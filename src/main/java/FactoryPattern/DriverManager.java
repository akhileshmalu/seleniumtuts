package FactoryPattern;

import org.openqa.selenium.WebDriver;

/**
 * @author: Akhilesh Maloo
 * @date: 1/30/18.
 */
public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();


    public void quitDriver() {
        if(driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        if(driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }
}
