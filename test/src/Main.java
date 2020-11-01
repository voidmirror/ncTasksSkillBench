//import java.time.temporal.ValueRange;
//
//class SuperBase {
//    void print(SuperBase a) {
//        System.out.println("super");
//    }
//}
//
//class Base extends SuperBase {
//    void print(Base b) {
//        System.out.println("base");
//    }
//}
//
//class Derived extends Base {
//    void print(Derived c) {
//        System.out.println("derived");
//    }
//}

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;



class Main {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("One");
        arrayList.add("Two");
        arrayList.add("Three");

        for (Iterator<String> iter = arrayList.iterator(); iter.hasNext();) {
            String current = iter.next();
            if (current.length() == 3) {
                arrayList.remove(current);
            }
        }

        for (String current:arrayList) {
            System.out.println(current);
        }
    }

}