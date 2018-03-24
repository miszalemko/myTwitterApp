package twitter.hibernate.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import twitter.entities.Message;
import twitter.exceptions.DatabaseException;
import twitter.hibernate.HibernateConfigurationLoader;


import java.util.List;

public class TwitterMessageDaoImpl implements TwitterMessageDao {

    private SessionFactory sessionFactory = HibernateConfigurationLoader.getSessionFactory();
    private Logger logger = Logger.getLogger(TwitterMessageDaoImpl.class);
    @Override
    public List<Message> findAll() throws DatabaseException {
        Session session;
        try {
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Message");
        return (List<Message>) query.list();
        } catch(HibernateException e) {
            throw new DatabaseException("Error with getting from database" + e);
        }
    }

    @Override
    public Message findById(Integer id) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            return session.find(Message.class, id);
        } catch (HibernateException e) {
            throw new DatabaseException("Problem with getting message from database" + e);
        }
    }

    @Override
    public void save(Message message) throws DatabaseException {
        Session session;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(message);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DatabaseException("Problem with adding message \"" + message.toString() + "\"", e);
        }
    }
}
