package esercitazione04;

public class Data {

	public int g;
	public int m;
	public int a;
	final int GENNAIO = 1;
	final int FEBBRAIO = 2;
	final int MARZO = 3;
	final int APRILE = 4;
	final int MAGGIO = 5;
	final int GIUGNO = 6;
	final int LUGLIO = 7;
	final int AGOSTO = 8;
	final int SETTEMBRE = 9;
	final int OTTOBRE = 10;
	final int NOVEMBRE = 11;
	final int DICEMBRE = 12;

	public Data() {

	}

	public Data(int g, int m, int a) {
		this.a = a;
		setM(m);
		setG(g);
	}

//2. Si aggiunga alla classe Data un metodo toString che, dato un oggetto, restituisce una stringa che contiene la data (es. "17 novembre 2012") con il nome del mese a parole.	

	@Override
	public String toString() {
		return "Data: " + g + " " + getMAsString() + " " + a;
	}

	public String getMAsString() {
		String risultato = null;
		switch (m) {
		case 1:
			risultato = "Gennaio";
			break;

		case 2:
			risultato = "Febbraio";
			break;

		case 3:
			risultato = "Marzo";
			break;

		case 4:
			risultato = "Aprile";
			break;

		case 5:
			risultato = "Maggio";
			break;

		case 6:
			risultato = "Giugno";
			break;

		case 7:
			risultato = "Luglio";
			break;

		case 8:
			risultato = "Agosto";
			break;

		case 9:
			risultato = "Settembre";
			break;

		case 10:
			risultato = "Ottobre";
			break;

		case 11:
			risultato = "Novembre";
			break;

		case 12:
			risultato = "Dicembre";
			break;

		default: // tutti i numeri non dichiarati nei casi precedenti ( possibile inserire
			// iff o EXC
			// istruzioni di fdefault (in tutti gli altri casi)
			break;
		}
		return risultato;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {

		if (g < 1) {
			g = 1;
		}
		int ug = ultimogiorno();
		if (g > ug) {
			g = ug;
		}
		this.g = g;
	}

	private int ultimogiorno() {
		int ultimog;
		if (m == FEBBRAIO && calcoloAnnoBisestile())
			ultimog = 29;
		else if (m == FEBBRAIO)
			ultimog = 28;
		else if (m == APRILE || m == GIUGNO || m == SETTEMBRE || m == NOVEMBRE)
			ultimog = 30;
		else
			ultimog = 31;
		return ultimog;
	}

	public boolean calcoloAnnoBisestile() {
		boolean annoBisestile = a % 400 == 0 || (a % 4 == 0 && a % 100 != 0);
		return annoBisestile;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		if (m > 12) {
			m = 12;
		} else if (m < 1) {
			m = 1;
		}
		this.m = m;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

//3. Si aggiunga alla classe Data un metodo equals che verifica se due date sono uguali.

	public boolean equals(Object o) {

		if (this == o) {
			return true;
		} else {
			if (o == null || o.getClass() != this.getClass())
				return false;
		}
		Data data = (Data) o;
		return (data.g == this.g) && (data.m == this.m) && (data.a == this.a);
	}

//4. Si aggiunga alla classe Data un metodo precede che verifica se una data precede strettamente l'altra.	

	public boolean precede(Object o) {

		boolean bool = false;
		Data data = (Data) o;
		if ((this.a < data.a)) {
			bool = true;
		} else if ((this.a == data.a) && (this.m < data.m)) {
			bool = true;
		} else if ((this.a == data.a) && (this.m == data.m) && (this.g < data.g)) {
			bool = true;
		} else {
			bool = false;
		}
		return bool;
	}

//5. Si aggiunga alla classe Data un metodo successivo che calcola la data successiva a una data specificata.

	public Data successivo() {

		Data o = new Data();
		if (this.ultimogiorno() == this.g) {
			o.setG(1);
			if (this.getM() == this.DICEMBRE) {
				o.setA(this.a + 1);
				o.setM(this.GENNAIO);
			} else {
				o.setM(this.m + 1);
				o.setA(this.a);
			}
		} else {
			o.setG(this.g + 1);
			o.setM(this.m);
			o.setA(this.a);
		}
		return o;
	}

}