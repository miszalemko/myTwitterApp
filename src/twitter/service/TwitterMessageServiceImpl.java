package twitter.service;

import twitter.dto.TwitterMessageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterMessageServiceImpl implements TwitterMessageService {

    @Override
    public TwitterMessageDto findbyId(Integer id) {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1,"First message","Mike","Mike's title");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2,"Second message","John","John's title");

        Map<Integer,TwitterMessageDto> tweetsMap = new HashMap<Integer,TwitterMessageDto>();

        tweetsMap.put(twitterMessageDto1.getId(),twitterMessageDto1);
        tweetsMap.put(twitterMessageDto2.getId(),twitterMessageDto2);

        TwitterMessageDto foundTweet = tweetsMap.get(id);
        return foundTweet;
    }

    @Override
    public List<TwitterMessageDto> finadAll() {
        TwitterMessageDto twitterMessageDto1 = new TwitterMessageDto(1, "First message", "Mike","Mike's title");
        TwitterMessageDto twitterMessageDto2 = new TwitterMessageDto(2, "Second message", "John","John's title");

        List<TwitterMessageDto> tweets = new ArrayList<TwitterMessageDto>();
        tweets.add(twitterMessageDto1);
        tweets.add(twitterMessageDto2);

        return tweets;
    }

    @Override
    public List<TwitterMessageDto> findByUserNameAndByMessage(String username, String message) {
        List<TwitterMessageDto> allTweets= finadAll();

        List<TwitterMessageDto> foundTweets = new ArrayList<>();

        if(username!=null && !username.equals("") && message!=null && !message.equals("")) {
            for(TwitterMessageDto tweet:allTweets) {
                if (tweet.getUsername().equals(username) && tweet.getMessage().equals(message)) {
                    foundTweets.add(tweet);
                }
            }
        }
        return foundTweets;
    }
}
