package cg.services;

import cg.entities.Contatto;

public interface ContattoService {
	
	//CRUD operations

	 //void addContatto(Contatto c);
	Contatto saveContatto(Contatto contatto);

	//void updateContatto(Contatto c);

	//void removeContatto(Integer id);
	void deleteContatto(Integer id);

	//Contatto getContatto(Integer id);
	Contatto getContattoById(Integer id);

	//List<Contatto> getContatti();
	Iterable<Contatto> listAllContattiByNome(String nome);
	
	Iterable<Contatto> listAllContatti();

}
