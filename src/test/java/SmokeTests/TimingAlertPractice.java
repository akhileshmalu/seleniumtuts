package SmokeTests;

import FactoryPattern.DriverManager;
import FactoryPattern.DriverManagerFactory;
import FactoryPattern.DriverType;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author: Akhilesh Maloo
 * @date: 2/5/18.
 */
public class TimingAlertPractice {

    WebDriver driver;
    DriverManager driverManager;


    @BeforeMethod
    public void setUp() {

        driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/popup.php");

    }

    @Test
    public void radioButtonCheck() {

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
