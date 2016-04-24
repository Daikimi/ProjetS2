import javax.swing.JOptionPane;
/**
 * Classe Explorateur héritant de Personnage.
 * L'explorateur est le seul type de Personnage pouvant fouiller sous les rochers.
 * Il est le seul type de personnage ne pouvant pas marcher dans toutes les 8 directions.
 * @author Team-F5
 */

public class Explorateur extends Personnage{
	
	/**
	 * Constructeur de la classe Explorateur.
	 * @param posX position X désirée
	 * @param posY position Y désirée
	 * @param equipe équipe désirée
	 */
	public Explorateur(int posX,int posY, int equipe){
		super.posX=posX;
		super.posY=posY;
		super.equipe=equipe;
	}
	/**
	 * Méthode permettant de fouiller et récupérer la clé à droite de l'Explorateur si elle s'y trouve.
	 */
	public void recupereClefDroite(){
        if(Island.ile[posX+1][posY].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
	/**
	 * Méthode permettant de fouiller et récupérer la clé à gauche de l'Explorateur si elle s'y trouve.
	 */
    public void recupereClefGauche(){
        if(Island.ile[posX-1][posY].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
    /**
	 * Méthode permettant de fouiller et récupérer la clé en dessous de l'Explorateur si elle s'y trouve.
	 */
    public void recupereClefBas(){
        if(Island.ile[posX][posY+1].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }
    /**
	 * Méthode permettant de fouiller et récupérer la clé au dessus de l'Explorateur si elle s'y trouve.
	 */
    public void recupereClefHaut(){
        if(Island.ile[posX][posY-1].getValeur()==9){
            super.possedeClef=true;
        }else{
            JOptionPane.showMessageDialog(null, "Rien en dessous du rocher !");
        }
        energie-=5;
    }

    /**
     * Méthode de déplacement généralisée.
     */
    public void deplacement() {
		super.deplacement();
	} 
	/**
	 * Méthode de repos généralisée.
	 */
	public void repos(){
		super.repos();
	}
}