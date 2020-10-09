package com.socialBookmarkingApp;

import com.socialBookmarkingApp.entities.Bookmark;
import com.socialBookmarkingApp.entities.User;
import com.socialBookmarkingApp.managers.BookmarkManager;
import com.socialBookmarkingApp.managers.UserManager;

import static com.socialBookmarkingApp.DataStore.loadData;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData(){
        System.out.println("1. Loading data");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println();
        printUserData();
        printBookmarkData();
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarklist : bookmarks){
            for (Bookmark bookmark:bookmarklist
                 ) {
                System.out.println(bookmark);
            }
        }
    }

    private static void printUserData() {
        for(User user : users){
            System.out.println(user);
        }
    }
    private static void startBookmarking() {
        System.out.println("1. Loading data");
        for (User user : users){
            View.browse(user,bookmarks);
        }
    }

    public static void main(String[] args) {
        loadData();
        startBookmarking();
    }


}
