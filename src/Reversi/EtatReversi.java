package Reversi;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private String[][] jeu;
	private Joueur joueurCourant;
	
	
	public EtatReversi(String[][] game, Joueur j) {
		this.jeu = game ;
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
