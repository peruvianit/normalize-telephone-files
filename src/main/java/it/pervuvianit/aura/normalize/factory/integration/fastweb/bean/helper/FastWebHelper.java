/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import it.pervuvianit.aura.normalize.exception.FastWebHelperException;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.FatturaInfo;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.RiepilogoFattura;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public final class FastWebHelper {
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String version(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String version = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				version = fatturaInfo.getVersion();
				
				if ( version != null ) {
					break;
				}
			}
		}
		
		return version;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String payloadID(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String payloadID = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				payloadID = fatturaInfo.getPayloadID();
				
				if ( payloadID != null ) {
					break;
				}
			}
		}
		
		return payloadID;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String timestamp(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String timestamp = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				timestamp = fatturaInfo.getTimestamp();
				
				if ( timestamp != null ) {
					break;
				}
			}
		}
		
		return timestamp;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String invoiceID(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String invoiceID = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				invoiceID = fatturaInfo.getInvoiceID();
				
				if ( invoiceID != null ) {
					break;
				}
			}
		}
		
		return invoiceID;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return Data emissione fattura
	 * 
	 */
	public static String invoiceDate(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String invoceDate = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				invoceDate = fatturaInfo.getInvoiceDate();
				
				if ( invoceDate != null ) {
					break;
				}
			}
		}
		
		return invoceDate;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String startDate(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String startDate = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				startDate = fatturaInfo.getStartDate();
				
				if ( startDate != null ) {
					break;
				}
			}
		}
		
		return startDate;
	}
	
	/**
	 * 
	 * @param linkedListFattura
	 * 
	 * @return 
	 */
	public static String endDate(LinkedList<FatturaInfo> linkedListFattura, Boolean header) {
		String endDate = null;
		
		if ( linkedListFattura != null ) {
			for (FatturaInfo fatturaInfo : linkedListFattura) {
				if ( header ) {
					header = false;
					continue;
				}
				endDate = fatturaInfo.getStartDate();
				
				if ( endDate != null ) {
					break;
				}
			}
		}
		
		return endDate;
	}
	
	/**
	 * 
	 * @param keyIdentifier
	 * @param linkedListFattura
	 * 
	 * @return Il valore associato al identifier [colonna identifier], esempio [CODICE CLIENTE, CODICE CLIENTE ORDINANTE, RAG SOC CLIENTE ORDINANTE, ECC]
	 */
	public static String identifierDescription(String keyDescription, LinkedList<FatturaInfo> linkedListFatturaInfo) {
		String value = null;
		
		if ( linkedListFatturaInfo != null ) {
			for (FatturaInfo fatturaInfo : linkedListFatturaInfo) {
				if (fatturaInfo.getDescription().trim().toUpperCase().equals(keyDescription)) {
					value = fatturaInfo.getIdentifier();
					break;
				}
			}
		}
		
		return value;
	}
	
	/**
	 * 
	 * @param keyDescription
	 * @param mapRiepilogoFattura
	 * 
	 * @return Il importo associato alla descrizione [colonna Description34]
	 */
	public static String detailDescription(String keyDescription, Map<String, RiepilogoFattura> mapRiepilogoFattura) {
		String value = null;
		
		if ( mapRiepilogoFattura.size() > 0 ) {
			RiepilogoFattura riepilogoFattura = mapRiepilogoFattura.get(keyDescription);
			
			if ( riepilogoFattura != null ) {
				value = riepilogoFattura.getMoney36();
			}
		}
		
		return value;
	}
	
	/**
	 * 
	 * @param sDataInzio
	 * @param sDataFine
	 * 
	 * @return ritorna il Bimestre in base al calcolo delle date inizio e data fine del Livello 3
	 */
	public static String calcoloBimestre(String sDataInzio, String sDataFine) {
		if (StringUtils.isAllBlank(sDataInzio, sDataFine)) {
			throw new FastWebHelperException("Il calcolo per il bimestre, non puo essere effettuato : dataInizio [" +  sDataInzio + "] - dataFine [" + sDataFine + "]");
		}
		
		DateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		try {
			Date dataInizio = sdf.parse(sDataInzio);
			Date dataFine = sdf.parse(sDataFine);
			
			System.out.println(dataInizio + " :: " + dataFine);
		} catch (ParseException e) {
			throw new FastWebHelperException(e);
		}
		
		return "----";
	}
	
	
	public static String formatToDateInvoiceDate(String invioceDate) {
		return invioceDate.substring(6,8) + "/" +
			   invioceDate.substring(4,6) + "/" +
			   invioceDate.substring(0,4);
	}
	
}