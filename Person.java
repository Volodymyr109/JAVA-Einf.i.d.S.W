package Aufgabe4_hash_eq;

public class Person {

    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {}

    public void setValues(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getValues() {
        String pers = name + age;
        return pers;
    }
}
