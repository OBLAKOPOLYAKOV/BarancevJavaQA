package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            new Select(wd.findElement(By.name("new_group"))).selectByIndex(0);
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initCreation() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initEditContactById(int id) {
        wd.findElement(By.xpath("//input[contains(@id,'"+id+"')]/../..//img[@alt='Edit']")).click();
    }

    public void submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='"+ id +"']")).click();
    }

    public void submitContactModificationUpper() {
        click(By.xpath("//input[@value='Update'][1]"));
    }

    public void submitContactModificationAtTheBottom() {
        click(By.xpath("//input[@value='Update'][1]"));
    }

    public void create(ContactData contact) {
        initCreation();
        fillContactForm(contact, true);
        submitContactCreation();
        returnToContactPage();
    }

    public void modify(ContactData contact, boolean upperBotton) {
        selectContactById(contact.getId());
        initEditContactById(contact.getId());
        fillContactForm(contact, false);
        if (upperBotton){
            submitContactModificationUpper();}
        else {submitContactModificationAtTheBottom();}
        returnToContactPage();
    }

    public void deleteById(ContactData contact) {
        selectContactById(contact.getId());
        initEditContactById(contact.getId());
        submitContactDeletion();
    }

    public boolean isTheAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement>elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element:elements){
            List<WebElement>cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            int id =Integer.parseInt(element.findElement(By.cssSelector("input[type='checkbox']"))
                    .getAttribute("id"));
            contacts.add(new ContactData()
                    .withId(id).withFirstname(firstName).withLastname(lastName).withAddress(address));
        }
        return contacts;
    }

}
