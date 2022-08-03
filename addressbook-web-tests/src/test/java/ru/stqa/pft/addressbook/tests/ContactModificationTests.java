package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().homaPage();
        if ( app.contact().list().size()==0){
            app.contact().create(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));
        }
    }
    @Test
    public void testContactModificationAtTheUpper() {
        List<ContactData> before = app.contact().list();
        int contactNumber = 0;
        ContactData contact = new ContactData(before.get(contactNumber).getId(),
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null);
        app.contact().modify(contactNumber, contact);
        List<ContactData> after = app.contact().list();
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
        List<ContactData> before = app.contact().list();
        int contactNumber = before.size()-1;
        ContactData contact = new ContactData(before.get(contactNumber).getId(),
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null);
        app.contact().modify(contactNumber, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(),before.size());

        before.remove(contactNumber);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
