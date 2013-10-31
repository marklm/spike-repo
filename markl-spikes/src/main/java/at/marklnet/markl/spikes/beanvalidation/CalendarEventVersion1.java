package at.marklnet.markl.spikes.beanvalidation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import at.marklnet.markl.spikes.beanvalidation.constraints.SelfValidating;
import at.marklnet.markl.spikes.beanvalidation.constraints.Validatable;

/**
 * Beispiel für Class Level Constraint.
 * 
 * @author Markus Markl
 */
@SelfValidating
public class CalendarEventVersion1 implements Validatable {

    @NotNull
    private final String title;

    private final Date startDate;

    private final Date endDate;

    public CalendarEventVersion1(String title, Date startDate, Date endDate) {

        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isValid() {
        return startDate == null || endDate == null || startDate.before(endDate);
    }

    @Override
    public String toString() {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");

        return 
            title + 
            " from " +  (startDate == null ? "-" : format.format(startDate)) + 
            " till " + (endDate == null ? "-" : format.format(endDate));
    }

}
