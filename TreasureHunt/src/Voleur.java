import javax.swing.JOptionPane;

public class Voleur extends Personnage {
	
	
	public Voleur(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	
	public void vol(Personnage victime){
		if(victime.possedeClef){
			victime.possedeClef=false;
			this.possedeClef=true;
			System.out.println("Réussi !!!");
		}else{
			System.out.println("Loupé...");
		}
	}
	
	public void deplacementDroite() {
		super.deplacementDroite();
	} 
	public void deplacementGauche() {
		super.deplacementGauche();
	}
	public void deplacementBas() {
		super.deplacementBas();
	}
	public void deplacementHaut() {
		super.deplacementHaut();
	}
	public void deplacementBasDroit(){
		if(Island.ile[posX+1][posY+1].getValeur()==1 ||Island.ile[posX+1][posY+1].getValeur() == 5 || Island.ile[posX+1][posY+1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX+1][posY+1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX+1][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX+=1;
			posY+=1;
		}
	}
	
	public void deplacementBasGauche(){
		if(Island.ile[posX+1][posY-1].getValeur()==1 ||Island.ile[posX+1][posY-1].getValeur() == 5 || Island.ile[posX+1][posY-1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX+1][posY-1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX+1][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX+=1;
			posY-=1;
		}
	}
	
	public void deplacementHautGauche(){
		if(Island.ile[posX-1][posY-1].getValeur()==1 ||Island.ile[posX-1][posY-1].getValeur() == 5 || Island.ile[posX-1][posY-1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY-1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY-1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX-=1;
			posY-=1;
		}
	}
	
	public void deplacementHautDroit(){
		if(Island.ile[posX-1][posY+1].getValeur()==1 ||Island.ile[posX-1][posY+1].getValeur() == 5 || Island.ile[posX-1][posY+1].getValeur()== 7 ||  (Island.ile[posX][posY].getValeur()==7 && Island.ile[posX-1][posY+1].getValeur()==4) ||Island.ile[posX][posY].getValeur()==5 && Island.ile[posX-1][posY+1].getValeur()==6){
			JOptionPane.showMessageDialog(null, "Impossible !");
		}else{
			posX-=1;
			posY+=1;
		}
	}
	
}
