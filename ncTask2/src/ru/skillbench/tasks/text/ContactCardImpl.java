package ru.skillbench.tasks.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ContactCardImpl implements ContactCard {
    private String fullName;                     //VCard: FN
    private String organization;                 //VCard: ORG
    private String gender;                       //VCard: GENDER  //TODO: Если поле GENDER отсутствует в данных или равно "M", этот метод возвращает false
    private Calendar birthday;                   //VCard: BDAY
    private HashMap<String, String> telephone;   //VCard: TEL



    @Override
    public ContactCard getInstance(Scanner scanner) {
//        ArrayList<String> list = new ArrayList<>();
//        if (scanner.hasNext()) {
//            StringBuffer s = new StringBuffer();
//            String[] sarr;
////            String data = scanner.next();
////            s = scanner.next().split("\r\n");
//            while (scanner.hasNext()) {
//                s.append(scanner.next());
//            }
//            sarr = s.toString().split("\r\n");
//
//            System.out.println(sarr[0]);
//        }

        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(i) != ':' || list.get(i).charAt(i) != ';') {
                    s.append(list.get(i).charAt(j));


                    String st = s.toString();

                    switch (st) {
                        case "FN":
                            fullName = list.get(i).substring(j + 2);
                        case "ORG":
                            organization = list.get(i).substring(j + 2);
                        case "GENDER":
                            gender = list.get(i).substring(j + 2);
                        case "BDAY":
                            String bd = list.get(i).substring(j + 2);
                            birthday = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                            //TODO: ак перевести текст в дату (sdf?)
//                            try {
//                                birthday.set(sdf.parse(bd));
//                            } catch (ParseException e) {
//                                System.out.println("Date is not in right format");
//                            }
                        case "TEL":
//                            for (int k = j + 1; j < list.get(i).length(); k++) {
//
//                            }
                    }
                } else {

                }
            }
        }

        System.out.println(fullName);
        System.out.println(getOrganization());
        System.out.println(getBirthday());


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
