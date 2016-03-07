
public class Island {
	
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Périmètre = Intérieur du carré (l'extérieur sera de l'eau)
	public int nbRochers = 5; //A modifier, je pense que ce sera trop peu
	public Parcelle[][] ile = new Parcelle[xIle][yIle];
	
	public String toString() {

		for (int i = 0; i < xIle; i++) {
			System.out.print("|");
			for (int j = 0; j < yIle; j++) {
				System.out.print(" " + ile[i][j] + " |");
			}
			System.out.println("");
		}
		return "";
	}
	
	//public static void main(String[] args) {
	//	Island test = new Island();
	//	
	//	test[0][0] = new Parcelle("A");
	//	
	//	test.toString();
	//}
}
