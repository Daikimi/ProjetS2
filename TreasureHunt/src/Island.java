public class Island {
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Perimetre = Interieur du carre (l'exterieur sera de l'eau)
	public int nbRochers = (int)((xIle*yIle)*0.1); //A modifier, je pense que ce sera trop peu
	public Parcelle[][] ile = new Parcelle[xIle][yIle];
	
	public Island(){
		for(int i=0;i<ile.length;i++){
			for(int j=0;j<ile[0].length;j++){
				ile[i][j]=new Parcelle();
			}
		}
		Random rdm = new random();
		for(int i =0;i<nbRochers;i++){
			do{
				boolean positionne=false;
				int posX = rdm.nextInt(xIle);
				int posY = rdm.nextInt(yIle);
				if(ile[posX][posY]==" "){
					ile[posX][posY]="R";
					positionne= true;
				}
			}while(!positionne);
			
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
		ile[posX][posY].changement(chose); // Je n'arrive pas a modifier de manière a ce que les changements montent... :/
	}
	
	public String affichage(int posX,int posY) {
		return ile[posX][posY].toString(); 
	}
	 
	public void placementRocheux()
	
	public static void main(String[] args){
		
		Island ile= new Island();
		ile.changement("A", 1, 1);
		System.out.println(ile);
		
		
		
	}

}
