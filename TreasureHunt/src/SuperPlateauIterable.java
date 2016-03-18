import java.awt.event.InputEvent;
import java.util.Iterator;
/**
 * @author "2103-Team"
 *
 */
public class SuperPlateauIterable implements Iterable<Integer> {

	public Iterator<Integer> iterator() {
		return new PlateauIterator(plateau.getJeu());
	}
	
	private Plateau plateau;

	public SuperPlateauIterable(String[] gif,int taille){
		plateau = new Plateau(gif,taille);
	}

	public SuperPlateauIterable(String[] gif,int taille, boolean withTextArea){
		plateau = new Plateau(gif,taille, withTextArea);
	}

	public void setJeu(int[][] jeu) {
		plateau.setJeu(jeu);
	}

	public int[][] getJeu() {
		return plateau.getJeu();
	}

	public void affichage() {
		plateau.affichage();
	}
	
	public boolean deplacer(int x,int y,int a, int b){
		int[][] jeu;
		if (a==x && b==y) return false;
		jeu=plateau.getJeu();
		if (jeu[a][b]!=0)  return false;
		jeu[a][b]=jeu[x][y];
		jeu[x][y]=0;
		plateau.setJeu(jeu);
		return true ;
	}
	public InputEvent waitEvent() {
		return plateau.waitEvent() ;
	}
	public InputEvent waitEvent(int timeout) {
		return plateau.waitEvent(timeout) ;
	}
	public void println(String message) {
		plateau.println(message) ;
	}
	public void close() {
		plateau.close() ;
	}

}

