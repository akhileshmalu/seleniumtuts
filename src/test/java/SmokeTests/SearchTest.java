package SmokeTests;

import FactoryPattern.DriverManager;
import FactoryPattern.DriverManagerFactory;
import FactoryPattern.DriverType;
import PageObjects.AccountPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchPage;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;


/**
 * @author: Akhilesh Maloo
 * @date: 1/31/18.
 */
public class SearchTest {

    WebDriver driver;
    DriverManager driverManager;
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    SearchPage searchPage;


    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser){
        driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase(Locale.ENGLISH)));
        driver = driverManager.getDriver();
    }

    private AccountPage navigateToAccountPage(String user, String pass) {
        homePage = new HomePage(driver);
        loginPage = homePage.navigateToSignInPage();
        return loginPage.signIn(user,pass);
    }


    private boolean verifyAllLinks(String path) {
        try {

            URL link = new URL(path);
            HttpURLConnection connection = (HttpURLConnection)link.openConnection();
            connection.setConnectTimeout(2000);
            connection.connect();

            if(connection.getResponseCode() == 200) {
                System.out.println(path + " - " + connection.getResponseMessage());
                return true;
            } else {
                System.out.println(" Link is Broken - " + connection.getResponseMessage());
            }

        } catch (Exception e) {

            System.out.println("Error while opening connection");
        }
        return false;
    }

    @Test(enabled = false)
    public void checkBrokenLinks() {
        homePage = new HomePage(driver);
        boolean notBroken = true;
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String href = link.getAttribute("href");
            notBroken &= verifyAllLinks(href);
        }
        Assert.assertTrue(notBroken);
    }


    @Test
    @Parameters({"validUser","validPass"})
    public void validValueSearchBox(String user, String pass) throws Exception {

        String itemName = "iphone 6";
        accountPage = navigateToAccountPage(user, pass);
        searchPage = accountPage.searchItem(itemName);
        Assert.assertTrue(searchPage.getSearchStatusForProduct().equalsIgnoreCase(itemName));

    }

    /*
    @DataProvider(name = "getSearchData")
    public Object[][] getSearchItem() {
        return new Object[][] {
                {"iphone 6"},
                {"samsung galaxy"}
        };
    }*/

    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {

        /* 1. take screenshots

        if(result.getStatus() == ITestResult.FAILURE) {


            //Screenshot code below
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File(System.getProperty("user.dir")
                        + "/target/FailedScreenShots/" + result.getName() + ".png"));

            } catch (Exception e) {
                System.out.println("Exception while taking a screenshot");
            }
        }
        */


        driver.quit();
    }
}
