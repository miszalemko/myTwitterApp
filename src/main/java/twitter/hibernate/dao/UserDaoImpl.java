package twitter.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import twitter.entities.Message;
import twitter.entities.User;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.HibernateConfigurationLoader;


public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();

    @Override
    public User findById(Integer id) throws DatabaseException{
        Session session;
        try {
            session = sessionFactory.openSession();
            return session.find(User.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException("Problem with getting user with id= " + id + " from database w" + e);
        }
    }

    @Override
    public User findByUsername(String username) throws DatabaseException{
        Session session;
        try {
            session = sessionFactory.openSession();
            Query<User> query = session.createNamedQuery("findUserByUsername", User.class);
            query.setParameter("userName", username);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Problem with getting user with username= " + username + " from database" + e);
        }
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws DatabaseException{
        Session session;
        try {
            session = sessionFactory.openSession();
            Query<User> query = session.createQuery("SELECT u FROM User u WHERE " + "u.username LIKE :userName AND u.password LIKE :password",
                    User.class);
            query.setParameter("userName",User.class);
            query.setParameter("password",User.class);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new DatabaseException("Problem with getting user with username= " + username + " from database" + e);
        }
    }
}
