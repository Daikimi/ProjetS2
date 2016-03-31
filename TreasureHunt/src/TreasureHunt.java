import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

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
			/*InputEvent evenement;
			
			boolean finished = false ;
			Color currentColor = Color.BLUE ;
		    do {
		        InputEvent event ;
		        plateau.println("A vous (ESC pour finir)") ;
		    	test.affichage();
		        event=  plateau.waitEvent();
		        if (event instanceof MouseEvent) {
		        	int x = plateau.getX((MouseEvent) event) ;
		        	int y = plateau.getY((MouseEvent) event) ;
		        	if (plateau.isHighlight(x,y)) {
		            	plateau.resetHighlight(x, y) ;        		
		        	} else {
		            	plateau.setHighlight(x, y, currentColor) ;  
		            	if (currentColor == Color.BLUE) {
		            		currentColor = Color.GREEN ; 
		            	} else if (currentColor == Color.GREEN) {
		            		currentColor = Color.RED ;
		            	} else if (currentColor == Color.RED) {
		            		currentColor = Color.YELLOW ;
		            	} else {
		            		currentColor = Color.BLUE ;
		            	}
		        	}
		        } else if (event instanceof KeyEvent) {
		        	plateau.println(event.toString()) ;
		        	int keyCode = ((KeyEvent) event).getKeyCode() ;
		        	if (keyCode == 27) { // test escape key
		        		finished = true ;
		        	}
		        }
		    } while (! finished) ; */
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