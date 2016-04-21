import javax.swing.JOptionPane;

public class Piegeur extends Personnage{
	
	public Piegeur(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	
	public void pieger(int posX,int posY){
		if(Island.ile[posX][posY].getValeur()==9){
			Island.ile[posX][posY].setValeur(10);		
		}		
		energie-=5;
	}
	
	public void piegerDroit(){
		pieger(posX,posY+1);		
	}

	public void piegerGauche(){
		pieger(posX,posY-1);		
	}
	
	public void piegerHaut(){
		pieger(posX-1,posY);		
	}
	
	public void piegerBas(){
		pieger(posX+1,posY);		
	}
	
	public void deplacementDroite() {
		super.deplacement();
	} 
	public void deplacementGauche() {
		super.deplacement();
	}
	public void deplacementBas() {
		super.deplacement();
	}
	public void deplacementHaut() {
		super.deplacement();
	}
	public void deplacementBasDroit(){
		if(Island.ile[posX+1][posY+1].getValeur()==1 ||Island.ile[posX+1][posY+1].getValeur() == 5 || Island.ile[posX+1][posY+1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX+1][posY+1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX+1][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX+=1;
			posY+=1;
		}
		energie--;
	}
	
	public void deplacementBasGauche(){
		if(Island.ile[posX+1][posY-1].getValeur()==1 ||Island.ile[posX+1][posY-1].getValeur() == 5 || Island.ile[posX+1][posY-1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX+1][posY-1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX+1][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX+=1;
			posY-=1;
		}
		energie--;
	}
	
	public void deplacementHautGauche(){
		if(Island.ile[posX-1][posY-1].getValeur()==1 ||Island.ile[posX-1][posY-1].getValeur() == 5 || Island.ile[posX-1][posY-1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY-1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX-=1;
			posY-=1;
		}
		energie--;
	}
	
	public void deplacementHautDroit(){
		if(Island.ile[posX-1][posY+1].getValeur()==1 ||Island.ile[posX-1][posY+1].getValeur() == 5 || Island.ile[posX-1][posY+1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY+1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX-=1;
			posY+=1;
		}
		energie--;
	}
}
