package jeu;

import java.security.SecureRandom;
import java.util.Random;

public class Plateau {
	private Case[] cases;
	private int nbCase = 30;
	private int valeur;
	private int cptCaseChangerPos;
	private int cptCaseChangerVie;
	private int cptCaseModifDe;
	private Jeu jeu;

	public int chiffreRandom(int max) {
		// utile pour générer un chiffre aléatoire pour le reste du programme
		Random random;
		try {
			random = SecureRandom.getInstanceStrong();
			valeur = random.nextInt(max) + 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return valeur;
	}

	public Plateau(Jeu jeu) {
		this.jeu = jeu;
		cases = new Case[nbCase + 1];
		for (int i = 0; i < nbCase + 1; i++) {
			valeur = chiffreRandom(7); // random défini dans jeu
			if (valeur == 2 && cptCaseChangerPos < 5) {
				cases[i] = new CaseChangerPosition(chiffreRandom(4), this.jeu);
				cptCaseChangerPos += 1;
			} else if (i == 10) {
				cases[i] = new CaseChangerPosition(4, jeu);
			} else if (valeur == 4 && cptCaseChangerVie < 5) {
				cases[i] = new CaseChangerVie(chiffreRandom(2) + 5, this.jeu);
				cptCaseChangerVie += 1;
			} else if (valeur == 6 && cptCaseModifDe < 5) {
				cases[i] = new CaseModifDe(chiffreRandom(3) + 7, this.jeu);
				cptCaseModifDe += 1;
			} else {
				cases[i] = new CaseNormal(this.jeu);
			}
		}

	}

	public Case getCase(int indice) {
		if (indice >= 0 && indice < nbCase) {
			return cases[indice];
		} else {
			throw new IllegalArgumentException("Indice de case invalide.");
		}
	}

	public int getNbCase() {
		return nbCase;
	}
}
