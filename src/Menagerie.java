import java.util.ArrayList; 

public class Menagerie {

	private ArrayList <Animal> listeAnimaux;
	
	public Menagerie(){
		this.listeAnimaux = new ArrayList <Animal>();
	}
	
	public int getNombreAnimaux(){
		return this.listeAnimaux.size();
	}
	
	public void presenter(){
		
		  System.out.println("***** PRESENTATION DE LA MENAGERIE *****");
		  if (this.listeAnimaux.size() == 0){
			  System.out.println("La ménagerie ne possède aucun animal !");
		  }
		  else{
			  for (int i = 0; i < this.listeAnimaux.size(); i++){
				  System.out.println(this.listeAnimaux.get(i).sePresenter());
			  }
		  }
		  
	}
	public ArrayList<Animal> getListeAnimaux(){
		   return this.listeAnimaux;
	}
	public void arriver(Animal unAnimal){
		this.listeAnimaux.add(unAnimal);
	}
	
	public void partir(Animal unAnimal){
		this.listeAnimaux.remove(unAnimal);
	}
}
