package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashBoardPage extends BasePage{
    private static final String XPATH_BOOKS_TABLE = "//table[contains(@class, 'table')]";
    private static final String XPATH_BOOKS = "//table[contains(@class, 'table')]//td/a[contains(@ng-click, 'editBook')]";
    private static final String XPATH_SEARCH_INPUT = "//input[contains(@class,'search')]";
    private static final String XPATH_GO_BUTTON = "//button[text()='go']";
    private static final String XPATH_GO_CLEAR = "//button[text()='clear']";
    private static final String XPATH_BOOK = XPATH_BOOKS + "[text()='%s ']";
    private static final String XPATH_BUTTON_PROGRESS = XPATH_BOOK + "/parent::td/following-sibling::td/a";
    private static final String XPATH_VALUE_PROGRESS = XPATH_BOOK + "/parent::td/following-sibling::td//div[contains(@class,'progress-bar')]";
    private static final String XPATH_VALUE_RATING = XPATH_BOOK + "/parent::td/following-sibling::td[3]";

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public String getProgressForBook(String bookName){
        return driver.findElement(By.xpath(String.format(XPATH_VALUE_PROGRESS, bookName))).getText();
    }

    public String getRatingValueForBook(String bookName){
        return driver.findElement(By.xpath(String.format(XPATH_VALUE_RATING, bookName))).getText();
    }



    public AddProgressPage clickOnProgressButtonForBook(String bookName) {
        driver.findElement(By.xpath(String.format(XPATH_BUTTON_PROGRESS, bookName))).click();
        return new AddProgressPage(driver);
    }

    public EditBookPage clicOnBookTitleToEdit(String bookName) {
        driver.findElement(By.xpath(String.format(XPATH_BOOK, bookName))).click();
        return new EditBookPage(driver);
    }

    public void clear() {
        driver.findElement(By.xpath(XPATH_GO_CLEAR)).click();
    }

    public void searchByText(String text) {
        WebElement search = driver.findElement(By.xpath(XPATH_SEARCH_INPUT));
        search.click();
        search.sendKeys(text);
        driver.findElement(By.xpath(XPATH_GO_BUTTON)).click();
    }

    public boolean isBooksTableDisplyed() {
        return driver.findElement(By.xpath(XPATH_BOOKS_TABLE)).isDisplayed();
    }

    public boolean isBookInTable(String bookname) {
        List<String> findedBooks = getBooksNames();
        for (String item : findedBooks) {
            if (item.equals(bookname)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSortingTypeAscending() {
        List<String> actualBookNamesOrder = getBooksNames();
        List<String> expectedBookNamesOrder = actualBookNamesOrder.stream().sorted(String::compareToIgnoreCase).collect(Collectors.toList());
        return actualBookNamesOrder.equals(expectedBookNamesOrder);
    }

    /* --- Private methods --- */

    private List<String> getBooksNames() {
        List<WebElement> books = driver.findElements(By.xpath(XPATH_BOOKS));
        List<String> actualBookNames = new ArrayList<>();
        for (WebElement book : books) {
            actualBookNames.add(book.getText());
        }
        return actualBookNames;
    }
}
