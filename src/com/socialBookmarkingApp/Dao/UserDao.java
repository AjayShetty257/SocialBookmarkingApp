package com.socialBookmarkingApp.Dao;

import com.socialBookmarkingApp.DataStore;
import com.socialBookmarkingApp.entities.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
