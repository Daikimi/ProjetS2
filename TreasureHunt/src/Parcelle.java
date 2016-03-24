	/**
	 * La classe Parcelle g�re une case de l'�le
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
	
	private int emplacement ;
	
	/**
	 * boolean v�rifiant si la case est un navire de l'equipe 1
	 * 
	 */
	private boolean navire1 = false;
	
	/**
	 * boolean v�rifiant si la case est un navire de l'equipe 2
	 * 
	 */
	private boolean navire2 = false;
	
	/**
	 * boolean v�rifiant si la case est de l'eau
	 * 
	 */
	private boolean eau = false;
	
	/**
	 * boolean v�rifiant si la case est un rocher
	 * 
	 */
	private boolean rocher = false;
	
	/**
	 * boolean v�rifiant si la case est un coffre cach�
	 * 
	 */
	private boolean coffre = false;
	
	/**
	 * boolean v�rifiant si la case est un rocher contenant la cl� du coffre
	 * 
	 */
	private boolean cle = false;
	/**
	 * boolean v�rifiant si la case est un personnage
	 * 
	 */
	private boolean personnage = false;
	
	
	/**
	 * Constructeur de Parcelle
	 * assigne une valeur � la case
	 * @param chose la valeur assign�e � la case
	 *  
	 */
	public Parcelle(int chose) {
		emplacement = chose;
	}
	
	/**
	 * M�thode de type setter
	 * qui assigne une nouvelle valeur � la case
	 * @param chose la nouvelle valeur qui va �tre assign�e � la case
	 */
		
	public int getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(int emplacement) {
		this.emplacement = emplacement;
	}

	public boolean isNavire1() {
		return navire1;
	}

	public void setNavire1(boolean navire1) {
		this.navire1 = navire1;
	}

	public boolean isNavire2() {
		return navire2;
	}

	public void setNavire2(boolean navire2) {
		this.navire2 = navire2;
	}

	public boolean isEau() {
		return eau;
	}

	public void setEau(boolean eau) {
		this.eau = eau;
	}

	public boolean isRocher() {
		return rocher;
	}

	public void setRocher(boolean rocher) {
		this.rocher = rocher;
	}

	public boolean isCoffre() {
		return coffre;
	}

	public void setCoffre(boolean coffre) {
		this.coffre = coffre;
	}

	public boolean isCle() {
		return cle;
	}

	public void setCle(boolean cle) {
		this.cle = cle;
	}

	public boolean isPersonnage() {
		return personnage;
	}

	public void setPersonnage(boolean personnage) {
		this.personnage = personnage;
	}

	/**
	 * M�thode toString qui 
	 * retourne une String la valeur de la case
	 * @return emplacement la valeur de la case
	 */
	public String toString() {
		if(emplacement==0){
			return " O"; 
		}else if(emplacement==1){
			return "XO";
		}else if(emplacement==2){
			return "RO";
		}else if(emplacement==4){
			return "nO";
		}else if(emplacement==5){
			return " e";
		}else if(emplacement==6){
			return "NO";
		}else{
			return " E";		}
	}
	
}