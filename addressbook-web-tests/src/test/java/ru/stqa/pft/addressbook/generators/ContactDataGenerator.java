package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactData> contacts = generateContacts(count);
        save(contacts,file);
    }
    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s;%s;%s\n", contact.getFirstname(),
                            contact.getLastname(),
                            contact.getLastname(),
                            contact.getAddress(),
                            contact.getMobilePhone(),
                            contact.getEmail(),
                            contact.getHomePhone()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData>contacts = new ArrayList<ContactData>();
        for (int i = 0; i<count;i++){
            contacts.add(new ContactData()
                    .withFirstname(String.format("Name%s", i ))
                    .withLastname(String.format("LastName%s",i))
                    .withAddress(String.format("Test Adress h.%s", i))
                    .withMobilePhone(String.format("8919762841%s", i))
                    .withEmail(String.format("test%s@test.com", i))
                    .withHomePhone(String.format("8(495)167881%s", i)));
        }
        return contacts;
    }
}
