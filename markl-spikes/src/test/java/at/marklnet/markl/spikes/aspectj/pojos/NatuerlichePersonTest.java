package at.marklnet.markl.spikes.aspectj.pojos;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import junit.framework.Assert;

import org.junit.Test;

public class NatuerlichePersonTest {

    private static final Validator BEAN_VALIDATOR =  Validation.buildDefaultValidatorFactory().getValidator();
    
    @Test
    public void testConstraints() {
       final  NatuerlichePerson person = new NatuerlichePerson();
       
       person.setVorname("Ungültiges Zeichen *~");
       person.setNachname("Gültige Zeichen *~");
       
       final Set<ConstraintViolation<NatuerlichePerson>> violations = BEAN_VALIDATOR.validate(person);
       
       Assert.assertEquals(1, violations.size());
    }
    
    
}
