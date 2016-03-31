

public class Voleur extends Personnage {
	
	
	public Voleur(int posX,int posY,int equipe){
		this.posX=posX;
		this.posY=posY;
		this.equipe=equipe;
	}
	
	public void vol(Personnage victime){
		if(victime.possedeClef){
			victime.possedeClef=false;
			this.possedeClef=true;
			System.out.println("Réussi !!!");
		}else{
			System.out.println("Loupé...");
		}
	}
	
	public void deplacementDroite() {	posX+=1;	} 
	public void deplacementGauche() {	posX-=1;	}
	public void deplacementBas() {		posY+=1;	} 
	public void deplacementHaut() {		posY-=1;	}
	public void deplacementHautGauche(){
		this.deplacementHaut();
		this.deplacementGauche();	}
	public void deplacementHautDroite(){
		this.deplacementHaut();
		this.deplacementDroite();	}
	public void deplacementBasGauche(){
		this.deplacementBas();
		this.deplacementGauche();	}
	public void deplacementBasDroite(){
		this.deplacementBas();
		this.deplacementDroite();	}
}
