package se.kth.iv1350.PointOfSale.integration;

/**
 * Class AddressDTO holding address details.
 */

public class AddressDTO {
	private final String streetName;
	private final String city;
	private final String country;
	private final int streetNumber;
	private final int zipcode;
	
	/**
	 * Creates a new instance of class <code>AddressDTO</code>
	 * @param streetName The street name of the location.
	 * @param city The city of the location.
	 * @param country The country of the location.
	 * @param streetNumber The street number of the location.
	 * @param zipCode The zip code of the location.
	 */
	
	public AddressDTO(String streetName, String city, String country, int streetNumber, int zipCode) {
		this.streetName = streetName;
		this.city = city;
		this.country = country;
		this.streetNumber = streetNumber;
		this.zipcode = zipCode;
	}
	
	/**
	 * Returns the street name.
	 * @return the street name.
	 */
	public String getStreetName() {
		return streetName;
	}
	
	/**
	 * Returns the name of the city.
	 * @return the name of the city.
	 */

	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the name of the country.
	 * @return the name of the country.
	 */


	public String getCountry() {
		return country;
	}
	
	/**
	 * Returns the street number.
	 * @return the street number.
	 */

	public int getStreetNumber() {
		return streetNumber;
	}
	
	/**
	 * Returns the zip code.
	 * @return the zip code.
	 */

	public int getZipcode() {
		return zipcode;
	}

}
