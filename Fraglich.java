public class Fraglich {

   // a = 0 weil static int
   static int a;

   public static void main(String[] args) {
      int a = 3;
      int[] c = {18, 2, 1, 8};

      /*** Stelle 1 ***/
      //Stelle 1: a=3, c={18, 2, 1, 8}

      initialize();

      /*** Stelle 3 ***/
      //Stelle 3: a=23 weil static void initialize() a = 23, b=0, c bleibt {18, 2, 1, 8}

      for (int b = -1; b < 1; b += 3) {

         /*** Stelle 4 ***/
         //Stelle 4: a=23, b=-1, c={0, 2, 1, 8} c[b + 2] is equivalent to c[b + 2] und = 0

         a /= 2;
         c[b + 2] -= c[b + 2]; //  c[b + 2] is equivalent to c[b + 2] und = NULL WEIL B = 0 deswegen c={0, 2, 1, 8}
      }

      /*** Stelle 5 ***/
      //Stelle 5: a=11  weil a(23) /= 2; und die andere: b=-1, c={0, 2, 1, 8}

      for (a = 2; a < 3; a++) {
         int b = 2;
         c[a] -= c[b];

         /*** Stelle 6 ***/
         //Stelle 6: a=2, b=2, c={0, 2, 1, 8} weil a = 2 und b = 2 und c[a] -= c[b]

      }

      /*** Stelle 7 ***/
      //Stelle 7 bleibt : a=2, b=2, c={0, 2, -1, 8}

      int b = method(a + c[a - 3]);

      /*** Stelle 9 ***/
      //Stelle 9: a=9, b=1, c={0, 2, -1, 8} weil a + c[a - 3] und method benützt

      b = 7 + method(++a, c);

      /*** Stelle 11 ***/
      // a=9, b=1, c={0, 2, -1, 8} weil method für variable a benützt also new int[]{b, a, c[0], c[2], c[3], c[1]}

      a = method(method(method(a), new int[]{b, a, c[0], c[2], c[3], c[1]}));

      /*** Stelle 15 ***/
      //Stelle 15: a=10, b=1, c={0, 2, 1, 8} WEIL a++, b bleibt

   }

   static void initialize() {

      int b = 0;
      a = 23;

      /*** Stelle 2 ***/
      //a=10, b=1, c={0, 2, -1, 8} zu obene Stelle

   }

   protected static int method(int b) {

      /*** Stelle 8, 12 bzw. 14 ***/
      //Stelle 8: a=23, b=0, c={0, 10, -1, 8}
      //a=23, b=0, c={0, 10, -1, 8}
      // a=11, b=1, c={0, 2, -1, 8} WEIL int a/2 und B nach der stelle 2 ++, C bleibt
      //a=11, b=1, c={0, 2, -1, 8} WEIL int a/2 und B nach der stelle 2 ++, C bleibt

      return a;
   }

   private static int method(int a, int[] c) {

      a++;
      c[0] /= 2;
      c[0] = c[0] + c[1];
      c = new int[4];

      /*** Stelle 10 bzw. 13 ***/
      //Stelle 10: a=11, b=1, c={0, 2, -1, 8}  WEIL int a/2 und B nach der stelle 2 ++, C bleibt

      return a;
   }

}
