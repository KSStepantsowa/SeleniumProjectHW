package staticpageobjectHW;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties locators;

    static {
        InputStream is = Locators.class.getResourceAsStream("/locators.properties");

        try {
            locators.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from property file");
        }
    }

    public static By getLocator(String elementName) {
        String locatorText = locators.getProperty(elementName);

        String[] fullLocator = locatorText.split("=", 2);
        String locatorValue = fullLocator[1];
        By by = switch (LocatorType.valueOf(fullLocator[0])) {
            case id -> By.id(locatorValue);
            case name -> By.name(locatorValue);
            case className -> By.className(locatorValue);
            case tagName -> By.tagName(locatorValue);
            case linkText -> By.linkText(locatorValue);
            case css -> By.cssSelector(locatorValue);
            case xpath -> By.xpath(locatorValue);
        };
        return by;
    }
}
