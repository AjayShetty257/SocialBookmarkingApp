package com.socialBookmarkingApp.entities;

import com.socialBookmarkingApp.managers.BookmarkManager;
import org.junit.Assert;
import org.junit.Test;

public class MovieTest {
    @Test
    public void testIsKidFriendly() {
        // test 1 thriller
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Classics", 8.5);
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

        Assert.assertFalse("movie is thriller - return false", isKidFriendlyEligible);
        // test 2 horror
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", 1941, new String[]{"Orson Welles", "Joseph Cotten"}, new String[]{"Orson Welles"}, "Classics", 8.5);
        isKidFriendlyEligible = movie.isKidFriendlyEligible();

        Assert.assertFalse("movie is horror - return false", isKidFriendlyEligible);
    }
}