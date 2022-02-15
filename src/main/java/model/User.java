package model;

import java.sql.Date;

public class User {

	//attribut
	private String nom, prenom, email, password, civilite;
	private int idUser, idStatus, age;
	private Date dateInscription;
	
	//constructeur	
	public User(String nom, String prenom, int age, String civilite, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.civilite = civilite;
	}
	
	public User(int idUser, String nom, String prenom, int age, String civilite, String email, String password,
			Date dateInscription, int idStatus) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.civilite = civilite;
		this.dateInscription = dateInscription;
		this.idStatus = idStatus;
	}
	
	public User(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public User(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public User(String nom, int idUser, int idStatus) {
		super();
		this.nom = nom;
		this.idUser = idUser;
		this.idStatus = idStatus;
	}
	

	//getter
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCivilite() {
		return civilite;
	}

	public int getIdUser() {
		return idUser;
	}

	public int getIdStatus() {
		return idStatus;
	}
	
	public int getAge() {
		return age;
	}
	public Date getDateInscription() {
		return dateInscription;
	}

}
