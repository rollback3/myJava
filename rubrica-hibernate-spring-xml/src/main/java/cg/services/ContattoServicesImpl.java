package cg.services;

import java.util.List;

import cg.dao.ContattoDaoImpl;
import cg.entities.Contatto;

public class ContattoServicesImpl implements ContattoServices {

	private static ContattoDaoImpl contattoDaoImpl;

	public void persist(Contatto contatto) {
		contattoDaoImpl.openCurrentSessionwithTransaction();
		contattoDaoImpl.persist(contatto);
		contattoDaoImpl.closeCurrentSessionwithTransaction();
	}

	public void update(Contatto contatto) {
		contattoDaoImpl.openCurrentSessionwithTransaction();
		contattoDaoImpl.update(contatto);
		contattoDaoImpl.closeCurrentSessionwithTransaction();
	}

	public Contatto findById(String id) {
		contattoDaoImpl.openCurrentSession();
		Contatto contatto = contattoDaoImpl.findById(id);
		contattoDaoImpl.closeCurrentSession();
		return contatto;
	}

	public void delete(String id) {
		contattoDaoImpl.openCurrentSessionwithTransaction();
		Contatto contatto = contattoDaoImpl.findById(id);
		contattoDaoImpl.delete(contatto);
		contattoDaoImpl.closeCurrentSessionwithTransaction();
	}

	public List<Contatto> findAll() {
		contattoDaoImpl.openCurrentSession();
		List<Contatto> contatti = contattoDaoImpl.findAll();
		contattoDaoImpl.closeCurrentSession();
		return contatti;
	}

	public void deleteAll() {
		contattoDaoImpl.openCurrentSessionwithTransaction();
		contattoDaoImpl.deleteAll();
		contattoDaoImpl.closeCurrentSessionwithTransaction();
	}

}
