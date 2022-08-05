package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Contacts before = app.contact().all();
        ContactData deletionContact = before.iterator().next();
        app.contact().deleteById(deletionContact);
        app.goTo().homaPage();
        assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(deletionContact)));

    }

}
