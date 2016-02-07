package jd2.baggins.dao;

import jd2.baggins.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

public interface Dao<T extends Serializable> {
    //TODO: add custom exceptions
    //TODO: add exception handling

    void add(T t) throws DaoException;

    List<T> getAll() throws DaoException;

    T getById(int id) throws DaoException;

    void update(T t) throws DaoException;

    void delete(T t) throws DaoException;
}
