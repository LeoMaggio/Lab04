package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO cdao = new CorsoDAO();
	StudenteDAO sdao = new StudenteDAO();
	
	public List<Corso> getTuttiICorsi() {
		return cdao.getTuttiICorsi();
	}
	
	public List<String> getTuttiINomiDeiCorsi() {
		return cdao.getTuttiINomiDeiCorsi();
	}

	public Corso getCorso(Corso corso) {
		return cdao.getCorso(corso);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(Corso corso) {
		return cdao.getStudentiIscrittiAlCorso(corso);
	}
	
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		return cdao.inscriviStudenteACorso(studente, corso);
	}
	
	public List<Studente> getTuttiGliStudenti() {
		return sdao.getTuttiGliStudenti();
	}
	
	public Studente getStudente(int id) {
		return sdao.getStudente(id);
	}
	
	public List<Corso> getCorsi(int id) {
		return sdao.getCorsi(id);
	}
}
