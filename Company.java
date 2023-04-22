public class Company {

    // deklarieren variables: name und stockPrice
    private String name;
    private double stockPrice;
    private boolean insolvent;

    // Konstruktor nimmt name und stockPrice als Instanzen der Klasse und Print variables und default insolvent check
    public Company(String name, double stockPrice, boolean insolvent) {
        this.name = name;
        this.stockPrice = stockPrice;
        this.insolvent = false;
        if (insolvent) {
            Ticker.getInstance().print(name + " " + stockPrice + " Status:" + " is not insolvent" + "\n");
        } else {
            Ticker.getInstance().print(name + " " + stockPrice + " Status:" + "insolvent" + "\n");
        }
    }

    // changeStockPrice nimmt name und out string mit "changed price" und boolean insolvent
    // Hinweis: Frage beim Testat über die alternative Einsätze if-else (ternäre operatoren)
    public void changeStockPrice(double d, boolean insolvent) {
        if (insolvent) {
            String message = name + " stock price changed to " + (stockPrice + d) + ", Status:" + " insolvent";
            Ticker.getInstance().print(message);
        } else {
            String message = name + " stock price changed to " + (stockPrice + d) + ", Status:" + " is not insolvent";
            Ticker.getInstance().print(message);
        }
        stockPrice += d;
    }

    /*
    dekoriert final out der Methode und wenn !insolvent dann is insolvent
    finalize init garbage collector des Programs (ruf System.gc in main funktion)
    */
    @Override
    protected void finalize() {
        Ticker.getInstance().print(name + " is insolvent");
    }
}

        // sieche Hinweis, str 21
        /*boolean insolvent > true String message = m1 : String message =  m2;
        String message = m1;
        String m1 = name + " stock price changed to " + (stockPrice + d) + " Status:" + " insolvent";
        String message = m2;
        String m2 = name + " stock price changed to " + (stockPrice + d) + " Status:" + " is not insolvent"; */