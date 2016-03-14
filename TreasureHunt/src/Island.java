import java.util.Random;

public class Island {
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Perimetre = Interieur du carre (l'exterieur sera de l'eau)
	public int nbRochers = (xIle*yIle)/10;
	public Parcelle[][] ile = new Parcelle[xIle][yIle];
	Random random = new Random();

	public Island(){
		
		placementEau();

		placementNavires();
		
		placementRochers();
		
	}

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
	
	public void changement(String chose,int posX,int posY) {	
		ile[posX][posY].changement(chose);
	}
	
	public String affichage(int posX,int posY) {
		return ile[posX][posY].toString(); 
	}

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

	private void placementNavires() {
		int b1 = 1+ random.nextInt(yIle-2);
		int b2 = 1+ random.nextInt(yIle-2);
		
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
		ile[b2-1][yIle-2].emplacement = "e" + increment ;
		increment++;
	}
	if (ile[b2+1][yIle-2].emplacement == " 0") {
		ile[b2+1][yIle-2].emplacement = "e" + increment ;
		increment++;
	}
	if (ile[b2-1][yIle-3].emplacement == " 0") {
		ile[b2-1][yIle-3].emplacement = "e" + increment ;
		increment++;
	}
	if (ile[b2+1][yIle-3].emplacement == " 0") {
		ile[b2+1][yIle-3].emplacement = "e" + increment ;
		increment++;
	}
	if (ile[b2][yIle-3].emplacement == " 0") {
		ile[b2][yIle-3].emplacement = "e" + increment ;
		increment++;
	}


}

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


