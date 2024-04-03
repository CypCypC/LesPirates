package jeu;

public abstract class Case{
	private int specialite;
	protected Jeu jeu;

	protected Case(int specialite, Jeu jeu) {
		this.specialite = specialite;
		this.jeu = jeu;
		
	}
	



	public int getSpecialite() {
		return specialite;
	}
	

	public void effetCase() {
		int val = this.getSpecialite();
		switch(val) {
		case 1:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Tempête");
			jeu.getJA().setPosition(jeu.getDe30face().lancerDe());
			break;
		case 2:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Jour de chance");
			jeu.getJA().setResDe(jeu.getDe().lancerDe());
			jeu.getJA().avancerPirate(jeu.getJA().getResDe());
			jeu.getLog().affichageResultat(jeu.getJA().getNom(), jeu.getJA().getResDe());
			break;
		case 3:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Manque de bol");
			jeu.getJA().setResDe(jeu.getDe().lancerDe());
			jeu.getJA().reculerPirate(jeu.getJA().getResDe());
			jeu.getLog().affichageResultat(jeu.getJA().getNom(), jeu.getJA().getResDe());
			break;
		case 4:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Echange de position");
			int posTemp = jeu.getJ1().getPosition();
			jeu.getJ1().setPosition(jeu.getJ2().getPosition());
			jeu.getJ2().setPosition(posTemp);
			break;
		case 5:
			jeu.getJA().changerVie(jeu.getJA().getVie() - jeu.chiffreRandom(3));
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "perte de vie, il a maintenant " + jeu.getJA().getVie());
			break;
		case 6:
			jeu.getJA().changerVie(jeu.getJA().getVie() + jeu.chiffreRandom(3));
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "gain de vie, il a maintenant " + jeu.getJA().getVie());
			break;
		case 7:
			jeu.getJA().setMultiplicateurDe(jeu.chiffreRandom(2) + 1);
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "est bourré, gain de vitesse dé : " + jeu.getJA().getMultiplicateurDe());
			break;
		case 8:
			jeu.getJA().setMultiplicateurDe(1 / (jeu.chiffreRandom(2) + 1));
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "est fatigué, perte de vitesse dé : " + jeu.getJA().getMultiplicateurDe());
			break;
		case 9:
			jeu.getJA().setMultiplicateurDe(0);
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "est perdu dans la foret, il passe son tour");
			break;
		default:
			jeu.getLog().afficher("Case normale.\n");
			break;
		}
	}
}
