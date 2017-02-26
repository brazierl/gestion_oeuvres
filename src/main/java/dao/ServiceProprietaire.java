package dao;

import meserreurs.MonException;
import metier.Proprietaire;
import persistance.DialogueBd;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Louis on 25/02/2017.
 */
public class ServiceProprietaire {
    public Proprietaire get(int numero){
        String mysql = "select * from proprietaire where id_proprietaire="+numero;
        DialogueBd unDialogueBd = DialogueBd.getInstance();
        List<Object> rs = null;
        try {
            rs = DialogueBd.lecture(mysql);
        } catch (MonException e) {
            e.printStackTrace();
        }
        Proprietaire unProp = buildObjectFromRS(rs,0);
        return unProp;
    }

    private Proprietaire buildObjectFromRS(List<Object> rs, int start){
        Proprietaire unProp = new Proprietaire();
        // il faut redecouper la liste pour retrouver les lignes
        unProp.setIdProprietaire(Integer.parseInt(rs.get(start + 0).toString()));
        unProp.setNomProprietaire(rs.get(start + 1).toString());
        unProp.setPrenomProprietaire(rs.get(start + 2).toString());
        return unProp;
    }

    private List<Proprietaire> buildListFromRS(List<Object> rs){
        List<Proprietaire> mesProprietaires = new ArrayList<Proprietaire>();
        int index = 0;
        while (index < rs.size()) {
            Proprietaire unA = buildObjectFromRS(rs,index);
            mesProprietaires.add(unA);
            index += 3;
        }
        return mesProprietaires;
    }
}
