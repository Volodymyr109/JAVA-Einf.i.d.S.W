import java.io.*;
/*
AUFGABE
• WriterThread
– Erbt von der Klasse java.io.PipedWriter.
– Implementiert das Interface java.lang.Runnable.
– Bekommt im Konstruktor einen java.io.InputStream übergeben.
– Soll die run()-Methode überschreiben. In dieser sollen stetig zeilenweise vom bei der
  Instanziierung übergebenen java.io.InputStream gelesen werden. Jede gelesene
  Zeile soll direkt wieder von der Instanz der WriterThread Klasse geschrieben werden.
 */

// Diese Klasse liest zeilenweise aus dem InputStream und schreibt die gelesenen Zeilen in den PipedWriter.
class WriterThread extends PipedWriter implements Runnable { // laut der aufgabe! Erbt von der Klasse java.io.PipedWriter. Implementiert das Interface java.lang.Runnable.
    //wird erstellt, um zeilenweise aus dem InputStream zu lesen.
    private final BufferedReader reader;

    //InputStream als Parameter akzeptiert und die Instanz des WriterThread erstellt.
    public WriterThread(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }
    /*
  laut der aufgabe! Soll die run()-Methode überschreiben. In dieser sollen stetig zeilenweise vom bei der
  Instanziierung übergebenen java.io.InputStream gelesen werden. Jede gelesene
  Zeile soll direkt wieder von der Instanz der WriterThread Klasse geschrieben werden.
     */
    @Override
    public void run() {
        try {
            String line;
            while ((line = reader.readLine()) != null) { //solange wiederholt wird, bis readLine() null zurückgibt
                this.write(line + "\n"); //gelesene Zeile wird in den PipedWriter geschrieben
            }
            this.close(); //geschlossen
        } catch (IOException e) { //Falls während des Lesens oder Schreibens ein Fehler auftritt, wird eine IOException abgefangen
            e.printStackTrace();
        }
    }
}
