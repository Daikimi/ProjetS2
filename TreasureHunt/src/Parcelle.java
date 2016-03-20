	/**
	 * La classe Parcelle g�re une case de l'�le
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
	 * boolean v�rifiant si la case est un navire de l'equipe 1
	 * 
	 */
	boolean navire1 = false;
	
	/**
	 * boolean v�rifiant si la case est un navire de l'equipe 2
	 * 
	 */
	boolean navire2 = false;
	
	/**
	 * boolean v�rifiant si la case est de l'eau
	 * 
	 */
	boolean eau = false;
	
	/**
	 * boolean v�rifiant si la case est un rocher
	 * 
	 */
	boolean rocher = false;
	
	/**
	 * boolean v�rifiant si la case est un coffre cach�
	 * 
	 */
	boolean coffre = false;
	
	/**
	 * boolean v�rifiant si la case est un rocher contenant la cl� du coffre
	 * 
	 */
	boolean cle = false;
	/**
	 * boolean v�rifiant si la case est un personnage
	 * 
	 */
	boolean personnage = false;
	
	
	/**
	 * Constructeur de Parcelle
	 * assigne une valeur � la case
	 * @param chose la valeur assign�e � la case
	 *  
	 */
	public Parcelle(String chose) {
		emplacement = chose;
	}
	
	/**
	 * M�thode de type setter
	 * qui assigne une nouvelle valeur � la case
	 * @param chose la nouvelle valeur qui va �tre assign�e � la case
	 */
	public void changement(String chose) {	
			emplacement = chose;
	}
	
	/**
	 * M�thode toString qui 
	 * retourne une String la valeur de la case
	 * @return emplacement la valeur de la case
	 */
	public String toString() {
		return emplacement;
	}
	
}