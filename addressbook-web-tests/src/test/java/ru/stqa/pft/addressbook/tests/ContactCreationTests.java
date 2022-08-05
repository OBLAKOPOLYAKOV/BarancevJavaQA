package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().groupPage();
        if  (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test2"));
        }
        app.goTo().homaPage();
    }

    @Test
    public void testContactCreation(){

        Contacts before = app.contact().all();
        app.contact().initCreation();
        ContactData contact = new ContactData()
                .withFirstname("Mikhail")
                .withLastname("Poliakov")
                .withAddress("Moscow, Pushkina, dom Kolotushkina")
                .withEmail("test@test.ru")
                .withBday("27")
                .withBmonth("September")
                .withByear("1996");
        app.contact().create(contact);
        assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size()+1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
    }

}
