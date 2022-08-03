package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().groupPage();
        if  (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test2"));
        }
        app.goTo().homaPage();
    }

    @Test
    public void testContactCreation(){

        List<ContactData> before = app.contact().list();
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
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()+1);

        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
