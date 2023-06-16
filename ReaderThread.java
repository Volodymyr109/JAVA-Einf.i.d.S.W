import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PipedReader;
import java.io.Writer;
/*
AUFGABE
• ReaderThread
– Erbt von der Klasse java.io.PipedReader.
– Implementiert das Interface java.lang.Runnable.
– Bekommt im Konstruktor einen java.io.Writer übergeben.
– Soll die run()-Methode überschreiben. In dieser soll stetig von dem
  java.io.PipedWriter, zu dem die java.io.PipedReader Instanz verbunden ist, zeilenweise gelesen werden. Alles was gelesen wird, soll direkt wieder über
  den bei der Instanziierung übergebenen java.io.Writer geschrieben werden.
 */
class ReaderThread extends PipedReader implements Runnable { // laut der Aufgabe Erbt von der Klasse java.io.PipedReader. Implementiert das Interface java.lang.Runnable.
    private final BufferedWriter writer;

    //konstr
    public ReaderThread(Writer writer) {
        this.writer = new BufferedWriter(writer);
    } // laut der aufgabe Bekommt im Konstruktor einen java.io.Writer übergeben.

    //Methode wird überschrieben, um die Funktionalität des Runnable-Interface zu implementieren. In dieser Methode wird eine Schleife ausgeführt,
    @Override
    public void run() {
        try {
            String line; //Eine Variable vom Typ String, in der die aktuell gelesene Zeile gespeichert wird.
            while ((line = this.readLine()) != null) { //solange wiederholt wird, bis readLine() null zurückgibt
                writer.write(line + "\n"); //In jeder Iteration wird die Methode readLine() aufgerufen, um die nächste Zeile vom PipedReader zu lesen.
                writer.flush(); //wird sofort durch flush() geleert, um die geschriebenen Daten sofort verfügbar zu machen.
                // Dadurch wird sichergestellt, dass die Daten nicht im Puffer verbleiben, sondern tatsächlich geschrieben werden.
            }
            writer.close(); //geschlossen
        } catch (IOException e) { //Falls während des Lesens oder Schreibens ein Fehler auftritt, wird eine IOException abgefangen
            e.printStackTrace();
        }
    }

    // zeilenweise Lesen aus dem PipedReader.
    public String readLine() throws IOException {
        StringBuilder sb = new StringBuilder(); //wird erstellt, um die gelesenen Zeichen zu einer Zeile zusammenzufügen.
        int c; // aktuelle gelesene Zeichen speichert.
        while ((c = this.read()) != -1) { //solange wiederholt wird, bis read() -1 zurückgibt, was darauf hinweist, dass das Ende des Streams erreicht wurde.
            if (c == '\n') { //prüft, ob das gelesene Zeichen ein Zeilenumbruch (\n) ist,
                return sb.toString(); //ret
            } else {
                sb.append((char) c); //Wenn das gelesene Zeichen kein Zeilenumbruch ist, wird es dem StringBuilder hinzugefügt, um die Zeile fortzusetzen.
            }
        }
        return sb.length() > 0 ? sb.toString() : null; //null zurückgegeben, um anzuzeigen, dass keine weiteren Zeilen vorhanden sind.
    }
}
