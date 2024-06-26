package pl.czarymary.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;  // Dodane

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class SeleniumHelper {

    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    public static void waitForVisibility(WebElement el, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    public static void waitForInvisible(WebElement el, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOf(el));
    }

    public static void scrollToViewElement(WebElement el, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", el);
    }

    public static void executorClick(WebElement el, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
    }

    public static void waitForUrlNotContains(String url, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        wait.until(ExpectedConditions.not(urlContains(url)));
    }
}