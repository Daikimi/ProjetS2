public class Parcelle {

	String emplacement = null;
	
	Parcelle() {
		emplacement = "";
	}

	public void changement(String chose) {	
			emplacement = chose;
	}
	
	public String affichage() {
		return emplacement;
	}
	
	public static void main(String[] args) {
		
		Parcelle test = new Parcelle();
		
		test.changement("A");
		
		System.out.println("| " + test.affichage() + " |");
	}
}