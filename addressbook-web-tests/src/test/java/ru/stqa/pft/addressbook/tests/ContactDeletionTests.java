package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isTheAContact()) {
            app.getContactHelper().createContact(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int contactNumber = before.size() - 1;
        app.getContactHelper().selectContact(contactNumber);
        app.getContactHelper().initEditContact(contactNumber);
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomaPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}
