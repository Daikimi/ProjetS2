import java.util.Random;
import javax.swing.JOptionPane;



/**
	 * La classe Island génere et gère la carte de l'île
	 * sur laquelle seront placées les diffèrents navires et personnages
	 * elle permet aussi l'affichage et la modification d'une case
	 * 
	 * @author Team-F5
	 */
public class Island {
	
	/**
	 * Attributs où est enregistrées la taille verticale de l'île
	 * par défaut l'île 10
	 * mais est modulable lors de la construction
	 * 
	 */
	private int xIle = 10; // A modifier si l'on veut
	/**
	 * Attributs où sont enregistrées la taille horizontale de l'île
	 * par défaut l'île est de taille 10
	 * mais est modulable lors de la construction
	 */
	
	private int yIle = 10; // A modifier si l'on veut
	
	//public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Perimetre = Interieur du carre (l'exterieur sera de l'eau)
	/**
	 * nombre de rocher sur l'île
	 * est pour l'instant mis à 10 % de la taille de l'île
	 * 
	 */
	private int nbRochers;
	/**
	 * Gère les différentes cases de l'île
	 * avec des cases de valeurs diffèrentes représentant les différents objet du jeu
	 *   
	 */
	
	public Parcelle[][] ileTemp;
	
	/**
	 * Plateau graphique permettant l'affichage du jeu.
	 */
	public Plateau plateau;
	
	/**
	 * attribut qui permet de créer le plateau (des cases vides ont étés ajoutées pour
	 * permettre une lecture plus facile de la grille.
	 */
	
	public Parcelle[][] ile;
	
	/**
	 * attribut nous permettant de placer aléatoirement des rocher sur la carte
	 * et de prévoir toute utilisation d'aléatoire dans le jeu(chances de réussir son attaque , de réussir une action, etc...)
	 * 
	 */
	Random random = new Random();
	
	
	/**
	 * Construit une île vierge et y place
	 * les différents objet qui seront dessus(eau , navires et aventuriers , rochers) 
	 */

	public Island(){
		creationIle();
		placementEau();
		placementNavires();
		placementRochers();	
	}
	
	public Island(int xIle, int yIle, int rochers, int exp1,  int vol1, int pi1, int gue1, int exp2, int vol2, int pi2, int gue2) {
		creationIle(xIle, yIle, rochers);
		placementEau();
		placementNavires(exp1, vol1, pi1, gue1, exp2, vol2, pi2, gue2);
		placementRochers();
	}
	/**
	 * Construit une ile en copiant une autre
	 * @param island Ile modèle
	 */
	
	public Island(Island island){
		ileTemp = new Parcelle[island.getXIle()][island.getYIle()];
		
		for (int i = 0; i < island.getXIle(); i++) {
   			for (int j = 0; j < island.getYIle(); j++){
   				this.ileTemp[i][j] = island.ileTemp[i][j];
   			}
   		}
	}
	/**
	 * 
	 * Méthode toString qui donne un affichage texte de l'île de l'île
	 * 
	 *@return l'affichage texte avec une coloration de ce dernier
	 */

	public String toString() {

		for (int i = 0; i < xIle; i++) {
			System.out.print("|");
			for (int j = 0; j < yIle; j++) {
				if (ileTemp[i][j].getValeur()==8) {
					System.out.print(" " + "\u001b[30m" + ileTemp[i][j].toString() + "\u001b[0m" + " |");
				} else if (ileTemp[i][j].getValeur() == 1) {
					System.out.print(" " + "\u001b[34m" + ileTemp[i][j].toString() + "\u001b[0m" + " |");
				} else if (ileTemp[i][j].getValeur() == 2) {
					System.out.print(" " + "\u001b[37m" + ileTemp[i][j].toString() + "\u001b[0m" + " |");
				} else if (ileTemp[i][j].getValeur() == 4 || ileTemp[i][j].getValeur() == 6) {
					System.out.print(" " + "\u001b[31m" + ileTemp[i][j].toString() + "\u001b[0m" + " |");
				} else {
					System.out.print(" " + "\u001b[36m" + ileTemp[i][j].toString() + "\u001b[0m" + " |");

				}

			}
			System.out.println("");
		}
		return "";
	}
	
	/**
	 * Méthode qui change la valeur d'une case de position [X,Y]
	 * pour une autre 
	 * 
	 * @param chose nouvelle valeur pour la case
	 * @param posX position X de la case voulue
	 * @param posY position Y de la case voulue
	 */
	public void changement(int chose,int posX,int posY) {	
		ileTemp[posX-1][posY-1].setValeur(chose);
	}
	
	/**
	 * Affiche la valeur de la case de position voulue
	 * 
	 * @param posX position X de la case sur l'île
	 * @param posY position Y de la case sur l'île
	 * @return valeur de la case désirée
	 */
	public int getValeur(int posX, int posY) {
		return ile[posX][posY].getValeur();
	}
	
	/**
	 * Méthode obsolète
	 * 
	 * @param posX position X de la case sur l'île
	 * @param posY position Y de la case sur l'île
	 * @return valeur de la case désirée
	 */
	public String affichage(int posX,int posY) {
		return ileTemp[posX][posY].toString(); 
	}
	
	/**
	 * Affichage graphique de l'île grâce à la
	 * classe Plateau modifiée afin de pouvoir faire des îles personnalisable 
	 * 
	 */
	
	public void affichageGraphique(){
		
		String[] gifs = {
				"lib/mer.png",               // 1
				"lib/rocher.png",            // 2
				"lib/coffre.png",            // 3
				"lib/1.navire.png",          // 4
				"lib/1.explorateur.png",     // 5
				"lib/2.navire.png",          // 6
				"lib/2.explorateur.png",     // 7
				"lib/sable.png",             // 8
				"lib/cle.png",               // 9
				"lib/1.voleur.png",          // 10
				"lib/2.voleur.png",          // 11
				"lib/1.piegeur.png",         // 12
				"lib/2.piegeur.png",         // 13
				"lib/1.guerrier.png",        // 14
				"lib/2.guerrier.png",        // 15
				"lib/piege.png"              // 16
				};

		ile = new Parcelle[xIle+1][yIle+1];
		for (int i = 0; i<xIle+1; i++) {
			for (int j = 0; j<yIle+1; j++) {
				if (i == 0 || j == 0) {
					ile[i][j] = new Parcelle(0);
				} else {
					ile[i][j] = new Parcelle(ileTemp[i-1][j-1].getValeur());
				}
			}
		}
		int[][] carte = new int[yIle+1][xIle+1];
		for(int i =0; i<xIle+1; i++) {
			for(int j =0; j<yIle+1 ; j++) {
				if(ile[i][j].getValeur() == 1) {
					carte[j][i]=1;
				} else if(ile[i][j].getValeur() == 2) {
					carte[j][i]=2;
				} else if(ile[i][j].getValeur()==3){
					carte[j][i]=3;
				}else if(ile[i][j].getValeur() ==4 ) {
					carte[j][i]=4;
				} else if (ile[i][j].getValeur() == 5) {
					carte[j][i]=5;
				} else if (ile[i][j].getValeur() == 6) { 
					carte[j][i]=6;
				} else if (ile[i][j].getValeur()== 7) {
					carte[j][i]=7;
				}else if (ile[i][j].getValeur() == 8){
					carte[j][i]=8;
				} else if (ile[i][j].getValeur() == 9){
					carte[j][i]=9;
				}else if (ile[i][j].getValeur() == 10){
					carte[j][i]=10;
				}else if (ile[i][j].getValeur() == 11){
					carte[j][i]=11;
				}else if (ile[i][j].getValeur() == 12){
					carte[j][i]=12;
				} else if (ile[i][j].getValeur() == 13){
					carte[j][i]=13;
				}   else if (ile[i][j].getValeur() == 14){
					carte[j][i]=14;
				}   else if (ile[i][j].getValeur() == 15){
					carte[j][i]=15;
				}  else{
					carte[j][i]=0;
				}
			}
		}

		plateau = new Plateau(gifs, 1, true);
		plateau.setJeu(carte);
		
		for (int i = 1 ; i < xIle+1 ; i++) {
			plateau.setText(i, 0, String.valueOf(i)) ;
		}
		for (int j = 1 ; j < yIle+1 ; j++) {
			String msg = "" ;
			int y = j-1 ;
			if (y < 26) {
				msg += (char) (y + 65) ; // Convert 0 to A
			} else {
				msg += (char) ((y/26) + 65) ;  // Convert to AA..ZZ
				msg += (char) ((y%26) + 65) ;
			}
			plateau.setText(0, j, msg) ;
		}
	
		plateau.affichage();
		
	    }
	
	/**
	 * Méthode permettant une demande à l'utilisateur de la taille voulue pour l'île
	 */
	
	private void creationIle(int x, int y, int r) {
		xIle = x;
		yIle = y;
		ileTemp = new Parcelle[xIle][yIle];
		nbRochers = r;
	}
	
	private void creationIle() {
		String regex = "[0-9]+";
		String rep1 = "";
		String rep2 = "";
		String nbroc="";
		do {
			rep1 = JOptionPane.showInputDialog(null, "Choisissez la taille x de l'île",10);
		 	rep2 = JOptionPane.showInputDialog(null, "Choisissez la taille y de l'île",10);
		 	nbroc = JOptionPane.showInputDialog(null, "Choisissez le pourcentage de rocher de l'île :",10);
		} while (!rep1.matches(regex) && !rep2.matches(regex)&& !nbroc.matches(regex));

		xIle = Integer.parseInt(rep1);
		yIle = Integer.parseInt(rep2);
		ileTemp = new Parcelle[xIle][yIle];
		nbRochers = Integer.parseInt(nbroc);
	}
	
	/**
	 * Méthode remplaçant les bords de l'île par la valeur de l'eau
	 */
	
	private void placementEau() {
		for(int i=0;i<ileTemp.length;i++){
			for(int j=0;j<ileTemp[0].length;j++){
				if (i == 0 || i == xIle-1 || j == 0 || j == yIle-1) {
					ileTemp[i][j]=new Parcelle(1);
				} else {
					ileTemp[i][j]=new Parcelle(8);
				}
			}
		}
	}
	
	/**
	 * Place les navires sur l'île
	 * chacun sur un côté de l'île
	 * puis placement de 5 aventuriers autour du navire
	 */

	private void placementNavires() {
		int b1 = 1+ random.nextInt(xIle-2);
		int b2 = 1+ random.nextInt(xIle-2);
		ileTemp[b1][1].setValeur(4);
		ileTemp [b2][yIle-2].setValeur(6);
	}
	
	private void placementNavires(int e1, int v1, int p1, int g1, int e2, int v2, int p2, int g2) {
		int b1 = 1+ random.nextInt(xIle-2);
		int b2 = 1+ random.nextInt(xIle-2);
		ileTemp[b1][1].setValeur(4);
		ileTemp[b2][yIle-2].setValeur(6);
		
		for (int a = 0; a < e1; a++) {
			ile[b1][1].personnages.put("Explorateur "+(a+1), new Explorateur(b1, 1, 1));
		}
		for (int a = 0; a < v1; a++) {
			ile[b1][1].personnages.put("Voleur "+(a+1), new Voleur(b1, 1, 1));
		}
		for (int a = 0; a < p1; a++) {
			ile[b1][1].personnages.put("Piegeur "+(a+1), new Piegeur(b1, 1, 1));
		}
		for (int a = 0; a < g1; a++) {
			ile[b1][1].personnages.put("Guerrier "+(a+1), new Guerrier(b1, 1, 1));
		}
		
		for (int a = 0; a < e2; a++) {
			ile[b2][yIle-2].personnages.put("Explorateur "+(a+1), new Explorateur(b2, yIle-2, 2));
		}
		for (int a = 0; a < v2; a++) {
			ile[b2][yIle-2].personnages.put("Voleur "+(a+1), new Voleur(b2, yIle-2, 2));
		}
		for (int a = 0; a < p2; a++) {
			ile[b2][yIle-2].personnages.put("Piegeur "+(a+1), new Piegeur(b2, yIle-2, 2));
		}
		for (int a = 0; a < g2; a++) {
			ile[b2][yIle-2].personnages.put("Guerrier "+(a+1), new Guerrier(b2, yIle-2, 2));
		}
	}
	/**
	 * Place les rochers sur l'île en regardant si les rochers ne bloque pas la progression
	 * des aventuriers sur l'île 
	 */

	private void placementRochers() {
	int r = 0;
		while (r < nbRochers-2) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ileTemp[posX][posY].setValeur(2) ;
				r = r + 1;
			}
		}		
		while (r < nbRochers-1) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ileTemp[posX][posY].setValeur(2);
				r = r + 1;
			}
		}
		while (r < nbRochers) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ileTemp[posX][posY].setValeur(2);
				r = r + 1;
			}
		}
	}
	/**
	 *  Regarde si l'on peut placer un rochers à la position donnée
	 *  en regardant les cases alentours pour éviter de bloquers le passage
	 *  et retourne true si la casse ne dérange pas sinon false
	 * @param posX : position X de la case voulue sur l'île
	 * @param posY : position Y de la case voulue sur l'île
	 * @return la non-génance de passage de la case
	 */
	private boolean verificationPlacementRochers(int posX, int posY) {
		if (ileTemp[posX][posY].getValeur() == 8) {
			if (ileTemp[posX-1][posY-1].getValeur() != 2 && ileTemp[posX-1][posY].getValeur() != 2 && ileTemp[posX-1][posY+1].getValeur() != 2 && ileTemp[posX][posY-1].getValeur() != 2  && ileTemp[posX][posY+1].getValeur() != 2  && ileTemp[posX+1][posY-1].getValeur() != 2  && ileTemp[posX+1][posY].getValeur() != 2  && ileTemp[posX+1][posY+1].getValeur() != 2) {
				if (ileTemp[posX-1][posY-1].getValeur() != 4 && ileTemp[posX-1][posY].getValeur() != 4 && ileTemp[posX-1][posY+1].getValeur() != 4  && ileTemp[posX][posY-1].getValeur() != 4  && ileTemp[posX][posY+1].getValeur() != 4 && ileTemp[posX+1][posY-1].getValeur() != 4 && ileTemp[posX+1][posY].getValeur() != 4  && ileTemp[posX+1][posY+1].getValeur() != 4) {
					if (ileTemp[posX-1][posY-1].getValeur() != 6 && ileTemp[posX-1][posY].getValeur() != 6 && ileTemp[posX-1][posY+1].getValeur() != 6  && ileTemp[posX][posY-1].getValeur() != 6 && ileTemp[posX][posY+1].getValeur() != 6  && ileTemp[posX+1][posY-1].getValeur() != 6  && ileTemp[posX+1][posY].getValeur() != 6  && ileTemp[posX+1][posY+1].getValeur() != 6) {
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Méthode permettant d'obtenir la valeur de xIle.
	 * @return Valeur xIle
	 */
	public int getXIle(){
		return xIle;
	}
	
	/**
	 * Méthode permettant d'obtenir la valeur de yIle.
	 * @return Valeur yIle
	 */
	public int getYIle() {
		return yIle;
	}

}


