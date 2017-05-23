package dev.sgp.entite;

public class VisiteLog {

	private String chemin;
	private long nbVisites;
	private long min;
	private long max;
	private double moyenne;
	
	
	public VisiteLog(String chemin, long nbVistes, long min, long max, double moyenne) {
		super();
		this.chemin = chemin;
		this.nbVisites = nbVistes;
		this.min = min;
		this.max = max;
		this.moyenne = moyenne;
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public long getNbVisites() {
		return nbVisites;
	}


	public void setNbVisites(int nbVisites) {
		this.nbVisites = nbVisites;
	}
	
	public void incrementNbVisites() {
		this.nbVisites++;
	}


	public long getMin() {
		return min;
	}


	public void setMin(long min) {
		this.min = min;
	}


	public long getMax() {
		return max;
	}


	public void setMax(long max) {
		this.max = max;
	}


	public double getMoyenne() {
		return moyenne;
	}


	public void setMoyenne(long moyenne) {
		this.moyenne = moyenne;
	}
	
	
	
}