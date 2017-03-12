package controle;

import dao.ServiceAdherent;
import dao.ServiceOeuvrevente;
import dao.ServiceReservation;
import meserreurs.MonException;
import metier.Reservation;
import utilitaires.FonctionsUtiles;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Servlet implementation class ControleurAdherents
 */
@WebServlet("/ControleurReservations")
public class ControleurReservations extends Controleur {

    private static final String RESERVER_OEUVRE = "reserverOeuvre";
    private static final String INSERER_RESERVATION = "insererReservation";
    private static final String CONFIRMER_RESERVATIONS = "confirmerReservations";

    protected String dispatcher(HttpServletRequest request) {
        String destinationPage;
        String actionName = request.getParameter(ACTION_TYPE);
        if(RESERVER_OEUVRE.equals(actionName)){
            try {
                int id = Integer.parseInt(request.getParameter("idOeuvre"));
                request.setAttribute("mesAdherents", new ServiceAdherent().getList());
                request.setAttribute("monOeuvre", new ServiceOeuvrevente().get(id));
            } catch (MonException e) {
                e.printStackTrace();
            }
            destinationPage = "/reserverOeuvre.jsp";
        }
        else if(INSERER_RESERVATION.equals(actionName)){
            try {
                Reservation uneResa = new Reservation();
                uneResa.setAdherent(new ServiceAdherent().get(Integer.parseInt(request.getParameter("txtIDAdherent"))));
                uneResa.setOeuvrevente(new ServiceOeuvrevente().get(Integer.parseInt(request.getParameter("txtIDOeuvre"))));
                uneResa.setDate(FonctionsUtiles.conversionChaineenDate(request.getParameter("txtDate"),"yyyy-mm-dd"));
                uneResa.setStatut("en attente");
                ServiceReservation unServiceResa = new ServiceReservation();
                unServiceResa.insert(uneResa);
                request.setAttribute("mesInfos", new String[]{"Demande de réservation enregistrée !"});
                destinationPage = "/index.jsp";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré. Veillez à bien renseigner la date dans le format requis."});
                destinationPage = "/reserverOeuvre.jsp";
            }
        }
        else if(CONFIRMER_RESERVATIONS.equals(actionName)){
            try{
                if(request.getParameter("idOeuvre")!=null && request.getParameter("date")!=null && request.getParameter("idAdherent")!=null){
                    int idOeuvre = Integer.parseInt(request.getParameter("idOeuvre"));
                    int idAdherent = Integer.parseInt(request.getParameter("idAdherent"));
                    Date date = FonctionsUtiles.conversionChaineenDate(request.getParameter("date"),"yyyy-mm-dd");
                    Reservation uneResa = new ServiceReservation().get(idOeuvre,idAdherent,date);
                    uneResa.setStatut("confirmee");
                    new ServiceReservation().update(idOeuvre,idAdherent,date,uneResa);
                    request.setAttribute("mesInfos", new String[]{"La réservation de "+uneResa.getAdherent().getPrenomAdherent()+" "+uneResa.getAdherent().getNomAdherent()+" pour l'oeuvre "+uneResa.getOeuvrevente().getTitreOeuvrevente()+" à la date du "+FonctionsUtiles.conversionDateenChaine(uneResa.getDate(),"dd MMMM yyyy")+" a été confirmée."});
                }
                request.setAttribute("mesReservations", new ServiceReservation().getList());
            }
            catch(Exception e){
                e.printStackTrace();
                request.setAttribute("mesErreurs", new String[]{"Un problème a été rencontré. Veuillez renouveller la confirmation."});
            }
            destinationPage = "/confirmerReservations.jsp";
        }
        else{
            destinationPage = error(request);
        }
        return destinationPage;
    }
}
