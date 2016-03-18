import java.util.Random;
import java.awt.event.InputEvent ;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class EssaiPlateau {
	public static void main(String[] args) {
		Random r=new Random();
		int tailleX=12;
		int tailleY=15;
		String[] gifs={"images/un.gif","images/deux.gif","images/trois.gif","images/quatre.gif"};
		
		Plateau[] grille = new Plateau[2] ;
		grille[0] = new Plateau(gifs,10, true);
		grille[1] = new Plateau(gifs,10, false);

		int[][] jeu=new int[tailleX][tailleY];
		for (int e = 0 ; e < 2 ; e++) {
	  		for (int i=0;i<tailleX;i++)
				for (int j=0;j<tailleY;j++)
					jeu[i][j]=r.nextInt(gifs.length+1);
			grille[e].setJeu(jeu);
		}
		
    grille[0].println("Hello world !!") ;
    grille[0].println("This is a new day !") ;
    grille[0].println("And again ...") ;
    grille[0].println("And again ...") ;
    grille[0].println("And again ...") ;
    grille[0].println("And again ...") ;
    
	int equipe = 0 ;
	boolean finished = false ;
    do {
        InputEvent event ;
        grille[equipe].println("A vous (ESC pour finir)") ;
    	grille[equipe].affichage();
        event=  grille[equipe].waitEvent(20000);
        if (event instanceof MouseEvent) {
        	int x = grille[equipe].getX((MouseEvent) event) ;
        	int y = grille[equipe].getY((MouseEvent) event) ;
        	grille[equipe].println("ligne " + x + " colonne : " + y ) ;
        } else if (event instanceof KeyEvent) {
        	grille[equipe].println(event.toString()) ;
        	int keyCode = ((KeyEvent) event).getKeyCode() ;
        	if (keyCode == 27) { // test escape key
        		finished = true ;
        	}
        }
        event = grille[equipe].waitEvent(1000) ;	// Délai pour permettre la lecture.
    	grille[equipe].masquer();
    	equipe = 1-equipe ; // Passe à l'équipe suivante.
    } while (! finished) ;
    grille[0].close() ;
    grille[1].close() ;
    
}
}
