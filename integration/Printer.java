package se.kth.iv1350.PointOfSale.integration;

/**
 * Class Printer representing the connection to the printer.
 * 
 */
public class Printer {
	private ReceiptDTO receiptDTO;
	
	/**
	 * Creates a new instance of <code>Printer</code>
	 */
	public Printer() {
		
	}
	/**
	 * Prints the receipt.
	 * @param receiptDTO The receipt to be printed.
	 */
	
	public void printReceipt(ReceiptDTO receiptDTO){
		this.receiptDTO = receiptDTO;
		
		
	}
	
	/**
	 * Retrieves the receipt.
	 * @return The receipt.
	 */
	
	public ReceiptDTO getReceipt() {
		return receiptDTO;
	}
	
	
}
