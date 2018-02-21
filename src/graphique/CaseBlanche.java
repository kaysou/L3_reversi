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
 * JButton qui represente une case avec un jeton blanc
 *
 */
public class CaseBlanche extends JButton implements Case {
	// image du jeton blanc
	private Image img;

	public CaseBlanche() {
		try {

			img = ImageIO.read(new File("src/ressources/white.png"));
			ImageIcon icon = new ImageIcon(img);
			this.setIcon(icon);
			this.setSize(icon.getIconWidth(), icon.getIconHeight());

			
			this.setBorderPainted(false);
			this.setBorder(null);

			this.setMargin(new Insets(0, 0, 0, 0));
			this.setContentAreaFilled(false);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public TypeCase getType() {
		return TypeCase.blanche;
	}
}
