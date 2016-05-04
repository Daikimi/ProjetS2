import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JTextPane;

public class MenuTreasureHunt {
	
	public MenuTreasureHunt() {
		JFrame fenetre = new JFrame("Menu Treasure Hunt");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar;
		JMenu accueil, regles, j1, j2, options;
		JLabel labelAccueil, labelRegles, labelJ1, labelJ2, labelOptions;
		JButton jouerAccueil, quitterAccueil;
		labelAccueil = new JLabel();
		labelRegles = new JLabel("<html> Test <br> Test </html>");
		labelJ1 = new JLabel("<html> Test2 <br> Test2 </html>");
		labelJ2 = new JLabel("<html> Test3 <br> Test3 </html>");
		labelOptions = new JLabel("<html> Test4 <br> Test4 </html>");
		
		// DEBUT labelAccueil
		labelAccueil.setLayout(new BoxLayout(labelAccueil, BoxLayout.X_AXIS));
		jouerAccueil = new JButton("Jouer");
		quitterAccueil = new JButton("Quitter");
		quitterAccueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelAccueil.add(Box.createHorizontalGlue());
		labelAccueil.add(jouerAccueil);
		labelAccueil.add(Box.createHorizontalGlue());
		labelAccueil.add(quitterAccueil);
		labelAccueil.add(Box.createHorizontalGlue());
		fenetre.getContentPane().add(labelRegles);
		labelRegles.setVisible(false);
		fenetre.getContentPane().add(labelJ1);
		labelJ1.setVisible(false);
		fenetre.getContentPane().add(labelJ2);
		labelJ2.setVisible(false);
		fenetre.getContentPane().add(labelOptions);
		labelOptions.setVisible(false);
		fenetre.getContentPane().add(labelAccueil);
		// FIN labelAccueil
		
		// DEBUT labelRegles
		// Les règles sont rédigées plus haut.		
		// FIN labelRegles
		
		//DEBUT labelJ1
		/*JLabel gaucheJ1, droiteJ1;
		JSlider explorateurSlider, voleurSlider, piegeurSlider, guerrierSlider;
		explorateurSlider = new JSlider(0, 4);
		voleurSlider = new JSlider(0, 4);
		piegeurSlider = new JSlider(0, 4);
		guerrierSlider = new JSlider(0, 4);
	
		gaucheJ1 = new JLabel();
		droiteJ1 = new JLabel();
		gaucheJ1.setLayout(new BoxLayout(gaucheJ1, BoxLayout.Y_AXIS));
		droiteJ1.setLayout(new BoxLayout(droiteJ1, BoxLayout.Y_AXIS));
		droiteJ1.add(explorateurSlider);
		droiteJ1.add(voleurSlider);
		droiteJ1.add(piegeurSlider);
		droiteJ1.add(guerrierSlider);
		labelJ1.add(droiteJ1, BorderLayout.WEST);*/
		
		
		//FIN labelJ1
		
		//DEBUT labelJ2
		
		//FIN labelJ2
		
		//DEBUT labelOptions
		
		//FIN labelOptions
		
		menuBar = new JMenuBar();
		accueil = new JMenu("Accueil");
		
		accueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(labelAccueil);
				labelAccueil.setVisible(true);
				labelRegles.setVisible(false);
				labelJ1.setVisible(false);
				labelJ2.setVisible(false);
				labelOptions.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		regles = new JMenu("Règles");
		regles.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(labelRegles);
				labelRegles.setVisible(true);
				labelAccueil.setVisible(false);
				labelJ1.setVisible(false);
				labelJ2.setVisible(false);
				labelOptions.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		j1 = new JMenu("Joueur 1");
		accueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(labelJ1);
				labelJ1.setVisible(true);
				labelAccueil.setVisible(false);
				labelRegles.setVisible(false);
				labelJ2.setVisible(false);
				labelOptions.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		j2 = new JMenu("Joueur 2");
		accueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(labelJ2);
				labelJ2.setVisible(true);
				/*labelAccueil.setVisible(false);
				labelJ1.setVisible(false);
				labelRegles.setVisible(false);
				labelOptions.setVisible(false);*/
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		options = new JMenu("Options de Jeu");
		accueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(labelOptions);
				labelOptions.setVisible(true);
				/*labelAccueil.setVisible(false);
				labelJ1.setVisible(false);
				labelJ2.setVisible(false);
				labelRegles.setVisible(false);*/
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		menuBar.add(accueil);
		menuBar.add(regles);
		menuBar.add(j1);
		menuBar.add(j2);
		menuBar.add(options);
		
		fenetre.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		fenetre.setPreferredSize(new Dimension(800,100));
	    fenetre.pack();
	    fenetre.setVisible(true);
	}
	
	 public static void main(String[] args) {
	      //Schedule a job for the event-dispatching thread:
	      //creating and showing this application’s GUI.
	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	          new MenuTreasureHunt();
	        }
	    });
	  }

}
