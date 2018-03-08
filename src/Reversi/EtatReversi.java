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
		TypeCase couleurJoueur ;
		TypeCase couleurEnnemi ;
		// on recupere les types de cases des joueurs
		if(joueurCourant.getCouleurJoueur() == Color.black) {
			couleurEnnemi = TypeCase.blanche;
			couleurJoueur = TypeCase.noir;
		}else {
			couleurEnnemi = TypeCase.noir;
			couleurJoueur = TypeCase.blanche;
		}
		int k = 0;
		boolean prise = false ;
		// parcours des pions
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
				k = j ;
				// si on trouve un pion du joueur courant on tests les coups possibles
	    		if(jeu[i][j] == couleurJoueur) {
	    			// test coup vers la gauche
	    				while(k-1 >= 0 && jeu[i][k-1] != couleurJoueur ) {
	    					// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
	    					if(jeu[i][k] == couleurEnnemi) {
	    						prise = true ;
	    					}
	    					// si on a sauté un pion ennemi et qu'il y a une case vide derrière
	    					if(prise && jeu[i][k] == TypeCase.vide) {
	    						jeu[i][k] = TypeCase.jouable;
	    						prise = false ; 
	    						break;
	    					}
	    					k--;
	    				}
	    				k = j;
	    				// test coup vers la droite
	    				while(k+1 < jeu[1].length && jeu[i][k+1] != couleurJoueur ) {
	    					// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
	    					if(jeu[i][k] == couleurEnnemi) {
	    						prise = true ;
	    					}
	    					// si on a sauté un pion ennemi et qu'il y a une case vide derrière
	    					if(prise && jeu[i][k] == TypeCase.vide) {
	    						jeu[i][k] = TypeCase.jouable;
	    						prise = false ; 
	    						break;
	    					}
	    					k++;
	    				}
	    				k = i ;
	    				// test coup vers le bas
	    				while(k+1 < jeu.length && jeu[k+1][j] != couleurJoueur ) {
	    					// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
	    					if(jeu[k][j] == couleurEnnemi) {
	    						prise = true ;
	    					}
	    					// si on a sauté un pion ennemi et qu'il y a une case vide derrière
	    					if(prise && jeu[k][j] == TypeCase.vide) {
	    						jeu[k][j] = TypeCase.jouable;
	    						prise = false ; 
	    						break;
	    					}
	    					k++;
	    				}
	    				k = i ;
	    				// test coup vers le haut
	    				while(k-1 >=0 && jeu[k-1][j] != couleurJoueur ) {
	    					// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
	    					if(jeu[k][j] == couleurEnnemi) {
	    						prise = true ;
	    					}
	    					// si on a sauté un pion ennemi et qu'il y a une case vide derrière
	    					if(prise && jeu[k][j] == TypeCase.vide) {
	    						jeu[k][j] = TypeCase.jouable;
	    						prise = false ; 
	    						break;
	    					}
	    					k--;
	    				}
	    				
	    		}
			}
		}
	}


	@Override
	public void lireEtat() {
		
	}


	@Override
	public void ecrireEtat() {

	}

	public TypeCase[][] getJeu() {
		return jeu;
	}

	public void setJeu(TypeCase[][] jeu) {
		this.jeu = jeu;
	}
	
	
	
}
