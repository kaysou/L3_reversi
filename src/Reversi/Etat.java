package Reversi;

import graphique.TypeCase;

public abstract class Etat {

	public abstract void successeur(TypeCase[][] plateau, PointPerso p);
	public abstract void lireEtat();
	public abstract void ecrireEtat();
}
