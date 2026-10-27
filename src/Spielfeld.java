/* ************************************************************************************************************
 * Folgen Sie den Todo-Anweisungen und beachten Sie die Kommentare der einzelnen Methoden und Kosntruktoren! 
 * Fuegen Sie Code, insbesondere weitere Methoden Methoden, hinzu! 
 * Aendern Sie vom vorhandenen Code nur die return-Anweisungen von zug, gewonnen und toString()
 * ************************************************************************************************************ */

public class Spielfeld {
	/*
	 * DIE ATTRIBUTE NICHT AENDERN! Verwenden Sie diese Attribute
	 */
	private boolean[][] feld;
	private final int N;

	/*
	 * NICHT AENDERN! Zu Testzwecken vorhanden Darf verwendet werden, muss aber
	 * nicht
	 */
	public Spielfeld(boolean[][] feld) {
		this.feld = feld;
		this.N = feld.length;
	}

	/*
	 * NICHT AENDERN! Zu Testzwecken vorhanden Darf verwendet werden, muss aber
	 * nicht
	 */
	public boolean[][] getFeld() {
		return feld;
	}

	/*
	 * Nach Aufruf des Konstruktors hat feld die Groesse n x n Der Eintrag in der
	 * Mitte von feld ist false Alle anderen Eintraege sind true
	 */
	public Spielfeld(int n) {
		this.N = n;
		this.feld = new boolean[n][n];

		for (int z = 0; z < n; z++) {
			for (int s = 0; s < n; s++) {
				feld[z][s] = true;
			}
		}
		feld[n / 2][n / 2] = false;

		// TODO
	}

	/*
	 * Gibt true zurueck, wenn die Eingabeparameter und das aktuelle feld einen Zug
	 * zulassen In dem Fall wird der Zug auch durchgefuehrt, also alle noetigen
	 * Aenderungen in feld werden vorgenommen Gibt false zurueck, wenn die
	 * Eingabeparameter und das aktuelle feld KEINEN Zug zulassen
	 */
	public boolean zug(int z, int s, char richtung) {
		// TODO
		int neuZ = z;
		int neuS = s;

		if (richtung == 'o') {
			neuZ = z - 2;
		}
		if (richtung == 'u') {
			neuZ = z + 2;
		}
		if (richtung == 'l') {
			neuS = s - 2;
		}
		if (richtung == 'r') {
			neuS = s + 2;
		} else {
			return false;
		}

		if (z < 0 || z >= N || s < 0 || s >= N) {
			return false;
		}
		if (neuZ < 0 || neuZ >= N || neuS < 0 || neuS >= N) {
			return false;
		}

		if (!feld[z][s]) {
			return false;
		}
		if (feld[neuZ][neuS]) {
			return false;
		}
		int mitteZ = (z + neuZ) / 2;
		int mitteS = (s + neuS) / 2;

		if (!feld[mitteZ][mitteS]) {
			return false;
		}
		feld[z][s] = false;
		feld[mitteZ][mitteS] = false;
		feld[neuZ][neuS] = true;

		return true;
	}

	/*
	 * Gibt true zurueck, wenn das Spiel gewonnen wurde, also nur noch genau ein Pin
	 * = ein true in feld zu finden ist Sonst false
	 */
	public boolean gewonnen() {
		// TODO
		int anzahl = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (feld[i][j] == true) {
					anzahl += 1;
				}
			}

		}
		if (anzahl == 1) {
			return true;
		} else {
			return false;
		}

	}

	/*
	 * Gibt das aktuelle Feld als String zurueck. Genau den Aufbau aus der
	 * Aufgabenstellung beachten. Tabalutor mit "\t", Zeilenwechsel mit "\n"
	 */
	public String toString() {
		// TODO
		String ausgabe = "  ";
		for (int s = 0; s < N; s++) {
			ausgabe = s + "  ";
		}
		ausgabe = ausgabe + "\n";
		for (int z = 0; z < N; z++) {
			ausgabe += z + "  ";
			for (int s = 0; s < N; s++) {
				if (feld[z][s] == true) {
					ausgabe += "# ";
				} else {
					ausgabe += "_ ";
				}
			}
			ausgabe += "\n";
		}
		return ausgabe;
	}

}
