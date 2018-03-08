package graphique;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Reversi.Jeu;

/**
 * Classe graphique qui permet d'afficher le plateau d'un jeu donnée et les possibilités pour jouer
 *
 */
public class ReversiJFrame extends JFrame {
	private JPanel pan ;
	
	public ReversiJFrame(int taille, Jeu game) {
		this.setTitle("Animation");
	    this.setSize(275, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    pan = new JPanel();

	    GridLayout grid = new GridLayout(taille, taille);
	    
	    TypeCase[][] tab = game.getJeu();
	    
	    for(int i = 0; i < taille; i++) {
	    	for(int j = 0; j < taille; j++) {
	    		if(tab[i][j] == TypeCase.vide) {
			    	this.pan.add(new CaseVide());
	    		}else
	    		if(tab[i][j] == TypeCase.blanche) {
	    			this.pan.add(new CaseBlanche());
	    		}else
	    		if(tab[i][j] == TypeCase.noir){
	    			this.pan.add(new CaseNoir());
	    		}else
		    		if(tab[i][j] == TypeCase.jouable){
		    			this.pan.add(new CaseJouable());
		    		}

		    }
	    }
	    
	    pan.setLayout(grid);
	    this.setContentPane(pan);
	    this.setVisible(true);
	}
}
