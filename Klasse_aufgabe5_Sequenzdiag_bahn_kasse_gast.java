public class Bahn {
public static void main(String[] args) {
Kasse k = new Kasse();
Gast muster = new Gast(k);
muster.ticketHolen();
}
}
public class Gast {
private Kasse v;
public Gast(Kasse v) {
this.v = v;
}
public void ticketHolen() {
String zuKaufen = tarifAussuchen();
v.bezahlen(zuKaufen);
}
public String tarifAussuchen() {
return "49CTicket";
}
}
public class Kasse {
public void bezahlen(String ware) {
System.out.println("Abkassiert");
}
}
