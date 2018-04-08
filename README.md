# README #

### What is this repository for? ###

Jeu de Reversi pour le projet de representation de connaisances

### How do I get set up? ###

* Deployment instructions
Lancez le projet et ... 

* Writing tests
* Code review
* Other guidelines

### Github link ###

https://github.com/kaysou/L3_reversi

### Contribution guidelines ###
Séance 1 :
	Yoan FATH et Jonathan SCHMITT
	- Mise en place du projet
	- Initialisation du depôt github
	- Mise en place du jeu et affichage
	
Travail préparatoire:
	Yoan FATH
	- mise en place d'une interface graphique pour jouer plus facilement
	- début implémentation algorithme pour savoir les coups possibles
	- refactor du tableau initial en tableau d'objet (maintient plus facile)
	
	
Séance 2 :
	Yoan FATH
	- Méthode équals pour les etats reversis
	- Coups jouables pour un joueur donné
	- Interface graphique MVC 
	Jonathan SCHMITT
	- Début méthode successeurs
	- Début lien entre case et EtatReversi si joué

Séance 3:
	Yoan FATH
	- Interface graphique MVC sans images -> plus simple à visualiser
	- Difference entre joueur et machine
	- première éval0, éval et minimax 
	Jonathan SCHMITT
	- Mise à jour cases jouables + changement joueur à chaque pion posé
	- ajout successeur en diagonale
	- correction successeurs et case à changer de couleur lors de coup joué
	
Séance 4:
	Yoan FATH
	- implémentation méthodes eval0
	Jonathan SCHMITT
	- IA contre IA et IA contre joueur fonctionnel
	
Sans elagage :
	-minimax met 1658 maximum ms en profondeur 3
Avec elagage :
	-minimax avec elagage met 1337 ms maximum pour la profondeur 3
	
	
Difficultés rencontrés :
	- principalement la recherche de fonction eval0 pertinentes.
	- l'implémentation de l'interface graphique et les coups "bloquant" : quand un joueur n'avait plus d'alternative.
	- la fonction minimax qui devait bien prendre en compte le bon joueur pour retourner un choix qui favorise le joueur courant : cette difficulté vient de notre choix d'implémentation.

Avec du temps supplémentaire :
	- Nous aurions pu essayer de faire du machine learning : que l'IA sache quand elle a gagné et comment pour pouvoir évaluer avec plus de précisions son taux de victoire sur un état.
	
Configuration :
	- Un état est representé par un tableau a double dimension de TypeCase qui sont les différents types de case possibles (blanc noir vide et jouable).
	- Nous avons une interface graphique qui montre l'état du jeu grace a ce tableau de TypeCase et qui se rafraichit à chaque action.
	- Un Etat connais ses successeurs et les stockes dans un tableau de point personnalisé, point qui correspond a l'emplacement de la case, ainsi chaque case jouable sait l'état qui sera engendré.
	
Execution :
	- L'interface graphique est configuré pour jouer avec joueur noir IA et joueur blanc un joueur.