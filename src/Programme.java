import java.util.Scanner;

public class Programme {
	private static Scanner clavier;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clavier = new Scanner(System.in);
		
		//Mode Fenetre
		Menagerie maMenagerie = new Menagerie();
		Pgm maFenetre = new Pgm(maMenagerie);
		
		/*//Variables
		int choix, choixA, i, nbSuppr, nbpattes, vitesse;
		String espece, nom, couleur, indices;
		boolean trouve;
		
		System.out.println("***************************************************************************");
		System.out.println("                            BIENVENUE DANS MA MENAGERIE");
		System.out.println("***************************************************************************");
		System.out.println();
		
		do{
			menu();
			choix = verifsaisie(0,5);
		
			switch (choix){
				case 1 : 
					clavier.nextLine();
					System.out.println("---------------------------- Ajout d'un animal ----------------------------");
					menuAnimal();
					choixA = verifsaisie(1, 3);
					clavier.nextLine();
					switch (choixA){
						case 1 :
							System.out.println("Quelle est l'espèce de votre animal ?");
							espece = clavier.nextLine();
							System.out.println("Quelle est le nom de votre animal ?");
							nom = clavier.nextLine();
							System.out.println("Combien a-t-il de pattes ?");
							nbpattes = clavier.nextInt();
							Chien unChien = new Chien(espece, nom, nbpattes);
							maMenagerie.arriver(unChien);
							break;
							
						case 2 :
							System.out.println("Quelle est l'espèce de votre animal ?");
							espece = clavier.nextLine();
							System.out.println("Quelle est le nom de votre animal ?");
							nom = clavier.nextLine();
							System.out.println("Combien a-t-il de pattes ?");
							nbpattes = clavier.nextInt();
							System.out.println("Quelle est sa vitesse ?");
							vitesse = clavier.nextInt();
							Felin unFelin = new Felin(espece, nom, nbpattes, vitesse);
							maMenagerie.arriver(unFelin);
							break;
							
						case 3 :
							System.out.println("Quelle est l'espèce de votre animal ?");
							espece = clavier.nextLine();
							System.out.println("Quelle est le nom de votre animal ?");
							nom = clavier.nextLine();
							System.out.println("Quelle est sa couleur ?");
							couleur = clavier.nextLine();
							Oiseau unOiseau = new Oiseau(espece, nom, couleur);
							maMenagerie.arriver(unOiseau);
							break;
							
						default : 
							System.out.println("Ce choix n'existe pas, recommencez.");
							
					}
					System.out.println("Animal ajouté !");
					break;
				
				case 2 :
					clavier.nextLine();
					System.out.println("\n------------------------- Suppression d'un animal -------------------------");
					System.out.println();
					
					System.out.println("Quelle est l'espèce de votre animal ?");
					espece = clavier.nextLine();
					System.out.println("Quelle est le nom de votre animal ?");
					nom = clavier.nextLine();
					nbSuppr = 0;
					i = 0;
					while (i < maMenagerie.getNombreAnimaux()){
						if (maMenagerie.getListeAnimaux().get(i).getEspece().equals(espece) && maMenagerie.getListeAnimaux().get(i).getNom().equals(nom)){
							maMenagerie.partir(maMenagerie.getListeAnimaux().get(i));
							nbSuppr ++;
						}
						else{
							i++;
						}
					}
						
					if(nbSuppr == 0){
						System.out.println("L'animal à supprimer n'existe pas !");
					}
					else{
						System.out.println("Animal supprimé !");
					}
					maMenagerie.presenter();
					break;
					
				case 3 :
					clavier.nextLine();
					System.out.println("\n---------------------------- Liste des animaux ----------------------------");
					System.out.println();
					
					maMenagerie.presenter();
					System.out.println(Animal.getCpt());
					break;
					
				case 4 :
					clavier.nextLine();
					System.out.println("\n-------------------------- Recherche d'un animal --------------------------");
					System.out.println();
					
					System.out.println("Quelle est l'espèce de votre animal ?");
					espece = clavier.nextLine();
					System.out.println("Quelle est le nom de votre animal ?");
					nom = clavier.nextLine();
					
					indices = "";
					trouve = false;
					for (i = 0 ; i < maMenagerie.getNombreAnimaux() ; i++){
						if (maMenagerie.getListeAnimaux().get(i).getEspece().equals(espece) && maMenagerie.getListeAnimaux().get(i).getNom().equals(nom)){
							trouve = true;
							indices = indices + (i+1) + " ";
						}
					}
					
					if (trouve == false){
						System.out.println("Cet animal n'existe pas !");
					}
					else{
						System.out.println("L'animal " + espece + " " + nom + " se trouve aux indices : " + indices); 
					}
					break;
					
				case 5 :
					clavier.nextLine();
					System.out.println("\n---------------------------- Modifier un animal ---------------------------");
					
					break;
					
				case 0 :
					System.out.println("Arret du programme.");
					break;
					
				default : 
					System.out.println("Ce choix n'existe pas, recommencez.");
			}
		}while (choix != 0);

	}

	public static void menu(){  
		System.out.println("\n============================= MENU PRINCIPAL ==============================");
		System.out.println();
		System.out.println("\t 1- Ajouter un animal à ma ménagerie");
        System.out.println("\t 2- Supprimer un animal de ma ménagerie");
        System.out.println("\t 3- Consulter la liste des animaux");
        System.out.println("\t 4- Rechercher un animal");
        System.out.println("\t 0- Quitter le programme ?");
        System.out.print("\nQue voulez-vous faire ?");
	}
	
	public static void menuAnimal(){
		System.out.println("--- Choisir un animal ---");
		System.out.println("\t 1- Chien");
        System.out.println("\t 2- Felin");
        System.out.println("\t 3- Oiseau");
	}
	
	public static int verifsaisie(int borneinf, int bornesup){ 
		//Variable locale
		int choix;
		
		//Début
		choix = clavier.nextInt();
		while (choix < borneinf || choix > bornesup){
			System.out.println("Erreur, vous devez saisir un nombre entre " + borneinf + " et " + bornesup + ". Recommencez : ");
			choix = clavier.nextInt();
		}
		return(choix);*/
	}
	
	

}
