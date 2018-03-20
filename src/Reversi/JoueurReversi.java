package Reversi;

import java.awt.Color;

import graphique.TypeCase;

public class JoueurReversi extends Joueur{
	private Color couleurJoueur;
	private TypeCase tc;
	private boolean machine;
	
	// booleen pour definir si le joueur peut jouer ou non
	private boolean tour;
	
	public JoueurReversi(Color c) {
		this.couleurJoueur = c ;
		this.tc = c == Color.WHITE ? TypeCase.blanche : TypeCase.noir ;
		tour = false;
		this.machine = false;
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

	public TypeCase getTc() {
		return tc;
	}

	public boolean isMachine() {
		return machine;
	}

	public void setMachine(boolean machine) {
		this.machine = machine;
	}
}
