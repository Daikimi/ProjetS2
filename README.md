# ProjetS2 - Treasure Hunt

## Premier Jalon 21 Mars 18h


###A faire:
Création d'une île "vierge" (composée de parcelles vides, sans "élément").
→ classe élémentaire représentant une "parcelle" d'une île. 
Faire en sorte qu'une parcelle puisse afficher un unique "élément" (navire, rocher, ...). 
→ classe Ile encapsulant un tableau ([][]) de parcelles.
Tableau (carré de taille 10 par défaut) ou bien de taille fournie à la construction, 
méthode toString() pour affichage dans un main().

Affichage en mode texte de l'île vierge.

Placement des 2 navires (vides, à des emplacements fixés a priori).

Placement d'un rocher "recouvrant" le coffre à trésor (emplacement aléatoire ou fixé a priori).

Placement d'un rocher "recouvrant" la clef du coffre (idem,
emplacement distinct de celui du coffre).

Affichage en mode texte de l'île avec ces éléments.

Placement aléatoire de 10% (% du nombre de parcelles de l'île) de rochers ne recouvrant pas d' élément.

Affichage en mode texte de l'île avec ces nouveaux éléments.
Exemple de représentation de l'île 10 x10, et sa légende, intégrant tous les éléments du jeu version N°1 :
Les personnages de l'équipe N°1 sont représentés par des minuscules suivies de numéro d'ordre du personnage 
(dans l'équipe, sans tenir compte du type de personnage):

e pour un explorateur

v pour un voleur

n pour le navire
Les personnages de l'équipe N°2 sont représentés par des Majuscules suivies de numéro d'ordre du personnage 
(dans l'équipe, sans tenir compte du type de personnage): 

E pour un explorateur

V pour un voleur 

N pour le navire
Les autres éléments sont en majuscules

R pour un rocher

C pour le coffre 
(visible uniquement par la ou les équipes ayant découvert le coffre)
