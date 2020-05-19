package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public boolean isNotReg(String name);

    public User getUserByName(String name);
}
