package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class AddProgressPage extends BasePage{
    private static final String XPATH_RATING_DROPDOWN = "//select[@id='selectRating']";
    private static final String XPATH_RATING_OPTIONS = XPATH_RATING_DROPDOWN + "/option";
    private static final String XPATH_PAGES = "//input[@id='pages']";
    private static final String XPATH_PROGRESS = "//input[@id='progress']";
    private static final String XPATH_REVIEW = "//textarea[@id='textAreaProgress']";
    public static final String XPATH_BUTTON = "//button[@name='%s']";


    public AddProgressPage(WebDriver driver) {
        super(driver);
    }

    public void selectOptionInRatingDropdown(String option){
        Select raiting = new Select(driver.findElement(By.xpath(XPATH_RATING_DROPDOWN)));
        raiting.selectByValue(option);
    }

    public DashBoardPage saveProgress(){
        driver.findElement(By.xpath(String.format(XPATH_BUTTON, "save"))).click();
        return new DashBoardPage(driver);
    }

    public DashBoardPage cancelProgress(){
        driver.findElement(By.xpath(String.format(XPATH_BUTTON, "cancel"))).click();
        return new DashBoardPage(driver);
    }

    public String getSelectedOptionInRaiting() {
        Select raiting = new Select(driver.findElement(By.xpath(XPATH_RATING_DROPDOWN)));
        return raiting.getFirstSelectedOption().getText();
    }

    public List<String> getOptionsAvailableInRating(){
        return driver.findElements(By.xpath(XPATH_RATING_OPTIONS)).stream().map(option -> option.getText()).collect(Collectors.toList());
    }
}
