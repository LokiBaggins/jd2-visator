package jd2.baggins.dao;

import jd2.baggins.beans.Teammate;
import jd2.baggins.exceptions.DaoException;
import jd2.baggins.hibernate.HibernateUtil;
import org.hibernate.*;

import java.util.List;

public class TeammateHiberDao implements Dao<Teammate> {

    @Override
    public boolean add(Teammate teammate) throws DaoException {
        return false;
    }

    @Override
    public List<Teammate> getAll() throws DaoException {
        return null;
    }

    @Override
    public Teammate getById(int id) throws DaoException {
        Teammate tm = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            String queryString = "FROM Teammate WHERE id = :id";
            Query query = session.createQuery(queryString);
//        Query query = session.createSQLQuery("Select * from t_teammates where c_id = :id");
            query.setInteger("id", id);
            tm = (Teammate) query.uniqueResult();
            session.flush();
            session.close();
            return tm;
        } catch (HibernateException e) {
            if(transaction != null) {
                transaction.rollback();
            }
            throw new DaoException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Teammate teammate) throws DaoException {
        return false;
    }

    @Override
    public boolean delete(Teammate teammate) throws DaoException {
        return false;
    }
}
