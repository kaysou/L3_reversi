package graphique;

import java.awt.Color;
import javax.swing.JButton;

/**
 * JButton qui represente une case avec un jeton blanc
 *
 */
public class CaseBlanche extends JButton implements Case {
	// image du jeton blanc
	private Color blanc;

	public CaseBlanche() {
			blanc = Color.WHITE;
			this.setBackground(blanc);;
			this.setSize(50,50);
	}

	@Override
	public TypeCase getType() {
		return TypeCase.blanche;
	}
}
