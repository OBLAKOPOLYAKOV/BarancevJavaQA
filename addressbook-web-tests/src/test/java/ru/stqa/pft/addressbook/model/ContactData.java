package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

public class ContactData {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String address;
    @Expose
    private String email;
    private String email2;
    private String email3;
    @Expose
    private String bday;
    @Expose
    private String bmonth;
    @Expose
    private String byear;
    private String group;
    @Expose
    private String homePhone;
    @Expose
    private String home2Phone;
    @Expose
    private String workPhone;
    @Expose
    private String mobilePhone;
    private String allPhones;
    private String allEmails;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    public String firstname() {
        return firstname;
    }

    public String lastname() {
        return lastname;
    }

    public String address() {
        return address;
    }

    public File photo() {
        return photo;
    }
    public String allEmails() {
        return allEmails;
    }

    public String bday() {
        return bday;
    }

    public String bmonth() {
        return bmonth;
    }

    public String byear() {
        return byear;
    }

    public String homePhone() {
        return homePhone;
    }

    public String home2Phone() {
        return home2Phone;
    }

    public String workPhone() {
        return workPhone;
    }

    public String mobilePhone() {
        return mobilePhone;
    }

    public String allPhones() {
        return allPhones;
    }

    public String email() {
        return email;
    }

    public String email2() {
        return email2;
    }

    public String email3() {
        return email3;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getHome2Phone() {
        return home2Phone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }


    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withHome2Phone(String home2Phone) {
        this.home2Phone = home2Phone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address) && Objects.equals(homePhone, that.homePhone) && Objects.equals(workPhone, that.workPhone) && Objects.equals(mobilePhone, that.mobilePhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, homePhone, workPhone, mobilePhone);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}