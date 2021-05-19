package se.kth.iv1350.PointOfSale.integration;

import java.util.ArrayList;
import java.util.Random;

import se.kth.iv1350.PointOfSale.model.Sale;
/**
 * Class SaleLog representing the logging of <code>Sale</code>s.
 *  *
 */
public class SaleLog {
	Random randomIntGenerator = new Random();
	ArrayList<Sale> saleLog = new ArrayList<>();
	
	/**
	 * Creates a new instance of <code>SaleLog</code>.
	 */
	public SaleLog() {
		
	}
	/**
	 * Creates a new <code>Sale</code> identification number.
	 * @return The created <code>Sale</code> identification number.
	 */
	
	public Sale newSale() {
		return new Sale(generateSaleID());	
	}
	
	/**
	 * Adds the <code>Sale</code> to the log list.
	 * @param sale The <code>Sale</code> to be added to the log list.
	 */
	public void logSale(Sale sale) {
		saleLog.add(sale);
	}
	
	private int generateSaleID() {
		return randomIntGenerator.nextInt(100);
	}

}
