package controle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import metier.*;
import dao.ServiceAdherent;
import meserreurs.*;

/**
 * Servlet implementation class ControleurAdherents
 */
@WebServlet("/ControleurAdherents")
public class ControleurAdherents extends Controleur {
	private static final String LISTER_RADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";

	protected String dispatcher(HttpServletRequest request) {
		String destinationPage;
		String actionName = request.getParameter(ACTION_TYPE);
		if (LISTER_RADHERENT.equals(actionName)) {
			try {
				ServiceAdherent unServiceAdherent = new ServiceAdherent();
				request.setAttribute("mesAdherents", unServiceAdherent.getList());
			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/listerAdherent.jsp";
		} else if (AJOUTER_ADHERENT.equals(actionName)) {
			destinationPage = "/ajouterAdherent.jsp";
		} else if (INSERER_ADHERENT.equals(actionName)) {
			try {
				Adherent unAdherent = new Adherent();
				unAdherent.setNomAdherent(request.getParameter("txtnom"));
				unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
				unAdherent.setVilleAdherent(request.getParameter("txtville"));
				ServiceAdherent unServiceAdherent = new ServiceAdherent();
				unServiceAdherent.insert(unAdherent);
			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
		} else{
			destinationPage = error(request);
		}
		return destinationPage;
	}
}
