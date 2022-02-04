package repository.impl;

import exception.RuntimeSqlException;
import model.Status;
import model.Task;
import model.User;
import repository.InitialConnection;
import repository.TaskRepository;

import javax.management.RuntimeMBeanException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private Connection connection;

    public TaskRepositoryImpl() {

        try {
            connection = InitialConnection.getInstance().getConnection();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean add(Task task) {
        try {
            String add = "insert into task values (default,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setInt(1, task.getUser().getId());
            preparedStatement.setString(2, task.getContent());
            preparedStatement.setString(3, task.getStatus().name());
            preparedStatement.setTimestamp(4, task.getTimestamp());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public List<Task> findAll(int id_user)  {
        try {
            String find = """
                    select * from task 
                    where id_user = ?   
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Task> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(new Task(resultSet.getInt("id"),
                        resultSet.getString("content"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getTimestamp("doing_time"),
                        null
                ));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            String delete = "delete from task where id = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean update(Task task)  {
        try {
            String update = "update task set content = ? , status = ? , doing_time = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, task.getContent());
            preparedStatement.setString(2, task.getStatus().name());
            preparedStatement.setTimestamp(3, task.getTimestamp());
            preparedStatement.setInt(4, task.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }


}
