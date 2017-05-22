package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	
	// création de la liste de collaborateurs
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	// lister la liste de collaborateur 
	public List<Collaborateur> listerCollaborateurs(){
		return listeCollaborateurs;
	}
	
	// sauvegarder la liste
	public void sauvegarderCollaborateur (Collaborateur collab){
		listeCollaborateurs.add(collab);
	}

}
