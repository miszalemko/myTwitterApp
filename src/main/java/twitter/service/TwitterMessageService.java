package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.List;

public interface TwitterMessageService {

    TwitterMessageDto findbyId(Integer id);
    List<TwitterMessageDto> findAll();
    List<TwitterMessageDto> findByUserNameAndByMessage(String username,String message);
    List<TwitterMessageDto> findByUser(String username);
    void save(TwitterMessageDto twitterMessageDto);
}
