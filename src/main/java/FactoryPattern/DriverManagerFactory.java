package FactoryPattern;

/**
 * @author: Akhilesh Maloo
 * @date: 1/30/18.
 */
public class DriverManagerFactory {

    public static DriverManager getManager(DriverType browser) {

        DriverManager driverManager;

        switch (browser) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
        }

        return driverManager;

    }
}
