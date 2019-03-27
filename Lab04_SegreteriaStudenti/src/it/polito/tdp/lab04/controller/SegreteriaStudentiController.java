package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

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
    private HBox btnIscritti;

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

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doSearchCorsi(ActionEvent event) {

    }

    @FXML
    void doSearchIscritti(MouseEvent event) {

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
    }
}
