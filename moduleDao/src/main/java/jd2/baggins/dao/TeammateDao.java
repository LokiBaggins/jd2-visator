package jd2.baggins.dao;

import jd2.baggins.beans.Teammate;
import jd2.baggins.exceptions.DaoException;
import jd2.baggins.utils.HibernateUtil;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

public class TeammateDao implements Dao<Teammate> {

    @Override
    public void add(Teammate teammate) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.save(teammate);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Teammate> getAll() throws DaoException {
        List<Teammate> tmList = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession();) {
            String queryString = "FROM Teammate";
            Query query = session.createQuery(queryString);
            tmList = query.list();
            session.flush();
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }

        return tmList;
    }

    @Override
    public Teammate getById(int id) throws DaoException {
        Teammate tm = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            String queryString = "FROM Teammate WHERE id = :id";
            Query query = session.createQuery(queryString);
//        Query query = session.createSQLQuery("Select * from t_teammates where c_id = :id");
            query.setInteger("id", id);
            tm = (Teammate) query.uniqueResult();
            session.flush();
        } catch (HibernateException e) {
            // TODO: log error
            throw new DaoException(e);
        }

        return tm;
    }

    @Override
    public void update(Teammate teammate) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.update(teammate);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(Teammate teammate) throws DaoException {
        try (Session session = HibernateUtil.getSessionFactory().openSession() ) {
            session.beginTransaction();
            session.delete(teammate);
            session.flush();
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            TODO: log error
            throw new DaoException(e);
        }
    }
}
