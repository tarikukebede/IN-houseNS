package com.tarikukebede.INhousenavigationsystem.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;
import java.util.regex.Pattern;

public class ValidateUUID implements ConstraintValidator<ValidUUID, UUID> {
    @Override
    public void initialize(ValidUUID constraintAnnotation) {
    }

    @Override
    public boolean isValid(UUID uuid, ConstraintValidatorContext context) {
        Pattern UUID_REGEX = Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");
        return UUID_REGEX.matcher(uuid.toString()).matches();
    }
}
