/*
AUFGABE
Das außerirdische Volk der Marklar benutzt unsere Sprache mit der Ausnahme, dass alle Dinge, Orte,
Personen usw. durch das Wort Marklar ersetzt werden. Da Sie ohnehin der Meinung sind, dass man
eine solche Sprache gar nicht verstehen kann, ersetzen Sie bei Ihrer Übersetzung in die
MarklarSprache einfach alle großgeschriebenen Wörter durch das Wort Marklar.
Schreiben Sie ein Programm, das diese Form der Übersetzung wiederspiegelt und nebenläufige Streams benutzt.
Hierzu sollen Sie folgende Klassen anlegen, welche die gegebenen Eigenschaften erfüllen sollen:
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

/*
AUFGABE
• MarklarTranslator
– Diese Klasse soll Ihre main()-Methode beinhalten. Alle folgenden Stichpunkte sollen
  innerhalb der main()-Methode realisiert werden.
– Erstellen Sie eine Instanz von WriterThread. Als InputStream sollen Sie System.in
  benutzen.
– Erstellen Sie eine Instanz von ReplaceWordWriter, welche auf System.out
  schreiben soll und als replacement-String das Wort „Marklar“ verwendet.
– Erstellen Sie eine Instanz von ReaderThread, der als Konstruktorparameter den soeben erstellten ReplaceWordWriter übergeben bekommt.
  Verbinden Sie die erstellte Instanz mit dem zuvor erstellten WriterThread.
– Starten Sie zwei Threads mit den Instanzen von WriterThread und ReaderThread.
– Erstellen Sie einen Shutdown-Hook, der die Streams der Instanzen von WriterThread
  und ReaderThread bei Beendigung des Programms explizit schließt
 */
public class MarklarTranslator {
	public static void main(String[] args) {
		try {
			// Eine Instanz von WriterThread wird erstellt und mit dem System.in-Stream als Eingabe verbunden. Dies ermöglicht das Lesen von Benutzereingaben.
			WriterThread writerThread = new WriterThread(System.in);
			//wird erstellt und mit dem System.out-Stream verbunden
			ReplaceWordWriter replaceWordWriter1 = new ReplaceWordWriter(System.out, "Marklar");
			//wird erstellt und mit dem System.out-Stream verbunden
			ReplaceWordWriter replaceWordWriter2 = new ReplaceWordWriter(System.out, "Marklar");
			//wird erstellt und mit dem replaceWordWriter2 verbunden. Dadurch wird die Ausgabe des replaceWordWriter2 gelesen und verarbeitet.
			ReaderThread readerThread = new ReaderThread(replaceWordWriter2);

			//Methode des WriterThread wird aufgerufen, um den readerThread mit dem writerThread zu verbinden.
			//Dadurch wird der Output des writerThread an den readerThread weitergeleitet.
			writerThread.connect(readerThread);
			// Ein Thread für den writerThread wird erstellt.
			Thread writerThreadThread = new Thread(writerThread);
			Thread readerThreadThread = new Thread(readerThread);
			// start thread
			writerThreadThread.start();
			readerThreadThread.start();
			/*
			Ein Shutdown-Hook ist ein spezieller Thread, der beim Beenden des Programms ausgeführt wird, bevor es vollständig beendet wird.
			Der Zweck des Shutdown-Hooks ist es, bestimmte Aufräumarbeiten durchzuführen oder Ressourcen freizugeben, bevor das Programm beendet wird.
			 */

			//Shutdown-Hook wird hinzugefügt, um die Streams der Threads und der ReplaceWordWriter-Instanzen beim Beenden des Programms explizit zu schließen.
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				try {
					//close-Methoden aufgerufen, um die Streams der writerThread, readerThread, replaceWordWriter1 und replaceWordWriter2 zu schließen
					writerThread.close();
					readerThread.close();
					replaceWordWriter1.close();
					replaceWordWriter2.close();
				} catch (IOException e) { ////Falls während des Lesens oder Schreibens ein Fehler auftritt, wird eine IOException abgefangen
					e.printStackTrace();
				}
			}));
			// hauptprogramm endet
			writerThreadThread.join();
			readerThreadThread.join();

			replaceWordWriter1.flush(); // Flushing the ReplaceWordWriter to ensure all data is written
			replaceWordWriter2.flush(); // Flushing the ReplaceWordWriter to ensure all data is written
		} catch (IOException | InterruptedException e) { //verwendet, um auf das Beenden der Threads zu warten.
			e.printStackTrace();
		}
	}
}