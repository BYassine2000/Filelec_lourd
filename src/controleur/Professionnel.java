package controleur;

public class Professionnel {

	private int idClient;
	private String nom, tel, email, mdp, adresse, cp, ville, pays, numSIRET, statut, etat, role;

	public Professionnel(int idClient, String nom, String tel, String email, String mdp,
			String adresse, String cp, String ville, String pays, String numSIRET, String statut, String etat,
			String role) {
		this.idClient = idClient;
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.numSIRET = numSIRET;
		this.statut = statut;
		this.etat = etat;
		this.role = role;
	}

	public Professionnel(String nom, String tel, String email, String mdp, String adresse,
			String cp, String ville, String pays, String numSIRET, String statut, String etat, String role) {
		this.idClient = 0;
		this.nom = nom;
		this.tel = tel;
		this.email = email;
		this.mdp = mdp;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.pays = pays;
		this.numSIRET = numSIRET;
		this.statut = statut;
		this.etat = etat;
		this.role = role;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getNumSIRET() {
		return numSIRET;
	}

	public void setNumSIRET(String numSIRET) {
		this.numSIRET = numSIRET;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
