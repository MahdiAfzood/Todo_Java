package service;

import model.User;

public interface UserService {

    boolean add(String firstName, String lastName, String username, String password);

    User find(String username);

    boolean delete(String username);

    boolean update(User user);

}
