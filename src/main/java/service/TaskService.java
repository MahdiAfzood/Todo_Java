package service;

import model.Status;
import model.Task;
import model.User;

import java.sql.Timestamp;
import java.util.List;

public interface TaskService {

    boolean add(String context, Status status, Timestamp time, User user);

    List<Task> findAll(int id_user);

    boolean delete(int id);

    boolean update(Task task);

}
