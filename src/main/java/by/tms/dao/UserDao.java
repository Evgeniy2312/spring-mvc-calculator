package by.tms.dao;

import by.tms.entity.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);

    public boolean isExistUser(User user);

    public List<User> getUsers();

    public User getUserByLogin(User user);

    public boolean updatePassword(User user, String password);

    public boolean updateName(User user,String name);

}
