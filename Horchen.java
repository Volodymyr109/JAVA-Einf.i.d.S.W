package Spezielle_Threads;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Horchen {

	public static void main(String[] args) {

		if (args.length != 1) { //ueberprueft, ob ein Argument an das Programm uebergeben wurde
			System.out.println(" genau ein File/Directory muss angegeben werden");
			System.exit(1); // exit
		}
		//Dateiobjekt als f initialisiert
		final File f = new File(args[0]);

		// ueberprueft ob datei existiert
		if (!f.exists()) {
			System.out.println(f + " existiert nicht");
			System.exit(1);
		}

		//Ein TimerTask-Objekt namens timerTask wird erstellt, indem die Klasse HorchenTask verwendet wird und f als Argument uebergeben wird.
		final TimerTask timerTask = new HorchenTask(f);
		final Timer timer = new Timer();

		//Es wird ein Shutdown-Hook definiert, der beim Beenden des Programms aufgerufen wird.
		// Im Shutdown-Hook wird der Timer abgebrochen und eine Meldung wird auf der Konsole ausgegeben.
		Thread shutdownHook = new Thread() {
			public void run() {
				timer.cancel();
				System.out.println("Programm wurde beendet");
			}
		};
		// add Shutdown-Hook
		Runtime.getRuntime().addShutdownHook(shutdownHook);

		System.out.println("Beenden mit strg + c");

		//Der Timer wird gestartet und der TimerTask wird alle 500 Millisekunden (0,5 Sekunden) ausgeführt.
		timer.schedule(timerTask, 0, 500);
	}

	private static void handleError(String message) {
		System.out.println(message);
		printUsage();
		System.exit(1);
	}

	private static void printUsage() {
		System.out.println("Usage: java io/ListenFile FileOrDirectoryName ");
		System.out.println("Terminate with ctrl + C");
	}
}

