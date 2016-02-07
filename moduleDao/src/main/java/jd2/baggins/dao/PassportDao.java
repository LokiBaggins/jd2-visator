package jd2.baggins.dao;

import jd2.baggins.beans.Passport;
import jd2.baggins.exceptions.DaoException;
import jd2.baggins.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class PassportDao implements Dao<Passport> {
    
    @Override
    public void add(Passport passport) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.save(passport);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }
    
    @Override
    public List<Passport> getAll() throws DaoException {
        List<Passport> passList = new ArrayList<>();
        
        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            String queryString = "FROM Passport";
            Query query = session.createQuery(queryString);
            passList = query.list();
            session.flush();
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }
        
        return passList;
    }
    
    @Override
    public Passport getById(int id) throws DaoException {
        Passport tm = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            String queryString = "FROM Passport WHERE id = :id";
            Query query = session.createQuery(queryString);
//        Query query = session.createSQLQuery("Select * from t_passports where c_id = :id");
            query.setInteger("id", id);
            tm = (Passport) query.uniqueResult();
            session.flush();
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }
        
        return tm;
    }
    
    @Override
    public void update(Passport passport) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.update(passport);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }
    
    @Override
    public void delete(Passport passport) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.delete(passport);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }
}
