package jd2.baggins.dao;

import jd2.baggins.exceptions.DaoException;

import java.util.List;

public interface Dao<T> {
    //TODO: add custom exceptions
    //TODO: add exception handling

    boolean add(T t) throws DaoException;

    List<T> getAll() throws DaoException;

    T getById(int id) throws DaoException;

    boolean update(T t) throws DaoException;

    boolean delete(T t) throws DaoException;
}
