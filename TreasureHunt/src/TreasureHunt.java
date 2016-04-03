import javax.swing.JOptionPane;
//import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

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
	    	
		}
	    	
	    if(choisir == 1) { 
	    	boolean finish = false;
	    	Island test = new Island();
			System.out.println(test.toString());
			test.affichageGraphique();
			
			int [] res= new int[4];
			InputEvent evenement;
			
			do{
				evenement =  test.plateau.waitEvent();
								
			if (evenement instanceof MouseEvent) {
				res[0]=test.plateau.getX((MouseEvent) evenement) ;
				res[1]=test.plateau.getY((MouseEvent) evenement) ;
				char ch = (char) (res[0]+64);
					
				System.out.println("Case : "+res[1]+ ch);
				
				
				
				evenement =  test.plateau.waitEvent();
				
				res[2]=test.plateau.getX((MouseEvent) evenement) ;
				res[3]=test.plateau.getY((MouseEvent) evenement) ;
				
				//Valeur de la première case => temp
				int temp = test.getValeur(res[0], res[1]);
				System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
				//Valeur de la deuxième case => première case
				test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
				System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
				// Valeur temp => deuxième case
				test.changement(temp, res[2], res[3]);
				System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
				
				
				test.affichageGraphique();
					
			} else {
		       	int keyCode = ((KeyEvent) evenement).getKeyCode() ;
		       	if (keyCode == 27) { // test escape key
		       		finish = true ;
		       	}
			}
		}while(!finish);
		test.plateau.close();
	}
	    
	    
	    if(choisir == 2) {
	    	JOptionPane.showMessageDialog(null, "Les règles du jeu doivent être écrites !");
	    }
	   
	    if(choisir == 3) {
	    	System.exit(0);
	    }
	    
	}
	    	
}