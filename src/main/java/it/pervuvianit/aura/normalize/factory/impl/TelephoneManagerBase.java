/**
 * 
 */
package it.pervuvianit.aura.normalize.factory.impl;

import java.util.LinkedList;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import it.pervuvianit.aura.normalize.factory.integration.CSVTelephoneManagerInfoGeneral;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class TelephoneManagerBase{

	public void generaFattureCSV(LinkedList<CSVTelephoneManagerInfoGeneral> linkedListCSVTelephoneManagerInfoGeneral) {
		for (CSVTelephoneManagerInfoGeneral csvTelephoneManagerInfoGeneral : linkedListCSVTelephoneManagerInfoGeneral) {
			System.out.println(ReflectionToStringBuilder.toString(csvTelephoneManagerInfoGeneral,ToStringStyle.SIMPLE_STYLE));
		}
	}
	
}
