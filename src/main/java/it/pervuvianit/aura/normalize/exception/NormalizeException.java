/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class NormalizeException extends Exception {
	private static final long serialVersionUID = 2677270233049746402L;

	protected NormalizeException() {
	}

	public NormalizeException(String message) {
		super(message);
	}

	public NormalizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NormalizeException(Throwable cause) {
		super(cause);
	}
}
