public class CompanyTest {

    public static void main(String[] args) {

        Company c1 = new Company("Weyland Yutani", 528.0, true);
        Company c2 = new Company("Umbrella", 491.0, true);

        System.out.println("--Stock price change ---------------------------------------------");
        // out change stock + insolvent
        c1.changeStockPrice(100.0, false);
        // garbage collector System.gc() - "man sagt: IDE, mach gc an (in heap)!" und IDE würde entscheiden, ob das notwendig ist
        System.gc();
        c2.changeStockPrice(-100.0 , true);
        System.gc();

    }
}