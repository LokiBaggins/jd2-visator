package jd2.baggins.services;

import java.util.List;

public interface BasicService<T> {
    boolean add(T t);

    List<T> getAll();

    T getById(int id);

    boolean update(T t);

    boolean delete(T t);
}
