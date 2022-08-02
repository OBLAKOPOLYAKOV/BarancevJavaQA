package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModificationAtTheUpper() {
        app.getNavigationHelper().goToHomaPage();
        if ( !app.getContactHelper().isTheAContact()){
            app.getContactHelper().createContact(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int contactNumber = 0;
        app.getContactHelper().selectContact(contactNumber);
        app.getContactHelper().initEditContact(contactNumber);
        ContactData contact = new ContactData(before.get(contactNumber).getId(),
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null);
        app.getContactHelper().fillContactForm(contact,
                false);
        app.getContactHelper().submitContactModificationUpper();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(contactNumber);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactModificationAtTheBottom() {
        app.getNavigationHelper().goToHomaPage();
        if ( !app.getContactHelper().isTheAContact()){
            app.getContactHelper().createContact(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int contactNumber = before.size()-1;
        app.getContactHelper().selectContact(contactNumber);
        app.getContactHelper().initEditContact(contactNumber);
        ContactData contact = new ContactData(before.get(contactNumber).getId(),
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null);
        app.getContactHelper().fillContactForm(contact,
                false);
        app.getContactHelper().submitContactModificationAtTheBottom();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(contactNumber);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
