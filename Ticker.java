package ticker;
public class Ticker {

    private static Ticker ticker;

    private static final String LINE_SEP = System.lineSeparator();

    public static final String MESSAGE_SEP = "+++";

    private Ticker() {

    }

    public static Ticker getInstance(){
        if (ticker == null) {
            ticker = new Ticker();
        }
        return ticker;
    }

    public void print(String text) {
        text = text.replace(LINE_SEP, " ");
        System.out.println(MESSAGE_SEP + text);
    }
}
