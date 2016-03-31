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

		String choisir = 
	    		(String)JOptionPane.showInputDialog(null, "Quel est votre choix ?",
	    									"Menu",JOptionPane.QUESTION_MESSAGE,
	    									null,choix,choix[0]);
	    
	    switch(choisir){   
	    case("Jouer") :
	    	Island test = new Island();
			System.out.println(test.toString());
			test.affichageGraphique();
			break;
			
	    case("Tester déplacement") :
	    	
	    	break;
			
	    case("Règles") :
	    	JOptionPane.showMessageDialog(null, "Les règles du jeu doivent être écrites !");
	    	break;
	    
	    case("Quitter") :
	    	System.exit(0);
	    	break;
	    
	    }
	    	
	  }
	}
