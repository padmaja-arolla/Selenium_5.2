package com.atm.modulefive.webdriver.advanced.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Decorator implements WebDriver {

    protected WebDriver driver;

    public Decorator(WebDriver driver) {
	this.driver = driver;
    }

    public void get(String url) {
	System.out.println("Browser will navigate to the URL: " + url);
	driver.get(url);
    }

    public String getCurrentUrl() {
	return driver.getCurrentUrl();
    }

    public String getTitle() {
	return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
	return driver.findElements(by);
    }

    public WebElement findElement(By by) {
	return driver.findElement(by);
    }

    public String getPageSource() {
	return driver.getPageSource();
    }

    public void close() {
	driver.close();

    }

    public void quit() {
	System.out.println("Closing the current driver instance");
	driver.quit();

    }

    public Set<String> getWindowHandles() {
	return driver.getWindowHandles();
    }

    public String getWindowHandle() {
	return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
	return driver.switchTo();
    }

    public Navigation navigate() {
	return driver.navigate();
    }

    public Options manage() {
	return driver.manage();
    }

}
