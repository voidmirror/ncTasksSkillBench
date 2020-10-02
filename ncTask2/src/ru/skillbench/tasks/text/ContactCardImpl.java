package ru.skillbench.tasks.text;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class ContactCardImpl implements ContactCard {
    private String fullName;                     //VCard: FN
    private String organization;                 //VCard: ORG
    private String gender;                       //VCard: GENDER  //TODO: Если поле GENDER отсутствует в данных или равно "M", этот метод возвращает false
    private Calendar birthday;                   //VCard: BDAY
    private HashMap<String, String> telephone;   //VCard: TEL



    @Override
    public ContactCard getInstance(Scanner scanner) {
        ArrayList<String> list = new ArrayList<>();
        if (scanner.hasNext()) {
            StringBuffer s = new StringBuffer();
            String[] sarr;
//            String data = scanner.next();
//            s = scanner.next().split("\r\n");
            while (scanner.hasNext()) {
                s.append(scanner.next());
            }
            sarr = s.toString().split("\r\n");

            System.out.println(sarr[0]);
        }
        return null;
    }

    @Override
    public ContactCard getInstance(String data) {
        Scanner scanner = new Scanner(data);
        return getInstance(scanner);
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getOrganization() {
        return organization;
    }

    @Override
    public boolean isWoman() {
        return gender.equals("F");
    }

    @Override
    public Calendar getBirthday() {
        return birthday;
    }

    @Override
    public Period getAge() {
        DateTimeFormatter formatter;    //TODO: понять, как оно работает
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
