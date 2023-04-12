import java.lang.Math;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    // Berechnet den größten gemeinsamen Teiler von zwei ganzen Zahlen
    // Wenn zweite zahl gleich null ist, ist der größte gemeinsame Teiler gleich dem Betrag von erster Zahl
    public Fraction(int numerator, int denominator) {
        int ggt = ggt(numerator, denominator); //*ggt - größten gemeinsamen Teiler
        this.numerator = numerator / ggt;
        this.denominator = denominator / ggt;
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    //Fractions, die mult/div Factoren als int zahl nimmt und in FractionTest.java implementiert werden
    public Fraction multiply(int factor) {
        return new Fraction(this.numerator * factor, this.denominator);
    }

    public Fraction multiply(Fraction factor) {
        return new Fraction(this.numerator * factor.numerator, this.denominator * factor.denominator);
    }

    public Fraction divide(Fraction divisor) {
        return new Fraction(this.numerator * divisor.denominator, this.denominator * divisor.numerator);
    }

    // es nimmt Argument in factors und das Ergebnis mit dem vorherigen Ergebnis multipliziert und als results das neue Ergebnis als neues Fraction gegeben werden
    public Fraction multiply(Fraction... factors) {
        Fraction result = this;
        for (Fraction factor : factors) {
            result = result.multiply(factor);
        }
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator; //man deklariert "/" als default symbol zwischen numerator und denominator
    }

    // recursion um ggt* zu berechnen, inkl. prüf ob der teiler gleich null ist
    // math.abs gibt den absoluten Wert eines numerischen Ausdrucks
    private int ggt(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return ggt(b, a % b);
    }
}