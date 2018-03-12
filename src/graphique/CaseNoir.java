package graphique;

import java.awt.Color;
import javax.swing.JButton;

import Reversi.Jeu;


/**
 * JButton qui represente une case avec un jeton noir
 *
 */
public class CaseNoir extends JButton implements Case {
	// image du jeton noir
	private Color noir;
	private Jeu jeu;

	public CaseNoir(Jeu jf) {
		this.jeu = jf;
		noir = Color.BLACK;
		this.setBackground(noir);
		this.setSize(50,50);
	}

	@Override
	public TypeCase getType() {
		return TypeCase.noir;
	}
}
