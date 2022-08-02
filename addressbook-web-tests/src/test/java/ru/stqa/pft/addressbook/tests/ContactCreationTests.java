package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation(){
        int before = app.getContactHelper().getContactCount();
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
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }

}
