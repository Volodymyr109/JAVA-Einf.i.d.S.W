public class Fraglich {

   // a = 0 weil static int
   static int a;

   public static void main(String[] args) {
      int a = 3;
      int[] c = {18, 2, 1, 8};

      /*** Stelle 1 ***/
      //Stelle : a=3, c={18, 2, 1, 8}
      initialize();

      /*** Stelle 3 ***/
      //Stelle : a=23, b=0, c={18, 2, 1, 8}

      for (int b = -1; b < 1; b += 3) {

         /*** Stelle 4 ***/
         //Stelle : a=23, b=-1, c={0, 2, 1, 8}
         a /= 2;
         c[b + 2] -= c[b + 2];
      }

      /*** Stelle 5 ***/
      //Stelle : a=11, b=-1, c={0, 2, 1, 8}

      for (a = 2; a < 3; a++) {
         int b = 2;
         c[a] -= c[b];

         /*** Stelle 6 ***/
         //Stelle : a=2, b=2, c={0, 2, 1, 8}

      }

      /*** Stelle 7 ***/
      //Stelle : a=2, b=2, c={0, 2, -1, 8}
      int b = method(a + c[a - 3]);

      /*** Stelle 9 ***/
      //Stelle : a=9, b=1, c={0, 2, -1, 8}
      b = 7 + method(++a, c);

      /*** Stelle 11 ***/
      // a=9, b=1, c={0, 2, -1, 8}
      a = method(method(method(a), new int[]{b, a, c[0], c[2], c[3], c[1]}));

      /*** Stelle 15 ***/
      //Stelle : a=10, b=1, c={0, 2, -1, 8}
   }

   static void initialize() {

      int b = 0;
      a = 23;

      /*** Stelle 2 ***/
      //a=10, b=1, c={0, 2, -1, 8}
   }

   protected static int method(int b) {

      /*** Stelle 8, 12 bzw. 14 ***/
      //Stelle : a=23, b=0, c={0, 10, -1, 8}
      //a=23, b=0, c={0, 10, -1, 8}
      // a=11, b=1, c={0, 2, -1, 8}
      //a=11, b=1, c={0, 2, -1, 8}
      return a;
   }

   private static int method(int a, int[] c) {

      a++;
      c[0] /= 2;
      c[0] = c[0] + c[1];
      c = new int[4];

      /*** Stelle 10 bzw. 13 ***/
      //Stelle : a=11, b=1, c={0, 2, -1, 8}

      return a;
   }

}
