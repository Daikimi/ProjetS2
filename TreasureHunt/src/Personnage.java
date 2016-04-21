import javax.swing.JOptionPane;

abstract class Personnage{
	protected int posX;
	protected int posY;
	protected int energie=100;
	protected int equipe;
	protected boolean possedeClef=false;
	protected boolean possedeTresor=false;
	
	
	public void deplacementDroite() {
		if(Island.ile[posX+1][posY].getValeur()==1 ||Island.ile[posX+1][posY].getValeur() == 5 || Island.ile[posX+1][posY].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX+1][posY].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX+1][posY].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
		posX=posX+1;}
		energie--;
	} 
	public void deplacementGauche() {
		if(Island.ile[posX-1][posY].getValeur()==1 ||Island.ile[posX-1][posY].getValeur() == 5 || Island.ile[posX-1][posY].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
		posX=posX-1;}
		energie--;
	}
	public void deplacementBas() {
		if(Island.ile[posX][posY+1].getValeur()==1 ||Island.ile[posX][posY+1].getValeur() == 5 || Island.ile[posX][posY+1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX][posY+1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posY=posY+1;}
		energie--;
	}
	public void deplacementHaut() {
		if(Island.ile[posX][posY-1].getValeur()==1 ||Island.ile[posX][posY-1].getValeur() == 5 || Island.ile[posX][posY-1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX][posY-1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
		posY=posY-1;
		} 
		energie--;
	}
	
	public void repos(){
		if(Island.ile[posX][posY].getValeur()==4 && energie<100 ){
			energie+=10;
		}
	}
}
