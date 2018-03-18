package twitter.validators;

import org.junit.Assert;
import org.junit.Test;
import twitter.dto.TwitterMessageDto;

public class TwitterTitleMessageValidatorImplTest {

    private Validator validator = new TwitterTitleMessageValidatorImpl();

    @Test
    public void shouldTitleCanNotBeNull() throws Exception {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1, null,null,null);
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);
        Assert.assertNotNull("Title must not be null", errors.getErrorMessage("title"));
    }

}