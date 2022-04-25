package controleur;

import modele.Modele;
import vue.VueConnexion;
import vue.VueGenerale;

public class Filelec {
	
	private static VueConnexion uneConnexion;
	
	private static VueGenerale uneVueGenerale;
	
	public static void rendreVisibleVueConnexion (boolean action) {
		uneConnexion.setVisible(action);
	}
	
	public static void rendreVisibleVueGenerale (boolean action) {
		uneVueGenerale.setVisible(action);
	}
	
	public static void instancierVueGenerale (Admin unAdmin) {
		uneVueGenerale = new VueGenerale(unAdmin);
	}
	
	public static void fermerVueGenerale () {
		uneVueGenerale.dispose();
	}

	public static void main(String[] args) {
		uneConnexion = new VueConnexion();
	}
	
	public static Admin selectWhereAdmin (String mail, String mdp) {
		Admin unAdmin = Modele.selectWhereAdmin(mail, mdp);
		return unAdmin;
	}

}
