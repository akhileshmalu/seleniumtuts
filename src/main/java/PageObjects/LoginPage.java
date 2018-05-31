package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 */
public class LoginPage {

    WebDriver driver;

    @FindBy(id="userid")
    WebElement userId;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(id="sgnBt")
    WebElement signInBtn;

    @FindBy(id="errf")
    WebElement error ;


    LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        if (!driver.getTitle().equals("Sign in or Register | eBay")){
            throw new WrongPageException("Incorrect page Sign In");
        }

    }

    public void setUserId(String name) {
        userId.clear();
        userId.sendKeys(name);
    }

    public void setPassword(String name) {
        password.clear();
        password.sendKeys(name);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

    public boolean errorOccured() {
        return error.isDisplayed();
    }


    public AccountPage signIn(String username, String pass) {
        setUserId(username);
        setPassword(pass);
        signInBtn.click();

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-ug")));

        return new AccountPage(driver);
    }

    public LoginPage signWrong(String username, String pass) {
        setUserId(username);
        setPassword(pass);
        signInBtn.click();

        return this;
    }



}