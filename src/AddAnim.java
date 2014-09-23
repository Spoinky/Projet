import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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


public class AddAnim extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Menagerie menagerie;
	private JPanel panel;
	private JButton btnChien = new JButton("Chien");
	private JButton btnFelin = new JButton("Felin");
	private JButton btnOiseau = new JButton("Oiseau");
	private JButton btnBack = new JButton("Retour");
	
	public AddAnim(Menagerie maMenagerie){
		//Titre de la fenêtre
		this.setTitle("Ajouter un animal");
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
		
		//Différents types d'animaux
		btnChien.addActionListener(this);
		panel.add(btnChien);
		btnFelin.addActionListener(this);
		panel.add(btnFelin);
		btnOiseau.addActionListener(this);
		panel.add(btnOiseau);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		this.setVisible(true);
		this.menagerie = maMenagerie;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnChien){
			//Bouton fenetre AddChien
			AddChien fenAddC = new AddChien(this.menagerie);
			this.dispose();
		}
		
		if(e.getSource() == btnFelin){
			//Bouton fenetre AddFelin
			AddFelin fenAddF = new AddFelin(this.menagerie);
			this.dispose();
			}
		
		if(e.getSource() == btnOiseau){
			//Bouton fenetre AddChien
			AddOiseau fenAddO = new AddOiseau(this.menagerie);
			this.dispose();
		}
		
		if(e.getSource() == btnBack){
			//Bouton retour
			Pgm fenAdd = new Pgm(this.menagerie);
			this.dispose();
		}
	}
}
