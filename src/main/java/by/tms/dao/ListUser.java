package by.tms.dao;


import by.tms.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ListUser implements UserDao {
    private static final List<User> users = new ArrayList<>();


    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean isExistUser(User user) {
        return users.contains(user);
    }

    @Override
    public List<User> getUsers() {
        return users;
    }



    @Override
    public User getUserByLogin(User user){
        return users.get(users.indexOf(user));
    }

    @Override

    public boolean updatePassword(User user, String password) {
        User user1 = users.get(users.indexOf(user));
        user1.setPassword(password);
        return true;
    }

    @Override
    public boolean updateName(User user, String name) {
        User user1 =users.get(users.indexOf(user));
        user1.setName(name);
        return true;
    }

}
