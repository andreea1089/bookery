import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DashBoardPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashBoardTest extends BaseTest {

    @Test
    public void verifyTableIsDisplyed() {
        assertTrue(dashBoardPage.isBooksTableDisplyed(), "Table is not displyed.");
    }

    @DisplayName("Verify books list is sorted ascending by default")
    @Test
    public void verifyBooksAreSortedAscending() {
        assertTrue(dashBoardPage.isSortingTypeAscending(), "Books are not in ascending order.");
    }

    @Test
    public void verifyBookIsDisplyedInTable() {
        String bookTitle = "5656";
        dashBoardPage.searchByText(bookTitle);
        assertTrue(dashBoardPage.isBookInTable(bookTitle), "Book " + bookTitle + " is not in list.");
    }

    @Test
    public void verifyProgressForBook(){
        String bookTitle = "abb";
        assertEquals("2%", dashBoardPage.getProgressForBook(bookTitle), "Progress value is not as expeced.");
    }
}