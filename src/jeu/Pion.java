package jeu;

public class Pion extends Jeu {
	private int position;
	
	public int avancerPion(int distance) {
		position = position + distance;
		if (position > getNbCase()) {
			position = getNbCase() - (position - getNbCase());
		}
		return position;
	}
	
	public int getPosition() {
		return position;
	}
}
