package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomaPage();
        app.getContactHelper().selectContact();
        app.getContactHelper().initEditContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomaPage();
    }
}
