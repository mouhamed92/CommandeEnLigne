package beans;

public class Commande {

	private String date ;
	private String montant ;
	private String mode_paiment ;
	private String statut_paiment ;
	private String mode_livraison ;
	private String statut_livraison ;
	private Client client ;
	
	public Commande() {
		
	}

	public Commande(String date, String montant, String mode_paiment, String statut_paiment, String mode_livraison,
			String statut_livraison, Client client) {
		super();
		this.date = date;
		this.montant = montant;
		this.mode_paiment = mode_paiment;
		this.statut_paiment = statut_paiment;
		this.mode_livraison = mode_livraison;
		this.statut_livraison = statut_livraison;
		this.client = client;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	public String getMode_paiment() {
		return mode_paiment;
	}

	public void setMode_paiment(String mode_paiment) {
		this.mode_paiment = mode_paiment;
	}

	public String getStatut_paiment() {
		return statut_paiment;
	}

	public void setStatut_paiment(String statut_paiment) {
		this.statut_paiment = statut_paiment;
	}

	public String getMode_livraison() {
		return mode_livraison;
	}

	public void setMode_livraison(String mode_livraison) {
		this.mode_livraison = mode_livraison;
	}

	public String getStatut_livraison() {
		return statut_livraison;
	}

	public void setStatut_livraison(String statut_livraison) {
		this.statut_livraison = statut_livraison;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
