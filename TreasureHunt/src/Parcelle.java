public class Parcelle {

	String emplacement = "";
	String chose = "";
	
	public void changement() {

		if (emplacement == "") {
			emplacement = chose;
		} 
	}
}