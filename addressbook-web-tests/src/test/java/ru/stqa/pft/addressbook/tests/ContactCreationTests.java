package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation()throws Exception{
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData(
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "*9666666666",
                "test@test.ru",
                "27",
                "September",
                "1996"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }

}
