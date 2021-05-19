package se.kth.iv1350.PointOfSale.integration;

import java.time.LocalDateTime;
import java.util.ArrayList;

import se.kth.iv1350.PointOfSale.model.CashPayment;
import se.kth.iv1350.PointOfSale.model.LineItem;
import se.kth.iv1350.PointOfSale.model.Sale;
import se.kth.iv1350.PointOfSale.model.Store;

/**
 * Class ReceiptDTO containing details about the receipt.
 * 
 */
public class ReceiptDTO {
	private final LocalDateTime dateAndTimeOfPurchase;
	private final Store store;
	private final ArrayList<LineItem> allItems;
	private final double totalVAT;
	private final double totalPrice;
	private final double amountToPay;
	private final double amountPaid;
	
	/**
	 * Creates a new instance of <code>ReceiptDTO</code>
	 * @param dateAndTimeOfPurchase The date and time of the corresponding <code>Sale</code>
	 * @param store The store in which the sale takes place.
	 * @param sale The sale corresponding to the receipt.
	 * @param cashPayment The payment in cash paying for the sale.
	 */
	public ReceiptDTO(LocalDateTime dateAndTimeOfPurchase, Store store, Sale sale, CashPayment cashPayment) {
		this.dateAndTimeOfPurchase = dateAndTimeOfPurchase;
		this.store = store;
		this.allItems = sale.getAllItems();
		totalVAT = sale.getTotalVAT();
		totalPrice = sale.getTotalPrice();
		amountToPay = cashPayment.getAmountToPay();
		amountPaid = cashPayment.getAmountPaid();
	}
	
	/**
	 * Retrieves the date and time of the corresponding purchase.
	 * @return The date and time of purchase.
	 */
	public LocalDateTime getDateAndTimeOfPurchase() {
		return dateAndTimeOfPurchase;
	}

	/**
	 * Retrieves the store in which the corresponding <code>Sale</code> took place. 
	 * @return The store in which the corresponding <code>Sale</code> took place. 
	 */
	public Store getStore() {
		return store;
	}


	/**
	 * Retrieves the list of purchased items in the corresponding <code>Sale</code>.
	 * @return The list of purchased items in the corresponding <code>Sale</code>.
	 */
	public ArrayList<LineItem> getAllItems() {
		return allItems;
	}

	/**
	 * Retrieves the total VAT of the corresponding <code>Sale</code>.
	 * @return The total VAT of the corresponding <code>Sale</code>.
	 */

	public double getTotalVAT() {
		return totalVAT;
	}
/**
 * Retrieves the total price of the corresponding <code>Sale</code>.
 * @return The total price of the corresponding <code>Sale</code>.
 */

	public double getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * Retrieves the amount to pay for the corresponding <code>Sale</code>.
	 * @return The amount to pay for the corresponding <code>Sale</code>.
	 */
	
	public double getAmountToPay() {
		return amountToPay;
	}
	
	/**
	 * Retrieves the amount paid for the corresponding <code>Sale</code>.
	 * @return The amount paid for the corresponding <code>Sale</code>.
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	
	
	
	




}
