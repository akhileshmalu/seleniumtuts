package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 */
public class HomePage {

    protected String baseUrl = "https://www.ebay.com";
    protected WebDriver driver;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public HomePage(WebDriver dr) {
        driver = dr;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        driver.get(baseUrl + "/");
    }

    public LoginPage navigateToSignInPage() {
        signInLink.click();
        return new LoginPage(driver);
    }

}
