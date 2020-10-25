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
    }

    @Override
    public List<Map.Entry<String, Long>> getWordCountsSorted() {
        return null;
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
