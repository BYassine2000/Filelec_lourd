package controleur;

public class Types {
	
	private int idType;
	private String libelle;
	
	public Types(int idType, String libelle) {
		this.idType = idType;
		this.libelle = libelle;
	}
	
	public Types(String libelle) {
		this.idType = 0;
		this.libelle = libelle;
	}


	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
