/*

"""FEHLERKORREKTUR"""

Satz 1. In der Methode uncertain(), nach dem switch-Statement,
benötigen wir eine break-Anweisung in den case 9: und case 10:
Abschnitten, um sicherzustellen, dass der Code nicht in den nächsten Abschnitt übergeht.

Satz 2. Einige der "uncertain"-Methoden werfen eine Ausnahme aus dem finally-Block.
In Java ist das nicht ratsam, weil eine solche Ausnahme die vorherige Ausnahme, die im try oder catch Block aufgetreten sein könnte, unterdrücken würde.
In den Methoden uncertain1(), uncertain2(), uncertain5(), uncertain8(), und uncertain9(), muss der Code so angepasst werden,
dass keine Ausnahmen aus dem finally-Block geworfen werden.

Satz 3. In der Methode uncertain7(), wird eine IOException geworfen, die nicht in der Methode behandelt oder deklariert wird,
was zu einem Compiler-Fehler führt.
Wir müssen diese Ausnahme entweder innerhalb der Methode behandeln oder sie in der Methodendeklaration mit throws IOException deklarieren.

Satz 4. In der Methode uncertain10(), die IOException wird nicht behandelt oder deklariert,was zu einem Compiler-Fehler führt.
Wie in Punkt 3 müssen wir diese Ausnahme entweder innerhalb der Methode behandeln oder sie in der Methodendeklaration mit throws IOException deklarieren.
 */

//1,2,5,6
import java.io.IOException;

public class UncertainException {

   private int i = 0;

   public static void uncertain(int number) {
      UncertainException uncertain = new UncertainException();
      int result = 0;

      try {
         System.out.println("uncertain" + number + "()");
         switch (number) {
            case 1:
               result = uncertain.uncertain1();
               break;
            case 2:
               result = uncertain.uncertain2();
               break;
            case 3:
               result = uncertain.uncertain3();
               break;
            case 4:
               result = uncertain.uncertain4();
               break;
            case 5:
               result = uncertain.uncertain5();
               break;
            case 6:
               result = uncertain.uncertain6();
               break;
            case 7:
               result = uncertain.uncertain7();
               break;
            case 8:
               result = uncertain.uncertain8();
               break;
               // add break
            case 9:
               result = uncertain.uncertain9();
               break;
               // add break
            case 10:
               result = uncertain.uncertain10();
               break;
         }
         System.out.println("result = " + result + ", i = " + uncertain.i);
      } catch (Exception e) {
         System.out.println("i = " + uncertain.i + " Exception (" + e.getClass().getName() + ")");
      } finally {
      }
   }

   public static void main(String args[]) {
      for (int i = 1; i <= 10; ++i) {
         uncertain(i);
      }
   }
   // bevor war es ausser "breaks in cases 9 und 10" korrekt

   // dann finally-Blocks In Java ist das nicht zu empfohlen,
   // weil eine solche Ausnahme die vorherige Ausnahme, die im try oder catch Block aufgetreten sein könnte, unterdrücken würde,
   // deswegen mach man finally-Blocks aus uncertain1(), uncertain2(), uncertain5(), uncertain8(), und uncertain9() weg

   // finally-Block weg
   public int uncertain1() {
      try {
         throw new RuntimeException();
      } catch (RuntimeException e) {
         i++;
         throw new ClassCastException();
      } finally {
         i++;
      }
   }

   // finally-Block weg, muss der Code so angepasst werden, dass keine Ausnahmen aus dem finally-Block geworfen werden.
   public int uncertain2() {
      for (; ; ) {
         try {
            break;
         } catch (RuntimeException e) {
            i++;
         } finally {
            i++;
         }
      }
      return i++;
   }

   public int uncertain3() {
      do {
         try {
            throw new RuntimeException();
         } catch (RuntimeException e) {
            i++;
            continue;
         } finally {
            i++;
         }
      } while (false);
      return i++;
   }

   public int uncertain4() {
      try {
         return i++;
      } catch (RuntimeException e) {
         i++;
      } finally {
         i++;
      }
      return i++;
   }

   // finally-Block weg, muss der Code so angepasst werden, dass keine Ausnahmen aus dem finally-Block geworfen werden.
   public int uncertain5() {
      try {
         return i;
      } finally {
         i++;
      }
   }

   public int uncertain6() {
      try {
         throw new RuntimeException();
      } finally {
         return ++i;
      }
   }

   //In der Methode uncertain7(), wird eine IOException geworfen, die nicht in der Methode behandelt oder deklariert wird, was zu einem Compiler-Fehler führt.
   //Man muss der Methodendeklaration mit throws IOException deklarieren.
   public int uncertain7() throws IOException {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException e) {
         i++;
      } finally {
         return i++;
      }
   }

   // finally-Block weg, muss der Code so angepasst werden, dass keine Ausnahmen aus dem finally-Block geworfen werden.
   public int uncertain8() {
      try {
         throw new NumberFormatException();
      } catch (RuntimeException e) {
         i++;
         throw new RuntimeException();
      } finally {
         i++;
      }
   }

   // finally-Block weg, muss der Code so angepasst werden, dass keine Ausnahmen aus dem finally-Block geworfen werden.
   public int uncertain9() {
      try {
         throw new ClassCastException();
      } catch (RuntimeException e) {
         return i++;
      } finally {
         i++;
      }
   }

   //In der Methode uncertain7(), wird eine IOException geworfen, die nicht in der Methode behandelt oder deklariert wird, was zu einem Compiler-Fehler führt.
   //Man muss der Methodendeklaration mit throws IOException deklarieren.
   public int uncertain10() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException | IOException e) {
      }
      return 1;
   }
}


//DER bereitgestellte CODE, der falsch funktionierte - wurde kommentiert
/*


Exception in thread "main" java.lang.Error: Unresolved compilation problems:
        The field UncertainException.i is not visible
        The field UncertainException.i is not visible

        at UncertainExceptionFehler.uncertain(UncertainExceptionFehler.java:43)
        at UncertainExceptionFehler.main(UncertainExceptionFehler.java:52)

import java.io.IOException;

public class UncertainException {

   private int i = 0;

   public static void uncertain(int number) {
      UncertainException uncertain = new UncertainException();
      int result = 0;

      try {
         System.out.println("uncertain" + number + "()");
         switch (number) {
            case 1:
               result = uncertain.uncertain1();
               break;
            case 2:
               result = uncertain.uncertain2();
               break;
            case 3:
               result = uncertain.uncertain3();
               break;
            case 4:
               result = uncertain.uncertain4();
               break;
            case 5:
               result = uncertain.uncertain5();
               break;
            case 6:
               result = uncertain.uncertain6();
               break;
            case 7:
               result = uncertain.uncertain7();
               break;
            case 8:
               result = uncertain.uncertain8();
               break;
            case 9:
               result = uncertain.uncertain9();
            case 10:
               result = uncertain.uncertain10();
         }
         System.out.println("result = " + result + ", i = " + uncertain.i);
      } catch (Exception e) {
         System.out.println("i = " + uncertain.i + " Exception (" + e.getClass()
               .getName() + ")");
      } finally {
      }
   }
   public static void main(String args[]) {
      for (int i = 1; i <= 10; ++i) {
         uncertain(i);
      }
   }

   public int uncertain1() {
      try {
         throw new RuntimeException();
      } catch (RuntimeException e) {
         i++;
         throw new ClassCastException();
      } finally {
         i++;
         throw new NumberFormatException();
      }
   }

   public int uncertain2() {
      for (; ; ) {
         try {
            break;
         } catch (RuntimeException e) {
            i++;
         } finally {
            i++;
            throw new RuntimeException();
         }
      }
      return i++;
   }

   public int uncertain3() {
      do {
         try {
            throw new RuntimeException();
         } catch (RuntimeException e) {
            i++;
            continue;
         } finally {
            i++;
         }
      } while (false);
      return i++;
   }

   public int uncertain4() {
      try {
         return i++;
      } catch (RuntimeException e) {
         i++;
      } finally {
         i++;
      }
      return i++;
   }

   public int uncertain5() {
      try {
         return i;
      } finally {
         throw new RuntimeException();
      }
   }

   public int uncertain6() {
      try {
         throw new RuntimeException();
      } finally {
         return ++i;
      }
   }

   public int uncertain7() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException e) {
         i++;
      } finally {
         return i++;
      }
   }

   public int uncertain8() {
      try {
         throw new NumberFormatException();
      } catch (RuntimeException e) {
         i++;
         throw new RuntimeException();
      } finally {
         i++;
      }
   }

   public int uncertain9() {
      try {
         throw new ClassCastException();
      } catch (RuntimeException e) {
         return i++;
      } finally {
         return i++;
      }
   }

   public int uncertain10() {
      try {
         throw new java.io.IOException();
      } catch (RuntimeException | IOException e) {
      }
      return 1;

   }
}
*/
