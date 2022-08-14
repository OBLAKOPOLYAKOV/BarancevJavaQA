package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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
        attach(By.name("photo"),contactData.photo());
        type(By.name("email"),contactData.email());
        type(By.name("mobile"),contactData.mobilePhone());
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
        contactCashe = null;
        returnToContactPage();
    }

    public void modify(ContactData contact, boolean upperBotton) {
        selectContactById(contact.getId());
        initEditContactById(contact.getId());
        fillContactForm(contact, false);
        if (upperBotton){
            submitContactModificationUpper();}
        else {submitContactModificationAtTheBottom();}
        contactCashe = null;
        returnToContactPage();
    }

    public void deleteById(ContactData contact) {
        selectContactById(contact.getId());
        initEditContactById(contact.getId());
        submitContactDeletion();
        contactCashe = null;
    }

    public boolean isTheAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCashe = null;

    public Contacts all() {
        if(contactCashe != null){
            return new Contacts(contactCashe);
        }
        contactCashe = new Contacts();
        List<WebElement>elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element:elements){
            List<WebElement>cells = element.findElements(By.tagName("td"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            int id =Integer.parseInt(element.findElement(By.cssSelector("input[type='checkbox']"))
                    .getAttribute("id"));
            contactCashe.add(new ContactData()
                    .withId(id).withFirstname(firstName).withLastname(lastName)
                    .withAddress(address).withAllPhones(allPhones).withAllEmails(allEmails));
        }
        return new Contacts(contactCashe);
    }

    public ContactData infoFromEditForm(ContactData contact) {
        selectContactById(contact.getId());
        initEditContactById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String home2 = wd.findElement(By.name("phone2")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");;
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");;
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");;
        wd.navigate().back();
        return new ContactData().withFirstname(firstName).withLastname(lastName)
                .withAddress(address).withHomePhone(home).withMobilePhone(mobile)
                .withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withHome2Phone(home2);

    }
}
