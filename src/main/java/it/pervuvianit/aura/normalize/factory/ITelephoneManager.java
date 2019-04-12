package it.pervuvianit.aura.normalize.factory;

import java.io.File;
import java.util.LinkedList;

import it.pervuvianit.aura.normalize.exception.ProcessFileTelephoneManagerException;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public interface ITelephoneManager {

	Integer processesFile(File file) throws ProcessFileTelephoneManagerException;
	
	<T> void  generaFattureDettaglioCSV(LinkedList<T> linkedList);
}

