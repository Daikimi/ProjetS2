# ProjetS2 - Treasure Hunt

###Lug réparera le code auparavant, pour permettre un meilleur développement du projet.

###Jalon 2 : éléments contrôlés par menu (xxxTableau + JOptionPane) => Nicolas (n'hésites pas à demander si tu as besoin d'aide)

#### L'objectif est de pouvoir tester les différents éléments du jeu via un menu (sans être dans une partie)
    - On doit pouvoir placer les personnages sur la grille à des places précises (spécifiées via un menu),
    et leur faire réaliser les différentes actions possibles.


#### Première étape du Jalon2: => Toinou parce que de toute façon il va demander à Lug
    - Ajouter l'explorateur
    - Saisir  la cible /direction de l'action (explorateur => déplacement)
    - Respect des règles du jeu, selon votre choix
        soit ne proposer que les actions valides,
        soit vérifier que l'action choisie est valide.


    - Contrôle du déplacement pour les explorateurs, selon la parcelle d'arrivée :
        explorateur <=> 4 directions
        parcelle
            vide (terrain clair) : déplacement
            mer : impossible
            personnage : impossible
            navire ami : remontée à bord
                remarque pour la suite :
                    uniquement s'il reste au moins un personnage de l'équipe sur l'île
                    le repos (récupération d'énergie) sera traité plus tard
            navire ennemi : impossible
            rocher : soulever reposer
                rien en dessous : continuer quête
                clef : prendre clef
                coffre :
                    si clef transportée : prendre trésor
                    sinon mémoriser emplacement coffre


#### Deuxième étape du Jalon2: (Ceci n'est pas impératif, selon un message sur le forum de JM Place, voilà pourquoi c'est Lug qui s'en occupera)
  - Ajouter le voleur et ses actions (attention déplacement dans les huit directions)
