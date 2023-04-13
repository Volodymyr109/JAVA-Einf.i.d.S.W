public class FibonacciPrint {
    public static void main(String[] args) {

        int n = 10; //menge der fib. zahlen

        // new macht speicherplatz für "neue" klasse frei, push quasi
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("+---+--------+"); //struktur outputs
        System.out.println("| n | f(n)   |"); //struktur outputs
        System.out.println("+---+--------+"); //struktur outputs
        System.out.printf("|   |        |\n", 0, 0); //struktur outputs
        // schleife geht n mal, und importiert klasse fibonacci, die die fib. zahlen rechnet
        for (int i = 1; i <= n; i++) {
            int fn = fibonacci.next();
            System.out.printf("|%3d|%8d|\n", i, fn); //struktur outputs, %3d ist als quasi "tostring" benötigt
        }
        System.out.println("+---+--------+"); //struktur outputs
    }
}
