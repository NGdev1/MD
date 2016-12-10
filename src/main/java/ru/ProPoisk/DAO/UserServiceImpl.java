package ru.ProPoisk.DAO;

import ru.ProPoisk.models.User;

/**
 * Created by apple on 22.08.16.
 */
public class UserServiceImpl implements UserService {

    UserDao myDAO;

    public UserServiceImpl(UserDao userDao){
        myDAO = userDao;
    }

    public boolean isRegistered(String userName) {
        User[] allUsers = myDAO.getAll();

        for(User user : allUsers) {
            if (user.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
