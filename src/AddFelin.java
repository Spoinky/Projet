import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddFelin extends JFrame implements ActionListener{
	
	private Menagerie menagerie;
	private JPanel panel;
	private JButton btnValider = new JButton("Valider");
	private JButton btnBack = new JButton("Retour");
	private JLabel labelEspece = new JLabel("Quel est l'espece de l'animal ?");
	private JLabel labelNom = new JLabel("Quel est le nom de l'animal ?");
	private JLabel labelPattes = new JLabel("Combien a-t-il de pattes ?");
	private JLabel labelVitesse = new JLabel("A quelle vitesse va-t-il ?");
	private JLabel labelCouleur = new JLabel("De quelle couleur est-il ?");
	private JTextField jtfEspece = new JTextField();
	private JTextField jtfNom = new JTextField();
	private JTextField jtfPattes = new JTextField();
	private JTextField jtfVitesse = new JTextField();
	private JTextField jtfCouleur = new JTextField();
	private JLabel labelOk;
	private JLabel labelQEspece;
	private JLabel labelQNom;
	private JLabel labelQPattes;
	private JLabel labelQVitesse;
	private JLabel labelQCouleur;

	
	public AddFelin(Menagerie maMenagerie){
		//Titre de la fenêtre
		this.setTitle("Ajouter un chien");
		//Détermine le positionnement de la fenêtre
		this.setLocationRelativeTo(null);
		//Ferme la fenêtre lorsque l'on clique sur la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Détermine la taille.
		this.setSize(800, 500);
		
		//Instanciation de l'objet JPanel
		panel = new JPanel();
		//Définition de la couleur de fond du JPanel
		panel.setBackground(Color.white);
		//Ajout du JPanel au conteneur principal
		this.getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		//Précise l'espacement entre les colonnes et entre les lignes
		panel.setLayout(new GridLayout(7, 5, 5, 5));
		jtfNom.setPreferredSize(new Dimension(150, 50));
		jtfEspece.setPreferredSize(new Dimension(150, 50));
		jtfPattes.setPreferredSize(new Dimension(150, 50));
		jtfVitesse.setPreferredSize(new Dimension(150, 50));
		
		//Nom
		labelNom.setVisible(true);
		panel.add(labelNom);
		jtfNom.setVisible(true);
		panel.add(jtfNom);
		
		//Espece
		labelEspece.setVisible(true);
		panel.add(labelEspece);
		jtfEspece.setVisible(true);
		panel.add(jtfEspece);
		
		//Nombre de Pattes
		labelPattes.setVisible(true);
		panel.add(labelPattes);
		jtfPattes.setVisible(true);
		panel.add(jtfPattes);
		
		//Vitesse
		labelVitesse.setVisible(true);
		panel.add(labelVitesse);
		jtfVitesse.setVisible(true);
		panel.add(jtfVitesse);
		
		//Couleur
		labelCouleur.setVisible(true);
		panel.add(labelCouleur);
		jtfCouleur.setVisible(true);
		panel.add(jtfCouleur);

		btnValider.addActionListener(this);
		panel.add(btnValider);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		this.setVisible(true);
		this.menagerie = maMenagerie;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String espece = jtfEspece.getText();
		String nom = jtfNom.getText();
		String patte = jtfPattes.getText();
		String vitesse = jtfVitesse.getText();
		String couleur = jtfCouleur.getText();
		
		int nbpattes = Integer.parseInt(patte);
		float vitesses = Float.parseFloat(vitesse);
		
		if(e.getSource() == btnValider){
			Felin unFelin = new Felin(espece, nom, nbpattes, vitesses, couleur);
	
			this.menagerie.arriver(unFelin);
				
			/*panel.add(labelOk = new JLabel("L'animal a été ajouté avec succès."));
			panel.add(labelQEspece = new JLabel("Votre Felin est un " + espece + ".")); 
			panel.add(labelQNom = new JLabel("Son nom est " + nom + "."));
			panel.add(labelQPattes = new JLabel("Il possède " + nbpattes + " pattes."));
			panel.add(labelQVitesse = new JLabel("Il court à " + vitesses + " km/h."));
			panel.add(labelQCouleur = new JLabel("Il est de couleur " + couleur + "."));*/
	
			panel.add(labelOk = new JLabel("L'animal a été ajouté avec succès. \n" +
					"Votre Felin est un " + espece + ". " +
					"Son nom est " + nom + "." +
					"Il possède " + nbpattes + " pattes." +
					"Il court à " + vitesses + " km/h." +
					"Il est de couleur " + couleur + "."));
	
			labelNom.setVisible(false);
			jtfNom.setVisible(false);
	
			labelEspece.setVisible(false);
			jtfEspece.setVisible(false);
	
			labelPattes.setVisible(false);
			jtfPattes.setVisible(false);
			
			labelVitesse.setVisible(false);
			jtfVitesse.setVisible(false);
				
			labelCouleur.setVisible(false);
			jtfCouleur.setVisible(false);
			
			btnBack.setVisible(true);
		}else if(e.getSource() == btnBack){
			//Bouton fenetre AddAnim
			AddAnim fenAdd = new AddAnim(this.menagerie);
			this.dispose();
		}
	}
}
