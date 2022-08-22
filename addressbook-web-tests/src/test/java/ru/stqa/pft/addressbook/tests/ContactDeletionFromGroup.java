package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class ContactDeletionFromGroup extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().homaPage();
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }
        Groups groups = app.db().groups();
        if (app.db().contacts().size() == 0 || choiceGroupDel(groups, null)== null) {
            app.contact().create(new ContactData()
                    .withFirstname("Mikhail")
                    .withLastname("ForAddContact")
                    .withAddress("Moscow, Pushkina, dom Kolotushkina")
                    .withEmail("test@test.ru")
                    .withBday(27)
                    .withBmonth("September")
                    .withByear("1996").inGroup(app.db().groups().iterator().next()));
        }

    }

    @Test
    public void testContactDeletionFromGroup() {
        Groups beforeGroups = app.db().groups();
        ContactData contact = app.db().contacts().iterator().next();
        GroupData groupDeletion = null;
        groupDeletion = choiceGroupDel(beforeGroups, groupDeletion);
        app.contact().delContactFromGroup(contact, groupDeletion);
        app.goTo().homaPage();
        ContactData contactWithOutGroup = app.db().contactById(contact.getId());
        GroupData afterGroup = app.db().groupById(groupDeletion.getId());
        Assert.assertFalse(contactWithOutGroup.getGroups().contains(afterGroup));
        Assert.assertFalse(afterGroup.getContacts().contains(contactWithOutGroup));
    }

    private GroupData choiceGroupDel(Groups beforeGroups, GroupData groupDeletion) {
        for (GroupData group : beforeGroups) {
            if (group.getContacts().size() != 0) {
                groupDeletion = group;
                break;
            }
        }
        return groupDeletion;
    }
}
