import java.util.Random;
import javax.swing.JOptionPane;

/**
	 * La classe Island g�nere et g�re la carte de l'�le
	 * sur laquelle seront plac�es les diff�rents navires et personnages
	 * elle permet auusi l'affichage et la modification d'une case
	 * 
	 * @author Team-F5
	 */
public class Island {
	
	/**
	 * Attributs o� est enregistr�es la taille verticale de l�le
	 * par d�faut l'�le 10
	 * mais est modulable lors de la construction
	 * 
	 */
	public int xIle = 10; // A modifier si l'on veut
	/**
	 * Attributs o� sont enregistr�es la taille horizontale de l�le
	 * par d�faut l'�le est de taille 10
	 * mais est modulable lors de la construction
	 */
	
	public int yIle = 10; // A modifier si l'on veut
	
	//public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Perimetre = Interieur du carre (l'exterieur sera de l'eau)
	/**
	 * nombre de rocher sur l'�le
	 * est pour l'instant mis � 10 % de la taille de l'�le
	 * 
	 */
	public int nbRochers;
	/**
	 * G�re les diff�rentes cases de l'�le
	 * avec des cases de valeurs diff�rentes repr�sentant les diff�rentqs objet du jeu
	 *   
	 */
	
	public Parcelle[][] ile;
	
	/**
	 * attribut nous permettant de placer al�atoirement des rocher sur la carte
	 * et de pr�voir toutes utilisatoin d'al�at dans le jeu(chances de r�ussir son attaque , de r�ussir une action, etc...)
	 * 
	 */
	Random random = new Random();
	
	
	/**
	 * Construit une �le vierge et y place
	 * les diff�rents objet qui seront dessus(eau , navires et aventuriers , rochers) 
	 */

	public Island(){
		
		creationIle();
		
		placementEau();

		placementNavires();
		
		placementRochers();
		
	}
	/**
	 * 
	 * M�thode toString qui donne un affichage texte de l'�le de l'�le
	 * 
	 *@return l'affichage texte avec une coloration de ce dernier
	 */

	public String toString() {

		for (int i = 0; i < xIle; i++) {
			System.out.print("|");
			for (int j = 0; j < yIle; j++) {
				if (ile[i][j].emplacement == " 0") {
					System.out.print(" " + "\u001b[30m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].emplacement == "X0") {
					System.out.print(" " + "\u001b[34m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].emplacement == "R0") {
					System.out.print(" " + "\u001b[37m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].emplacement == "n0" || ile[i][j].emplacement == "N0") {
					System.out.print(" " + "\u001b[31m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else {
					System.out.print(" " + "\u001b[36m" + ile[i][j].toString() + "\u001b[0m" + " |");

				}

			}
			System.out.println("");
		}
		return "";
	}
	
	/**
	 * M�thode qui change la valeur d'une case de position [X,Y]
	 * pour une autre 
	 * 
	 * @param chose nouvelle valeur pour la case
	 * @param posX position X de la case voulue
	 * @param posY position Y de la case voulue
	 */
	public void changement(String chose,int posX,int posY) {	
		ile[posX][posY].changement(chose);
	}
	/**
	 * Affiche la valeur de la case de position voulue
	 * 
	 * @param posX position X de la case sur l'�le
	 * @param posY position Y de la case sur l'�le
	 * @return valeur de la case d�sir�e
	 */
	
	public String affichage(int posX,int posY) {
		return ile[posX][posY].toString(); 
	}
	
	/**
	 * Affichage graphique de l'�le gr�ce � la
	 * classe Plateau mdifi� afin de pouvoir faire des �le personnalisable 
	 * 
	 */
	
	public void affichageGraphique(){
		
		String[] gifs = {"lib/mer.png" , "lib/rocher.png" , "lib/coffre.png" , "lib/1.navire.png" , "lib/1.explorateur.png", "lib/2.navire.png" , "lib/2.explorateur.png", "lib/sable.png"};
		int[][] carte = new int[yIle][xIle];
		for(int i =0; i<xIle; i++) {
		    for(int j =0; j<yIle ; j++) {
			if(ile[i][j].emplacement == "X0") {
			    carte[j][i]=1;
			}
			else if(ile[i][j].emplacement == "R0") {
			    carte[j][i]=2;
			}
			else if(ile[i][j].emplacement == "n0") {
			    carte[j][i]=4;
			}
			else if (ile[i][j].emplacement.charAt(0) == 'e') {
			    carte[j][i]=5;
			} else if (ile[i][j].emplacement == "N0") { 
				carte[j][i]=6;
			} else if (ile[i][j].emplacement.charAt(0) == 'E') {
			    carte[j][i]=7;
		    } else {
		    	carte[j][i]=8;
		    }
		}
		
		Plateau plateau = new Plateau(gifs, 1);
		plateau.setJeu(carte);
		plateau.affichage();

		}
		
	    }
	
	/**
	 * M�thode permettant une demande � l'utilisateur de la taille voulue pour l'�le
	 *  
	 */
	
	private void creationIle() {
		String regex = "[0-9]+";
		String rep1 = "";
		String rep2 = "";
		do {
			rep1 = JOptionPane.showInputDialog(null, "Choississez la taille x de l'île");
		 	rep2 = JOptionPane.showInputDialog(null, "Choississez la taille y de l'île");
		} while (!rep1.matches(regex) && !rep2.matches(regex));

		xIle = Integer.parseInt(rep1);
		yIle = Integer.parseInt(rep2);
		ile = new Parcelle[xIle][yIle];
		nbRochers = (xIle*yIle)/10;
	}
	
	/**
	 * M�thode rempla�ant les bords de l'�le par la valeur de l'eau
	 * 
	 */
	
	private void placementEau() {
		for(int i=0;i<ile.length;i++){
			for(int j=0;j<ile[0].length;j++){
				if (i == 0 || i == xIle-1 || j == 0 || j == yIle-1) {
					ile[i][j]=new Parcelle("X0");
					ile[i][j].eau = true;
				} else {
					ile[i][j]=new Parcelle(" 0");
				}
			}
		}
	}
	
	/**
	 * Place les navires sur l'�le
	 * chacun sur un c�t� de l'�le
	 * puis placement de 5 aventuriers autour du navire
	 *  
	 */

	private void placementNavires() {
		int b1 = 1+ random.nextInt(xIle-2);
		int b2 = 1+ random.nextInt(xIle-2);
		
		ile[b1][1].emplacement = "n0";
		ile[b1][1].navire1 = true;
		ile [b2][yIle-2].emplacement = "N0";
		ile [b2][yIle-2].navire2 = true;

		int increment = 1;


	if (ile[b1-1][1].emplacement == " 0") {
		ile[b1-1][1].emplacement = "e" + increment ;
		increment++;
	}

	if (ile[b1+1][1].emplacement == " 0") {
		ile[b1+1][1].emplacement = "e" + increment ;
		increment++;
	}

	if (ile[b1][2].emplacement == " 0") {
		ile[b1][2].emplacement = "e" + increment ;
		increment++;
	}

	if (ile[b1-1][2].emplacement == " 0") {
		ile[b1-1][2].emplacement = "e" + increment ;
		increment++;
	}

	if (ile[b1+1][2].emplacement == " 0") {
		ile[b1+1][2].emplacement = "e" + increment ;
		increment++;
	}
	increment = 1;
	if (ile[b2-1][yIle-2].emplacement == " 0") {
		ile[b2-1][yIle-2].emplacement = "E" + increment ;
		increment++;
	}
	if (ile[b2+1][yIle-2].emplacement == " 0") {
		ile[b2+1][yIle-2].emplacement = "E" + increment ;
		increment++;
	}
	if (ile[b2-1][yIle-3].emplacement == " 0") {
		ile[b2-1][yIle-3].emplacement = "E" + increment ;
		increment++;
	}
	if (ile[b2+1][yIle-3].emplacement == " 0") {
		ile[b2+1][yIle-3].emplacement = "E" + increment ;
		increment++;
	}
	if (ile[b2][yIle-3].emplacement == " 0") {
		ile[b2][yIle-3].emplacement = "E" + increment ;
		increment++;
	}


}
	/**
	 * Place les rochers sur l'�le en regardant si les rochers ne bloque pas la progression
	 * des aventuriers sur l'�le 
	 * 
	 */

	private void placementRochers() {
	int r = 0;
		while (r < nbRochers-2) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].emplacement = "R0";
				ile[posX][posY].rocher = true;
				r = r + 1;
			}
		}		
		while (r < nbRochers-1) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].emplacement = "R0";
				ile[posX][posY].rocher = true;
				ile[posX][posY].coffre = true;
				r = r + 1;
			}
		}
		while (r < nbRochers) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].emplacement = "R0";
				ile[posX][posY].rocher = true;
				ile[posX][posY].cle = true;
				r = r + 1;
			}
		}
	}
	/**
	 *  Regarde si l'on peut placer un rochers � la position donn�e
	 *  en regardant les cases alentours pour �viter de bloquers le passage
	 *  et retourne true si la casse ne d�range pas sinon false
	 * @param posX : position X de la case voulue sur l'�le
	 * @param posY : position Y de la case voulue sur l'�le
	 * @return la non-g�nance de passage de la case
	 */
	private boolean verificationPlacementRochers(int posX, int posY) {
		if (ile[posX][posY].emplacement == " 0") {
			if (ile[posX-1][posY-1].emplacement != "R0" && ile[posX-1][posY].emplacement != "R0"  && ile[posX-1][posY+1].emplacement != "R0"  && ile[posX][posY-1].emplacement != "R0"  && ile[posX][posY+1].emplacement != "R0"  && ile[posX+1][posY-1].emplacement != "R0"  && ile[posX+1][posY].emplacement != "R0"  && ile[posX+1][posY+1].emplacement != "R0") {
				if (ile[posX-1][posY-1].emplacement != "n0" && ile[posX-1][posY].emplacement != "n0"  && ile[posX-1][posY+1].emplacement != "n0"  && ile[posX][posY-1].emplacement != "n0"  && ile[posX][posY+1].emplacement != "n0"  && ile[posX+1][posY-1].emplacement != "n0"  && ile[posX+1][posY].emplacement != "n0"  && ile[posX+1][posY+1].emplacement != "n0") {
					if (ile[posX-1][posY-1].emplacement != "N0" && ile[posX-1][posY].emplacement != "N0"  && ile[posX-1][posY+1].emplacement != "N0"  && ile[posX][posY-1].emplacement != "N0"  && ile[posX][posY+1].emplacement != "N0"  && ile[posX+1][posY-1].emplacement != "N0"  && ile[posX+1][posY].emplacement != "N0"  && ile[posX+1][posY+1].emplacement != "N0") {
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

}


