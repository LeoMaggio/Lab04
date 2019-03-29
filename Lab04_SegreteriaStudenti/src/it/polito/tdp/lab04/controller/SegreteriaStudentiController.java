package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.*;

import it.polito.tdp.lab04.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private Button btnIscritti;

    @FXML
    private TextField matricola;

    @FXML
    private Button btnComplete;

    @FXML
    private TextField nome;

    @FXML
    private TextField cognome;

    @FXML
    private Button btnCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    void doComplete(ActionEvent event) {
    	int id = 0;
    	try {
			id = Integer.parseInt(matricola.getText().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			Studente s = this.model.getStudente(id);
			cognome.setText(s.getCognome());
			cognome.setDisable(true);
			nome.setText(s.getNome());
			nome.setDisable(true);
			txtResult.clear();
		} catch (Exception e) {
			e.printStackTrace();
			txtResult.appendText("Inserire una matricola corretta per effettuare il completamento\n");
			matricola.clear();
		}
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	matricola.clear();
    	cognome.clear();
    	nome.clear();
    	cognome.setDisable(false);
    	nome.setDisable(false);
    }

    @FXML
    void doSearchCorsi(ActionEvent event) {
    	List<Corso> corsi = new LinkedList<Corso>();
    	int id = 0;
    	try {
			id = Integer.parseInt(matricola.getText().trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
    	try {
			Studente s = this.model.getStudente(id);
			if(!s.getCognome().equals(this.cognome.getText().toUpperCase()) || !s.getNome().equals(this.nome.getText().toUpperCase())) {
				txtResult.appendText("Dati inseriti in modo errato\n");
				matricola.clear();
				cognome.clear();
				nome.clear();
				return;
			}
			corsi = this.model.getCorsi(id);
			for(Corso c : corsi) {
				txtResult.appendText(c.toString()+"\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
			txtResult.appendText("Dati inseriti in modo errato\n");
			matricola.clear();
		}
    }

    @FXML
    void doSearchIscritti(ActionEvent event) {
    	List<Studente> studenti = new LinkedList<Studente>();
    	try {
			StringTokenizer st = new StringTokenizer (this.combo.getValue(), " ");
			String codins = st.nextToken().trim();
			if(codins.equals("Tutti"))
				studenti = this.model.getTuttiGliStudenti();
			else {
				Corso corso = new Corso(codins, -1, null, -1);
				studenti = this.model.getStudentiIscrittiAlCorso(corso);
			}
			for(Studente s : studenti) {
				txtResult.appendText(s.toString()+"\n");
			}
		} catch (Exception e) {
			txtResult.appendText("Selezionare un corso\n");
		}
    }

    @FXML
    void initialize() {
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert combo != null : "fx:id=\"combo\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscritti != null : "fx:id=\"btnIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert matricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnComplete != null : "fx:id=\"btnComplete\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCorsi != null : "fx:id=\"btnCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model = model;
    	this.combo.getItems().addAll(model.getTuttiINomiDeiCorsi());
    }
}
