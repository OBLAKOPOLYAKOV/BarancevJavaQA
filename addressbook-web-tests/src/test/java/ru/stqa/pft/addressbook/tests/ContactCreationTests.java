package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
