package ticker;

public class TickerCompany {

    private String name;

    public TickerCompany(String companyName) {
        this.name = companyName;
    }

    public String getName() {
        return this.name;
    }

    public void changeStockPrice(double stockPrice) {
        ticker.Ticker.getInstance().print("Company name: " + this.name + " Stock price: " + stockPrice);
    }
    protected void finalize() {
        ticker.Ticker.getInstance().print("Company name: " + name + " is insolvent");
    }
}

