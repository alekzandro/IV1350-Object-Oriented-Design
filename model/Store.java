package se.kth.iv1350.PointOfSale.model;

import se.kth.iv1350.PointOfSale.integration.AddressDTO;

/**
 *  
 * Class Store.
 *  
 */
public class Store {
	private String name;
	private AddressDTO addressDTO;
	
	/**
	 * Creates a new instance of class <code>Store</code>.
	 * @param name The name of the <code>Store</code>.
	 * @param addressDTO The address of the <code>Store</code>.
	 *  
	 */
	
	public Store(String name, AddressDTO addressDTO) {
		this.name = name;
		this.addressDTO = addressDTO;
	}
	
	/**
	 * Retrieves the name of the <code>Store</code>.
	 * 
	 * @return The name of the <code>Store</code>.
	 *  
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Retrieves the address of the <code>Store</code>.
	 * 
	 * @return The address of the <code>Store</code>.
	 *  
	 */

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

}
