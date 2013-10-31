package at.marklnet.markl.spikes.beanvalidation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit Test testet ClassLevel Constraint.
 * 
 * @author Markus Markl
 */
public class CalendarEventVersion1SelfValidatingTest {

    private static Validator validator;

    private static Date startDate;

    private static Date endDate;
    
    /** instance to test */
    private CalendarEventVersion1 instance;

    @BeforeClass
    public static void setUpValidatorAndDates() {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        startDate = new GregorianCalendar(2009, 8, 20).getTime();
        endDate = new GregorianCalendar(2009, 8, 21).getTime();
    }
    

    @Test
    public void calendarEventIsValidAsEndDateIsAfterStartDate() {
        instance = new CalendarEventVersion1("Team meeting", startDate, endDate);
        assertTrue(validator.validate(instance).isEmpty());
    }

    @Test
    public void calendarEventIsInvalidAsEndDateIsBeforeStartDate() {
        instance = new CalendarEventVersion1("Team meeting", endDate, startDate);

        Set<ConstraintViolation<CalendarEventVersion1>> constraintViolations = validator.validate(instance);
        assertEquals(1, constraintViolations.size());

        assertEquals("{at.marklnet.markl.spikes.beanvalidation.SelfValidating.message}", 
                     constraintViolations.iterator().next().getMessage());
    }
}