package model;

public class Categorie {

	//attributs
	private int idCategorie;
	private String libelle;
	
	//constructeur
	public Categorie(int idCategorie, String libelle) {
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	
	//getter
	public int getIdCategorie() {
		return idCategorie;
	}
	
	public String getLibelle() {
		return libelle;
	}

}
