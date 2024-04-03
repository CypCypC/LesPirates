package jeu;

public class JournalDeBord implements Affichage {
	private String lj = "Le joueur ";
    @Override
    public void affichageGagnant(String nom) {
        afficher(lj + nom + " a gagné !\n");
    }

    @Override
    public void affichageJoueurActif(String nom, int position, int vie) {
        afficher("Le joueur actif est " + nom + " en position " + position + " avec " + vie + " de vie.\n");
    }

    @Override
    public void affichageLancerDe(String nom) {
        afficher(lj + nom + " lance le dé.\n");
    }

    @Override
    public void affichagePosition(String nom, int position) {
        afficher(lj + nom + " est à la position " + position + ".\n");
    }

    @Override
    public void affichagePremierJoueur(String nom) {
        afficher(lj + nom + " commence.\n");
    }

    @Override
    public void affichageResultat(String nom, int resultat) {
        afficher(lj + nom + " obtient un résultat de " + resultat + ".\n");
    }

    @Override
    public void afficher(String truc) {
        System.out.println(truc);
    }

	@Override
	public void afficherAvancer(String nom, int distance) {
	       afficher(lj + nom + " avance à la case " + distance +".\n");
		
	}

	@Override
	public void afficherDuel() {
		afficher("Les deux joueurs sont tombé sur la même case : Duel.\n");
		
	}

	@Override
	public void afficherFinDeTour(String nom, int position, int vie) {
	       afficher(lj + nom + " a fini son tour avec " + vie + " de vie et en position " + position +".\n");
		
	}

	@Override
	public void afficherMultiplicateur(String nom, double d) {
	       afficher("Le joueur " + nom + " a un multiplicateur de " + d + ".\n");
		
	}

	@Override
	public void afficherPiege(String nom, String piege) {
	       afficher(lj + nom + " est sur une case événement : " + piege +".\n");
	    }

    
    
}