/**
 * 
 */
package it.pervuvianit.aura.normalize.helper;

import static it.pervuvianit.aura.normalize.constant.AppConstant.FILE_TELEPHONE_MANAGER_FASTWEB_VALIDATE;
import static it.pervuvianit.aura.normalize.constant.AppConstant.FILE_TELEPHONE_MANAGER_TIM_VALIDATE;
import static it.pervuvianit.aura.normalize.constant.AppConstant.TELEPHONE_MANAGER_FASTWEB;
import static it.pervuvianit.aura.normalize.constant.AppConstant.TELEPHONE_MANAGER_TIM;

import org.apache.commons.lang3.StringUtils;

import it.pervuvianit.aura.normalize.exception.UtilHelperException;
import it.pervuvianit.aura.normalize.util.RegExUtil;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class UtilHelper {
	
	/**
	 * 
	 * @param content
	 * @param separator
	 * 
	 * @return lista delle extensioni
	 * 
	 * @throws UtilHelperException se il content è vuoto, scatta l'essezione
	 * 
	 * @see UtilHelperException
	 * 
	 * @since 1.0.0
	 */
	public static String[] convertStringToArray(String content, String separator) throws UtilHelperException {
		if ( StringUtils.isBlank(content) ) {
			throw new UtilHelperException("Nessun contenuto da elavorare!");
		}
		
		return content.split("\\" + separator);
	}
	
	/**
	 * Controlla tramite regular expression che tipo di file è sapere a che gestore apartiene, per decidere
	 * che processo eseguire 
	 * 
	 * @param nameFile 
	 * 
	 * @return codice del gestore telefonico che apartiene il file
	 * 
	 * @throws UtilHelperException 
	 * 
	 * @since 1.0.0
	 */
	public static String telephoneManagerByFile(String nameFile) throws UtilHelperException {
		if ( StringUtils.isBlank(nameFile) ) {
			throw new UtilHelperException("Nessun contenuto da elavorare!");
		}
		
		String telephoneManager = null;
		
		String match = nameFile.toUpperCase(); 
		if (RegExUtil.isMatches(FILE_TELEPHONE_MANAGER_TIM_VALIDATE,match)) {
			telephoneManager = TELEPHONE_MANAGER_TIM;
		}else if (RegExUtil.isMatches(FILE_TELEPHONE_MANAGER_FASTWEB_VALIDATE, match)) {
			telephoneManager = TELEPHONE_MANAGER_FASTWEB;
		}
		
		return telephoneManager;
	}
}
