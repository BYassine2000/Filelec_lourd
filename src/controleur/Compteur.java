package controleur;

public class Compteur {
	
	private int idcompteur;
	private String libelle;
	private int nombre;
	
	public Compteur(int idcompteur, String libelle, int nombre) {
		this.idcompteur = idcompteur;
		this.libelle = libelle;
		this.nombre = nombre;
	}
	
	public Compteur(String libelle, int nombre) {
		this.idcompteur = 0;
		this.libelle = libelle;
		this.nombre = nombre;
	}

	public int getIdcompteur() {
		return idcompteur;
	}

	public void setIdcompteur(int idcompteur) {
		this.idcompteur = idcompteur;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

}
