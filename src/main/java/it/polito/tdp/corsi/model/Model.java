package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao=new CorsoDAO();
	}
	
	public List<Corso> getCorsiByPeriodo(Integer pd){
		return corsoDao.getCorsiByPeriodo(pd);
	}
	
	public Map<Corso, Integer> getIscrttiByPeriodo(Integer pd){
		return corsoDao.getIscrittiByPriodo(pd);
	}
	
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDao.getStudentiByCorso(new Corso(codice, null, null, null));
	}
	
	public Map<String, Integer> getDivisioneCDS (String codice) {
		//Soluzione 1
		/*
		Map<String, Integer> divisione=new HashMap<>();
		List<Studente> studenti=this.getStudentiByCorso(codice);
		for(Studente s:studenti) {
			if(s.getCDS()!=null && !s.getCDS().equals("")) {
				if(divisione.get(s.getCDS())==null) { //se CDS non è ancora presente lo aggiungo
					divisione.put(s.getCDS(), 1);
				} else { //se CDS già presente nella mappa aggiorno il valore
					divisione.put(s.getCDS(), divisione.get(s.getCDS()+1));
				}
			}
		}*/
		
		//return divisione;
		return corsoDao.getDivisioneStudenti(new Corso(codice, null, null, null));
	}

	public boolean esisteCorso(String codice) {
		return corsoDao.esisteCorso(new Corso(codice, null, null, null));
	}
	
}
