package twitter.dto;

public class TwitterMessageDto {

    private Integer id;
    private String message = "";
    private String username = "";
    private String title = "";

    public TwitterMessageDto() {
    }

    public TwitterMessageDto(Integer id, String message, String username) {
        this.id = id;
        this.message = message;
        this.username = username;
    }

    public TwitterMessageDto(Integer id, String message, String username, String title) {
        this.id = id;
        this.message = message;
        this.username = username;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }
}
