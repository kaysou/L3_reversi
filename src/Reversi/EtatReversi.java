package Reversi;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import graphique.TypeCase;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private TypeCase[][] jeu;
	private JoueurReversi joueurCourant;
	private JoueurReversi joueurAdv;

	public EtatReversi(Jeu game) {
		this.jeu = game.getJeu() ;
		this.joueurCourant = game.getJ1();
		this.joueurAdv = game.getJ2();
	}
	
	public void successeur() {
		TypeCase couleurJoueur = joueurCourant.getTc() ;
		TypeCase couleurEnnemi = joueurAdv.getTc() ;
		TypeCase jouable = TypeCase.jouable;
		
		// parcours des pions
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
				if (jeu[i][j] == jouable){
					
				}
			}
		}
	}
	
	public TypeCase[][] calculSuccesseur(int i, int j){
		TypeCase[][] tmp = cloneJeu(jeu);
		
		
		
		return tmp;
	}
	
/**
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
		// nouvel EtatReversi qui sera créer et ajouter a l'arraylist des successeur
		EtatReversi nouvEtat; 
		// plateau de jeu temporaire qui permet le calcul des successeurs
		TypeCase [][] tmp; 
		// ArrayList qui contient les successeurs
		ArrayList<EtatReversi> listeSucc = new ArrayList<EtatReversi>();

		// parcours des pions
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
				k = j ;
				tmp = cloneJeu(jeu);
				// si on trouve un pion du joueur courant on tests les coups possibles
				if(jeu[i][j] == couleurJoueur) {
					// test coup vers la gauche
					while(k-1 >= 0 && jeu[i][k-1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[i][k] == couleurEnnemi) {
							//tmp[i][k] = couleurJoueur; // on prend la case
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[i][k] == TypeCase.vide) {
							System.out.println("successeur");
							jeu[i][k] = TypeCase.jouable;
							//tmp[i][k] = couleurJoueur;
							prise = false ; 
							//nouvEtat = new EtatReversi(tmp,joueurAdv, joueurCourant);
							listeSucc.add(nouvEtat);
							break;
						}
						k--;
					}
					tmp = cloneJeu(jeu);
					k = j;
					// test coup vers la droite
					while(k+1 < jeu[1].length && jeu[i][k+1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[i][k] == couleurEnnemi) {
							//tmp[i][k] = couleurJoueur; // on prend la case
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[i][k] == TypeCase.vide) {
							System.out.println("successeur");
							jeu[i][k] = TypeCase.jouable;
							//tmp[i][k] = couleurJoueur;
							prise = false ; 
							//nouvEtat = new EtatReversi(tmp,joueurAdv, joueurCourant);
							listeSucc.add(nouvEtat);
							break;
						}
						k++;
					}
					tmp = cloneJeu(jeu);
					k = i ;
					// test coup vers le bas
					while(k+1 < jeu.length && jeu[k+1][j] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][j] == couleurEnnemi) {
							//tmp[i][k] = couleurJoueur; // on prend la case
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][j] == TypeCase.vide) {
							System.out.println("successeur");
							jeu[i][k] = TypeCase.jouable;
							//tmp[i][k] = couleurJoueur;
							prise = false ; 
							//nouvEtat = new EtatReversi(tmp,joueurAdv, joueurCourant);
							listeSucc.add(nouvEtat);
							break;
						}
						k++;
					}
					tmp = cloneJeu(jeu);
					k = i ;
					// test coup vers le haut
					while(k-1 >=0 && jeu[k-1][j] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][j] == couleurEnnemi) {
							//tmp[i][k] = couleurJoueur; // on prend la case
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][j] == TypeCase.vide) {
							System.out.println("successeur");
							jeu[i][k] = TypeCase.jouable;
							//tmp[i][k] = couleurJoueur;
							prise = false ; 
							//nouvEtat = new EtatReversi(tmp,joueurAdv, joueurCourant);
							listeSucc.add(nouvEtat);
							break;
						}
						k--;
					}
				}
			}
		}
	}**/

	//  calcul des cases jouable en diagonale
	// vertical = HAUT BAS
	// horizontal = GAUCHE DROITE
	public void calculDiag(TypeCase joueur, TypeCase ennemi, String vertical, String horizontal){



	}

	// calcul des cases jouable par le joueur courant
	public void caseJouable(){
		TypeCase couleurJoueur = joueurCourant.getTc() ;
		TypeCase couleurEnnemi = joueurAdv.getTc() ;
		

		Point p;
		int k = 0;
		int w = 0;
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
					k = i ;
					w = j;
					// test coup vers le haut a gauche
					while(k-1 >=0 && w-1 >=0 && jeu[k-1][w-1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][w] == TypeCase.vide) {
							jeu[k][w] = TypeCase.jouable;
							prise = false ; 
							break;
						}
						k--;
						w--;
					}
					k = i ;
					w = j;
					// test coup vers le haut a droite
					while(k-1 >=0 && w+1 < jeu.length && jeu[k-1][w+1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][w] == TypeCase.vide) {
							jeu[k][w] = TypeCase.jouable;
							prise = false ; 
							break;
						}
						k--;
						w++;
					}
					k = i ;
					w = j;
					// test coup vers le bas  a gauche
					while(k+1 < jeu.length && w-1 >=0 && jeu[k+1][w-1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][w] == TypeCase.vide) {
							jeu[k][w] = TypeCase.jouable;
							prise = false ; 
							break;
						}
						k++;
						w--;
					}
					k = i ;
					w = j;
					// test coup vers le bas  a droite
					while(k+1 < jeu.length && w+1 < jeu.length && jeu[k+1][w+1] != couleurJoueur ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if(prise && jeu[k][w] == TypeCase.vide) {
							jeu[k][w] = TypeCase.jouable;
							prise = false ; 
							break;
						}
						k++;
						w--;
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
	
	public TypeCase[][] cloneJeu( TypeCase [][] jeu){
		TypeCase[][] nouvJeu = new TypeCase[jeu.length][jeu[1].length];
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
				nouvJeu[i][j] = jeu[i][j];
			}
		}
		return nouvJeu;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtatReversi other = (EtatReversi) obj;
		if (!Arrays.deepEquals(jeu, other.jeu))
			return false;
		if (joueurAdv == null) {
			if (other.joueurAdv != null)
				return false;
		} else if (!joueurAdv.equals(other.joueurAdv))
			return false;
		if (joueurCourant == null) {
			if (other.joueurCourant != null)
				return false;
		} else if (!joueurCourant.equals(other.joueurCourant))
			return false;
		return true;
	}


}
