package twitter.service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import twitter.dto.TwitterMessageDto;
import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.dao.TwitterMessageDao;
import twitter.hibernate.dao.TwitterMessageDaoImpl;
import twitter.hibernate.dao.UserDao;
import twitter.hibernate.dao.UserDaoImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwitterMessageDatabaseServiceImpl implements TwitterMessageService {

    private TwitterMessageDao twitterMessageDao = new TwitterMessageDaoImpl();
    private TwitterMessageDtoMapper dtoMapper = new TwitterMessageDtoMapper();
    private Logger logger = Logger.getLogger(this.getClass());
    private UserDao userDao = new UserDaoImpl();
    private TwitterMessageEntityMapper entityMapper = new TwitterMessageEntityMapper();

    @Override
    public TwitterMessageDto findbyId(Integer id) {
        try{
            return dtoMapper.apply(twitterMessageDao.findById(id));
        } catch (DatabaseException e) {
            logger.error("Problem with getting tweet by id= " + id + " from database " + e);
        }
        return null;
    }

    @Override
    public List<TwitterMessageDto> findAll() {
        try {
            List<Message> tweets = twitterMessageDao.findAll();
            return tweets.stream().map(dtoMapper).collect(Collectors.toList());
        } catch (DatabaseException e) {
            logger.error("Problem with getting tweets from database", e);
        }
        return null;
    }

    @Override
    public void save(TwitterMessageDto twitterMessageDto) {
        try{
            Message message = entityMapper.apply(twitterMessageDto);
            twitterMessageDao.save(message);
        } catch (DatabaseException e) {
            logger.error("Problem with saving tweet to database", e);
        }
    }

    @Override
    public List<TwitterMessageDto> findByUserNameAndByMessage(String username, String message) {
        return null;
    }

    @Override
    public List<TwitterMessageDto> findByUser(String username) {
        return null;
    }

    private class TwitterMessageDtoMapper implements Function<Message, TwitterMessageDto> {
        @Override
        public TwitterMessageDto apply(Message message) {
            User user = message.getUser();
            return new TwitterMessageDto(message.getId(), message.getMessage(), user.getUsername(), message.getTitle());
        }
    }
    private class TwitterMessageEntityMapper implements Function<TwitterMessageDto,Message> {
        @Override
        public Message apply(TwitterMessageDto twitterMessageDto) {
            User user = null;
            try {
                user = userDao.findByUsername(twitterMessageDto.getUsername());
            } catch (DatabaseException e) {
                logger.error("Find by username error", e);
            }
             return new Message(twitterMessageDto.getTitle(), twitterMessageDto.getMessage(), user);
        }
    }

}
