package graphique;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * JButton qui represente une case avec un possibilité de poser un jeton
 *
 */
public class CaseJouable extends JButton implements Case {
	// image d'une case jouable
	private Image img;

	public CaseJouable() {
		try {

			img = ImageIO.read(new File("src/ressources/jouable.png"));
			ImageIcon icon = new ImageIcon(img);
			this.setIcon(icon);
			this.setSize(icon.getIconWidth(), icon.getIconHeight());

			
			this.setBorderPainted(false);
			this.setBorder(null);

			this.setMargin(new Insets(0, 0, 0, 0));
			this.setContentAreaFilled(false);

			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TypeCase getType() {
		return TypeCase.jouable;
	}
}
