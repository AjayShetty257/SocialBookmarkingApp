import com.socialBookmarkingApp.entities.Weblink;
import com.socialBookmarkingApp.managers.BookmarkManager;
import org.junit.Assert;
import org.junit.Test;


public class WeblinkTest {
    @Test
    public void testIsKidFriendly(){
        // test 1 porn in url - return false

        
        Class<Weblink> t = Weblink.class;

        Weblink webLink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.porn.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        Assert.assertFalse("test 1 porn in url - return false",isKidFriendlyEligible);
        // test 2 porn in title false
         webLink = BookmarkManager.getInstance().createWeblink(2000,"porn Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
         isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        Assert.assertFalse("porn in title - return false",isKidFriendlyEligible);

        // test 3 adult in host false
        webLink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.adult.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        Assert.assertFalse("adult in host-return false",isKidFriendlyEligible);

        // test 4 adult in url but not host part true
        webLink = BookmarkManager.getInstance().createWeblink(2000,"Taming Tiger, Part 2","http://www.adult.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        Assert.assertTrue("adult in url but not host part - return true",isKidFriendlyEligible);

        // test 5 adult in title only true
        webLink = BookmarkManager.getInstance().createWeblink(2000,"adult Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();

        Assert.assertTrue("adult in title only return true",isKidFriendlyEligible);
    }
}
