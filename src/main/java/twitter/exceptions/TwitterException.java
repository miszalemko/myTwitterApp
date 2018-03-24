package twitter.exceptions;

public class TwitterException extends Exception {

    public TwitterException(String message) {
        super(message);
    }

    public TwitterException(String message, Throwable cause) {
        super(message, cause);
    }
}
