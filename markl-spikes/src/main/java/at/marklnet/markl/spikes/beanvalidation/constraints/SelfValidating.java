package at.marklnet.markl.spikes.beanvalidation.constraints;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = SelfValidatingValidator.class)
@Documented
public @interface SelfValidating {

    String message() default "{at.marklnet.markl.spikes.beanvalidation.SelfValidating.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}