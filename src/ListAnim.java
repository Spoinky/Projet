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


public class ListAnim extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menagerie menagerie;
	private JPanel panel;
	private JButton btnList = new JButton("Liste");
	private JButton btnBack = new JButton("Retour");
	private JLabel labelList;
	
	public ListAnim(Menagerie maMenagerie){
		//Titre de la fenêtre
		this.setTitle("Consulter la liste des animaux");
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
		panel.setLayout(new GridLayout(4, 2, 5, 5));

		btnList.addActionListener(this);
		panel.add(btnList);
		btnBack.addActionListener(this);
		panel.add(btnBack);
		
		this.setVisible(true);
		this.menagerie = maMenagerie;
	}
	
	public void actionPerformed(ActionEvent e) {
		int i = 0;
		if (e.getSource() == btnList){
			while(i < this.menagerie.getNombreAnimaux()){
				panel.add(labelList = new JLabel(this.menagerie.getListeAnimaux().get(i).sePresenter()));
				i++;
			}
			if(this.menagerie.getNombreAnimaux() == 0){
				panel.add(labelList = new JLabel("La ménagerie est actuellement vide."));
			}
			btnList.setVisible(false);
		}else{
			//Bouton retour
			Pgm fenList = new Pgm(this.menagerie);
			this.dispose();
		}
	}
}
