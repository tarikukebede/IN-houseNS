package com.tarikukebede.INhousenavigationsystem.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Tariku Kebede
 * validates UUIds using a regex patteren
 * */
@Target(ElementType.FIELD)
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp="^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$|")
@ReportAsSingleViolation
public @interface ValidUUID {
    String message() default "Invalid UUID";
    Class<?>[] groups()default {};
    Class<? extends Payload>[] payload()default {};
}