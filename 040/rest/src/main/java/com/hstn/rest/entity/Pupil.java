package com.hstn.rest.entity;

public class Pupil {

    private String firstName;
    private String lastName;

    public Pupil(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Pupil() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
