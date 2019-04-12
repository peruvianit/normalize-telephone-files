/**
 * 
 */
package it.pervuvianit.aura.normalize.run;

import static it.pervuvianit.aura.normalize.constant.AppConstant.EXTENSION_FILE_ERROR;
import static it.pervuvianit.aura.normalize.constant.AppConstant.EXTENSION_FILE_TEMPORALE;
import static it.pervuvianit.aura.normalize.constant.AppConstant.SEPARATOR_EXTENSION_FILE;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import it.pervuvianit.aura.normalize.bean.SummaryProcessFileTelephoneManager;
import it.pervuvianit.aura.normalize.config.ApplicationConfig;
import it.pervuvianit.aura.normalize.exception.DirectoryEntryException;
import it.pervuvianit.aura.normalize.exception.NormalizeException;
import it.pervuvianit.aura.normalize.factory.ITelephoneManager;
import it.pervuvianit.aura.normalize.factory.TelephoneManagerFactory;
import it.pervuvianit.aura.normalize.helper.UtilHelper;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */

/**
 * <p>
 * Classe di partenza per la elaborazione dei distinti file in input che 
 * provengono dei diversi gestori telefonici.
 * Una volta verificato il file e scelto il gestore, viene eseguito in base al
 * gestore scelto e produce un file normalizzato per caricare sul DBMS.
 * </p>
 * @author Sergio Arellano {PeruViANit}
 *
 */
@Component
public class NormalizeInvoke {
	private static final Logger logger = LoggerFactory.getLogger(NormalizeInvoke.class);
	
	@Autowired
	private ApplicationConfig applicationConfig;
	
	public void execute() throws NormalizeException {
		
		String pathDirectoryEntry = applicationConfig.getPathDirectoryEntry();
		File src = new File(pathDirectoryEntry);
		String[] exts;
		try {
			exts = UtilHelper.convertStringToArray(applicationConfig.getWorkingExtensions(), SEPARATOR_EXTENSION_FILE );
			
			if (!src.exists()) {
				throw new DirectoryEntryException("Il pathDirectoryEntry non è corretto, controllare ruta : " + pathDirectoryEntry);
			}
			
			IOFileFilter filter = new SuffixFileFilter(exts, IOCase.INSENSITIVE);
			Iterator<File> iteratorFile = FileUtils.iterateFiles(src, filter, DirectoryFileFilter.DIRECTORY);
			
			Collection<File> files = Lists.newArrayList(iteratorFile);
			
			if ( files.size() > 0 ) {
				TelephoneManagerFactory telephoneManagerFactory = new TelephoneManagerFactory();
				for (File file : files) {
					String fileName = file.getName();
					String selectTelephoneManager = UtilHelper.telephoneManagerByFile(fileName);
					
					if (selectTelephoneManager == null) {
						logger.warn("Il file non è lavorabile, controllare il nome se è corretto : " + fileName);
						continue;
					}
					
					SummaryProcessFileTelephoneManager summaryProcess = new SummaryProcessFileTelephoneManager();
					summaryProcess.setNameFile(fileName);
					summaryProcess.setTelphoneManager(selectTelephoneManager);
					
					ITelephoneManager telephoneManager = telephoneManagerFactory.getTelephoneManager(selectTelephoneManager);
					
					// Step 1 FILE : Spostamento del file per iniziare a elaborare, la extension cambia a tmp.
					String originExtension = FilenameUtils.getExtension(fileName);
					
					File fileWorking = new File(applicationConfig.getPathDirectoryWorking() + fileName.replace(originExtension, EXTENSION_FILE_TEMPORALE));
					FileUtils.moveFile(file, fileWorking);
					
					Integer rowWorking = null;
					
					try {
						rowWorking = telephoneManager.processesFile(fileWorking);
					}catch (Exception pEx ) {
						File fileWorkingError = new File(applicationConfig.getPathDirectoryWorking() + fileName.replace(originExtension, EXTENSION_FILE_ERROR));
						FileUtils.moveFile(fileWorking, fileWorkingError);
						throw pEx;
					}
					
					// Step 2 FILE : Spostamento del file che stato elaborato, e riprende la extension originale.
					File fileWorked = new File(applicationConfig.getPathDirectoryWorked() + fileName);
					FileUtils.moveFile(fileWorking, fileWorked);
					
					summaryProcess.setRowWorking(rowWorking);
					summaryProcess.setEndProcess(new Date());
					
					logger.debug(ReflectionToStringBuilder.toString(summaryProcess, ToStringStyle.MULTI_LINE_STYLE));
				}
			}else {
				logger.warn("Nessun file da elavorare");
			}
		} catch (Exception e) {
			throw new NormalizeException(e);
		}
	}
}

