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
				if (ile[i][j].getEmplacement()==0) {
					System.out.print(" " + "\u001b[30m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].getEmplacement() == 1) {
					System.out.print(" " + "\u001b[34m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].getEmplacement() == 2) {
					System.out.print(" " + "\u001b[37m" + ile[i][j].toString() + "\u001b[0m" + " |");
				} else if (ile[i][j].getEmplacement() == 4 || ile[i][j].getEmplacement() == 6) {
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
	 * Méthode qui change la valeur d'une case de position [X,Y]
	 * pour une autre 
	 * 
	 * @param chose nouvelle valeur pour la case
	 * @param posX position X de la case voulue
	 * @param posY position Y de la case voulue
	 */
	public void changement(int chose,int posX,int posY) {	
		ile[posX][posY].setEmplacement(chose);
	}
	/**
	 * Affiche la valeur de la case de position voulue
	 * 
	 * @param posX position X de la case sur l'île
	 * @param posY position Y de la case sur l'île
	 * @return valeur de la case désirée
	 */
	
	public String affichage(int posX,int posY) {
		return ile[posX][posY].toString(); 
	}
	
	/**
	 * Affichage graphique de l'île grâce à la
	 * classe Plateau modifiée afin de pouvoir faire des îles personnalisable 
	 * 
	 */
	
	public void affichageGraphique(){
		
		String[] gifs = {"lib/mer.png" , "lib/rocher.png" , "lib/coffre.png" , "lib/1.navire.png" , "lib/1.explorateur.png", "lib/2.navire.png" , "lib/2.explorateur.png", "lib/sable.png"};
		int[][] carte = new int[yIle][xIle];
		for(int i =0; i<xIle; i++) {
			for(int j =0; j<yIle ; j++) {
				if(ile[i][j].getEmplacement() == 1) {
					carte[j][i]=1;
				} else if(ile[i][j].getEmplacement() == 2) {
					carte[j][i]=2;
				} else if(ile[i][j].getEmplacement() ==4 ) {
					carte[j][i]=4;
				} else if (ile[i][j].getEmplacement() == 5) {
					carte[j][i]=5;
				} else if (ile[i][j].getEmplacement() == 6) { 
					carte[j][i]=6;
				} else if (ile[i][j].getEmplacement()== 7) {
					carte[j][i]=7;
				} else {
					carte[j][i]=8;
				}
			}
		}

		Plateau plateau = new Plateau(gifs, 1);
		plateau.setJeu(carte);
		plateau.affichage();
		
	    }
	
	/**
	 * Méthode permettant une demande à l'utilisateur de la taille voulue pour l'île
	 *  
	 */
	
	private void creationIle() {
		String regex = "[0-9]+";
		String rep1 = "";
		String rep2 = "";
		String nbroc="";
		do {
			rep1 = JOptionPane.showInputDialog(null, "Choississez la taille x de l'île");
		 	rep2 = JOptionPane.showInputDialog(null, "Choississez la taille y de l'île");
		 	nbroc = JOptionPane.showInputDialog(null, "Choisissez le pourcentage de rocher de l'île :");
		} while (!rep1.matches(regex) && !rep2.matches(regex)&& !nbroc.matches(regex));

		xIle = Integer.parseInt(rep1);
		yIle = Integer.parseInt(rep2);
		ile = new Parcelle[xIle][yIle];
		nbRochers = Integer.parseInt(nbroc);
	}
	
	/**
	 * Méthode remplaçant les bords de l'île par la valeur de l'eau
	 * 
	 */
	
	private void placementEau() {
		for(int i=0;i<ile.length;i++){
			for(int j=0;j<ile[0].length;j++){
				if (i == 0 || i == xIle-1 || j == 0 || j == yIle-1) {
					ile[i][j]=new Parcelle(1);
					ile[i][j].setEau(true);
				} else {
					ile[i][j]=new Parcelle(0);
				}
			}
		}
	}
	
	/**
	 * Place les navires sur l'île
	 * chacun sur un côté de l'île
	 * puis placement de 5 aventuriers autour du navire
	 *  
	 */

	private void placementNavires() {
		int b1 = 1+ random.nextInt(xIle-2);
		int b2 = 1+ random.nextInt(xIle-2);
		
		ile[b1][1].setEmplacement(4);
		ile[b1][1].setNavire1(true);
		ile [b2][yIle-2].setEmplacement(6);
		ile [b2][yIle-2].setNavire2(true);

		for(int i=b1-1;i<b1+2;i++){
			for(int j=1;j<3;j++){
				if(ile[i][j].getEmplacement()==0){
					ile[i][j].setEmplacement(5);
					ile[i][j].setPersonnage(true);
				}
			}
		}
		
		for(int i=b2-1;i<b2+2;i++){
			for(int j=yIle-3;j<yIle-1;j++){
				if(ile[i][j].getEmplacement()==0){
					ile[i][j].setEmplacement(7);
					ile[i][j].setPersonnage(true);
				}
			}
		}
	


}
	/**
	 * Place les rochers sur l'île en regardant si les rochers ne bloque pas la progression
	 * des aventuriers sur l'île 
	 * 
	 */

	private void placementRochers() {
	int r = 0;
		while (r < nbRochers-2) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].setEmplacement(2) ;
				ile[posX][posY].setRocher(true);
				r = r + 1;
			}
		}		
		while (r < nbRochers-1) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].setEmplacement(2);
				ile[posX][posY].setRocher(true);
				ile[posX][posY].setCoffre(true);
				r = r + 1;
			}
		}
		while (r < nbRochers) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (verificationPlacementRochers(posX,posY))  {
				ile[posX][posY].setEmplacement(2);
				ile[posX][posY].setRocher(true);
				ile[posX][posY].setCle(true);
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
		if (ile[posX][posY].getEmplacement() == 0) {
			if (!ile[posX-1][posY-1].isRocher()&& !ile[posX-1][posY].isRocher() && !ile[posX-1][posY+1].isRocher() && !ile[posX][posY-1].isRocher()  && !ile[posX][posY+1].isRocher()  && !ile[posX+1][posY-1].isRocher()  && !ile[posX+1][posY].isRocher()  && !ile[posX+1][posY+1].isRocher()) {
				if (!ile[posX-1][posY-1].isNavire1() && !ile[posX-1][posY].isNavire1() && !ile[posX-1][posY+1].isNavire1()  && !ile[posX][posY-1].isNavire1()  && !ile[posX][posY+1].isNavire1() && !ile[posX+1][posY-1].isNavire1() && !ile[posX+1][posY].isNavire1()  && !ile[posX+1][posY+1].isNavire1()) {
					if (!ile[posX-1][posY-1].isNavire2() && !ile[posX-1][posY].isNavire2() && !ile[posX-1][posY+1].isNavire2()  && !ile[posX][posY-1].isNavire2() && !ile[posX][posY+1].isNavire2()  && !ile[posX+1][posY-1].isNavire2()  && !ile[posX+1][posY].isNavire2()  && !ile[posX+1][posY+1].isNavire2()) {
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


