package FactoryPattern;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * @author: Akhilesh Maloo
 * @date: 1/30/18.
 */
public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chromeService;

    protected void startService() {

        if(chromeService == null) {
            try {
//                System.setProperty("webdriver.chrome.driver", "/opt/marionette/chromedriver");
                chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("/opt/marionette/chromedriver"))
                        .usingAnyFreePort()
                        .build();
                chromeService.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    protected void stopService() {
        if(chromeService != null && chromeService.isRunning()) {
            chromeService.stop();
        }

    }

    protected void createDriver() {

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        driver = new ChromeDriver(chromeService, options);
    }
}
