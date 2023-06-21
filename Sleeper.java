package threads;
/* AUFGABE
=
1. Verändern Sie nur die Klassen threads.RandomGenerator und threads.Sleeper
und beheben Sie die Probleme durch die Synchronisation über ein geeignetes Monitor-Objekt
 */
/**
 * 6 * Simple {@code Thread} which continuously reads random values from the given
 7 * {@code Queue} and sleeps for as long as the currently read value determines.
 8 *
 9 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 10 *
 11 */
//Zweck dieser Klasse besteht darin, eine Liste von Werten (Long-Werten) zu überwachen und für jeden Wert eine bestimmte Zeit zu warten.
public class Sleeper extends Thread {
   //Datenfeld wird verwendet, um die Warteschlange der Werte zu speichern, die von der Klasse überwacht werden sollen.
   private Queue<Long> values;

   //nimmt eine Warteschlange von Long-Werten entgegen und weist sie dem Datenfeld "values" zu.
   public Sleeper(Queue<Long> values) {
      this.values = values;
      }
      //Die Methode "run()" wird ausgeführt, wenn der Thread gestartet wird.
      public void run() {
         try {
            while (true) { //die solange ausgeführt wird, bis der Thread unterbrochen wird.
               long value;
               synchronized (values) { // wird ein Synchronisationsblock verwendet, um auf das Datenfeld "values" zuzugreifen.
                  while (this.values.empty()) { //überprüft, ob die Warteschlange "values" leer ist. Wenn sie leer ist, ruft der Thread die Methode "wait()" auf, Warteschlange zu warten.
                     values.wait();

                     }
                  value = values.deq(); //Methode "deq()" aus der Warteschlange entfernt und der Variablen "value" zugewiesen.
                  values.notifyAll();   //aufgerufen, um andere Threads zu benachrichtigen
                  System.out.println("Now sleeping for " + value + " ms"); // ausgegeben, um anzuzeigen, dass der Thread für den bestimmten Zeitraum schläft.
               }
            this.sleep(value);

            }
         }
         //Falls der Thread während des Schlafens unterbrochen wird (InterruptedException), wird eine Fehlermeldung ausgegeben.
         catch (InterruptedException e) {
         e.printStackTrace();
      }
   }
}