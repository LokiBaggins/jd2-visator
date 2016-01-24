package jd2.baggins.dao;

import java.util.List;

public interface Dao<T> {
    //TODO: add custom exceptions
    //TODO: add exception handling

    boolean add(T t);

    List<T> getAll();

    T getById(int id);

    boolean update(T t);

    boolean delete(T t);
}
