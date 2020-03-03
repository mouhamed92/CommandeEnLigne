package beans;

public class Client {

	private String nom ;
	private String prenom ;
	private String adresse_livraison ;
	private String num_tel ;
	private String email ;
	
	public Client() {
	
	}

	public Client(String nom, String prenom, String adresse_livraison, String num_tel, String email) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse_livraison = adresse_livraison;
		this.num_tel = num_tel;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse_livraison() {
		return adresse_livraison;
	}

	public String getNum_tel() {
		return num_tel;
	}

	public String getEmail() {
		return email;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}

	public void setNum_tel(String num_tel) {
		this.num_tel = num_tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
