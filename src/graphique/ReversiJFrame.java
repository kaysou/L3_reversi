package graphique;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Reversi.Jeu;

/**
 * Classe graphique qui permet d'afficher le plateau d'un jeu donnée et les possibilités pour jouer
 *
 */
public class ReversiJFrame extends JFrame implements Observer {
	private JPanel pan ;
	private TypeCase[][] tab;
	private int taille;
	private Jeu game;
	
	public ReversiJFrame(int taille, Jeu jeu) {
		this.setTitle("Animation");
	    this.setSize(275, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.taille = taille;
	    this.game = jeu;
	    pan = new JPanel();

	    GridLayout grid = new GridLayout(taille, taille);
	    
	    tab = game.getJeu();
	    
	    for(int i = 0; i < taille; i++) {
	    	for(int j = 0; j < taille; j++) {
	    		if(tab[i][j] == TypeCase.vide) {
			    	this.pan.add(new CaseVide(game));
	    		}else
	    		if(tab[i][j] == TypeCase.blanche) {
	    			this.pan.add(new CaseBlanche(game));
	    		}else
	    		if(tab[i][j] == TypeCase.noir){
	    			this.pan.add(new CaseNoir(game));
	    		}else
		    		if(tab[i][j] == TypeCase.jouable){
		    			this.pan.add(new CaseJouable(i,j,game));
		    		}

		    }
	    }
	    
	    pan.setLayout(grid);
	    this.setContentPane(pan);
	    this.setVisible(true);
	    game.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.tab = ((Jeu)o).getJeu();
		this.pan = new JPanel();
	    GridLayout grid = new GridLayout(taille, taille);
	    pan.setLayout(grid);
	    this.setContentPane(pan);


		for(int i = 0; i < taille; i++) {
	    	for(int j = 0; j < taille; j++) {
	    		if(tab[i][j] == TypeCase.vide) {
			    	this.pan.add(new CaseVide(game));
	    		}else
	    		if(tab[i][j] == TypeCase.blanche) {
	    			this.pan.add(new CaseBlanche(game));
	    		}else
	    		if(tab[i][j] == TypeCase.noir){
	    			this.pan.add(new CaseNoir(game));
	    		}else
		    		if(tab[i][j] == TypeCase.jouable){
		    			this.pan.add(new CaseJouable(i,j,game));
		    		}
		    }
	    }
		SwingUtilities.updateComponentTreeUI(this);
		//System.out.println(game.afficherPlateau(game.getJeu()));
	}
}
