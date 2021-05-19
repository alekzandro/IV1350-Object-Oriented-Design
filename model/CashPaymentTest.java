package se.kth.iv1350.PointOfSale.model;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.PointOfSale.integration.ItemDTO;



public class CashPaymentTest {
	private static CashPayment cashPayment;
	private static Sale sale;
	private static final double AMOUNT_PAID = 150;
	private static final int SALE_ID = 123;
	private ItemDTO sampleItemDTO1;
	private ItemDTO sampleItemDTO2;
	
	
	
	@BeforeAll
	public static void setUpClass() {
		
	}

	@AfterAll
	public static void cleanUpClass() {
		
	}

	@BeforeEach
	public void setUp() {
		sale = new Sale(SALE_ID);
		sampleItemDTO1 = new ItemDTO(5, "A", "A", 5, 5);
		sampleItemDTO2 = new ItemDTO(6, "B", "B", 6, 6);
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
	
	@Test
	public void testChangeToGive() {
		cashPayment = new CashPayment(AMOUNT_PAID, sale);
		assertEquals(128, cashPayment.calculateChangeToGive(), 0);
		
	}


}
