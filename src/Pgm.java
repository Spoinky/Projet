import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	// Création d’une classe Fenetre héritant de la classe JFrame
	public class Pgm extends JFrame implements ActionListener{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	//Attributs privée
		private Menagerie menagerie;
		private JPanel panel ;
	//Interaction avec l'utilisateur
		private JButton btnAdd = new JButton("Ajouter un animal");
		private JButton btnDel = new JButton("Supprimer un animal");
		private JButton btnList = new JButton("Consulter la liste des animaux");
		private JButton btnSearch = new JButton("Rechercher un animal");
		private JButton btnQuit = new JButton("Quitter");
		private JLabel lblTxt;
		
		private AddAnim ajout;
		
	// Constructeur de la classe Fenetre
		public Pgm(Menagerie maMenagerie){	
			//Titre de la fenêtre
			this.setTitle("Ménagerie");
			//Détermine le positionnement de la fenêtre
			this.setLocationRelativeTo(null);
			//Ferme la fenêtre lorsque l'on clique sur la croix
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Taille de la fenêtre
			this.setSize(500, 500);

			//Instanciation de l'objet JPanel
			panel = new JPanel( );
			//Définition de la couleur de fond du JPanel
			panel.setBackground(Color.white);
			//Ajout du JPanel au conteneur principal
			this.getContentPane().add(panel);
			panel.setLayout(new FlowLayout());

			//Précise l'espacement entre les colonnes et entre les lignes
			panel.setLayout(new GridLayout(5, 3, 5, 5));
			
	//Permet l'interaction avec l'utilisateur
			btnAdd.addActionListener(this);
			panel.add(btnAdd);	
			btnDel.addActionListener(this);
			panel.add(btnDel);
			btnList.addActionListener(this);
			panel.add(btnList);
			btnSearch.addActionListener(this);
			panel.add(btnSearch);
			btnQuit.addActionListener(this);
			panel.add(btnQuit);
			
			this.setVisible(true);
			this.menagerie = maMenagerie;
		}
	//Permet d'aficher ce que font les boutons
		public void actionPerformed ( ActionEvent e ) {
		
			if (e.getSource() == btnAdd){
				//Bouton qui ouvre la fenêtre d'ajout d'animaux.
				AddAnim fenAdd = new AddAnim(this.menagerie);
				this.dispose();
					
			}else if (e.getSource() == btnDel){
				//Bouton qui ouvre la fenêtre d'effacement d'animaux.
				DelAnim fenDel = new DelAnim(this.menagerie);
				this.dispose();
					
			}else if (e.getSource() == btnList){
				//Bouton qui ouvre la fenêtre d'affichage des animaux.
				ListAnim fenList = new ListAnim(this.menagerie);
				this.dispose();
				
			}else if (e.getSource() == btnSearch){
				//Bouton qui ouvre la fenêtre de recherche d'animaux.
				SearchAnim fenSearch = new SearchAnim(this.menagerie);
				this.dispose();
			}
			else{
				//Bouton quitter
				System.exit(0); 
			}
		}
	}

