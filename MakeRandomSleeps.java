package threads;

/**
 * Runs a {@link Sleeper} and a {@link RandomGenerator} with the same
 * {@link Queue} which has a capacity of {@code MAX_VALUES}.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class MakeRandomSleeps {

	//Konstante "MAX_VALUES", die angibt, wie viele Werte die Warteschlange queue maximal speichern kann.
	public static final int MAX_VALUES = 4;

	public static void main(String[] args) {
		//Warteschlange für Long-Werte namens "randoms" erstellt. Diese Warteschlange hat eine maximale Kapazität von "MAX_VALUES".
		Queue<Long> randoms = new Queue<Long>(MAX_VALUES);
		/*
		Thread-Objekte erstellt: "a" vom Typ "RandomGenerator" und "b" vom Typ "Sleeper". Der "RandomGenerator"-Thread generiert Zufallswerte und
		fügt sie in die Warteschlange "randoms" ein, während der "Sleeper"-Thread die Werte aus der Warteschlange entnimmt und für die angegebene Zeit schläft.
		 */
		Thread a = new RandomGenerator(randoms);
		Thread b = new Sleeper(randoms);
		/*
		Die beiden Threads "a" und "b" werden mit der Methode "start()" gestartet.
		Dadurch wird die "run()" Methode jedes Threads aufgerufen und die Ausführung beginnt.
		 */
		a.start();
		b.start();
		/*
		startet zwei Threads: einen "RandomGenerator"-Thread und einen "Sleeper"-Thread.
		Der "RandomGenerator"-Thread generiert Zufallswerte und fügt sie in die Warteschlange ein,
		während der "Sleeper"-Thread die Werte aus der Warteschlange entnimmt und für die angegebene Zeit schläft.
		 */
	}
}
