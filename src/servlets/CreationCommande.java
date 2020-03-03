package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Commande;
import model.ControleCmd;


@WebServlet("/CreationCommande")
public class CreationCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreationCommande() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getServletContext().getRequestDispatcher("/creeCommande.jsp")
			.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ControleCmd cmd = new ControleCmd() ;
		Commande commande = cmd.commandeForm(request);
		Map<String, String> erreurs = cmd.getErreurs();
		String resultat = cmd.getResultat();
		
		request.setAttribute("commande", commande);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("resultat", resultat);
		
		if(erreurs.isEmpty()){
			request.getServletContext().getRequestDispatcher("/afficheCommande.jsp")
			.forward(request, response);
		}else{
			request.getServletContext().getRequestDispatcher("/creeCommande.jsp")
			.forward(request, response);
		}
	}

}
