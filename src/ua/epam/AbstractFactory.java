package ua.epam;

/**
 * Created by Dmytro_Rybin on 9/23/2016.
 */
public class AbstractFactory {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("ENG");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchPad();

        m.click();
        k.print();
        t.track(10, 20);
    }

         private static DeviceFactory getFactoryByCountryCode(String code) {
         switch (code) {
             case "UKR":
                 return new UkrDeviceFactory();
             case "ENG":
                 return new EngDeviceFactory();
             default:
                 throw new RuntimeException("Unexpected country code: " + code);
         }
     }
}

    interface Mouse {
        void  click();
        void dblclick();
        void scroll(int direction);
    }

    interface Keyboard {
        void print();
        void println();
    }

    interface Touchpad {
        void track(int deltaX, int deltaY);
    }

     class UkrMouse implements Mouse {
        public void click() {
            System.out.println("ukr click");
        }
        public void dblclick() {
            System.out.println("ukr double click");
        }
        public void scroll(int direction) {
            if (direction > 0)
                System.out.println("ukr scroll up");
            else if (direction < 0)
                System.out.println("ukr scroll down");
            else
                System.out.println("ukr no scroll ");
        }
    }

     class UkrKeyboard implements Keyboard {
        public void print() {
            System.out.println("ukr print");
        }
        public void println() {
            System.out.println("ukr println");
        }
    }

     class UkrTouchpad implements Touchpad {
        public void track(int deltaX, int deltaY) {
            int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            System.out.println("ukr moved " + s + " pixels");
        }
    }

     class EngMouse implements Mouse {
        public void click() {
            System.out.println("eng click");
        }
        public void dblclick() {
            System.out.println("eng double click");
        }
        public void scroll(int direction) {
            if (direction > 0)
                System.out.println("eng scroll up");
            else if (direction < 0)
                System.out.println("eng scroll down");
            else
                System.out.println("eng no scroll ");
        }
    }

     class EngKeyboard implements Keyboard {
        public void print() {
            System.out.println("eng print");
        }
        public void println() {
            System.out.println("eng println");
        }
    }

     class EngTouchpad implements Touchpad {
        public void track(int deltaX, int deltaY) {
            int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            System.out.println("eng moved " + s + " pixels");
        }
    }

    interface DeviceFactory {
        Mouse getMouse();
        Keyboard getKeyboard();
        Touchpad getTouchPad();
    }

     class UkrDeviceFactory implements DeviceFactory {
        public Mouse getMouse() {
            return new UkrMouse();
        }
        public Keyboard getKeyboard() {
            return new UkrKeyboard();
        }
        public Touchpad getTouchPad() {
            return new UkrTouchpad();
        }
    }

     class EngDeviceFactory implements DeviceFactory {
        public Mouse getMouse() {
            return new EngMouse();
        }
        public Keyboard getKeyboard() {
            return new EngKeyboard();
        }
        public Touchpad getTouchPad() {
            return new EngTouchpad();
        }
    }

