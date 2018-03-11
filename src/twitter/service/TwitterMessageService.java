package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.List;

public interface TwitterMessageService {

    TwitterMessageDto findbyId(Integer id);
    List<TwitterMessageDto> finadAll();
}
