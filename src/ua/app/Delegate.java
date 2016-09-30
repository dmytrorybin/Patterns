package ua.app;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class Delegate {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Triangle());
        painter.draw();
    }
}
//    class A {
//        void f() {
//            System.out.println("f()");
//        }
//    }
//
//    class B {
//        A a = new A();
//        void f() {
//            a.f();
//        }
//    }

    interface Graphics {
        void draw();
    }

    class Triangle implements Graphics {
        public void draw() {
            System.out.println("draw triangle");
        }
    }

    class Square implements Graphics {
        public void draw() {
            System.out.println("draw square");
        }
    }

    class Painter {
        Graphics graphics;
        void setGraphics(Graphics g) {
            graphics = g;
        }

        void draw() {
            graphics.draw();
        }
    }

