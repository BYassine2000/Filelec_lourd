package controleur;

public class Produits {
	
	private int idProduit;
	private String nomProduit, imageProduit, descriptionProduit;
	private int qteProduit, prixProduit, idType;
	private String date_ajout;
	
	public Produits(int idProduit, String nomProduit, String imageProduit, String descriptionProduit, int qteProduit,
			int prixProduit, int idType, String date_ajout) {
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.imageProduit = imageProduit;
		this.descriptionProduit = descriptionProduit;
		this.qteProduit = qteProduit;
		this.prixProduit = prixProduit;
		this.idType = idType;
		this.date_ajout = date_ajout;
	}
	
	public Produits(String nomProduit, String imageProduit, String descriptionProduit, int qteProduit,
			int prixProduit, int idType, String date_ajout) {
		this.idProduit = 0;
		this.nomProduit = nomProduit;
		this.imageProduit = imageProduit;
		this.descriptionProduit = descriptionProduit;
		this.qteProduit = qteProduit;
		this.prixProduit = prixProduit;
		this.idType = idType;
		this.date_ajout = date_ajout;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getImageProduit() {
		return imageProduit;
	}

	public void setImageProduit(String imageProduit) {
		this.imageProduit = imageProduit;
	}

	public String getDescriptionProduit() {
		return descriptionProduit;
	}

	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}

	public int getQteProduit() {
		return qteProduit;
	}

	public void setQteProduit(int qteProduit) {
		this.qteProduit = qteProduit;
	}

	public int getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(int prixProduit) {
		this.prixProduit = prixProduit;
	}
	
	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(String date_ajout) {
		this.date_ajout = date_ajout;
	}

}
