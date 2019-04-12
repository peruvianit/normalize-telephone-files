/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.integration.fastweb.bean;

import lombok.Data;

/**
 * Clase per la creazione delle rige del file csv output
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */

@Data
public final class CSVFastWebOutput{
	
		// FATTURA INFO	
		private String version;
		private String payloadID;
		private String timestamp;
		private String invoiceID;
		private String invoiceDate;
		private String codiceCliente;
		private String codiceClienteOrdinante;
		private String ragioneSocialeClienteOrdinante;
		private String codiceUnitaOrdinante;
		private String descrizioneUnitaOrdinante;
		private String centroFatturazione;
		private String codiceConvenzione;
		private String piva;
		private String codiceFiscale;
		private String ordineFornitura;
		private String metodoPagamento;
		private String dataScadenza;
		
		// RIEPIOLGO
		private String canoni;
		private String consumi;
		private String altriConsumi;
		private String costiSostenutiPerTerzeParti;
		private String altriAccrediti;
		private String attivazioni;
		private String totaleIva;
		private String totaleImponibile;
		private String totaleFattura;
		private String rimborsiFatturePrecedenti;
		private String rateizzazioniHardware;
		private String totalePagare;
		
		// DETTAGLIO FATTURA
		private String descr;
		private String id38;
		private String indirizzo;
		private String presso;
		private String alias;
		private String descr39;
		private String numIdent;
		private String descr40;
		private String area;
		private String tipoLinea;
		private String config;
		private String h24;
		private String nLinee;
		private String nCanali;
		private String dataAttiv;
		private String dataInizio;
		private String dataFine;
		private String costo;
		private String aliqIVA;
		private String codIVA;
		private String numUtenza;
		private String nChiamate;
		private String durata;
		private String servizio;
		private String tipologia;
		private String tariffa;
		private String qta;
		private String numOrdine;
		private String notaLibera;
		private String codProtocollo;
		private String descr41;
		private String prezzoUnit;
		private String dataVal;
		private String descr42;
		private String id43;
		private String indirizzo44;
		private String presso45;
		private String alias46;
		private String id47;
		private String id48;
		private String descr49;
		private String tariffa50;
		private String nChiamate51;
		private String durata52;
		private String costo53;
		private String aliqIVA54;
		private String codIVA55;
		private String qta56;
		private String numOrdine57;
		private String notaLibera58;
		private String codProtocollo59;
		private String descr60;
		private String prezzoUnit61;
		private String dataVal62;		
}
