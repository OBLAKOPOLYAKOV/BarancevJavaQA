package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]>validContactsFromXml() throws IOException {
        List<Object[]> List = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.xml")))){
            String xml="";
            String line = reader.readLine();
            while (line !=null){
                xml+=line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> groups = (List<ContactData>) xstream.fromXML(xml);
            groups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();
            return List.iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]>validContactsFromJson() throws IOException {
        List<Object[]> List = new ArrayList<Object[]>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.json")))){
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> groups = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePrecondition(){
        if(app.db().groups().size() ==0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test2"));
        }
        app.goTo().homaPage();
    }

    @Test(dataProvider = "validContactsFromJson")
    public void testContactCreation(ContactData contact){
        Contacts before = app.db().contacts();
        Groups groups = app.db().groups();
        app.contact().initCreation();
        File photo = new File("src/test/resources/photoContact.jpg");
        app.contact().create(contact.withPhoto(photo).inGroup(groups.iterator().next()));
        assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.db().contacts();
        assertEquals(after.size(), before.size()+1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
        verifyContactListInUi();
    }
}
