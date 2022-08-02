package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToGroupPage();
        if ( !app.getGroupHelper().isTheAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getContactHelper().initContactCreation();
        app.getContactHelper().createContact(new ContactData(
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null));
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size()+1);
    }

}
