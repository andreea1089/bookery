package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String XPATH_LOGIN_BUTTON = "//button[@type='submit']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public DashBoardPage logInSuccessfully(String user, String password) {
        driver.findElement(By.id(USERNAME)).sendKeys(user);
        driver.findElement(By.id(PASSWORD)).sendKeys(password);
        driver.findElement(By.xpath(XPATH_LOGIN_BUTTON)).click();
        return new DashBoardPage(driver);
    }
}
