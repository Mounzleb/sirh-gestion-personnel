package dev.sgp.entite;

public class VisiteWeb {
	
	int id;
	String chemin;
	public VisiteWeb(String chemin, int tempsExecution) {
		super();
		this.chemin = chemin;
		this.tempsExecution = tempsExecution;
	}
	int tempsExecution;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}
	public int getTempsExecution() {
		return tempsExecution;
	}
	public void setTempsExecution(int tempsExecution) {
		this.tempsExecution = tempsExecution;
	}

}
