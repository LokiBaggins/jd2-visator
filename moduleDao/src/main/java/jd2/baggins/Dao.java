package jd2.baggins;

import java.util.List;

public interface Dao<T> {
    boolean add(T t);

    List<T> getAll();

    T getById(int id);

    boolean update(T t);

    boolean delete(T t);
}
