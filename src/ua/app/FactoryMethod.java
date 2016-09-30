package ua.app;

import java.util.Date;

/**
 * Created by Dmytro_Rybin on 9/23/2016.
 */
public class FactoryMethod {
    public static void main(String[] args) {
   //     FactoryMethod.Watch watch = new FactoryMethod.DigitalWatch();
   //     watch.showTime();
        WatchMaker maker = new DigitalWatchMaker(); //new FactoryMethod.RomeWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }
}

    interface Watch {

        void showTime();
    }

     class DigitalWatch implements Watch {
        public void showTime() {
            System.out.println(new Date());
        }
    }

     class RomeWatch implements Watch {
        public void showTime() {
            System.out.println("VII");
        }
    }

    interface WatchMaker {
        Watch createWatch();
    }

     class DigitalWatchMaker implements WatchMaker {
        public Watch createWatch() {
            return new DigitalWatch();
        }
    }

     class RomeWatchMaker implements WatchMaker {
        public Watch createWatch() {
            return new RomeWatch();
        }
    }

