package vue;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import controleur.Clients;
import controleur.Tableau;
import modele.Modele;

public class PanelClient extends PanelDeBase implements ActionListener {

	private JPanel panelTable = new JPanel();

	private JLabel titre = new JLabel("Liste des Clients");

	Font fButton = new Font("Arial", Font.BOLD, 14);
	Font fTitre = new Font("Arial", Font.BOLD, 30);

	private JTable uneTable = null;

	private static Tableau unTableau = null;

	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");

	public PanelClient() {
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

		this.panelTable.setBounds(2, 40, 1300, 300); // Dimension du tableau
		this.panelTable.setBackground(new Color(23, 25, 51));
		this.panelTable.setLayout(null);
		String entetes[] = { "ID", "Nom","Tel", "Email", "Adresse", "CP", "Ville", "Pays", "Etat", "Rôle" };
		Object donnees[][] = this.getLesDonnees("");
		unTableau = new Tableau(entetes, donnees);
		this.uneTable = new JTable(unTableau);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for (int i=0; i<uneTable.getColumnCount(); i++) {
			uneTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		
		// this.uneTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		/* Colonne ID */
		// Alignement du texte
		// uneTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		// Largeur de la colonne
		uneTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		
		// Largeur de la colonne 'Nom'
		uneTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		
		/* Colonne Tel */
		// uneTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		uneTable.getColumnModel().getColumn(2).setPreferredWidth(90);
		
		/* Colonne Email */
		// Largeur de la colonne
		uneTable.getColumnModel().getColumn(3).setPreferredWidth(190);
		
		// Largeur de la colonne 'CP'
		// uneTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		uneTable.getColumnModel().getColumn(5).setPreferredWidth(0);
				
		// Largeur de la colonne 'Rôle'
		// uneTable.getColumnModel().getColumn(9).setPreferredWidth(10);
		
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(2, 10, 1300, 280); // Dimension du tableau d'affichage
		this.panelTable.add(uneScroll);

		this.add(this.panelTable);

	}

	public Object[][] getLesDonnees(String mot) {
		ArrayList<Clients> lesClients = null;
		if (mot.equals("")) {
			lesClients = Modele.selectAllClients();
		} else {
			lesClients = Modele.selectLikeClient(mot);
		}	
		Object[][] matrice = new Object[lesClients.size()][10];
		int i = 0;
		for (Clients unClient : lesClients) {
			matrice[i][0] = unClient.getIdClient();
			matrice[i][1] = unClient.getNom();
			matrice[i][2] = unClient.getTel();
			matrice[i][3] = unClient.getEmail();
			matrice[i][4] = unClient.getAdresse();
			matrice[i][5] = unClient.getCp();
			matrice[i][6] = unClient.getVille();
			matrice[i][7] = unClient.getPays();
			matrice[i][8] = unClient.getEtat();
			matrice[i][9] = unClient.getRole();
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btRechercher) {
			String mot = this.txtMot.getText();
			Object matrice [][] = this.getLesDonnees(mot);
			unTableau.setDonnees(matrice);
		}
	}

}
