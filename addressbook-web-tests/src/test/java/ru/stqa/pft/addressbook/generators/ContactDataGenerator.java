package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Contact Count")
    public int count;

    @Parameter(names = "-f", description = "target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")){
            saveAsXml(contacts,new File(file));
        } else if (format.equals("json")){
            saveAsJson(contacts,new File(file));
        } else {
            System.out.println("Unregnized format" + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String  json = gson.toJson(contacts);
        try(Writer writer = new FileWriter(file)){
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        try(Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
        try(Writer writer = new FileWriter(file)){
            for (ContactData contact : contacts){
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s\n",
                        contact.getFirstname(),
                        contact.getLastname(),
                        contact.getAddress(),
                        contact.getEmail(),
                        contact.getMobilePhone(),
                        contact.getBday(),
                        contact.getBmonth(),
                        contact.getByear()));
            }
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData>contacts = new ArrayList<ContactData>();
        for (int i = 0; i<count;i++){
            contacts.add(new ContactData()
                    .withFirstname(String.format("Name%s", i ))
                    .withLastname(String.format("LastName%s",i))
                    .withAddress(String.format("Test Address-%s", i))
                    .withEmail(String.format("test%s@test.com", i))
                    .withMobilePhone(String.format("8995167881%s", i))
                    .withBday(21)
                    .withBmonth("September")
                    .withByear("1991"));
        }
        return contacts;
    }
}
