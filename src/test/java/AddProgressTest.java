import org.junit.jupiter.api.Test;
import pages.AddProgressPage;
import pages.DashBoardPage;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddProgressTest extends BaseTest {
    AddProgressPage progressPage;

    @Test
    public void verifySelecteOptionInRatingDropdown() {
        String bookName = "rar";
        progressPage = dashBoardPage.clickOnProgressButtonForBook(bookName);
        assertEquals("0", progressPage.getSelectedOptionInRaiting());
    }

    @Test
    public void verifyOptionsInRatingDropdown(){
        List<String> expectedOptions = Arrays.asList("N/A", "1", "2", "3", "4", "5");
        String bookName = "rar";
        progressPage = dashBoardPage.clickOnProgressButtonForBook(bookName);
        assertEquals(expectedOptions, progressPage.getOptionsAvailableInRating(), "Options are not as expected");
    }

    @Test
    public void selectOptionInRaitingAndSave() {
        String bookName = "rar";
        progressPage = dashBoardPage.clickOnProgressButtonForBook(bookName);
        progressPage.selectOptionInRatingDropdown("3");
        progressPage.saveProgress();
        assertEquals("3", dashBoardPage.getRatingValueForBook(bookName), "Progress for book " + bookName + " is not as expected");
    }
}