package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.TypeCollabEvt;

@ApplicationScoped
public class ActiveService {

	
	List<CollabEvt> listeActiviterCollab = new ArrayList<>();
	
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt) {
		
		
		listeActiviterCollab.add(evt);
		System.out.println("creation d'un nouveau collaborateur avec un nouveau matricule" + listeActiviterCollab);

	}

	public List<CollabEvt> listerActiviterCollab(){
		return listeActiviterCollab;
	}

}
