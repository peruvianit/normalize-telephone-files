/**
 * 
 */
package it.pervuvianit.aura.normalize.bean;

import java.util.Date;

import lombok.Data;

/**
 * Classe per la estadistica della performance dell'elaborazione dei singoli
 * file
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */

@Data
/**
 * Al momento di creare l'oggetto, per default la data startProcess è inizializzata
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class SummaryProcessFileTelephoneManager {
	private Date startProcess;
	private Date endProcess;	
	private String nameFile;
	private String telphoneManager;
	private Integer rowWorking;

	public SummaryProcessFileTelephoneManager() {
		startProcess = new Date();
	}
}
