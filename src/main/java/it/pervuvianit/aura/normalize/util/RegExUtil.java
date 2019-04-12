/**
 * 
 */
package it.pervuvianit.aura.normalize.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sergio Arellano {PeruViANit}
 *
 */
public class RegExUtil {
	public static boolean isMatches(final String patternContent, final String match) {
		Pattern pattern = Pattern.compile(patternContent);
		
		Matcher matcher = pattern.matcher(match);
		
		return matcher.matches();
	}
}
