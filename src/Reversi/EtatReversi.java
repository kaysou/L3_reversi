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
		
	}


	@Override
	public void lireEtat() {
		
	}


	@Override
	public void ecrireEtat() {

	}
	
}
