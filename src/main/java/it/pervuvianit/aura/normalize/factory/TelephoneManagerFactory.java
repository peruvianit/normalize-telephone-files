/**
 * 
 */
package it.pervuvianit.aura.normalize.factory;

import static it.pervuvianit.aura.normalize.constant.AppConstant.*;

import org.springframework.util.StringUtils;

import it.pervuvianit.aura.normalize.exception.TelephoneManagerFactoryException;
import it.pervuvianit.aura.normalize.factory.impl.TelephoneManagerFastWeb;
import it.pervuvianit.aura.normalize.factory.impl.TelephoneManagerTim;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerFactory {
	public ITelephoneManager getTelephoneManager(String telephoneManager) throws TelephoneManagerFactoryException {
		
		if (StringUtils.isEmpty(telephoneManager)) {
			throw new TelephoneManagerFactoryException("Il parametro telephoneManager è obbligatorio!");
		}
		
		if (telephoneManager.equalsIgnoreCase(TELEPHONE_MANAGER_TIM)) {
			return new TelephoneManagerTim();
		}else if (telephoneManager.equalsIgnoreCase(TELEPHONE_MANAGER_FASTWEB)) {
			return new TelephoneManagerFastWeb();
		}else {
			throw new TelephoneManagerFactoryException("Non è gestito il gestore : [" + telephoneManager + "]");
		}
		
	}
}
