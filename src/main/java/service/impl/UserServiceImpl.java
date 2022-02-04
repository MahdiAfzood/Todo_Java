package service.impl;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository ;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add(String firstName , String lastName , String username , String password) {
        userRepository = new UserRepositoryImpl();
        User user = new User(-1 , firstName , lastName , username , password ) ;
        return userRepository.add(user);
    }

    public User find(String username)  {
        userRepository = new UserRepositoryImpl();
        return userRepository.find(username);
    }

    public boolean delete(String username) {
        userRepository = new UserRepositoryImpl();
        return  userRepository.delete(username);
    }

    public boolean update(User user)  {
        userRepository = new UserRepositoryImpl();
        return  userRepository.update(user);
    }
}
