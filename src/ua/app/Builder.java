package ua.app;

/**
 * Created by Дмитрий on 25.09.2016.
 */
public class Builder {
    public static void main(String[] args) {
 //       Car car = new CarBuilder().buildMaker("fdgd");
        Car car = new CarBuilder()
        .buildMaker("Vilvo")
        .buildTransmission(Transmission.MANUAL)
        .buildMaxSpeed(150)
        .build();
        System.out.println(car.toString());
    }
}

enum Transmission {
    MANUAL, AUTO
}

class  Car {
    String maker;
    Transmission transmission;
    int maxSpeed;

    public void setMaker(String make) {
        this.maker = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maker='" + maker + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder extends Car{
    String m = "Default";
    Transmission t = Transmission.AUTO;
    int s = 120;

    CarBuilder buildMaker(String m) {
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }
    CarBuilder buildMaxSpeed(int s) {
        this.s = s;
        return this;
    }
    Car build(){
        Car car = new Car();
        car.setMaker(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}

