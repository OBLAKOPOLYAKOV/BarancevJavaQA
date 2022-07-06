package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname());
        type(By.name("lastname"), contactData.lastname());
        type(By.name("address"), contactData.address());
        type(By.name("email"),contactData.email());
        selectedFromTheList(By.name("bday"), contactData.bday());
        selectedFromTheList(By.name("bmonth"), contactData.bmonth());
        type(By.name("byear"), contactData.byear());
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initEditContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));;
    }

    public void submitContactModificationUpper() {
        click(By.xpath("//input[@value='Update'][1]"));
    }

    public void submitContactModificationAtTheBottom() {
        click(By.xpath("//input[@value='Update'][1]"));
    }
}
