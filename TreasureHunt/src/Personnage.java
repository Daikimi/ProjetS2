/**
 * Classe abstraite permettant de créer un Personnage, celle-ci contient donc naturellement
 * les actions communes à tous les types de Personnages : Les déplacements et le repos.
 * La récupération du trésor n'est pas encore présente.
 * @author Team-F5
 */
abstract class Personnage{
	/**
	 * Attribut permettant de déterminer la postion X du Personnage.
	 */
	protected int posX;
	/**
	 * Attribut permettant de déterminer la position Y du Personnage.
	 */
	protected int posY;
	/**
	 * Attribut permettant de déterminer le niveau d'énergie du Personnage.
	 */
	protected int energie=100;
	/**
	 * Attribut permettant de déterminer l'équipe du Personnage.
	 */
	protected int equipe;
	/**
	 * Attribut permettant de déterminer si le Personnage possède la clé ou non.
	 */
	protected boolean possedeClef=false;
	/**
	 * Attribut permettant de déterminer si le Personnage possède le trésor ou non.
	 */
	protected boolean possedeTresor=false;
	
	/**
	 * Méthode de déplacement : Le coeur de la fonction se trouve dans TreasureHunt.
	 * L'appel à cette fonction permet la décrémentation de l'énergie du Personnage.
	 */
	public void deplacement() {
		energie--;
	} 
	/**
	 * Méthode permettant de regagner de l'énergie lorsque le personnage se trouve dans le navire.
	 */
	public void repos(){
		if(Island.ile[posX][posY].getValeur()==4 && energie<100 ){
			energie+=10;
		}
	}
	
	public boolean mort(){
		if(energie<=0){
			return true;
		}else{
			return false;
		}
	}
}
