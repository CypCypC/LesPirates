package jeu;
import java.security.SecureRandom;
import java.util.Random;

public class De{
	private int nbFace = 12;
	private int valeur;
	
	public De (int nbFace) {
		this.nbFace = nbFace;
	}
	
	public int lancerDe() {
		  Random random;
			try {
				random = SecureRandom.getInstanceStrong();
				valeur = random.nextInt(nbFace) + 1;

			} catch (Exception e) {
				e.printStackTrace();
			}
		return valeur;
	}
}