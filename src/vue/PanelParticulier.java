package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.Particulier;
import controleur.Tableau;
import modele.Modele;

public class PanelParticulier extends PanelDeBase implements ActionListener, ListSelectionListener, ItemListener {

	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();

	private JLabel titre = new JLabel("Gestion des particuliers");

	Font fButton = new Font("Arial", Font.BOLD, 14);
	Font fTitre = new Font("Arial", Font.BOLD, 30);

	private JButton btAjouter = new JButton("Ajouter");
	private JButton btAnnuler = new JButton("Annuler");

	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtPays = new JTextField();

	// Les selects
	private JComboBox<String> comboEtat = new JComboBox<String>();
	private JComboBox<String> comboRole = new JComboBox<String>();

	private JTable uneTable = null;

	private static Tableau unTableau = null;

	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");

	public PanelParticulier() {
		super(new Color(23, 25, 51));

		this.titre.setBounds(2, -1, 500, 40);
		this.titre.setForeground(Color.WHITE);
		this.titre.setFont(fTitre);
		this.add(titre);

		this.txtMot.setBounds(980, 10, 150, 20);
		this.add(this.txtMot);

		this.btRechercher.setBounds(1145, 10, 110, 20);
		this.btRechercher.addActionListener(this);
		this.add(this.btRechercher);

		// Options pour le t'état du particulier
		String optionsEtat[] = { "Prospect", "Client Courant", "Client Grand Courant" };
		this.comboEtat = new JComboBox(optionsEtat);

		// Options pour le rôle du client
		String optionsRole[] = { "Client", "Admin" };
		this.comboRole = new JComboBox(optionsRole);

		this.panelForm.setLayout(new GridLayout(12, 2));

		this.panelForm.add(new JLabel(" Nom du particulier : "));
		this.panelForm.add(this.txtNom);

		this.panelForm.add(new JLabel(" Prénom du particulier : "));
		this.panelForm.add(this.txtPrenom);

		this.panelForm.add(new JLabel(" Téléphone du particulier : "));
		this.panelForm.add(this.txtTel);

		this.panelForm.add(new JLabel(" Email du particulier : "));
		this.panelForm.add(this.txtEmail);

		this.panelForm.add(new JLabel(" Mot de passe du particulier : "));
		this.panelForm.add(this.txtMdp);

		this.panelForm.add(new JLabel(" Adresse du particulier : "));
		this.panelForm.add(this.txtAdresse);

		this.panelForm.add(new JLabel(" Code postale du particulier : "));
		this.panelForm.add(this.txtCp);

		this.panelForm.add(new JLabel(" Ville du particulier : "));
		this.panelForm.add(this.txtVille);

		this.panelForm.add(new JLabel(" Pays du particulier : "));
		this.panelForm.add(this.txtPays);

		this.panelForm.add(new JLabel(" Etat du particulier : "));
		this.panelForm.add(comboEtat);

		this.panelForm.add(new JLabel(" Rôle : "));
		this.panelForm.add(comboRole);

		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btAjouter);

		this.panelForm.setBounds(0, 40, 300, 294);
		this.add(this.panelForm);

		this.panelTable.setBounds(345, 40, 935, 300); // Dimension du tableau
		this.panelTable.setBackground(new Color(23, 25, 51));
		this.panelTable.setLayout(null);
		String entetes[] = { "ID", "Nom", "Prénom", "Tel", "Email", "Adresse", "CP", "Ville", "Pays", "Etat",
				"Rôle" };
		Object donnees[][] = this.getLesDonnees("");
		unTableau = new Tableau(entetes, donnees);
		this.uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(10, 10, 915, 280); // Dimension du tableau d'affichage
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
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce particulier ?",
							"Suppression d'un Particulier", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idclient = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteParticulier(idclient);
						unTableau.supprimerLigne(numLigne);
						viderChamps();
					}
				} else if (nbclic == 1) {
					int numLigne = uneTable.getSelectedRow();

					String nom = unTableau.getValueAt(numLigne, 1).toString();
					txtNom.setText(nom);

					String prenom = unTableau.getValueAt(numLigne, 2).toString();
					txtPrenom.setText(prenom);

					String tel = unTableau.getValueAt(numLigne, 3).toString();
					txtTel.setText(tel);

					String email = unTableau.getValueAt(numLigne, 4).toString();
					txtEmail.setText(email);

					String mdp = unTableau.getValueAt(numLigne, 5).toString();
					txtMdp.setText(mdp);

					String adresse = unTableau.getValueAt(numLigne, 6).toString();
					txtAdresse.setText(adresse);

					String cp = unTableau.getValueAt(numLigne, 7).toString();
					txtCp.setText(cp);

					String ville = unTableau.getValueAt(numLigne, 8).toString();
					txtVille.setText(ville);

					String pays = unTableau.getValueAt(numLigne, 9).toString();
					txtPays.setText(pays);

					String etat = unTableau.getValueAt(numLigne, 10).toString();
					comboEtat.setSelectedItem(etat);

					String role = unTableau.getValueAt(numLigne, 11).toString();
					comboRole.setSelectedItem(role);

					btAjouter.setBackground(new Color(13, 110, 253));
					btAjouter.setText("Modifier");
				}
			}
		});

		this.btAnnuler.setBackground(new Color(178, 34, 34));
		this.btAnnuler.setForeground(Color.WHITE);
		this.btAnnuler.setFont(fButton);
		this.btAnnuler.addActionListener(this);

		this.btAjouter.setBackground(new Color(0, 128, 0));
		this.btAjouter.setForeground(Color.WHITE);
		this.btAjouter.setFont(fButton);
		this.btAjouter.addActionListener(this);
	}

	public Object[][] getLesDonnees(String mot) {
		ArrayList<Particulier> lesParticuliers = null;
		if (mot.equals("")) {
			lesParticuliers = Modele.selectAllParticuliers();
		} else {
			lesParticuliers = Modele.selectLikeParticulier(mot);
		}
		Object[][] matrice = new Object[lesParticuliers.size()][12];
		int i = 0;
		for (Particulier unParticulier : lesParticuliers) {
			matrice[i][0] = unParticulier.getIdClient();
			matrice[i][1] = unParticulier.getNom();
			matrice[i][2] = unParticulier.getPrenom();
			matrice[i][3] = unParticulier.getTel();
			matrice[i][4] = unParticulier.getEmail();
			matrice[i][5] = unParticulier.getAdresse();
			matrice[i][6] = unParticulier.getCp();
			matrice[i][7] = unParticulier.getVille();
			matrice[i][8] = unParticulier.getPays();
			matrice[i][9] = unParticulier.getEtat();
			matrice[i][10] = unParticulier.getRole();
			i++;
		}
		return matrice;
	}

	private void viderChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtTel.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtAdresse.setText("");
		this.txtCp.setText("");
		this.txtVille.setText("");
		this.txtPays.setText("");
		this.btAjouter.setBackground(new Color(0, 128, 0));
		this.btAjouter.setText("Ajouter");
	}

	public Particulier saisirParticulier() {
		Particulier unParticulier = null;
		String nom = this.txtNom.getText();
		String prenom = this.txtPrenom.getText();
		String tel = this.txtTel.getText();
		String email = this.txtEmail.getText();
		String mdp = this.txtMdp.getText();
		String adresse = this.txtAdresse.getText();
		String cp = this.txtCp.getText();
		String ville = this.txtVille.getText();
		String pays = this.txtPays.getText();
		String etat = this.comboEtat.getSelectedItem().toString();
		String role = this.comboRole.getSelectedItem().toString();

		if (nom.equals("")) {
			this.txtNom.setBackground(Color.red);
		} else {
			this.txtNom.setBackground(Color.white);
		}

		if (prenom.equals("")) {
			this.txtPrenom.setBackground(Color.red);
		} else {
			this.txtPrenom.setBackground(Color.white);
		}

		if (tel.equals("")) {
			this.txtTel.setBackground(Color.red);
		} else {
			this.txtTel.setBackground(Color.white);
		}

		if (email.equals("")) {
			this.txtEmail.setBackground(Color.red);
		} else {
			this.txtEmail.setBackground(Color.white);
		}

		if (mdp.equals("")) {
			this.txtMdp.setBackground(Color.red);
		} else {
			this.txtMdp.setBackground(Color.white);
		}

		if (adresse.equals("")) {
			this.txtAdresse.setBackground(Color.red);
		} else {
			this.txtAdresse.setBackground(Color.white);
		}

		if (cp.equals("")) {
			this.txtCp.setBackground(Color.red);
		} else {
			this.txtCp.setBackground(Color.white);
		}

		if (ville.equals("")) {
			this.txtVille.setBackground(Color.red);
		} else {
			this.txtVille.setBackground(Color.white);
		}

		if (pays.equals("")) {
			this.txtPays.setBackground(Color.red);
		} else {
			this.txtPays.setBackground(Color.white);
		}

		if (!nom.equals("") && !prenom.equals("") && !tel.equals("") && !email.equals("") && !mdp.equals("")
				&& !adresse.equals("") && !cp.equals("") && !ville.equals("") && !pays.equals("")) {
			unParticulier = new Particulier(nom, prenom, tel, email, mdp, adresse, cp, ville, pays, etat, role);
		} else {
			return null;
		}
		return unParticulier;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.viderChamps();
		} else if (e.getSource() == this.btAjouter && e.getActionCommand().equals("Ajouter")) {
			Particulier unParticulier = this.saisirParticulier();
			Modele.insertParticulier(unParticulier);
			unParticulier = Modele.selectWhereParticulier(unParticulier.getNom(), unParticulier.getPrenom());
			Object ligne[] = {
					unParticulier.getIdClient(), 
					unParticulier.getNom(), 
					unParticulier.getPrenom(),
					unParticulier.getTel(), 
					unParticulier.getEmail(), 
					unParticulier.getMdp(), 
					unParticulier.getAdresse(), 
					unParticulier.getCp(),
					unParticulier.getVille(), 
					unParticulier.getPays(), 
					unParticulier.getEtat(), 
					unParticulier.getRole()
				};
			unTableau.ajouterLigne(ligne);
			JOptionPane.showMessageDialog(this, "Insertion du particulier réussi !");
			this.viderChamps();
		} else if (e.getSource() == this.btAjouter && e.getActionCommand().equals("Modifier")) {
			Particulier unParticulier = this.saisirParticulier();
			int numLigne = this.uneTable.getSelectedRow();
			int idclient = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
			unParticulier.setIdClient(idclient);
			Modele.updateParticulier(unParticulier);
			Object ligne[] = {
					unParticulier.getIdClient(), 
					unParticulier.getNom(), 
					unParticulier.getPrenom(),
					unParticulier.getTel(), 
					unParticulier.getEmail(), 
					unParticulier.getMdp(), 
					unParticulier.getAdresse(), 
					unParticulier.getCp(),
					unParticulier.getVille(), 
					unParticulier.getPays(), 
					unParticulier.getEtat(), 
					unParticulier.getRole()
				};
			unTableau.modifierLigne(numLigne, ligne);
			JOptionPane.showMessageDialog(this, "Modification du particulier effectuée !");
			this.btAjouter.setText("Ajouter");
		} else if (e.getSource() == this.btRechercher) {
			String mot = this.txtMot.getText();
			Object matrice[][] = this.getLesDonnees(mot);
			unTableau.setDonnees(matrice);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}

}
