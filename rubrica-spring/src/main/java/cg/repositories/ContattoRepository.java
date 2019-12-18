package cg.repositories;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import cg.entities.Contatto;

public interface ContattoRepository extends CrudRepository<Contatto, Integer> {

	public List<Contatto> findByNome(String nome);

}
