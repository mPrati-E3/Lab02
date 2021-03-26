package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.alien.Dizionario;
import it.polito.tdp.alien.Traduzione;

public class Model {
	
	Dizionario Diz = new Dizionario();

	public String traduci(String S) {
		
		
		S.replaceAll("?", "\\\\d");
		
		int F = 0;
		
		List<Traduzione> D = Diz.getDiz();
		
		String TraduzioneEseguita = "";
		List<String> TempC = new ArrayList<String>();
		String TempA = "";
		
		for (int i=0; i<D.size(); i++) {
			if (D.get(i).getAlieno().equals(S)) {
				TempC = D.get(i).getComune();
				F = 1;
			}
			for (int j=0; j<D.get(i).getComune().size(); j++) {
				if (D.get(i).getComune().get(j).equals(S)) {
					TempA = TempA + D.get(i).getAlieno() + " ";
					F = 2;
				}
			}
			
		}
		
		if (F==1) {
			TraduzioneEseguita = "Traduzione eseguita: "+S+" -> "+TempC+"\n";
		} else if (F==2){
			TraduzioneEseguita = "Traduzione eseguita: "+S+" -> "+TempA+"\n";
		} else {
			TraduzioneEseguita = "Traduzione fallita! \n";
		}
		
		
		return TraduzioneEseguita;
		
	}
	
	private int checkRipetizione(String tC, String tA) {
		
		for (int i=0; i<Diz.getDiz().size(); i++) {
			for (int j=0; j<Diz.getDiz().get(i).getComune().size(); j++) {
				if (Diz.getDiz().get(i).getComune().get(j).equals(tC)) {
					return 2;
				}
			}
		}
		
		for (int i=0; i<Diz.getDiz().size(); i++) {
			if (Diz.getDiz().get(i).getAlieno().equals(tA)) {
				return 3;
			}
		}
		
		return 1;

	}

	public boolean inserisci(String tC, String tA) {
		
		switch (checkRipetizione(tC,tA)) {
			case 1:
				List<String> TempC = new ArrayList<String>();
				Traduzione TempT = new Traduzione(TempC, tA);
				Diz.getDiz().add(TempT);
				return true;
			case 2:
				return false;
			case 3:
				for (int i=0; i<Diz.getDiz().size(); i++) {
					if (Diz.getDiz().get(i).getAlieno().equals(tA)) {
						Diz.getDiz().get(i).getComune().add(tC);
					}
				}
				return true;
			case 0:
				return false;
			default:
				return false;
				
		}
		
	}

	

	public void reset() {
		this.Diz = new Dizionario();	
	}

}
