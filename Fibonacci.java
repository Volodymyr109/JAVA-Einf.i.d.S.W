public class Fibonacci {
    private int f1 = 1;
    private int f2 = 1;

    // f1=1, f2=2, fn = f(n-1) + f(n-2) also 0 + 1 = 1. 1 + 1 =2. 1 + 2 = 3. 2 + 3 = 5
    public int next() {
        int count = f1;
        f1 += f2;  //dec
        f2 = count;
        return f2;
    }
}
