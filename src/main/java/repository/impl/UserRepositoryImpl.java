package repository.impl;

import exception.RuntimeSqlException;
import model.User;
import repository.InitialConnection;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private Connection connection;

    public UserRepositoryImpl() {
        try{
            connection = InitialConnection.getInstance().getConnection();
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e);
        }

    }

    @Override
    public boolean add(User user){
        try{
            String add = "insert into user_1 values (default,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(add);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            return preparedStatement.executeUpdate() > 0;
        }catch(SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
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
    public User find(String username) {
        try {
            String find = """
                    select * from user_1 
                    where username = ?   
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(find);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(resultSet.getInt("id"),
                    resultSet.getString("first_name") ,
                    resultSet.getString("last_name") ,
                    resultSet.getString("username"),
                    resultSet.getString("password")) ;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean delete(String username) {

        try {
            String delete = "delete from user_1 where username = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setString(1, username);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean update(User user)  {

        try {
            String update = "update user_1 set first_name = ? , last_name = ? , password = ? where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getUsername());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeSqlException(e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

}
