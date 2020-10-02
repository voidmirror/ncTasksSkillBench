package ru.skillbench.tasks.text;

import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ContactCardImpl implements ContactCard {
    String fullName;
    String organization;
    Date bday;
    

    @Override
    public ContactCard getInstance(Scanner scanner) {
        return null;
    }

    @Override
    public ContactCard getInstance(String data) {
        System.out.println(data);
        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getOrganization() {
        return null;
    }

    @Override
    public boolean isWoman() {
        return false;
    }

    @Override
    public Calendar getBirthday() {
        return null;
    }

    @Override
    public Period getAge() {
        return null;
    }

    @Override
    public int getAgeYears() {
        return 0;
    }

    @Override
    public String getPhone(String type) {
        return null;
    }
}
