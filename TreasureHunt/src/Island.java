
public class Island {
	
	
	public int xIle = 10; // A modifier si l'on veut
	public int yIle = 10; // A modifier si l'on veut
	public int nbParcelles = (xIle*yIle) - ((xIle + yIle)*2) ; // Aire - Périmètre = Intérieur du carré (l'extérieur sera de l'eau)
	public int nbRochers = 5; //Je sais pas combien on doit en mettre ?
	public Parcelle[][] ile = new Parcelle[xIle][yIle];
	
	
	
}
