package se.kth.iv1350.PointOfSale.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.PointOfSale.integration.ItemDTO;
import se.kth.iv1350.PointOfSale.integration.SaleSummaryDTO;
import se.kth.iv1350.PointOfSale.integration.SummaryOfRunningSaleDTO;


/**
 * Class Sale 
 */
public class Sale {
	private static final int ITEM_NOT_IN_LIST = -1;
	private int saleID;
	private CashPayment cashPayment;
	private double totalPrice = 0;
	private double totalVAT =0;
	private LocalDateTime dateAndTimeOfSale;
	ArrayList<LineItem> items = new ArrayList<>();
	
	/**
	 * Creates a new instance of class <code>Sale</code>
	 * @param saleID The identification number of the <code>Sale</code> instance.
	 * 
	 *  
	 */
	public Sale(int saleID) {
		this.saleID = saleID;
		dateAndTimeOfSale = LocalDateTime.now();
	}
	
	/**
	 * Adds scanned item to the current <code>Sale</code>.
	 * 
	 * @param itemDTO The scanned item.
	 */
	
	
	public void addItem(ItemDTO itemDTO) {
		int indexOfItemInList = indexOfItemInList(itemDTO);
		if(indexOfItemInList == ITEM_NOT_IN_LIST) {
			LineItem lineItem = new LineItem(itemDTO);
			items.add(lineItem);
			updateTotalPrice(lineItem);
			updateTotalVAT(lineItem);
		} else {
			LineItem lineItem = items.get(indexOfItemInList);
			lineItem.increaseQuantity();
			updateTotalPrice(lineItem);
			updateTotalVAT(lineItem);
		}
	}
	
	/**
	 * Adds the scanned item to the current <code>Sale</code>, with the specified quantity.
	 * 
	 * @param itemDTO The scanned item in question.
	 * @param quantity The quantity of the item.
	 */
	public void addItemManualQuantity(ItemDTO itemDTO, int quantity) {
		LineItem lineItem = new LineItem(itemDTO);
		lineItem.setQuantity(quantity);
		items.add(lineItem);
		updateTotalPrice(lineItem);
		updateTotalVAT(lineItem);
	}
	
	/**
	 * Gets the summary of the running <code>Sale</code>.
	 * 
	 * @param itemDTO The scanned item in question.
	 * @return The summary of the running <code>Sale</code>.
	 */
	
	public SummaryOfRunningSaleDTO getSummaryOfRunningSale(ItemDTO itemDTO) {
		SummaryOfRunningSaleDTO summaryOfRunningSaleDTO = new SummaryOfRunningSaleDTO(itemDTO.getItemDescription(), itemDTO.getItemPrice(), totalPrice + totalVAT );
		return summaryOfRunningSaleDTO;
	}	
	
	
	/**
	 * Gets the total price of the <code>Sale</code>.
	 * @return The total price of the <code>Sale</code>.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * Gets the total price including the VAT of the <code>Sale</code>.
	 * @return The total price, including the total VAT, of the <code>Sale</code>.
	 */
	
	public double getTotalPriceIncludingVAT() {
		return totalPrice + totalVAT;
	}
	
	/**
	 * Gets the total VAT of the <code>Sale</code>.
	 * 
	 * 
	 * @return The total VAT of the <code>Sale</code>.
	 */
	
	public double getTotalVAT() {
		return totalVAT;
	}
	/**
	 * Gets the date and time of the <code>Sale</code>.
	 * 
	 * @return The date and time of the <code>Sale</code>.
	 */
	
	public LocalDateTime getDateAndTimeOfSale() {
		return dateAndTimeOfSale;
	}
	
	/**
	 * Gets the list of all items of the <code>Sale</code>.
	 * 
	 * 
	 * @return The list of items.
	 */
	
	public ArrayList<LineItem> getAllItems(){
		return items;
	}
	
	/**
	 * Registers the <code>CashPayment</code> of the <code>Sale</code>.
	 * 
	 * 
	 * @param The <code>CashPayment</code> of the <code>Sale</code>.
	 */
	
	public void pay(CashPayment cashPayment) {
		this.cashPayment = cashPayment;
	}
	
	/**
	 * Gets the summary of the <code>Sale</code>.
	 * 
	 * 
	 * @return The summary of the <code>Sale</code>.
	 */
	public SaleSummaryDTO getSaleSummaryDTO() {
		return new SaleSummaryDTO(items, totalPrice);
	}
	
	/**
	 * Applies the discount to the total price of the <code>Sale</code>.
	 * 
	 * 
	 * @param discount The discount to be applied to the total price.
	 */
	public void applyDiscount(double discount) {
		totalPrice *= (1-discount);
	}
	
	private void updateTotalPrice(LineItem lineItem) {
		for(int i = 0; i < lineItem.getQuantity(); i++) {
			totalPrice += lineItem.getPrice();
		}
		
	}
	
	private void updateTotalVAT(LineItem lineItem) {
		for(int i = 0; i < lineItem.getQuantity(); i++) {
			totalPrice += lineItem.getVAT();
		}
	}
	
	private int indexOfItemInList(ItemDTO itemDTO) {
		int itemID = itemDTO.getItemID();
		for(int i = 0; i < items.size() ; i++) {
			if(items.get(i).getItemID() == itemID) {
				return i;
			}
		}
		return ITEM_NOT_IN_LIST;
	}
}
