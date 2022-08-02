package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion(){
        if ( !app.getContactHelper().isTheAContact()){
            app.getContactHelper().createContact(new ContactData(
                    "Mikhail",
                    "Poliakov",
                    "Moscow, Pushkina, dom Kolotushkina",
                    "test@test.ru",
                    "27",
                    "September",
                    "1996",
                    null));}
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().initEditContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomaPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1);
    }
}
