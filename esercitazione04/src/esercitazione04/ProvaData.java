package esercitazione04;

public class ProvaData {

	public static void main(String[] args) {
		Data a = new Data(29, 2, 2012);
		Data b = new Data(13, 12, 2012);

// test costruttore
		System.out.println(a.g + "/" + a.m + "/" + a.a);
		// dovrebbe stampare 28/2/2012 > il 2012 è stato un anno bisestile

// test toString
		System.out.println(a.toString());
		// dovrebbe stampare 28 Febbraio 2012 > il 2012 è stato un anno bisestile

// test equals
		System.out.println("equals? " + a.equals(new Data(29, 2, 2012)));
		// dovrebbe stampare true
		System.out.println("equals? " + a.equals(b));
		// dovrebbe stampare false

// test precede
		System.out.println("precede? " + a.precede(a));
		// dovrebbe stampare false
		System.out.println("precede? " + a.precede(b));
		// dovrebbe stampare true

//DA FARE test successivo

		Data c = new Data(29, 2, 2012).successivo();
		Data c1 = new Data(31, 12, 2012).successivo();

		System.out.println(c.toString() + " seconda: " + c1.toString());
		// dovrebbe stampare 1 Marzo 2012
	}
}