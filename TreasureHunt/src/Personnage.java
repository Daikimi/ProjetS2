import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Classe abstraite permettant de créer un Personnage, celle-ci contient donc naturellement
 * les actions communes à tous les types de Personnages : Les déplacements et le repos.
 * La récupération du trésor n'est pas encore présente.
 * @author Team-F5
 */
abstract class Personnage{
	/**
	 * Attribut permettant de déterminer la postion X du Personnage.
	 */
	protected int posX;
	/**
	 * Attribut permettant de déterminer la position Y du Personnage.
	 */
	protected int posY;
	/**
	 * Attribut permettant de déterminer le niveau d'énergie du Personnage.
	 */
	protected int energie=100;
	/**
	 * Attribut permettant de déterminer l'équipe du Personnage.
	 */
	protected int equipe;
	/**
	 * Attribut permettant de déterminer si le Personnage possède la clé ou non.
	 */
	protected boolean possedeClef=false;
	/**
	 * Attribut permettant de déterminer si le Personnage possède le trésor ou non.
	 */
	protected boolean possedeTresor=false;
	
	protected boolean inBoat = true;
	
	protected boolean possedeArme = false;
	
	protected boolean possedePiege = false;
	
	/**
	 * Méthode de déplacement : Le coeur de la fonction se trouve dans TreasureHunt.
	 * L'appel à cette fonction permet la décrémentation de l'énergie du Personnage.
	 */
	public void deplacement() {
		energie--;
	} 
	/**
	 * Méthode permettant de regagner de l'énergie lorsque le personnage se trouve dans le navire.
	 */
	public void repos(Island i){
		if(i.ile[posX][posY].getValeur()==4 && energie<100 ){
			energie+=10;
		}
	}
	
	public boolean mort(){
		if(energie<=0){
			return true;
		}else{
			return false;
		}
	}
	
	public void vol(Personnage victime) {
		if(victime.possedeClef){
			victime.possedeClef=false;
			this.possedeClef=true;
			JOptionPane.showMessageDialog(null, "Vous avez volé la clé !");
		}else if(victime.possedeTresor){
			victime.possedeTresor=false;
			this.possedeTresor=true;
			JOptionPane.showMessageDialog(null, "Vous avez volé le trésor !");
		} else if (victime.possedeArme) {
			victime.possedeArme=false;
			this.possedeArme=true;
			JOptionPane.showMessageDialog(null, "Vous avez volé une arme !");
		} else {
			JOptionPane.showMessageDialog(null, "Il n'y avait rien dans ses poches !");
		}
		energie-=10;
	}
	
	public void frapper(Personnage victime) {
		int degats = new Random().nextInt(20)+1;
		victime.energie-= degats;
		JOptionPane.showMessageDialog(null, "Vous frappez le personnage et lui infliger " + degats + " dégâts.");
		this.energie-=10;
	}
}
