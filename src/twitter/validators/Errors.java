package twitter.validators;

import java.util.HashMap;
import java.util.Map;

public class Errors {

    private Map<String,String> filedErrors;

    public void addFieldError(String fieldName, String errorMessage) {
        if(filedErrors==null) {
            filedErrors = new HashMap<String,String>();
        }
        filedErrors.put(fieldName,errorMessage);
    }

    public String getErrorMessage(String fieldName) {
        return filedErrors.get(fieldName);
    }
}
