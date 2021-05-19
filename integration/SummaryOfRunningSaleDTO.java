package se.kth.iv1350.PointOfSale.integration;


/**
 * Class SummaryOfRunningSaleDTO containing details about the current running <code>Sale</code>.
 */

public class SummaryOfRunningSaleDTO {
	private final String descriptionOfLastAddedItem;
	private final double priceOfLastAddedItem;
	private final double totalPriceOfSale;
	
	/**
	 * Creates a new instance of class <code>SummaryOfRunningSaleDTO</code>
	 * @param descriptionOfLastAddedItem The description of the last added item.
	 * @param priceOfLastAddedItem The price of the last added item.
	 * @param totalPriceOfSale The total price of the <code>Sale</code>
	 * 
	 */
	
	
	public SummaryOfRunningSaleDTO(String descriptionOfLastAddedItem, double priceOfLastAddedItem, double totalPriceOfSale) {
		this.descriptionOfLastAddedItem = descriptionOfLastAddedItem;
		this.priceOfLastAddedItem = priceOfLastAddedItem;
		this.totalPriceOfSale = totalPriceOfSale;
		
	}
	
	/**
	 * Gets the description of the last added item.
	 * @return The description of the last added item
	 */
	
	public String getDescriptionOfLastAddedItem() {
		return descriptionOfLastAddedItem;
	}

	/**
	 * Gets price of the last added item.
	 * @return The price of the last added item.
	 */

	public double getPriceOfLastAddedItem() {
		return priceOfLastAddedItem;
	}

	/**
	 * Gets total price of corresponding <code>Sale</code>
	 * @return The total price of the corresponding <code>Sale</code>.
	 */

	public double getTotalPriceOfSale() {
		return totalPriceOfSale;
	}
	/**
	 * Gets text representation of the summary of the running <code>Sale</code>.
	 * @return The text representation of the summary of the running <code>Sale</code>.
	 */
	public String toString() {
		return "Item description: " + descriptionOfLastAddedItem + ". Item price: " + priceOfLastAddedItem + " kr. Total price of sale: " + totalPriceOfSale + " kr.";
	}


}
