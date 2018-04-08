package Reversi;

import java.util.Arrays;
import java.util.HashMap;


import graphique.TypeCase;

public class EtatReversi extends Etat {
	// plateau de jeu initial
	private TypeCase[][] jeu;
	private JoueurReversi joueurCourant;
	private JoueurReversi joueurAdv;
	private Jeu game;
	HashMap<PointPerso, EtatReversi> successeur;
	
	public EtatReversi(Jeu game) {
		this.game = game;
		if(game.firstLaunch) {
			this.jeu = game.getJeuInit();
		}else {
			this.jeu = game.getJeu() ;
		}
		
		this.successeur = new HashMap<>();
	}
	
	public void successeur(TypeCase[][] plateau, PointPerso p) {
		EtatReversi res = new EtatReversi(game);
		res.setJeu(plateau);
		res.setJoueurAdv(joueurCourant);
		res.setJoueurCourant(joueurAdv);

		successeur.put(p, res);
	}
	
	
	// calcul des cases jouable par le joueur courant
	public void caseJouable(){
		TypeCase couleurJoueur = joueurCourant.getTc() ;
		TypeCase couleurEnnemi = joueurAdv.getTc() ;
		

		PointPerso p;
		int k = 0;
		int w = 0;
		boolean prise = false ;
		TypeCase[][] jeuInitial = cloneJeu(jeu);
		TypeCase[][] tmp;
		
		// parcours des pions
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {

				// si on trouve un pion du joueur courant on tests les coups possibles
				if(jeu[i][j] == couleurJoueur) {
					k=j;
					// test coup vers la gauche
					//while ( k-1 < jeu.length && k-1 >= 0 && jeu[i][k-1] != couleurJoueur ) {
					while ( k < jeu.length && k >= 0 ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[i][k] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[i][k] == TypeCase.vide )|| (prise && jeu[i][k] == TypeCase.jouable )) {
							p = new PointPerso(i,k);

							if(jeu[i][k] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[i][k] = TypeCase.jouable;
							}else{
								EtatReversi tmp2 = successeur.get(p);

								tmp = tmp2.getJeu();
								
							}
								  while ( k <= j){
								  tmp[i][k] = couleurJoueur;
								  k++;
								  }
								  successeur(tmp,p);
								break;
							
						}
						if (jeu[i][k] == TypeCase.vide){
							break;
						}
						if (jeu[i][k] == couleurJoueur && prise ){
							break;
						}
						if (jeu[i][k] == TypeCase.jouable && !prise ){
							break;
						}
						k--;
					}
					prise = false ;
					k = j;
					// test coup vers la droite
					//while(k+1 >= 0 && k+1 < jeu.length && jeu[i][k+1] != couleurJoueur ) {
					while(k >= 0 && k < jeu.length ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[i][k] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[i][k] == TypeCase.vide )||( prise && jeu[i][k] == TypeCase.jouable )) {
							p = new PointPerso(i,k);
							if(jeu[i][k] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[i][k] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k >= j){
								tmp[i][k] = couleurJoueur;
								k--;
							}
							successeur(tmp,p);
							break;
						}
						if (jeu[i][k] == TypeCase.vide){
							break;
						}
						if (jeu[i][k] == couleurJoueur && prise ){
							break;
						}
						if (jeu[i][k] == TypeCase.jouable && !prise ){
							break;
						}

						k++;
					}
					prise = false ;
					k = i ;
					// test coup vers le bas
					//while(k+1 >= 0 && k+1 < jeu.length && jeu[k+1][j] != couleurJoueur ) {
					while(k >= 0 && k < jeu.length) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][j] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][j] == TypeCase.vide )|| (prise && jeu[k][j] == TypeCase.jouable) ) {
							p = new PointPerso(k,j);
							if(jeu[k][j] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][j] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k >= i){
								tmp[k][j] = couleurJoueur;
								k--;
							}
							successeur(tmp,p);
							break;
						}
						if (jeu[k][j] == TypeCase.vide){
							break;
						}
						if (jeu[k][j] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][j] == TypeCase.jouable && !prise ){
							break;
						}
						k++;
					}
					prise = false ;
					k = i ;
					// test coup vers le haut
					//while(k-1 < jeu.length && k-1 >=0 && jeu[k-1][j] != couleurJoueur ) {
					while(k < jeu.length && k >=0) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][j] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][j] == TypeCase.vide )||( prise && jeu[k][j] == TypeCase.jouable )) {
							p = new PointPerso(k,j);
							if(jeu[k][j] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][j] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k <= i){
								tmp[k][j] = couleurJoueur;
								k++;
							}
							successeur(tmp,p);
							break;

						}
						if (jeu[k][j] == TypeCase.vide){
							break;
						}
						if (jeu[k][j] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][j] == TypeCase.jouable && !prise ){
							break;
						}
						k--;
					}
					prise = false ;
					k = i ;
					w = j;
					// test coup vers le haut a gauche
					//while(k-1 < jeu.length && k-1 >=0 && w-1<jeu.length && w-1 >=0 && jeu[k-1][w-1] != couleurJoueur ) {
					while(k < jeu.length && k >=0 && w<jeu.length && w >=0 ) {
					// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][w] == TypeCase.vide )|| (prise && jeu[k][w] == TypeCase.jouable)) {
							p = new PointPerso(k,w);
							if(jeu[k][w] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][w] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k <= i){
								tmp[k][w] = couleurJoueur;
								k++;
								w++;
							}
							successeur(tmp,p);
							break;

						}
						if (jeu[k][w] == TypeCase.vide){
							break;
						}
						if (jeu[k][w] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][w] == TypeCase.jouable && !prise ){
							break;
						}
						k--;
						w--;
					}
					prise = false ;
					k = i ;
					w = j;
					// test coup vers le haut a droite
					//while(k-1 <jeu.length && k-1 >=0 && w+1 >=0 && w+1 < jeu.length && jeu[k-1][w+1] != couleurJoueur ) {
					while(k <jeu.length && k >=0 && w >=0 && w < jeu.length) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][w] == TypeCase.vide ) || ( prise && jeu[k][w] == TypeCase.jouable)) {
							p = new PointPerso(k,w);
							if(jeu[k][w] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][w] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k <= i){
								tmp[k][w] = couleurJoueur;
								k++;
								w--;
							}
							successeur(tmp,p);
							break;
						}
						if (jeu[k][w] == TypeCase.vide){
							break;
						}
						if (jeu[k][w] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][w] == TypeCase.jouable && !prise ){
							break;
						}
						k--;
						w++;
					}
					prise = false ;
					k = i ;
					w = j;
					// test coup vers le bas  a gauche
					//while(k+1 >0 && k+1 < jeu.length && w-1 <jeu.length && w-1 >=0 && jeu[k+1][w-1] != couleurJoueur ) {
					while(k >=0 && k < jeu.length && w <jeu.length && w >=0) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][w] == TypeCase.vide ) || ( prise && jeu[k][w] == TypeCase.jouable)) {
							p = new PointPerso(k,w);
							if(jeu[k][w] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][w] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k >= i){
								tmp[k][w] = couleurJoueur;
								k--;
								w++;
							}
							successeur(tmp,p);
							break;
						}
						if (jeu[k][w] == TypeCase.vide){
							break;
						}
						if (jeu[k][w] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][w] == TypeCase.jouable && !prise ){
							break;
						}
						k++;
						w--;
					}
					prise = false ;
					k = i ;
					w = j;
					// test coup vers le bas  a droite
					//while(k+1 >0 && k+1 < jeu.length && w+1>0 && w+1 < jeu.length && jeu[k+1][w+1] != couleurJoueur ) {
					while(k >=0 && k < jeu.length && w>=0 && w < jeu.length ) {
						// si on trouve un pion ennemi on peut peut etre jouer pour le prendre
						if(jeu[k][w] == couleurEnnemi) {
							prise = true ;
						}
						// si on a sauté un pion ennemi et qu'il y a une case vide derrière
						if((prise && jeu[k][w] == TypeCase.vide ) || ( prise && jeu[k][w] == TypeCase.jouable)) {
							p = new PointPerso(k,w);
							if(jeu[k][w] == TypeCase.vide){
								tmp = cloneJeu(jeuInitial);
								jeu[k][w] = TypeCase.jouable;
							}else{
								tmp = successeur.get(p).getJeu();
							}
							while ( k >= i){
								tmp[k][w] = couleurJoueur;
								k--;
								w--;
							}
							successeur(tmp,p);
							break;
						}
						if (jeu[k][w] == TypeCase.vide ){
							break;
						}
						if (jeu[k][w] == couleurJoueur && prise ){
							break;
						}
						if (jeu[k][w] == TypeCase.jouable && !prise ){
							break;
						}
						k++;
						w++;
					}
					prise = false ;
				}
			}
		}
		
	}

	@Override
	public void lireEtat() {

	}


	@Override
	public void ecrireEtat() {

	}

	public TypeCase[][] getJeu() {
		return jeu;
	}

	public void setJeu(TypeCase[][] jeu) {
		this.jeu = jeu;
	}
	
	public TypeCase[][] cloneJeu( TypeCase [][] jeu){
		TypeCase[][] nouvJeu = new TypeCase[jeu.length][jeu[1].length];
		for(int i = 0 ; i < jeu.length ; i++) {
			for(int j = 0 ; j < jeu[1].length; j++) {
				nouvJeu[i][j] = jeu[i][j];
			}
		}
		return nouvJeu;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtatReversi other = (EtatReversi) obj;
		if (!Arrays.deepEquals(jeu, other.jeu))
			return false;
		if (joueurAdv == null) {
			if (other.joueurAdv != null)
				return false;
		} else if (!joueurAdv.equals(other.joueurAdv))
			return false;
		if (joueurCourant == null) {
			if (other.joueurCourant != null)
				return false;
		} else if (!joueurCourant.equals(other.joueurCourant))
			return false;
		return true;
	}

	public HashMap<PointPerso, EtatReversi> getSuccesseur() {
		return successeur;
	}

	public JoueurReversi getJoueurCourant() {
		return joueurCourant;
	}

	public void setJoueurCourant(JoueurReversi joueurCourant) {
		this.joueurCourant = joueurCourant;
		this.joueurAdv = joueurCourant == game.getJ1() ? game.getJ2() : game.getJ1();
	}

	public JoueurReversi getJoueurAdv() {
		return joueurAdv;
	}

	public void setJoueurAdv(JoueurReversi joueurAdv) {
		this.joueurAdv = joueurAdv;
	}
	
	public void echangerJoueur() {
		Joueur tmp = this.joueurAdv;
		this.joueurAdv = this.joueurCourant;
		this.joueurCourant = (JoueurReversi) tmp;
	}

}
