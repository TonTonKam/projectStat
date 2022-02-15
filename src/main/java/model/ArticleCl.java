package model;

import java.sql.Date;

public class ArticleCl {

	//attributs
	private String titre, contenu, resume, image, auteur, libelle;
	private int idArticle, idCategorie, idUser, idVue, idSigne;
	private Date date;
	private boolean isVisible;
	
	//constructeur
	public ArticleCl(String titre, String contenu, String resume, String image, int idSigne,
			int idArticle, int idUser, String auteur, int idCategorie, String libelle, int idVue,
			Date date, boolean isVisible) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.resume = resume;
		this.image = image;
		this.idUser = idUser;
		this.auteur = auteur;
		this.idSigne = idSigne;
		this.idArticle = idArticle;
		this.idCategorie = idCategorie;
		this.libelle = libelle;
		this.idVue = idVue;
		this.date = date;
		this.isVisible = isVisible;
	}
	
	public ArticleCl(String titre, String contenu, String resume, String image, int idArticle,
			int idUser, String auteur, int idCategorie) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.resume = resume;
		this.image = image;
		this.idUser = idUser;
		this.auteur = auteur;
		this.idArticle = idArticle;
		this.idCategorie = idCategorie;
	}
	
	public ArticleCl(String titre, String contenu, int idUser, String auteur, int idCategorie) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.idUser = idUser;
		this.auteur = auteur;
		this.idCategorie = idCategorie;
	}
	
	public ArticleCl(String titre, String contenu, String image, int idCategorie , int idArticle) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.image = image;
		this.idCategorie = idCategorie;
		this.idArticle = idArticle;
	}


	//getter
	public String getTitre() {
		return titre;
	}
	
	public String getContenu() {
		return contenu;
	}
	public String getResume() {
		return resume;
	}

	public String getImage() {
		return image;
	}

	public int getIdSigne() {
		return idSigne;
	}

	public int getIdArticle() {
		return idArticle;
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}

	public int getIdVue() {
		return idVue;
	}

	public Date getDate() {
		return date;
	}

	public boolean isVisible() {
		return isVisible;
	}

	@Override
	public String toString() {
		return "Article [titre=" + titre + ", contenu=" + contenu + ", resume=" + resume + ", image=" + image
			+ ", auteur=" + auteur + ", idArticle=" + idArticle + ", idCategorie=" + idCategorie + ", idUser="
			+ idUser + ", vues=" + idVue + ", idSigne=" + idSigne + ", date=" + date + ", isVisible=" + isVisible + "]";
	}
	
	
}
