import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FutureOrPresentWithMarginValidator implements ConstraintValidator<FutureOrPresentWithMargin, Temporal> {

    FutureOrPresentWithMargin constraintAnnotation;

    @Override public void initialize(FutureOrPresentWithMargin constraintAnnotation) {
        this.constraintAnnotation = constraintAnnotation;
    }

    @Override public boolean isValid(Temporal given, ConstraintValidatorContext constraintValidatorContext) {
        if(given == null){
            return true;
        }
        long diff = ChronoUnit.SECONDS.between(Instant.now().minusSeconds(this.constraintAnnotation.margin()), given);
        return diff >= 0;
    }
}
