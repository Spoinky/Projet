
public abstract class Animal {


	//Atribus Privés
	private static int cpt = 0;
	private String espece;
	private String nom;
	
	//Constructeur
	public Animal(){
		cpt = cpt + 1;
	}
	
	public Animal(String unNom){
		this.nom = unNom;
		cpt = cpt + 1;
	}
	
	public Animal( String uneEspece, String unNom){
		this.espece = uneEspece;
		this.nom = unNom;
		cpt = cpt + 1;
	}
	
	//Methodes Publics
	
	public String getNom() {
		return this.nom;
	}
	
	public void setAnimal(String unNom) {
		this.nom = unNom;
	}
	
	public String getEspece() {
		return this.espece;
	}
	
	public void setNomEspece(String uneEspece) {
		this.espece = uneEspece;
	}
	
	public static int getCpt() {
		return cpt;
	}
	
	 public String sePresenter(){
		return ("Je me présente : " + this.nom + " de l'espece des " + this.espece);
	}
	 
	public abstract void dormir();
	
	public void manger(){
		
	}
}
