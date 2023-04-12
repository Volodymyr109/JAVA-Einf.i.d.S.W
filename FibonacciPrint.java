public class FibonacciPrint {
    public static void main(String[] args) {

        int n = 10;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("+---+--------+");
        System.out.println("| n | f(n)   |");
        System.out.println("+---+--------+");
        System.out.printf("|   |        |\n", 0, 0);
        for (int i = 1; i <= n; i++) {
            int fn = fibonacci.next();
            System.out.printf("|%3d|%8d|\n", i, fn);
        }
        System.out.println("+---+--------+");
    }
}