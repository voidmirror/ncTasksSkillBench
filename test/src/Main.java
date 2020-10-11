import javax.swing.text.AsyncBoxView;

class Base {
    void test() {
        System.out.println("Base.test()");
    }
}
public class Main  extends Base{
    void test() {
        System.out.println("Child");
    }
    public static void main(String[] args) {
        Main anMain = new Main();
        Base baseobj = (Base) anMain;
        baseobj.test();
        
    }
}
