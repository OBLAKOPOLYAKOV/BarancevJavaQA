package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModificationAtTheUpper() {
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
                    null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initEditContact();
        app.getContactHelper().fillContactForm(new ContactData(
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null),
                false);
        app.getContactHelper().submitContactModificationUpper();
        app.getContactHelper().returnToContactPage();
    }

    @Test
    public void testContactModificationAtTheBottom() {
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
                    null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().initEditContact();
        app.getContactHelper().fillContactForm(new ContactData(
                "Mikhail",
                "Poliakov",
                "Moscow, Pushkina, dom Kolotushkina",
                "test@test.ru",
                "27",
                "September",
                "1996",
                null),
                false);
        app.getContactHelper().submitContactModificationAtTheBottom();
        app.getContactHelper().returnToContactPage();
    }
}
