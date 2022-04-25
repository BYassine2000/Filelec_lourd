package modele;

import java.sql.*;
import java.util.ArrayList;

import controleur.Admin;
import controleur.Clients;
import controleur.Particulier;
import controleur.Produits;
import controleur.Professionnel;
import controleur.TP;
import controleur.Types;

public class Modele {
	
	private static Bdd uneBdd = new Bdd ("localhost", "filelec", "root", "");
	
	/***** Gestion des admins *****/
	public static Admin selectWhereAdmin (String mail, String mdp) {
		Admin unAdmin = null;
		String requete = "SELECT * FROM admin WHERE mail = '"+mail+"' and mdp = '"+mdp+"'; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unAdmin = new Admin (
						unResultat.getInt("idadmin"),
						unResultat.getString("mail"),
						unResultat.getString("mdp"),
						unResultat.getInt("droit")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Errehr de requête : " + requete);
		}
		return unAdmin;
	}
	
	/***** GESTION DES PARTICULIERS *****/
	
	// Insertion d'un particulier
	public static void insertParticulier (Particulier unParticulier) {
		String requete = "INSERT INTO particulier VALUES (null, '"
				+ unParticulier.getNom() + "', '"
				+ unParticulier.getPrenom() + "', '"
				+ unParticulier.getTel() + "', '"
				+ unParticulier.getEmail() + "', '"
				+ unParticulier.getMdp() + "', '"
				+ unParticulier.getAdresse() + "', '"
				+ unParticulier.getCp() + "', '"
				+ unParticulier.getVille() + "', '"
				+ unParticulier.getPays() + "', '"
				+ unParticulier.getEtat() + "', '"
				+ unParticulier.getRole() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection de tous les particuliers
	public static ArrayList<Particulier> selectAllParticuliers () {
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		String requete = "SELECT * FROM particulier;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Particulier unParticulier = new Particulier (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("prenom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesParticuliers.add(unParticulier);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesParticuliers;
	}
	
	// Suppression d'un particulier
	public static void deleteParticulier (int idClient) {
		String requete = "DELETE FROM particulier WHERE idClient = "+idClient+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection d'un particulier
	public static Particulier selectWhereParticulier (int idClient) {
		Particulier unParticulier = null;
		String requete = "SELECT * FROM particulier WHERE idClient = "+idClient+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unParticulier = new Particulier (
						unResultat.getInt("idClient"),
						unResultat.getString("nom"),
						unResultat.getString("prenom"),
						unResultat.getString("tel"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("adresse"),
						unResultat.getString("cp"),
						unResultat.getString("ville"),
						unResultat.getString("pays"),
						unResultat.getString("etat"),
						unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unParticulier;
	}
	
	// Edition d'un particulier
	public static void updateParticulier (Particulier unParticulier) {
		String requete = "UPDATE particulier SET nom = '"
				+ unParticulier.getNom() + "', prenom = '"
				+ unParticulier.getPrenom() + "', tel = '"
				+ unParticulier.getTel() + "', email = '"
				+ unParticulier.getEmail() + "', mdp = '"
				+ unParticulier.getMdp() + "', adresse = '"
				+ unParticulier.getAdresse() + "', cp = '"
				+ unParticulier.getCp() + "', ville = '"
				+ unParticulier.getVille() + "', pays = '"
				+ unParticulier.getPays() + "', etat = '"
				+ unParticulier.getEtat() + "', role = '"
				+ unParticulier.getRole() + "' WHERE idClient = "+unParticulier.getIdClient()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Nombre de particuliers
	public static int countParticuliers () {
		int nbparticuliers = 0;
		String requete = "SELECT count(*) as nb FROM particulier;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				nbparticuliers = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return nbparticuliers;
	}
	
	/***** GESTION DES PROFESSIONNELS *****/
	
	// Insertion d'un professionnel
	public static void insertProfessionnel (Professionnel unProfessionnel) {
		String requete = "INSERT INTO professionnel VALUES (null, '"
				+ unProfessionnel.getNom() + "', '"
				+ unProfessionnel.getTel() + "', '"
				+ unProfessionnel.getEmail() + "', '"
				+ unProfessionnel.getMdp() + "', '"
				+ unProfessionnel.getAdresse() + "', '"
				+ unProfessionnel.getCp() + "', '"
				+ unProfessionnel.getVille() + "', '"
				+ unProfessionnel.getPays() + "', '"
				+ unProfessionnel.getNumSIRET() + "', '"
				+ unProfessionnel.getStatut() + "', '"
				+ unProfessionnel.getEtat() + "', '"
				+ unProfessionnel.getRole() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection de tous les professionnels
	public static ArrayList<Professionnel> selectAllProfessionnels () {
		ArrayList<Professionnel> lesProfessionnels = new ArrayList<Professionnel>();
		String requete = "SELECT * FROM professionnel;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Professionnel unProfessionnel = new Professionnel (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("numSIRET"),
						desResultats.getString("statut"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesProfessionnels.add(unProfessionnel);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesProfessionnels;
	}
	
	// Suppression d'un professionnel
	public static void deleteProfessionnel (int idClient) {
		String requete = "DELETE FROM professionnel WHERE idClient = "+idClient+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection d'un professionnel
	public static Professionnel selectWhereProfessionnel (int idClient) {
		Professionnel unProfessionnel = null;
		String requete = "SELECT * FROM professionnel WHERE idClient = "+idClient+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unProfessionnel = new Professionnel (
						unResultat.getInt("idClient"),
						unResultat.getString("nom"),
						unResultat.getString("tel"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("adresse"),
						unResultat.getString("cp"),
						unResultat.getString("ville"),
						unResultat.getString("pays"),
						unResultat.getString("numSIRET"),
						unResultat.getString("statut"),
						unResultat.getString("etat"),
						unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unProfessionnel;
	}
	
	// Edition d'un professionnel
	public static void updateProfessionnel (Professionnel unProfessionnel) {
		String requete = "UPDATE professionnel SET nom = '"
				+ unProfessionnel.getNom() + "', tel = '"
				+ unProfessionnel.getTel() + "', email = '"
				+ unProfessionnel.getEmail() + "', mdp = '"
				+ unProfessionnel.getMdp() + "', adresse = '"
				+ unProfessionnel.getAdresse() + "', cp = '"
				+ unProfessionnel.getCp() + "', ville = '"
				+ unProfessionnel.getVille() + "', pays = '"
				+ unProfessionnel.getPays() + "', etat = '"
				+ unProfessionnel.getEtat() + "', role = '"
				+ unProfessionnel.getRole() + "' WHERE idClient = "+unProfessionnel.getIdClient()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Nombre de professionnels
	public static int countProfessionnels () {
		int nbprofessionnels = 0;
		String requete = "SELECT count(*) as nb FROM professionnel;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				nbprofessionnels = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return nbprofessionnels;
	}
	
	/***** GESTION DES TYPES *****/
	
	// Insertion d'un type
	public static void insertType (Types unType) {
		String requete = "INSERT INTO types VALUES (null, '"
				+ unType.getLibelle() + "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection de tous les types
	public static ArrayList<Types> selectAllTypes () {
		ArrayList<Types> lesTypes = new ArrayList<Types>();
		String requete = "SELECT * FROM types ORDER BY idType";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Types unType = new Types (
						desResultats.getInt("idType"),
						desResultats.getString("libelle")
						);
				lesTypes.add(unType);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesTypes;
	}
	
	// Suppression d'un type
	public static void deleteType (int idType) {
		String requete = "DELETE FROM types WHERE idType = "+idType+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection d'un type
	public static Types selectWhereType (int idType) {
		Types unType = null;
		String requete = "SELECT * FROM types WHERE idType = "+idType+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unType = new Types (
						unResultat.getInt("idType"),
						unResultat.getString("libelle")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unType;
	}
	
	// Edition d'un type
	public static void updateType (Types unType) {
		String requete = "UPDATE types SET libelle = '"
				+ unType.getLibelle() + "' WHERE idType = "+unType.getIdType()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
		
	// Nombre de clients
	public static int countTypes () {
		int nbtypes = 0;
		String requete = "SELECT count(*) as nb FROM types;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				nbtypes = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return nbtypes;
	}
	
	/***** GESTION DES PRODUITS *****/
	
	// Insertion d'un produit
	public static void insertProduit (Produits unProduit) {
		String requete = "INSERT INTO produits VALUES (null, '"
				+ unProduit.getNomProduit() + "', '"
				+ unProduit.getImageProduit() + "', '"
				+ unProduit.getDescriptionProduit() + "', '"
				+ unProduit.getQteProduit() + "', '"
				+ unProduit.getPrixProduit() + "', sysdate());'";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection de tous les produits
	public static ArrayList<Produits> selectAllProduits () {
		ArrayList<Produits> lesProduits = new ArrayList<Produits>();
		String requete = "SELECT * FROM produits";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Produits unProduit = new Produits (
						desResultats.getInt("idProduit"),
						desResultats.getString("nomProduit"),
						desResultats.getString("imageProduit"),
						desResultats.getString("descriptionProduit"),
						desResultats.getInt("qteProduit"),
						desResultats.getInt("prixProduit"),
						desResultats.getInt("idType"),
						desResultats.getString("date_ajout")
						);
				lesProduits.add(unProduit);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesProduits;
	}
	
	// Suppression d'un produit
	public static void deleteProduit (int idProduit) {
		String requete = "DELETE FROM produits WHERE idProduit = "+idProduit+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Sélection d'un produit
	public static Produits selectWhereProduit (int idProduit) {
		Produits unProduit = null;
		String requete = "SELECT * FROM produits WHERE idProduit = "+idProduit+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unProduit = new Produits (
						unResultat.getInt("idProduit"),
						unResultat.getString("nomProduit"),
						unResultat.getString("imageProduit"),
						unResultat.getString("descriptionProduit"),
						unResultat.getInt("qteProduit"),
						unResultat.getInt("prixProduit"),
						unResultat.getInt("idType"),
						unResultat.getString("date_ajout")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unProduit;
	}
	
	// Edition d'un produit
	public static void updateProduit (Produits unProduit) {
		String requete = "UPDATE produits SET nomProduit = '"
				+ unProduit.getNomProduit() + "', imageProduit = '"
				+ unProduit.getImageProduit() + "', descriptionProduit = '"
				+ unProduit.getDescriptionProduit() + "', qteProduit = '"
				+ unProduit.getQteProduit() + "', prixProduit = '"
				+ unProduit.getPrixProduit() + "' WHERE idProduit = "+unProduit.getIdProduit()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
	}
	
	// Nombre de produits
	public static int countProduits () {
		int nbproduits = 0;
		String requete = "SELECT count(*) as nb FROM produits;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				nbproduits = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return nbproduits;
	}
	
	// Nombre de clients
	public static int countClients () {
		int nbclients = 0;
		String requete = "SELECT count(*) as nb FROM clients;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				nbclients = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return nbclients;
	}

	/*
	public static Clients selectWhereClient(String nom, String prenom, String pseudo) {
		Clients unClient = null;
		String requete = "SELECT * FROM clients WHERE "
				+ " nom = '"+nom+"' and prenom = '"+prenom+"' and pseudo = '"+pseudo+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unClient = new Clients (
						unResultat.getInt("idClient"),
						unResultat.getString("nom"),
						unResultat.getString("prenom"),
						unResultat.getString("pseudo"),
						unResultat.getString("tel"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("adresse"),
						unResultat.getString("cp"),
						unResultat.getString("ville"),
						unResultat.getString("pays"),
						unResultat.getString("type"),
						unResultat.getString("qualification"),
						unResultat.getString("droit")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unClient;
	}
	*/

	public static Types selectWhereType(String libelle) {
		Types unType = null;
		String requete = "SELECT * FROM types WHERE "
				+ " libelle = '"+libelle+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unType = new Types (
						unResultat.getInt("idType"),
						unResultat.getString("libelle")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unType;
	}
	
	// Sélection de tous les clients
	public static ArrayList<Clients> selectAllClients () {
		ArrayList<Clients> lesClients = new ArrayList<Clients>();
		String requete = "SELECT * FROM clients;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Clients unClient = new Clients (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesClients;
	}

	public static ArrayList<Clients> selectLikeClient(String mot) {
		ArrayList<Clients> lesClients = new ArrayList<Clients>();
		String requete = "SELECT * FROM clients WHERE "
				+ "nom LIKE '%"+mot+"%' or "
				+ "tel LIKE '%"+mot+"%' or "
				+ "email LIKE '%"+mot+"%' or "
				+ "adresse LIKE '%"+mot+"%' or "
				+ "cp LIKE '%"+mot+"%' or "
				+ "ville LIKE '%"+mot+"%' or "
				+ "pays LIKE '%"+mot+"%' or "
				+ "etat LIKE '%"+mot+"%' or "
				+ "role LIKE '%"+mot+"%';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Clients unClient = new Clients (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesClients;
	}
	
	public static ArrayList<Particulier> selectLikeParticulier(String mot) {
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		String requete = "SELECT * FROM particulier WHERE "
				+ "nom LIKE '%"+mot+"%' or "
				+ "prenom LIKE '%"+mot+"%' or "
				+ "tel LIKE '%"+mot+"%' or "
				+ "email LIKE '%"+mot+"%' or "
				+ "adresse LIKE '%"+mot+"%' or "
				+ "cp LIKE '%"+mot+"%' or "
				+ "ville LIKE '%"+mot+"%' or "
				+ "pays LIKE '%"+mot+"%' or "
				+ "etat LIKE '%"+mot+"%' or "
				+ "role LIKE '%"+mot+"%';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Particulier unParticulier = new Particulier (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("prenom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesParticuliers.add(unParticulier);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesParticuliers;
	}
	
	public static ArrayList<Professionnel> selectLikeProfessionnel(String mot) {
		ArrayList<Professionnel> lesProfessionnels = new ArrayList<Professionnel>();
		String requete = "SELECT * FROM particulier WHERE "
				+ "nom LIKE '%"+mot+"%' or "
				+ "tel LIKE '%"+mot+"%' or "
				+ "email LIKE '%"+mot+"%' or "
				+ "adresse LIKE '%"+mot+"%' or "
				+ "cp LIKE '%"+mot+"%' or "
				+ "ville LIKE '%"+mot+"%' or "
				+ "pays LIKE '%"+mot+"%' or "
				+ "numSIRET LIKE '%"+mot+"%' or "
				+ "statut LIKE '%"+mot+"%' or "
				+ "etat LIKE '%"+mot+"%' or "
				+ "role LIKE '%"+mot+"%';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Professionnel unProfessionnel = new Professionnel (
						desResultats.getInt("idClient"),
						desResultats.getString("nom"),
						desResultats.getString("tel"),
						desResultats.getString("email"),
						desResultats.getString("mdp"),
						desResultats.getString("adresse"),
						desResultats.getString("cp"),
						desResultats.getString("ville"),
						desResultats.getString("pays"),
						desResultats.getString("numSIRET"),
						desResultats.getString("statut"),
						desResultats.getString("etat"),
						desResultats.getString("role")
						);
				lesProfessionnels.add(unProfessionnel);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesProfessionnels;
	}

	public static ArrayList<Types> selectLikeType(String mot) {
		ArrayList<Types> lesTypes = new ArrayList<Types>();
		String requete = "SELECT * FROM types WHERE "
				+ "libelle LIKE '%"+mot+"%';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Types unType = new Types (
						desResultats.getInt("idType"),
						desResultats.getString("libelle")
						);
				lesTypes.add(unType);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesTypes;
	}

	public static ArrayList<Produits> selectLikeProduit(String mot) {
		ArrayList<Produits> lesProduits = new ArrayList<Produits>();
		String requete = "SELECT * FROM produits WHERE "
				+ "nomProduit LIKE '%"+mot+"%' or "
				+ "prixProduit LIKE '%"+mot+"%' or "
				+ "idType LIKE '%"+mot+"%' or "
				+ "date_ajout LIKE '%"+mot+"%';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				Produits unProduit = new Produits (
						desResultats.getInt("idProduit"),
						desResultats.getString("nomProduit"),
						desResultats.getString("imageProduit"),
						desResultats.getString("descriptionProduit"),
						desResultats.getInt("qteProduit"),
						desResultats.getInt("prixProduit"),
						desResultats.getInt("idType"),
						desResultats.getString("date_ajout")
						);
				lesProduits.add(unProduit);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesProduits;
	}
	
	// SELECTION DE LA VUE : TP (TypesProduits)
	public static ArrayList<TP> selectAllTP () {
		ArrayList<TP> lesTPs = new ArrayList<TP>();
		String requete = "SELECT * FROM TP;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next()) {
				TP unTP = new TP (
						desResultats.getString("libelle"),
						desResultats.getString("nomProduit")
						);
				lesTPs.add(unTP);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return lesTPs;
	}

	public static Particulier selectWhereParticulier(String nom, String prenom) {
		Particulier unParticulier = null;
		String requete = "SELECT * FROM particulier WHERE "
				+ " nom = '"+nom+"' AND prenom = '"+prenom+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next()) {
				unParticulier = new Particulier (
						unResultat.getInt("idClient"),
						unResultat.getString("nom"),
						unResultat.getString("prenom"),
						unResultat.getString("tel"),
						unResultat.getString("email"),
						unResultat.getString("mdp"),
						unResultat.getString("adresse"),
						unResultat.getString("cp"),
						unResultat.getString("ville"),
						unResultat.getString("pays"),
						unResultat.getString("etat"),
						unResultat.getString("role")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		} catch (SQLException exp) {
			System.out.println("Erreur de requête : " + requete);
		}
		return unParticulier;
	}

}
