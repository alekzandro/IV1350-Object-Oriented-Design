package se.kth.iv1350.PointOfSale.integration;

/**
 * Class DatabaseConnectionFailedException.
 * 
 */

public class DatabaseConnectionFailedException extends Exception {
		
/**
 * Creates a new instance of the exception <code>DatabaseConnectionFailedException</code>
 * @param message The message informing about the exception.
 */
	public DatabaseConnectionFailedException (String message) {
		super(message);
	}

}
