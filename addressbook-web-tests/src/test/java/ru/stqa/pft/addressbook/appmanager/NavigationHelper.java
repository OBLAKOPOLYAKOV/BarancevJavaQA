package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends SessionHelper {
    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void goToHomaPage() {
        click(By.linkText("home"));
    }
}
