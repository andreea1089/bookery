package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditBookPage extends BasePage {
    public static final String XPATH_INPUT_BOOK_FIELDS = "//input[@id='%s']";
    public static final String XPATH_SAVE_BUTTON = "//button[@name='save']";
    public static final String XPATH_DELETE_BUTTON = "//button[@name='delete']";
    public static final String XPATH_CANCEL_BUTTON = "//button[@name='cancel']";
    WebElement element;

    public EditBookPage(WebDriver driver) {
        super(driver);
    }

    public void editInputWithNewValue(String inputField, String newValue) {
        element = driver.findElement(By.xpath(String.format(XPATH_INPUT_BOOK_FIELDS, inputField)));
        // un mic wait
        element.clear();
        element.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        element.sendKeys(newValue);
    }

    public DashBoardPage saveEditedBook() {
        driver.findElement(By.xpath(XPATH_SAVE_BUTTON)).click();
        return new DashBoardPage(driver);
    }

    public DashBoardPage cancelEditBook() {
        driver.findElement(By.xpath(XPATH_CANCEL_BUTTON)).click();
        return new DashBoardPage(driver);
    }

    public DashBoardPage deleteBook() {
        driver.findElement(By.xpath(XPATH_DELETE_BUTTON)).click();
        return new DashBoardPage(driver);
    }
}
