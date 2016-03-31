import javax.swing.JOptionPane;

/**
 * Classe contenant le main qui sert à lancer la partie et appeler les diverses 
 * méthodes d'autre classe 
 * 
 * @author Team-F5
 *
 */

public class TreasureHunt {

	public static void main(String[] args) {
		
		String[] choix = {"Jouer", "Tester déplacement", "Règles", "Quitter"};

		int choisir = JOptionPane.showOptionDialog(null, "Quel est votre choix ?", "Bienvenue !", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
		
	   	if(choisir == 0) {
	    	Island test = new Island();
			System.out.println(test.toString());
			test.affichageGraphique();
		}
	    	
	    if(choisir == 1) { }
	    
	    if(choisir == 2) {
	    	JOptionPane.showMessageDialog(null, "Les règles du jeu doivent être écrites !");
	    }
	   
	    if(choisir == 3) {
	    	System.exit(0);
	    }
	    
	}
	    	
}