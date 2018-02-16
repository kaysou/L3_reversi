package Reversi;

import java.util.Arrays;

public class Jeu {
	private String[][] jeu;
	private Joueur j1;
	private Joueur j2;
	
	public Jeu(int taille) {
		this.jeu = new String[taille][taille] ;
		// dessiner les 4 pions de base
		 this.jeu[taille/2][taille/2] = "x" ;
		 this.jeu[taille/2][taille/2] = "x" ;
		 this.jeu[taille/2][taille/2] = "x" ;
		 this.jeu[taille/2][taille/2] = "x" ;
		 System.out.println(taille/2);
		 
	}


	@Override
	public String toString() {
		String plateau = "";
		for(String[] s1 : jeu) {
			for(String s2 : s1) {
				plateau += s2 + " ";
			}
			plateau += "\n" ; 
		}
		return "Jeu [jeu= \n" + plateau + " ]";
	}
	
	
}
