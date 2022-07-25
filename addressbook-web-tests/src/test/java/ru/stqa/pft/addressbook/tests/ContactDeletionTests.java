package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().goToHomaPage();
        if ( !app.getContactHelper().isTheAContact()){
            app.getContactHelper().createContact(new ContactData(
                            "Mikhail",
                            "Poliakov",
                            "Moscow, Pushkina, dom Kolotushkina",
                            "test@test.ru",
                            "27",
                            "September",
                            "1996",
                            "test2"),
                    true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initEditContact();
        app.getContactHelper().submitContactDeletion();
        app.getNavigationHelper().goToHomaPage();
    }
}
