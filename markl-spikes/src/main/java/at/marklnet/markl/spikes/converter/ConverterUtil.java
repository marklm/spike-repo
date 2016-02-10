package at.marklnet.markl.spikes.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * Converting Utility.
 * 
 * @author marklm 
 */
public final class ConverterUtil {
    
    private ConverterUtil() {
        
    }
    
    private static final SimpleDateFormat DEFAULT_DATE = new SimpleDateFormat("dd.MM.yyyy");
    
    private static final SimpleDateFormat SVNR_DATE = new SimpleDateFormat("ddMMyyyy");
    
    private static final Pattern SVNR_REGEX_PATTERN = Pattern.compile("(%d{4})(%d{2})(%d{2})(%d{4})");
    
    /**
     * Converts given svnr to a birthday String representation.
     * 
     * @param svnr
     *            the SVNR
     * @param pattern
     *            pattern to apply
     * @return the converted birthday as String representation using the given format
     * @throws ConverterUtilException
     *             in case converting fails
     */
    public static String svnrToDateString(String svnr, String pattern) throws ConverterUtilException {
        return new SimpleDateFormat(pattern).format(svnrToDate(svnr));
    }

    /**
     * Converts given svnr to a birthday String representation, using a default pattern "dd.MM.yyyy".
     * 
     * @param svnr
     *            the SVNR
     * 
     * @return the converted birthday as String representation using the given format
     * @throws ConverterUtilException
     *             in case converting fails
     */
    public static String svnrToDateString(String svnr) throws ConverterUtilException {
        return DEFAULT_DATE.format(svnrToDate(svnr));
    }

    /**
     * Converts given svnr to a birthday String representation, using a default pattern "dd.MM.yyyy".
     * 
     * @param svnr
     *            the SVNR
     * 
     * @return the birthday as Date
     * @throws ConverterUtilException
     *             in case converting fails
     */
    public static Date svnrToDate(String svnr) throws ConverterUtilException {
        assertValidSvnrChars(svnr);

        final Matcher matcher = SVNR_REGEX_PATTERN.matcher(svnr);

        try {
            return SVNR_DATE.parse(matcher.group(1) + matcher.group(2) + matcher.group(3));
        } catch (ParseException e) {
            throw new ConverterUtilException(svnr + " is not a valid SVNR. Unable to convert.");
        }

    }

    private static void assertValidSvnrChars(String svnr) throws ConverterUtilException {
        if (!StringUtils.isEmpty(svnr) && SVNR_REGEX_PATTERN.matcher(svnr).matches()) {
            return;
        }
        throw new ConverterUtilException(svnr + " is not a valid SVNR. Unable to convert.");
    }

}
