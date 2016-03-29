

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
			System.out.println("Loupé ... Tu pu la mer2!!!");
		}
	}
	
	public void deplacement(int posX,int posY){
		MyMouseEvent event= new MyMouseEvent();
	}
	

}
