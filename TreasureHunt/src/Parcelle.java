import java.util.HashMap;

/**
	 * La classe Parcelle gère une case de l'île
	 *  en prenant la valeur de la case voulue
	 *  dans la classe ile
	 *  
	 *  @author Team-F5
	 */

public class Parcelle {
	
	/**
	 * Integer contenant la valeur de la case
	 * 
	 */
	
	private int valeur ;



	
	/**
	 * Variable de classe Personnage permettant de contrôler un personnage actif.
	 */
	private Personnage perso = null;
	HashMap<String,Personnage> personnages = new HashMap<>(); // N'est utilisé que si c'est un bateau
	

	/**
	 * Constructeur de Parcelle
	 * assigne une valeur à la case
	 * @param chose la valeur assignée à la case
	 *  
	 */
	public Parcelle(int chose) {
		valeur = chose;
	}
	/**
	 * Méthode de type getter
	 * qui permet de récupérer la valeur de la Parcelle.
	 * @return valeur de la parcelle
	 */
	public int getValeur() {
		return valeur;
	}
	
	/**
	 * Méthode de type setter
	 * qui assigne une nouvelle valeur à la case
	 * @param valeur la nouvelle valeur qui va être assignée à la case
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * Méthode toString qui 
	 * retourne une String la valeur de la case
	 * @return emplacement la valeur de la case
	 */
	public String toString() {
		if(valeur==8){
			return " O"; 
		}else if(valeur==1){
			return "XO";
		}else if(valeur==2){
			return "RO";
		}else if(valeur==4){
			return "nO";
		}else if(valeur==5){
			return " e";
		}else if(valeur==6){
			return "NO";
		}else{
			return " E";		}
	}
	
	/**
	 * Méthode de type getter
	 * qui permet de récupérer le Personnage de la Parcelle.
	 * @return valeur de la parcelle
	 */
	public Personnage getPerso() {
		return perso;
	}
	
	/**
	 * Méthode de type setter
	 * qui assigne un nouveau personnage à la case
	 * @param p la nouvelle valeur qui va être assignée à la case
	 */
	public void setPersonnage(Personnage p) {
		this.perso = p;
	}

	/*public void ajoutPersonnage(Personnage p) {
		this.personnages.add(p);
	}
	
	public void supprimerPersonnage(Personnage p) {
		this.personnages.remove(p);
	}*/

	
}