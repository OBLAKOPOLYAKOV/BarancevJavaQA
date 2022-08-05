package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().homaPage();
        if ( app.contact().all().size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("Mikhail")
                    .withLastname("Poliakov")
                    .withAddress("Moscow, Pushkina, dom Kolotushkina")
                    .withEmail("test@test.ru")
                    .withBday("27")
                    .withBmonth("September")
                    .withByear("1996"));
        }
    }
    @Test
    public void testContactModificationAtTheUpper() {
        Set<ContactData> before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId())
                .withFirstname("MikhailEdit")
                .withLastname("PoliakovUpper")
                .withAddress("Moscow, Tverskaya-Yamskaya, dom 24")
                .withEmail("test@test.ru")
                .withBday("27")
                .withBmonth("September")
                .withByear("1996");
        app.contact().modify(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactModificationAtTheBottom() {
        Set<ContactData> before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId())
                .withFirstname("MikhailEdit")
                .withLastname("PoliakovBottom")
                .withAddress("Moscow, Tverskaya-Yamskaya, dom 24")
                .withEmail("test@test.ru")
                .withBday("27")
                .withBmonth("September")
                .withByear("1996");
        app.contact().modify(contact, false);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(),before.size());

        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
