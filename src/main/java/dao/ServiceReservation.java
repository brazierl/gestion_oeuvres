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
            mysql = "insert into reservation (id_oeuvrevente,id_adherent,date_reservation) values ('"+uneResa.getOeuvrevente().getIdOeuvrevente()+"','"+uneResa.getAdherent().getIdAdherent()+"','"+uneResa.getDate()+")";
            unDialogueBd.insertionBD(mysql);
        } catch (MonException e) {
            throw e;
        }
    }

    // gestion des adherents
    // Consultation d'un adh�rent par son num�ro
    // Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
    // BDD
    public Reservation get(int idOeuvreVente,int idAdherent) throws MonException {
        String mysql = "select * from reservation";
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        List<Object> rs = DialogueBd.lecture(mysql);
        Reservation uneResa = buildObjectFromRS(rs,0);
        return uneResa;
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
            index += 3;
        }
        return mesOeuvres;
    }
}
