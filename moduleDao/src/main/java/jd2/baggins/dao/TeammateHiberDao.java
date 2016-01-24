package jd2.baggins.dao;

import jd2.baggins.beans.Teammate;
import jd2.baggins.hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TeammateHiberDao implements Dao<Teammate> {

    @Override
    public boolean add(Teammate teammate) {
        return false;
    }

    @Override
    public List<Teammate> getAll() {

        return null;
    }

    @Override
    public Teammate getById(int id) {
        Teammate tm = null;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String queryString = "FROM Teammate WHERE id = :id";
        Query query = session.createQuery(queryString);
//        Query query = session.createSQLQuery("Select * from t_teammates where c_id = :id");
        query.setInteger("id", id);
        tm = (Teammate) query.uniqueResult();
        session.flush();
        session.close();
        return tm;
    }

    @Override
    public boolean update(Teammate teammate) {
        return false;
    }

    @Override
    public boolean delete(Teammate teammate) {
        return false;
    }
}
