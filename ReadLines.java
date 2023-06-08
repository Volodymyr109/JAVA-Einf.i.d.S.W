package Aufgabe_9_3_Stroeme;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadLines extends LineNumberReader {
	//Deklaration einer finalen Variablen vom Typ "Pattern", die ein regulärer Ausdruck darstellt.
	private final Pattern pattern;
	//Deklaration einer Variablen vom Typ "int" zur Zählung der Matching.
	private int zaehler;
	// der Konstruktor initialisiert die Instanz der Klasse
	public ReadLines(Reader in, String string) { //werden ein Reader-Objekt und ein regulärer Ausdruck als Parameter übergeben
		super(in);
		this.pattern = Pattern.compile(string);
		this.zaehler = 0;
	}

	@Override
	public String readLine() throws IOException {
		String line = super.readLine();
		zaehler = 0; // 0 setze
		if (line != null) { //bis keine Zeichen mehr in der Line sind ja prüft, ob die gelesene Zeile nicht null ist.
			Matcher Maetscher = this.pattern.matcher(line); // erstele matcher obj
			while (Maetscher.find()) { //Sucht nach Matches
				zaehler++; // ++ weiter
			}
		}
		return line; // ret
	}
	//Gibt die Anzahl der Matches zurück, die während des Lesens der Zeilen gefunden wurden.
	public int getAmountOfMatches() {
		return this.zaehler;
	}
}

 