package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> getTuttiGliStudenti() {

		final String sql = "SELECT * FROM studente";

		List<Studente> studenti = new LinkedList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String CDS = rs.getString("CDS");

				System.out.println(matricola + " " + cognome + " " + nome + " " + CDS);

				// Crea un nuovo JAVA Bean Studente
				Studente s = new Studente(matricola, cognome, nome, CDS);
				// Aggiungi il nuovo oggetto Corso alla lista corsi
				studenti.add(s);
			}

			return studenti;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}
	
	/*
	 * Data una matricola, ottengo lo studente
	 */
	public Studente getStudente(int id) {
		String sql = "SELECT * FROM studente WHERE matricola = ?";
		Studente s = null;
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				s = new Studente(rs.getInt("matricola"),
						rs.getString("cognome"),
						rs.getString("nome"),
						rs.getString("CDS"));
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
}
