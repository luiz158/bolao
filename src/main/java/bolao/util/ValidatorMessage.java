package bolao.util;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public class ValidatorMessage {
	
public static String getMessage(Object obj) {
		
		Validator validator;
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        Set<ConstraintViolation<Object>> constraintViolation = validator.validate(obj); 
        
        String msg = null;
        
        Iterator<ConstraintViolation<Object>> a = constraintViolation.iterator();
        
        while (a.hasNext()){
        	if (msg == null){
        		msg ="";
        	}
        	
        	ConstraintViolation<Object> cv =  a.next();
        	msg += cv.getMessage() + "\n";
        }
        return msg;
    }
}
