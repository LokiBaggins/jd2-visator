package jd2.baggins.dao;

import jd2.baggins.exceptions.DaoException;
import jd2.baggins.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericDao<T extends Serializable>
        implements Dao<T> {

    private Class<T> type;

    public GenericDao(Class<T> type) {
        this.type = type;
    }

    @Override
    public void add(T t) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.save(t);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }
    
    @Override
    public List<T> getAll() throws DaoException {
        List<T> tList = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tList = session.createCriteria(type).list();
            session.flush();
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }
        
        return tList;
    }
    
    @Override
    public T getById(int id) throws DaoException {
        T t = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            t = session.get(type, id);
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }
        
        return t;
    }
    
    @Override
    public void update(T t) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.saveOrUpdate(t);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }
    
    @Override
    public void delete(T t) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.delete(t);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }

}
