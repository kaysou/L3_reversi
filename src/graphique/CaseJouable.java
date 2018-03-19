package graphique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Reversi.Jeu;

/**
 * JButton qui represente une case avec un possibilité de poser un jeton
 *
 */
public class CaseJouable extends JButton implements Case {
	// image d'une case jouable
	private Color jouable;
	private Jeu jeu;
	private int x, y;
	
	public CaseJouable(int i, int j, Jeu jf) {
		this.jeu = jf;
		jouable = Color.GREEN;
		this.x = i;
		this.y = j;
		this.setBackground(jouable);
		this.setSize(50,50);
		final TypeCase couleurJoueur;
		if( jeu.getCourant().getCouleurJoueur() == Color.black) {
			couleurJoueur = TypeCase.noir;
		}else {
			couleurJoueur = TypeCase.blanche;
		}
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jeu.jouer(x,y) ;
				System.out.println("test");
			}
		});
	}

	@Override
	public TypeCase getType() {
		return TypeCase.jouable;
	}


}
