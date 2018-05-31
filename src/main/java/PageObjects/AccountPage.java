package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 */
public class AccountPage {

    WebDriver driver;

    @FindBy(id="gh-ug")
    WebElement accountProfileBtn;

    @FindBy(id="gh-btn")
    WebElement searchBtn;

    @FindBy(id = "gh-ac")
    WebElement searchBox;


    AccountPage(WebDriver dr) {
        this.driver = dr;
        PageFactory.initElements(driver, this);

//        if (!driver.getTitle().equals("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")) {
//            throw new WrongPageException("Incorrect page Account");
//        }
    }

    public boolean isAccountProfilebtnVisible() {
        return accountProfileBtn.isDisplayed();
    }

    public void setSearchBoxValue(String item) {
        searchBox.clear();
        searchBox.sendKeys(item);
    }

    public SearchPage searchItem(String item) {
        setSearchBoxValue(item);
        searchBtn.click();

        return new SearchPage(driver);
    }

}
