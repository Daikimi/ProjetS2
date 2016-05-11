/**
 * Classe Piégeur héritant de Personnage.
 * Le Piégeur est le seul type de Personnage pouvant piéger le sol et immobiliser d'autres Personnages.
 * @author Team-F5
 */
public class Piegeur extends Personnage{
	/**
	 * Constructeur de la classe Piègeur
	 * @param posX position X désirée
	 * @param posY position Y désirée
	 * @param equipe équipe désirée
	 */
	public Piegeur(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	/**
	 * Méthode permettant de poser un piège à l'emplacement défini.
	 * @param posX position X voulue
	 * @param posY position Y voulue
	 */
	public void pieger(int posX,int posY){
		if(Island.ile[posX][posY].getValeur()==8){
			Island.ile[posX][posY].setValeur(16);		
		}		
		energie-=5;
	}
	/**
	 * Méthode permettant de désarmer un piège à l'emplacement défini.
	 * @param posX position X voulue
	 * @param posY position Y voulue
	 */
	public void desarmerPiege(int posX, int posY) {
		if(Island.ile[posX][posY].getValeur()==16){
			Island.ile[posX][posY].setValeur(8);		
		}		
		energie-=5;
	}
	
	/**
	 * Méthode permettant de poser un piège à droite du Piégeur.
	 */
	public void piegerDroit(){
	
		pieger(posX,posY+1);		
	
	}
	
	/**
	 * Méthode permettant de poser un piège à gauche du Piégeur.
	 */
	public void piegerGauche(){
	
		pieger(posX,posY-1);		
	
	}
	
	/**
	 * Méthode permettant de poser un piège au dessus du Piégeur.
	 */
	public void piegerHaut(){
	
		pieger(posX-1,posY);		
	
	}
	
	/**
	 * Méthode permettant de poser un piège au dessous du Piégeur.
	 */
	public void piegerBas(){
	
		pieger(posX+1,posY);		
	
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
