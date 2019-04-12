/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class UtilHelperException extends Exception {
	private static final long serialVersionUID = 2677270233049746402L;

	protected UtilHelperException() {
	}

	public UtilHelperException(String message) {
		super(message);
	}

	public UtilHelperException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilHelperException(Throwable cause) {
		super(cause);
	}
}
