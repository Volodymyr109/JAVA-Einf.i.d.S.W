public class Fraction {
    private int numerator;
    private int denominator;

    // wird aufgerufen, wenn ein neues Objekt dieser Klasse erzeugt wird
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator muss > 0 sein");
        }
        // wird der größte gemeinsame Teiler (ggT) des Zählers (numerator) und des Nenners berechnet
        int ggt = ggt(Math.abs(numerator), Math.abs(denominator));
        this.numerator = numerator / ggt;
        this.denominator = denominator / ggt;
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }
    //Fractions Addiert/Subtrahiert/Multipliziert/Dividiert den aktuellen Bruch mit dem als Argument übergebenen Bruch
    public Fraction add(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction other) {
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator, newDenominator);
    }
    /*
    parseFraction macht Darstellung des Bruchs als zahl1/zahl2
     */
    public static Fraction parseFraction(String s) { // nimmt s string als Bruch darstellung
        String[] parts = s.split("/"); // s wäre mit trennzeichen aufgeteilt
        if (parts.length == 1) { // geteilt der Input
            return new Fraction(Integer.parseInt(parts[0]), 1);
        } else if (parts.length == 2) { // Wenn die zusammen eine Zahl vorhanden, wird es als integer erstellt z.b. 2/2
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            return new Fraction(numerator, denominator);
        } else {
            throw new IllegalArgumentException("Invalid fraction format: " + s);
        }
    }
    /*
     Größten gemeinsamen Teiler um den Bruch vor der Kürzung zu reduzieren
     recursion um ggt* zu berechnen, inkl. prüf ob der teiler gleich null ist
     */
    private static int ggt(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return ggt(b, a % b);
        }
    }
    //man deklariert "/" als default symbol zwischen numerator und denominator
    @Override
    public String toString() {
        return numerator + "/" + denominator; //man deklariert "/" als default symbol zwischen numerator und denominator
    }
}