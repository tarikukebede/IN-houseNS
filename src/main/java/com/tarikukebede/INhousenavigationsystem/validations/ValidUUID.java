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
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@Constraint(validatedBy = ValidateUUID.class)
public @interface ValidUUID {
    String message() default "Invalid UUID";
    Class<?>[] groups()default {};
    Class<? extends Payload>[] payload()default {};
}
