package Aufgabe_9_3_Stroeme;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.PatternSyntaxException;

public class SearchLines {

	public static void main(String[] args) {
		// Überprüft, ob genau ein Argument übergeben wurde
		if (args.length != 1) { // 0
			System.out.println("Nur ein Argument!");
			//Programm wird gestoppt und das Programm wird mit dem Exit-Code 1 beendet.
			System.exit(1); // fehler
		}
		//Speichere das übergebene Argument
		String arg = args[0];
		//Deklaration einer ReadLines-Variable
		ReadLines reader = null;

		try {
			try {
				reader = new ReadLines(new InputStreamReader(System.in), arg); // read obj erstellt
			} catch (PatternSyntaxException E) { //Unchecked exception thrown to indicate a syntax error in a regular-expression pattern.
				System.out.println(arg + " ist keine gültige Eingabe! ");
				// dann exit wenn fehler in pattern
				System.exit(1);
			}
			String line;
			//Geht alle Lines durch, bis eine gleich null/leer ist
			System.out.println(arg + " hat in der Datei folgende Matches");
			while ((line = reader.readLine()) != null) { // liesst Zeilen
				if (reader.getAmountOfMatches() > 0) {
					// dann Gibt die gelesene Zeile, die Zeilennummer und die Anzahl der Übereinstimmungen aus.
					System.out.printf(line + "  in Zeile " +  reader.getLineNumber() + " hat: "+ reader.getAmountOfMatches() +  " Matches %n");
				}
			}

		} catch (IOException E) { //Falls eine IOException auftritt, wird die Fehlermeldung auf der Konsole ausgegeben.
			E.printStackTrace();
		} finally { //Der finally-Block wird immer ausgeführt, unabhängig davon, ob eine Ausnahme auftritt oder nicht.
			try {
				reader.close();
			} catch (IOException e) { //Falls beim Schließen des Readers eine IOException auftritt, wird die Fehlermeldung auf der Konsole ausgegeben.
				e.printStackTrace();
			}
		}
	}

	 private static void handleError(String message) {
		 System.out.println(message);
		 // printUsage
		 printUsage();
		 // dann wird das Programm mit dem Exit-Code 1 beende
		 System.exit(1);
	 }

	 private static void printUsage() {
		 System.out.println("Usage: java io/SearchLines RegularExpression < File");
	 }

 }

