import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SearchAnim extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menagerie menagerie;
	private JPanel panel;
	private JLabel labelEspece = new JLabel("Donnez l'espèce de l'animal à chercher");
	private JLabel labelNom= new JLabel("Donnez le nom de l'animal à chercher");
	private JTextField jtfEspece = new JTextField();
	private JTextField jtfNom = new JTextField();
	private JLabel labelInfo;
	private JButton btnCherch = new JButton("Rechercher un animal");
	private JButton btnBack = new JButton("Retour");
	
	public SearchAnim(Menagerie maMenagerie){
		//Titre de la fenêtre
		this.setTitle("Recherche des animaux");
		//Détermine le positionnement de la fenêtre
		this.setLocationRelativeTo(null);
		//Ferme la fenêtre lorsque l'on clique sur la croix
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Détermine la taille.
		this.setSize(800, 500);

		//Instanciation de l'objet JPanel
		panel = new JPanel( );
		//Définition de la couleur de fond du JPanel
		panel.setBackground(Color.white);
		//Ajout du JPanel au conteneur principal
		this.getContentPane().add(panel);
		panel.setLayout(new FlowLayout());

		//Précise l'espacement entre les colonnes et entre les lignes
		panel.setLayout(new GridLayout(5, 2, 5, 5));
		
		//Espece
		labelEspece.setVisible(true);
		panel.add(labelEspece);
		jtfEspece.setVisible(true);
		panel.add(jtfEspece);
		
		//Nom
		labelNom.setVisible(true);
		panel.add(labelNom);
		jtfNom.setVisible(true);
		panel.add(jtfNom);

		btnCherch.addActionListener(this);
		panel.add(btnCherch);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		this.setVisible(true);
		this.menagerie = maMenagerie;
	}
	
	public void actionPerformed(ActionEvent e) {
		String indice = "";
		String espece = jtfEspece.getText();
		String nom = jtfNom.getText();
		
		if (e.getSource() == btnCherch){
			System.out.print(this.menagerie.getNombreAnimaux());
			if(this.menagerie.getNombreAnimaux()!=0){
					
				boolean trouve = false ;
				int i = 0;
				for (i = 0 ; i < this.menagerie.getNombreAnimaux() ; i++){
					if (this.menagerie.getListeAnimaux().get(i).getEspece().equals(espece) && this.menagerie.getListeAnimaux().get(i).getNom().equals(nom)){
						trouve = true;
					}
				}
					
				if(trouve == false){
					panel.add(labelInfo = new JLabel("Cet animal n'existe pas !"));
				}
				else{
					panel.add(labelInfo = new JLabel("L'animal " + espece + " " + nom + " se trouve aux indices : " + indice));
				}
			}
			else{
				panel.add(labelInfo = new JLabel("La ménagerie est actuellement vide"));
			}
		}else{
			//Bouton retour
			Pgm fenSearch = new Pgm(this.menagerie);
			this.dispose();
		}
	}
}
