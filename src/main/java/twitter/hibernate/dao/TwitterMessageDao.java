package twitter.hibernate.dao;

import twitter.entities.Message;
import twitter.exceptions.DatabaseException;

import java.util.List;

public interface TwitterMessageDao {

    List<Message> findAll() throws DatabaseException;

    Message findById(Integer id) throws DatabaseException;

    void save(Message message) throws DatabaseException;
}
