package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String group;

    public ContactData(String firstname, String lastname, String address, String email, String bday,
                       String bmonth, String byear, String group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.group = group;
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

    public String email() {
        return email;
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

    public String getGroup() {
        return group;
    }
}