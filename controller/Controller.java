package se.kth.iv1350.PointOfSale.controller;

import java.io.IOException;

import se.kth.iv1350.PointOfSale.integration.*;
import se.kth.iv1350.PointOfSale.model.*;
import se.kth.iv1350.PointOfSale.util.LogHandler;
import se.kth.iv1350.PointOfSale.view.TotalRevenueView;

/**
 * Class controller.
 */  

public class Controller {
	private Inventory inventory; 
	private SaleLog saleLog; 
	private Accounting accounting;
	private CashRegister cashRegister;
	private Printer printer;
	private Sale currentSale;
	private DiscountCalculator discountCalculator;
	private Store store;
	private CashPayment cashPayment;
	private LogHandler logger;
	
	
	/**
	 * Creates a new instance of <code>Controller</code>, representing the controller of the system. This is the system's only controller.
	 * 
	 * @param inventory Representing the connection to the inventory system.
	 * @param saleLog Representing the connection to the sale log system.
	 * @param accounting Representing the connection to the accounting system.
	 * @param cashRegister Representing the state of the cash register, such as cash present.
	 * @param printer Representing the connection to the receipt printer.
	 * @param store The store of the point of sale.
	 * @param totalRevenueView The object which displays current total revenue of the day.
	 * @throws IOException When the creation of the error log file fails.
	 */
	
	public Controller(Inventory inventory, SaleLog saleLog, Accounting accounting, CashRegister cashRegister, Printer printer, Store store, TotalRevenueView totalRevenueView) throws IOException {
		this.inventory = inventory;
		this.saleLog = saleLog;
		this.accounting = accounting;
		this.cashRegister = cashRegister;
		this.printer = printer;
		this.store = store;
		try {
			logger = new LogHandler();
			TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();
			accounting.attachObserver(totalRevenueView);
			accounting.attachObserver(totalRevenueFileOutput);
		} catch(IOException ioException) {
			System.out.println("Could not create log file.");
		}
	}


	/**
	 * Starts new sale.
	 */

	public void newSale() {
		currentSale = saleLog.newSale();
	}
	
	/**
	 * Scans the item to be purchased.
	 * 
	 * @param itemID The identification number of the item.
	 * @return SummaryOfRunningSaleDTO The summary of the running sale.
	 * @throws ItemNotFoundException If the item identification number is not found.
	 * @throws OperationFailedException If the operation, due to some reason, could not be successfully completed.
	 */
	
	public SummaryOfRunningSaleDTO scanItem(int itemID) throws ItemNotFoundException, OperationFailedException {
		try {
			ItemDTO itemDTO = getItemDTOFromInventory(itemID);
			addItemToSale(itemDTO);
			return currentSale.getSummaryOfRunningSale(itemDTO);
		} catch (DatabaseConnectionFailedException databaseConnectionFailedException ) {
			writeToLog(databaseConnectionFailedException);
			throw new OperationFailedException("The operation failed. Please try again.");
		}		
	}
	
	/**
	 * Scans the item to be purchased together with manually entered quantity.
	 * 
	 * @param itemID The identification number of the item.
	 * @param quantity The number of items of the particular item.
	 * @return SummaryOfRunningSaleDTO The summary of the running sale.
	 * @throws ItemNotFoundException If the item identification number is not found.
	 * @throws OperationFailedException If the operation, due to some reason, could not be successfully completed.
	 *  
	 */
	
	public SummaryOfRunningSaleDTO scanItemManualQuantity(int itemID, int quantity) throws ItemNotFoundException, OperationFailedException {
		try {
			
			ItemDTO itemDTO = getItemDTOFromInventory(itemID);
			addItemToSaleManualQuantity(itemDTO, quantity);
			return currentSale.getSummaryOfRunningSale(itemDTO);
		} catch (DatabaseConnectionFailedException databaseConnectionFailedException ) {
			writeToLog(databaseConnectionFailedException);
			throw new OperationFailedException("The operation failed. Please try again.");
		}				
	}
		
	/**
	 * Ends the sale.
	 * @return totalPriceIncludingVAT The total price of the sale, including VAT.
	 */
	
	public double endSale() {
		return currentSale.getTotalPriceIncludingVAT();
		
	}
	
	/**
	 * Registers the amount paid by the customer.
	 * 
	 * @param paidAmount The amount paid by the customer.
	 * @return changeToGive The change to be given to the customer.
	 */
	
	public double payAmount(double paidAmount) {
		cashPayment = new CashPayment(paidAmount, currentSale);
		cashRegister.addCashPayment(cashPayment);
		currentSale.pay(cashPayment);
		printReceipt();
		addSaleToSaleLog();
		addSaleToAccounting();
		updateInventory();
		return cashPayment.calculateChangeToGive();
		
	}
	
	/**
	 * Applies discount to total price of sale if customer is eligible.
	 * 
	 * @param customerID The identification number of the customer.
	 * @return totalPrice The new total price of sale after the discount has been applied.
	 */
	
	public double applyDiscount(int customerID) {
		discountCalculator = new DiscountCalculator(customerID, currentSale.getSaleSummaryDTO());
		currentSale.applyDiscount(discountCalculator.calculateDiscount());
		return currentSale.getTotalPrice();
	}
	
	/**
	 * Fills the inventory with sample items. Only here for sample execution.
	 */
	
	public void fillInventorySampleExecution() {
		inventory.fillInventorySampleExecution();
	}
	
	private void writeToLog(Exception exception) {
		logger.logException(exception);
	}
	
	private void addItemToSale(ItemDTO itemDTO)  {
		currentSale.addItem(itemDTO);
	}
	
	private void addItemToSaleManualQuantity(ItemDTO itemDTO, int quantity) {
		currentSale.addItemManualQuantity(itemDTO, quantity);
	}
	
	private ItemDTO getItemDTOFromInventory(int itemID) throws ItemNotFoundException, DatabaseConnectionFailedException {
				return inventory.getItem(itemID);
	}
	
	private void printReceipt() {
		ReceiptDTO receiptDTO = new ReceiptDTO(currentSale.getDateAndTimeOfSale(), store, currentSale, cashPayment);
		printer.printReceipt(receiptDTO);
	}
	
	private void addSaleToSaleLog() {
		saleLog.logSale(currentSale);
	}
	
	private void addSaleToAccounting() {
		accounting.addSale(currentSale);
	}
	
	private void updateInventory() {
		inventory.updateInventory(currentSale);
	}

}


