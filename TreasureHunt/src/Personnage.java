import javax.swing.JOptionPane;

abstract class Personnage{
	protected int posX;
	protected int posY;
	protected int energie=100;
	protected int equipe;
	protected boolean possedeClef=false;
	protected boolean possedeTresor=false;
	
	
	public void deplacement() {
		energie--;
	} 	
	public void repos(){
		if(Island.ile[posX][posY].getValeur()==4 && energie<100 ){
			energie+=10;
		}
	}
}
