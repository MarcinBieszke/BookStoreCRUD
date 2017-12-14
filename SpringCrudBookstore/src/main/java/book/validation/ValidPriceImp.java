package book.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPriceImp implements ConstraintValidator<ValidPrice, Integer>{

	@Override
	public void initialize(ValidPrice anno) {
	}

	@Override
	public boolean isValid(Integer price, ConstraintValidatorContext context) {
		if(price < 0 ) return false;
		if(price > 1000) return false;
		return true;
	}

}
