package se.kth.iv1350.PointOfSale.model;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.PointOfSale.integration.ItemDTO;

public class CashRegisterTest {
	private static CashRegister cashRegister;
	private static CashPayment cashPayment;
	private static Sale sale;
	private static final double AMOUNT_PAID = 150;
	private static final int SALE_ID = 123;
	private ItemDTO sampleItemDTO1;
	private ItemDTO sampleItemDTO2;
	private Store store;

	
	@BeforeAll
	public static void setUpClass() {
		
	}

	@AfterAll
	public static void cleanUpClass() {
		
	}

	@BeforeEach
	public void setUp() {
		sale = new Sale(SALE_ID);
		sampleItemDTO1 = new ItemDTO(5, "A", "A", 13, 13);
		sampleItemDTO2 = new ItemDTO(6, "B", "B", 17, 17);
		sale.addItem(sampleItemDTO1);
		sale.addItem(sampleItemDTO2);
	}

	@AfterEach
	public void cleanUp() {
		sale = null;
		cashPayment = null;
		sampleItemDTO1 = null;
		sampleItemDTO2 = null;		
		}
	
	public void testAmountPresent() {
		sale = new Sale(123);
		sale.addItem(sampleItemDTO1);
		sale.addItem(sampleItemDTO2);
		cashPayment = new CashPayment(44, sale);
		cashRegister = new CashRegister(store);
		cashRegister.addCashPayment(cashPayment);
		assertEquals(60, cashRegister.getAmountPresent(), 0);
	}
}
