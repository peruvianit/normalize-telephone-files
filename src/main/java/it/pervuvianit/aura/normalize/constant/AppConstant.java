package it.pervuvianit.aura.normalize.constant;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class AppConstant {
	public static final String TELEPHONE_MANAGER_TIM = "TIM";
	public static final String TELEPHONE_MANAGER_FASTWEB = "FASTWEB";
	
	// REGULAR EXPRESSION
	
	public static final String FILE_TELEPHONE_MANAGER_TIM_VALIDATE = "^\\d{4}_\\d{1,2}_(\\d+_){2}DF_\\d{8}_\\d{6}\\.CSV$";
	public static final String FILE_TELEPHONE_MANAGER_FASTWEB_VALIDATE = "^\\w{3}\\d{1,}\\.XLSX";
	
	// EXTENSION
	
	public static final String EXTENSION_FILE_TEMPORALE = "tmp";
	public static final String EXTENSION_FILE_ERROR = "err";
	
	// CONSTANT APPLICATION
	
	public static final String SEPARATOR_EXTENSION_FILE = "|";
	public static final Character SEPARATOR_EXTENSION_CSV_TIM = ';';
	
	//
	public static final String TESTO_CONSUMO = "CONSUMO";
	public static final String TESTO_CANONE = "CANONE";
	
}
