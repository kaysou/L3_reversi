package Reversi;

import java.util.Arrays;

/**
 * 
 * Class jeu
 * contient un tableau de String qui correspond au plateau de jeu
 * contient des joueurs 
 */
public class Jeu {
	private String[][] jeu;
	private Joueur j1;
	private Joueur j2;
	private int taillePlateau;
	
	/**
	 * Constructeur de jeu qui remplit le plateau a vide sauf les 4 pions de départ
	 * @param taille, taille du plateau a générer 
	 */
	public Jeu(int taille) {
		this.jeu = new String[taille][taille] ;
		this.taillePlateau = taille ;
		
		for(int i = 0 ; i < taille ; i++) {
			for(int j = 0 ; j < taille ; j++) {
				jeu[i][j] = "v" ;
			}
		}
		// dessiner les 4 pions de base
		// pions blanc
		this.jeu[taille/2][taille/2] = "b" ;
		this.jeu[(taille/2-1)][(taille/2)-1] = "b" ;
		
		// pions noir
		this.jeu[taille/2][(taille/2)-1] = "n" ;
		this.jeu[(taille/2)-1][taille/2] = "n" ;

	}

	/**
	 * Methode d'affichage du jeu
	 */
	public String afficherPlateau(String[][] game) {
		String hautPlateau = "a b c d e f g h i j k l m n o p q r s t u v w x y z ";
		String plateau = "  " + hautPlateau.substring(0, taillePlateau*2 ) + "\n";
		int i = 0 ;
		
		for(String[] s1 : game) {
			plateau += ++i + " ";
			for(String s2 : s1) {
				plateau += s2 + " ";
			}
			plateau += "\n" ; 
		}
		return "plateau du jeu [ \n" + plateau + " ]";
	}

   // getter - setter 
	
	public String[][] getJeu() {
		return jeu;
	}


	public void setJeu(String[][] jeu) {
		this.jeu = jeu;
	}


	public Joueur getJ1() {
		return j1;
	}


	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}


	public Joueur getJ2() {
		return j2;
	}


	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}


	public int getTaillePlateau() {
		return taillePlateau;
	}


	public void setTaillePlateau(int taillePlateau) {
		this.taillePlateau = taillePlateau;
	}
	
	


}
