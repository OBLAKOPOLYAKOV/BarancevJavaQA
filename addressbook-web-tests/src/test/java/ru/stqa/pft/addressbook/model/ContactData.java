package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class ContactData {
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String phone;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;

    public ContactData(String firstname, String lastname, String address, String phone, String email, String bday,
                       String bmonth, String byear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
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

    public String phone() {
        return phone;
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

}