package Aufgabe4_hash_eq;

public class TestStudentAndPerson {
    public static void main(String[] args) {

        Person p1 = new Person("John", 18);
        Person p2 = new Person("Tom", 30);
        Person p3 = new Person("Hans", 50);

        Student s1 = new Student("Jack", 21, 123);
        Student s2 = new Student("Dave", 22, 456);
        Student s3 = new Student("Nick", 23, 789);

        /* Test equals und hashCode für Person
           ob Personen verschiedene hashCode haben und ob Personen identisch sind
         */
        System.out.println("Person1 equals Person2: " + p1.equals(p2)); // false
        System.out.println("Person1 equals Person3: " + p2.equals(p3)); // true

        System.out.println("Person " + p1.name + " hashCode: " + p1.hashCode());
        System.out.println("Person " + p2.name + " hashCode: " + p2.hashCode());
        System.out.println("Person " + p3.name + " hashCode: " + p3.hashCode());
        System.out.println("\n");

        /* Test equals und hashCode für Student
           ob Studenten verschiedene hashCode haben und ob Studenten identisch sind
         */
        System.out.println("Student1 equals Student2: " + s1.equals(s2)); // false
        System.out.println("Student1 equals Student3: " + s1.equals(s3)); // true

        System.out.println("Student" + s1.name + " hashCode: " + s1.hashCode());
        System.out.println("Student" + s2.name + " hashCode: " + s2.hashCode());
        System.out.println("Student" + s3.name + " hashCode: " + s3.hashCode());
    }
}
