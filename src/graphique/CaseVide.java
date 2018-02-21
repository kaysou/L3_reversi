package graphique;

import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * JButton qui represente une case sans jeton ni possibilité de jouer un jeton dessus
 *
 */
public class CaseVide extends JButton implements Case{
	// image de case vide
	private Image vide;
	
	public CaseVide() {
		  try {

			  vide = ImageIO.read(new File("src/ressources/caseVide.png"));
			  ImageIcon img = new ImageIcon(vide);
			  this.setIcon(img);
			  this.setSize(img.getIconWidth(), img.getIconHeight());
			  
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
		return TypeCase.vide;
	}

}
