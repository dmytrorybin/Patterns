package ua.app;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class TemplateMethod {
    public static void main(String[] args) {
        C a = new A();
        C b = new B();
        a.templateMethod();
        b.templateMethod();
    }

}

abstract class C {
    void templateMethod() {
        System.out.println("1");
        differ();
        System.out.println("3");
    }
    abstract void differ();
}

class A extends C{
    void differ() {
        System.out.println("2");
    }
//    void print() {
//        System.out.println("1");
//        System.out.println("2");
//        System.out.println("3");
//    }
}

class B  extends  C{
    void differ() {
        System.out.println("4");
    }
//    void print() {
//        System.out.println("1");
//        System.out.println("3");
//        System.out.println("4");
//    }
}