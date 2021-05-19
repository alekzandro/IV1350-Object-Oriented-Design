package se.kth.iv1350.PointOfSale.model;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.PointOfSale.integration.ItemDTO;
import se.kth.iv1350.PointOfSale.integration.SummaryOfRunningSaleDTO;


public class SaleTest {
	private Sale saleToTest;
	private ItemDTO sampleItemDTO1;
	private ItemDTO sampleItemDTO2;
	private ItemDTO sampleItemDTO3;
	private ItemDTO sampleItemDTO4;
	private ItemDTO sampleItemDTO5;
	private ItemDTO sampleItemDTO6;
	private static final int SAMPLE_ID = 123;
	




@BeforeAll
public static void setUpClass() {
	
}

@AfterAll
public static void cleanUpClass() {
	
}

@BeforeEach
public void setUp() {
	saleToTest = new Sale(123);
	sampleItemDTO1 = new ItemDTO(5, "A", "A", 5, 5);
	sampleItemDTO2 = new ItemDTO(6, "B", "B", 6, 6);
	sampleItemDTO3 = new ItemDTO(7, "C", "C", 7, 7);
	sampleItemDTO4 = new ItemDTO(8, "D", "D", 8, 8);
	sampleItemDTO5 = new ItemDTO(9, "E", "E", 9, 9);
	sampleItemDTO6 = new ItemDTO(55, "E", "E", 9, 9);
	saleToTest = new Sale(SAMPLE_ID);
}

@AfterEach
public void cleanUp() {
	saleToTest = null;
	sampleItemDTO1 = null;
	sampleItemDTO2 = null;
	sampleItemDTO3 = null;
	sampleItemDTO4 = null;
	sampleItemDTO5 = null;
	}

@Test
public void testItemQuantityWhenScanningSameItemSeveralTimesInARow() {
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	assertEquals("Incorrect quantity", saleToTest.items.get(2).getQuantity(), 3);

}

@Test
public void testItemQuantityWhenScanningSameItemSeveralTimesButNotInARow() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO2);
	saleToTest.addItem(sampleItemDTO4);
	saleToTest.addItem(sampleItemDTO1);
	
	assertEquals("Incorrect quantity", saleToTest.items.get(0).getQuantity(), 4);
}


@Test 
public void testItemPrice() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	SummaryOfRunningSaleDTO summary = saleToTest.getSummaryOfRunningSale(sampleItemDTO1);	
	assertEquals(5, summary.getPriceOfLastAddedItem(), 0);
		
}

@Test
public void testItemDescription() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	SummaryOfRunningSaleDTO summary = saleToTest.getSummaryOfRunningSale(sampleItemDTO1);	
	assertEquals("Incorrect item description", summary.getDescriptionOfLastAddedItem(), "A");
		
}
@Test
public void testRunningTotal() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	SummaryOfRunningSaleDTO summary = saleToTest.getSummaryOfRunningSale(sampleItemDTO1);	
	assertEquals(52, summary.getTotalPriceOfSale(), 0);
		
}




@Test
public void testTotalPrice() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO2);
	saleToTest.addItem(sampleItemDTO4);
	saleToTest.addItem(sampleItemDTO1);
	int price = (int) saleToTest.getTotalPrice();
	assertEquals("Incorrect total price", 50, price);
		
}
@Test
public void testTotalPriceIncludingVAT() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO2);
	saleToTest.addItem(sampleItemDTO4);
	saleToTest.addItem(sampleItemDTO1);
	int price = (int) saleToTest.getTotalPriceIncludingVAT();
	assertEquals("Incorrect total price", 100, price);
		
}

@Test
public void testApplyDiscount() {
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO5);
	saleToTest.addItem(sampleItemDTO3);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.addItem(sampleItemDTO2);
	saleToTest.addItem(sampleItemDTO4);
	saleToTest.addItem(sampleItemDTO1);
	saleToTest.applyDiscount(0.3);
	int price = (int) saleToTest.getTotalPriceIncludingVAT();
	assertEquals("Incorrect total price", 85, price);
		
}


}

