package FactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author: Akhilesh Maloo
 * @date: 1/30/18.
 */
public class FireFoxDriverManager extends DriverManager {

    protected void startService() {
        // extra service configuration
        System.setProperty("webdriver.gecko.driver", "/opt/marionette/geckodriver");
    }

    protected void stopService() {
        // does not require extra service configuration
    }

    protected void createDriver() {
        if (driver == null) {

            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            FirefoxOptions options = new FirefoxOptions();
            options.merge(capabilities);
            driver = new FirefoxDriver(options);

        }
    }
}
