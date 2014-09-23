
public class Oiseau extends Animal{
	//Attributs privés
	private int nbPattes;
	private String couleur;
	private float vitesses;
	
	//Méthodes publics
	public void dormir(){
		System.out.println(" et je dors sur une patte");
	}
	
	public Oiseau(String nom, String espece, int leNbPatte, float uneVitesse , String uneCouleur){
		super(nom, espece);
		this.nbPattes = leNbPatte;
		this.vitesses = uneVitesse;
		this.couleur = uneCouleur;
	}
	
	public int getNbPattes() {
		return this.nbPattes;
	}

	public void setNbPattes(int leNbPattes) {
		this.nbPattes = leNbPattes;
	}

	public float getVitesses() {
		return this.vitesses;
	}

	public void setVitesses(float uneVitesses) {
		this.vitesses = uneVitesses;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String uneCouleur) {
		this.couleur = uneCouleur;
	}

	public void voler(){
		System.out.print("I believe i can fly");
	}
	
	public String sePresenter(){
		return (super.sePresenter() + " je vole à " + this.vitesses + " km/h, je possède " + this.nbPattes + " et je suis de couleur " + this.couleur);
	}
}
