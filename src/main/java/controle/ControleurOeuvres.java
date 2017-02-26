package controle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import dao.ServiceOeuvrepret;
import meserreurs.MonException;

/**
 * Servlet implementation class ControleurAdherents
 */
@WebServlet("/ControleurOeuvres")
public class ControleurOeuvres extends Controleur {

    private static final String CONSULTER_CATALOGUE = "consulterCatalogue";

    protected String dispatcher(HttpServletRequest request) {
        String destinationPage;
        String actionName = request.getParameter(ACTION_TYPE);
        if (CONSULTER_CATALOGUE.equals(actionName)) {
            try {
                ServiceOeuvrepret unServiceOeuvrepret = new ServiceOeuvrepret();
                request.setAttribute("mesOeuvres", unServiceOeuvrepret.getList());
            } catch (MonException e) {
                e.printStackTrace();
            }
            destinationPage = "/consulterCatalogue.jsp";
        } else{
            destinationPage = error(request);
        }
        return destinationPage;
    }
}
