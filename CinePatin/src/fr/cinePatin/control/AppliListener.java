package fr.cinePatin.control;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.security.ntlm.Client;

import fr.cinePatin.model.Compteur;

/**
 * Application Lifecycle Listener implementation class AppliListener
 *
 */
@WebListener
public class AppliListener implements ServletContextListener, HttpSessionListener {

	
	private Compteur compteur;
    /**
     * Default constructor. 
     */
    public AppliListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // code declancher la premier fois que l utilisateur va sur le site
    	 // compteur ++
    	this.compteur.incremente();
    	// cree une liste ou on va stocker les clients. on doit le assosier a la session. il disparait a la fin de la session 
    	// on peut simuler a l ajout de produit dans le panier .... a chaque client il ya une session et une panier unique 
    	// le produit ajouter au panier ne doit pas etre stocker dans la base de donner ... panier temporaire 
    	
    	ArrayList<Client> liste = new ArrayList<>();
    	HttpSession session = arg0.getSession();
    	session.setAttribute("listeClients", liste);
    	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // code declancher quand la session disparait (apres timeout) 
    	// la session n est supprimer qu apres l excustion de cette methode 
    	// compteur --
    	this.compteur.decremente();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // creation et initialisation de compteur
    	//code lancer au demarrage de l application (publish)
    	this.compteur= new Compteur();
    	ServletContext sc = arg0.getServletContext();
    	//stoker le compteur dans le contexte
    	sc.setAttribute("compteurutilisateur", compteur);

    }
	
}
