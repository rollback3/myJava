package cg.controllers;

import cg.entities.Contatto;
import cg.services.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contatto controller.
 */
@Controller
public class ContattoController {

	private ContattoService contattoService;

	@Autowired
	public void setContattoService(ContattoService contattoService) {
		this.contattoService = contattoService;
	}

	/**
	 * List all contatti.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contatti", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("contatti", contattoService.listAllContatti());
		System.out.println("Returning contatti:");
		return "contatti";
	}

	/**
	 * View a specific contatto by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("contatto/{id}")
	public String showContatto(@PathVariable Integer id, Model model) {
		model.addAttribute("contatto", contattoService.getContattoById(id));
		return "contattoshow";
	}

	@RequestMapping("contatto/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("contatto", contattoService.getContattoById(id));
		return "contattoform";
	}

	/**
	 * New contatto.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("contatto/new")
	public String newContatto(Model model) {
		model.addAttribute("contatto", new Contatto());
		return "contattoform";
	}

	/**
	 * Save contatto to database.
	 *
	 * @param contatto
	 * @return
	 */
	@RequestMapping(value = "contatto", method = RequestMethod.POST)
	public String saveContatto(Contatto contatto) {
		contattoService.saveContatto(contatto);
		return "redirect:/contatto/" + contatto.getId();
	}

	/**
	 * Delete contatto by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("contatto/delete/{id}")
	public String delete(@PathVariable Integer id) {
		contattoService.deleteContatto(id);
		return "redirect:/contatti";
	}

	@RequestMapping(value = "/contattiByNome/{nome}", method = RequestMethod.GET)
	public String listByNome(@PathVariable String nome, Model model) {
		model.addAttribute("contatti", contattoService.listAllContattiByNome(nome));
		System.out.println("Returning contatti:");
		return "contatti";
	}

}
