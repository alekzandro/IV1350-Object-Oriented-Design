package se.kth.iv1350.PointOfSale.model;
/**
 * Class OperationFailedException
 *
 */
public class OperationFailedException extends Exception {
	
	/**
	 * Creates a new instance of <code>OperationFailedException</code>
	 * @param message The message containing information about the exception.
	 */
	public OperationFailedException (String message) {
		super(message);
	}

}
