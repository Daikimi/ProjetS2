import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

//Pour les déplacements, il y a un inversement des cases, donc ça fonctionne pas MDLOL

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
	   		
	   		Island[] equipe = new Island[2];
	   		equipe[0] = new Island();
	   		equipe[1] = new Island(equipe[0]);
	   		boolean fin = false;
	   		InputEvent evenement;
	   		int[] res = new int[4];
	   		int jActif = 0;
	   		char ch;

	   		do {
	   			if (jActif == 0) { //J1 Clic1
	   				do {
	   					equipe[jActif].affichageGraphique();
	   					evenement = equipe[jActif].plateau.waitEvent();
	   					if (evenement instanceof MouseEvent) {
	   						res[0]=equipe[jActif].plateau.getX((MouseEvent) evenement) ;
	   						res[1]=equipe[jActif].plateau.getY((MouseEvent) evenement) ;
	   					}
	   				} while(equipe[jActif].getValeur(res[0], res[1]) == 1 || equipe[jActif].getValeur(res[0], res[1]) == 2  || equipe[jActif].getValeur(res[0], res[1]) == 3  || equipe[jActif].getValeur(res[0], res[1]) == 4  || equipe[jActif].getValeur(res[0], res[1]) == 6  || equipe[jActif].getValeur(res[0], res[1]) == 7 || equipe[jActif].getValeur(res[0], res[1]) == 8 || equipe[jActif].getValeur(res[0], res[1])==9 || equipe[jActif].getValeur(res[0], res[1]) == 11);
	   			} else { //J2 Clic1
	   				do {
	   					equipe[jActif].affichageGraphique();
	   					evenement = equipe[jActif].plateau.waitEvent();
	   					if (evenement instanceof MouseEvent) {
	   						res[0]=equipe[jActif].plateau.getX((MouseEvent) evenement) ;
	   						res[1]=equipe[jActif].plateau.getY((MouseEvent) evenement) ;
	   					}
	   				} while(equipe[jActif].getValeur(res[0], res[1]) == 1 || equipe[jActif].getValeur(res[0], res[1]) == 2  || equipe[jActif].getValeur(res[0], res[1]) == 3  || equipe[jActif].getValeur(res[0], res[1]) == 4  || equipe[jActif].getValeur(res[0], res[1]) == 5  || equipe[jActif].getValeur(res[0], res[1]) == 6 || equipe[jActif].getValeur(res[0], res[1]) == 8 || equipe[jActif].getValeur(res[0], res[1])==9 || equipe[jActif].getValeur(res[0], res[1]) == 10);
	   			}
   				ch = (char) (res[0]+64);
   				equipe[jActif].plateau.print("Case : "+res[1]+ ch);
   				if (Island.ile[res[0]][res[1]].getValeur()==5 || Island.ile[res[0]][res[1]].getValeur()==7) {
   					highlight4(equipe[jActif], res[0],res[1]);
   				}
   				if (Island.ile[res[0]][res[1]].getValeur()==10 || Island.ile[res[0]][res[1]].getValeur()==11) {
   					highlight8(equipe[jActif], res[0], res[1]);
   				}
   				boolean clic2 = false;
   				do{
   					evenement =  equipe[jActif].plateau.waitEvent();

   					res[2]=equipe[jActif].plateau.getX((MouseEvent) evenement) ;
   					res[3]=equipe[jActif].plateau.getY((MouseEvent) evenement) ;
   					if ((res[3] == res[1]+1 && res[2] == res[0]) || (res[3] == res[1]-1 && res[2] == res[0]) || (res[3] == res[1] && res[2] == res[0]+1) || (res[3] == res[1] && res[2] == res[0]-1) || (res[3] == res[1]+1 && res[2] == res[0]+1) || (res[3] == res[1]-1 && res[2] == res[0]+1) || (res[3] == res[1]+1 && res[2] == res[0]-1) || (res[3] == res[1]-1 && res[2] == res[0]-1)) {
   						clic2 = true;
   						
   						char ch2 = (char) (res[2]+64);
   						equipe[jActif].plateau.println("; "+res[3]+ ch2);
   						evenement = equipe[jActif].plateau.waitEvent(1000);
   					}   					
   				} while (!clic2);
   				if (equipe[jActif].getValeur(res[0], res[1]) == 5 || equipe[jActif].getValeur(res[0], res[1]) == 7 || equipe[jActif].getValeur(res[0], res[1]) == 10 || equipe[jActif].getValeur(res[0], res[1]) == 11) {
   					
   					if (res[3] == res[1]+1 && res[2] == res[0]) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
   							//Valeur de la première case => temp
   							int temp = equipe[jActif].getValeur(res[0], res[1]);
   							//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
   							//Valeur de la deuxième case => première case
   							equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
   							//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
   							// Valeur temp => deuxième case
   							equipe[jActif].changement(temp, res[2], res[3]);
   							//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
   											
   							equipe[jActif].plateau.masquer();
   							}
   						}
   					
   					
   					if (res[3] == res[1]-1 && res[2] == res[0]) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}
   					if (res[3] == res[1] && res[2] == res[0]+1) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}
   					if (res[3] == res[1] && res[2] == res[0]-1) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}


   					if (res[3] == res[1]+1 && res[2] == res[0]+1 && (equipe[jActif].getValeur(res[0], res[1]) == 10 || equipe[jActif].getValeur(res[0], res[1]) == 11)) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}
   					if (res[3] == res[1]+1 && res[2] == res[0]-1 && (equipe[jActif].getValeur(res[0], res[1]) == 10 || equipe[jActif].getValeur(res[0], res[1]) == 11)) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}
   					
   					if (res[3] == res[1]-1 && res[2] == res[0]+1 && (equipe[jActif].getValeur(res[0], res[1]) == 10 || equipe[jActif].getValeur(res[0], res[1]) == 11)) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
   						}
   					}
   					if (res[3] == res[1]-1 && res[2] == res[0]-1 && (equipe[jActif].getValeur(res[0], res[1]) == 10 || equipe[jActif].getValeur(res[0], res[1]) == 11)) {
   						if(Island.ile[res[2]][res[3]].getValeur()!=8){
   							JOptionPane.showMessageDialog(null, "Impossible !");
   							for (int i = 0; i < equipe[jActif].getXIle(); i++) {
   								for (int j = 0; j < equipe[jActif].getYIle(); j++){
   									equipe[jActif].plateau.resetHighlight(i, j);
   								}							
   							}
   						} else {
	   						//Valeur de la première case => temp
	   						int temp = equipe[jActif].getValeur(res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						//Valeur de la deuxième case => première case
	   						equipe[jActif].changement(equipe[jActif].getValeur(res[2], res[3]), res[0], res[1]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   						// Valeur temp => deuxième case
	   						equipe[jActif].changement(temp, res[2], res[3]);
	   						//System.out.println(temp + " " + equipe[jActif].getValeur(res[0], res[1]) + " " + equipe[jActif].getValeur(res[2], res[3]));
	   										
	   						equipe[jActif].plateau.masquer();
	   						}
   					}

   					if (evenement instanceof KeyEvent) {
   						int keyCode = ((KeyEvent) evenement).getKeyCode() ;
   						if (keyCode == 27) { // equipe[jActif] escape key
   							fin = true ;
   						}
   					}
   				}
   				if (jActif == 0) {
   					jActif = 1;
   				} else {
   					jActif = 0;
   				}
	} while (!fin);
}
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
	    	//System.exit(0);
	    	
	    if(choisir == 1) { 
	    	boolean finish = false;
	    	Island test = new Island();
	    	int turn = 0;
			System.out.println(test.toString());
			test.affichageGraphique();
			
			int [] res= new int[4];
			InputEvent evenement;
			
			do{
				do {
					evenement =  test.plateau.waitEvent();
								
			
					if (evenement instanceof MouseEvent) {
						res[0]=test.plateau.getX((MouseEvent) evenement) ;
						res[1]=test.plateau.getY((MouseEvent) evenement) ;
					}
				} while(test.getValeur(res[0], res[1]) == 1 || test.getValeur(res[0], res[1]) == 2  || test.getValeur(res[0], res[1]) == 3  || test.getValeur(res[0], res[1]) == 4  || test.getValeur(res[0], res[1]) == 6  || test.getValeur(res[0], res[1]) == 8 || test.getValeur(res[0], res[1])==9);

				char ch = (char) (res[0]+64);
					
				System.out.print("Case : "+res[1]+ ch);
				
				if (Island.ile[res[0]][res[1]].getValeur()==5 || Island.ile[res[0]][res[1]].getValeur()==7) {
					highlight4(test, res[0],res[1]);
				}
				if (Island.ile[res[0]][res[1]].getValeur()==10 || Island.ile[res[0]][res[1]].getValeur()==11) {
					highlight8(test, res[0], res[1]);
				}
				
				boolean clic2 = false;
				do{
					evenement =  test.plateau.waitEvent();
				
					res[2]=test.plateau.getX((MouseEvent) evenement) ;
					res[3]=test.plateau.getY((MouseEvent) evenement) ;
					if ((res[3] == res[1]+1 && res[2] == res[0]) || (res[3] == res[1]-1 && res[2] == res[0]) || (res[3] == res[1] && res[2] == res[0]+1) || (res[3] == res[1] && res[2] == res[0]-1) || (res[3] == res[1]+1 && res[2] == res[0]+1) || (res[3] == res[1]-1 && res[2] == res[0]+1) || (res[3] == res[1]+1 && res[2] == res[0]-1) || (res[3] == res[1]-1 && res[2] == res[0]-1)) {
						clic2 = true;
						
						char ch2 = (char) (res[2]+64);
						System.out.println("; "+res[3]+ ch2);
					}
					
				} while (!clic2);
				
				if (test.getValeur(res[0], res[1]) == 5 || test.getValeur(res[0], res[1]) == 7 || test.getValeur(res[0], res[1]) == 10 || test.getValeur(res[0], res[1]) == 11) {
					
					if (res[3] == res[1]+1 && res[2] == res[0]) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
							//Valeur de la première case => temp
							int temp = test.getValeur(res[0], res[1]);
							//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
							//Valeur de la deuxième case => première case
							test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
							//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
							// Valeur temp => deuxième case
							test.changement(temp, res[2], res[3]);
							//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
											
							test.plateau.masquer();
							test.affichageGraphique();
							turn++;
							}
						}
					
					
					if (res[3] == res[1]-1 && res[2] == res[0]) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
					if (res[3] == res[1] && res[2] == res[0]+1) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
					if (res[3] == res[1] && res[2] == res[0]-1) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
				
				
					if (res[3] == res[1]+1 && res[2] == res[0]+1 && (test.getValeur(res[0], res[1]) == 10 || test.getValeur(res[0], res[1]) == 11)) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
					if (res[3] == res[1]+1 && res[2] == res[0]-1 && (test.getValeur(res[0], res[1]) == 10 || test.getValeur(res[0], res[1]) == 11)) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
					
					if (res[3] == res[1]-1 && res[2] == res[0]+1 && (test.getValeur(res[0], res[1]) == 10 || test.getValeur(res[0], res[1]) == 11)) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
					if (res[3] == res[1]-1 && res[2] == res[0]-1 && (test.getValeur(res[0], res[1]) == 10 || test.getValeur(res[0], res[1]) == 11)) {
						if(Island.ile[res[2]][res[3]].getValeur()!=8){
							JOptionPane.showMessageDialog(null, "Impossible !");
							for (int i = 0; i < test.getXIle(); i++) {
								for (int j = 0; j < test.getYIle(); j++){
									test.plateau.resetHighlight(i, j);
								}							
							}
						} else {
						//Valeur de la première case => temp
						int temp = test.getValeur(res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						//Valeur de la deuxième case => première case
						test.changement(test.getValeur(res[2], res[3]), res[0], res[1]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
						// Valeur temp => deuxième case
						test.changement(temp, res[2], res[3]);
						//System.out.println(temp + " " + test.getValeur(res[0], res[1]) + " " + test.getValeur(res[2], res[3]));
										
						test.plateau.masquer();
						test.affichageGraphique();
						turn++;
						}
					}
				}
				
			if (evenement instanceof KeyEvent) {
		       	int keyCode = ((KeyEvent) evenement).getKeyCode() ;
		       	if (keyCode == 27) { // test escape key
		       		finish = true ;
		       	}
			}
		}while(!finish);
		test.plateau.close();
	       
	    
	    if(choisir == 2) {
	    	JOptionPane.showMessageDialog(null, "Les règles du jeu doivent être écrites !");
	    }
	   
	    if(choisir == 3) {
	    	System.exit(0);
	    }
	    }
	    }


	    
	

	static void highlight4(Island i, int x, int y) {
		
		if (Island.ile[x+1][y].getValeur()==8) {
			i.plateau.setHighlight(x+1, y, Color.blue);
		}
		if (Island.ile[x-1][y].getValeur()==8) {
			i.plateau.setHighlight(x-1, y, Color.blue);
		}
		if (Island.ile[x][y+1].getValeur()==8) {
			i.plateau.setHighlight(x, y+1, Color.blue);
		}
		if (Island.ile[x][y-1].getValeur()==8) {
			i.plateau.setHighlight(x, y-1, Color.blue);
		}
	}
	static void highlight8(Island i, int x, int y) {
		highlight4(i,x,y);
		if (Island.ile[x-1][y-1].getValeur()==8) {
			i.plateau.setHighlight(x-1, y-1, Color.blue);
		}
		if (Island.ile[x+1][y-1].getValeur()==8) {
			i.plateau.setHighlight(x+1, y-1, Color.blue);
		}
		if (Island.ile[x-1][y+1].getValeur()==8) {
			i.plateau.setHighlight(x-1, y+1, Color.blue);
		}
		if (Island.ile[x+1][y+1].getValeur()==8) {
			i.plateau.setHighlight(x+1, y+1, Color.blue);
		}
	}	
}