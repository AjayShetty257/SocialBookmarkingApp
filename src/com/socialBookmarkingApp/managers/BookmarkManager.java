package com.socialBookmarkingApp.managers;

import com.socialBookmarkingApp.Dao.BookmarkDao;
import com.socialBookmarkingApp.entities.*;

public class BookmarkManager {
    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManager() {}

    public static BookmarkManager getInstance(){
        return instance;
    }

    public Movie createMovie(long id, String title, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating){
        Movie movie = new Movie();
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);
        movie.setId(id);
        movie.setTitle(title);
        return movie;
    }
    public Book createBook(long id,String title,int publicationYear,String publisher,String[] authors,String genre,double amazonRating){
        Book book = new Book();
        book.setPublicationYear(publicationYear);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);
        book.setId(id);
        book.setTitle(title);
        return book;
    }
    public Weblink createWeblink(long id,String title,String url,String host){
        Weblink weblink = new Weblink();
        weblink.setUrl(url);
        weblink.setHost(host);
        weblink.setId(id);
        weblink.setTitle(title);
        return weblink;
    }
    public Bookmark[][] getBookmarks(){
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user,String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("kid - friendly status"+kidFriendlyStatus+","+bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);
        System.out.println("Data to be shared: ");
        if (bookmark instanceof Book){
            System.out.println(((Book) bookmark).getItemData());
        }
        else if (bookmark instanceof Weblink){
            System.out.println(((Weblink) bookmark).getItemData());
        }
    }
}
