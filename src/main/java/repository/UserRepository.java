package repository;

import model.User;

public interface UserRepository extends Repository<User> {

    User find(String username);

    boolean delete(String username);

}
