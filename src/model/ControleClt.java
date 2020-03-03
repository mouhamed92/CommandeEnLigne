package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Client;

public class ControleClt {
	
	Client client ;
	
	private Map<String, String> erreurs = new HashMap<String, String>() ;
	
	private String resultat ;
	
	private static final String CHAMP_NOM = "nomClient";
	private static final String CHAMP_PRENOM = "prenomClient";
	private static final String CHAMP_ADRESSE = "adresseClient";
	private static final String CHAMP_TEL = "telephoneClient";
	private static final String CHAMP_EMAIL = "emailClient";
	
	public Client clientForm(HttpServletRequest request){
		
		String nom = getValeurChamp(request,CHAMP_NOM);
		String prenom = getValeurChamp(request,CHAMP_PRENOM);
		String livraison =  getValeurChamp(request,CHAMP_ADRESSE);
		String tel =  getValeurChamp(request,CHAMP_TEL);
		String email = getValeurChamp(request,CHAMP_EMAIL);
		
	    client = new Client();
	    
	    try {
			verifNom(nom);
			
		} catch (Exception e) {
			setErreurs(CHAMP_NOM,e.getMessage());
		}
	    client.setNom(nom);
	    
	    try {
			verifPrenom(prenom);
			
		} catch (Exception e) {
			setErreurs(CHAMP_PRENOM, e.getMessage());
		}
	    client.setPrenom(prenom);
	    
	    try {
			verifAdresse(livraison);
			
		} catch (Exception e) {
			setErreurs(CHAMP_ADRESSE, e.getMessage());
		}
	    client.setAdresse_livraison(livraison);
	    
	    try {
	    	
			verifTel(tel);
		} catch (Exception e) {
			setErreurs(CHAMP_TEL, e.getMessage());
		}
	    client.setNum_tel(tel);
	    
	    try {
	    	
			verifEmai(email);
		} catch (Exception e) {
			setErreurs(CHAMP_EMAIL, e.getMessage());
		}
	    client.setEmail(email);
	    
	    if(erreurs.isEmpty()){
	    	resultat ="Succès de la création du client.";
	    }else{
	    	resultat ="Échec de la création du client.";
	    }
		
	    return client;
		
	}

	

	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public String getResultat() {
		return resultat;
	}

	private void verifEmai(String email) throws Exception {
	 if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }
	}



	private void verifTel(String tel) throws Exception {
		if(tel.length()<8 && tel.matches("^\\d+$")){
			throw new Exception("Entrer un numéro de téléphone valide");
		}
		
	}



	private void verifAdresse(String livraison) throws Exception{
		if(livraison.length()<10){
			throw new Exception("L'adresse de livraison doit contenir au moins 10 caractères.");
		}
		
	}



	private void verifPrenom(String prenom)throws Exception {
		if(prenom.length()<2){
			throw new Exception("Le prenom d'utilisateur doit contenir au moins 2 caractères.");
		}
		
	}



	private void verifNom(String nom)throws Exception {
		if(nom.length()<2){
			throw new Exception("Le nom d'utilisateur doit contenir au moins 2 caractères.");
		}
		
	}

	private String getValeurChamp(HttpServletRequest request, String champ) {
		String valeur = request.getParameter(champ);
		return valeur;
	}
	
	private void setErreurs(String champ, String message) {
		
		erreurs.put(champ, message);
	}
	
}
