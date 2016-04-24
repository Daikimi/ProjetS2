import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Classe héritant de JScrollPane permettant d'afficher une console dans le jeu.
 * @author M2103-Team (et Team-F5 pour un ajout)
 */
class ConsolePane extends JScrollPane {
	private static final long serialVersionUID = 3L;
	private JTextArea textArea ;
	public ConsolePane() {
		super() ;
		textArea = new JTextArea() ;
		textArea.setEditable(false) ;
		textArea.setFocusable(false) ;
		textArea.setText("Console:\n") ;
		this.setViewportView(textArea) ;
	}
	/**
	 * Méthode permettant d'afficher un message puis de provoquer un retour à la ligne.
	 * @param message message écrit dans la console
	 */
	public void println(String message) {
		textArea.append(message + '\n') ;
		// Positionne la scrollPane à son extrémité inférieure.
		JScrollBar vertical = this.getVerticalScrollBar() ;
		vertical.setValue(vertical.getMaximum()) ;
	}
	/**
	 * Méthode permettant d'afficher un message.
	 * @param message message écrit dans la console
	 */
	public void print(String message) {
		textArea.append(message) ;
		// Positionne la scrollPane à son extrémité inférieure.
		JScrollBar vertical = this.getVerticalScrollBar() ;
		vertical.setValue(vertical.getMaximum()) ;
	}
}
