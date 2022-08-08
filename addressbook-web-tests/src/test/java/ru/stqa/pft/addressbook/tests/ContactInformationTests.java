package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInformationTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        app.goTo().homaPage();
        if ( app.contact().all().size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("Mikhail")
                    .withLastname("Poliakov")
                    .withEmail("test@test.ru")
                    .withEmail2("javaqa@googlemail.com")
                    .withHomePhone("+7(919)7628411")
                    .withMobilePhone("170-22-77")
                    .withAddress("Moscow, Pushkina, dom Kolotushkina"));
        }
    }

    @Test
    public void testContactPhone(){
        app.goTo().homaPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    private String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3())
                .stream().filter(a->! a.equals("")).collect(Collectors.joining("\n"));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone(), contact.getHome2Phone())
                .stream().filter(a->! a.equals("")).map(ContactInformationTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
