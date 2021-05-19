package se.kth.iv1350.PointOfSale.model;

import se.kth.iv1350.PointOfSale.integration.ItemDTO;

/**
 * Class LineItem 
 */

public class LineItem {
	private int itemID;
	private int quantity;
	private double price;
	private double itemVAT;
	private String itemName;
	
	/**
	 * Creates a new instance of class <code>LineItem</code>
	 * @param itemDTO The corresponding <code>ItemDTO</code>   
	 */
	
	public LineItem(ItemDTO itemDTO) {
		this.itemID = itemDTO.getItemID();	
		this.quantity = 1;
		price = itemDTO.getItemPrice();
		itemName = itemDTO.getItemName();
		itemVAT = itemDTO.getItemVAT();
	
	}
	
	/**
	 * Gets the identification number of the item.
	 * @return The identification number of the item.
	 */
	public int getItemID() {
		return itemID;
	}
	/**
	 * Gets the VAT of the item.
	 * @return The VAT of the item.
	 */
	
	public double getVAT() {
		return itemVAT;
	}
	
	/**
	 * Sets the identification number of the item.
	 * @param itemID The identification number of the item..
	 */

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * Gets the quantity of the item.
	 * @return The quantity of the item.
	 */

	public int getQuantity() {
		return quantity;
	}
	/**
	 * Sets the quantity for the item in question.
	 * @param quantity The quantity of the item in question.
	 */

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
	/**
	 * Gets the price of the item.
	 * @return The price of the item.
	 */
	
	public double getPrice() {
		return price;
	}
	/**
	 * Increases the quantity of the <code>LineItem</code> instance in question by one.
	 */
	public void increaseQuantity() {
		quantity++;
	}
}
