package jeu;

public class Jeu {
	private int nbCase=30;
	private int nbJoueurs;
	
	public void lancerJeu() {
		
	}
	
	public int changerJoueur(int num) {
		if (num>nbJoueurs) {
			num = 0;
		}
		else {
			num=num+1;
		}
		return num;
	}
	
	public int getNbCase() {
		return nbCase;
	}
	
}
