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
        String errorMessage = errors.getErrorMessage("title");
        Assert.assertNotNull("Title must not be null", errors.getErrorMessage("title"));
        Assert.assertEquals("Title must be not blank",errorMessage);
    }

    @Test
    public void shouldTitleNotExceed10() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto(1, null,null,"asfasfasfasfasfsafasfasf");
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);
        String errorMessage = errors.getErrorMessage("title");
        Assert.assertEquals("Title size length must not exceed 10",errorMessage);
    }

    @Test
    public void shouldTitleCanNotBeBlank() {
        TwitterMessageDto twitterMessageDto = new TwitterMessageDto();
        Errors errors = new Errors();
        validator.validate(twitterMessageDto,errors);
        String errorMessage = errors.getErrorMessage("title");
        Assert.assertEquals("Title must be not blank",errorMessage);
    }

}