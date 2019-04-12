/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.impl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.CharSequenceReader;

import com.opencsv.CSVReader;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerCsvBase<T> extends TelephoneManagerBase{

	protected CSVReader csvReader;
	protected String[] nextRecord;
	
	protected LinkedList<T> linkedListCSV = new LinkedList<>();
	
	@SuppressWarnings("deprecation")
	protected void csvReaderTelephoneManager(File file, Character separatorCSV, Boolean skipHeader) throws IOException {
		byte[] buffer;
		
		try {
			buffer = FileUtils.readFileToByteArray(file);			
			Reader targetReader = new CharSequenceReader(new String(buffer));	
			
			this.csvReader = new CSVReader(targetReader, separatorCSV);	
			
			nextRecord = csvReader.readNext();
					
			if ( skipHeader ) {
				nextRecord = csvReader.readNext(); // SKIP HEADER
			}
		} catch (IOException ioEx) {
			throw ioEx;
		}
	}
	
	protected void nextRow() throws IOException {
		nextRecord = csvReader.readNext();
		if (nextRecord != null) {
			if (nextRecord[0].equalsIgnoreCase("#")) {
				nextRecord = null;
			}
    	}
	}
}
