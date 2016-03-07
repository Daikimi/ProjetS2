public class Parcelle {

	String emplacement = null;
	
	Parcelle() {
		emplacement = "";
	}

	public void changement(String chose) {	
			emplacement = chose;
	}
	
	public String toString() {
		return emplacement;
	}
}