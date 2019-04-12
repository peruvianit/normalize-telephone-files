/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerFactoryException extends Exception {
	private static final long serialVersionUID = 2677270233049746402L;

	protected TelephoneManagerFactoryException() {
	}

	public TelephoneManagerFactoryException(String message) {
		super(message);
	}

	public TelephoneManagerFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public TelephoneManagerFactoryException(Throwable cause) {
		super(cause);
	}
}
