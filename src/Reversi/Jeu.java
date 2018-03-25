package Reversi;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;

import graphique.TypeCase;

/**
 * 
 * Class jeu
 * contient un tableau de String qui correspond au plateau de jeu
 * contient des joueurs 
 */
public class Jeu extends Observable {
	private TypeCase[][] jeuInit;
	private JoueurReversi j1 = new JoueurReversi(Color.BLACK);
	private JoueurReversi j2 =  new JoueurReversi(Color.WHITE);
	
	private JoueurReversi courant;
	
	private int taillePlateau;
	
	private EtatReversi etat;
	public boolean firstLaunch = true;
	
	
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
		courant = j1;
		
		etat = new EtatReversi(this);
		
		etat.caseJouable();
		
		if(this.j1.isMachine()) {
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

		if(this.getCourant().isMachine()) {
			
		}
		
		this.courant = this.courant == j1 ? j2 : j1 ;

		HashMap<PointPerso, EtatReversi> test = etat.getSuccesseur();

		this.setEtat(test.get(new PointPerso(x,y)));

		etat.caseJouable();
		if(isBloque()) {
			System.out.println("Joueur " + this.courant.getTc() + " bloque");
			this.courant = this.courant == j1 ? j2 : j1 ;
			EtatReversi res = new EtatReversi(this);

			this.setEtat(res);
			etat.caseJouable();
			
			setChanged();
			notifyObservers();

			if (isBloque()){
				System.out.println("Joueur " + this.courant.getTc() + " bloque");
				System.out.println("Fin de la partie");
			}

		}
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Algorithme minimax qui va chercher quel est l'état le plus probable de faire gagner
	 * Utilise la fonction éval donc -> eval0 définie, cette méthode à un grand impact sur la chance de gagner
	 * @param dep
	 * @param prof
	 * @return
	 */
	public EtatReversi minimax(EtatReversi dep,int prof) {
		// Variables
		ArrayList<EtatReversi> etats = new ArrayList<>();
		int score_max =  Integer.MIN_VALUE;
		int score = 0 ;
		EtatReversi etat_sortie;
		
		for (EtatReversi e : dep.getSuccesseur().values()) {
			etats.add(e);
		}

		etat_sortie = this.etat;
		
		for(EtatReversi etat : etats) {
			score = eval(prof, dep);
			if(score >= score_max) {
				etat_sortie = dep;
				score_max = score;
			}
		}
		return etat_sortie;
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
		
		// si current est final -> pas de successeur ?
		// return -infini si perdu, +infini gagné, 0 match nul
		// fsi
		
		if(prof == 0) {
			return eval0(etat);
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
				score_min = Integer.min(score_max,eval(prof-1,e));
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
				if(this.getJeu()[i][j] == e.getJoueurCourant().getTc()) {
					p1++;
				}
			}
		}
		return p1;
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
		return courant;
	}

	public void setCourant(JoueurReversi courant) {
		this.courant = courant;
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
		this.setJeu(e.getJeu());
		this.etat = e;
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
