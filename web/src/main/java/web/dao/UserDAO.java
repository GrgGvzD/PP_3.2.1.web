package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
    public User getUserById(long id);
    public void deleteUserById(long id);
    public void updateUser(User user);
    public void addUser(User user);
}
