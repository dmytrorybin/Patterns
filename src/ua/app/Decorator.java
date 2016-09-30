package ua.app;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class Decorator {
    public static void main(String[] args) {
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hi"))));
        printer.print();
    }
    }

    interface PrinterInterface {
        void print();
    }

     class Printer implements PrinterInterface {
        String value;
        public Printer(String value) {
            this.value = value;
        }
        public void print() {
            System.out.print(value);
        }
    }


    abstract  class AbstrDecorator implements PrinterInterface {
        PrinterInterface component;
        public AbstrDecorator(PrinterInterface component) {
            this.component = component;
        }
    }

     class QuotesDecorator extends AbstrDecorator {
        public QuotesDecorator(PrinterInterface component) {
            super(component);
        }
        public void print() {
            System.out.print("\"");
            component.print();
            System.out.print("\"");
        }
    }

     class LeftBracketDecorator extends AbstrDecorator {
        public LeftBracketDecorator(PrinterInterface component) {
            super(component);
        }
        public void print() {
            System.out.print("(");
            component.print();
        }
    }

     class RightBracketDecorator extends AbstrDecorator {
        public RightBracketDecorator(PrinterInterface component) {
            super(component);
        }
        public void print() {
            component.print();
            System.out.print(")");
        }
    }

