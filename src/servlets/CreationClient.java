package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Client;
import model.ControleClt;


@WebServlet("/CreationClient")
public class CreationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CreationClient() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		request.getServletContext().getRequestDispatcher("/creeClient.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ControleClt clt = new ControleClt();
	    Client client = clt.clientForm(request);
	    String resultat = clt.getResultat();
	    Map<String,String> erreurs = clt.getErreurs();
	    
	    request.setAttribute("client", client);
	    request.setAttribute("resultat", resultat);
	    request.setAttribute("erreurs", erreurs);
	    
	    if(erreurs.isEmpty()){
	  	    request.getServletContext().getRequestDispatcher("/afficheClient.jsp")
	  		.forward(request, response);
	    }else{
	    	request.getServletContext().getRequestDispatcher("/creeClient.jsp")
			.forward(request, response);
	    }
    }  

}
