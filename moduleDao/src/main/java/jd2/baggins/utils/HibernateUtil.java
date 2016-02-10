package jd2.baggins.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sf = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}
