package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().homaPage();
        if ( app.contact().all().size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("Mikhail")
                    .withLastname("Poliakov")
                    .withEmail("test@test.ru")
                    .withEmail2("javaqa@googlemail.com"));
        }
    }

    @Test
    public void testContactPhone(){
        app.goTo().homaPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));
    }

    private String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter(a->! a.equals("")).collect(Collectors.joining("\n"));
    }
}
