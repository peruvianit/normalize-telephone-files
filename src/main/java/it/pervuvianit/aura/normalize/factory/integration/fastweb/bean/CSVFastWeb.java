/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.integration.fastweb.bean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;

import static it.pervuvianit.aura.normalize.constant.AppConstant.*;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */

/**.
 * Solo per DettaglioFattura, in modalita Map, ha la lista dei consumi.
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Data
public final class CSVFastWeb{

	protected LinkedList<FatturaInfo> linkedListFatturaInfo = new LinkedList<>();
	protected Map<String, RiepilogoFattura> mapRiepilogoFattura = new HashMap<String, RiepilogoFattura>();
	protected LinkedList<DettaglioFattura> linkedListDettaglioFattura = new LinkedList<>();
	
	protected Map<String, DettaglioFattura> mapDettaglioFattura = new HashMap<String, DettaglioFattura>();
	
	public void aggiungeFatturaInfo(final FatturaInfo fatturaInfo) {
		linkedListFatturaInfo.add(fatturaInfo);
	}
	
	public void aggiungeRiepilogoFattura(final RiepilogoFattura riepilogoFattura) {
		mapRiepilogoFattura.put(riepilogoFattura.getDescription34(), riepilogoFattura);
	}
	
	public void aggiungeDettaglioFattura(final DettaglioFattura dettaglioFattura) {
		linkedListDettaglioFattura.add(dettaglioFattura);
		aggiungeDettaglioFatturaMap(dettaglioFattura);
	}
	
	public void aggiungeDettaglioFatturaMap(final DettaglioFattura dettaglioFattura) {
		String durata = dettaglioFattura.getDurata();
		
		if (dettaglioFattura.getDescr39().toUpperCase().equals(TESTO_CONSUMO) && 
			( !StringUtils.isBlank(durata) && !durata.equals("0:00:00"))) {
			mapDettaglioFattura.put(dettaglioFattura.getNumIdent(), dettaglioFattura);
		}
	}
	
	public void aggiungeDettaglioConsumo(final DettaglioConsumo dettaglioConsumo) {
		// TO DO Verificare il problema della utenza che da una parte hanno il zero davanti
		DettaglioFattura dettaglioFattura = mapDettaglioFattura.get("0" + dettaglioConsumo.getId47());
		
		if ( dettaglioFattura != null ) {
			dettaglioFattura.aggiungeDettaglioConsumo(dettaglioConsumo);
		}
	}
		
	@Data
	public static class FatturaInfo{
		private String version;
		private String payloadID;
		private String timestamp;
		private String domain;
		private String identity;
		private String domain2;
		private String identity3;
		private String domain4;
		private String identity5;
		private String sharedSecret;
		private String userAgent;
		private String deploymentMode;
		private String invoiceID;
		private String purpose;
		private String operation;
		private String invoiceDate;
		private String invoiceDetailHeaderIndicator;
		private String invoiceDetailLineIndicator;
		private String role;
		private String addressID;
		private String name;
		private String ns1Lang;
		private String name6;
		private String deliverTo;
		private String street;
		private String city;
		private String state;
		private String postalCode;
		private String country;
		private String isoCountryCode;
		private String countryCode;
		private String isoCountryCode7;
		private String areaOrCityCode;
		private String number;
		private String countryCode8;
		private String isoCountryCode9;
		private String areaOrCityCode10;
		private String number11;
		private String identifier;
		private String domain12;
		private String creator;
		private String ns1Lang13;
		private String description;
		private String ns1Lang14;
		private String startDate;
		private String endDate;
		private String payloadID15;
		private String invoiceLineNumber;
		private String quantity;
		private String unitOfMeasure;
		private String currency;
		private String lineNumber;
		private String money;
		private String currency16;
		private String money17;
		private String currency18;
		private String description19;
		private String ns1Lang20;
		private String purpose21;
		private String category;
		private String percentageRate;
		private String currency22;
		private String currency23;
		private String taxLocation;
		private String ns1Lang24;
		private String money25;
		private String currency26;
		private String percentageRate27;
		private String currency28;
		private String money29;
		private String currency30;
		private String money31;
		private String currency32;
		private String currency33;
	}
	
	@Data
	public static class RiepilogoFattura{
		private String id;
		private String description34;
		private String ns1Lang35;
		private String money36;
		private String currency37;
	}

	@Data
	public static class DettaglioFattura{
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
		
		protected LinkedList<DettaglioConsumo> linkedListDettaglioConsumo = new LinkedList<>();
		
		public void aggiungeDettaglioConsumo(final DettaglioConsumo dettaglioConsumo) {
			linkedListDettaglioConsumo.add(dettaglioConsumo);
		}
	}
	
	@Data
	public static class DettaglioConsumo{
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
}
