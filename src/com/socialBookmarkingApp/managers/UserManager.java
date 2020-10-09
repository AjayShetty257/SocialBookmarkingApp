package com.socialBookmarkingApp.managers;

import com.socialBookmarkingApp.Dao.UserDao;
import com.socialBookmarkingApp.entities.Bookmark;
import com.socialBookmarkingApp.entities.User;

public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();
    private UserManager(){}

    public static UserManager getInstance(){
       return instance;
    }
    public User createUser(long id,String email,String password,String firstName,String lastName,int gender,String userType){
        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setGender(gender);
        user.setId(id);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setUserType(userType);

        return user;
    }
    public User[] getUsers(){
        return dao.getUsers();
    }


}
