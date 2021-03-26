package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class Traduzione {
	
	List<String> Comune;
	String Alieno;
	
	public List<String> getComune() {
		return Comune;
	}

	public void setComune(List<String> comune) {
		Comune = comune;
	}

	public String getAlieno() {
		return Alieno;
	}

	public void setAlieno(String alieno) {
		Alieno = alieno;
	}
	
	public Traduzione() {
		this.Comune=new ArrayList<String>();
		this.Alieno="";
	}
	
	public Traduzione(List<String> L, String S) {
		this.Comune=L;
		this.Alieno=S;
	}

}
