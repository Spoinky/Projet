import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DelAnim extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menagerie menagerie;
	private JPanel panel;
	private JLabel labelEspece = new JLabel("Donnez l'espèce de l'animal à supprimer");
	private JLabel labelNom= new JLabel("Donnez le nom de l'animal à supprimer");
	private JTextField jtfEspece = new JTextField();
	private JTextField jtfNom = new JTextField();
	private JLabel labelInfo = new JLabel();
	private JButton btnSupp = new JButton("Supprimer");
	private JButton btnBack = new JButton("Retour");
	
	public DelAnim(Menagerie maMenagerie){
		//Titre de la fenêtre
		this.setTitle("Supprimer un animal");
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
		
		btnSupp.addActionListener(this);
		panel.add(btnSupp);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		this.setVisible(true);
		this.menagerie = maMenagerie;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String espece = jtfEspece.getText();;
		String nom = jtfNom.getText();;
		if (e.getSource() == btnSupp){
			if (this.menagerie.getNombreAnimaux()!=0){
				boolean trouve = false ;
				int i = 0;
				while (i < this.menagerie.getNombreAnimaux() && trouve==false){
					if (this.menagerie.getListeAnimaux().get(i).getEspece().equals(espece) && 
							this.menagerie.getListeAnimaux().get(i).getNom().equals(nom)){
						this.menagerie.partir(this.menagerie.getListeAnimaux().get(i));
						trouve = true;
					}
					i++;
				}
				
				if(trouve == false){
					panel.add(labelInfo = new JLabel("L'animal à supprimer n'existe pas !"));
					//Espece
					labelEspece.setVisible(false);
					panel.add(labelEspece);
					jtfEspece.setVisible(false);
					panel.add(jtfEspece);
							
					//Nom
					labelNom.setVisible(false);
					panel.add(labelNom);
					jtfNom.setVisible(false);
					panel.add(jtfNom);
				}
				else{
					panel.add(labelInfo = new JLabel("L'animal a bien été supprimé."));
					//Espece
					labelEspece.setVisible(false);
					panel.add(labelEspece);
					jtfEspece.setVisible(false);
					panel.add(jtfEspece);
							
					//Nom
					labelNom.setVisible(false);
					panel.add(labelNom);
					jtfNom.setVisible(false);
					panel.add(jtfNom);
				}
			}
			else{
				panel.add(labelInfo = new JLabel("La ménagerie est actuellement vide"));
			}
		}else{
			//Bouton retour
			Pgm fenDel = new Pgm(this.menagerie);
			this.dispose();
		}
	}
}
