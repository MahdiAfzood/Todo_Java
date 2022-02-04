package view;

import exception.RuntimeSqlException;
import model.Status;
import model.User;
import repository.TaskRepository;
import repository.UserRepository;
import repository.impl.TaskRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import service.TaskService;
import service.UserService;
import service.impl.TaskServiceImpl;
import service.impl.UserServiceImpl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

public class main {


    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        TaskRepository taskRepository = new TaskRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        TaskService taskService = new TaskServiceImpl(taskRepository);

        try {
            /*userService.add("ali" , "ali" , "a" , "a");
            userService.add("ahmad" , "ahmad","b" , "b");*/
            System.out.println(userService.find("b").toString());
            User user1 = userService.find("b");
            taskService.add("sjdflkjslkdfj", Status.doing,new Timestamp(Calendar.getInstance().getTimeInMillis()),user1);
        } catch (RuntimeSqlException e) {
            e.printStackTrace();
        }

    }

}
