package jd2.baggins.services;

import jd2.baggins.beans.Teammate;
import jd2.baggins.dao.TeammateDao;
import jd2.baggins.dao.TeammateHiberDao;

import java.util.List;

public class TeammateService implements BasicService<Teammate> {
    @Override
    public boolean add(Teammate teammate) {
        return false;
    }

    @Override
    public List<Teammate> getAll() {
        return new TeammateDao().getAll();
    }

    @Override
    public Teammate getById(int id) throws RuntimeException {
        return new TeammateHiberDao().getById(id);
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
