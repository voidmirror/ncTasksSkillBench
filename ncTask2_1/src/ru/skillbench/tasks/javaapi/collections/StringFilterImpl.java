package ru.skillbench.tasks.javaapi.collections;

import java.util.*;
import java.util.regex.Pattern;

public class StringFilterImpl implements StringFilter {
    HashSet<String> hashSet = null;

    private boolean isInputNull(String s) {
        if (s == null || s.equals("")) {

        }
        return true; //TODO: !!
    }

    private HashSet<String> setCopy(String begin) {
        if (begin == null || begin.equals("")) {
            return hashSet;
        }

        HashSet<String> copy = (HashSet<String>) hashSet.clone();
//        Iterator<String> iterator = copy.iterator();
        return copy;
    }

    @Override
    public void add(String s) {
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(s.toLowerCase());
    }

    @Override
    public boolean remove(String s) {
        return hashSet.remove(s);
    }

    @Override
    public void removeAll() {
        hashSet.removeAll(hashSet);
    }

    @Override
    public Collection<String> getCollection() {
        return hashSet;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        if (chars == null || chars.equals("")) {
            return hashSet.iterator();
        }
        HashSet copy = (HashSet)hashSet.clone();
        Iterator iterator = copy.iterator();
//        for (String s : hashSet) {
//            if (!s.contains(chars)) {
//
//            }
//            iterator.next();
//        }

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            if (!s.contains(chars)) {
                iterator.remove();
            }
        }

        return copy.iterator();
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        if (begin == null || begin.equals("")) {
            return hashSet.iterator();
        }

        HashSet<String> copy = (HashSet)hashSet.clone();
        Iterator<String> iterator = copy.iterator();
        Pattern pattern = Pattern.compile("^" + begin + ".*");
        while (iterator.hasNext()) {

//            System.out.println(pattern);
//            System.out.println(pattern.pattern());
            if (!Pattern.matches(pattern.pattern(), iterator.next())) {
//                System.out.println("+++");
                iterator.remove();
            }
        }


        return copy.iterator();
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {
        return null;
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        return null;
    }
}
