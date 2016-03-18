import java.util.Random;

public class EssaiIle {
	public static void main(String[] args) {
		Random r=new Random();
		String[] gifs={"img/mer.png","img/rocher.png","img/coffre.png",
				"img/1.navire.png","img/2.navire.png",
				"img/1.explorateur.png","img/2.explorateur.png", 
				"img/1.piegeur.png", "img/2.piegeur.png",
				"img/1.voleur.png", "img/2.voleur.png"
				};
		int taille=10;
		SuperPlateauIterable grille=new SuperPlateauIterable(gifs,taille);
		int[][] jeu=new int[taille][taille];
		for(int x=0;x<taille;x++) {jeu[x][0]=1;jeu[x][taille-1]=1;}
		for(int x=1;x<taille-1;x++) {jeu[0][x]=1;jeu[taille-1][x]=1;}
		
		for (int i=1;i<taille-1;i++) jeu[r.nextInt(taille-3)+1][i]=2;
		
		jeu[3][5]=5;
		jeu[4][5]=6;
		jeu[7][3]=7;
		jeu[5][5]=8;
		jeu[2][3]=9;
		jeu[3][6]=10;
		jeu[3][7]=11;

		//bord aleatoire	
		for (int x=1;x<taille-1;x++){
			for (int y=1,max=r.nextInt(2)+1;y<max;y++) jeu[x][y]=1;
			for (int y=8,max=r.nextInt(2)+8;y<max;y++) jeu[x][y]=1;
			for (int y=1,max=r.nextInt(2)+1;y<max;y++) jeu[y][x]=1;
			for (int y=8,max=r.nextInt(2)+8;y<max;y++) jeu[y][x]=1;
		}
		
		jeu[1][1]=4;
		jeu[taille-2][taille-2]=5;
		grille.setJeu(jeu);
		grille.affichage();

/*		
    try{Thread.sleep(1000);}catch(Exception ie){}
    grille.deplacer(5, 5, 5,6);
    grille.affichage();
*/    
	/*
    int[] x={0,1},y={1,0},u={0,0},v={0,0};
    jeu[0][1]=1;
    jeu[1][0]=2;
    grille.setJeu(jeu);
    while ( ((x[0]<taille-1) || (y[0]<taille-1)) || ((x[1]<taille-1) || (y[1]<taille-1))){
    	for (int k=0;k<2;k++){
	    	if (x[k]<taille-1) u[k]=x[k]+r.nextInt(2);
	    	if (y[k]<taille-1) v[k]=y[k]+r.nextInt(2);
	    	if (u[k]==x[k] && v[k]==y[k]) continue;
	    	try{Thread.sleep(100);}catch(Exception ie){}
	    	if (grille.deplacer(x[k],y[k],u[k],v[k])){
	    	grille.affichage();
	    	x[k]=u[k];
	    	y[k]=v[k];
	    	}
    	}
    }
    */
}
}
