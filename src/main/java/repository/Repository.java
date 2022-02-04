package repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    boolean add(T t);

    T find(int id);

    List<T> findAll();

    boolean update(T t);

    boolean delete(int id);

}
