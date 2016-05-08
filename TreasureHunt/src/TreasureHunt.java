import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

//Pour les déplacements, il y a un inversement des cases, donc ça fonctionne pas MDLOL

/**
 * Classe contenant le main qui sert à lancer la partie et appeler les diverses 
 * méthodes d'autre classes (ainsi que les méthodes de highlight désignée dans cette classe). 
 * @author Team-F5
 */

public class TreasureHunt {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		
		MenuTreasureHunt instance = new MenuTreasureHunt();
		String[] choix = {"Lancer", "Tester déplacement", "Règles", "Quitter"};
//LE CODE NE FONCTIONNE PAS ACTUELLEMENT, IL FAUT QUE JE TROUVE COMMENT FAIRE PASSER LE instance EN
// PRIORITE, CAR SI IL EST PLACE APRES LE CHOISIR == 0, IL Y A ERREUR ET SI PLACE LA, LE JOP A LA PRIORITE...
		int choisir = JOptionPane.showOptionDialog(null, "Quel est votre choix ?", "Bienvenue !", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
	   	if(choisir == 0) {
	   		
	   		InputEvent evenement;
	   		Island equipe = new Island(instance.ile);
	   		boolean fin = false;
	   		int[] res = new int[4];
	   		int jActif = 0;
	   		char ch;
	   		
	   		do {
	   			if (jActif == 0) { //J1 Clic1
	   				do {
	   					equipe.affichageGraphique();
	   					equipe.plateau.println("C'est au tour du joueur 1 !");
	   					evenement = equipe.plateau.waitEvent();
	   					if (evenement instanceof MouseEvent) {
	   						res[0]=equipe.plateau.getX((MouseEvent) evenement) ;
	   						res[1]=equipe.plateau.getY((MouseEvent) evenement) ;
	   					}
	   				} while(equipe.getValeur(res[0], res[1]) == 1 || equipe.getValeur(res[0], res[1]) == 2  || equipe.getValeur(res[0], res[1]) == 3 || equipe.getValeur(res[0], res[1]) == 4  || equipe.getValeur(res[0], res[1]) == 6  || equipe.getValeur(res[0], res[1]) == 7 || equipe.getValeur(res[0], res[1]) == 8 || equipe.getValeur(res[0], res[1])==9 || equipe.getValeur(res[0], res[1]) == 11);
	   			} else { //J2 Clic1
	   				do {
	   					equipe.affichageGraphique();
	   					equipe.plateau.println("C'est au tour du joueur 2 !");
	   					evenement = equipe.plateau.waitEvent();
	   					if (evenement instanceof MouseEvent) {
	   						res[0]=equipe.plateau.getX((MouseEvent) evenement) ;
	   						res[1]=equipe.plateau.getY((MouseEvent) evenement) ;
	   					}
	   				} while(equipe.getValeur(res[0], res[1]) == 1 || equipe.getValeur(res[0], res[1]) == 2  || equipe.getValeur(res[0], res[1]) == 3  || equipe.getValeur(res[0], res[1]) == 4  || equipe.getValeur(res[0], res[1]) == 5 || equipe.getValeur(res[0], res[1]) == 6 || equipe.getValeur(res[0], res[1]) == 8 || equipe.getValeur(res[0], res[1])==9 || equipe.getValeur(res[0], res[1]) == 10);
	   			}
	   			equipe.affichageGraphique();
	   			//Affichage case sélectionnée au premier clic
   				ch = (char) (res[0]+64);
   				equipe.plateau.print("Case : "+res[1]+ ch);
   				//Highligh Explorateur
   				if (Island.ile[res[0]][res[1]].getValeur()==5 || Island.ile[res[0]][res[1]].getValeur()==7) {
   					highlight4(equipe, res[0],res[1]);
   				}
   				//Highlight Voleur
   				if (Island.ile[res[0]][res[1]].getValeur()==10 || Island.ile[res[0]][res[1]].getValeur()==11) {
   					highlight8(equipe, res[0], res[1]);
   				}
   				boolean clic2 = false;
   				do{
   					evenement =  equipe.plateau.waitEvent();

   					res[2]=equipe.plateau.getX((MouseEvent) evenement) ;
   					res[3]=equipe.plateau.getY((MouseEvent) evenement) ;
   					if ((res[3] == res[1]+1 && res[2] == res[0]) || (res[3] == res[1]-1 && res[2] == res[0]) || (res[3] == res[1] && res[2] == res[0]+1) || (res[3] == res[1] && res[2] == res[0]-1) || (res[3] == res[1]+1 && res[2] == res[0]+1) || (res[3] == res[1]-1 && res[2] == res[0]+1) || (res[3] == res[1]+1 && res[2] == res[0]-1) || (res[3] == res[1]-1 && res[2] == res[0]-1)) {
   						clic2 = true;
   						
   						char ch2 = (char) (res[2]+64);
   						equipe.plateau.println("; "+res[3]+ ch2);
   						evenement = equipe.plateau.waitEvent(1000);
   					}   					
   				} while (!clic2);
   				if (equipe.getValeur(res[0], res[1]) == 5 || equipe.getValeur(res[0], res[1]) == 7 || equipe.getValeur(res[0], res[1]) == 10 || equipe.getValeur(res[0], res[1]) == 11 || equipe.getValeur(res[0], res[1]) == 12 || equipe.getValeur(res[0], res[1]) == 13  || equipe.getValeur(res[0], res[1]) == 14 || equipe.getValeur(res[0], res[1]) == 15) {
   					
   					if ((res[3] == res[1]-1 && res[2] == res[0]-1 && (equipe.getValeur(res[0], res[1]) == 10 || equipe.getValeur(res[0], res[1]) == 11)) || (res[3] == res[1]-1 && res[2] == res[0]+1 && (equipe.getValeur(res[0], res[1]) == 10 || equipe.getValeur(res[0], res[1]) == 11)) || (res[3] == res[1]+1 && res[2] == res[0]-1 && (equipe.getValeur(res[0], res[1]) == 10 || equipe.getValeur(res[0], res[1]) == 11)) || (res[3] == res[1]+1 && res[2] == res[0]+1 && (equipe.getValeur(res[0], res[1]) == 10 || equipe.getValeur(res[0], res[1]) == 11)) || (res[3] == res[1] && res[2] == res[0]-1) || (res[3] == res[1] && res[2] == res[0]+1) || (res[3] == res[1]+1 && res[2] == res[0]) || (res[3] == res[1]-1 && res[2] == res[0])) {
   						deplacement(equipe, res[0], res[1], res[2], res[3]);
   						}
   					if (evenement instanceof KeyEvent) {
   						int keyCode = ((KeyEvent) evenement).getKeyCode() ;
   						if (keyCode == 27) { // equipe escape key
   							fin = true ;
   						}
   					}
   				}
   				if (jActif == 0) {
   					jActif = 1;
   				} else {
   					jActif = 0;
   				}
   				
   				
   				for (int i = 1; i < equipe.getXIle()+1; i++){
   					if (equipe.ile[i][2].getPerso() != null) {
	   					if (equipe.ile[i][2].getValeur() == 4 && equipe.ile[i][2].getPerso().possedeTresor) {
	   						fin = true;
	   						JOptionPane.showMessageDialog(null, "Le joueur 1 a gagné, il a ramené le trésor à son navire !");
	   					}
	   				}
   				}
   				for (int i = 1; i < equipe.getXIle()+1; i++){
   					if (equipe.ile[i][2].getPerso() != null) {
	   					if (equipe.ile[i][equipe.getYIle()-2].getValeur() == 6 && equipe.ile[i][equipe.getYIle()-2].getPerso().possedeTresor) {
	   						fin = true;
	   						JOptionPane.showMessageDialog(null, "Le joueur 2 a gagné, il a ramené le trésor à son navire !");
	   					}
	   				}
   				}
   				//Ne sera utile qu'après avoir remanié les données
   				/*if (nbPersoJ1 == 0) {
   					fin = true;
   					JOptionPane.showMessageDialog(null, "Le joueur 2 a gagné, il a vaincu l'équipe adverse !");
   				}
   				if (nbPersoJ2 == 0) {
   					fin = true;
   					JOptionPane.showMessageDialog(null, "Le joueur 1 a gagné, il a vaincu l'équipe adverse !");
   				}*/
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
				} while(test.getValeur(res[0], res[1]) == 1 || test.getValeur(res[0], res[1]) == 2  || test.getValeur(res[0], res[1]) == 3  || /*test.getValeur(res[0], res[1]) == 4  || test.getValeur(res[0], res[1]) == 6  ||*/ test.getValeur(res[0], res[1]) == 8 || test.getValeur(res[0], res[1])==9);

				char ch = (char) (res[0]+64);
					
				System.out.print("Case : "+res[1]+ ch);
				int perso=-1 ;
				if (Island.ile[res[0]][res[1]].getValeur()==5 || Island.ile[res[0]][res[1]].getValeur()==7) {
					highlight4(test, res[0],res[1]);
				}
				if (Island.ile[res[0]][res[1]].getValeur()==10 || Island.ile[res[0]][res[1]].getValeur()==11 ) {

					highlight8(test, res[0], res[1]);
				}
				if(Island.ile[res[0]][res[1]].getValeur()==4 || Island.ile[res[0]][res[1]].getValeur()==6){
					perso=menuNavire(test, res[0] , res[1]);


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
				if(perso==-1 ){
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
							}
							test.plateau.masquer();
							test.affichageGraphique();
							turn++;
							
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
				}else{
						if (res[3] == res[1]+1 && res[2] == res[0]) {
							if(Island.ile[res[2]][res[3]].getValeur()!=8){
								JOptionPane.showMessageDialog(null, "Impossible !");
								for (int i = 0; i < test.getXIle(); i++) {
									for (int j = 0; j < test.getYIle(); j++){
										test.plateau.resetHighlight(i, j);
									}							
								}
							} else {
								if(perso==5){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 1));
									System.out.println(test.affichage(res[2], res[3]));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 2));
								}
								if(perso==10){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 1));
								}
								if(perso==11){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 2));
								}
								if(perso==12){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 1));
								}
								if(perso==13){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 2));
								}
								if(perso==14){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 2));
								}
								for(int i=0;i<test.getXIle();i++){
									for(int j=0;j<test.getYIle();j++){
										test.plateau.resetHighlight(i, j);
									}
								}
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
								if(perso==5){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 2));
								}
								if(perso==10){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 1));
								}
								if(perso==11){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 2));
								}
								if(perso==12){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 1));
								}
								if(perso==13){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 2));
								}
								if(perso==14){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 2));
								}
								for(int i=0;i<test.getXIle();i++){
									for(int j=0;j<test.getYIle();j++){
										test.plateau.resetHighlight(i, j);
									}
								}
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
								if(perso==5){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 2));
								}
								if(perso==10){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 1));
								}
								if(perso==11){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 2));
								}
								if(perso==12){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 1));
								}
								if(perso==13){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 2));
								}
								if(perso==14){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 2));
								}											
								for(int i=0;i<test.getXIle();i++){
									for(int j=0;j<test.getYIle();j++){
										test.plateau.resetHighlight(i, j);
									}
								}
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
								if(perso==5){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Explorateur(res[2], res[3], 2));
								}
								if(perso==10){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 1));
								}
								if(perso==11){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Voleur(res[2], res[3], 2));
								}
								if(perso==12){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 1));
								}
								if(perso==13){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Piegeur(res[2], res[3], 2));
								}
								if(perso==14){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 1));
								}
								if(perso==7){
									test.ile[res[2]][res[3]].setValeur(perso);
									test.ile[res[2]][res[3]].setPersonnage(new Guerrier(res[2], res[3], 2));
								}				
								for(int i=0;i<test.getXIle();i++){
									for(int j=0;j<test.getYIle();j++){
										test.plateau.resetHighlight(i, j);
									}
								}
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


	    
	


	private static int menuNavire(Island test, int i, int j) {
		int perso = 0;
		String[] choix=new String[]{"Explorateur","Voleur","Guerrier","Piégeur","Sortir"};
		if(test.getValeur(i, j)==4){
			perso = JOptionPane.showOptionDialog(null, "J1 Quel personnage souhaitez vous débarquez :" , "Debarquement de personnage", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, choix,choix[0]);
			if(perso==0){
				highlight4(test,i,j);
				return 5;
				
			}
			if(perso==1){
				highlight4(test,i,j);
				return 10;
				
			}
			if(perso==2){
				highlight4(test,i,j);
				return 14;
				
			}
			if(perso==3){
				highlight4(test,i,j);
				return 12;
			}
		}else{
			perso = JOptionPane.showOptionDialog(null, "J2 Quel personnage souhaitez vous débarquez :" , "Debarquement de personnage", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null, choix,choix[0]);			
			if(perso==0){
				highlight4(test,i,j);
				return 7;
				
			}
			if(perso==1){
				highlight4(test,i,j);
				return 11;
				
			}
			if(perso==2){
				highlight4(test,i,j);
				return 15;
			}
			if(perso==3){
				highlight4(test,i,j);
				return 13;
				
			}
		}
		return -1;
		
		

	}







	/**
	 * Méthode permettant de mettre en surbrillance les cases aux points cardinaux si celles-ci sont accessibles.
	 * @param i Ile sur laquelle apporter la modification
	 * @param x position X voulue
	 * @param y position Y voulue
	 */
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
	/**
	 * Méthode reprenant highlight4 et y ajoutant les 4 cases restantes entourant la cible du clic.
	 * @param i Ile sur laquelle apporter la modification
	 * @param x position X voulue
	 * @param y position Y voulue
	 */
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
	
	private static void deplacement (Island joueur, int res0, int res1, int res2, int res3) {
		if(Island.ile[res2][res3].getValeur()!=8){
				JOptionPane.showMessageDialog(null, "Impossible !");
				for (int i = 0; i < joueur.getXIle(); i++) {
					for (int j = 0; j < joueur.getYIle(); j++){
						joueur.plateau.resetHighlight(i, j);
					}							
				}
			} else {
				//Valeur de la première case => temp
				int temp = joueur.getValeur(res0, res1);
				//Valeur de la deuxième case => première case
				joueur.changement(joueur.getValeur(res2, res3), res0, res1);
				// Valeur temp => deuxième case
				joueur.changement(temp, res2, res3);
				joueur.ile[res2][res3].setPersonnage(joueur.ile[res0][res1].getPerso());
				joueur.ile[res2][res3].setPersonnage(null);
								
				joueur.plateau.masquer();
				}
	}
}