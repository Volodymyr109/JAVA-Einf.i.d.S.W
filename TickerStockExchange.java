package ticker;

public class TickerStockExchange {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("args.length != 1");
            System.out.println("Argument 1/3 of the amount " + "instances to be created");
            System.out.println("Terminating program");
            System.exit(-1);
        }

        final int N = Integer.parseInt(args[0]);

        TickerCompany c[] = new TickerCompany[3 * N];

        for (int i = 0; i < c.length; i++) {
            c[i] = new TickerCompany("Toto_" + i);
        }

        for (int i= 0; i < 2 * N; i++) {
            System.out.println(c[i].getName());
            c[i] = null;
        }
        for (int i= 2 * N; i < 3 * N; i++) {
            System.out.println(c[i].getName());
            c[i] = null;
        }
        while(true);
    }
}