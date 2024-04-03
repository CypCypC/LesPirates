package jeu;

public abstract class Case{
	protected Jeu jeu;
	private int specialite;

	protected Case(int specialite, Jeu jeu) {
		this.specialite = specialite;
		this.jeu = jeu;
		
	}
	
	public void effetCase() {
		int val = this.getSpecialite();
		switch(val) {
		case 1:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Tempête : le joueur atterit quelque part");
			jeu.getJA().setResDe(jeu.chiffreRandom(30));
			jeu.getJA().setPosition(jeu.getJA().getResDe());
			break;
		case 2:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Jour de chance. il relance le dé");
			jeu.getJA().setResDe(jeu.getDe().lancerDe());
			jeu.getJA().avancerPirate(jeu.getJA().getResDe());
			jeu.getLog().affichageResultat(jeu.getJA().getNom(), jeu.getJA().getResDe());
			break;
		case 3:
			jeu.getLog().afficherPiege(jeu.getJA().getNom(), "Manque de bol, il relance le dé et recule");
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
	

	public int getSpecialite() {
		return specialite;
	}
}
