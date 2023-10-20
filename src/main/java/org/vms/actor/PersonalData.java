package org.vms.actor;

public class PersonalData {
    private final String name;
    private final String surname;

    public PersonalData(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
