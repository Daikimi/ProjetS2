/**
 * Classe Voleur héritant de Personnage.
 * Le Voleur est le seul type de Personnage pouvant fouiller les poches des autres Personnages.
 * @author Team-F5
 */
public class Voleur extends Personnage {
	
	/**
	 * Constructeur de la classe Voleur
	 * @param posX position X désirée
	 * @param posY position Y désirée
	 * @param equipe équipe désirée
	 */
	public Voleur(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	/**
	 * Méthode permettant de voler un autre Personnage
	 * @param victime Personnage qui va subir le vol
	 */
	public void vol(Personnage victime){
		super.vol(victime);
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
	public void repos(Island i){
		super.repos(i);
	}
}
