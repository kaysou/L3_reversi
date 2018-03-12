package graphique;

import java.awt.Color;
import javax.swing.JButton;

import Reversi.Jeu;

/**
 * JButton qui represente une case avec un jeton blanc
 *
 */
public class CaseBlanche extends JButton implements Case {
	// image du jeton blanc
	private Color blanc;
	private Jeu jeu;

	public CaseBlanche(Jeu jf) {
		this.jeu = jf;
		blanc = Color.WHITE;
		this.setBackground(blanc);;
		this.setSize(50,50);
	}

	@Override
	public TypeCase getType() {
		return TypeCase.blanche;
	}
}
