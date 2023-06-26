package threads;
/**
 * Einfacher {@code Thread}, der kontinuierlich gleichmäßig verteilte zufällige
 * Werte von 0 bis {@code MAX_VALUE} in die gegebene {@code Queue} schreibt.
 * Nach jeder Einfügung wird für {@code SLEEP_TIME} geschlafen.
 */
public class RandomGenerator extends Thread {

	private Queue<Long> randoms; // Die Warteschlange, in die die generierten Zufallswerte eingefügt werden
	public static final long MAX_VALUE = 3000;
	public static final long SLEEP_TIME = 1000;

	//Konstruktor, der eine Warteschlange von Long-Werten entgegennimmt und sie dem Datenfeld "randoms" zuweist.
	public RandomGenerator(Queue<Long> randoms) {
		this.randoms = randoms;
	}

	//Die Methode "run()" wird ausgeführt, wenn der Thread gestartet wird.
	public void run() {
		try {
			while (true) { // Die Schleife wird solange ausgeführt, bis der Thread unterbrochen wird.
				long random;
				synchronized (randoms) { // Ein Synchronisationsblock wird verwendet, um auf das Datenfeld "randoms" zuzugreifen.
					while (this.randoms.full()) { // Überprüft, ob die Warteschlange "randoms" voll ist.
						randoms.wait(); // Wenn die Warteschlange voll ist, ruft der Thread die Methode "wait()" auf und wartet darauf, dass Elemente entfernt werden.
					}
					random = (long) (Math.random() * (double) MAX_VALUE); // Generiert einen zufälligen Wert zwischen 0 und "MAX_VALUE".
					System.out.println("Now putting " + random); // Gibt aus, dass der generierte Wert in die Warteschlange eingefügt wird.
					randoms.enq(random); // Fügt den generierten Wert in die Warteschlange ein.
					randoms.notifyAll(); // Benachrichtigt andere Threads, dass neue Werte in die Warteschlange eingefügt wurden.
				}
				this.sleep(SLEEP_TIME); // Der Thread schläft für die angegebene Zeit.
			}
		} catch (InterruptedException ex) { // Falls der Thread während des Wartens unterbrochen wird (InterruptedException), wird eine Fehlermeldung ausgegeben.
			ex.printStackTrace();
		}
	}
}
