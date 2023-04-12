public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2,3);
        Fraction f3 = new Fraction(4,0);

        Fraction fm1 = f1.multiply(2);
        System.out.println("• Fraction multiply(int factor): " + f1 + " *2/1 = " + fm1);

        Fraction fm2 = f2.multiply(f2);
        System.out.println("• Fraction multiply(Fraction factor): " + f1 + " * " + f2 + " = " + fm2);

        Fraction fd3 = f1.divide(f2);
        System.out.println("• Fraction divide(Fraction divisor): " + f1 + " / " + f2 + " = " + fd3);

        Fraction fm4 = f1.multiply(f2, f3);
        System.out.println("• Fraction multiply(Fraction... factors): " + f1 + " * " + f2 + " * " + f3 + " = " + fm4);

        // fm - fraction mult.
        // fd - fraction div.
    }
}
