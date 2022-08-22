package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactAddToGroupTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().homaPage();
        app.contact().selectContactWithoutGroup();
        if ( app.db().contacts().size()==0 || app.contact().all().size() ==0){
            app.contact().create(new ContactData()
                    .withFirstname("Mikhail")
                    .withLastname("ForAddContact")
                    .withAddress("Moscow, Pushkina, dom Kolotushkina")
                    .withEmail("test@test.ru")
                    .withBday(27)
                    .withBmonth("September")
                    .withByear("1996"));
        }
        if(app.db().groups().size() ==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }
    }

    @Test
    public void testContactAddingToGroup() {
        app.goTo().homaPage();
        Contacts before = app.db().contacts();
        ContactData toBeAddContact = null;
        for (ContactData contacts : before) {
            if (contacts.getGroups().size() == 0) {
                toBeAddContact = contacts;
                break;
            }
        }
        GroupData group =  app.db().groups().iterator().next();
        app.contact().addContactToGroup(toBeAddContact, group);
        app.goTo().homaPage();
        ContactData contactWithGroup = app.db().contactById(toBeAddContact.getId());
        GroupData afterGroup = app.db().groupById(group.getId());
        Assert.assertTrue(contactWithGroup.getGroups().contains(afterGroup));
        Assert.assertTrue(afterGroup.getContacts().contains(contactWithGroup));
    }
}
