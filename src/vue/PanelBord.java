package vue;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import controleur.TP;
import controleur.Tableau;
import modele.Modele;

public class PanelBord extends PanelDeBase {
	
	private JLabel titre = new JLabel("Tableau de bord de Filelec");
	
	Font fTitre = new Font("Arial", Font.BOLD, 28);
	
	private JPanel panelBord = new JPanel();
	
	private JTable uneTable = null;
	
	private static Tableau unTableau = null;

	public PanelBord() {
		super(new Color(23, 25, 51));
		
		this.titre.setBounds(475, -1, 500, 40);
		this.titre.setForeground(Color.WHITE);
		this.titre.setFont(fTitre);
		this.add(titre);
		
		this.panelBord.setBounds(285, 30, 727, 303);
		this.panelBord.setBackground(new Color(23, 25, 51));
		this.panelBord.setLayout(null);
		
		String entetes[] = {"Types", "Produits"};
		Object donnees [][] = this.getLesDonnees();
		unTableau = new Tableau(entetes, donnees);
		this.uneTable = new JTable(unTableau);
		
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(10, 20, 707, 280);
		this.panelBord.add(uneScroll);
		
		this.add(this.panelBord);
		this.setVisible(false);
	}
	
	public Object[][] getLesDonnees() {
		ArrayList<TP> lesTPs = Modele.selectAllTP();
		Object[][] matrice = new Object[lesTPs.size()][2];
		int i = 0;
		for (TP unTP : lesTPs) {
			matrice[i][0] = unTP.getLibelle();
			matrice[i][1] = unTP.getNomProduit();
			i++;
		}
		return matrice;
	}

}
