package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public static final String XPATH_TABS = "//nav[contains(@class, 'navig')]//a[contains(@href, '%s')]";
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddBookPage goToAddBook(){
        driver.findElement(By.xpath(String.format(XPATH_TABS, "addBook"))).click();
        return new AddBookPage(driver);
    }

    public DashBoardPage goToDashboard(){
        driver.findElement(By.xpath(String.format(XPATH_TABS, "dashboard"))).click();
        return new DashBoardPage(driver);
    }
}
