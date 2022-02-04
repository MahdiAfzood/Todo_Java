package repository;

import exception.RuntimeSqlException;
import model.Task;
import model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface TaskRepository extends Repository<User> {

    boolean add(Task task);

    List<Task> findAll(int id_user);

    boolean update(Task task);


}
