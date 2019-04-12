/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class DirectoryEntryException extends RuntimeException {
	private static final long serialVersionUID = 2677270233049746402L;

	protected DirectoryEntryException() {
	}

	public DirectoryEntryException(String message) {
		super(message);
	}

	public DirectoryEntryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DirectoryEntryException(Throwable cause) {
		super(cause);
	}
}
