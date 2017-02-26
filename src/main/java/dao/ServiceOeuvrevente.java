package dao;

import meserreurs.MonException;
import metier.Oeuvrevente;
import metier.Proprietaire;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;

public class ServiceOeuvrevente {

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Oeuvrevente get(int numero) throws MonException {
		String mysql = "";
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		Oeuvrevente uneOv = buildObjectFromRS(rs,0);
		return uneOv;
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Oeuvrevente> getList() throws MonException {
		String mysql = "select * from oeuvrepret";
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		mesOeuvres = buildListFromRS(rs);
		return mesOeuvres;
	}

	private Oeuvrevente buildObjectFromRS(List<Object> rs, int start){
		Oeuvrevente uneOv = new Oeuvrevente();
		// il faut redecouper la liste pour retrouver les lignes
		uneOv.setIdOeuvrevente(Integer.parseInt(rs.get(start + 0).toString()));
		uneOv.setTitreOeuvrevente(rs.get(start + 1).toString());
		uneOv.setEtatOeuvrevente(rs.get(start + 2).toString());
		uneOv.setPrixOeuvrevente(Float.parseFloat(rs.get(start + 3).toString()));
		Proprietaire prop = new ServiceProprietaire().get(Integer.parseInt(rs.get(start + 4).toString()));
		uneOv.setProprietaire(prop);
		return uneOv;
	}

	private List<Oeuvrevente> buildListFromRS(List<Object> rs){
		List<Oeuvrevente> mesOeuvres = new ArrayList<Oeuvrevente>();
		int index = 0;
		while (index < rs.size()) {
			Oeuvrevente uneOp = buildObjectFromRS(rs,index);
			mesOeuvres.add(uneOp);
			index += 5;
		}
		return mesOeuvres;
	}
}
