/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.impl;

import static it.pervuvianit.aura.normalize.constant.AppConstant.SEPARATOR_EXTENSION_CSV_TIM;
import static it.pervuvianit.aura.normalize.constant.AppConstant.TELEPHONE_MANAGER_TIM;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import it.pervuvianit.aura.normalize.exception.ProcessFileTelephoneManagerException;
import it.pervuvianit.aura.normalize.factory.ITelephoneManager;
import it.pervuvianit.aura.normalize.factory.integration.CSVTelephoneManagerInfoGeneral;
import it.pervuvianit.aura.normalize.factory.integration.tim.bean.CSVTim;

/**
 * 
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerTim extends TelephoneManagerCsvBase<CSVTim> implements ITelephoneManager{

	@Override
	public Integer processesFile(File file) throws ProcessFileTelephoneManagerException {
		try {
			super.csvReaderTelephoneManager(file, SEPARATOR_EXTENSION_CSV_TIM, true); 
			
            while (nextRecord != null) {
            	CSVTim csvTim = new CSVTim();
            	
                csvTim.setCodiceFiscale(nextRecord[0]);
            	csvTim.setPartitaIva(nextRecord[1]);
            	csvTim.setCfa(nextRecord[2]);
            	csvTim.setContratto(nextRecord[3]);
            	csvTim.setFattura(nextRecord[4]);
            	csvTim.setIntestatario(nextRecord[5]);
            	csvTim.setImpianto(nextRecord[6]);
            	csvTim.setLocalitaImpianto(nextRecord[7]);
            	csvTim.setIndirizzoImpianti(nextRecord[8]);
            	csvTim.setDescrizioneAddebitiAccrediti(nextRecord[9]);
            	csvTim.setDescrizioneOffertaServizio(nextRecord[10]);
            	csvTim.setImportoAddebitiAccrediti(nextRecord[11]);
            	csvTim.setScontoRiduzione(nextRecord[12]);
            	csvTim.setImportoRiduzione(nextRecord[13]);
            	csvTim.setCosto(nextRecord[14]);
            	csvTim.setRiferimentoIva(nextRecord[15]);
            	csvTim.setFlagRegDer(nextRecord[16]);
            	csvTim.setQuantita(nextRecord[17]);
            	csvTim.setDurata(nextRecord[18]);
            	csvTim.setNumeroCarta(nextRecord[19]);
            	csvTim.setDataInizioRif(nextRecord[20]);
            	csvTim.setDataFineRif(nextRecord[21]);
            	csvTim.setTipologiaFattura(nextRecord[22]);
            	csvTim.setDataEmissioneFattura(nextRecord[23]);
            	csvTim.setDataScadenzaFattura(nextRecord[24]);
            	csvTim.setTotaleFattura(nextRecord[25]);
            	csvTim.setBimestreFatturazione(nextRecord[26]);
            	csvTim.setTipoImportoAddebito(nextRecord[27]);
            	
            	linkedListCSV.add(csvTim);
            	nextRow();
            }
            
            LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral = telephoneManagerInfoGeneral(linkedListCSV);
    		
    		super.generaFattureCSV(linkedListCSVTelephoneManagerInfoGeneral);
    		generaFattureDettaglioCSV(linkedListCSV);
    		
		} catch (IOException ioEx) {
			throw new ProcessFileTelephoneManagerException("Problemi con l'elaborazione del file : " + file.getName(), ioEx);
		} catch (Exception ex) {
			throw new ProcessFileTelephoneManagerException("Problemi con l'elaborazione della riga : " + nextRecord, ex);
		}
	    
		return linkedListCSV.size();
		
	}

	public LinkedList<CSVTelephoneManagerInfoGeneral> telephoneManagerInfoGeneral(LinkedList<CSVTim> linkedListCsvTim) {
		
		LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral = new LinkedList<CSVTelephoneManagerInfoGeneral>();
		
		Map<String, String> utenzeMap = new HashMap<String, String>();
		
		for (CSVTim csvTim : linkedListCsvTim) {
			String impianto = csvTim.getImpianto();
			
			if (utenzeMap.get(impianto) != null ) {
				continue;
			}
			
			utenzeMap.put(impianto, impianto);
			
			CSVTelephoneManagerInfoGeneral csvTelephoneManagerInfoGeneral = new CSVTelephoneManagerInfoGeneral();
			
			csvTelephoneManagerInfoGeneral.setGestore(TELEPHONE_MANAGER_TIM);			
			csvTelephoneManagerInfoGeneral.setUtenza(csvTim.getImpianto());
			csvTelephoneManagerInfoGeneral.setCodiceFiscale(csvTim.getCodiceFiscale());
			csvTelephoneManagerInfoGeneral.setFattura(csvTim.getFattura());
			csvTelephoneManagerInfoGeneral.setImporto(csvTim.getTotaleFattura());
			csvTelephoneManagerInfoGeneral.setIndirizzo(csvTim.getLocalitaImpianto());
			csvTelephoneManagerInfoGeneral.setDataEmissione(csvTim.getDataEmissioneFattura());
			csvTelephoneManagerInfoGeneral.setBimestre(csvTim.getBimestreFatturazione());
			
			linkedListCSVTelephoneManagerInfoGeneral.add(csvTelephoneManagerInfoGeneral);
		}
		
		return linkedListCSVTelephoneManagerInfoGeneral;
		
	}

	@Override
	public void generaFattureCSV(LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral) {
		for (CSVTelephoneManagerInfoGeneral csvTelephoneManagerInfoGeneral : linkedListCSVTelephoneManagerInfoGeneral) {
			System.out.println(ReflectionToStringBuilder.toString(csvTelephoneManagerInfoGeneral,ToStringStyle.SIMPLE_STYLE));
		}
	}

	@Override
	public <T> void generaFattureDettaglioCSV(LinkedList<T> linkedList) {
		for (T t : linkedList) {
			System.out.println(ReflectionToStringBuilder.toString((CSVTim) t,ToStringStyle.SIMPLE_STYLE));
		}
		
	}
}
