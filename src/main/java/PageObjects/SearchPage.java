package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author: Akhilesh Maloo
 * @date: 1/31/18.
 */
public class SearchPage extends AccountPage {

    //WebDriver driver;

    @FindBy(xpath = "//div[@class='clt']//span[@class='kwcat']/b")
    WebElement searchStatus;


    SearchPage(WebDriver dr) {
        super(dr);
        PageFactory.initElements(driver, this);
    }

    public String getSearchStatusForProduct() {
        return searchStatus.getText();
    }


}
