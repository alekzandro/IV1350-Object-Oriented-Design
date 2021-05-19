package se.kth.iv1350.PointOfSale.integration;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class InventoryTest {
	Inventory inventory;
	private static final int INVALID_ITEM_ID = 55;
	private static final int CONNECTION_FAILED = 67;
	
	@BeforeAll
	public static void setUpClass() {
		
	}

	@AfterAll
	public static void cleanUpClass() {
		
	}

	@BeforeEach
	public void setUp() {
		System.out.println("HELLO");
		inventory = new Inventory();
		inventory.fillInventorySampleExecution();
	
	}

	@AfterEach
	public void cleanUp() {
		inventory = null;
			
		}

	@Test
	public void testItemNotFoundException(){
		Exception expectedException = new ItemNotFoundException("55"); 
		try {
			inventory.getItem(INVALID_ITEM_ID);
			fail("Could find non-existing item.");
		} catch (Exception exception) {
			assertEquals(expectedException.getMessage(), exception.getMessage());
		}
		
	}
	
	@Test
	public void testDatabaseConnectionFailedException(){
		Exception expectedException = new DatabaseConnectionFailedException("Connection to inventory failed."); 
		try {
			inventory.getItem(CONNECTION_FAILED);
			fail("Could connect when it should not be possible.");
		} catch (Exception exception) {
			assertEquals(expectedException.getMessage(), exception.getMessage());
		}
		
	}
}
