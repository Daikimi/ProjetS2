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
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//TODO Remplir les listeners pour récupérer les valeurs.
//TODO Finir les règles.
//TODO Créer les tests.

public class MenuTreasureHunt {
	
	public MenuTreasureHunt() {
		JFrame fenetre = new JFrame("Menu Treasure Hunt");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar;
		JMenu accueil, regles, j1, j2, options, test;
		JPanel accueilPanel, reglesPanel, j1Panel, j2Panel, optionsPanel, testPanel;
		JButton jouerAccueil, quitterAccueil;
		JLabel reglesLabel;
		
		accueilPanel = new JPanel();
		reglesPanel = new JPanel();
		j1Panel = new JPanel();
		j2Panel = new JPanel();
		optionsPanel = new JPanel();
		testPanel = new JPanel();
		

		
		// DEBUT Accueil
		accueilPanel.setLayout(new BoxLayout(accueilPanel, BoxLayout.X_AXIS));
		jouerAccueil = new JButton("Jouer");
		quitterAccueil = new JButton("Quitter");
		quitterAccueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		accueilPanel.add(Box.createHorizontalGlue());
		accueilPanel.add(jouerAccueil);
		accueilPanel.add(Box.createHorizontalGlue());
		accueilPanel.add(quitterAccueil);
		accueilPanel.add(Box.createHorizontalGlue());
		fenetre.getContentPane().add(accueilPanel);
		// FIN Accueil
		
		// DEBUT Regles
		reglesLabel = new JLabel("<html> Test <br> OLOLOLZ </html>");
		reglesPanel.add(reglesLabel);
		// FIN Regles
		
		//DEBUT J1
		j1Panel.setLayout(new BoxLayout(j1Panel, BoxLayout.X_AXIS));
		JPanel gaucheJ1, droiteJ1;
		JSlider explorateurSliderJ1, voleurSliderJ1, piegeurSliderJ1, guerrierSliderJ1;
		JLabel explorateurLabelJ1, voleurLabelJ1, piegeurLabelJ1, guerrierLabelJ1;
		
		explorateurSliderJ1 = new JSlider(0, 4, 0);
		voleurSliderJ1 = new JSlider(0, 4, 0);
		piegeurSliderJ1 = new JSlider(0, 4, 0);
		guerrierSliderJ1 = new JSlider(0, 4, 0);
		
		explorateurLabelJ1 = new JLabel();
		voleurLabelJ1 = new JLabel();
		piegeurLabelJ1 = new JLabel();
		guerrierLabelJ1 = new JLabel();
	
		gaucheJ1 = new JPanel();
		droiteJ1 = new JPanel();
		
		gaucheJ1.setLayout(new BoxLayout(gaucheJ1, BoxLayout.Y_AXIS));
		
		explorateurLabelJ1.setText("Nombre d'explorateurs : " +explorateurSliderJ1.getValue());
		gaucheJ1.add(explorateurLabelJ1);
		gaucheJ1.add(Box.createVerticalGlue());
		
		voleurLabelJ1.setText("Nombre de voleurs : " +voleurSliderJ1.getValue());
		gaucheJ1.add(voleurLabelJ1);
		gaucheJ1.add(Box.createVerticalGlue());
		
		piegeurLabelJ1.setText("Nombre de piègeurs : " +piegeurSliderJ1.getValue());
		gaucheJ1.add(piegeurLabelJ1);
		gaucheJ1.add(Box.createVerticalGlue());
		
		guerrierLabelJ1.setText("Nombre de guerriers : "+guerrierSliderJ1.getValue());
		gaucheJ1.add(guerrierLabelJ1);
		gaucheJ1.add(Box.createVerticalGlue());
		
		droiteJ1.setLayout(new BoxLayout(droiteJ1, BoxLayout.Y_AXIS));
		
		JPanel explorateurPanelJ1 = new JPanel();
		explorateurPanelJ1.add(Box.createHorizontalGlue());
		explorateurPanelJ1.add(explorateurSliderJ1);
		explorateurSliderJ1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				explorateurLabelJ1.setText("Nombre d'explorateurs : "+explorateurSliderJ1.getValue());
			}
		});
		explorateurPanelJ1.add(Box.createHorizontalGlue());
		
		JPanel voleurPanelJ1 = new JPanel();
		voleurPanelJ1.add(Box.createHorizontalGlue());
		voleurPanelJ1.add(voleurSliderJ1);
		voleurSliderJ1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				voleurLabelJ1.setText("Nombre de voleurs : "+voleurSliderJ1.getValue());
			}
		});
		voleurPanelJ1.add(Box.createHorizontalGlue());
		
		JPanel piegeurPanelJ1 = new JPanel();
		piegeurPanelJ1.add(Box.createHorizontalGlue());
		piegeurPanelJ1.add(piegeurSliderJ1);
		piegeurSliderJ1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				piegeurLabelJ1.setText("Nombre de piègeurs : "+piegeurSliderJ1.getValue());
			}
		});
		piegeurPanelJ1.add(Box.createHorizontalGlue());
		
		JPanel guerrierPanelJ1 = new JPanel();
		guerrierPanelJ1.add(Box.createHorizontalGlue());
		guerrierPanelJ1.add(guerrierSliderJ1);
		guerrierSliderJ1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				guerrierLabelJ1.setText("Nombre de guerriers : "+guerrierSliderJ1.getValue());
			}
		});
		guerrierPanelJ1.add(Box.createHorizontalGlue());
		
		droiteJ1.add(explorateurPanelJ1);
		droiteJ1.add(voleurPanelJ1);
		droiteJ1.add(piegeurPanelJ1);
		droiteJ1.add(guerrierPanelJ1);
		
		j1Panel.add(gaucheJ1);
		j1Panel.add(droiteJ1);
		//FIN J1
		
		//DEBUT J2
		j2Panel.setLayout(new BoxLayout(j2Panel, BoxLayout.X_AXIS));
		JPanel gaucheJ2, droiteJ2;
		JSlider explorateurSliderJ2, voleurSliderJ2, piegeurSliderJ2, guerrierSliderJ2;
		JLabel explorateurLabelJ2, voleurLabelJ2, piegeurLabelJ2, guerrierLabelJ2;
		
		explorateurSliderJ2 = new JSlider(0, 4, 0);
		voleurSliderJ2 = new JSlider(0, 4, 0);
		piegeurSliderJ2 = new JSlider(0, 4, 0);
		guerrierSliderJ2 = new JSlider(0, 4, 0);
		
		explorateurLabelJ2 = new JLabel();
		voleurLabelJ2 = new JLabel();
		piegeurLabelJ2 = new JLabel();
		guerrierLabelJ2 = new JLabel();
	
		gaucheJ2 = new JPanel();
		droiteJ2 = new JPanel();
		gaucheJ2.setLayout(new BoxLayout(gaucheJ2, BoxLayout.Y_AXIS));
		explorateurLabelJ2.setText("Nombre d'explorateurs : " +explorateurSliderJ2.getValue());
		gaucheJ2.add(explorateurLabelJ2);
		gaucheJ2.add(Box.createVerticalGlue());
		voleurLabelJ2.setText("Nombre de voleurs : " +voleurSliderJ2.getValue());
		gaucheJ2.add(voleurLabelJ2);
		gaucheJ2.add(Box.createVerticalGlue());
		piegeurLabelJ2.setText("Nombre de piègeurs : " +piegeurSliderJ2.getValue());
		gaucheJ2.add(piegeurLabelJ2);
		gaucheJ2.add(Box.createVerticalGlue());
		guerrierLabelJ2.setText("Nombre de guerriers : "+guerrierSliderJ2.getValue());
		gaucheJ2.add(guerrierLabelJ2);
		gaucheJ2.add(Box.createVerticalGlue());
		droiteJ2.setLayout(new BoxLayout(droiteJ2, BoxLayout.Y_AXIS));
		JPanel explorateurPanelJ2 = new JPanel();
		explorateurPanelJ2.add(Box.createHorizontalGlue());
		explorateurPanelJ2.add(explorateurSliderJ2);
		
		explorateurSliderJ2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				explorateurLabelJ2.setText("Nombre d'explorateurs : "+explorateurSliderJ2.getValue());
			}
		});
		explorateurPanelJ2.add(Box.createHorizontalGlue());
		JPanel voleurPanelJ2 = new JPanel();
		voleurPanelJ2.add(Box.createHorizontalGlue());
		voleurPanelJ2.add(voleurSliderJ2);
		voleurSliderJ2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				voleurLabelJ2.setText("Nombre de voleurs : "+voleurSliderJ2.getValue());
			}
		});
		voleurPanelJ2.add(Box.createHorizontalGlue());
		JPanel piegeurPanelJ2 = new JPanel();
		piegeurPanelJ2.add(Box.createHorizontalGlue());
		piegeurPanelJ2.add(piegeurSliderJ2);
		piegeurSliderJ2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				piegeurLabelJ2.setText("Nombre de piègeurs : "+piegeurSliderJ2.getValue());
			}
		});
		piegeurPanelJ2.add(Box.createHorizontalGlue());
		JPanel guerrierPanelJ2 = new JPanel();
		guerrierPanelJ2.add(Box.createHorizontalGlue());
		guerrierPanelJ2.add(guerrierSliderJ2);
		guerrierSliderJ2.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				guerrierLabelJ2.setText("Nombre de guerriers : "+guerrierSliderJ2.getValue());
			}
		});
		guerrierPanelJ2.add(Box.createHorizontalGlue());
		
		droiteJ2.add(explorateurPanelJ2);
		droiteJ2.add(voleurPanelJ2);
		droiteJ2.add(piegeurPanelJ2);
		droiteJ2.add(guerrierPanelJ2);
		
		j2Panel.add(gaucheJ2);
		j2Panel.add(droiteJ2);
		//FIN J2
		
		//DEBUT Options
		JSlider taille, rochers;
		taille = new JSlider(10,15,10);
		rochers = new JSlider(10,14,10);
		
		//FIN Options
		
		//DEBUT Tests
		
		//FIN Tests
		
		menuBar = new JMenuBar();
		
		accueil = new JMenu("Accueil");
		accueil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(accueilPanel);
				accueilPanel.setVisible(true);
				reglesPanel.setVisible(false);
				j1Panel.setVisible(false);
			    j2Panel.setVisible(false);
				optionsPanel.setVisible(false);
				testPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		regles = new JMenu("Règles");
		regles.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(reglesPanel);
				accueilPanel.setVisible(false);
				reglesPanel.setVisible(true);
				j1Panel.setVisible(false);
				j2Panel.setVisible(false);
				optionsPanel.setVisible(false);
				testPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		j1 = new JMenu("Joueur 1");
		j1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				accueilPanel.setVisible(false);
				reglesPanel.setVisible(false);
				fenetre.getContentPane().add(j1Panel);
				j1Panel.setVisible(true);
				j2Panel.setVisible(false);
				optionsPanel.setVisible(false);
				testPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		j2 = new JMenu("Joueur 2");
		j2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(j2Panel);
				j2Panel.setVisible(true);
				accueilPanel.setVisible(false);
				j1Panel.setVisible(false);
				reglesPanel.setVisible(false);
				optionsPanel.setVisible(false);
				testPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		options = new JMenu("Options de Jeu");
		options.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(optionsPanel);
				optionsPanel.setVisible(true);
				accueilPanel.setVisible(false);
				j1Panel.setVisible(false);
				j2Panel.setVisible(false);
				reglesPanel.setVisible(false);
				testPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		test = new JMenu("Tests de Jeu");
		test.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fenetre.getContentPane().add(testPanel);
				testPanel.setVisible(true);
				optionsPanel.setVisible(false);
				accueilPanel.setVisible(false);
				j1Panel.setVisible(false);
				j2Panel.setVisible(false);
				reglesPanel.setVisible(false);
				fenetre.pack();
			    fenetre.setVisible(true);
			}
		});
		
		menuBar.add(accueil);
		menuBar.add(regles);
		menuBar.add(j1);
		menuBar.add(j2);
		menuBar.add(options);
		menuBar.add(test);
		
		fenetre.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		fenetre.setPreferredSize(new Dimension(800,300));
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
