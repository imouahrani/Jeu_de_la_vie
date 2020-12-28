package jeu_de_la_vie;


import java.util.Arrays;

public class Main {
	
	public static void  main( String[] args ) throws InterruptedException
	{
		System.out.println("Hello World!");
		
		Matrice matrice = new Matrice( 10 , 10 );
		matrice.remplire_glider();
		//matrice.smallExploder();
		while( true ) {
			
			matrice.afficheVie();
			matrice.prochaineGeneration();


			Thread.sleep(500);

		}
		
		
		
		
		/*
		//matrice.prochaine_etape(3, 3);
		//matrice.prochaineGeneration();
		//matrice.afficheVie();
		matrice.afficheVie();
		matrice.prochaineGeneration();
		matrice.afficheVie();

		matrice.prochaineGeneration();
		matrice.afficheVie();
		*/
		



		
		
		
		
	}

}
