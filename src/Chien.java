
public class Chien extends Animal {
	//Attributs privés
	private int nbPattes;
	private float vitesses;
	private String couleur;
	
	//Méthodes publics
	public Chien(String uneEspece, String unNom, int leNbPatte, float uneVitesse, String uneCouleur) {
		super(uneEspece, unNom);
		this.nbPattes = leNbPatte;
		this.vitesses = uneVitesse;
		this.couleur = uneCouleur;
	}

	//getter et setter
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

	public int getNbpattes() {
		return this.nbPattes;
	}

	public void setNbpattes(int leNbPattes) {
		this.nbPattes = leNbPattes;
	}
	
	public void aboyer() {
		System.out.println("Ouaf ...");
	}
	
	//présentation de l'animal
	public String sePresenter() {
		return (super.sePresenter() + ", je possède " + this.nbPattes + " pattes , je cours à " + this.vitesses + " km/h et je suis de couleur " + this.couleur);
	}
	
	public void dormir(){
		System.out.println("Je dors en boule");
	}
}
