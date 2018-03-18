package twitter.validators;

import twitter.dto.TwitterMessageDto;

public interface TwitterMessageValidator {

    void validate(TwitterMessageDto twitterMessageDto);
}
