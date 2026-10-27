import java.util.Scanner;

/* *****************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden!
 * Fuegen Sie Code, insbesondere weitere Methoden, hinzu!
 * Aendern Sie vom vorhandenen Code nur die return-Anweisung von checkEingabeMenu()
 ****************************************************************************************************** */

public class Spiel {

	private static Scanner sc = new Scanner(System.in);
	private static final int n = 5;

	public static void main(String[] args) {
		System.out.println("Herzlich Willkommen zu Solitaer!");
		// TODO
		int eingabe;
		do {
			System.out.println("1- Ein neues Spiel starten");
			System.out.println("2- Programm beenden");
			eingabe=sc.nextInt();
		}while(!checkEingabeMenu(eingabe));
		Spielfeld sf=new Spielfeld(5);
		boolean aufgeben=false;
		do {
		System.out.println(sf);
		System.out.println("Welche pin moechten Sie bewegen? ");
		System.out.println("Zeile: ");
		int zeile=sc.nextInt();
		System.out.println("Spalte: ");
		int spalte=sc.nextInt();
		System.out.println("In Welche Richtung(o/u/l/r) soll pin bewegt werden?");
		System.out.println("Geben Sie x ein,wenn Sie aufgeben moechten");
		char schritt=sc.next().charAt(0);
		if(schritt=='x') {
			aufgeben=true;
		}else {
			boolean gueltig=sf.zug(zeile, spalte, schritt);
			if(gueltig==false) {
				System.out.println("Ungueltiger Zug!");
			}
		}
		}while(!sf.gewonnen()&&!aufgeben);
		
		if(sf.gewonnen()) {
			System.out.println(sf);
			System.out.println("Sie haben gewonnen");
		}else {
			System.out.println("Sie haben aufgegeben");
		}
		
		sc.close();
	}

	/*
	 * Gibt bei Eingabe von 1 oder 2 true zurueck Sonst false
	 */
	public static boolean checkEingabeMenu(int eingabe) {
		// TODO
		if (eingabe == 1 || eingabe == 2) {
			return true;
		} else {
			return false;
		}

	}

}
