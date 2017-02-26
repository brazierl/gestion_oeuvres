package dao;

import meserreurs.MonException;
import metier.Adherent;
import metier.Oeuvrepret;
import metier.Proprietaire;
import persistance.DialogueBd;

import java.util.ArrayList;
import java.util.List;

public class ServiceOeuvrepret {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insert(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "";
			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Oeuvrepret get(int numero) throws MonException {
		String mysql = "";
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		Oeuvrepret uneOp = buildObjectFromRS(rs,0);
		return uneOp;
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Oeuvrepret> getList() throws MonException {
		String mysql = "select * from oeuvrepret";
		List<Oeuvrepret> mesOeuvres = new ArrayList<Oeuvrepret>();
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		mesOeuvres = buildListFromRS(rs);
		return mesOeuvres;
	}

	private Oeuvrepret buildObjectFromRS(List<Object> rs, int start){
		Oeuvrepret uneOp = new Oeuvrepret();
		// il faut redecouper la liste pour retrouver les lignes
		String ss = rs.get(start + 0).toString();
		String sss = rs.get(start + 2).toString();
		uneOp.setIdOeuvrepret(Integer.parseInt(rs.get(start + 0).toString()));
		uneOp.setTitreOeuvrepret(rs.get(start + 1).toString());
		Proprietaire prop = new ServiceProprietaire().get(Integer.parseInt(rs.get(start + 2).toString()));
		uneOp.setProprietaire(prop);
		return uneOp;
	}

	private List<Oeuvrepret> buildListFromRS(List<Object> rs){
		List<Oeuvrepret> mesOeuvres = new ArrayList<Oeuvrepret>();
		int index = 0;
		while (index < rs.size()) {
			Oeuvrepret uneOp = buildObjectFromRS(rs,index);
			mesOeuvres.add(uneOp);
			index += 4;
		}
		return mesOeuvres;
	}
}
