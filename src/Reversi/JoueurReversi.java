package Reversi;

import java.awt.Color;

public class JoueurReversi extends Joueur{
	private Color couleurJoueur;

	public JoueurReversi(Color c) {
		this.couleurJoueur = c ;
	}

	@Override
	public String toString() {
		return "JoueurReversi " + couleurJoueur ;
	}

	
}
