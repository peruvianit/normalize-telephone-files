/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import it.pervuvianit.aura.normalize.exception.ProcessFileTelephoneManagerException;
import it.pervuvianit.aura.normalize.factory.ITelephoneManager;
import it.pervuvianit.aura.normalize.factory.integration.CSVTelephoneManagerInfoGeneral;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.DettaglioConsumo;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.DettaglioFattura;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.FatturaInfo;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWeb.RiepilogoFattura;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.CSVFastWebOutput;
import it.pervuvianit.aura.normalize.factory.integration.fastweb.bean.helper.FastWebHelper;
import static it.pervuvianit.aura.normalize.constant.AppConstant.*;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerFastWeb extends TelephoneManagerBase implements ITelephoneManager{

	@Override
	public Integer processesFile(File file) throws ProcessFileTelephoneManagerException {

		Integer fattureLavorate = 0;
		
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			// we get first sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// we iterate on rows
		    Iterator<Row> rowIt = sheet.iterator();

		    CSVFastWeb csvFastWeb = new CSVFastWeb();
		    
		    Boolean header = true;
		    
		    while(rowIt.hasNext()) {
		    	
		      Row row = rowIt.next();
		      
		      if ( header ) {
		    	  header = false;
		    	  continue;
		      }

		      if ( row.getCell(0) != null && !StringUtils.isBlank(row.getCell(0).toString())) {
		    	  CSVFastWeb.FatturaInfo fatturaInfo = new CSVFastWeb.FatturaInfo();
		    	  
		    	  fatturaInfo.setVersion(contentCell(row.getCell(0)).toString());
                  fatturaInfo.setPayloadID(contentCell(row.getCell(1)).toString());
                  fatturaInfo.setTimestamp(contentCell(row.getCell(2)).toString());
                  fatturaInfo.setDomain(contentCell(row.getCell(3)).toString());
                  fatturaInfo.setIdentity(contentCell(row.getCell(4)).toString());
                  fatturaInfo.setDomain2(contentCell(row.getCell(5)).toString());
                  fatturaInfo.setIdentity3(contentCell(row.getCell(6)).toString());
                  fatturaInfo.setDomain4(contentCell(row.getCell(7)).toString());
                  fatturaInfo.setIdentity5(contentCell(row.getCell(8)).toString());
                  fatturaInfo.setSharedSecret(contentCell(row.getCell(9)).toString());
                  fatturaInfo.setUserAgent(contentCell(row.getCell(10)).toString());
                  fatturaInfo.setDeploymentMode(contentCell(row.getCell(11)).toString());
                  fatturaInfo.setInvoiceID(contentCell(row.getCell(12)).toString());
                  fatturaInfo.setPurpose(contentCell(row.getCell(13)).toString());
                  fatturaInfo.setOperation(contentCell(row.getCell(14)).toString());
                  fatturaInfo.setInvoiceDate(contentCell(row.getCell(15)).toString());
                  fatturaInfo.setInvoiceDetailHeaderIndicator(contentCell(row.getCell(16)).toString());
                  fatturaInfo.setInvoiceDetailLineIndicator(contentCell(row.getCell(17)).toString());
                  fatturaInfo.setRole(contentCell(row.getCell(18)).toString());
                  fatturaInfo.setAddressID(contentCell(row.getCell(19)).toString());
                  fatturaInfo.setName(contentCell(row.getCell(20)).toString());
                  fatturaInfo.setNs1Lang(contentCell(row.getCell(21)).toString());
                  fatturaInfo.setName6(contentCell(row.getCell(22)).toString());
                  fatturaInfo.setDeliverTo(contentCell(row.getCell(23)).toString());
                  fatturaInfo.setStreet(contentCell(row.getCell(24)).toString());
                  fatturaInfo.setCity(contentCell(row.getCell(25)).toString());
                  fatturaInfo.setState(contentCell(row.getCell(26)).toString());
                  fatturaInfo.setPostalCode(contentCell(row.getCell(27)).toString());
                  fatturaInfo.setCountry(contentCell(row.getCell(28)).toString());
                  fatturaInfo.setIsoCountryCode(contentCell(row.getCell(29)).toString());
                  fatturaInfo.setCountryCode(contentCell(row.getCell(30)).toString());
                  fatturaInfo.setIsoCountryCode7(contentCell(row.getCell(31)).toString());
                  fatturaInfo.setAreaOrCityCode(contentCell(row.getCell(32)).toString());
                  fatturaInfo.setNumber(contentCell(row.getCell(33)).toString());
                  fatturaInfo.setCountryCode8(contentCell(row.getCell(34)).toString());
                  fatturaInfo.setIsoCountryCode9(contentCell(row.getCell(35)).toString());
                  fatturaInfo.setAreaOrCityCode10(contentCell(row.getCell(36)).toString());
                  fatturaInfo.setNumber11(contentCell(row.getCell(37)).toString());
                  fatturaInfo.setIdentifier(contentCell(row.getCell(38)).toString());
                  fatturaInfo.setDomain12(contentCell(row.getCell(39)).toString());
                  fatturaInfo.setCreator(contentCell(row.getCell(40)).toString());
                  fatturaInfo.setNs1Lang13(contentCell(row.getCell(41)).toString());
                  fatturaInfo.setDescription(contentCell(row.getCell(42)).toString());
                  fatturaInfo.setNs1Lang14(contentCell(row.getCell(43)).toString());
                  fatturaInfo.setStartDate(contentCell(row.getCell(44)).toString());
                  fatturaInfo.setEndDate(contentCell(row.getCell(45)).toString());
                  fatturaInfo.setPayloadID15(contentCell(row.getCell(46)).toString());
                  fatturaInfo.setInvoiceLineNumber(contentCell(row.getCell(47)).toString());
                  fatturaInfo.setQuantity(contentCell(row.getCell(48)).toString());
                  fatturaInfo.setUnitOfMeasure(contentCell(row.getCell(49)).toString());
                  fatturaInfo.setCurrency(contentCell(row.getCell(50)).toString());
                  fatturaInfo.setLineNumber(contentCell(row.getCell(51)).toString());
                  fatturaInfo.setMoney(contentCell(row.getCell(52)).toString());
                  fatturaInfo.setCurrency16(contentCell(row.getCell(53)).toString());
                  fatturaInfo.setMoney17(contentCell(row.getCell(54)).toString());
                  fatturaInfo.setCurrency18(contentCell(row.getCell(55)).toString());
                  fatturaInfo.setDescription19(contentCell(row.getCell(56)).toString());
                  fatturaInfo.setNs1Lang20(contentCell(row.getCell(57)).toString());
                  fatturaInfo.setPurpose21(contentCell(row.getCell(58)).toString());
                  fatturaInfo.setCategory(contentCell(row.getCell(59)).toString());
                  fatturaInfo.setPercentageRate(contentCell(row.getCell(60)).toString());
                  fatturaInfo.setCurrency22(contentCell(row.getCell(61)).toString());
                  fatturaInfo.setCurrency23(contentCell(row.getCell(62)).toString());
                  fatturaInfo.setTaxLocation(contentCell(row.getCell(63)).toString());
                  fatturaInfo.setNs1Lang24(contentCell(row.getCell(64)).toString());
                  fatturaInfo.setMoney25(contentCell(row.getCell(65)).toString());
                  fatturaInfo.setCurrency26(contentCell(row.getCell(66)).toString());
                  fatturaInfo.setPercentageRate27(contentCell(row.getCell(67)).toString());
                  fatturaInfo.setCurrency28(contentCell(row.getCell(68)).toString());
                  fatturaInfo.setMoney29(contentCell(row.getCell(69)).toString());
                  fatturaInfo.setCurrency30(contentCell(row.getCell(70)).toString());
                  fatturaInfo.setMoney31(contentCell(row.getCell(71)).toString());
                  fatturaInfo.setCurrency32(contentCell(row.getCell(72)).toString());
                  fatturaInfo.setCurrency33(contentCell(row.getCell(73)).toString());
                  
                  csvFastWeb.aggiungeFatturaInfo(fatturaInfo);
		      }
		      
		      // LIVELLO 2		      
		      if ( row.getCell(74) != null && !StringUtils.isBlank(row.getCell(74).toString())) {
		    	  CSVFastWeb.RiepilogoFattura riepilogoFattura = new CSVFastWeb.RiepilogoFattura();
		    	  
		    	  riepilogoFattura.setId(contentCell(row.getCell(74)).toString());
                  riepilogoFattura.setDescription34(contentCell(row.getCell(75)).toString());
                  riepilogoFattura.setNs1Lang35(contentCell(row.getCell(76)).toString());
                  riepilogoFattura.setMoney36(contentCell(row.getCell(77)).toString());
                  riepilogoFattura.setCurrency37(contentCell(row.getCell(78)).toString());
		    	  
		    	  csvFastWeb.aggiungeRiepilogoFattura(riepilogoFattura);
		      }
		      
		      // LIVELLO 3
		      if( row.getCell(79) != null && !StringUtils.isBlank(row.getCell(79).toString())) {
		    	  CSVFastWeb.DettaglioFattura dettaglioFattura = new CSVFastWeb.DettaglioFattura();
		    	  
		    	  dettaglioFattura.setDescr(contentCell(row.getCell(79)).toString());
                  dettaglioFattura.setId38(contentCell(row.getCell(80)).toString());
                  dettaglioFattura.setIndirizzo(contentCell(row.getCell(81)).toString());
                  dettaglioFattura.setPresso(contentCell(row.getCell(82)).toString());
                  dettaglioFattura.setAlias(contentCell(row.getCell(83)).toString());
                  dettaglioFattura.setDescr39(contentCell(row.getCell(84)).toString());
                  dettaglioFattura.setNumIdent(contentCell(row.getCell(85)).toString());
                  dettaglioFattura.setDescr40(contentCell(row.getCell(86)).toString());
                  dettaglioFattura.setArea(contentCell(row.getCell(87)).toString());
                  dettaglioFattura.setTipoLinea(contentCell(row.getCell(88)).toString());
                  dettaglioFattura.setConfig(contentCell(row.getCell(89)).toString());
                  dettaglioFattura.setH24(contentCell(row.getCell(90)).toString());
                  dettaglioFattura.setNLinee(contentCell(row.getCell(91)).toString());
                  dettaglioFattura.setNCanali(contentCell(row.getCell(92)).toString());
                  dettaglioFattura.setDataAttiv(contentCell(row.getCell(93)).toString());
                  dettaglioFattura.setDataInizio(contentCell(row.getCell(94)).toString());
                  dettaglioFattura.setDataFine(contentCell(row.getCell(95)).toString());
                  dettaglioFattura.setCosto(contentCell(row.getCell(96)).toString());
                  dettaglioFattura.setAliqIVA(contentCell(row.getCell(97)).toString());
                  dettaglioFattura.setCodIVA(contentCell(row.getCell(98)).toString());
                  dettaglioFattura.setNumUtenza(contentCell(row.getCell(99)).toString());
                  dettaglioFattura.setNChiamate(contentCell(row.getCell(100)).toString());
                  dettaglioFattura.setDurata(contentCell(row.getCell(101)).toString());
                  dettaglioFattura.setServizio(contentCell(row.getCell(102)).toString());
                  dettaglioFattura.setTipologia(contentCell(row.getCell(103)).toString());
                  dettaglioFattura.setTariffa(contentCell(row.getCell(104)).toString());
                  dettaglioFattura.setQta(contentCell(row.getCell(105)).toString());
                  dettaglioFattura.setNumOrdine(contentCell(row.getCell(106)).toString());
                  dettaglioFattura.setNotaLibera(contentCell(row.getCell(107)).toString());
                  dettaglioFattura.setCodProtocollo(contentCell(row.getCell(108)).toString());
                  dettaglioFattura.setDescr41(contentCell(row.getCell(109)).toString());
                  dettaglioFattura.setPrezzoUnit(contentCell(row.getCell(110)).toString());
                  dettaglioFattura.setDataVal(contentCell(row.getCell(111)).toString());
                  
                  csvFastWeb.aggiungeDettaglioFattura(dettaglioFattura);
		      }   
		      
              //LIVELLO 4
		      if ( row.getCell(112) != null && !StringUtils.isBlank(row.getCell(112).toString())) {
		    	  CSVFastWeb.DettaglioConsumo dettaglioConsumo = new CSVFastWeb.DettaglioConsumo();

                  dettaglioConsumo.setDescr42(contentCell(row.getCell(112)).toString());
                  dettaglioConsumo.setId43(contentCell(row.getCell(113)).toString());
                  dettaglioConsumo.setIndirizzo44(contentCell(row.getCell(114)).toString());
                  dettaglioConsumo.setPresso45(contentCell(row.getCell(115)).toString());
                  dettaglioConsumo.setAlias46(contentCell(row.getCell(116)).toString());
                  dettaglioConsumo.setId47(contentCell(row.getCell(117)).toString());
                  dettaglioConsumo.setId48(contentCell(row.getCell(118)).toString());
                  dettaglioConsumo.setDescr49(contentCell(row.getCell(119)).toString());
                  dettaglioConsumo.setTariffa50(contentCell(row.getCell(120)).toString());
                  dettaglioConsumo.setNChiamate51(contentCell(row.getCell(121)).toString());
                  dettaglioConsumo.setDurata52(contentCell(row.getCell(122)).toString());
                  dettaglioConsumo.setCosto53(contentCell(row.getCell(123)).toString());
                  dettaglioConsumo.setAliqIVA54(contentCell(row.getCell(124)).toString());
                  dettaglioConsumo.setCodIVA55(contentCell(row.getCell(125)).toString());
                  dettaglioConsumo.setQta56(contentCell(row.getCell(126)).toString());
                  dettaglioConsumo.setNumOrdine57(contentCell(row.getCell(127)).toString());
                  dettaglioConsumo.setNotaLibera58(contentCell(row.getCell(128)).toString());
                  dettaglioConsumo.setCodProtocollo59(contentCell(row.getCell(129)).toString());
                  dettaglioConsumo.setDescr60(contentCell(row.getCell(130)).toString());
                  dettaglioConsumo.setPrezzoUnit61(contentCell(row.getCell(131)).toString());
                  dettaglioConsumo.setDataVal62(contentCell(row.getCell(132)).toString());
                  
                  csvFastWeb.aggiungeDettaglioConsumo(dettaglioConsumo);
		      }
		    }
		    
		    workbook.close();
		    
		    LinkedList<CSVFastWebOutput> LinkedListCSVFastWebOutput = generaCsvFastweb(csvFastWeb);
		    
		    fattureLavorate = LinkedListCSVFastWebOutput.size();
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fattureLavorate;
	}
	
	private LinkedList<CSVFastWebOutput> generaCsvFastweb(CSVFastWeb csvFastWeb) {
		LinkedList<CSVFastWebOutput> linkedListcsvFastWebOutput = new LinkedList<>();
		
		LinkedList<FatturaInfo>  linkedListFatturaInfo = csvFastWeb.getLinkedListFatturaInfo();
		Map<String, RiepilogoFattura> mapRiepilogoFattura = csvFastWeb.getMapRiepilogoFattura();
		
		Map<String, BigDecimal> mapTotaleFattura = new HashMap<String, BigDecimal>();
		
		if ( csvFastWeb != null ) {
			
			String version = FastWebHelper.version(linkedListFatturaInfo,true);
			String payloadID = FastWebHelper.payloadID(linkedListFatturaInfo,true);
			String timestamp = FastWebHelper.timestamp(linkedListFatturaInfo,true);
			String invoiceID = FastWebHelper.invoiceID(linkedListFatturaInfo,true);
			String invoiceDate = FastWebHelper.invoiceDate(linkedListFatturaInfo,true);
			
			String codiceCliente = FastWebHelper.identifierDescription("CODICE CLIENTE", linkedListFatturaInfo);
			String codiceClienteOrdinante = FastWebHelper.identifierDescription("CODICE CLIENTE ORDINANTE", linkedListFatturaInfo);
			String ragioneSocialeClienteOrdinante = FastWebHelper.identifierDescription("RAG SOC CLIENTE ORDINANTE", linkedListFatturaInfo);
			String codiceUnitaOrdinante = FastWebHelper.identifierDescription("CODICE UNITA' ORDINANTE", linkedListFatturaInfo);			
			String descrizioneUnitaOrdinante = FastWebHelper.identifierDescription("DESCRIZIONE UNITA' ORDINANTE", linkedListFatturaInfo);
			String centroFatturazione = FastWebHelper.identifierDescription("CENTRO FATTURAZIONE", linkedListFatturaInfo);
			String codiceConvenzione = FastWebHelper.identifierDescription("CODICE CONVENZIONE", linkedListFatturaInfo);
			String piva = FastWebHelper.identifierDescription("PIVA", linkedListFatturaInfo);
			String codiceFiscale = FastWebHelper.identifierDescription("CODFISC", linkedListFatturaInfo);
			String ordineFornitura = FastWebHelper.identifierDescription("ORD. FORNITURA", linkedListFatturaInfo);
			String metodoPagamento = FastWebHelper.identifierDescription("METODO PAGAMENTO", linkedListFatturaInfo);
			String dataScadenza = FastWebHelper.identifierDescription("DATA SCADENZA", linkedListFatturaInfo);
			
			String canoni = FastWebHelper.detailDescription("Canoni", mapRiepilogoFattura);
			String consumi = FastWebHelper.detailDescription("Consumi", mapRiepilogoFattura);
			String altriConsumi = FastWebHelper.detailDescription("Altri Costi", mapRiepilogoFattura);
			String costiSostenutiPerTerzeParti = FastWebHelper.detailDescription("Costi sostenuti per terze parti", mapRiepilogoFattura);
			String altriAccrediti = FastWebHelper.detailDescription("Altri Accrediti", mapRiepilogoFattura);
			String attivazioni = FastWebHelper.detailDescription("Attivazioni", mapRiepilogoFattura);
			String totaleIva = FastWebHelper.detailDescription("Totale IVA", mapRiepilogoFattura);
			String totaleImponibile = FastWebHelper.detailDescription("Totale Imponibile", mapRiepilogoFattura);
			String totaleFattura = FastWebHelper.detailDescription("Totale Fattura", mapRiepilogoFattura);
			String rimborsiFatturePrecedenti = FastWebHelper.detailDescription("Rimborsi fatture precedenti", mapRiepilogoFattura);
			String rateizzazioniHardware = FastWebHelper.detailDescription("Rateizzazioni hardware", mapRiepilogoFattura);
			String totalePagare = FastWebHelper.detailDescription("Totale da pagare", mapRiepilogoFattura);
			
			LinkedList<DettaglioFattura> linkedListDettaglioFattura = csvFastWeb.getLinkedListDettaglioFattura();
			
			Boolean header = true;
			 
			for (DettaglioFattura dettaglioFattura : linkedListDettaglioFattura) {
				
				if ( header ) {
					header = false;
					continue;
				}
				
				String numIdent = dettaglioFattura.getNumIdent();
				
				String costo = dettaglioFattura.getCosto();
				
				if ( mapTotaleFattura.get(numIdent) != null ) {
					BigDecimal tmpTotale = mapTotaleFattura.get(numIdent).add(convertStringToBigDecimal(costo));
					mapTotaleFattura.remove(numIdent);
					mapTotaleFattura.put(numIdent, tmpTotale);
				}else {
					mapTotaleFattura.put(numIdent, convertStringToBigDecimal(costo));
				}
				
				LinkedList<DettaglioConsumo> linkedListDettaglioConsumo = new LinkedList<>();
				
				DettaglioFattura dettaglioFatturaConsumo = null;
				
				String durata = dettaglioFattura.getDurata();
				
				if ( !StringUtils.isBlank(durata) && !durata.equals("0:00:00")) {
					dettaglioFatturaConsumo = csvFastWeb.getMapDettaglioFattura().get(numIdent);
				}
				
				if ( dettaglioFatturaConsumo != null ) {
					linkedListDettaglioConsumo = dettaglioFatturaConsumo.getLinkedListDettaglioConsumo();
				}
				 
				Integer numeroDettaglioConsumo = 0;
				Integer posX = 0;
				
				if ( linkedListDettaglioConsumo.size()> 0) {
					numeroDettaglioConsumo = linkedListDettaglioConsumo.size();
				}
				 
				do {
					CSVFastWebOutput csvFastWebOutput = new CSVFastWebOutput();
					 
					csvFastWebOutput.setVersion(version);
					csvFastWebOutput.setPayloadID(payloadID);
					csvFastWebOutput.setTimestamp(timestamp);
					csvFastWebOutput.setInvoiceID(invoiceID);
					csvFastWebOutput.setInvoiceDate(invoiceDate);
					 
					csvFastWebOutput.setCodiceCliente(codiceCliente);
					csvFastWebOutput.setCodiceClienteOrdinante(codiceClienteOrdinante);
					csvFastWebOutput.setRagioneSocialeClienteOrdinante(ragioneSocialeClienteOrdinante);
					csvFastWebOutput.setCodiceUnitaOrdinante(codiceUnitaOrdinante);
					csvFastWebOutput.setDescrizioneUnitaOrdinante(descrizioneUnitaOrdinante);
					csvFastWebOutput.setCentroFatturazione(centroFatturazione);
					csvFastWebOutput.setCodiceConvenzione(codiceConvenzione);
					csvFastWebOutput.setPiva(piva);
					csvFastWebOutput.setCodiceFiscale(codiceFiscale);
					csvFastWebOutput.setOrdineFornitura(ordineFornitura);
					csvFastWebOutput.setMetodoPagamento(metodoPagamento);
					csvFastWebOutput.setDataScadenza(dataScadenza);
					 
					csvFastWebOutput.setCanoni(canoni);
					csvFastWebOutput.setConsumi(consumi);
					csvFastWebOutput.setAltriConsumi(altriConsumi);
					csvFastWebOutput.setCostiSostenutiPerTerzeParti(costiSostenutiPerTerzeParti);
					csvFastWebOutput.setAltriAccrediti(altriAccrediti);
					csvFastWebOutput.setAttivazioni(attivazioni);
					csvFastWebOutput.setTotaleIva(totaleIva);
					csvFastWebOutput.setTotaleImponibile(totaleImponibile);
					csvFastWebOutput.setTotaleFattura(totaleFattura);
					csvFastWebOutput.setRimborsiFatturePrecedenti(rimborsiFatturePrecedenti);
					csvFastWebOutput.setRateizzazioniHardware(rateizzazioniHardware);
					csvFastWebOutput.setTotalePagare(totalePagare);
					 
					csvFastWebOutput.setDescr(dettaglioFattura.getDescr());
					csvFastWebOutput.setId38(dettaglioFattura.getId38());
					csvFastWebOutput.setIndirizzo(dettaglioFattura.getIndirizzo());
					csvFastWebOutput.setPresso(dettaglioFattura.getPresso());
					csvFastWebOutput.setAlias(dettaglioFattura.getAlias());
					csvFastWebOutput.setDescr39(dettaglioFattura.getDescr39());
					csvFastWebOutput.setNumIdent(dettaglioFattura.getNumIdent());
					csvFastWebOutput.setDescr40(dettaglioFattura.getDescr40());
					csvFastWebOutput.setArea(dettaglioFattura.getArea());
					csvFastWebOutput.setTipoLinea(dettaglioFattura.getTipoLinea());
					csvFastWebOutput.setConfig(dettaglioFattura.getConfig());
					csvFastWebOutput.setH24(dettaglioFattura.getH24());
					csvFastWebOutput.setNLinee(dettaglioFattura.getNLinee());
					csvFastWebOutput.setNCanali(dettaglioFattura.getNCanali());
					csvFastWebOutput.setDataAttiv(dettaglioFattura.getDataAttiv());
					csvFastWebOutput.setDataInizio(dettaglioFattura.getDataInizio());
					csvFastWebOutput.setDataFine(dettaglioFattura.getDataFine());
					csvFastWebOutput.setCosto(costo);
					csvFastWebOutput.setAliqIVA(dettaglioFattura.getAliqIVA());
					csvFastWebOutput.setCodIVA(dettaglioFattura.getCodIVA());
					csvFastWebOutput.setNumUtenza(dettaglioFattura.getNumUtenza());
					csvFastWebOutput.setNChiamate(dettaglioFattura.getNChiamate());
					csvFastWebOutput.setDurata(dettaglioFattura.getDurata());
					csvFastWebOutput.setServizio(dettaglioFattura.getServizio());
					csvFastWebOutput.setTipologia(dettaglioFattura.getTipologia());
					csvFastWebOutput.setTariffa(dettaglioFattura.getTariffa());
					csvFastWebOutput.setQta(dettaglioFattura.getQta());
					csvFastWebOutput.setNumOrdine(dettaglioFattura.getNumOrdine());
					csvFastWebOutput.setNotaLibera(dettaglioFattura.getNotaLibera());
					csvFastWebOutput.setCodProtocollo(dettaglioFattura.getCodProtocollo());
					csvFastWebOutput.setDescr41(dettaglioFattura.getDescr41());
					csvFastWebOutput.setPrezzoUnit(dettaglioFattura.getPrezzoUnit());
					csvFastWebOutput.setDataVal(dettaglioFattura.getDataVal());
					 
					if ( linkedListDettaglioConsumo != null && linkedListDettaglioConsumo.size()> 0) {
						DettaglioConsumo dettaglioConsumo = linkedListDettaglioConsumo.get(posX++);
						 
						csvFastWebOutput.setDescr42(dettaglioConsumo.getDescr42());
						csvFastWebOutput.setId43(dettaglioConsumo.getId43());
						csvFastWebOutput.setIndirizzo44(dettaglioConsumo.getIndirizzo44());
						csvFastWebOutput.setPresso45(dettaglioConsumo.getPresso45());
						csvFastWebOutput.setAlias46(dettaglioConsumo.getAlias46());
						csvFastWebOutput.setId47(dettaglioConsumo.getId47());
						csvFastWebOutput.setId48(dettaglioConsumo.getId48());
						csvFastWebOutput.setDescr49(dettaglioConsumo.getDescr49());
						csvFastWebOutput.setTariffa50(dettaglioConsumo.getTariffa50());
						csvFastWebOutput.setNChiamate51(dettaglioConsumo.getNChiamate51());
						csvFastWebOutput.setDurata52(dettaglioConsumo.getDurata52());
						csvFastWebOutput.setCosto53(dettaglioConsumo.getCosto53());
						csvFastWebOutput.setAliqIVA54(dettaglioConsumo.getAliqIVA54());
						csvFastWebOutput.setCodIVA55(dettaglioConsumo.getCodIVA55());
						csvFastWebOutput.setQta56(dettaglioConsumo.getQta56());
						csvFastWebOutput.setNumOrdine57(dettaglioConsumo.getNumOrdine57());
						csvFastWebOutput.setNotaLibera58(dettaglioConsumo.getNotaLibera58());
						csvFastWebOutput.setCodProtocollo59(dettaglioConsumo.getCodProtocollo59());
						csvFastWebOutput.setDescr60(dettaglioConsumo.getDescr60());
						csvFastWebOutput.setPrezzoUnit61(dettaglioConsumo.getPrezzoUnit61());
						csvFastWebOutput.setDataVal62(dettaglioConsumo.getDataVal62());
					} 
					
					linkedListcsvFastWebOutput.add(csvFastWebOutput);
					
				} while(--numeroDettaglioConsumo > 0);
			}
		}
		
		LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral = telephoneManagerInfoGeneral(linkedListcsvFastWebOutput, mapTotaleFattura);
		
		super.generaFattureCSV(linkedListCSVTelephoneManagerInfoGeneral);
		generaFattureDettaglioCSV(linkedListcsvFastWebOutput);
		
		return linkedListcsvFastWebOutput;
		
	}

	public LinkedList<CSVTelephoneManagerInfoGeneral> telephoneManagerInfoGeneral(LinkedList<CSVFastWebOutput> linkedListcsvFastWebOutput, Map<String, BigDecimal> mapTotaleFattura) {
		
		LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral = new LinkedList<CSVTelephoneManagerInfoGeneral>();
		
		Map<String, String> utenzeMap = new HashMap<String, String>();
		
		for (CSVFastWebOutput csvFastWebOutput : linkedListcsvFastWebOutput) {
			String numIdent = csvFastWebOutput.getNumIdent();
			
			if (utenzeMap.get(numIdent) != null ) {
				continue;
			}
			
			utenzeMap.put(numIdent, numIdent);
			
			CSVTelephoneManagerInfoGeneral csvTelephoneManagerInfoGeneral = new CSVTelephoneManagerInfoGeneral();
			
			csvTelephoneManagerInfoGeneral.setGestore(TELEPHONE_MANAGER_FASTWEB);			
			csvTelephoneManagerInfoGeneral.setUtenza(numIdent);
			csvTelephoneManagerInfoGeneral.setCodiceFiscale(csvFastWebOutput.getCodiceFiscale());
			csvTelephoneManagerInfoGeneral.setFattura(csvFastWebOutput.getInvoiceID());
			csvTelephoneManagerInfoGeneral.setImporto(mapTotaleFattura.get(numIdent).toString().replace(".", ","));
			csvTelephoneManagerInfoGeneral.setIndirizzo(csvFastWebOutput.getIndirizzo());
			csvTelephoneManagerInfoGeneral.setDataEmissione(FastWebHelper.formatToDateInvoiceDate(csvFastWebOutput.getInvoiceDate()));
			csvTelephoneManagerInfoGeneral.setBimestre(FastWebHelper.calcoloBimestre(csvFastWebOutput.getDataInizio(), csvFastWebOutput.getDataFine()));
			
			linkedListCSVTelephoneManagerInfoGeneral.add(csvTelephoneManagerInfoGeneral);
		}
		
		return linkedListCSVTelephoneManagerInfoGeneral;
		
	}

	@Override
	public <T> void generaFattureDettaglioCSV(LinkedList<T> linkedList) {
		for (T t : linkedList) {
			System.out.println(ReflectionToStringBuilder.toString((CSVFastWebOutput) t,ToStringStyle.SIMPLE_STYLE));
		}
	}
	
	private Object contentCell(Cell cell) {
		Object cellValue = "";
		
		if ( cell != null ) {
			CellType cellType = cell.getCellType();
			if (cellType == CellType.STRING) {
				cellValue = cell.getStringCellValue();
			} else if (cellType == CellType.NUMERIC) {
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = cell.getDateCellValue();
				} else {
					cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());
				}
			} else if (cellType == CellType.BOOLEAN) {
				cellValue = cell.getBooleanCellValue();
			} else if (cellType == CellType.FORMULA) {
				cellValue = cell.getCellFormula();
			} else if (cellType == CellType.BLANK) {
				cellValue = "";
			}
		}
		return cellValue; 
	}
	
	private BigDecimal convertStringToBigDecimal(String costo) {
		BigDecimal value = new BigDecimal(costo.replace(".","").replace(",", "."));
		return value;
	}
}
