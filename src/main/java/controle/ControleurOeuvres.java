package controle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import dao.*;
import meserreurs.MonException;
import metier.*;
import utilitaires.FonctionsUtiles;

import java.util.Date;

/**
 * Servlet implementation class ControleurAdherents
 */
@WebServlet("/ControleurOeuvres")
public class ControleurOeuvres extends Controleur {

    private static final String CONSULTER_CATALOGUE = "consulterCatalogue";
    private static final String AJOUTER_OEUVRE = "ajouterOeuvre";
    private static final String INSERER_OEUVRE = "insererOeuvre";
    private static final String MODIFIER_OEUVRE = "modifierOeuvre";

    protected String dispatcher(HttpServletRequest request) {
        String destinationPage;
        String actionName = request.getParameter(ACTION_TYPE);
        if (CONSULTER_CATALOGUE.equals(actionName)) {
            try {
                ServiceOeuvrevente unServiceOeuvrevente = new ServiceOeuvrevente();
                request.setAttribute("mesOeuvres", unServiceOeuvrevente.getList());
            } catch (Exception e) {
                e.printStackTrace();
            }
            destinationPage = "/consulterCatalogue.jsp";
        }
        else if (MODIFIER_OEUVRE.equals(actionName)) {
            try {
                int idOeuvre = Integer.parseInt(request.getParameter("idOeuvre"));
                Oeuvrevente uneOeuvre = new Oeuvrevente();
                if(request.getParameter("txtTitre")!=null && request.getParameter("txtEtat")!=null && request.getParameter("txtPrix")!=null && request.getParameter("txtIDProprietaire")!=null){
                    if(request.getParameter("txtEtat").length()>1){
                        request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré. Veillez à ce que le champ état ne comporte qu'un seul caractère."});
                    }
                    else{
                        uneOeuvre.setTitreOeuvrevente(request.getParameter("txtTitre"));
                        uneOeuvre.setEtatOeuvrevente(request.getParameter("txtEtat"));
                        uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtPrix")));
                        uneOeuvre.setProprietaire(new ServiceProprietaire().get(Integer.parseInt(request.getParameter("txtIDProprietaire"))));
                        new ServiceOeuvrevente().update(idOeuvre,uneOeuvre);
                        request.setAttribute("mesInfos", new String[]{"L'oeuvre numéro "+idOeuvre+" a bien été modifiée."});
                    }
                }
                uneOeuvre = new ServiceOeuvrevente().get(idOeuvre);
                request.setAttribute("mesProprietaires", new ServiceProprietaire().getList());
                request.setAttribute("monOeuvre", uneOeuvre);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré. Veillez à avoir renseigner tous les champs correctement."});
            }
            destinationPage = "/modifierOeuvre.jsp";
        }
        else if (AJOUTER_OEUVRE.equals(actionName)) {
            try {
                request.setAttribute("mesProprietaires", new ServiceProprietaire().getList());
            } catch (MonException e) {
                e.printStackTrace();
                request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré en chargeant les propriétaires."});
            }
            destinationPage = "/ajouterOeuvre.jsp";
        }
        else if (INSERER_OEUVRE.equals(actionName)) {
            Oeuvrevente uneOeuvre = new Oeuvrevente();
            try {
                uneOeuvre.setTitreOeuvrevente(request.getParameter("txtTitre"));
                uneOeuvre.setEtatOeuvrevente(request.getParameter("txtEtat"));
                uneOeuvre.setPrixOeuvrevente(Float.parseFloat(request.getParameter("txtPrix")));
                uneOeuvre.setProprietaire(new ServiceProprietaire().get(Integer.parseInt(request.getParameter("txtIDProprietaire"))));
                new ServiceOeuvrevente().insert(uneOeuvre);
                request.setAttribute("mesInfos", new String[]{"L'oeuvre a bien été ajoutée."});
                try {
                    ServiceOeuvrevente unServiceOeuvrevente = new ServiceOeuvrevente();
                    request.setAttribute("mesOeuvres", unServiceOeuvrevente.getList());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                destinationPage = "/consulterCatalogue.jsp";
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré. Veillez à avoir renseigner tous les champs correctement."});
                request.setAttribute("monOeuvre", uneOeuvre);
                try {
                    request.setAttribute("mesProprietaires", new ServiceProprietaire().getList());
                } catch (MonException e1) {
                    e1.printStackTrace();
                    request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré en chargeant les propriétaires."});
                }
                destinationPage = "/ajouterOeuvre.jsp";
            }
        }
        else{
            destinationPage = error(request);
        }
        return destinationPage;
    }
}
