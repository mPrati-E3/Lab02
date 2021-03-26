package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private ImageView imgAlieno;

    @FXML
    void doClear(ActionEvent event) {
    	txtStampa.clear();
    	txtComune.clear();
    	txtAlieno.clear();
    	txtTraduci.clear();
    	model.reset();
    }

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	String TC = txtComune.getText();
    	String TA = txtAlieno.getText();
    	TC.toLowerCase();
    	TA.toLowerCase();
    	txtComune.clear();
    	txtAlieno.clear();
    	
    	if (TC.length()==0) {
    		txtStampa.appendText("Le scritte non possono essere vuote! \n");
    		return;
    	}
    	if (TA.length()==0) {
    		txtStampa.appendText("Le scritte non possono essere vuote! \n");
    		return;
    	}
    	
    	if (TC.matches("[a-z]+") && TA.matches("[a-z]+")) {
    		if (model.inserisci(TC,TA)) {
    			txtStampa.appendText("Nuova traduzione inserita con successo! \n");
    			return;
    		} else {
    			txtStampa.appendText("Inserimento fallito! Trovata ripetizione! \n");
    			return;
    		}
    	} else {
    		txtStampa.appendText("Le scritte non possono contenere numeri o caratteri speciali! \n");
    		return;
    	}
    	
    	
    	


    }

    @FXML
    void doTraduci(ActionEvent event) {
    	
    	txtStampa.clear();
    	
    	String T = txtTraduci.getText();
    	T.toLowerCase();
    	txtTraduci.clear();
    	
    	if (T.length()==0) {
    		txtStampa.appendText("Le scritte non possono essere vuote! \n");
    		return;
    	}
    	
    	if (T.matches("[a-z]+") || T.matches("[?]")) {
    		String S = model.traduci(T);
    		txtStampa.appendText(S);
    	} else {
    		txtStampa.appendText("Le scritte non possono contenere numeri o caratteri speciali eccetto '?' \n");
    		return;
    	}
    	
    	
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
        assert imgAlieno!= null : "fx:id=\"imgAlieno\" was not injected: check your FXML file 'Scene.fxml'.";
        
        Image I = new Image("alien.png");
        imgAlieno.setImage(I);
    }
    
    public void setModel(Model m) {
    	this.model=m;
    }
}
