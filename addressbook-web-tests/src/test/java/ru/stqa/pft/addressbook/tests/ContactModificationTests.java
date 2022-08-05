package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
        Contacts before = app.contact().all();
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
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));
    }

    @Test
    public void testContactModificationAtTheBottom() {
        Contacts before = app.contact().all();
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
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));
    }
}
