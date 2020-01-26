package cg.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import cg.entities.Contatto;

public interface ContattoDao<A, Id extends Serializable> {

	// public Contatto save(Contatto contatto);

	public void persist(A contatto);

	public void delete(A contatto);

	public void update(A contatto);

	public Contatto findById(Id id);

	public List<Contatto> findAll();

	public void deleteAll();
}