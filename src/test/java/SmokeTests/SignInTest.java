package SmokeTests;

import FactoryPattern.DriverManager;
import FactoryPattern.DriverManagerFactory;
import FactoryPattern.DriverType;
import PageObjects.AccountPage;
import PageObjects.LoginPage;
import PageObjects.HomePage;
import org.openqa.selenium.By;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * @author: Akhilesh Maloo
 * @date: 1/26/18.
 */
public class SignInTest {
    private DriverManager driverManager;
    private WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accPage;

    @BeforeMethod
    @Parameters({"browser"})
    public  void setUp(String browser) {
        driverManager = DriverManagerFactory.getManager(DriverType.valueOf(browser.toUpperCase(Locale.ENGLISH)));
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    private LoginPage navigateToSignInPage() {
        HomePage homepage = new HomePage(driver);
        return homepage.navigateToSignInPage();
    }

    @Test
    public void invalidCredSignIn(){
        String user = "priya.somani@rediffmail.com",
                pass = "Test@123";
        loginPage = navigateToSignInPage();
        loginPage = loginPage.signWrong(user, pass);
        Assert.assertTrue(loginPage.errorOccured());
    }

    @Test
    public void ValidCredentialsignInTest() {

        String user = "priya.somani@rediffmail.com",
                pass = "Priya@123";
        loginPage = navigateToSignInPage();
        accPage = loginPage.signIn(user, pass);
        Assert.assertTrue(accPage.isAccountProfilebtnVisible());
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
//        driverManager.quitDriver();
    }

}
