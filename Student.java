package Aufgabe4_hash_eq;

// Students inherited name und age aus der Klasse Person also vererbung
public class Student extends Person {

    // create Obj matr_num, als ein Teil der Identität der Studenten ist
    private Object matr_num;

    public Student(String name, int age, Object matr_num) {
        super();
    }

    public void setValues(String name, int age, Object matr_num) {
        this.name = name;
        this.age = age;
        this.matr_num = matr_num;
    }

    public String getValues() {
        String stud = name + age + matr_num;
        return stud;
    }
}
