package jeu;

import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Random;

public class Jeu {
	De de = new De(12);
	private Pirate joueur1 = new Pirate("Ratass4000", 1, 5, 1, 1);
	private Pirate joueur2 = new Pirate("LordRonpicheur", 1, 5, 2, 1);
	private Pirate joueuractu;
	JournalDeBord log = new JournalDeBord();
	Plateau plateau = new Plateau(this);
	private int valeur;

	public void applicationCase() {
		if (joueuractu.getMultiplicateurDe() == 0) {
			joueuractu.setMultiplicateurDe(1);
		} else { // pour éviter qu'un joueur soit perpétuellement bloqué sur une case
			joueuractu.setMultiplicateurDe(1);
			plateau.getCase(joueuractu.getPosition()).effetCase();
		}
	}

	public void attenteSuite() {
		Scanner scanner = new Scanner(System.in); // besoin de laisser ouvert parce que si on met un scanner.close ça
													// n'attend pas pour la suite
		log.afficher("Appuyez sur la touche entrée pour continuer...\n");
		while (true) {
			if (scanner.hasNextLine()) {
				scanner.nextLine();
			}
			break;
		}
	}

	public void changerJoueur() {
		log.afficher("changement de joueur");
		if (joueuractu.getNumID() == joueur1.getNumID()) {
			joueur1 = joueuractu;
			joueuractu = joueur2;
		} else if (joueuractu.getNumID() == joueur2.getNumID()) {
			joueur2 = joueuractu;
			joueuractu = joueur1;
		} else {
			log.afficher("erreur update joueur");
		}
	}

	public void checkDuel() {
		if (joueur1.getPosition() == joueur2.getPosition()) {
			log.afficherDuel();
			joueur1.setResDe(0);
			joueur2.setResDe(0);
			while (joueur1.getResDe() == joueur2.getResDe()) {
				lancerDeJ1();
				lancerDeJ2();
			}
			if (joueur1.getResDe() > joueur2.getResDe()) {
				log.affichageGagnant(joueur1.getNom());
				joueur2.changerVieDuel();
			} else {
				log.affichageGagnant(joueur2.getNom());
				joueur1.changerVieDuel();
			}
		}
	}

	public void checkVictoire() {
		if (joueur1.getVie() == 0 || joueur2.getPosition() == plateau.getNbCase()) {
			log.affichageGagnant(joueur2.getNom());
			log.afficher("fin de la partie");
		} else if (joueur2.getVie() == 0 || joueur1.getPosition() == plateau.getNbCase()) {
			log.affichageGagnant(joueur1.getNom());
			log.afficher("fin de la partie");
		}
	}

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

	public void choisirJ1() {
		while (joueur1.getResDe() == joueur2.getResDe()) {
			lancerDeJ1();
			lancerDeJ2();
		}
		if (joueur1.getResDe() > joueur2.getResDe()) {
			joueur1.setNumID(1);
			joueur2.setNumID(2);
			log.affichagePremierJoueur(joueur1.getNom());
			joueuractu = joueur1;
			attenteSuite();
		} else {
			joueur1.setNumID(2);
			joueur2.setNumID(1);
			log.affichagePremierJoueur(joueur2.getNom());
			joueuractu = joueur2;
			attenteSuite();
		}
	}

	public int correctionCase() {
		if (joueuractu.getPosition() > plateau.getNbCase()) {
			joueuractu.setPosition(plateau.getNbCase() - (joueuractu.getPosition() - plateau.getNbCase()));
		} else if (joueuractu.getPosition() == plateau.getNbCase()) {
			log.affichagePosition(joueuractu.getNom(), joueuractu.getPosition());
			return 1;
		}
		if (joueuractu.getPosition() < 0) {
			joueuractu.setPosition(0);
		}
		return 0;
	}

	public De getDe() {
		return de;
	}

	public Pirate getJ1() {
		return joueur1;
	}

	public Pirate getJ2() {
		return joueur2;
	}

	public Pirate getJA() {
		return joueuractu;
	}

	public JournalDeBord getLog() {
		return log;
	}

	public void lancerDeJ1() {
		log.affichageLancerDe(joueur1.getNom());
		attenteSuite();
		joueur1.setResDe(de.lancerDe());
		log.affichageResultat(joueur1.getNom(), joueur1.getResDe());
	}

	public void lancerDeJ2() {
		log.affichageLancerDe(joueur2.getNom());
		attenteSuite();
		joueur2.setResDe(de.lancerDe());
		log.affichageResultat(joueur2.getNom(), joueur2.getResDe());
	}

	public void lancerDeJA() {
		log.affichageJoueurActif(joueuractu.getNom(), joueuractu.getPosition(), joueuractu.getVie());
		log.afficherMultiplicateur(joueuractu.getNom(), joueuractu.getMultiplicateurDe());
		log.affichageLancerDe(joueuractu.getNom());
		attenteSuite();
		joueuractu.setResDe(de.lancerDe());
		log.affichageResultat(joueuractu.getNom(), joueuractu.getResDe());
		log.afficherAvancer(joueuractu.getNom(),joueuractu.avancerPirate((int)( joueuractu.getResDe() * joueuractu.getMultiplicateurDe())));
	}

	public void lancerJeu() {
		choisirJ1();
		partie();
	}

	public void partie() {
		// tant que y en a pas un des deux qui a gagné ou mort
		while ((joueur1.getPosition() != plateau.getNbCase() && joueur2.getPosition() != plateau.getNbCase())
				&& (joueur1.getVie() > 0 && joueur2.getVie() > 0)) {
			log.afficher("######################################################################\n\n");
			// lancé du dé par le joueur actif
			lancerDeJA();
			// si jamais le joueur dépasse la ligne d'arrivée ou passe dans les négatifs
			if (correctionCase() != 1) {
				applicationCase();
				checkDuel();
				log.afficherFinDeTour(joueuractu.getNom(), joueuractu.getPosition(), joueuractu.getVie());
				attenteSuite();
				// mise a jour des données du joueur actif et passage au joueur suivant
				changerJoueur();
			}
		}
		checkVictoire();

	}
}
