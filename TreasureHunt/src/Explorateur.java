import javax.swing.JOptionPane;

public abstract class Explorateur extends Personnage{
	
	
	public Explorateur(int posX,int posY, int equipe){
		super.posX=posX;
		super.posY=posY;
		super.equipe=equipe;
	}

	public void deplacementDroite() {
		super.posX=super.posX+1;
	} 
	public void deplacementGauche() {
		if(Island.ile[posX-1][posY].getValeur()==1 ||Island.ile[posX-1][posY].getValeur() == 5 || Island.ile[posX-1][posY].getValeur()== 7 ||  Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY].getValeur()==4||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY].getValeur()==6){
			JOptionPane.showMessageDialog(null, "VTFF");
		}else{
		super.posX=super.posX-1;}
	}
	public void deplacementBas() {
		if(Island.ile[posX][posY+1].getValeur()==1 ||Island.ile[posX][posY+1].getValeur() == 5 || Island.ile[posX][posY+1].getValeur()== 7 ||  Island.ile[posX][posY].getValeur()==7 && Island.ile[posX][posY+1].getValeur()==4||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "VTFF");
		}else{
			super.posY=super.posY+1;}
	}
	public void deplacementHaut() {
		if(Island.ile[posX][posY-1].getValeur()==1 ||Island.ile[posX][posY-1].getValeur() == 5 || Island.ile[posX][posY-1].getValeur()== 7 ||  Island.ile[posX][posY].getValeur()==7 && Island.ile[posX][posY-1].getValeur()==4||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "VTFF");
		}else{
		super.posY=super.posY-1;
		} 
	}
}