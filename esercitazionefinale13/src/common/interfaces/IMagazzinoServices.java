package common.interfaces;

import java.util.List;
import common.javabeans.Magazzino;

public interface IMagazzinoServices {

	void insertMagazzino(Magazzino magazzino);

	// specifico oggetto, nella lista, per evitare il cast quando verrà richiamato
	// il metodo
	List<Magazzino> listaMagazzino();

	void updateMagazzino(Magazzino magazzino);

	void deleteMagazzino(Magazzino magazzino);

	void increaseScorte(Magazzino magazzino);

	void decreaseScorte(Magazzino magazzino);

	int controlloScorte(Magazzino magazzino);
	
	int livelloScorteMinime(Magazzino magazzino);

}
