import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
/*
AUFGABE
• ReplaceWordWriter
– Erbt von der Klasse BufferedWriter.
– Bekommt als Konstruktorparameter einen java.io.Writer, sowie einen String
  replacement.
– Überschreibt die Methode write(String str) so, dass der
  ReplaceWordWriter den Parameter str wieder schreibt. Dabei soll jedes Wort in
  str, welches mit einem Großbuchstaben anfängt, durch den String replacement ersetzt werden.
 */
class ReplaceWordWriter extends BufferedWriter { // laut der aufgabe! Erbt von der Klasse BufferedWriter.
    //Ersetzungswort (replacement) speichert.
    private final String replacement;

    //PrintStream und das Ersetzungswort als Parameter akzeptiert und die Instanz des ReplaceWordWriter erstellt
    public ReplaceWordWriter(PrintStream writer, String replacement) { // laut der aufgabe! Bekommt als Konstruktorparameter einen java.io.Writer, sowie einen String replacement.
        super(new OutputStreamWriter(writer));
        this.replacement = replacement;
    }

    //Methode, die den übergebenen String zum Schreiben in den BufferedWriter verwendet
    @Override
    public void write(String str) throws IOException { // laut der aufgabe! Überschreibt die Methode write(String str)
        String replacedStr = str.replaceAll("\\b[A-Z]\\w*\\b", replacement); //String wird mithilfe des regulären Ausdrucks durch das Ersetzungswort (replacement) ersetzt
        //wird an die ursprüngliche write()-Methode des übergeordneten BufferedWriter weitergegeben, um den Text in den Puffer zu schreiben.
        super.write(replacedStr);
    }
}