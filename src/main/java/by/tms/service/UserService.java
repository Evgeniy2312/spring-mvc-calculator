package by.tms.service;

import by.tms.dao.ListUser;
import by.tms.dao.UserDao;
import by.tms.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(ListUser listUser) {
        this.userDao = listUser;
    }

    public boolean save(User user){
        if(!userDao.isExistUser(user)){
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    public Optional<User> findByUsername(User user){
        if(userDao.isExistUser(user)){
            return Optional.of(userDao.getUserByLogin(user));
        }else return Optional.empty();
    }

    public boolean updatePassword(User user, String newPassword, String oldPassword) {
        if (user.getPassword().equals(oldPassword) && !oldPassword.equals(newPassword)) {
            return userDao.updatePassword(user, newPassword);
        }else return false;
    }



    public boolean updateName(User user, String name){
        if(!user.getName().equals(name)) {
            return userDao.updateName(user, name);
        }else return false;
    }
}
