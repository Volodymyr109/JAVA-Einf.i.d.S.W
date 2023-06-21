package threads;
/* AUFGABE
1. Verändern Sie nur die Klassen threads.RandomGenerator und threads.Sleeper
und beheben Sie die Probleme durch die Synchronisation über ein geeignetes Monitor-Objekt
 */
/**
6 * A simple {@code Thread} which continuously writes uniformly distribute random
7 * values from 0 to {@code MAX_VALUE} to the given {@code Queue}. Will sleep
8 * {@code SLEEP_TIME} after every insertion.
9 *
10 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 /////
 Verändern Sie nur die Klassen threads.RandomGenerator und threads.Sleeper
 und beheben Sie die Probleme durch die Synchronisation über ein geeignetes Monitor-Objekt.
 /////
11 */
//Diese Klasse generiert zufällige Long-Werte und fügt sie einer Warteschlange hinzu, um von einem anderen Thread verwendet zu werden.
public class RandomGenerator extends Thread {

	//wird verwendet, um die Warteschlange der generierten Zufallswerte zu speichern.
	private Queue<Long> randoms;
	public static final long MAX_VALUE = 3000;
	public static final long SLEEP_TIME = 1000;
	//nimmt eine Warteschlange von Long-Werten entgegen und weist sie dem Datenfeld "randoms" zu.
	public RandomGenerator(Queue<Long> randoms) {
		this.randoms = randoms;
	}
	//ausgeführt, wenn der Thread gestartet wird.
	public void run() {
		try {

			while (true) { //die solange ausgeführt wird, bis der Thread unterbrochen wird.

				long random;
				synchronized (randoms) {
					while (this.randoms.full()) {
						randoms.wait();
					}
					/*
					Sobald Platz in der Warteschlange vorhanden ist,
					wird mit der Methode "Math.random()" ein zufälliger Wert zwischen 0 und "MAX_VALUE"
					generiert und der Variablen "random" zugewiesen.
					 */
					random = (long) (Math.random() * (double) MAX_VALUE);
					System.out.println("Now putting " + random); //ausgegeben, um anzuzeigen, dass der generierte Wert in die Warteschlange eingefügt wird.
					randoms.enq(random);
					randoms.notifyAll();
				}
			}

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}

