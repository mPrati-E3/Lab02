package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class Dizionario {
	
	List<Traduzione> Diz;
	
	public Dizionario () {
		this.Diz=new ArrayList<Traduzione>();
	}
	
	public Dizionario (List<Traduzione> T) {
		this.Diz=T;
	}
	
	public List<Traduzione> getDiz() {
		return Diz;
	}

	public void setDiz(List<Traduzione> diz) {
		Diz = diz;
	}
	

}
