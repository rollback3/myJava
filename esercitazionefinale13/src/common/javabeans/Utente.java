package common.javabeans;

public class Utente {

	private String nome;
	private String cognome;
	private String via;
	private String email;
	private String userName;
	private String password;

	public Utente(String nome, String cognome, String via, String email, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.via = via;
		this.email = email;
		this.userName = username;
		this.password = password;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
