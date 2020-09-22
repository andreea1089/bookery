import org.junit.jupiter.api.Test;
import pages.DashBoardPage;
import pages.EditBookPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditBookTest extends BaseTest {
    EditBookPage editPage;

    @Test
    public void editBook() {
        String bookName = "zz";
        editPage = dashBoardPage.clicOnBookTitleToEdit(bookName);
        editPage.editInputWithNewValue("author", "123456");
        editPage.saveEditedBook();
        dashBoardPage.searchByText("12456");
        assertTrue(dashBoardPage.isBookInTable(bookName), "Book " + bookName + " is not in table.");
    }
}
