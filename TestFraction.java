package Fraction;
import java.util.Scanner;


public class TestFraction {

	private int nrErrors;

	public static void main(String[] args) {

		   // Fraction Test mit dem Rechner
	       System.out.println("Start testing...");
	       TestFraction test = new TestFraction();
	       test.testToString();
	       test.testGcd();
	       test.testMultiply();
	       test.testDivide();
	       test.testAdd();
	       test.testSubtract();
	       
	       System.out.println("Found " + test.getNrErrors() + " errors");
	       System.out.println("... testing finished");

		   Scanner scanner = new Scanner(System.in);
		   System.out.println("Enter 1. fraction (bsp. x/y):");
		   String fraction1String = scanner.nextLine();
		   Fraction fraction1 = Fraction.parseFraction(fraction1String);

		   System.out.println("Enter operator (+, -, *, /):");
		   String operator = scanner.nextLine();

		   System.out.println("Enter 2. fraction (bsp. x/y):");
		   String fraction2String = scanner.nextLine();
		   Fraction fraction2 = Fraction.parseFraction(fraction2String);

		   Fraction result;

		   switch (operator) {
			   case "+":
				   result = fraction1.add(fraction2);
				   break;
			   case "-":
				   result = fraction1.subtract(fraction2);
				   break;
			   case "*":
				   result = fraction1.multiply(fraction2);
				   break;
			   case "/":
				   result = fraction1.divide(fraction2);
				   break;
			   default:
				   System.err.println("Invalid operator: " + operator);
				   System.out.println("Geben Sie zwei Brüche und einen Operator (+, -, *, /) getrennt durch Leerzeichen ein.");
				   return;
		   }
		   System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = " + result.toString());

	   }

	private String getNrErrors() {
		   return null;
	}

	public void testToString() {
	       String errMsg = "toString";
	       Fraction a = new Fraction(1,2);
	       assertEquals("1/2",a, errMsg);

	       //Testing same string representation of Fraction, regardless of whether
	       //the first or second parameter during construction was negative
	       Fraction b = new Fraction(-1, 2);
	       assertEquals("-1/2", b, errMsg);
	       
	       Fraction c = new Fraction(1, -2);
	       assertEquals("-1/2", c, errMsg);
	       
	       //Testing that positive Fraction is not stored as two negative numbers
	       Fraction d = new Fraction(-1,-2);
	       assertEquals("1/2", d, errMsg);
	   }

	   // test gr. gemeins. teiler
	   public void testGcd() {
	       String errMsg = "Errr in gcd() method";
	       assertBool(Fraction.gcd(8, 2) == 2, errMsg);
	       assertBool(Fraction.gcd(5, 2) == 1, errMsg);
	       assertBool(Fraction.gcd(125, 50) == 25, errMsg);
	   }

	   // FERTIGE test
	   public void testMultiply() {
	       String errMsg = "testMultiply(Fraction)";
	       Fraction a = new Fraction(1,2);
	       Fraction b = new Fraction (-3,4);
	       assertEquals("-3/8", a.multiply(b), errMsg);
	       
	       errMsg = "testMultiply(int)";
	       assertEquals("5/1", a.multiply(10), errMsg);
	       
	       errMsg = "testMultiply(Fraction...)";
	       Fraction c = new Fraction(2,3);
	       assertEquals("-1/4", a.multiply(b,c), errMsg);
	       
	       //testing that varargs parameter may also be empty
	       assertEquals("1/2", a.multiply(), errMsg);
	   }

	// FERTIGE test
	public void testAdd() {
		   String errMsg = "TestAdd(Fraction";
		   Fraction a = new Fraction(1,2);
	       Fraction b = new Fraction(3,4);
	       Fraction c = new Fraction(-3,4);
	       
	       assertEquals("5/4", a.add(b), errMsg);
	       assertEquals("-1/4", a.add(c), errMsg);
	   }

	// FERTIGE test
	public void testSubtract() {
		   String errMsg = "TestAdd(Fraction";
		   Fraction a = new Fraction(1,2);
	       Fraction b = new Fraction(3,4);
	       Fraction c = new Fraction(-3,4);
	       
	       assertEquals("-1/4", a.subtract(b), errMsg);
	       assertEquals("5/4", a.subtract(c), errMsg);
	   }

	// FERTIGE test
	public void testDivide() {
	       String errMsg = "testDivide";
	       Fraction a = new Fraction(1,2);
	       Fraction b = new Fraction(3,4);
	       Fraction c = new Fraction(-3,4);
	       
	       assertEquals("2/3", a.divide(b), errMsg);
	       assertEquals("3/2", b.divide(a), errMsg);
	       assertEquals("-2/3", a.divide(c), errMsg);

	   }
	   
	   // assertBool prüft, ob eine gegebene boolesche Aussage "statement" wahr (true) ist.
	   // Wenn die Aussage nicht wahr ist, wird die Anzahl der Fehler ("nrErrors") erhöht und eine Fehlermeldung ("errorMsg") wird ausgegeben.
	   private void assertBool(boolean statement, String errorMsg) {
	       if(!statement) {
	           this.nrErrors++;
	           System.out.println(errorMsg);
	       }
	   }

	   // assertEquals prüft, ob eine erwartete Zeichenfolge "expected" mit einer tatsächlichen Zeichenfolge "actual" übereinstimmt.
	   // Wenn die beiden Zeichenfolgen nicht übereinstimmen, wird die Anzahl der Fehler erhöht und eine Fehlermeldung wird ausgegeben
	   private void assertEquals(String expected, Fraction actual, 
	           String methodName) {
	      assertEquals(expected, actual.toString(), methodName);
	   }

	   // assertEquals identisch mit der oben beschriebenen Methode "assertEquals",
	   // aber die tatsächliche Zeichenfolge wird in der "Fraction"-Methode in eine Zeichenfolge umgewandelt, bevor der Vergleich durchgeführt wird.
	   private void assertEquals(String expected, String actual, 
	           String methodName) {
	       
	      if (!expected.equals(actual)) {
	          this.nrErrors++;
	          System.out.println("FAIL in " + methodName 
	                 + "() [expectded: " + expected + " but was "+ actual + "]");
	      }
	   }
}
