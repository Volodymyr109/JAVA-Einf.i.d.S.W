public class Ticker {
    // deklarieren instance der Klasse
    private static Ticker instance = null;
    // konstruktor
    private Ticker() {}

    public static Ticker getInstance() {
        if (instance == null) {
            instance = new Ticker();
        }
        return instance;
    }

    // pattern des outputs (laut aufgabe)
    public void print(String text) {
        text = text.replace("\n", "");
        System.out.print("+++" + text + "+++" + "\n");
    }
}