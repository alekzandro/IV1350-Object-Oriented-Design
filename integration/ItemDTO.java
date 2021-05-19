package se.kth.iv1350.PointOfSale.integration;

/**
 * Class ItemDTO containing details about item.
 * 
 */

public class ItemDTO {
	private final int itemID;
	private final String itemName;
	private final String itemDescription;
	private final double itemPrice;
	private final double itemVAT;
	
	/**
	 * Creates a new instance of <code>ItemDTO</code>
	 * @param itemID The identification number of the item.
	 * @param itemName The name of the item.
	 * @param itemDescription The description of the item.
	 * @param itemPrice The price of the item.
	 * @param itemVAT The VAT of the item.
	 */
	
	public ItemDTO(int itemID, String itemName, String itemDescription, double itemPrice, double itemVAT) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemVAT = itemVAT;		
		
	}
	
	/**
	 * Retrieves the item identification number.
	 * @return The item identification number.
	 */
	
	public int getItemID() {
		return itemID;
	}
	
	/**
	 * Retrieves the name of the item.
	 * @return The name of the item.
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Retrieves the description of the item.
	 * @return The description of the item.
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	/**
	 * Retrieves the price of the item.
	 * @return The price of the item.
	 */
	public double getItemPrice() {
		return itemPrice;
	}
	/**
	 * Retrieves the VAT of the item.
	 * @return The VAT of the item.
	 */
	public double getItemVAT() {
		return itemVAT;
	}

}
