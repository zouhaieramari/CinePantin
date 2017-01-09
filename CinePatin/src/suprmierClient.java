

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cinePatin.model.Client;
import fr.cinePatin.model.Compteur;

/**
 * Servlet implementation class suprmierClient
 */
@WebServlet("/suprmierClient")
public class suprmierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private Client c; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suprmierClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/ResultatInscriptionClient.jsp");
		rd.forward(request, response);
		// crees une session et afficher le nombre de conexion au serveur 
				HttpSession session = request.getSession();
				//Compteur compteur=  (Compteur)session.getAttribute("compteur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Compteur compteur=  (Compteur)session.getAttribute("compteur");
		//if (compteur==null)
		//{
		//	compteur= new Compteur();
			//session.setAttribute("compteur", compteur);
		//}
		//compteur.incremente();

String action = request.getParameter("modifier");
if(action!=null && action.equals("modifier"))
{
	



// on attendat la sauvegarde ds la base de donnees, stocker ds une liste en memoire

ArrayList<Client>listeClients=(ArrayList<Client>)session.getAttribute("listeClients");
listeClients.remove(1);

//request.setAttribute("clientAttr", c);

RequestDispatcher rd = request.getRequestDispatcher("/successInscriptionClient.jsp");
rd.forward(request, response);
System.out.println("ok");
}
	}

}
