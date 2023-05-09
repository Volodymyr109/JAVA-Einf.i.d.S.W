package Fraction;

public class Fraction {

    //Größten gemeinsamen Teiler um den Bruch vor der Kürzung zu reduzieren
    //recursion um ggt* zu berechnen, inkl. prüf ob der teiler gleich null ist
   public static int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
   }

   private final int numerator;
   private final int denominator;

   //Creates a Fraction object with numerator and denominator 1, reduces the fraction with creation.
   public Fraction(int numerator) {
      this(numerator, 1);
   }

   // Obj der Klasse, das  int numerator, int denominator nimmt und = oder !=0 prueft
   public Fraction(int numerator, int denominator) {
      if (denominator == 0) {
          System.out.println("denominator == 0 is not possible");
          System.out.println("Terminating program");
          System.exit(-1);
      }

      // Gr. gemeis teiler (creates greatest common divisior).
      int gcd = Fraction.gcd(numerator, denominator);
      
      /*
       * check sign, make denominator positive --> the sign of the fraction
       * is always stored only in the numerator. 
       */
      if (denominator / gcd < 0) {
          gcd *= -1;
      }

      this.numerator = numerator / gcd;
      this.denominator = denominator / gcd;
   }

    // add fractions mit other, numerator und denominator
   public Fraction add(Fraction other) {
       int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
       int newDenominator = this.denominator * other.denominator;
       return new Fraction(newNumerator, newDenominator);
   }

    // sub fractions mit other, numerator und denominator
    public Fraction subtract(Fraction other) {
       int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
       int newDenominator = this.denominator * other.denominator;
       return new Fraction(newNumerator, newDenominator);
   }

    // div fractions mit other, numerator und denominator
   public Fraction divide(Fraction other) {
       int newNumerator = this.numerator * other.denominator;
       int newDenominator = this.denominator * other.numerator;
       return new Fraction(newNumerator, newDenominator);
   }

   public int getDenominator() {
      return this.denominator;
   }

   public int getNumerator() {
      return this.numerator;
   }

    //Multiplies this Fraction with another Fraction mit factor
   public Fraction multiply(Fraction factor) {
      return new Fraction(this.numerator * factor.numerator, this.denominator
            * factor.denominator);
   }

   public Fraction multiply(Fraction... factors) {
      Fraction result = this;
      //variable parameters may be treated like an array inside the method
      for (int i = 0; i < factors.length; i++) {
         result = result.multiply(factors[i]);
      }
      return result;
   }

   // Multiplies this Fraction with int n.  n factor to multiply with return The product as a new Fraction
   public Fraction multiply(int n) {
      return new Fraction(this.numerator * n, this.denominator);
   }

    //parseFraction macht Darstellung des Bruchs als zahl1/zahl2 und Prueft format x/y
   public static Fraction parseFraction(String s) { 
	   // nimmt s string als Bruch darstellung
       String[] parts = s.split("/"); // s wäre mit trennzeichen aufgeteilt // REGEX WIE INPUT USERS SEIEN SOLL
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
   //man deklariert "/" als default symbol zwischen numerator und denominator
   public String toString() {
      return numerator + "/" + denominator;
   }
}