package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JPanel panJoueur;
	
	public ReversiJFrame(int taille, Jeu jeu) {
		this.setTitle("Animation");
	    this.setSize(600, 600);
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
	    
	    panJoueur = new JPanel();
	    panJoueur.add(new JLabel(jeu.getCourant().getCouleurJoueur() == Color.BLACK ? "Joueur courant : noir ": "Joueur courant : blanc" ));
	    
	    this.setLayout(new BorderLayout());
	    
	    pan.setLayout(grid);
	    
	    this.add(pan,BorderLayout.CENTER);
	    this.add(panJoueur, BorderLayout.NORTH);
	    this.setVisible(true);
	    game.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		Jeu courant = ((Jeu)o);
		this.remove(pan);
		this.remove(panJoueur);
		this.tab = courant.getJeu();
		this.pan = new JPanel();
	    GridLayout grid = new GridLayout(taille, taille);
	    pan.setLayout(grid);


	    this.panJoueur = new JPanel();
	    panJoueur.add(new JLabel(courant.getCourant().getCouleurJoueur() == Color.BLACK ? "Joueur courant : noir ": "Joueur courant : blanc" ));
	   
	    
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
		
		this.add(pan, BorderLayout.CENTER);
		this.add(panJoueur, BorderLayout.NORTH);
		SwingUtilities.updateComponentTreeUI(this);
		//System.out.println(game.afficherPlateau(game.getJeu()));
	}
}
