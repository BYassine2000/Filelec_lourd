package vue;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import controleur.Produits;
import controleur.Tableau;
import modele.Modele;

public class PanelProduit extends PanelDeBase implements ActionListener {
	
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	
	private JLabel titre = new JLabel("Gestion des produits");
	
	Font fTitre = new Font("Arial", Font.BOLD, 28);
	Font fButton = new Font("Arial", Font.BOLD, 14);
	Font fImage = new Font("Arial", Font.BOLD, 10);
	
	private JButton btImage = new JButton("Sélectionner un image");
	private JButton btAjouter = new JButton("Ajouter");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtNomProduit = new JTextField();
	// private JButton btImageProduit = new JButton("Image");
	private JTextField txtDescriptionProduit = new JTextField();
	private JTextField txtQteProduit = new JTextField();
	private JTextField txtPrixProduit = new JTextField();
	
	private JTable uneTable = null;

	private static Tableau unTableau = null;
	
	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");

	public PanelProduit() {
		super(new Color(23, 25, 51));
		
		this.titre.setBounds(5, -1, 500, 40);
		this.titre.setForeground(Color.WHITE);
		this.titre.setFont(fTitre);
		this.add(titre);
		
		this.txtMot.setBounds(980, 10, 150, 20);
		this.add(this.txtMot);
		
		this.btRechercher.setBounds(1145, 10, 110, 20);
		this.btRechercher.addActionListener(this);
		this.add(this.btRechercher);
		
		// Rendre le champ de type number
		txtQteProduit.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
		            e.consume();  // Si ce n’est pas un nombre, ignorer l’événement
		        }
		     }
		});
		
		this.panelForm.setLayout(new GridLayout(6,2));
		
		this.panelForm.add(new JLabel("Nom du produit : "));
		this.panelForm.add(this.txtNomProduit);
		
		this.panelForm.add(new JLabel("Image du produit : "));
		this.panelForm.add(this.btImage);
		
		this.panelForm.add(new JLabel("Description du produit : "));
		this.panelForm.add(this.txtDescriptionProduit);
		
		this.panelForm.add(new JLabel("Quantite du produit : "));
		this.panelForm.add(this.txtQteProduit);
		
		this.panelForm.add(new JLabel("Prix du produit : "));
		this.panelForm.add(this.txtPrixProduit);
		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btAjouter);
		
		this.panelForm.setBounds(10, 50, 300, 150);
		this.add(this.panelForm);
		
		this.panelTable.setBounds(330, 40, 945, 320); // Dimension du fond
		this.panelTable.setBackground(new Color(23, 25, 51));
		this.panelTable.setLayout(null);
		String entetes[] = { "ID", "Nom", "Image", "Description", "Quantité", "Prix", "Date ajout" };
		Object donnees[][] = this.getLesDonnees("");
		unTableau = new Tableau(entetes, donnees);
		this.uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(10, 10, 925, 250); // Dimension du tableau d'affichage
		this.panelTable.add(uneScroll);

		this.add(this.panelTable);
		
		this.uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int nbclic = e.getClickCount();
				if (nbclic == 2) {
					int numLigne = uneTable.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce produit ?", "Suppression d'un Produit", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idproduit = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteProduit(idproduit);
						unTableau.supprimerLigne(numLigne);
					}
				}
			}
		});
		
		// Bouton Image
		this.btImage.setBackground(Color.GRAY);
		this.btImage.setForeground(Color.WHITE);
		this.btImage.setFont(fImage);
		this.btImage.addActionListener(this);
		
		// Bouton Annuler
		this.btAnnuler.setBackground(new Color(178, 34, 34));
		this.btAnnuler.setForeground(Color.WHITE);
		this.btAnnuler.setFont(fButton);
		this.btAnnuler.addActionListener(this);
		
		// Bouton Ajouter
		this.btAjouter.setBackground(new Color(0, 128, 0));
		this.btAjouter.setForeground(Color.WHITE);
		this.btAjouter.setFont(fButton);
		this.btAjouter.addActionListener(this);
	}
	
	public Object[][] getLesDonnees(String mot) {
		ArrayList<Produits> lesProduits = null;
		if (mot.equals("")) {
			lesProduits = Modele.selectAllProduits();
		} else {
			lesProduits = Modele.selectLikeProduit(mot);
		}
		Object[][] matrice = new Object[lesProduits.size()][7];
		int i = 0;
		for (Produits unProduit : lesProduits) {
			matrice[i][0] = unProduit.getIdProduit();
			matrice[i][1] = unProduit.getNomProduit();
			matrice[i][2] = unProduit.getImageProduit();
			matrice[i][3] = unProduit.getDescriptionProduit();
			matrice[i][4] = unProduit.getQteProduit();
			matrice[i][5] = unProduit.getPrixProduit();
			matrice[i][6] = unProduit.getDate_ajout();
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtNomProduit.setText("");
			this.txtDescriptionProduit.setText("");
			this.txtQteProduit.setText("");
			this.txtPrixProduit.setText("");
		} else if (e.getSource() == this.btAjouter) {
			String nomProduit = this.txtNomProduit.getText();
			String descriptionProduit = this.txtDescriptionProduit.getText();
			int qteProduit = Integer.parseInt(this.txtQteProduit.getText());
			String prixProduit = this.txtPrixProduit.getText();
			
			try {
				qteProduit = Integer.parseInt(this.txtQteProduit.getText());
			} catch (NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "Attention au format du nombre");
				this.txtPrixProduit.setBackground(Color.red);
			}
			
			if (nomProduit.equals("")) {
				this.txtNomProduit.setBackground(Color.red);
			} else {
				this.txtNomProduit.setBackground(Color.white);
			}
			
			if (descriptionProduit.equals("")) {
				this.txtDescriptionProduit.setBackground(Color.red);
			} else {
				this.txtDescriptionProduit.setBackground(Color.white);
			}
			
			if (qteProduit > 0) {
				this.txtQteProduit.setBackground(Color.white);
			}
			
			if (prixProduit.equals("")) {
				this.txtPrixProduit.setBackground(Color.red);
			} else {
				this.txtPrixProduit.setBackground(Color.white);
			}
			
			if (!nomProduit.equals("") && !descriptionProduit.equals("") && qteProduit > 0 && !prixProduit.equals("")) {
				// Produits unProduit = new Produits (nomProduit, imageProduit, descriptionProduit, qteProduit, prixProduit, date_ajout);
				// Modele.insertProduit(unProduit);
				JOptionPane.showMessageDialog(this, "Insertion du produit réussi !");
				this.txtNomProduit.setText("");
				this.txtDescriptionProduit.setText("");
				this.txtQteProduit.setText("");
				this.txtPrixProduit.setText("");
			}
			
		} else if (e.getSource() == this.btRechercher) {
			String mot = this.txtMot.getText();
			Object matrice [][] = this.getLesDonnees(mot);
			unTableau.setDonnees(matrice);
		} else if (e.getSource() == this.btImage) {
			JFileChooser fileChooser = new JFileChooser();
			int result = fileChooser.showOpenDialog(null);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
			}
		}
	}

}
