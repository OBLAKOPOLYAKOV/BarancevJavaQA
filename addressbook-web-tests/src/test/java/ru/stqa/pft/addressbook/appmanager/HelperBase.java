package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(String locator) {
        wd.findElement(By.name(locator)).click();
    }

    protected void type(String locator, String text) {
        click(locator);
        wd.findElement(By.name(locator)).clear();
        wd.findElement(By.name(locator)).sendKeys(text);
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
