package controleur;

public class Admin {
	
	private int idadmin;
	private String mail, mdp;
	private int droit;
	
	public Admin(int idadmin, String mail, String mdp, int droit) {
		this.idadmin = idadmin;
		this.mail = mail;
		this.mdp = mdp;
		this.droit = droit;
	}
	
	public Admin(String mail, String mdp, int droit) {
		this.idadmin = 0;
		this.mail = mail;
		this.mdp = mdp;
		this.droit = droit;
	}

	public int getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getDroit() {
		return droit;
	}

	public void setDroit(int droit) {
		this.droit = droit;
	}

}
