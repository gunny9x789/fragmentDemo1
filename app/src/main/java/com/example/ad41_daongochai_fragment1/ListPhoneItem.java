package com.example.ad41_daongochai_fragment1;

public class ListPhoneItem {
    private String phoneNumber, name;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListPhoneItem(String phoneNumber, String name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
}
