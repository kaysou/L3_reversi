package Reversi;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private String[][] jeu;
	private Joueur joueurCourant;
	
	
	public EtatReversi(Jeu game, Joueur j) {
		this.jeu = game.getJeu() ;
		this.joueurCourant = j;
	}

	@Override
	public void successeur() {
		// parcours des pions
		// si croise un de ses pions on fait rien
		// si on croise un pions de l'autre couleur on continue 
		// si on peut placer son pion on le met et on change les couleurs
		// generation etat 
		// on recommence en verifiant que l'etat ne soit pas généré deux fois
	}


	@Override
	public void lireEtat() {
		
	}


	@Override
	public void ecrireEtat() {

	}
	
}
