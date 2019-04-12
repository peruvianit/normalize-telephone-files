/**
 * 
 */
package it.pervuvianit.aura.normalize.config;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * Classe me mappea tutte le propieta che ci sono nel file 
 * application.properties con il formato app.*
 * 
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Component
@Validated
@ConfigurationProperties("app")
@Data
public class ApplicationConfig {

	@NotNull
	private String version;
	private String title;
	@NotBlank 
	private String workingExtensions;
	
	@NotBlank
	private String pathDirectoryEntry;
	
	@NotBlank
	private String pathDirectoryWorking;
	
	@NotBlank
	private String pathDirectoryWorked;
}
