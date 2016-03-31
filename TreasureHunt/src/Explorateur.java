
public class Explorateur extends Personnage{
	
	
	public Explorateur(int posX,int posY){
		super.posX=posX;
		super.posY=posY;
	}
	
	public void deplacementDroite() {
		super.posX=super.posX+1;
	} 
	public void deplacementGauche() {
		super.posX=super.posX-1;
	}
	public void deplacementBas() {
		super.posY=super.posY+1;
	} 
	public void deplacementHaut() {
		super.posY=super.posY-1;
	}
}


