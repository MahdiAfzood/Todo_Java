package service.impl;

import model.Status;
import model.Task;
import model.User;
import repository.TaskRepository;
import repository.impl.TaskRepositoryImpl;
import service.TaskService;

import java.sql.Timestamp;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository ;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public boolean add(String context , Status status , Timestamp time , User user) {
        taskRepository = new TaskRepositoryImpl();
        Task task = new Task(-1 , context , status , time , user ) ;
        return taskRepository.add(task);
    }

    public List<Task> findAll(int id_user) {
        taskRepository = new TaskRepositoryImpl();
        return taskRepository.findAll(id_user);
    }

    public boolean delete(int id) {
        taskRepository = new TaskRepositoryImpl();
        return  taskRepository.delete(id);
    }

    public boolean update(Task task) {
        taskRepository = new TaskRepositoryImpl();
        return  taskRepository.update(task);
    }


}
