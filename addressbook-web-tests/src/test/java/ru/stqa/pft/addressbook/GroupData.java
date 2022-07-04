package ru.stqa.pft.addressbook;

import java.util.Objects;

public final class GroupData {
    private final String name;
    private final String header;
    private final String footer;

    GroupData(String name, String header, String footer) {
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