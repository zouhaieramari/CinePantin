package fr.cinePatin.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cinePatin.model.Client;

/**
 * Servlet implementation class ListeClientController
 */
@WebServlet("/ListeClientController")
public class ListeClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client c1 = new Client("toto", "pierre");
		Client c2 = new Client("titi", "jacques");
		Client c3 = new Client("tata", "marc");
		c1.setEmail("toto@gmail.com");
		c2.setAge("22/2/1990");
		ArrayList<Client> liste = new ArrayList<>();
		liste.add(c1);
		liste.add(c2);
		liste.add(c3);
		request.setAttribute("clients", liste);
		RequestDispatcher rd = request.getRequestDispatcher("/ResultatInscriptionClient.jsp");
		rd.forward(request, response);

		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
