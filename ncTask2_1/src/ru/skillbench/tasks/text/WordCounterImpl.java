package ru.skillbench.tasks.text;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.PrintStream;
import java.util.*;

public class WordCounterImpl implements WordCounter {
    private String text = null;
    private Map<String, Long> map = new HashMap<>();

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Map<String, Long> getWordCounts() {
//        String rp = text.replace();
        try {
            text = text.toLowerCase();
            String[] tmp = text.split("<[^<>]+>|[ \n\r\t]+");   //TODO: скобки!     ("<.+[^<]>|[ \n\r\t]+")

            for (String s : tmp) {
                if (!s.equals("")) {
                    if (map.containsKey(s.toLowerCase())) {
                        map.put(s.toLowerCase(), map.get(s.toLowerCase()) + 1);
                    } else {
                        map.put(s, 1L);
                    }
                }
            }
            return map;
        } catch (NullPointerException e) {
            throw new IllegalStateException();
        }
//        return null;
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        try {
            List<Map.Entry<String, Long>> arr = sort(map, new Comparator<Map.Entry<String, Long>>() {
                @Override
                public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                    if (o1.getValue().equals(o2.getValue())) {
                        return 0;
                    }
                    if (o1.getValue() < o2.getValue()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            return arr;     //TODO: check returning arr
        } catch (NullPointerException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K, V>> sort(Map<K, V> map, Comparator<Map.Entry<K, V>> comparator) {
        List<Map.Entry<K, V>> arr = new ArrayList<>(map.entrySet());
        arr.sort(comparator);

        return arr;
    }

    @Override
    public <K, V> void print(List<Map.Entry<K, V>> entries, PrintStream ps) {
        for (int i = 0; i < entries.size(); i++) {
            ps.println(entries.get(i).getKey() + " " + entries.get(i).getValue());
        }
    }
}
