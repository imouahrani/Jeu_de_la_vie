package jeu_de_la_vie;



import java.util.Arrays;


public class Matrice {
	
	private Cellule[][]  cellules; 
	private Cellule[][]  copie_cellules;
	private int ligne ;
	private int colonne ;
	private int generation ;
	
	
	
	public Matrice() {
		
		this.ligne = 20;
		this.colonne = 20;
		this.cellules = new Cellule[ ligne ][ colonne ];
		this.copie_cellules = new Cellule[ ligne ][ colonne ];
		this.generation = 0;

		
		for( int i = 0 ; i < this.ligne ; i++) {
			
			for( int j = 0; j < this.colonne ; j++) {
				
				cellules[i][j] = new Cellule(i, j, false);
				copie_cellules[i][j] = new Cellule(i, j, false);
				
			}
		}
	}
	
	public Matrice(int nb_ligne, int nb_colonne) {
		
		this.ligne = nb_ligne;
		this.colonne = nb_ligne;
		this.cellules = new Cellule[ ligne ][ colonne ];
		this.copie_cellules = new Cellule[ ligne ][ colonne ];
		this.generation = 0;

		
		for( int i = 0 ; i < this.ligne ; i++) {
			
			for( int j = 0; j < this.colonne ; j++) {
				
				cellules[i][j] = new Cellule(i, j, false);
				copie_cellules[i][j] = new Cellule(i, j, false);

			}
		}
	}
	
	
	public void  remplire_matice(int x , int y) {

		this.cellules[x][y].set_etat( true );
	}
	
	public void remplire_glider()
	{
		/*this.cellules[3][4].set_etat(true);
		this.cellules[4][5].set_etat(true);
		this.cellules[5][5].set_etat(true);
		this.cellules[5][5].set_etat(true);
		this.cellules[5][4].set_etat(true);
		this.cellules[5][3].set_etat(true);*/
		
		this.cellules[3][1].set_etat(true);
		this.cellules[4][2].set_etat(true);
		this.cellules[5][2].set_etat(true);
		this.cellules[5][1].set_etat(true);
		this.cellules[5][0].set_etat(true);

	}
	
	public void smallExploder()
	{
		this.cellules[3][4].set_etat(true);
		this.cellules[4][5].set_etat(true);
		this.cellules[4][4].set_etat(true);
		this.cellules[4][3].set_etat(true);
		this.cellules[5][5].set_etat(true);
		this.cellules[5][3].set_etat(true);
		this.cellules[6][4].set_etat(true);

	}
	
	public void afficheVie() {
		
		System.out.print("\t");
		for( int i = 0; i < this.ligne ; i++ )
		{
			System.out.print(i + "\t");
		}
		System.out.println();
		
		for( int i = 0; i < this.ligne ; i++)
		{
			System.out.print("" + i + "\t");
			for( int j = 0 ; j < this.colonne ; j++)
			{
				if( cellules[i][j].getetat() )
					System.out.print( "\\033[31;1m#" + "\t");
				else
					System.out.print( "." + "\t");

			}
			
			

			System.out.println();
			System.out.println();
		}
	}
	
	
	public void prochaine_etape(int x, int y) {
		
		int sousPopulation = 1;
		int surPopulation = 4;
		int minPopulationRegeneratrice = 3;
		int maxPopulationRegeneratrice = 3;
		
		int nbCelluleVivantes = 0;
		int[] voisins = this.cellules[x][y].voisins();
		int x_voisins;
		int y_voisins;
		int x1 = -1;
		int y1 = -1;
		
		
		for( int i = 0; i < voisins.length ; i++ ) {
			
			if( (i%2) == 0) {
			
				x_voisins = voisins[i];
				y_voisins = voisins[i+1];
				
				x1 = x_voisins;
				y1 = y_voisins;
				
				if(x_voisins < 0 )
				{
					x1 = this.ligne -1;
					//System.out.println("hhh" + x1);
				}
				else if( x_voisins >= this.ligne  ){
					
					x1 = 0;
					//System.out.println("hhh" + x1);

				}
				
				if( y_voisins < 0 ) {
					y1 = this.colonne -1;
				}
				else if( y_voisins >= this.colonne ) {
					
					y1 = 0;
				}
				
					
				
				
				
				//x1 = ( ( x_voisins < 0 || x_voisins >= this.ligne ) ?  : x_voisins );
				//y1 = ( ( y_voisins < 0 || y_voisins >= this.colonne ) ?  : y_voisins );
				
			
					if( this.cellules[x1][y1].getetat() == true ) {

						nbCelluleVivantes++;	
					}
				
			}
		}
		
		
		if ( nbCelluleVivantes == maxPopulationRegeneratrice ){ 
        	this.copie_cellules[x][y].set_etat( true );
        }
		else if ( nbCelluleVivantes <= sousPopulation || nbCelluleVivantes >= surPopulation){ 
			this.copie_cellules[x][y].set_etat(false);
		}	
	
		
	}
	
	// copie le tableau cellules dans le tableau copie_cellules
	public void copie_cellules_1() {
		
		for( int i = 0 ; i < this.ligne ; i++) {
			
			for( int j = 0; j < this.colonne ; j++) {
				
				copie_cellules[i][j].set_etat( this.cellules[i][j].getetat() );
			}
		}	
	}
	
	// copie le tableau copie_cellules dans le tableau cellules
	public void  copie_cellules_2() {
		
		for( int i = 0 ; i < this.ligne ; i++) {
			
			for( int j = 0; j < this.colonne ; j++) {
				
				cellules[i][j].set_etat( this.copie_cellules[i][j].getetat() );
			}
		}
	}
	
	public void prochaineGeneration() {
		
		this.generation++;
		this.copie_cellules_1();
		
		System.out.println("t = " + this.generation);
		
		for( int i = 0; i < this.ligne ; i++) {
			for( int j = 0; j < this.colonne ; j++) {
					
				this.prochaine_etape(i, j);
			
			}
			
			
			
		}
		
		this.copie_cellules_2();		
		
	}
	
	
	
	

}
