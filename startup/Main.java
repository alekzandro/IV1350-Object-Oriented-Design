package se.kth.iv1350.PointOfSale.startup;

import java.io.IOException;

import se.kth.iv1350.PointOfSale.controller.Controller;
import se.kth.iv1350.PointOfSale.integration.Accounting;
import se.kth.iv1350.PointOfSale.integration.AddressDTO;
import se.kth.iv1350.PointOfSale.integration.Inventory;
import se.kth.iv1350.PointOfSale.integration.ItemNotFoundException;
import se.kth.iv1350.PointOfSale.integration.Printer;
import se.kth.iv1350.PointOfSale.integration.SaleLog;
import se.kth.iv1350.PointOfSale.model.CashRegister;
import se.kth.iv1350.PointOfSale.model.Store;
import se.kth.iv1350.PointOfSale.view.TotalRevenueView;
import se.kth.iv1350.PointOfSale.view.View;

public class Main {
	private static final String SAMPLE_STRING = "ABC";
	private static final int SAMPLE_NUMBER = 123;
	
	
	public static void main(String args[]) throws ItemNotFoundException, IOException {
		Inventory inventory = new Inventory();
		SaleLog saleLog = new SaleLog();
		Accounting accounting = new Accounting();
		Printer printer = new Printer();
		AddressDTO addressDTO = new AddressDTO(SAMPLE_STRING, SAMPLE_STRING, SAMPLE_STRING, SAMPLE_NUMBER, SAMPLE_NUMBER);
		Store store = new Store(SAMPLE_STRING, addressDTO);
		CashRegister cashRegister = new CashRegister(store);
		TotalRevenueView totalRevenueView = new TotalRevenueView();
		Controller controller = new Controller(inventory, saleLog, accounting, cashRegister, printer, store, totalRevenueView);		
		View view = new View(controller, totalRevenueView);	
	}
}
