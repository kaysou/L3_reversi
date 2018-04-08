package Reversi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import graphique.TypeCase;

/**
 * Class jeu
 * contient un tableau de String qui correspond au plateau de jeu
 * contient des joueurs 
 */
public class Jeu extends Observable {
	private TypeCase[][] jeuInit;
	private JoueurReversi j1 = new JoueurReversi(Color.BLACK);
	private JoueurReversi j2 =  new JoueurReversi(Color.WHITE);

	private int taillePlateau;

	private EtatReversi etat;
	public boolean firstLaunch = true;
	public boolean partieFini = false;

	/**
	 * Constructeur de jeu qui remplit le plateau a vide sauf les 4 pions de départ
	 * @param taille, taille du plateau a générer 
	 */
	public Jeu(int taille) {
		this.jeuInit = new TypeCase[taille][taille] ;
		this.taillePlateau = taille ;

		for(int i = 0 ; i < taille ; i++) {
			for(int j = 0 ; j < taille ; j++) {
				jeuInit[i][j] = TypeCase.vide ;
			}
		}
		// dessiner les 4 pions de base
		// pions blanc
		this.jeuInit[taille/2][taille/2] = TypeCase.blanche ;
		this.jeuInit[(taille/2-1)][(taille/2)-1] = TypeCase.blanche ;
		// pions noir
		this.jeuInit[taille/2][(taille/2)-1] = TypeCase.noir ;
		this.jeuInit[(taille/2)-1][taille/2] = TypeCase.noir ;

		// les jetons blancs commencent
		j1.setMachine(true);
		//j2.setMachine(true);
		etat = new Reversi.EtatReversi(this);
		etat.setJoueurCourant(j1);
		etat.setJoueurAdv(j2);
		etat.caseJouable();

		setChanged();
		notifyObservers();
		if(this.getCourant().isMachine()) {
			jouer(-1,-1);
		}
		firstLaunch = false;
	}

	/**
	 * Methode d'affichage du jeu
	 */
	public String afficherPlateau(TypeCase[][] game) {
		String plateau = "";

		for(TypeCase[] s1 : game) {
			for(TypeCase s2 : s1) {
				plateau += s2 + " ";
			}
			plateau += "\n" ; 
		}
		return "plateau du jeu [ \n" + plateau + " ]";
	}


	public void jouer(int x, int y) {
		if(this.getCourant().isMachine() || (x == -1 && y == -1)) {


			//EtatReversi tmp = minimaxElagage(this.etat,4, Integer.MIN_VALUE, Integer.MAX_VALUE);
			EtatReversi tmp = minimax(this.etat,4);
			this.setCourant(this.getCourant() == j1 ? j2 : j1 );

			this.setEtat(tmp);
			etat.caseJouable();

		}else {

			this.setCourant(this.getCourant() == j1 ? j2 : j1 );

			HashMap<PointPerso, EtatReversi> test = etat.getSuccesseur();

			this.setEtat(test.get(new PointPerso(x,y)));
			etat.caseJouable();

		}

		setChanged();
		notifyObservers();

		if(isBloque()) {
			if(isFinal()) {
				System.out.println("Joueur couleur " + this.getCourant().getTc() + " bloque");
				System.out.println("Fin de la partie");
			}
		}

		setChanged();
		notifyObservers();
		if (!partieFini) {
			if (etat.getJoueurCourant().isMachine()) {
				jouer(-1, -1);
			}
		}
	}

	public boolean isFinal() {

		this.setCourant(this.getCourant() == j1 ? j2 : j1) ;
		EtatReversi res = new EtatReversi(this);
		res.setJoueurCourant(this.getCourant());
		res.setJoueurAdv(this.getCourant() == j1 ? j2 : j1 );
		System.out.println("courant : "  + res.getJoueurCourant().getTc() + " ______ " + res.getJoueurAdv().getTc() );
		this.setEtat(res);

		res.caseJouable();

		setChanged();
		notifyObservers();

		if (isBloque()){
			System.out.println("la partie est fini enculé");
			partieFini = true;
			int i = evalutationFinPartie(res);
			if(i==0) {
				System.out.println("Egalité");
			}
			if(i > 1) {
				System.out.println(this.getCourant().getCouleurJoueur() + " à gagné !");
			}
			if(i < -1) {
				System.out.println(this.getCourant().getCouleurJoueur() + " à perdu !");
			}
			return true;
		}

		return false;
	}
	/**
	 * Algorithme minimax qui va chercher quel est l'état le plus probable de faire gagner
	 * Utilise la fonction éval donc -> eval0 définie, cette méthode à un grand impact sur la chance de gagner
	 * @param dep
	 * @param prof
	 * @return
	 */
	public EtatReversi minimax(EtatReversi dep,int prof) {
		long startTime = System.nanoTime();
		// Variables
		ArrayList<EtatReversi> etats = new ArrayList<>();
		int score_max =  Integer.MIN_VALUE;
		int score = 0 ;
		EtatReversi etat_sortie;

		for (EtatReversi e : dep.getSuccesseur().values()) {
			if(dep.getJoueurCourant().getTc() != e.getJoueurCourant().getTc()) {

				etats.add(e);
			}
		}

		etat_sortie = this.etat;

		for(EtatReversi et : etats) {
			score = eval(prof, et);
				
			if(score >= score_max) {
				etat_sortie = et;
				score_max = score;
			}
		}
		long endTime = System.nanoTime();

		System.out.println((endTime - startTime) /1000 );  //microseconds
		return etat_sortie;
	}

	/**
	 * Algorithme minimax qui va chercher quel est l'état le plus probable de faire gagner avec elagage alpha beta
	 * Utilise la fonction éval donc -> eval0 définie, cette méthode à un grand impact sur la chance de gagner
	 * @param dep
	 * @param prof
	 * @return
	 */
	public EtatReversi minimaxElagage(EtatReversi dep,int prof, int alpha, int beta) {
		long startTime = System.nanoTime();
		// Variables
		ArrayList<EtatReversi> etats = new ArrayList<>();
		int score_max =  Integer.MIN_VALUE;
		int score = 0 ;
		EtatReversi etat_sortie;

		for (EtatReversi e : dep.getSuccesseur().values()) {
			if(dep.getJoueurCourant().getTc() != e.getJoueurCourant().getTc()) {

				etats.add(e);
			}
		}

		etat_sortie = this.etat;

		for(EtatReversi et : etats) {
			score = eval(prof, et);
				
			if(score >= score_max) {
				etat_sortie = et;
				score_max = score;
			}
		}
		long endTime = System.nanoTime();

		System.out.println((endTime - startTime) /1000 );  //microseconds
		return etat_sortie;
	}
	
	/**
	 * Méthode qui évalue la pertinence d'un état à une profondeur donnée avec l'elagage alpha beta
	 * @param prof, profondeur testée
	 * @param etat, état de départ
	 * @return
	 */
	public int evalElagage(int prof, EtatReversi etat, int alpha, int beta) {
		// variables
		ArrayList<EtatReversi> etats = new ArrayList<>();
		EtatReversi current;
		int score, score_min,score_max = 0 ;


		if(isBloque()) {
			if(isFinal()) {			
				return evalutationFinPartie(etat);
			}
		}

		if(prof == 0) {
			return eval0Upraged(etat);
		}

		if(etat.getJoueurCourant().isMachine()) {
			score_max = Integer.MIN_VALUE ;

			for(EtatReversi e : etats) {
				score_max = Integer.max(score_max,evalElagage(prof-1,e, alpha, beta));
				if(score_max >= beta ) {
					return score_max;
				}
				alpha = Integer.max(alpha,score_max);
			}
			return score_max;
		}else {
			score_min = Integer.MAX_VALUE;

			for(EtatReversi e : etats) {
				score_min = Integer.min(score_min,evalElagage(prof-1,e, alpha,beta));
				if(score_min <= alpha) {
					return score_min;
				}
				beta = Integer.min(beta, score_min);
			}
			return score_min;

		}		
	}

	
	/**
	 * Méthode qui évalue la pertinence d'un état à une profondeur donnée
	 * @param prof, profondeur testée
	 * @param etat, état de départ
	 * @return
	 */
	public int eval(int prof, EtatReversi etat) {
		// variables
		ArrayList<EtatReversi> etats = new ArrayList<>();
		EtatReversi current;
		int score, score_min,score_max = 0 ;


		if(isBloque()) {
			if(isFinal()) {			
				return evalutationFinPartie(etat);
			}
		}

		if(prof == 0) {
			return eval0Upraged(etat);
		}

		if(etat.getJoueurCourant().isMachine()) {
			score_max = Integer.MIN_VALUE ;

			for(EtatReversi e : etats) {
				score_max = Integer.max(score_max,eval(prof-1,e));
			}
			return score_max;
		}else {
			score_min = Integer.MAX_VALUE;

			for(EtatReversi e : etats) {
				score_min = Integer.min(score_min,eval(prof-1,e));
			}
			return score_min;

		}		
	}

	/**
	 * Premiere méthode eval0 qui compte juste le nombre de pions de la couleur du joueur qui joue
	 * @param e
	 * @return
	 */
	public int eval0(EtatReversi e) {
		int p1 = 0;
		for(int i = 0 ; i < e.getJeu().length ; i++) {
			for(int j = 0 ; j < e.getJeu().length ; j++) {
				if(this.getJeu()[i][j] == e.getJoueurAdv().getTc()) {
					p1++;
				}
			}
		}
		return p1;
	}
	
	/**
	 * Premiere méthode eval0 qui favorise les coups dans les coins et sur les cotés
	 * @param e
	 * @return
	 */
	public int eval0Upraged(EtatReversi e) {
		int p1 = 0;
		for(int i = 0 ; i < e.getJeu().length ; i++) {
			for(int j = 0 ; j < e.getJeu().length ; j++) {
				if(this.getJeu()[i][j] == e.getJoueurAdv().getTc()) {
					if(i == 0 || i == taillePlateau-1) {
						if(j == 0 || j == taillePlateau -1) {
							p1 += 50 ;
						}else {
							p1 += 5;
						}						
					}
					p1++;
				}
			}
		}
		return p1;
	}
	
	/**
	 * Premiere méthode eval0 qui ?
	 * @param e
	 * @return
	 */
	public int eval0Upragedv2(EtatReversi e) {
		int p1 = 0;
		for(int i = 0 ; i < e.getJeu().length ; i++) {
			for(int j = 0 ; j < e.getJeu().length ; j++) {
				/**if(this.getJeu()[i][j] == TypeCase.jouable) {
					
				}**/
			}
		}
		return p1;
	}

	public int evalutationFinPartie(EtatReversi e) {
		int p1 = 0;
		int p2 = 0;
		for(int i = 0 ; i < e.getJeu().length ; i++) {
			for(int j = 0 ; j < e.getJeu().length ; j++) {
				if(this.getJeu()[i][j] == e.getJoueurCourant().getTc()) {
					p1++;
				}else {
					if(this.getJeu()[i][j] == e.getJoueurAdv().getTc()) {
						p2++;
					}
				}
			}
		}
		if(p1==p2) {
			return 0;
		}
		if(p1>p2) {
			return Integer.MAX_VALUE;
		}else {
			return Integer.MIN_VALUE;
		}
	}
	// getter - setter 

	public TypeCase[][] getJeu() {
		return this.etat.getJeu();
	}

	public TypeCase[][] getJeuInit() {
		return this.jeuInit;
	}


	public void setJeu(TypeCase[][] jeu) {
		this.etat.setJeu(jeu);
		setChanged();
		notifyObservers();
	}


	public JoueurReversi getJ1() {
		return j1;
	}


	public void setJ1(JoueurReversi j1) {
		this.j1 = j1;
	}


	public JoueurReversi getJ2() {
		return j2;
	}


	public void setJ2(JoueurReversi j2) {
		this.j2 = j2;
	}


	public int getTaillePlateau() {
		return taillePlateau;
	}


	public JoueurReversi getCourant() {
		return this.etat.getJoueurCourant();
	}

	public void setCourant(JoueurReversi courant) {
		this.etat.setJoueurCourant(courant);
		setChanged();
		notifyObservers();
	}

	public void setTaillePlateau(int taillePlateau) {
		this.taillePlateau = taillePlateau;
	}

	public void setCase(int i, int j, TypeCase newType) {
		this.getJeu()[i][j] = newType;
		setChanged();
		notifyObservers();
	}

	public void enleverCaseJouable() {
		for(int i = 0 ; i < taillePlateau ; i++) {
			for(int j = 0 ; j < taillePlateau ; j++) {
				if(this.getJeu()[i][j] == TypeCase.jouable ) {
					this.getJeu()[i][j] = TypeCase.vide ;
				}
			}
		}
	}

	public void setEtat(EtatReversi e) {
		this.etat = e;
		this.setJeu(e.getJeu());

		setChanged();
		notifyObservers();
	}

	public boolean isBloque() {
		TypeCase[][] plat = this.getJeu();
		int cpt = 0;
		for(int i = 0 ; i < this.taillePlateau ; i++) {
			for(int j = 0 ; j < this.taillePlateau ; j++) {
				if(plat[i][j] == TypeCase.jouable) {
					cpt++;
				}
			}
		}
		return cpt==0;

	}
}
