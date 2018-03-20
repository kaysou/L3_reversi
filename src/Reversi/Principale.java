package Reversi;

import graphique.ReversiJFrame;

public class Principale {

	public static void main(String[] args) {
		Jeu j = new Jeu(8);
		//System.out.print(j.afficherPlateau(j.getJeu()));

		/**
		 * test interface graphique
		 */
		
		ReversiJFrame frame = new ReversiJFrame(8,j);
		
	}

}
