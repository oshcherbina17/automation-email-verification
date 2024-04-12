package com.zebrunner.carina.demo.sendtestemail.enums;

public enum EmailFolders {
    INBOX("INBOX"),
    SPAM("SPAM");

    private String nameFolders;

    EmailFolders(String name) {
        this.nameFolders = name;
    }

    public String getNameFolders() {
        return nameFolders;
    }
}
