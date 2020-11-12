package ru.skillbench.tasks.javaapi.collections;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import ru.skillbench.tasks.text.WordCounter;
import ru.skillbench.tasks.text.WordCounterImpl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        StringFilter stringFilter = new StringFilterImpl();
//        stringFilter.add("1 yui hjk bnm");
//        stringFilter.add("2 bnm oosikje sfkm skof");
//        stringFilter.add("3 hjk jdf kds");
//        stringFilter.add("4 jkrsngv kfed dklf hjk");
//        stringFilter.add("5 srgkn mdfkm lef a");
//        stringFilter.add("hjkdfskml 6");
//        stringFilter.add("7 jnksrvjhjksdkjvg mdkl mkes");
//
////        for (String s : stringFilter.getCollection()) {
////            System.out.println(s);
////        }
//        System.out.println();
//        System.out.println("---------------------");
//        System.out.println();
//
////        Iterator<String> iterator = stringFilter.getStringsContaining("hjk");
////        while (iterator.hasNext()) {
////            System.out.println(iterator.next());
////        }
//
//        System.out.println();
//        System.out.println("---------------------");
//        System.out.println();
//
////        for (String s : stringFilter.getCollection()) {
////            System.out.println(s);
////        }
//
//        System.out.println();
//        System.out.println("---------------------");
//        System.out.println();
//
//        Iterator<String> iterator = stringFilter.getStringsStartingWith("hjk");
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());        //TODO: уходит в бесконечность
//        }



        // TREE NODE ================================================================\
        // TREE NODE ================================================================\
        // TREE NODE ================================================================\

        TreeNode treeNode = new TreeNodeImpl();
        treeNode.setData("hello");
        treeNode.setParent(new TreeNodeImpl());
        treeNode.getParent().setData("im parent");
        for (int i = 0; i < 10; i++) {
            TreeNode t = new TreeNodeImpl();
            t.setData("im child " + i);
            t.setParent(treeNode.getParent());
        }
        System.out.println(treeNode.getParent().getData());
        Iterator<TreeNode> iterator = treeNode.getParent().getChildrenIterator();
        while (iterator.hasNext()) {
            System.out.println("+++");
            System.out.println(iterator.next().getData());
        }



    }
}
