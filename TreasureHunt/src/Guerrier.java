import java.util.Random;

/**
 * Classe Guerrier héritant de Personnage.
 * Le Guerrier est le seul type de Personnage pouvant frapper les autres Personnages.
 * @author Team-F5
 */

public class Guerrier extends Personnage{
	
	/**
	 * Constructeur de la classe Guerrier
	 * @param posX position X voulue
	 * @param posY position Y voulue
	 * @param equipe equipe dans laquelle se trouve le Guerrier
	 */
	public Guerrier(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	
	/**
	 * Méthode permettant de frapper un autre Personnage, lui assignant de 1 à 20 points de dégâts.
	 * @param victime Personnage visé par l'attaque.
	 */
	public void frapper(Personnage victime){
		victime.energie-=new Random().nextInt(20)+1;
		this.energie-=10;
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
