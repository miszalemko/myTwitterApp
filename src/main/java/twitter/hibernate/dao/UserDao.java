package twitter.hibernate.dao;

import twitter.entities.User;
import twitter.exceptions.DatabaseException;

public interface UserDao {

    User findById(Integer id) throws DatabaseException;
    User findByUsername(String username) throws DatabaseException;
    User findByUsernameAndPassword(String username, String password) throws DatabaseException;
}
