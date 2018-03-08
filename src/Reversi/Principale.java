package Reversi;

import java.awt.Color;

import graphique.ReversiJFrame;

public class Principale {

	public static void main(String[] args) {
		Jeu j = new Jeu(8);
		System.out.print(j.afficherPlateau(j.getJeu()));
		JoueurReversi player1 = new JoueurReversi(Color.BLACK);
		/**
		 * test interface graphique
		 */
		EtatReversi test = new EtatReversi(j.getJeu(), player1);
		test.successeur();
		j.setJeu(test.getJeu());
				
		ReversiJFrame frame = new ReversiJFrame(8,j);
	}

}
