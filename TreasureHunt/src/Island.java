
public class Island {
	
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Périmètre = Intérieur du carré (l'extérieur sera de l'eau)
	public int nbRochers = (xIle*yIle)/10; // 10% de l'île
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
	
	public void changement(String chose) {	
		this.emplacement = chose; // Je n'arrive pas à modifier de manière à ce que les changements montent... :/
}
	
	public String affichage() {
		return this.emplacement; // Je n'arrive pas à modifier de manière à ce que les changements montent... :/
	}
}
