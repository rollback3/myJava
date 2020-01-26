package cg.services;

import java.util.List;
import cg.entities.Contatto;

public interface ContattoServices {

	// public Contatto save(Contatto contatto);

	public void persist(Contatto contatto);

	public void update(Contatto contatto);

	public Contatto findById(String id);

	public void delete(String id);

	public List<Contatto> findAll();

	public void deleteAll();

}