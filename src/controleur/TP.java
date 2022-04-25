package controleur;

public class TP {
	
	private String libelle, nomProduit;

	public TP(String libelle, String nomProduit) {
		this.libelle = libelle;
		this.nomProduit = nomProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

}
