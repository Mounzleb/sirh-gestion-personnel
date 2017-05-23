package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {
	
	
	List<VisiteWeb> listeVisiteurWeb = new ArrayList<>();
	
	
	public List<VisiteWeb> listerVisiteurWeb(){
		return listeVisiteurWeb;
	}
	
	
	public void sauvegarderVisiteurWeb (VisiteWeb visiteurs){
		listeVisiteurWeb.add(visiteurs);
	}

}
