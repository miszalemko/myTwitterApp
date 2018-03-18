package twitter.validators;

import twitter.dto.TwitterMessageDto;

public class TwitterMessageValidatorImpl implements Validator {

    @Override
    public void validate(Object object, Errors errors) {
        TwitterMessageDto twitterMessageDto = (TwitterMessageDto) object;
        String message = twitterMessageDto.getMessage();
        if(message == null || message.equals("")) {
            errors.addFieldError("message", "Message can not be empty");
            return;
        }

        if(!message.matches("[a-zA-Z]+")) {
            errors.addFieldError("message", "Message can include only letters");
        }
    }
}
