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

		ZonedDateTime dateHeureCreation = ZonedDateTime.now();

		Stream.of(
				new Collaborateur("1", "ee", "ss", LocalDate.parse("1993-06-25"), "14", "121212121212123",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true),
				new Collaborateur("2", "est", "rr", LocalDate.parse("1993-06-25"), "14", "121212121212124",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true),
				new Collaborateur("3", "pmp", "cdr", LocalDate.parse("1993-06-25"), "14", "121212121212151",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true),
				new Collaborateur("4", "sar", "vif", LocalDate.parse("1993-06-25"), "14", "121212121212161",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true),
				new Collaborateur("5", "pop", "youpi", LocalDate.parse("1993-06-25"), "14", "121212121212161",
						"ee.ss@societe.com", "img.png", dateHeureCreation, true)

		).forEach(collab -> collabService.sauvegarderCollaborateur(collab));
		// ).forEach(collab -> em.persist(collab));

		Stream.of(new Departement(1, "departement1"), new Departement(2, "departement2"),
				new Departement(3, "departement3"))
				.forEach(departement -> departementService.sauvegarderDepartement(departement));

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}
}
