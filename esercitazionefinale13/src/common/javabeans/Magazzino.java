package common.javabeans;

public class Magazzino {

	private int id;
	private String nomeProdotto;
	private String descrizione;
	private int livelloScorte;
	private int editScorte;
	private int livelloMinimoScorte;

	public Magazzino(int id, String nomeProdotto, String descrizione, int livelloScorte) {
		this.id = id;
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
		this.livelloScorte = livelloScorte;
	}

	public Magazzino(int id, String nomeProdotto, String descrizione) {
		this.id = id;
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
	}

	public Magazzino(int id) {
		this.id = id;
	}

	public Magazzino(int id, int editScorte) {
		this.id = id;
		this.editScorte = editScorte;
	}

	public Magazzino(String nomeProdotto, String descrizione, int livelloScorte) {
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
		this.livelloScorte = livelloScorte;
	}

	public Magazzino(String nomeProdotto, String descrizione, int livelloScorte, int livelloMinimoScorte) {
		this.nomeProdotto = nomeProdotto;
		this.descrizione = descrizione;
		this.livelloScorte = livelloScorte;
		this.livelloMinimoScorte = livelloMinimoScorte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getLivelloScorte() {
		return livelloScorte;
	}

	public void setLivelloScorte(int livelloScorte) {
		this.livelloScorte = livelloScorte;
	}

	public int getEditScorte() {
		return editScorte;
	}

	public void setEditScorte(int editScorte) {
		this.editScorte = editScorte;
	}

	public int getLivelloMinimoScorte() {
		return livelloMinimoScorte;
	}

	public void setLivelloMinimoScorte(int livelloMinimoScorte) {
		this.livelloMinimoScorte = livelloMinimoScorte;
	}
}
