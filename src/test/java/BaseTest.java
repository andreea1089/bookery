import com.google.common.io.Files;
import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.engine.TestExecutionResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.BasePage;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.PropertyFileManager;
import utils.WebDriverManager;


import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest implements TestWatcher {
    private LoginPage loginPage;
    private WebDriverManager webDriverManager = new WebDriverManager();
    private PropertyFileManager propertyFileManager = PropertyFileManager.getInstance();

    private String password = propertyFileManager.getPassword();
    private String user = propertyFileManager.getUserName();
    private String url = propertyFileManager.getUrl();
    DashBoardPage dashBoardPage;

    @BeforeEach
    public void loginToBookery() {
        webDriverManager.initializeDriver();
        loginPage = new LoginPage(getDriver());
        getDriver().get(url);
        dashBoardPage = loginPage.logInSuccessfully(user, password);
    }

    @AfterEach
    public void closeDriver() {

//        TakesScreenshot takesScreenshot = (TakesScreenshot)getDriver();
//        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        try {
//            Files.move(screenshot, new File("D://bookery//src//test//resources//screenshots//test.png" ));
//        } catch (IOException e) {
//            e.printStackTrace();
//        };
        getDriver().close();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Blalalalallalalalalalala");

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
                TakesScreenshot takesScreenshot = (TakesScreenshot)getDriver();
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("D://bookery//src//test//resources//screenshots//test.png" ));
        } catch (IOException e) {
            e.printStackTrace();
        };
        System.out.println("YESSSSSSS");
    }

    public WebDriver getDriver() {
        return webDriverManager.getDriver();
    }
}
