package se.kth.iv1350.PointOfSale.view;

import java.io.IOException;
import se.kth.iv1350.PointOfSale.controller.Controller;
import se.kth.iv1350.PointOfSale.integration.ItemNotFoundException;
import se.kth.iv1350.PointOfSale.model.OperationFailedException;

/**
 * 
 * Class <code>View</code>. 
 *
 */
public class View {
	private Controller controller;
	private TotalRevenueView totalRevenueView;
	private ErrorMessageUserHandler errorMessageUser = new ErrorMessageUserHandler();
	
	/**
	 * Creates a new instance of the Class <code>View</code>.
	 * @param controller The <code>Controller</code> to be passed to the <code>View</code>.
	 * @param totalRevenueView The <code>TotalRevenueView</code> to be passed to the <code>View</code>.
	 * @throws ItemNotFoundException If the scanned item identification number cannot be found.
	 * @throws IOException If creation of log files fail.
	 */
	public View(Controller controller, TotalRevenueView totalRevenueView) throws ItemNotFoundException, IOException {
		this.controller = controller;
		this.totalRevenueView = totalRevenueView;
		sampleExecution();
	}
	
	/**
	 * Only used for demonstrative sample execution.
	 */
	public void sampleExecution() {
		try {
			controller.fillInventorySampleExecution();
			controller.newSale();
			System.out.println("A customer arrives at the POS and a new sale starts.");
			System.out.println("");
			System.out.println("Scanning one item with barcode 5");
			System.out.println("");
			System.out.println(controller.scanItem(5));
			System.out.println("");
			System.out.println("Scanning one item with barcode 6");
			System.out.println("");
			System.out.println(controller.scanItem(6));
			System.out.println("");
			System.out.println("Scanning one item with barcode 7 and entering manual quantity 3");
			System.out.println("");
			System.out.println(controller.scanItemManualQuantity(7, 3));
			System.out.println("");
			System.out.println("Scanning one item with barcode 5");
			System.out.println("");
			System.out.println(controller.scanItem(7));
			System.out.println("");
			System.out.println("No more items on belt, sale ends.");
			System.out.println("");
			System.out.println("Amount to pay: " + controller.endSale() + " kr.");
			System.out.println("");
			System.out.println("Customer says they're eligible for a discount. Cashier enters customer's ID.");
			System.out.println("");
			System.out.println("Customer receives 30% discount.");
			System.out.println("");
			System.out.println("Amount to pay: " + controller.applyDiscount(123) + " kr.");
			System.out.println("");
			System.out.println("Customer pays 250 kr in cash.");
			System.out.println("");
			System.out.println("Change to give customer: " + controller.payAmount(250) + " kr.");
			System.out.println("");
			System.out.println("Receipt is printed and sale is finished.");
			System.out.println("");
			System.out.println("The total revenue since the system started so far is: " + totalRevenueView.getTotalRevenue() + " kr.");
			
		} catch (ItemNotFoundException itemNotFoundException) {
			errorMessageUser.showErrorMessage("Item with item ID "+ itemNotFoundException.getMessage() + " could not be found.");
		}
		 catch (OperationFailedException exception) {
			writeToUI("The operation failed. Please try again.");
		}	
	}
	
	private void writeToUI(String message) {
		errorMessageUser.showErrorMessage(message);
	}
}
