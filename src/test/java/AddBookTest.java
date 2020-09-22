import org.junit.jupiter.api.Test;
import pages.AddBookPage;
import pages.BasePage;
import pages.DashBoardPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddBookTest extends BaseTest {
    AddBookPage bookPage;
    BasePage page;

    @Test
    public void addBook() {
        page = new BasePage(getDriver());
        bookPage = page.goToAddBook();
        bookPage.fillBookInformation("zz", "x", "2019", 100);
        bookPage.add();
        assertTrue(dashBoardPage.isBookInTable("zz"), "Book is not in list");
    }

    @Test
    public void cancelAddingBook() {
        page = new BasePage(getDriver());
        bookPage = page.goToAddBook();
        bookPage.fillBookInformation("The Book", "Unknown", "256", 200);
        bookPage.cancel();
        assertFalse(dashBoardPage.isBookInTable("The Book"), "Book is not in list");
    }

}