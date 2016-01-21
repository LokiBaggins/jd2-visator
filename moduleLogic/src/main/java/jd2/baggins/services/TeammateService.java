package jd2.baggins.services;

import beans.Teammate;
import jd2.baggins.TeammateDao;

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
    public Teammate getById(int id) {
        return null;
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
