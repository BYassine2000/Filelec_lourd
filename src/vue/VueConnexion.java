package vue;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controleur.*;

public class VueConnexion extends JFrame implements ActionListener, KeyListener {
	
	JPanel panelConnexion = new JPanel();
	private JButton btSeConnecter = new JButton("Se connecter");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtEmail = new JTextField("admin@gmail.com");
	private JPasswordField txtMdp = new JPasswordField("107d348bff437c999a9ff192adcb78cb03b8ddc6");
	
	Font fButton = new Font("Arial", Font.BOLD, 14);
	
	// Fond panelConnexion
	private ImageIcon fondPanelConnexion;
	private JLabel labelFond;
	
	public VueConnexion () {
		this.setTitle("Filelec - Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		// this.getContentPane().setBackground(Color.cyan);
		// this.getContentPane().setBackground(new Color(23, 25, 51));

		this.setBounds(300, 300, 600, 250);
		this.setLayout(null);
		
		// Construction du panel connexion
		this.panelConnexion.setLayout(new GridLayout(3, 2));
		this.panelConnexion.setBounds(300, 40, 260, 150);
		this.panelConnexion.setBackground(new Color(135, 206, 235));

		this.panelConnexion.add(new JLabel(" Adresse email : "));
		this.panelConnexion.add(this.txtEmail);
		
		this.panelConnexion.add(new JLabel(" Mot de passe : "));
		this.panelConnexion.add(this.txtMdp);
		
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeConnecter);
		
		this.add(this.panelConnexion);
		
		// Installation du logo
		ImageIcon leLogo = new ImageIcon("src/images/logo.png");
		JLabel lbLogo = new JLabel(leLogo);
		lbLogo.setBounds(20, 40, 250, 150);
		this.add(lbLogo);
		
		// Styles du bouton Annuler
		this.btAnnuler.setBackground(new Color(178, 34, 34));
		this.btAnnuler.setForeground(Color.WHITE);
		this.btAnnuler.setFont(fButton);
		
		// Styles du bouton SeConnecter
		this.btSeConnecter.setBackground(new Color(0, 128, 0));
		this.btSeConnecter.setForeground(Color.WHITE);
		this.btSeConnecter.setFont(fButton);
		
		// Rendre les boutons écoutables
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		// Rendre les txt écoutables
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		// Fond panelConnexion
		this.fondPanelConnexion = new ImageIcon(this.getClass().getResource("/fond.jpg"));
		this.labelFond = new JLabel(fondPanelConnexion);
		this.labelFond.setSize(585, 211);
		this.add(this.labelFond);
		 
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			traitement ();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler) {
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		} else if (e.getSource() == this.btSeConnecter) {
			traitement();
		}	
	}
	
	public void traitement () {
		String mail = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		// Vérification en BDD de l'user
		Admin unAdmin = Filelec.selectWhereAdmin(mail, mdp);
		
		if (unAdmin == null) {
			JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		} else {
			JOptionPane.showMessageDialog(this, "Vous êtes connecté en tant que " + unAdmin.getMail());

			Filelec.instancierVueGenerale(unAdmin);

			Filelec.rendreVisibleVueConnexion(false);
		}
	}

}
