import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

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
}