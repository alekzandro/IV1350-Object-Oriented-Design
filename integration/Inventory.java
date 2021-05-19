package se.kth.iv1350.PointOfSale.integration;

import java.util.ArrayList;

import se.kth.iv1350.PointOfSale.model.Sale;

/**
 * Class Inventory
 *
 */

public class Inventory {
	private ArrayList<ItemDTO> allItems = new ArrayList<ItemDTO>();
	private static int CONNECTION_FAILED = 67;
	
	/**
	 * Creates a new instance of <code>Inventory</code>
	 */
	public Inventory() {
		
	}
	
	/**
	 * Retrieves item from inventory list.
	 * @param itemID The identification number of the searched item.
	 * @return The <code>ItemDTO</code> with details about the corresponding items.
	 * @throws ItemNotFoundException If the item identification number cannot be found in the inventory list. 
	 * @throws DatabaseConnectionFailedException If the connection to the inventory fails. 
	 */
	
	public ItemDTO getItem(int itemID) throws ItemNotFoundException, DatabaseConnectionFailedException {
		for(ItemDTO itemDTO : allItems) {
			if(itemID == CONNECTION_FAILED) {
				throw new DatabaseConnectionFailedException("Connection to inventory failed.");
			}
			if(itemDTO.getItemID() == itemID) {
				return itemDTO; 
			}
		}
		throw new ItemNotFoundException(Integer.toString(itemID));
	}
	
	/**
	 * Updates the inventory list with sold items.
	 * @param currentSale The sale with the sold items.
	 */
	
	public void updateInventory(Sale currentSale) {
		
	}
	
	/**
	 * Fills the inventory with sample <code>ItemDTO</code>s for sample execution.
	 */
	
	public void fillInventorySampleExecution() {
		ItemDTO sampleItemDTO1 = new ItemDTO(5, "Salt", "Salty salt", 12, 5);
		ItemDTO sampleItemDTO2 = new ItemDTO(6, "Mango", "Sweet mango", 7, 4);
		ItemDTO sampleItemDTO3 = new ItemDTO(7, "Egg", "A nice egg", 16, 9);
		ItemDTO sampleItemDTO4 = new ItemDTO(8, "Juice", "Juicy juice!", 11, 4);
		ItemDTO sampleItemDTO5 = new ItemDTO(9, "Milk", "The best milk, from Arla.", 7, 2);
		allItems.add(sampleItemDTO1);
		allItems.add(sampleItemDTO2);
		allItems.add(sampleItemDTO3);		
		allItems.add(sampleItemDTO4);
		allItems.add(sampleItemDTO5);	
	}

}
