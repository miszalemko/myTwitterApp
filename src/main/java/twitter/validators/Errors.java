package twitter.validators;

import java.util.HashMap;
import java.util.Map;

public class Errors {

    private Map<String,String> fieldErrors;

    public void addFieldError(String fieldName, String errorMessage) {
        if(fieldErrors ==null) {
            fieldErrors = new HashMap<String,String>();
        }
        fieldErrors.put(fieldName,errorMessage);
    }

    public String getErrorMessage(String fieldName) {
        return fieldErrors.get(fieldName);
    }

    public boolean hasFieldErrors() {
        return fieldErrors !=null;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }
}
