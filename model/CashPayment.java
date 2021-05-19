package se.kth.iv1350.PointOfSale.model;


/**
 * Class CashPayment
 */

public class CashPayment {
	private double amountToPay;
	private double amountPaid;
	private Sale sale;
	
	/**
	 * Creates a new instance of class <code>CashPayment</code> 
	 * @param amountPaid The amount that has been paid by the customer.
	 * @param sale The <code>Sale</code> to be paid for.
	 * 
	 */
	
	public CashPayment(double amountPaid, Sale sale) {
		amountToPay = sale.getTotalPriceIncludingVAT();
		this.amountPaid = amountPaid;
		this.sale = sale;
		
	}
	/**
	 * Gets the amount to be paid.
	 * @return The amount to be paid.
	 */
	public double getAmountToPay() {
		return amountToPay;
	}
	
	/**
	 * Gets the amount that has been paid.
	 * @return The paid amount.
	 */
	public double getAmountPaid() {
		return amountPaid;
	}
	/**
	 * Calculates change to give.
	 * @return The resulting change to give to customer.
	 */
	public double calculateChangeToGive() {
		return amountPaid - amountToPay;
	}
}
