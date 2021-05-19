package se.kth.iv1350.PointOfSale.model;

import se.kth.iv1350.PointOfSale.integration.SaleSummaryDTO;

/**
 * Class DiscountCalculator 
 */

public class DiscountCalculator {
	private int customerID;
	private SaleSummaryDTO saleSummaryDTO;
	
	/**
	 * Creates a new instance of class <code>DiscountCalculator</code>. 
	 * @param customerID The identification number of the customer.
	 * @param saleSummaryDTO The summary of the <code>Sale</code>.  
	 */
	public DiscountCalculator(int customerID, SaleSummaryDTO saleSummaryDTO) {
		this.customerID = customerID;
		this.saleSummaryDTO = saleSummaryDTO;
		
	}
	
	/**
	 * Calculates the discount for the total price of the <code>Sale</code>. 
	 * @return The resulting discount for the total price.
	 */
	public double calculateDiscount() {
		double discount = 0.3;
		return discount;
	}

}
