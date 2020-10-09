package com.socialBookmarkingApp.entities;

import com.socialBookmarkingApp.managers.BookmarkManager;
import org.junit.Assert;
import org.junit.Test;

public class BookTest {
    @Test
    public void testIsKidFriendly() {

        // philosophy
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, "Philosophy", 4.3);
        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

        Assert.assertFalse("book is philosophy - return false", isKidFriendlyEligible);

        // self help
        book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[]{"Henry David Thoreau"}, "self help", 4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();

        Assert.assertFalse("book is self help - return false", isKidFriendlyEligible);
    }
}