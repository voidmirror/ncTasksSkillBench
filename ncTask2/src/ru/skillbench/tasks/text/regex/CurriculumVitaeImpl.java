package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {
    private String text = null;
    private ArrayList<Phone> phones = null;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        if (text == null) {
            throw new IllegalStateException();
        } else {
            return text;
        }
    }

    @Override
    public List<Phone> getPhones() {
        if (text == null) {
            throw new IllegalStateException();
        }

        ArrayList<Phone> phones = new ArrayList<>();
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
//            System.out.println(matcher.group());
            String current = matcher.group();
//            String patternNumber =
            String patternAreaCode = "\\(([1-9][0-9]{2})\\)";
            String patternExtension = "\\s*ext\\.?\\s*([0-9]+)";    //TODO: if it IS in whole number pattern then grab from in last numbers
            String patternExtensionNum = "([0-9]+)";
            
//            String patternNumber




//            Phone phone = new Phone();
//            phones.add();
        }

        return null;
    }

    @Override
    public String getFullName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getMiddleName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void updateLastName(String newLastName) {

    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {

    }

    @Override
    public void hide(String piece) {

    }

    @Override
    public void hidePhone(String phone) {

    }

    @Override
    public int unhideAll() {
        return 0;
    }
}
