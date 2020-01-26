package cg;

import java.util.List;

import cg.entities.Contatto;
import cg.services.ContattoServicesImpl;

public class MainTest {

	public static void main(String[] args) {

		/*
		 * ContattoDaoImpl cdm = new ContattoDaoImpl(); Contatto contatto = new
		 * Contatto();
		 * 
		 * contatto.setNome("Russel1"); contatto.setCognome("Allen1");
		 * contatto.setEmail("russel.allen@gmail.com");
		 * contatto.setTelefono("12345678"); cdm.save(contatto);
		 */

		ContattoServicesImpl csi = new ContattoServicesImpl();
		Contatto c = new Contatto("Russel", "Allen", "01023451", "russel@gmail.com");
		Contatto c1 = new Contatto("Maryan", "Pink", "18569153", "maryan@gmail.com");
		Contatto c2 = new Contatto("John", "Red", "5488546", "john@gmail.com");
		csi.persist(c);
		csi.persist(c1);
		csi.persist(c2);
		List<Contatto> contatti = csi.findAll();
		System.out.println("Lista contatti");
		for (@SuppressWarnings("unused") Contatto cs : contatti) {
			System.out.println("-" + c.toString());
		}
	}

}
