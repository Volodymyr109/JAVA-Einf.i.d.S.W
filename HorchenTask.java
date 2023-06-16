package Spezielle_Threads;
import java.io.File;
import java.util.TimerTask;

// Ein TimerTask wird verwendet, um periodische Aufgaben zu planen und auszufuehren.
// Die Hauptaufgabe des "HorchenTask" besteht darin, die Grosse einer Datei zu ueberwachen und uenderungen in der Groesse zu erfassen.
public class HorchenTask extends TimerTask {
	private File file;
	private long size;

	//Der Konstruktor der Klasse nimmt eine Datei als Argument und
	public HorchenTask(File file) {
		if (!file.exists()) { //prueft, ob die Datei existiert
			throw new IllegalArgumentException(file + " existiert nicht"); //Ansonsten wird die Datei und ihre arg exp in der Instanzvariablen gespeichert
		}
		this.file = file;
		this.size = 0L;
	 }
	//run methode wird von der TimerTask-Klasse bereitgestellt und wird periodisch ausgefuehrt
	@Override
	public void run() {
		long size = this.file.length();
		if (size != this.size) { //Wenn sich die Groesse gegenueber der vorherigen Groesse geaendert hat, wird die neue Groesse auf der Konsole ausgegeben.
			double d = (double) size;
			System.out.println(file.getName() + " ist jetzt " + d +  " bytes gross");
			this.size = size;
		}
	}
	//calculateSize wird rekursiv die Groesse einer Datei oder eines Verzeichnisses berechnet
	public static long calculateSize(File file) {
		if (!file.isDirectory()) { // ob file in Directory
			return file.length(); // dann ret file len
			} else {
			long size = 0; //oder 0

			File[] files = file.listFiles(); // liesst file
			//die Groesse einer Datei oder eines Verzeichnisses berechnet
			if (files != null) { // check on exist.
				for (File f : files) {
					size += calculateSize(f);
					}
				}
			return size; //	 //rekursiv die Groesse einer Datei oder eines Verzeichnisses berechnet
		}
	}
		// Groesse in einem lesbaren Format darstellt
		private String displaySize(long size) {
		double number = (double) size; // size gespeichert
		String unit; //Variable unit deklariert Einheitentyp
		if (size == 0) { //ob die Groesse gleich 0 ist
			unit = "-";
			} else if (number / 1000000000000L > 1) { //Ansonsten wird ueberprueft, ob die Groesse groesser als 1 Billion Bytes ist.
			number = ((double) size) / 1000000000000.0;
			unit = "tb"; //Wenn ja, wird number durch 1 Billion geteilt und unit auf "tera.b" gesetzt.
			} else if (number / 1000000000L > 1) {
			number = ((double) size) / 1000000000.0;
			unit = "gb"; // auf "giga.b" gesetzt.
			} else if (number / 1000000L > 1) {
			number = ((double) size) / 1000000.0;
			unit = "mb"; // auf "mega.b" gesetzt.
			} else if (number / 1000L > 1) {
			number = ((double) size) / 1000.0;
			unit = "kb";// auf "kilo.b" gesetzt.
			} else {
			unit = " b"; //Wenn keine der vorherigen Bedingungen erfuellt ist, wird unit auf "byte" gesetzt, um Bytes anzuzeigen.
			}
		return String.format("%8s", String.format("%03.2f %2s", unit)); //formatierter String zurueckgegeben, der die Einheit unit und die Groesse number enthaelt
	}
}
