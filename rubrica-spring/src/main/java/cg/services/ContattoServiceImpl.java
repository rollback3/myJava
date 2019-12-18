package cg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cg.entities.Contatto;
import cg.repositories.ContattoRepository;

@Service
public class ContattoServiceImpl implements ContattoService {

	private ContattoRepository contattoRepository;

	@Autowired
	public void setContattoRepository(ContattoRepository contattoRepository) {
		this.contattoRepository = contattoRepository;
	}
	
	public Contatto saveContatto(Contatto contatto) {
		return contattoRepository.save(contatto);
	}

	public void deleteContatto(Integer id) {
		contattoRepository.delete(id);
	}

	public Contatto getContattoById(Integer id) {
		return contattoRepository.findOne(id);
	}

	public Iterable<Contatto> listAllContattiByNome(String nome) {
		return contattoRepository.findByNome(nome);
	}

	public Iterable<Contatto> listAllContatti() {
		return contattoRepository.findAll();
	}

}
