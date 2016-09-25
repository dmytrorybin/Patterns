package ua.epam;


/**
 * Created by Дмитрий on 25.09.2016.
 */
public class Prototype {
    public static void main(String[] args) {
        Human original = new Human(20, "Jack");
        System.out.println(original);

        Human copy1 = (Human) original.copy();
        System.out.println(copy1);
    }
}

interface Copyable {
    Object copy();
}

class Human implements Copyable {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }
}

