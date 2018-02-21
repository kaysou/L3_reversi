package Reversi;

import java.awt.Color;

import graphique.TypeCase;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private TypeCase[][] jeu;
	private JoueurReversi joueurCourant;
	
	
	public EtatReversi(TypeCase[][] game, JoueurReversi j) {
		this.jeu = game ;
		this.joueurCourant = j;
	}

	@Override
	public void successeur() {
		Color couleurJoueur = joueurCourant.getCouleurJoueur();
		// parcours des pions
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
	    		if(jeu[i][j] == TypeCase.vide) {

	    		}else
	    		if(jeu[i][j] == TypeCase.blanche) {

	    		}else
	    		if(jeu[i][j] == TypeCase.noir){

	    		}
			}
		}
		// si croise un de ses pions on fait rien
		// si on croise un pions de l'autre couleur on continue 
		// si on peut placer son pion on le met et on change les couleurs
		// generation etat 
		// on recommence en verifiant que l'etat ne soit pas généré deux fois
	}


	@Override
	public void lireEtat() {
		
	}


	@Override
	public void ecrireEtat() {

	}
	
}
