package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.goTo().homaPage();
        if ( app.contact().list().size()==0){
            app.contact().create(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));
        }
        List<ContactData> before = app.contact().list();
        int contactNumber = before.size() - 1;
        app.contact().delete(contactNumber);
        app.goTo().homaPage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}
