package pl.bee.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pl.czarymary.utils.PropertiesLoader;

import java.io.IOException;

public class DriverFactory {

    public static WebDriver getDriver() throws IOException {

        String browser = PropertiesLoader.loadProperty("browser.name");

        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else
            WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }
}

