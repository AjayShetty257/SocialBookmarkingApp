package com.socialBookmarkingApp.Dao;

import com.socialBookmarkingApp.DataStore;
import com.socialBookmarkingApp.entities.Bookmark;
import com.socialBookmarkingApp.entities.UserBookmark;

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
