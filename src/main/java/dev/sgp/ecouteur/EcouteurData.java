package dev.sgp.ecouteur;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.stream.Stream;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class EcouteurData implements ServletContextListener {

	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	@Inject
	private CollaborateurService collabService;
	
	@Inject
	private DepartementService departementService;
	
	
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		Departement dpt1 = new Departement();
		Departement dpt2 = new Departement();
		Departement dpt3 = new Departement();
		Departement dpt4 = new Departement();
		Departement dpt5 = new Departement();
	
		dpt1.setId(1);
		dpt1.setNom("Comptabilité");
		
		dpt2.setId(2);
		dpt2.setNom("Ressources Humaines");
		
		dpt3.setId(3);
		dpt3.setNom("Informatique");
		
		dpt4.setId(4);
		dpt4.setNom("Administratif");
		
		dpt5.setId(5);
		dpt5.setNom("cccc");
		
		Stream.of(dpt1,dpt2,dpt3,dpt4,dpt5)
				.forEach(departement -> departementService.sauvegarderDepartement(departement));

		ZonedDateTime dateHeureCreation = ZonedDateTime.now();

		Stream.of(
				new Collaborateur("1", "Jack", "Jacko", LocalDate.parse("1993-06-25"), "14", "121212121212123",
						"ee.ss@societe.com", "img.png",dpt1 , dateHeureCreation,"banque1","bic1","iban1", true),
				new Collaborateur("2", "Laura", "Laure", LocalDate.parse("1993-06-25"), "14", "121212121212124",
						"ee.ss@societe.com", "img.png",dpt2 , dateHeureCreation,"banque2","bic2","iban2", true),
				new Collaborateur("3", "Meryem", "Amina", LocalDate.parse("1993-06-25"), "14", "121212121212151",
						"ee.ss@societe.com", "img.png",dpt3 , dateHeureCreation,"banque3","bic3","iban3", true),
				new Collaborateur("4", "Mohammad", "Abt", LocalDate.parse("1993-06-25"), "14", "121212121212161",
						"ee.ss@societe.com", "img.png", dpt4, dateHeureCreation,"banque4","bic4","iban4", true),
				new Collaborateur("5", "Man", "Jhay", LocalDate.parse("1993-06-25"), "14", "121212121212161",
						"ee.ss@societe.com", "img.png",dpt1 , dateHeureCreation,"banque5","bic5","iban5", true)

		).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
		// ).forEach(collab -> em.persist(collab));

		

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}
