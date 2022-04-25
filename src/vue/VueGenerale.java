package vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controleur.*;

public class VueGenerale extends JFrame implements ActionListener {
	
	private JButton btQuitter = new JButton("Déconnexion");
	private JButton btProfil = new JButton("Mon Profil");
	private JButton btClients = new JButton("Clients");
	private JButton btParticulier = new JButton("Particulier");
	private JButton btProfessionnel = new JButton("Professionnel");
	private JButton btTypes = new JButton("Types");
	private JButton btProduits = new JButton("Produits");
	private JButton btStats = new JButton("Statistiques");
	private JButton btBoard = new JButton("Dashboard");
	
	private JPanel panelMenu = new JPanel();
	private JPanel panelProfil = new JPanel();
	
	private static PanelClient unPanelClient = new PanelClient();
	private static PanelParticulier unPanelParticulier = new PanelParticulier();
	private static PanelProfessionnel unPanelProfessionnel = new PanelProfessionnel();
	private static PanelType unPanelType = new PanelType();
	private static PanelProduit unPanelProduit = new PanelProduit();
	private static PanelStats unPanelStats = new PanelStats();
	private static PanelBord unPanelBord = new PanelBord();
	
	Font fButton = new Font("Arial", Font.BOLD, 14);
	
	/* Fond panelMenu */
	// private ImageIcon fondPanelMenu;
	// private JLabel labelFond;
	
	public VueGenerale (Admin unAdmin) {
		
		this.setTitle("Filelec - Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(23, 25, 51));
		this.setBounds(300, 300, 1350, 450);
		this.setLayout(null);
		
		this.panelMenu.setLayout(new GridLayout(1,7));
		this.panelMenu.setBounds(20, 10, 1300, 40);
		this.panelMenu.setBackground(new Color(23, 25, 51));
		
		// Boutons menu
		this.btProfil.setFont(fButton);
		this.panelMenu.add(btProfil);
		
		this.btClients.setFont(fButton);
		this.panelMenu.add(btClients);
		
		this.btParticulier.setFont(fButton);
		this.panelMenu.add(btParticulier);
		
		this.btProfessionnel.setFont(fButton);
		this.panelMenu.add(btProfessionnel);
		
		this.btTypes.setFont(fButton);
		this.panelMenu.add(btTypes);
		
		this.btProduits.setFont(fButton);
		this.panelMenu.add(btProduits);
		
		this.btStats.setFont(fButton);
		this.panelMenu.add(btStats);
		
		this.btBoard.setFont(fButton);
		this.panelMenu.add(btBoard);
		
		// Bouton déconnexion
		this.btQuitter.setBackground(Color.RED);
		this.btQuitter.setForeground(Color.WHITE);
		this.btQuitter.setFont(fButton);
		this.panelMenu.add(btQuitter);
		
		this.add(this.panelMenu);
		
		this.panelProfil.setLayout(new GridLayout(2, 1));
		this.panelProfil.setBounds(260, 100, 400, 300);
		this.panelProfil.setBackground(new Color(23, 25, 51));
		this.panelProfil.setVisible(false);
		this.panelProfil.add(new JLabel("ID : " + unAdmin.getIdadmin()));
		this.panelProfil.add(new JLabel("Mail : " + unAdmin.getMail()));
		this.add(this.panelProfil);
		
		this.add(unPanelClient);
		this.add(unPanelParticulier);
		this.add(unPanelProfessionnel);
		this.add(unPanelType);
		this.add(unPanelProduit);
		this.add(unPanelStats);
		this.add(unPanelBord);
		
		this.btQuitter.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btParticulier.addActionListener(this);
		this.btProfessionnel.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btTypes.addActionListener(this);
		this.btProduits.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btBoard.addActionListener(this);
		
		/* Fond panelMenu */
		// this.fondPanelMenu = new ImageIcon(this.getClass().getResource("/dashboard.jpg"));
		// this.labelFond = new JLabel(fondPanelMenu);
		// this.labelFond.setSize(1350, 461);
		// this.add(this.labelFond);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter) {
			Filelec.fermerVueGenerale();
			Filelec.rendreVisibleVueConnexion(true);
		} else if (e.getSource() == this.btProfil) {
			this.btProfil.setBackground(Color.BLACK);
			this.btProfil.setForeground(Color.WHITE);
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(true);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btClients) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(Color.BLACK);
			this.btClients.setForeground(Color.WHITE);
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(true);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btParticulier) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(Color.BLACK);
			this.btParticulier.setForeground(Color.WHITE);
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(true);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btProfessionnel) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(Color.BLACK);
			this.btProfessionnel.setForeground(Color.WHITE);
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(true);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btTypes) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(Color.BLACK);
			this.btTypes.setForeground(Color.WHITE);
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(true);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btProduits) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(Color.BLACK);
			this.btProduits.setForeground(Color.WHITE);
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(true);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btStats) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(Color.BLACK);
			this.btStats.setForeground(Color.WHITE);
			this.btBoard.setBackground(getBackground());
			this.btBoard.setForeground(getForeground());
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(true);
			unPanelBord.setVisible(false);
		} else if (e.getSource() == this.btBoard) {
			this.btProfil.setBackground(getBackground());
			this.btProfil.setForeground(getForeground());
			this.btClients.setBackground(getBackground());
			this.btClients.setForeground(getForeground());
			this.btParticulier.setBackground(getBackground());
			this.btParticulier.setForeground(getForeground());
			this.btProfessionnel.setBackground(getBackground());
			this.btProfessionnel.setForeground(getForeground());
			this.btTypes.setBackground(getBackground());
			this.btTypes.setForeground(getForeground());
			this.btProduits.setBackground(getBackground());
			this.btProduits.setForeground(getForeground());
			this.btStats.setBackground(getBackground());
			this.btStats.setForeground(getForeground());
			this.btBoard.setBackground(Color.BLACK);
			this.btBoard.setForeground(Color.WHITE);
			this.panelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelParticulier.setVisible(false);
			unPanelProfessionnel.setVisible(false);
			unPanelType.setVisible(false);
			unPanelProduit.setVisible(false);
			unPanelStats.setVisible(false);
			unPanelBord.setVisible(true);
		}
	}

}
