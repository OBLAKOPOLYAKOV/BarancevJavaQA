package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;

    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", group='" + group + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", home2Phone='" + home2Phone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;
    @Expose
    private int bday;
    @Expose
    private String bmonth;
    @Expose
    private int byear;
    @Transient
    @Type(type = "text")
    private String group;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Expose
    @Column(name = "phone2")
    @Type(type = "text")
    private String home2Phone;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;
    @Expose
    @Transient
    private String allPhones;

    @Transient
    private String allEmails;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

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
        if (photo != null) {
            return new File(photo);
        } else {
            return null;
        }
    }

    public String allEmails() {
        return allEmails;
    }

    public int bday() {
            return Integer.parseInt(Integer.toString(bday));
        }

    public String bmonth() {
        if (bmonth != null){
            return bmonth;
        } else {
            return null;
        }
    }

    public int byear() {
            return Integer.parseInt(Integer.toString(byear));
    }

    public String homePhone() {
        if (homePhone != null){
            return homePhone;
        } else {
            return null;
        }
    }

    public String home2Phone() {
        if (home2Phone != null){
            return home2Phone;
        } else {
            return null;
        }
    }

    public String workPhone() {
        if (workPhone != null){
            return workPhone;
        } else {
            return null;
        }
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
        if (email2 != null){
            return email2;
        } else {
            return null;
        }
    }

    public String email3() {
        if (email3 != null){
            return email3;
        } else {
            return null;
        }
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getHomePhone() {
        if (homePhone != null){
            return homePhone;
        } else {
            return null;
        }
    }

    public String getHome2Phone() {
        if (home2Phone != null){
            return home2Phone;
        } else {
            return null;
        }
    }

    public String getWorkPhone() {
        if (workPhone != null){
            return workPhone;
        } else {
            return null;
        }
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGroup() {
        if (group != null){
            return group;
        } else {
            return null;
        }
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

    public int getBday() {
        return Integer.parseInt(Integer.toString(bday));
    }

    public String getBmonth() {
        return bmonth;
    }

    public int getByear() {
        return Integer.parseInt(Integer.toString(byear));
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

    public ContactData withBday(int bday) {
        this.bday = bday;
        return this;
    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }

    public ContactData withByear(int byear) {
        this.byear = byear;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

}