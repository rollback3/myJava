package cg.dao;

import java.util.List;

import cg.entities.Contatto;

public class ContattoDaoImpl extends BaseDao implements ContattoDao<Contatto, String> {

	/*
	 * public Contatto save(Contatto contatto) { Session session = (Session)
	 * getSession(); session.saveOrUpdate(contatto); return contatto; }
	 */

	public void persist(Contatto contatto) {
		getCurrentSession().save(contatto);
	}

	public void update(Contatto contatto) {
		getCurrentSession().update(contatto);
	}

	public Contatto findById(String id) {
		Contatto contatto = (Contatto) getCurrentSession().get(Contatto.class, id);
		return contatto;
	}

	public void delete(Contatto contatto) {
		getCurrentSession().delete(contatto);
	}

	public List<Contatto> findAll() {
		@SuppressWarnings("unchecked")
		List<Contatto> contatti = (List<Contatto>) getCurrentSession().createQuery("from Contatto").list();
		return contatti;
	}

	public void deleteAll() {
		List<Contatto> listaContatti = findAll();
		for (Contatto contatto : listaContatti) {
			delete(contatto);
		}
	}

}