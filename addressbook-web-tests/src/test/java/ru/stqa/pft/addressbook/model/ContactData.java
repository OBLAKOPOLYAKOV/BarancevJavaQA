package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @Column(name = "email3")
    @Type(type = "text")
    private String email3;
    @Expose
    @Column(columnDefinition = "tinyint")
    private int bday;
    @Expose
    private String bmonth;
    @Expose
    private String byear;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id
                && bday == that.bday
                && Objects.equals(firstname, that.firstname)
                && Objects.equals(lastname, that.lastname)
                && Objects.equals(address, that.address)
                && (email == null || that.email == null || Objects.equals(email, that.email))
                && (email2 == null || that.email2 == null || Objects.equals(email2, that.email2))
                && (email3 == null || that.email3 == null || Objects.equals(email3, that.email3))
                && (homePhone == null || that.homePhone == null || Objects.equals(homePhone, that.homePhone))
                && (home2Phone == null || that.home2Phone == null || Objects.equals(home2Phone, that.home2Phone))
                && (workPhone == null || that.workPhone == null || Objects.equals(workPhone, that.workPhone));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address);
    }

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
                ", bday=" + bday +
                ", bmonth='" + bmonth + '\'' +
                ", byear='" + byear + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", home2Phone='" + home2Phone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", allPhones='" + allPhones + '\'' +
                ", allEmails='" + allEmails + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name ="id"), inverseJoinColumns = @JoinColumn(name="group_id"))
    private Set<GroupData> groups=new HashSet<GroupData>();

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

    public ContactData withBday(int bday) {
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

    public Groups getGroups() {
        return new Groups(groups);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public ContactData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}