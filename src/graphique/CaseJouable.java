package graphique;

import java.awt.Color;
import javax.swing.JButton;

/**
 * JButton qui represente une case avec un possibilité de poser un jeton
 *
 */
public class CaseJouable extends JButton implements Case {
	// image d'une case jouable
	private Color jouable;

	public CaseJouable() {
			jouable = Color.GREEN;
			this.setBackground(jouable);
			this.setSize(50,50);
	}

	@Override
	public TypeCase getType() {
		return TypeCase.jouable;
	}
}
