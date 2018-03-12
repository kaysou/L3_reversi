package graphique;

import java.awt.Color;
import javax.swing.JButton;

import Reversi.Jeu;

/**
 * JButton qui represente une case sans jeton ni possibilité de jouer un jeton dessus
 *
 */
public class CaseVide extends JButton implements Case{
	// image de case vide
	private Color vide;
	private Jeu jeu;

	public CaseVide(Jeu jf) {
		this.jeu = jf;
		vide = Color.GRAY;
		this.setBackground(vide);			  
		this.setSize(50, 50);

	}

	@Override
	public TypeCase getType() {
		return TypeCase.vide;
	}

}
