import org.junit.jupiter.api.Test;
import pages.DashBoardPage;
import pages.EditBookPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteBookTest extends BaseTest {
    EditBookPage editPage;

    @Test
    public void deleteBook() {
        String bookName = "zz";
        editPage = dashBoardPage.clicOnBookTitleToEdit(bookName);
        editPage.deleteBook();
        assertFalse(dashBoardPage.isBookInTable(bookName));
    }
}
