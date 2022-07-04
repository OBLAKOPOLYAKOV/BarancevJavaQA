package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public final class GroupData {
    public final String name;
    public final String header;
    public final String footer;

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public String name() {
        return name;
    }

    public String header() {
        return header;
    }

    public String footer() {
        return footer;
    }
}