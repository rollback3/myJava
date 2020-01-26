package cg.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cg.entities.Contatto;
import cg.services.ContattoServices;

@RestController
@RequestMapping("/api/contatto")
public class ContattoController extends BaseController {

	@Autowired
	private ContattoServices contattoServices;

/*	@PostMapping
	public Contatto save(@RequestBody Contatto contatto) {
		contatto.setId(null);
		return contattoServices.persist(getUser(), contatto);
	}
*/
}
