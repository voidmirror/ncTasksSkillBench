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

class A {
    protected Exception getException(CharSequence cause) throws Exception {return new Exception();}
}

class Main extends A {

//    public Exception getException(String cause) throws RuntimeException {return new Exception();}
//    public Exception getException(CharSequence cause) throws Exception {return new Exception();}
//    public Exception getException(Object cause) { return new Exception();}
//    private Exception getException(CharSequence cause) {return new Exception();}


    @Override
    protected Exception getException(CharSequence cause) throws RuntimeException {
        try {
            return super.getException(cause);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}