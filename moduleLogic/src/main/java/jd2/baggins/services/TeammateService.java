package jd2.baggins.services;

import jd2.baggins.beans.Teammate;
import jd2.baggins.dao.GenericDao;
import jd2.baggins.dao.TeammateDao;

import java.util.List;

public class TeammateService implements BasicService<Teammate> {
    @Override
    public boolean add(Teammate teammate) {
        return false;
    }

    @Override
    public List<Teammate> getAll() {
        return new GenericDao<>(Teammate.class).getAll();
    }

    @Override
    public Teammate getById(int id) throws RuntimeException {
//        return new TeammateDao().getById(id);
        return new GenericDao<>(Teammate.class).getById(id);
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
