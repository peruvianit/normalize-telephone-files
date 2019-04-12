/**
 * 
 */
package it.pervuvianit.aura.normalize.exception;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class ProcessFileTelephoneManagerException extends Exception {
	private static final long serialVersionUID = 2677270233049746402L;

	protected ProcessFileTelephoneManagerException() {
	}

	public ProcessFileTelephoneManagerException(String message) {
		super(message);
	}

	public ProcessFileTelephoneManagerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProcessFileTelephoneManagerException(Throwable cause) {
		super(cause);
	}
}
