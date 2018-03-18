package twitter.validators;

import twitter.dto.TwitterMessageDto;

public class TwitterTitleMessageValidatorImpl implements Validator {

    private static int MAX_TITLE_LENGTH = 10;

    @Override
    public void validate(Object object, Errors errors) {
        TwitterMessageDto twitterMessageDto = (TwitterMessageDto)object;
        String title = twitterMessageDto.getTitle();
        if(title==null || title.equals("")) {
            errors.addFieldError("title", "Title must be not blank");
            return;
        }
        if(title!=null && title.length()>MAX_TITLE_LENGTH) {
            errors.addFieldError("title","Title size to length must not exceed " + MAX_TITLE_LENGTH);
        }
    }
}
