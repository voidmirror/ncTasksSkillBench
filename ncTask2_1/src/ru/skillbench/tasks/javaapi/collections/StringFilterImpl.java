package ru.skillbench.tasks.javaapi.collections;

import java.util.Collection;
import java.util.Iterator;

public class StringFilterImpl implements StringFilter {
    @Override
    public void add(String s) {

    }

    @Override
    public boolean remove(String s) {
        return false;
    }

    @Override
    public void removeAll() {

    }

    @Override
    public Collection<String> getCollection() {
        return null;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        return null;
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        return null;
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
