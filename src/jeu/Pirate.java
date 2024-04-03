package jeu;

public class Pirate {
	private String nom;
	private int position;
	private int vie = 5;
	private int numID;
	private double multiplicateurDe = 1;
	private int resDe = 0;

	public Pirate(String nom, int position, int vie, int numID, int multiplicateurDe) {
		this.nom = nom;
		this.position = position;
		this.vie = vie;
		this.numID = numID;
		this.multiplicateurDe = multiplicateurDe;
	}

	public String getNom() {
		return nom;
	}

	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}

	public int getVie() {
		return vie;
	}

	public int changerVie(int pv) {
		this.vie = pv;
		return vie;
	}

	public int changerVieDuel() {
		this.vie = this.vie - 3;
		return this.vie;
	}
	
	public int getNumID() {
		return numID;
	}

	public void setNumID(int ordre) {
		this.numID = ordre;
	}
	
	public double getMultiplicateurDe() {
		return multiplicateurDe;
	}
	
	public void setMultiplicateurDe(int multiplicateur) {
		this.multiplicateurDe = multiplicateur;
	}

	public int avancerPirate(int distance) {
		position = position + distance;
		return position;
	}

	public int reculerPirate(int distance) {
		position = position - distance;
		return position;
	}
	
	public void setResDe(int res) {
		this.resDe = res;
	}
	
	public int getResDe() {
		return resDe;
	}

}
