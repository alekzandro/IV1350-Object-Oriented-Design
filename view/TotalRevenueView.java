package se.kth.iv1350.PointOfSale.view;

import se.kth.iv1350.PointOfSale.model.Observer;

/**
 * 
 * Class <code>TotalRevenueView</code> 
 *
 */
public class TotalRevenueView implements Observer {
	private double totalRevenue = 0;
	
	
	/**
	 * Updates the total revenue.
	 * @param totalRevenue The total revenue.
	 */
	public void update(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	/**
	 * Retrieves the total revenue.
	 * @return The total revenue.
	 */
	
	public double getTotalRevenue() {
		return totalRevenue;
	}

}
