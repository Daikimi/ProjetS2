import java.util.Random;

public class Island {
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Perimetre = Interieur du carre (l'exterieur sera de l'eau)
	public int nbRochers = (xIle*yIle)/10;
	public Parcelle[][] ile = new Parcelle[xIle][yIle];
	Random random = new Random();
	
	public Island(){
		for(int i=0;i<ile.length;i++){
			for(int j=0;j<ile[0].length;j++){
				if (i == 0 || i == xIle-1 || j == 0 || j == yIle-1) {
					ile[i][j]=new Parcelle("X");
					ile[i][j].eau = true;
				} else {
					ile[i][j]=new Parcelle(" ");
				}
			}
		}
		int b1 = 1+ random.nextInt(yIle-2);
		int b2 = 1+ random.nextInt(yIle-2);
		
		ile[b1][1].emplacement = "n";
		ile[b1][1].navire1 = true;
		ile [b2][yIle-2].emplacement = "N";
		ile [b2][yIle-2].navire2 = true;
		
		int r = 0;
		while (r < nbRochers-2) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (ile[posX][posY].emplacement == " ")  {
				ile[posX][posY].emplacement = "R";
				ile[posX][posY].rocher = true;
				r = r + 1;
			}
		}		
		while (r < nbRochers-1) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (ile[posX][posY].emplacement == " ") {
				ile[posX][posY].emplacement = "R";
				ile[posX][posY].rocher = true;
				ile[posX][posY].coffre = true;
				r = r + 1;
			}
		}
		while (r < nbRochers) {			
			int posX = random.nextInt(xIle);
			int posY = random.nextInt(yIle);
			if (ile[posX][posY].emplacement == " ") {
				ile[posX][posY].emplacement = "R";
				ile[posX][posY].rocher = true;
				ile[posX][posY].cle = true;
				r = r + 1;
			}
		}
	}

	public String toString() {

		for (int i = 0; i < xIle; i++) {
			System.out.print("|");
			for (int j = 0; j < yIle; j++) {
				System.out.print(" " + ile[i][j].toString() + " |");
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
	
	public static void main(String[] args){
		
		Island test= new Island();
		System.out.println(test);
		
		}

}


