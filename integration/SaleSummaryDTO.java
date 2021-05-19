package se.kth.iv1350.PointOfSale.integration;

import java.util.ArrayList;

import se.kth.iv1350.PointOfSale.model.LineItem;

/**
 * Class SaleSummaryDTO containing details about the <code>Sale</code>.
 * 
 */

public class SaleSummaryDTO {
	private final ArrayList<LineItem> items;
	private final double totalPrice;
	
	
	/**
	 * Creates a new instance of <code>SaleSummaryDTO</code>
	 * @param items The items of the corresponding <code>Sale</code>.
	 * @param totalPrice The total price of the corresponding <code>Sale</code>.
	 */
	public SaleSummaryDTO(ArrayList<LineItem> items, double totalPrice) {
		this.items = items;
		this.totalPrice = totalPrice;
	}
	
	/**
	 * Retrieves the items of the corresponding <code>Sale</code>.
	 * @return The items of the corresponding <code>Sale</code>.
	 */
	
	public ArrayList<LineItem> getItems(){
		return items;
	}
	
	/**
	 * Retrieves the total price of the corresponding <code>Sale</code>.
	 * @return The price of the corresponding <code>Sale</code>.
	 */
	
	public double getTotalPrice() {
		return totalPrice;
	}

}
