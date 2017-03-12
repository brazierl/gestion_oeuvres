package dao;

import meserreurs.MonException;
import java.util.*;

import metier.*;
import persistance.*;

public class ServiceAdherent {

	// Mise � jour des caract�ristiques d'un adh�rent
	// Le booleen indique s'il s'agit d'un nouvel adh�rent, auquel cas on fait
	// une cr�ation

	public void insert(Adherent unAdherent) throws MonException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
					+ unAdherent.getNomAdherent();
			mysql += "'" + ",'" + unAdherent.getPrenomAdherent() + "','" + unAdherent.getVilleAdherent() + "')";

			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	// gestion des adherents
	// Consultation d'un adh�rent par son num�ro
	// Fabrique et renvoie un objet adh�rent contenant le r�sultat de la requ�te
	// BDD
	public Adherent get(int numero) throws MonException {
		String mysql = "select * from adherent where id_adherent=" + numero;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		Adherent unA = buildObjectFromRS(rs,0);
		return unA;
	}

	// Consultation des adh�rents
	// Fabrique et renvoie une liste d'objets adh�rent contenant le r�sultat de
	// la requ�te BDD
	public List<Adherent> getList() throws MonException {
		String mysql = "select * from adherent";
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		List<Object> rs = DialogueBd.lecture(mysql);
		mesAdherents = buildListFromRS(rs);
		return mesAdherents;
	}

	private Adherent buildObjectFromRS(List<Object> rs, int start){
		Adherent unA = new Adherent();
		// il faut redecouper la liste pour retrouver les lignes
		unA.setIdAdherent(Integer.parseInt(rs.get(start + 0).toString()));
		unA.setNomAdherent(rs.get(start + 1).toString());
		unA.setPrenomAdherent(rs.get(start + 2).toString());
		unA.setVilleAdherent(rs.get(start + 3).toString());
		return unA;
	}

	private List<Adherent> buildListFromRS(List<Object> rs){
		List<Adherent> mesAdherents = new ArrayList<Adherent>();
		int index = 0;
		while (index < rs.size()) {
			Adherent unA = buildObjectFromRS(rs,index);
			mesAdherents.add(unA);
			index += 4;
		}
		return mesAdherents;
	}
}
