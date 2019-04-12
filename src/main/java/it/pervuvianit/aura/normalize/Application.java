package it.pervuvianit.aura.normalize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import it.pervuvianit.aura.normalize.config.ApplicationConfig;
import it.pervuvianit.aura.normalize.run.NormalizeInvoke;

/**
 * Applicazione per la normalizzazione de diversi fonti di input dai diversi
 * gestori telefonici.
 * 
 * @author Sergio Arellano {PeruViANit}
 * 
 * @version 1.0.0
 *
 */
@SpringBootApplication
@ComponentScan({"it.pervuvianit.aura.normalize.config", "it.pervuvianit.aura.normalize.run"})
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	@Autowired
	private NormalizeInvoke normalizeInvoke;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Start dell'applicazione. Scrive il nome e la versione con la che viene eseguita 
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info(applicationConfig.getTitle() + ", version : " + applicationConfig.getVersion());
		normalizeInvoke.execute();
	}

}
