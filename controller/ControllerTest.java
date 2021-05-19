package se.kth.iv1350.PointOfSale.controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.PointOfSale.integration.Accounting;
import se.kth.iv1350.PointOfSale.integration.AddressDTO;
import se.kth.iv1350.PointOfSale.integration.Inventory;
import se.kth.iv1350.PointOfSale.integration.ItemNotFoundException;
import se.kth.iv1350.PointOfSale.integration.Printer;
import se.kth.iv1350.PointOfSale.integration.SaleLog;
import se.kth.iv1350.PointOfSale.model.CashRegister;
import se.kth.iv1350.PointOfSale.model.OperationFailedException;
import se.kth.iv1350.PointOfSale.model.Store;
import se.kth.iv1350.PointOfSale.view.TotalRevenueView;
import se.kth.iv1350.PointOfSale.view.View;


public class ControllerTest {
	private static final String SAMPLE_STRING = "ABC";
	private static final int SAMPLE_NUMBER = 123;
	private Inventory inventory;
	private SaleLog saleLog;
	private Accounting accounting;
	private AddressDTO addressDTO;
	private Printer printer;
	private Store store;
	private CashRegister cashRegister;
	private TotalRevenueView totalRevenueView;
	private View view;
	private Controller controller;
	
	@BeforeAll
	public static void setUpClass() {
		
	}

	@AfterAll
	public static void cleanUpClass() {
		
	}

	@BeforeEach
	public void setUp() {
		inventory = new Inventory();
		saleLog = new SaleLog();
		accounting = new Accounting();
		printer = new Printer();
		addressDTO = new AddressDTO(SAMPLE_STRING, SAMPLE_STRING, SAMPLE_STRING, SAMPLE_NUMBER, SAMPLE_NUMBER);
		store = new Store(SAMPLE_STRING, addressDTO);
		cashRegister = new CashRegister(store);
		totalRevenueView = new TotalRevenueView();
		
		
	
	}

	@AfterEach
	public void cleanUp() {
		 inventory = null;
		 saleLog = null;
		 accounting = null;
		 addressDTO = null;
		 printer = null;
		store = null;
	     cashRegister = null;
		 totalRevenueView = null;
		 view = null;
		 controller = null;
		
			
		}
	
	@Test
	public void testOperationFailedException() throws IOException, ItemNotFoundException {
		OperationFailedException expectedException = new OperationFailedException("The operation failed. Please try again.");
		try {
			controller = new Controller(inventory, saleLog, accounting, cashRegister, printer, store, totalRevenueView);		
			view = new View(controller, totalRevenueView);	
			
		} catch(IOException ioException) {
			fail("Different exception was thrown.");
			
		} catch(ItemNotFoundException itemNotFoundException) {
			fail("Different exception was thrown.");
		}
		
		try {
			controller.scanItem(67);
		} catch(OperationFailedException exception) {
			assertEquals(expectedException.getMessage(), exception.getMessage());
			
		}
		
	}

	
	
}
