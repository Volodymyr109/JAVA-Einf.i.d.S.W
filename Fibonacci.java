public class Fibonacci {
    private int f1 = 1;
    private int f2 = 1;

    public int next() {
        int count = f1;
        f1 += f2;
        f2 = count;
        return f2;
    }
}