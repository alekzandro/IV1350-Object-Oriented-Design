package se.kth.iv1350.PointOfSale.model;

import java.util.ArrayList;

/**
 * Class CashRegister
 */


public class CashRegister {
	private double amountPresent;
	private Store store;
	private ArrayList<CashPayment> cashPayments = new ArrayList<CashPayment>();
	
	/**
	 * Creates a new instance of class <code>CashRegister</code>. 
	 * @param store The <code>Store</code> in which the <code>CashRegister</code> resides.
	 * 
	 */
	
	public CashRegister(Store store) {
		this.store = store;
	}
	/**
	 * Adds payment to instance of <code>CashRegister</code> 
	 * @param cashPayment The payment in cash.
	 */
	
	public void addCashPayment(CashPayment cashPayment) {
		cashPayments.add(cashPayment);
		updateAmountPresent(cashPayment.getAmountToPay());
	}
	
	/**
	 * Gets amount present in cash register.
	 * @return The amount present in the cash register.
	 */
	public double getAmountPresent() {
		return amountPresent;
	}
	
	private void updateAmountPresent(double amount) {
		amountPresent += amount;
	}

}
