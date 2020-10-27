package ru.skillbench.tasks.javaapi.collections;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import ru.skillbench.tasks.text.WordCounter;
import ru.skillbench.tasks.text.WordCounterImpl;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String t = "fghjkl24m, 32j4kr nj2     jmlkml32\n\nhbj\n  \n nm,a";
//        String t = "<[commodo, odio, accumsan, nonummy, erat, facilisis, euismod, vero, ea, vel, molestie, feugiat, ut, wisi, volutpat, enim, exerci, ad, lobortis, consequat, in, velit, dignissim, vulputate, iriure, esse>, et, eu,< ex, at, eum, nostrud, ullamcorper, laoreet, qui, minim, veniam, hendrerit, autem, tincidunt, nisl, aliquam, magna, aliquip, nibh, quis, illum, iusto, tation, eros]>";
//        String t = "<[commodo, odio, accumsan, nonummy, erat, facilisis, euismod, vero, ea, vel, molestie> hjk <ghj>";
//        String t = null;
        String t = "bac <ccab> <abc> <cba abc abc> <ccab>";
//        System.out.println(t);

        WordCounter wordCounter = new WordCounterImpl();
        wordCounter.setText(t);
        Map<String, Long> map = wordCounter.getWordCounts();
        List<Map.Entry<String, Long>> list = wordCounter.getWordCountsSorted();
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m);
        }
        System.out.println();
        for (Map.Entry m : list) {
            System.out.println(m);
        }
    }
}
