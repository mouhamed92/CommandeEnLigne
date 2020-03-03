package model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import beans.Client;
import beans.Commande;

public class ControleCmd {
	
    private static final String CHAMP_MONTANT          = "montantCommande";
    private static final String CHAMP_MODE_PAIEMENT    = "modePaiementCommande";
    private static final String CHAMP_STATUT_PAIEMENT  = "statutPaiementCommande";
    private static final String CHAMP_MODE_LIVRAISON   = "modeLivraisonCommande";
    private static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
    
    private static final String FORMAT_DATE            = "dd/MM/yyyy HH:mm:ss";
    
    Map<String, String> erreurs = new HashMap<String, String>();
    String resultat ;

	public Commande commandeForm(HttpServletRequest request){
		
		String montant = getValeurChamp( request, CHAMP_MONTANT );
        String modePaiement = getValeurChamp( request, CHAMP_MODE_PAIEMENT );
        String statutPaiement = getValeurChamp( request, CHAMP_STATUT_PAIEMENT );
        String modeLivraison = getValeurChamp( request, CHAMP_MODE_LIVRAISON );
        String statutLivraison = getValeurChamp( request, CHAMP_STATUT_LIVRAISON );

		
		ControleClt clt = new ControleClt();
		Client client = clt.clientForm(request);
		
		erreurs = clt.getErreurs() ;
		
		DateTime dt = new DateTime();
		DateTimeFormatter formatter = DateTimeFormat.forPattern(FORMAT_DATE);
		String date = dt.toString(formatter);
		
		Commande commande = new Commande() ;
		
		
		commande.setClient(client);
		commande.setDate(date);
		 double valeurMontant = -1;
	        try {
	            valeurMontant = validerMT( montant );
	        } catch ( Exception e ) {
	            erreurs.put( CHAMP_MONTANT, e.getMessage() );
	        }
		commande.setMontant(montant);
		
		try {
			validerMP(modePaiement);
		} catch (Exception e) {
			erreurs.put(CHAMP_MODE_PAIEMENT, e.getMessage());
		}
		commande.setMode_paiment(modePaiement );
		
		try {
			validerSP(statutPaiement);
		} catch (Exception e) {
			erreurs.put(CHAMP_STATUT_PAIEMENT, e.getMessage());
		}
		commande.setStatut_paiment(statutPaiement );
		
		try {
			validerML(modeLivraison);
		} catch (Exception e) {
			erreurs.put(CHAMP_MODE_LIVRAISON, e.getMessage());
		}
		commande.setMode_livraison(modeLivraison );
		
		try {
			validerSL(statutLivraison);
		} catch (Exception e) {
			erreurs.put(CHAMP_STATUT_LIVRAISON, e.getMessage());
		}
		commande.setStatut_livraison(statutLivraison);
		
		if(erreurs.isEmpty()){
	    	resultat ="Succès de la création du commande.";
	    }else{
	    	resultat ="Échec de la création du commande.";
	    }
		
		
		return commande;
		
	}
	

	 private double validerMT( String montant ) throws Exception {
	        double temp;
	        if ( montant != null ) {
	            try {
	                temp = Double.parseDouble( montant );
	                if ( temp < 0 ) {
	                    throw new Exception( "Le montant doit être un nombre positif." );
	                }
	            } catch ( NumberFormatException e ) {
	                temp = -1;
	                throw new Exception( "Le montant doit être un nombre." );
	            }
	        } else {
	            temp = -1;
	            throw new Exception( "Merci d'entrer un montant." );
	        }
	        return temp;
	    }



	private void validerSL(String statutLivraison) throws Exception {
		if ( statutLivraison != null && statutLivraison.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caractères." );
        }
		
	}


	private void validerML(String modeLivraison) throws Exception {
		 if ( modeLivraison != null ) {
	            if ( modeLivraison.length() < 2 ) {
	                throw new Exception( "Le mode de livraison doit contenir au moins 2 caractères." );
	            }
	        } else {
	            throw new Exception( "Merci d'entrer un mode de livraison." );
	        }
		
	}


	private void validerSP(String statutPaiement) throws Exception {
		if ( statutPaiement != null && statutPaiement.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caractères." );
        }
		
	}


	private void validerMP(String modePaiement) throws Exception {
		if ( modePaiement != null ) {
            if ( modePaiement.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
		
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public String getResultat() {
		return resultat;
	}


	private String getValeurChamp(HttpServletRequest request, String champ) {
		
		String valeur = request.getParameter(champ);
		if(valeur == null || valeur.trim().length()==0)
		return null;
		else
		return valeur;
	}
}
