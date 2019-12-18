package common.interfaces;



import common.javabeans.Utente;

public interface IUserServices {
	
	void registraUtente(Utente utente);
	boolean login (String username, String password);

}
