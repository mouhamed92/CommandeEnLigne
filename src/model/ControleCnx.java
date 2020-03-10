package model;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import beans.Utilisateur;

public class ControleCnx {
	
	private static final String CHAMP_EMAIL ="email";
	private static final String CHAMP_PASS="motdepasse";
	
	Map<String, String> erreurs = new HashMap<String, String>();
	
	String resultat ;
	
	public Utilisateur connexionForm(HttpServletRequest request){
		
		String email = getChamp(request,CHAMP_EMAIL);
		String pass = getChamp(request,CHAMP_PASS);
		
		Utilisateur utilisateur  = new Utilisateur();
		
		try {
			validerMail(email);
		} catch (Exception e) {
		  setErreur(CHAMP_EMAIL,e.getMessage());	
		}
		utilisateur.setEmail(email);
		
		try {
			validerPass(pass);
		} catch (Exception e) {
			setErreur(CHAMP_PASS,e.getMessage());
		}
		utilisateur.setMotDePasse(pass);
		
		if(erreurs.isEmpty()){
			resultat = "Succès de la connexion.";
		}else{
			resultat="Échec de la connexion.";
		}
		return utilisateur;
		
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public String getResultat() {
		return resultat;
	}

	

	private void setErreur(String champ, String message) {
			erreurs.put(champ, message);		
	}

	private void validerMail(String email) throws Exception {
		if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
		
	}
	
	private void validerPass(String pass) throws Exception {
		if ( pass != null ) {
            if ( pass.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
	}

	private String getChamp(HttpServletRequest request ,String champ) {
		String valeur = request.getParameter( champ );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

}
