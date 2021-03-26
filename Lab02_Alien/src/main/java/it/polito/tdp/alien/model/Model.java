package it.polito.tdp.alien.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import it.polito.tdp.alien.Dizionario;
import it.polito.tdp.alien.Traduzione;

public class Model {
	
	Dizionario Diz = new Dizionario();

	public String traduci(String S) {
		
		//gestione wildcard "?" --- bisogna usare matches() e non equals() per attivare le regex
		String SOrig = S;
		S=S.replaceAll("\\?", ".");
		
	
		//variabili temporaneee
		int F = 0;
		
		List<Traduzione> D = Diz.getDiz();
		
		String TraduzioneEseguita = "";
		List<String> TempC = new ArrayList<String>();
		String TempA = "";
		//----------------------
		
		
		//cerco di capire se la traduzione è A->C o C->A (flag F) e poi cerco la traduzione 
		for (int i=0; i<D.size(); i++) {
			if (D.get(i).getAlieno().matches(S)) {
				TempC = D.get(i).getComune();
				F = 1;
			}
			for (int j=0; j<D.get(i).getComune().size(); j++) {
				if (D.get(i).getComune().get(j).matches(S)) {
					TempA = TempA + D.get(i).getAlieno() + " ";
					F = 2;
				}
			}
			
		}
		
		
		//a seconda del risultato di F, stamperò un messaggio diverso
		if (F==1) {
			TraduzioneEseguita = "Traduzione eseguita: "+SOrig+" -> "+TempC+"\n";
		} else if (F==2){
			TraduzioneEseguita = "Traduzione eseguita: "+SOrig+" -> "+TempA+"\n";
		} else {
			TraduzioneEseguita = "Traduzione fallita! \n";
		}
		
		
		return TraduzioneEseguita;
		
	}
	
	//funzione dedicata solamente a controllare se la traduzione non è nel database,
	//è nel database ma è estendibile o è nel databse e non è ripetibile
	private int checkRipetizione(String tC, String tA) {
		
		//check caso 2: traduzione non ripetibile
		for (int i=0; i<Diz.getDiz().size(); i++) {
			for (int j=0; j<Diz.getDiz().get(i).getComune().size(); j++) {
				if (Diz.getDiz().get(i).getComune().get(j).matches(tC)) {
					return 2;
				}
			}
		}
		
		//check caso 3: traduzione nel database ed estendibile
		for (int i=0; i<Diz.getDiz().size(); i++) {
			if (Diz.getDiz().get(i).getAlieno().matches(tA)) {
				return 3;
			}
		}
		
		//check caso 1: non esiste la traduzione nel database quindi la creo
		return 1;

	}

	public boolean inserisci(String tC, String tA) {
		
		//a seconda di come mi risponde la funzione di check, agisco in modo differente
		switch (checkRipetizione(tC,tA)) {
			//nuovo campo nel dizionario
			case 1:
				List<String> TempC = new ArrayList<String>();
				TempC.add(tC);
				Traduzione TempT = new Traduzione(TempC, tA);
				Diz.getDiz().add(TempT);
				return true;
			//non posso procedere in quanto c'è una ripetizione nei comuni
			case 2:
				return false;
			//estensione della traduzione
			case 3:
				for (int i=0; i<Diz.getDiz().size(); i++) {
					if (Diz.getDiz().get(i).getAlieno().matches(tA)) {
						Diz.getDiz().get(i).getComune().add(tC);
					}
				}
				return true;
			//casi di errore
			case 0:
				return false;
			default:
				return false;
				
		}
		
	}

	//genero un nuovo dizionario
	public void reset() {
		this.Diz = new Dizionario();	
	}

}
