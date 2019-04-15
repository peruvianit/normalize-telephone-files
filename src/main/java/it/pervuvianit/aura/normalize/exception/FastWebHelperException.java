/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class FastWebHelperException extends RuntimeException {
	private static final long serialVersionUID = 2677270233049746402L;

	protected FastWebHelperException() {
	}

	public FastWebHelperException(String message) {
		super(message);
	}

	public FastWebHelperException(String message, Throwable cause) {
		super(message, cause);
	}

	public FastWebHelperException(Throwable cause) {
		super(cause);
	}
}
