package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.Particulier;
import controleur.Professionnel;
import controleur.Tableau;
import modele.Modele;

public class PanelProfessionnel extends PanelDeBase implements ActionListener, ListSelectionListener, ItemListener {
	
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();

	private JLabel titre = new JLabel("Gestion des professionnels");

	Font fButton = new Font("Arial", Font.BOLD, 14);
	Font fTitre = new Font("Arial", Font.BOLD, 30);

	private JButton btAjouter = new JButton("Ajouter");
	private JButton btAnnuler = new JButton("Annuler");

	private JTextField txtNom = new JTextField();
	private JTextField txtTel = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JTextField txtMdp = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txtVille = new JTextField();
	private JTextField txtPays = new JTextField();
	private JTextField txtNumSIRET = new JTextField("521 868 267 00014");
	private JTextField txtStatut =  new JTextField();

	// Les selects
	private JComboBox<String> comboEtat = new JComboBox<String>();
	private JComboBox<String> comboRole = new JComboBox<String>();

	private JTable uneTable = null;

	private static Tableau unTableau = null;

	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");

	public PanelProfessionnel() {
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

		// Options pour le t'?tat du particulier
		String optionsEtat[] = { "Prospect", "Client Courant", "Client Grand Courant" };
		this.comboEtat = new JComboBox(optionsEtat);

		// Options pour le r?le du client
		String optionsRole[] = { "Client", "Admin" };
		this.comboRole = new JComboBox(optionsRole);

		this.panelForm.setLayout(new GridLayout(13, 2));

		this.panelForm.add(new JLabel(" Nom du professionnel : "));
		this.panelForm.add(this.txtNom);

		this.panelForm.add(new JLabel(" T?l?phone du professionnel : "));
		this.panelForm.add(this.txtTel);

		this.panelForm.add(new JLabel(" Email du professionnel : "));
		this.panelForm.add(this.txtEmail);

		this.panelForm.add(new JLabel(" Mot de passe du professionnel : "));
		this.panelForm.add(this.txtMdp);

		this.panelForm.add(new JLabel(" Adresse du professionnel : "));
		this.panelForm.add(this.txtAdresse);

		this.panelForm.add(new JLabel(" Code postale du professionnel : "));
		this.panelForm.add(this.txtCp);

		this.panelForm.add(new JLabel(" Ville du professionnel : "));
		this.panelForm.add(this.txtVille);

		this.panelForm.add(new JLabel(" Pays du professionnel : "));
		this.panelForm.add(this.txtPays);
		
		this.panelForm.add(new JLabel(" Num SIRET : "));
		this.panelForm.add(this.txtNumSIRET);
		
		this.panelForm.add(new JLabel(" Statut du professionnel : "));
		this.panelForm.add(this.txtStatut);

		this.panelForm.add(new JLabel(" Etat du professionnel : "));
		this.panelForm.add(comboEtat);

		this.panelForm.add(new JLabel(" R?le : "));
		this.panelForm.add(comboRole);

		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btAjouter);

		this.panelForm.setBounds(0, 40, 300, 294);
		this.add(this.panelForm);

		this.panelTable.setBounds(345, 40, 935, 300); // Dimension du tableau
		this.panelTable.setBackground(new Color(23, 25, 51));
		this.panelTable.setLayout(null);
		String entetes[] = { "ID", "Nom", "Tel", "Email", "Adresse", "CP", "Ville", "Pays", "SIRET", "Statut", "Etat", "R?le" };
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
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce professionnel ?",
							"Suppression d'un Professionnel", JOptionPane.YES_NO_OPTION);
					if (retour == 0) {
						int idclient = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deleteProfessionnel(idclient);
						unTableau.supprimerLigne(numLigne);
						viderChamps();
					}
				} else if (nbclic == 1) {
					int numLigne = uneTable.getSelectedRow();

					String nom = unTableau.getValueAt(numLigne, 1).toString();
					txtNom.setText(nom);

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
					
					String numSIRET = unTableau.getValueAt(numLigne, 10).toString();
					txtNumSIRET.setText(numSIRET);
					
					String statut = unTableau.getValueAt(numLigne, 11).toString();
					txtStatut.setText(statut);

					String etat = unTableau.getValueAt(numLigne, 12).toString();
					comboEtat.setSelectedItem(etat);

					String role = unTableau.getValueAt(numLigne, 13).toString();
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
		ArrayList<Professionnel> lesProfessionnels = null;
		if (mot.equals("")) {
			lesProfessionnels = Modele.selectAllProfessionnels();
		} else {
			lesProfessionnels = Modele.selectLikeProfessionnel(mot);
		}
		Object[][] matrice = new Object[lesProfessionnels.size()][12];
		int i = 0;
		for (Professionnel unProfessionnel : lesProfessionnels) {
			matrice[i][0] = unProfessionnel.getIdClient();
			matrice[i][1] = unProfessionnel.getNom();
			matrice[i][2] = unProfessionnel.getTel();
			matrice[i][3] = unProfessionnel.getEmail();
			matrice[i][4] = unProfessionnel.getAdresse();
			matrice[i][5] = unProfessionnel.getCp();
			matrice[i][6] = unProfessionnel.getVille();
			matrice[i][7] = unProfessionnel.getPays();
			matrice[i][8] = unProfessionnel.getNumSIRET();
			matrice[i][9] = unProfessionnel.getStatut();
			matrice[i][10] = unProfessionnel.getEtat();
			matrice[i][11] = unProfessionnel.getRole();
			i++;
		}
		return matrice;
	}

	private void viderChamps() {
		this.txtNom.setText("");
		this.txtTel.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtAdresse.setText("");
		this.txtCp.setText("");
		this.txtVille.setText("");
		this.txtPays.setText("");
		this.txtNumSIRET.setText("521 868 267 00014");
		this.txtStatut.setText("");
		this.btAjouter.setBackground(new Color(0, 128, 0));
		this.btAjouter.setText("Ajouter");
	}

	public Professionnel saisirProfessionnel() {
		Professionnel unProfessionnel = null;
		String nom = this.txtNom.getText();
		String tel = this.txtTel.getText();
		String email = this.txtEmail.getText();
		String mdp = this.txtMdp.getText();
		String adresse = this.txtAdresse.getText();
		String cp = this.txtCp.getText();
		String ville = this.txtVille.getText();
		String pays = this.txtPays.getText();
		String numSIRET = this.txtNumSIRET.getText();
		String statut = this.txtStatut.getText();
		String etat = this.comboEtat.getSelectedItem().toString();
		String role = this.comboRole.getSelectedItem().toString();

		if (nom.equals("")) {
			this.txtNom.setBackground(Color.red);
		} else {
			this.txtNom.setBackground(Color.white);
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
		
		if (statut.equals("")) {
			this.txtStatut.setBackground(Color.red);
		} else {
			this.txtStatut.setBackground(Color.white);
		}

		if (!nom.equals("") && !tel.equals("") && !email.equals("") && !mdp.equals("")
				&& !adresse.equals("") && !cp.equals("") && !ville.equals("") && !pays.equals("") && !statut.equals("")) {
			unProfessionnel = new Professionnel(nom, tel, email, mdp, adresse, cp, ville, pays, numSIRET, statut, etat, role);
		} else {
			return null;
		}
		return unProfessionnel;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 
	}

}
