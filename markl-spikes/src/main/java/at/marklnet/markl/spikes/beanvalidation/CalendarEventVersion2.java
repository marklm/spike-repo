package at.marklnet.markl.spikes.beanvalidation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.ScriptAssert;

/**
 * Beispiel für Class Level Constraint mit Hilfe von @ScriptAssert.
 * 
 * http://musingsofaprogrammingaddict.blogspot.co.at/2010/06/whats-new-in-hibernate-validator-41.html
 * http://musingsofaprogrammingaddict.blogspot.co.at/2010/02/generic-class-level-constraint-for-bean.html
 * http://stackoverflow.com/questions/1972933/cross-field-validation-with-hibernate-validator-jsr-303
 * http://stackoverflow.com/questions/2781771/how-can-i-validate-two-or-more-fields-in-combination
 * 
 * http://docs.jboss.org/hibernate/validator/4.1/api/org/hibernate/validator/constraints/ScriptAssert.html
 * 
 * @author Markus Markl
 */
@ScriptAssert (lang = "javascript", 
//               script="_this.isValid()",
               script="(_this.getStartDate() == null || _this.getEndDate() == null || _this.getStartDate().before(_this.getEndDate()))",
               message="{at.marklnet.markl.spikes.beanvalidation.SelfValidating.message}")
public class CalendarEventVersion2 {

    @NotNull
    private final String title;

    private final Date startDate;

    private final Date endDate;

    public CalendarEventVersion2(String title, Date startDate, Date endDate) {

        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Date getStartDate() {
        return this.startDate;
    }
    
    public Date getEndDate() {
        return this.endDate;
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
