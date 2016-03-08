public class Parcelle {

	String emplacement = null;
	
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