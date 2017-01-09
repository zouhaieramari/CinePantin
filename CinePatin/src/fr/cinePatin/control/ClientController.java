package fr.cinePatin.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cinePantin.dao.ClientDao;
import fr.cinePantin.dao.ClientDaoJdbcMySQL;
import fr.cinePatin.model.Client;
import fr.cinePatin.model.Compteur;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     // TODO instancier Dao
	private ClientDao Dao = new ClientDaoJdbcMySQL();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/FormulairInscriptionClient.jsp");
		rd.forward(request, response);
		// crees une session et afficher le nombre de conexion au serveur 
				HttpSession session = request.getSession();
				Compteur compteur=  (Compteur)session.getAttribute("compteur");
				if (compteur==null)
				{
					compteur= new Compteur();
					session.setAttribute("compteur", compteur);
				}
				compteur.incremente();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// crees une session et afficher le nombre de conexion au serveur 
				HttpSession session = request.getSession();
				Compteur compteur=  (Compteur)session.getAttribute("compteur");
				if (compteur==null)
				{
					compteur= new Compteur();
					session.setAttribute("compteur", compteur);
				}
				compteur.incremente();
		
		String action = request.getParameter("boutonaction");
		if(action!=null && action.equals("Inscription"))
		{
			boolean saisieOK=true;
			// recuperation de valeur de champ d inscription
			String nom = request.getParameter("nom");
			request.setAttribute("nom", nom);
			String prenom= request.getParameter("prenom");
			request.setAttribute("prenom", prenom);
			String adresse=request.getParameter("adresse");
			String age=request.getParameter("age");
			String email=request.getParameter("email");
			String motdepasse=request.getParameter("motdepasse");
			String confirmation=request.getParameter("confirmation");
			
			// controle sur le champ saisie
			if(nom==null || nom.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreurnom", "le nom est obligatoire");
			}
			if(prenom==null||prenom.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreurprenom", "le prenom est obligatoire");
			}
			if(adresse==null||adresse.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreuradresse", "l adresse est obligatoire");
				
			}
			if(age==null||age.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreurage", "l age est obligatoire");
			}
			if(email==null||age.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreuremail", "l email est obligatoire");
			}
			if(motdepasse==null||motdepasse.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreurmotdepasse", "le mot de pass est obligatoire");
			}
			if(confirmation==null||confirmation.equals(""))
			{
				saisieOK=false;
				request.setAttribute("erreurconfirmation", "la confirmation d email est obligatoire");
			}
			 //test sur le mot de pass est la confirmation sont identique
		if (!motdepasse.equals(confirmation))
			{
				saisieOK=false;
				request.setAttribute("erreurconfirmation", "la confirmation et le mot de pass ne sont pas identique");
				request.setAttribute("erreurmotdepasse", "le mot de pass est obligatoire");
			}
			if(saisieOK)
			{
				Client c = new Client (nom, prenom,email,age);
				
				// on attendat la sauvegarde ds la base de donnees, stocker ds une liste en memoire
				
				ArrayList<Client>listeClients=(ArrayList<Client>)session.getAttribute("listeClients");
				listeClients.add(c);
				
				request.setAttribute("clientAttr", c);
				
			RequestDispatcher rd = request.getRequestDispatcher("/ResultatInscriptionClient.jsp");
			rd.forward(request, response);
				System.out.println("ok");
			}
			else
			{ RequestDispatcher rd = request.getRequestDispatcher("/FormulairInscriptionClient.jsp");
			rd.forward(request, response);
				
			}
		}
		
		
	}

}
