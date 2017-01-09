package fr.cinePatin.model;

public class Client {
	private String nom;
	private String prenom;
	private String email;
	private String age;
	
	
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public Client(String nom, String prenom, String email, String age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email=email;
		this.age=age;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
