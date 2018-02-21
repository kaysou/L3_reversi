package Reversi;

import java.awt.Color;

public class JoueurReversi extends Joueur{
	private Color couleurJoueur;
	// booleen pour definir si le joueur peut jouer ou non
	private boolean tour;
	
	public JoueurReversi(Color c) {
		this.couleurJoueur = c ;
		tour = false;
	}

	@Override
	public String toString() {
		return "JoueurReversi " + couleurJoueur ;
	}

	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public Color getCouleurJoueur() {
		return couleurJoueur;
	}

	
	
}
