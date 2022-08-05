package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
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
        Set<ContactData> before = app.contact().all();
        ContactData deletionContact = before.iterator().next();
        app.contact().deleteById(deletionContact);
        app.goTo().homaPage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletionContact);
        Assert.assertEquals(before, after);

    }

}
