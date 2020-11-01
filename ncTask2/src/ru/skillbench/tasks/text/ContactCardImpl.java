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
    private boolean hasBegin = false;
    private boolean hasEnd = false;



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

//            String first = String.valueOf(list.get(i).charAt(0) + list.get(i).charAt(1));
//            switch (first) {
//                case "FN":
//
//            }





            // old-----------
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < list.get(i).length(); j++) {
                if (list.get(i).charAt(i) != ':' || list.get(i).charAt(i) != ';') {
                    s.append(list.get(i).charAt(j));


                    String st = s.toString();
                    String vcard;
                    switch (st) {
                        case "BEGIN":
                            vcard = list.get(i).substring(j + 2);
                            if (vcard.equals("VCARD") && j == 0) {
                                hasBegin = true;
                            }
                            break;
                        case "END":
                            vcard = list.get(i).substring(j + 2);
                            if (vcard.equals("VCARD") && (j == list.size() - 1)) {
                                hasEnd = true;
                            }
                            break;
                        case "FN":
                            fullName = list.get(i).substring(j + 2);
                            break;
                        case "ORG":
                            organization = list.get(i).substring(j + 2);
                            break;
                        case "GENDER":
                            gender = list.get(i).substring(j + 2);
                            break;
                        case "BDAY":
                            String bd = list.get(i).substring(j + 2);
//                            birthday = Calendar.getInstance();
                            try {
//                                System.out.println(bd);
                                Date sdf = new SimpleDateFormat("dd-MM-yyyy").parse(bd);
//                                System.out.println(sdf);
                                birthday = new GregorianCalendar();
                                birthday.setTime(sdf);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            break;
                        case "TEL":
                            if (telephone == null) {
                                telephone = new HashMap<>();
                            }
                            vcard = list.get(i).substring(9);
                            String[] vcardSplit = vcard.split(":+|,+");
                            if (vcardSplit[vcardSplit.length - 1].length() != 10) {
                                throw new InputMismatchException();
                            }
                            for (int l = 0; l < vcardSplit.length - 1; l++) {
                                telephone.put(vcardSplit[l], vcardSplit[vcardSplit.length - 1]);
                            }
                            break;
                        default:
                            throw new InputMismatchException();
                    }
                } else {

                }
            }
        }

//        System.out.println(fullName);
//        System.out.println(getOrganization());
//        System.out.println(getBirthday());
//        for (Map.Entry entry : telephone.entrySet()) {
//            System.out.println(entry);
//        }

        if (hasBegin && hasEnd && organization != null & fullName != null) {
            return this;
        } else {
            throw new NoSuchElementException();
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
