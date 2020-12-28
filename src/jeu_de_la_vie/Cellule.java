package jeu_de_la_vie;

public class Cellule {
	
	private int ligne;
	private int colonne;
	private boolean etat;
	
	

	public Cellule(int x, int y, boolean en_vie) {
		this.ligne = x;
		this.colonne = y;
		this.etat = en_vie;
	}

	public int getx() {
		
		return this.ligne;
	}
	
	public int gety() {
		return this.colonne;
	}
	
	public void setx( int x ) {
		this.ligne = x;
	}
	
	public void sety( int y ) {
		this.colonne = y;
	}
	
	public boolean getetat() {
		
		return this.etat;
	}
	
	public void set_etat( boolean en_vie ) {
		
		this.etat = en_vie;
	}
	

	public int[] voisins(){
		
		int x = this.getx();
		int y = this.gety();
		int x1 , y1;
		int[] voisins = new int[16];
		int indice = 0;
		
		for( int i = -1; i < 2 ; i++)
		{
			for( int j = -1; j<2; j++)
			{
				x1 = x + i;
				y1 = y + j;
				
				if(  ( x != x1 ) || ( y != y1 ) )
				{
					voisins[ indice ] = x1;
					indice++;
					voisins[ indice ] = y1;
					indice++;
				}
			}
	
		}
		
		return voisins;
	}
	
	
	
	
}
