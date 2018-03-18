package twitter.validators;

import org.junit.Assert;
import org.junit.Test;
import twitter.dto.TwitterMessageDto;

import static org.junit.Assert.*;

public class TwitterMessageValidatorImplTest {

    private Validator validator = new TwitterMessageValidatorImpl();

    @Test
    public void shouldMessageContainsOnlyLeetrs() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1," 111fafasfafa",null,null);
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);
        String errorMessage = errors.getErrorMessage("message");
        Assert.assertEquals("Message can include only letters", errorMessage);
    }
}