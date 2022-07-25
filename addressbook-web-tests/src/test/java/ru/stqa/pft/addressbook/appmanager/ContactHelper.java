package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToContactPage() {
        click(By.linkText("home page"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.firstname());
        type(By.name("lastname"), contactData.lastname());
        type(By.name("address"), contactData.address());
        type(By.name("email"),contactData.email());
        selectedFromTheList(By.name("bday"), contactData.bday());
        selectedFromTheList(By.name("bmonth"), contactData.bmonth());
        type(By.name("byear"), contactData.byear());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
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

    public void createContact(ContactData Contact, boolean Creation) {
        initContactCreation();
        fillContactForm(Contact, Creation);
        submitContactCreation();
        returnToContactPage();
    }

    public boolean isTheAContact() {
        return isElementPresent(By.name("selected[]"));
    }
}
