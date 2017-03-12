package dao;

import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Reservation;
import metier.Adherent;
import persistance.DialogueBd;
import utilitaires.FonctionsUtiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Louis on 26/02/2017.
 */
public class ServiceReservation {
    public void insert(Reservation uneResa) throws MonException {
        String mysql;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "insert into reservation (id_oeuvrevente,id_adherent,date_reservation,statut) values ('"+uneResa.getOeuvrevente().getIdOeuvrevente()+"','"+uneResa.getAdherent().getIdAdherent()+"','"+FonctionsUtiles.conversionDateenChaine(uneResa.getDate(),"yyyy-mm-dd")+"','"+uneResa.getStatut()+"')";
            unDialogueBd.insertionBD(mysql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(int idOeuvre, int idAdherent, Date date, Reservation nouvelleReservation){
        String mysql;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        try {
            mysql = "update reservation set id_oeuvrevente = "+nouvelleReservation.getOeuvrevente().getIdOeuvrevente()+", id_adherent = "+nouvelleReservation.getAdherent().getIdAdherent()+", date_reservation = '"+FonctionsUtiles.conversionDateenChaine(nouvelleReservation.getDate(),"yyyy-mm-dd")+"', statut = '"+nouvelleReservation.getStatut()+"' where id_oeuvrevente = "+idOeuvre+" and id_adherent = "+idAdherent+" and date_reservation = '"+FonctionsUtiles.conversionDateenChaine(date,"yyyy-mm-dd")+"'";
            unDialogueBd.execute(mysql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // gestion des adherents
    // Consultation d'un adh�rent par son num�ro
    // Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
    // BDD
    public Reservation get(int idOeuvreVente,int idAdherent, Date date) throws MonException {
        try {String mysql = null;
            mysql = "select * from reservation where id_oeuvrevente="+idOeuvreVente+" and id_adherent="+idAdherent+" and date_reservation='"+ FonctionsUtiles.conversionDateenChaine(date,"yyyy-mm-dd")+"';";
            DialogueBd unDialogueBd = DialogueBd.getInstance();
            List<Object> rs = DialogueBd.lecture(mysql);
            Reservation uneResa = buildObjectFromRS(rs,0);
            return uneResa;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MonException();
        }
    }

    // Consultation des adh�rents
    // Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
    // la requ�te BDD
    public List<Reservation> getList() throws MonException {
        String mysql = "select * from reservation";
        List<Reservation> mesResas = new ArrayList<Reservation>();
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        List<Object> rs = DialogueBd.lecture(mysql);
        mesResas = buildListFromRS(rs);
        return mesResas;
    }

    private Reservation buildObjectFromRS(List<Object> rs, int start){
        Reservation uneResa = new Reservation();
        try {
            Oeuvrevente ov = new ServiceOeuvrevente().get(Integer.parseInt(rs.get(start + 0).toString()));
            uneResa.setOeuvrevente(ov);
            Adherent adh = new ServiceAdherent().get(Integer.parseInt(rs.get(start + 1).toString()));
            uneResa.setAdherent(adh);
            uneResa.setDate(FonctionsUtiles.conversionChaineenDate(rs.get(start+2).toString(),"yyyy-mm-dd"));
            uneResa.setStatut(rs.get(start+3).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uneResa;
    }

    private List<Reservation> buildListFromRS(List<Object> rs){
        List<Reservation> mesOeuvres = new ArrayList<Reservation>();
        int index = 0;
        while (index < rs.size()) {
            Reservation uneResa = buildObjectFromRS(rs,index);
            mesOeuvres.add(uneResa);
            index += 4;
        }
        return mesOeuvres;
    }
}
