package FactoryPattern;

import java.util.Locale;

/**
 * @author: Akhilesh Maloo
 * @date: 1/30/18.
 */
public enum DriverType {
    CHROME("Chrome"),
    FIREFOX("FireFox"),
    IE("Internet Explorer"),
    SAFARI("Safari");

    private final String driverName;

    DriverType(String name) {
        this.driverName = name;
    }

    @Override
    public String toString() {
        return driverName;
    }

}
