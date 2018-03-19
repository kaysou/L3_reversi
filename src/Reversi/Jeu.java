package Reversi;

import java.awt.Color;
import java.util.Arrays;
import java.util.Observable;

import graphique.TypeCase;

/**
 * 
 * Class jeu
 * contient un tableau de String qui correspond au plateau de jeu
 * contient des joueurs 
 */
public class Jeu extends Observable {
	private TypeCase[][] jeu;
	private JoueurReversi j1 = new JoueurReversi(Color.white);
	private JoueurReversi j2 =  new JoueurReversi(Color.BLACK);
	
	private JoueurReversi courant;
	
	private int taillePlateau;
	
	/**
	 * Constructeur de jeu qui remplit le plateau a vide sauf les 4 pions de départ
	 * @param taille, taille du plateau a générer 
	 */
	public Jeu(int taille) {
		this.jeu = new TypeCase[taille][taille] ;
		this.taillePlateau = taille ;
		
		for(int i = 0 ; i < taille ; i++) {
			for(int j = 0 ; j < taille ; j++) {
				jeu[i][j] = TypeCase.vide ;
			}
		}
		// dessiner les 4 pions de base
		// pions blanc
		this.jeu[taille/2][taille/2] = TypeCase.blanche ;
		this.jeu[(taille/2-1)][(taille/2)-1] = TypeCase.blanche ;
		// pions noir
		this.jeu[taille/2][(taille/2)-1] = TypeCase.noir ;
		this.jeu[(taille/2)-1][taille/2] = TypeCase.noir ;
		
		// les jetons blancs commencent
		courant = j1;
	}

	/**
	 * Methode d'affichage du jeu
	 */
	public String afficherPlateau(TypeCase[][] game) {
		String plateau = "";
		
		for(TypeCase[] s1 : game) {
			for(TypeCase s2 : s1) {
				plateau += s2 + " ";
			}
			plateau += "\n" ; 
		}
		return "plateau du jeu [ \n" + plateau + " ]";
	}

	
	public void jouer(int x, int y) {
		this.setCase(x,y,this.courant.getTc());
	}
	
   // getter - setter 
	
	public TypeCase[][] getJeu() {
		return jeu;
	}


	public void setJeu(TypeCase[][] jeu) {
		this.jeu = jeu;
		setChanged();
		notifyObservers();
	}


	public JoueurReversi getJ1() {
		return j1;
	}


	public void setJ1(JoueurReversi j1) {
		this.j1 = j1;
	}


	public JoueurReversi getJ2() {
		return j2;
	}


	public void setJ2(JoueurReversi j2) {
		this.j2 = j2;
	}


	public int getTaillePlateau() {
		return taillePlateau;
	}


	public JoueurReversi getCourant() {
		return courant;
	}

	public void setCourant(JoueurReversi courant) {
		this.courant = courant;
	}

	public void setTaillePlateau(int taillePlateau) {
		this.taillePlateau = taillePlateau;
	}
	
	public void setCase(int i, int j, TypeCase newType) {
		this.jeu[i][j] = newType;
		setChanged();
		notifyObservers();
	}


}
