package controle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import dao.ServiceAdherent;
import dao.ServiceOeuvrepret;
import dao.ServiceOeuvrevente;
import dao.ServiceReservation;
import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrevente;
import metier.Reservation;
import utilitaires.FonctionsUtiles;

/**
 * Servlet implementation class ControleurAdherents
 */
@WebServlet("/ControleurOeuvres")
public class ControleurOeuvres extends Controleur {

    private static final String CONSULTER_CATALOGUE = "consulterCatalogue";
    private static final String RESERVER_OEUVRE = "reserverOeuvre";
    private static final String INSERER_OEUVRE = "insererOeuvre";

    protected String dispatcher(HttpServletRequest request) {
        String destinationPage;
        String actionName = request.getParameter(ACTION_TYPE);
        if (CONSULTER_CATALOGUE.equals(actionName)) {
            try {
                ServiceOeuvrevente unServiceOeuvrevente = new ServiceOeuvrevente();
                request.setAttribute("mesOeuvres", unServiceOeuvrevente.getList());
            } catch (MonException e) {
                e.printStackTrace();
            }
            destinationPage = "/consulterCatalogue.jsp";
        }
        else if(RESERVER_OEUVRE.equals(actionName)){
            try {
                int id = Integer.parseInt(request.getParameter("idOeuvre"));
                Oeuvrevente uneOeuvre = new ServiceOeuvrevente().get(id);
                request.setAttribute("monOeuvre",uneOeuvre);
            } catch (MonException e) {
                e.printStackTrace();
            }
            destinationPage = "/reserverOeuvre.jsp";
        }
        else if(INSERER_OEUVRE.equals(actionName)){
            try {
                Reservation uneResa = new Reservation();
                uneResa.setAdherent(new ServiceAdherent().get(Integer.parseInt(request.getParameter("txtIDAdherent"))));
                uneResa.setOeuvrevente(new ServiceOeuvrevente().get(Integer.parseInt(request.getParameter("txtIDOeuvrevente"))));
                ServiceReservation unServiceResa = new ServiceReservation();
                unServiceResa.insert(uneResa);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/index.jsp";
        }
        else{
            destinationPage = error(request);
        }
        return destinationPage;
    }
}
