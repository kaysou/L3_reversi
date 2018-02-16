package Reversi;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private String[][] jeu;
	private Joueur joueurCourant;
	
	
	public EtatReversi(Jeu game) {
		this.jeu = game.getJeu() ;
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
