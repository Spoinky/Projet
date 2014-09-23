
public class Felin extends Animal{
	//Attributs privés
	private int nbPattes;
	private float vitesse;
	private String couleur;
	
	//Méthodes publics
	public void dormir(){
		System.out.println(" et je dors en boule");
	}
	public Felin(String nom, String espece, int leNbPattes, float vitesses, String uneCouleur){
		super(nom, espece);
		this.nbPattes = leNbPattes;
		this.vitesse = vitesses;
		this.couleur = uneCouleur;
	}
	
	public int getNbpattes() {
		return this.nbPattes;
	}

	public void setNbpattes(int leNbpattes) {
		this.nbPattes = leNbpattes;
	}

	public float getVitesse() {
		return this.vitesse;
	}

	public void setVitesse(float uneVitesse) {
		this.vitesse = uneVitesse;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public void setCouleur(String uneCouleur) {
		this.couleur = uneCouleur;
	}
	
	public void chasser(){
		System.out.print("Je chasse la nuit tombée.");
	}
	
	public String sePresenter(){
		return (super.sePresenter() + ", j'ai " + this.nbPattes + " pattes, je cours à " + this.vitesse + " km/h et je suis de couleur " + this.couleur);
	}
}
