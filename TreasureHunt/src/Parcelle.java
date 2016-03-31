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
	 * Constructeur de Parcelle
	 * assigne une valeur à la case
	 * @param chose la valeur assignée à la case
	 *  
	 */
	public Parcelle(int chose) {
		valeur = chose;
	}
	
	/**
	 * Méthode de type setter
	 * qui assigne une nouvelle valeur à la case
	 * @param chose la nouvelle valeur qui va être assignée à la case
	 */
		
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int emplacement) {
		this.valeur = emplacement;
	}

	/**
	 * Méthode toString qui 
	 * retourne une String la valeur de la case
	 * @return emplacement la valeur de la case
	 */
	public String toString() {
		if(valeur==0){
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
	
}