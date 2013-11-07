package at.marklnet.markl.spikes.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class GlasUtils {
	
    /**
     * Gibt den aktuellen Zeitpunkt zurück.
     * @return Datum+Uhrzeit
     */
    public static Date now() {
         return new Date();
    }
	
    /**
     * Default value is today date.
     * 
     * @param day
     *            optional day of month to set
     * @param month
     *            optional month to set
     * @param year
     *            optonal year to set
     * @param startOfDay
     *            decision to time (start or end of day)
     * @return {@link Date} for given values.
     */
    public static Date getDateFor(Integer day, Integer month, Integer year, boolean startOfDay) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(startOfDay ? getTodayStartDate() : getTodayEndDate());

        updateCalendarField(cal, Calendar.DAY_OF_MONTH, day);
        updateCalendarField(cal, Calendar.MONTH, month);
        updateCalendarField(cal, Calendar.YEAR, year);

        return cal.getTime();
    }
    
    private static void updateCalendarField(Calendar cal, int field, Integer value) {
        if (value != null) {
            cal.set(field, value);
        } 
    }
    
    /**
     * @return start date of today e.g. 23.11.2012 00:00:00
     */
    public static Date getTodayStartDate() {
        // Need to subtract 1 day! Strange as behavior not like api's javadoc
        return DateUtils.addDays(DateUtils.ceiling(Calendar.getInstance().getTime(), Calendar.DAY_OF_MONTH), -1);
    }
    
    /**
     * @return start date of today e.g. 24.11.2012 23:59:59
     */
    public static Date getTodayEndDate() {
        return DateUtils.addMilliseconds(DateUtils.ceiling(Calendar.getInstance().getTime(), Calendar.DAY_OF_MONTH), -1);
    }

}
