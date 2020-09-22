package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddBookPage extends BasePage{

    public static final String XPATH_INPUT_BOOK_FIELDS = "//input[@id='%s']";
    public static final String XPATH_ADD_BUTTON = "//li[@id='addEditBook']/button[@name='add']";
    public static final String XPATH_CANCEL_BUTTON = "//li[@id='addEditBook']/button[@name='cancel']";

    public AddBookPage(WebDriver driver) {
        super(driver);
    }

    public void fillBookInformation(String title, String author, String edition, Integer numberOfPages) {
        addValueToInput("title", title);
        addValueToInput("author", author);
        addValueToInput("edition", edition);
        addValueToInput("pages", numberOfPages);
    }

    public DashBoardPage add() {
        driver.findElement(By.xpath(XPATH_ADD_BUTTON)).click();
        return new DashBoardPage(driver);
    }

    public DashBoardPage cancel() {
        driver.findElement(By.xpath(XPATH_CANCEL_BUTTON)).click();
        return new DashBoardPage(driver);
    }

    /* --- Private methods --- */

    private void addValueToInput(String input, String value) {
        driver.findElement(By.xpath(String.format(XPATH_INPUT_BOOK_FIELDS, input))).sendKeys(value);
    }

    private void addValueToInput(String input, Integer value) {
        driver.findElement(By.xpath(String.format(XPATH_INPUT_BOOK_FIELDS, input))).sendKeys(String.valueOf(value));
    }
}
