package dev.sgp.service;

import java.util.ArrayList;
import static java.util.stream.Collectors.*;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.VisiteLog;
import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteWebService {
	
	
	List<VisiteWeb> listeVisiteurWeb = new ArrayList<>();
	
	
	public List<VisiteWeb> listerVisiteurWeb(){
		return listeVisiteurWeb;
	}
	
	
	public void sauvegarderVisiteurWeb (VisiteWeb visiteurs){
		listeVisiteurWeb.add(visiteurs);
	}
	
	public List<VisiteLog> construireStatistiques() {
		List<VisiteLog> listVisitesLog = new ArrayList<>();
		
		Map<String, List<VisiteWeb>> cheminListeVisites = listeVisiteurWeb.stream().collect(groupingBy(VisiteWeb::getChemin));
		
		cheminListeVisites.forEach((chemin, listeVisiteurWeb) -> {
			listVisitesLog.add(construireVisiteLog(chemin, listerVisiteurWeb()));
		});
		
		return listVisitesLog;
	}
	
	
	public VisiteLog construireVisiteLog(String chemin, List<VisiteWeb> listeVisiteurWeb){
		LongSummaryStatistics stats = listeVisiteurWeb.stream().collect(
				summarizingLong(VisiteWeb::getTempsExecution));
		return new VisiteLog(chemin, stats.getCount(), stats.getMin(), stats.getMax(), stats.getAverage());
	}

}
