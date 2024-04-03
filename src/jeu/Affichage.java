package jeu;

public interface Affichage {
	public void affichageGagnant(String nom);
	
	public void affichageJoueurActif(String nom, int position, int vie);
	
	public void affichageLancerDe(String nom);
	
	public void affichagePosition(String nom, int position);
	
	public void affichagePremierJoueur(String nom );
	
	public void affichageResultat(String nom, int resultat);
	
	public void afficher(String truc);
	
	public void afficherAvancer(String nom, int distance);
	
	public void afficherDuel();
	
	public void afficherFinDeTour(String nom, int position, int vie);
	
	public void afficherMultiplicateur(String nom, double d);

	public void afficherPiege(String nom, String piege);

}