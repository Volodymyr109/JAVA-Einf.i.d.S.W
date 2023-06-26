package threads;
/* AUFGABE
2. Verändern Sie nur die Klasse util.Queue und beheben Sie die Probleme, indem Sie möglichst kleine Blöcke durch java.util.concurrent.locks.Lock-Instanzen sperren.
Nutzen Sie eine oder mehrere java.util.concurrent.locks.Condition-Instanzen
um die verlangte Synchronisation zu gewährleisten.
 */
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Condition;

public class Queue<E> {
	private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
	private final Lock readLock = rwLock.readLock();
	private final Lock writeLock = rwLock.writeLock();
	//Condition-Instanzen
	//verwendet wird, um zu bestimmen, ob ein bestimmter Codeblock ausgeführt oder wiederholt werden soll.
	// Die Bedingung ist in der Regel ein boolescher Ausdruck, der entweder true oder false ergibt
	private final Condition condition = writeLock.newCondition();
	private Object[] objects;
	private int first;
	private int size;

	// SPEICHERN
	//generische Typen und verwendet eine interne Array-Datenstruktur, um die Elemente der Warteschlange zu speichern.
	public Queue(int capacity) {
		this.objects = new Object[capacity];
		// Index des ersten Elements und die Anzahl der Elemente in der Warteschlange zu verfolgen.
		this.first = 0;
		this.size = 0;
		}
		//hinzuzufügen
		//verwendet, um ein Element am Ende der Warteschlange hinzuzufügen
		public void enq(E o) throws InterruptedException {
		// lock sperrt es, um sicherzustellen, dass kein anderer Thread zur gleichen Zeit auf die Warteschlange zugreift oder sie modifiziert
		this.writeLock.lock();
		try {

			while (this.full()) {      //Der Zugriff wird durch das Schreibschloss (writeLock) geschützt. Wenn die Warteschlange voll ist,
				this.condition.await();// wird der aufrufende Thread mit der Methode "await()"

				}
			objects[(first + size) % objects.length] = o;
			size++;
			} finally {
			this.condition.signalAll();
			this.writeLock.unlock();
			}
		}
		//entfernen
		//wird verwendet, um das erste Element aus der Warteschlange zu entfernen
		public E deq() throws InterruptedException {
		// lock sperrt es, um sicherzustellen, dass kein anderer Thread zur gleichen Zeit auf die Warteschlange zugreift oder sie modifiziert
		this.writeLock.lock(); // lock in work
		try {
			while (this.empty()) { //Wenn die Warteschlange leer ist, wartet der aufrufende Thread mit der Methode "await()"
				this.condition.await(); // wird der aufrufende Thread mit der Methode "await()"
										// sobald ein Element verfügbar ist, wird es entfernt
				}

			E o = (E) objects[first];
			first = (first + 1) % objects.length;	// der Index des ersten Elements wird aktualisiert
			size--;	//die Größe verringert und das Element zurückgegeben
			return o;
			} finally {
			this.condition.signalAll();
			this.writeLock.unlock(); //lock frei
			} //das Signal an andere Threads gesendet.
		}
		//gibt das erste Element in der Warteschlange zurück ohne es zu entfernen
		public E front(E o) {
		// lock sperrt es, um sicherzustellen, dass kein anderer Thread zur gleichen Zeit auf die Warteschlange zugreift oder sie modifiziert
		this.readLock.lock(); // lock in work
		try {
			if (this.empty()) { //Wenn die Warteschlange leer ist, wird eine "NoSuchElementException" ausgelöst.
				throw new NoSuchElementException();
				}
			return (E) objects[first]; // return obj
			} finally {
			this.readLock.unlock(); //lock frei
			}
		}
		//überprüft, ob die Warteschlange leer ist,
		public boolean empty() {
		// lock sperrt es, um sicherzustellen, dass kein anderer Thread zur gleichen Zeit auf die Warteschlange zugreift oder sie modifiziert
		this.readLock.lock();// lock in work
		try {
			return this.size == 0;
			} finally {
			this.readLock.unlock();//lock frei
			}
		}
		//überprüft, ob die Warteschlange voll ist
		public boolean full() {
		// lock sperrt es, um sicherzustellen, dass kein anderer Thread zur gleichen Zeit auf die Warteschlange zugreift oder sie modifiziert
		this.readLock.lock();// lock in work
		try {
			return this.size == objects.length;
			} finally {
			this.readLock.unlock();//lock frei
		}
	}
}
