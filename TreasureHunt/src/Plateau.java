import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

/**
 * La classe Plateau permet d'afficher un plateau de Jeu carré
 * sur lequel sont disposés des images représentant les éléments du jeu
 * Les images sont toutes de même taille et carrées. Optionellement, on peut y associer 
 * une zone d'affichage de texte et caturer les entrées (souris / clavier) de l'utilisateur.
 * @author M2103-Team
 */
public class Plateau {
	private static final long serialVersionUID = 1L;
	private JFrame window ;
	private GraphicPane graphic ;
	private ConsolePane console ;
	/**
	 *  Attribut ou est enregistré un événement observé. Cet attribut est
	 * initialisé à null au début de la scrutation et rempli par l'événement observé 
	 * par les deux listeners (mouseListener et keyListener). 
	 * cf {@link java.awt.event.InputEvent}.
	 */
	private InputEvent currentEvent = null ;
	/**
	 * Classe interne MouseListener. Quand instanciée et associée à un JPanel, elle
	 * répond à un événement souris en stockant cet événement dans l'attribut 
	 * {@link #currentEvent}.
	 * @author place
	 *
	 */
	private class Mouse implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent event) {
			currentEvent = event ;
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {	}
		@Override
		public void mouseExited(MouseEvent arg0) { }
		@Override
		public void mousePressed(MouseEvent arg0) { }
		@Override
		public void mouseReleased(MouseEvent arg0) { }
	}
	/**
	 * Classe interne keyListener. Quand instanciée et associée à une JFrame, elle
	 * répond à un événement clavier en le stockant dans la variable {@link #currentEvent}.
	 * @author place
	 *
	 */
	private class Key implements KeyListener {
		@Override
		public void keyPressed(KeyEvent event) {
			currentEvent = event ;
		}
		@Override
		public void keyReleased(KeyEvent e) {
		}
		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
	/**
	 * Construit un plateau de jeu vide de dimension taille x taille.
	 * Initialement, les cellules sont vides. Le constructeur demande la fourniture
	 * d'un catalogue d'images gif ou png. La fermeture de la fenêtre provoque uniquement le
	 * masquage de celle-ci. La destruction complète doit être faite explicitement par programme via 
	 * la méthode {@link #close()}.
	 * @param gif tableau 1D des chemins des fichiers des différentes images affichées.
	 * @param taille dimension (en nombre de cellules) d'un côté du plateau.
	 */
	public Plateau(String[] gif,int taille){
		this(gif, taille, false) ;
	}
	/**
	 * Construit un plateau de jeu vide de dimension taille x taille aec une éventuelle zone de texte associée.
	 * Initialement, les cellules sont vides. Le constructeur demande la fourniture
	 * d'un catalogue d'images gif ou png.
	 * @param gif tableau 1D des chemins des fichiers des différentes images affichées.
	 * @param taille Dimension (en nombre de cellules) d'un côté du plateau.
	 * @param withTextArea Indique si une zone de texte doit être affichée.
	 */
	public Plateau(String[] gif,int taille, boolean withTextArea){
		// Instancie la fenetre principale et et les deux composants.
		window = new JFrame() ;
		graphic = new GraphicPane(gif, taille) ;
		console = null ;

		// Caractéristiques initiales pour la fenetre.
		window.setTitle("Treasure Hunt");
		window.setLocationRelativeTo(null);
		window.setLayout(new BorderLayout());
		// La fermeture de la fenetre ne fait que la cacher. 
		// cf Javadoc setDefaultCloseOperation
		window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		// Ajout des deux composants à la fenetre
		window.getContentPane().add(graphic, BorderLayout.NORTH);
		if (withTextArea) {
			console = new ConsolePane() ;
			window.getContentPane().add(console) ;
		}
		resizeFromGraphic() ;

		// Affichage effectif 
		window.setVisible(true);
		// Ajout des listeners.
		graphic.addMouseListener(new Mouse());
		window.addKeyListener(new Key()) ;
		currentEvent = null ;
	}
	/**
	 * Méthode permettant de placer les éléments sur le plateau. Le tableau doit être  
	 * de même taille que la dimension déclarée via le constructeur.
	 * @param jeu tableau 2D représentant le plateau  
	 * la valeur numérique d'une cellule désigne l'image correspondante
	 * dans le tableau des chemins (décalé de un, 0 désigne une case vide)
	 */
	public void setJeu(int[][] jeu){
		graphic.setJeu(jeu) ;	// Délégué au composant graphic.
		resizeFromGraphic() ;
	}
	/**
	 * Retourne le tableau d'entiers représentant le plateau
	 * @return le tableau d'entiers
	 */
	public int[][] getJeu(){
		return graphic.getJeu() ;	// Délégué au composant graphic.
	}
	/**
	 * Demande l'affichage du plateau de jeu. 
	 * Si la fenêtre était cachée, elle redevient visible.
	 */
	public void affichage(){ 
		window.setVisible(true);	// Révèle la fenêtre.
		window.repaint(); 			// Délégué à Swing (appelle indirectement graphic.paintComponent via Swing)
	}
	/**
	 * prépare l'attente d'événements Swing (clavier ou souris).
	 * Appelé par waitEvent() et waitEvent(int).
	 */
	private void prepareWaitEvent() {
		currentEvent = null ;	// Annule tous les événements antérieurs
		window.requestFocusInWindow() ;
		affichage() ;	// Remet à jour l'affichage (peut être optimisé)
	}
	/**
	 * Attends (au maximum timeout ms) l'apparition d'une entrée (souris ou clavier).
	 * @param timeout La durée maximale d'attente.
	 * @return L'événement observé si il y en a eu un, <i>null</i> sinon.
	 */
	public InputEvent waitEvent(int timeout) {
		int time = 0 ;
		prepareWaitEvent() ;
		while ((currentEvent == null) && (time < timeout)) {
			try {
				Thread.sleep(100) ;	// Cette instruction - en plus du délai induit - permet à Swing de traiter les événements GUI 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			time += 100 ;
		}
		return currentEvent ;
	}
	/**
	 * Attends (indéfiniment) un événement clavier ou souris. 
	 * @return L'événement observé.
	 */
	public InputEvent waitEvent() {
		prepareWaitEvent() ;
		while (currentEvent == null) {
			Thread.yield() ;	// Redonne la main à Swing pour gérer les événements
		}
		return currentEvent ;
	}
	public void println(String message) {
		if (console != null) {
			console.println(message) ;
		}
	}
	/**
	 * Provoque la destruction du plateau. 
	 * L'arrêt du programme est conditionné par la fermeture de tous les plateaux ouverts.
	 */
	public void close() {
		window.dispose();
	}
	/**
	 * Provoque le masquage du plateau.
	 * Le plateau est conservé en mémoire et peut être réaffiché par {@link #affichage()}.
	 */
	public void masquer() {
		window.setVisible(false);
	}
	/**
	 * Calcule la ligne de la case ciblée par un mouseEvent.
	 * @param event
	 * @return le numéro de la ligne ciblée (0 à taille-1)
	 */
	public int getX(MouseEvent event) {
		return graphic.getX(event) ;
	}
	/**
	 * Calcule la colonne de la case ciblée par un mouseEvent.
	 * @param event
	 * @return le numéro de la colonne ciblée (0 à taille-1)
	 */
	public int getY(MouseEvent event) { 	
		return graphic.getY(event) ;
	}

	// Note la taille initiale est calculée d'après la taille du graphique.
	private void resizeFromGraphic() {
		Dimension dim = graphic.getGraphicSize() ;
		if (console == null) {
			dim.height += 10 ;
		} else {
			dim.height += 150 ;
		}
		System.out.println(dim) ;
		window.getContentPane().setPreferredSize(dim) ;
		window.pack() ;
	}
}