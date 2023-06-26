package threads;
/**
 * Einfacher {@code Thread}, der kontinuierlich zufällige Werte aus der gegebenen
 * {@code Queue} liest und entsprechend lange schläft.
 */
public class Sleeper extends Thread {

   private Queue<Long> values; // Die Warteschlange, die die zu überwachenden Werte enthält

   //Konstruktor, der eine Warteschlange von Long-Werten entgegennimmt und sie dem Datenfeld "values" zuweist.
   public Sleeper(Queue<Long> values) {
      this.values = values;
   }

   //Die Methode "run()" wird ausgeführt, wenn der Thread gestartet wird.
   public void run() {
      try {
         while (true) { // Die Schleife wird solange ausgeführt, bis der Thread unterbrochen wird.
            long value;
            synchronized (values) { // Ein Synchronisationsblock wird verwendet, um auf das Datenfeld "values" zuzugreifen.
               while (this.values.empty()) { // Überprüft, ob die Warteschlange "values" leer ist.
                  values.wait(); // Wenn die Warteschlange leer ist, ruft der Thread die Methode "wait()" auf und wartet darauf, dass Elemente hinzugefügt werden.
               }
               value = values.deq(); // Entfernt das nächste Element aus der Warteschlange und weist es der Variablen "value" zu.
               values.notifyAll(); // Benachrichtigt andere Threads, dass Elemente aus der Warteschlange entfernt wurden.
               System.out.println("Now sleeping for " + value + " ms"); // Gibt aus, dass der Thread für die bestimmte Zeit schläft.
            }
            this.sleep(value); // Der Thread schläft für den angegebenen Zeitraum.
         }
      } catch (InterruptedException e) { // Falls der Thread während des Schlafens unterbrochen wird (InterruptedException), wird eine Fehlermeldung ausgegeben.
         e.printStackTrace();
      }
   }
}