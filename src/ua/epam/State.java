package ua.epam;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class State {
    public static void main(String[] args) {
        Station r7 = new Radio7();
        Radio context = new Radio();
        context.setStation(r7);

        for (int i = 0; i < 10; i++) {
            context.play();
            context.nextStation();
        }
    }
}

interface Station {
    void play();
}

class Radio7 implements Station {
    public void play() {
        System.out.println("radio7");
    }
}

class Radio9 implements Station {
    public void play() {
        System.out.println("radio9");
    }
}

class Radio10 implements Station {
    public void play() {
        System.out.println("radio10");
    }
}

//Context
class Radio {
    Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void nextStation() {
        if(station instanceof Radio7)
            setStation(new Radio9());
        else if(station instanceof Radio9)
            setStation(new Radio10());
        else if(station instanceof Radio10)
            setStation(new Radio7());
    }
    void play() {
        station.play();
    }
}