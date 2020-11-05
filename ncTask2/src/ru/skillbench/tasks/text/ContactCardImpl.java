package ru.skillbench.tasks.text;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactCardImpl implements ContactCard {
    private String fullName;                     //VCard: FN
    private String organization;                 //VCard: ORG
    private String gender = "M";                       //VCard: GENDER  //TODO: Если поле GENDER отсутствует в данных или равно "M", этот метод возвращает false
    private Calendar birthday;                   //VCard: BDAY
    private String birthdayString;
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
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {

//            String first = String.valueOf(list.get(i).charAt(0) + list.get(i).charAt(1));
//            switch (first) {
//                case "FN":
//
//            }





            // old-----------
            boolean isEmpty = true;
            StringBuffer s = new StringBuffer();
            for (int j = 0; j < list.get(i).length(); j++) {

                if (list.get(i).charAt(i) != ':' || list.get(i).charAt(i) != ';') {
                    s.append(list.get(i).charAt(j));
//                    System.out.println("++");
                    if (j > 6 && isEmpty) {
//                        System.out.println(s);
                        throw new NoSuchElementException();
                    }

                    String st = s.toString();
                    String vcard;
                    switch (st) {
                        case "BEGIN":
//                            System.out.println("+++");
                            vcard = list.get(i).substring(j + 2);
//                            System.out.println(vcard + i);
                            if (vcard.equals("VCARD") && i == 0) {
                                hasBegin = true;
                            }
                            isEmpty = false;
                            break;
                        case "END":
//                            System.out.println("9+++");
                            vcard = list.get(i).substring(j + 2);
//                            System.out.println(vcard + i);
                            if (vcard.equals("VCARD") && (i == list.size() - 1)) {
                                hasEnd = true;
                            }
                            isEmpty = false;
                            break;
                        case "FN":
                            fullName = list.get(i).substring(j + 2);
                            isEmpty = false;
                            break;
                        case "ORG":
                            organization = list.get(i).substring(j + 2);
                            isEmpty = false;
                            break;
                        case "GENDER":
                            gender = list.get(i).substring(j + 2);
                            if (!(gender.equals("M") || gender.equals("F"))) {
                                throw new InputMismatchException();
                            }
                            isEmpty = false;
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
                                throw new InputMismatchException();
                            }
                            isEmpty = false;
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
                            for (Map.Entry entry : telephone.entrySet()) {
                                Pattern pattern = Pattern.compile("[0-9]+");
                                if (!(Pattern.matches(pattern.pattern(), (CharSequence) entry.getValue()))) {
                                    throw new InputMismatchException();
                                }
                            }
                            isEmpty = false;
                            break;
//                        default:
//                            throw new InputMismatchException();
                    }
//                } else if (j > 6) {
//                    System.out.println(list.get(i).charAt(j));
//                    throw new InputMismatchException();
                }
            }
        }

//        System.out.println(fullName);
//        System.out.println(getOrganization());
//        System.out.println(getBirthday());
//        for (Map.Entry entry : telephone.entrySet()) {
//            System.out.println(entry);
//        }
//        System.out.println(hasBegin);
//        System.out.println(hasEnd);

        if (hasBegin && hasEnd && organization != null & fullName != null) {
            return this;
        } else {
            throw new NoSuchElementException();
        }
//        return null;
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
        if (birthday == null) {
            throw new NoSuchElementException();
        } else {
            return birthday;
        }
    }

    @Override
    public Period getAge() {
        //TODO: понять, как оно работает
        if (birthday == null) {
            throw new NoSuchElementException();
        }
//        DateTimeFormatter formatter = new DateTimeFormatter.ISO_LOCAL_DATE.format(2018, 3, 3);
        LocalDate start = Instant.ofEpochMilli(birthday.getTimeInMillis()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneId.systemDefault()).toLocalDate();




        Period here = Period.between(start, now);
//        System.out.println(here);
        return here;
    }

    @Override
    public int getAgeYears() {
        if (birthday == null) {
            throw new NoSuchElementException();
        }
        return getAge().getYears();
    }

    @Override
    public String getPhone(String type) {
        if (!telephone.containsKey(type)) {
            throw new NoSuchElementException();
        }
        StringBuffer s = new StringBuffer();
        s.append("(");
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 3:
                    s.append(") ");
                    break;
                case 6:
                    s.append('-');
                    break;
            }
            s.append(telephone.get(type).charAt(i));
        }

        return s.toString();
    }
}
