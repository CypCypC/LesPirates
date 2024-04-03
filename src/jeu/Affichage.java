package jeu;

public interface Affichage {
	public void afficher(String truc);
	
	public void affichageLancerDe(String nom);
	
	public void affichageResultat(String nom, int resultat);
	
	public void affichagePremierJoueur(String nom );
	
	void affichageJoueurActif(String nom, int position, int vie);
	
	public void affichageGagnant(String nom);
	
	public void affichagePosition(String nom, int position);
	
	public void affichageVieJoueur(String nom, int vie);
	
	public void afficherPiege(String nom, String piege);
	
	public void afficherFinDeTour(String nom, int position, int vie);
	
	public void afficherDuel();
	
	public void afficherMultiplicateur(String nom, int multiplicateur);

}