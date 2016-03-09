public class Parcelle {

	String emplacement = null;
	boolean navire1 = false;
	boolean navire2 = false;
	boolean eau = false;
	boolean rocher = false;
	boolean coffre = false;
	boolean cle = false;
	boolean personnage = false;
	
	Parcelle(String chose) {
		emplacement = chose;
	}

	public void changement(String chose) {	
			emplacement = chose;
	}
	
	public String toString() {
		return emplacement;
	}
}