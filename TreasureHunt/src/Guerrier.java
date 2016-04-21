import javax.swing.JOptionPane;
import java.util.Random;


public class Guerrier extends Personnage{
	
	public Guerrier(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	
	public void frapper(Personnage victime){
		victime.energie-=new Random().nextInt(20)+1;
		this.energie-=10;
	}
	
	
	public void deplacement() {
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
