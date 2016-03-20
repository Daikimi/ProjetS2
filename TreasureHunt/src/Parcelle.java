	/**
	 * La classe Parcelle gère une case de l'île
	 *  en prenant la valeur de la case voulue
	 *  dans la classe ile
	 *  
	 *  @author Team-F5
	 */

public class Parcelle {
	
	/**
	 * String contenant la valeur de la case
	 * 
	 */
	
	String emplacement = null;
	
	/**
	 * boolean vérifiant si la case est un navire de l'equipe 1
	 * 
	 */
	boolean navire1 = false;
	
	/**
	 * boolean vérifiant si la case est un navire de l'equipe 2
	 * 
	 */
	boolean navire2 = false;
	
	/**
	 * boolean vérifiant si la case est de l'eau
	 * 
	 */
	boolean eau = false;
	
	/**
	 * boolean vérifiant si la case est un rocher
	 * 
	 */
	boolean rocher = false;
	
	/**
	 * boolean vérifiant si la case est un coffre caché
	 * 
	 */
	boolean coffre = false;
	
	/**
	 * boolean vérifiant si la case est un rocher contenant la clé du coffre
	 * 
	 */
	boolean cle = false;
	/**
	 * boolean vérifiant si la case est un personnage
	 * 
	 */
	boolean personnage = false;
	
	
	/**
	 * Constructeur de Parcelle
	 * assigne une valeur à la case
	 * @param chose la valeur assignée à la case
	 *  
	 */
	public Parcelle(String chose) {
		emplacement = chose;
	}
	
	/**
	 * Méthode de type setter
	 * qui assigne une nouvelle valeur à la case
	 * @param chose la nouvelle valeur qui va être assignée à la case
	 */
	public void changement(String chose) {	
			emplacement = chose;
	}
	
	/**
	 * Méthode toString qui 
	 * retourne une String la valeur de la case
	 * @return emplacement la valeur de la case
	 */
	public String toString() {
		return emplacement;
	}
	
}