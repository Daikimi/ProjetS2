import javax.swing.JOptionPane;

public abstract class Explorateur extends Personnage{
	
	
	public Explorateur(int posX,int posY, int equipe){
		super.posX=posX;
		super.posY=posY;
		super.equipe=equipe;
	}
	
	public void recupereClefDroite(){
        if(Island.ile[posX+1][posY].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
    public void recupereClefGauche(){
        if(Island.ile[posX-1][posY].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
    public void recupereClefBas(){
        if(Island.ile[posX][posY+1].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
    public void recupereClefHaut(){
        if(Island.ile[posX][posY-1].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }

    public void deplacement() {
		super.deplacement();
	} 
	
	public void repos(){
		super.repos();
	}
}