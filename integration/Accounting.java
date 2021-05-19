package se.kth.iv1350.PointOfSale.integration;

import java.util.ArrayList;

import se.kth.iv1350.PointOfSale.model.Observer;
import se.kth.iv1350.PointOfSale.model.Sale;
import se.kth.iv1350.PointOfSale.model.Subject;
/**
 * Class Accounting.
 */

public class Accounting implements Subject {
	private ArrayList<Sale> sales = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();
	
	/**
	 * Creates a new instance of <code>Accounting</code>, representing the connection to the accounting system.
	 */
	
	public Accounting () {
		
	}
	
	/**
	 * Adds the sale to the accounting list of sales.
	 * @param sale The sale to be added  to the list of sales.
	 */
	
	public void addSale(Sale sale) {
		sales.add(sale);
		notifyObservers();
	}
	
	/**
	 * Attaches an observer to the accounting object.
	 * @param observer The observer to be attached.
	 */
	
	public void attachObserver(Observer observer){
		observers.add(observer);
	}
	
	/**
	 * Detaches an observer from the accounting object.
	 * @param observer The observer to be detached.
	 */
	
	public void detachObserver(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 *Notifies the observers attached to the accounting object.
	 * 
	 */
	
	public void notifyObservers() {
		double totalRevenue = getTotalRevenue();
		for(Observer observer : observers) {
			observer.update(totalRevenue);
		}
	}
	
	private double getTotalRevenue() {
		double revenue = 0;
		for(Sale sale : sales) {
			revenue += sale.getTotalPrice();
		}
		return revenue;
	}

}
