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


	@Override
	public String toString() {
		String hautPlateau = "a b c d e f g h i j k l m n o p q r s t u v w x y z ";
		String plateau =  hautPlateau.substring(0, taillePlateau*2 ) + "\n";

		for(String[] s1 : jeu) {

			for(String s2 : s1) {
				plateau += s2 + " ";
			}
			plateau += "\n" ; 
		}
		return "Jeu [jeu= \n" + plateau + " ]";
	}


}
