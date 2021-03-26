package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextField txtComune;

    @FXML
    private TextField txtAlieno;

    @FXML
    private Button btnTraduci;

    @FXML
    private TextField txtTraduci;

    @FXML
    private TextArea txtStampa;

    @FXML
    void doClear(ActionEvent event) {
    	txtStampa.clear();
    }

    @FXML
    void doInserisci(ActionEvent event) {

    }

    @FXML
    void doTraduci(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtComune != null : "fx:id=\"txtComune\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAlieno != null : "fx:id=\"txtAlieno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTraduci != null : "fx:id=\"btnTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTraduci != null : "fx:id=\"txtTraduci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStampa != null : "fx:id=\"txtStampa\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
