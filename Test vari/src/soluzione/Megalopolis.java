package soluzione;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Megalopolis {
	
	Set<String> ID = new HashSet<String>();		//set di identificativi dei palazzi presenti
	int minSudLimit = Integer.MAX_VALUE;		//distanza minima dal fiume degli edifici del lato Sud
	int MaxSudLimit = 0;		//distanza massima dal fiume degli edifici del lato Sud
	int minNordLimit = Integer.MAX_VALUE;		//distanza minima dal fiume degli edifici del lato Nord
	int MaxNordLimit = 0;		//distanza massima dal fiume degli edifici del lato Nord
	ArrayList<Palazzo> NordBuildings = new ArrayList<Palazzo>();	//lista di edifici del lato Nord
	ArrayList<Palazzo> SudBuildings = new ArrayList<Palazzo>();	//lista di edifici del lato Sud
	
	/**Funzione che inserisce, in base all'altezza,il palazzo nella lista appropriata**/
	//TODO RICERCA BINARIA PER POSIZIONE EDIFICIO NELLA LISTA 
	public void Build(Palazzo p) {
		boolean inserito = false;		
		
		if(p.getLato().equals("N")) {
			//Inserimento a nord
			int i = NordBuildings.size();
			for(i=i/2; i!=0 && !inserito; i=i/2) {
				if(p.getAltezza()>NordBuildings.get(i).getAltezza()
						&&p.getAltezza()<NordBuildings.get(i-1).getAltezza()) {
						NordBuildings.add(i, p);
						inserito= true;
					}
			}
			if(!inserito) {
				NordBuildings.add(p);
			}
			
			LimitNUpdate(p);
			
		}else if(p.getLato().equals("S")){
			//Inserimento a sud
			int i = SudBuildings.size();
			for(i=i/2; i!=0 && !inserito; i=i/2) {
				if(p.getAltezza()>SudBuildings.get(i).getAltezza()
						&&p.getAltezza()<SudBuildings.get(i-1).getAltezza()) {
						SudBuildings.add(i, p);
						inserito= true;
					}
			}
			if(!inserito) {
				SudBuildings.add(p);
			}
			LimitSUpdate(p);
		}
		
		ID.add(p.getId());
		
	}
	
	/**Funzione per demolire gli edifici**/
	public void Demolish(String id) {
		for(int i=0; i<NordBuildings.size(); i++) {
			
			if(NordBuildings.get(i).getId().equals(id)) {
				
				if(NordBuildings.get(i).getLimit() == MaxNordLimit ||
						NordBuildings.get(i).getDistanza() == minNordLimit) {
					
					NordBuildings.remove(i);
					LimitChange("N");
					
					}else NordBuildings.remove(i);
				
				ID.remove(id);
				return;
			}
		}
		
		
		for(int i=0; i< SudBuildings.size(); i++) {
			if(SudBuildings.get(i).getId().equals(id)) {
				
				if(SudBuildings.get(i).getLimit() == MaxSudLimit ||
						SudBuildings.get(i).getDistanza() == minSudLimit) {					
					SudBuildings.remove(i);
					LimitChange("S");
				}else SudBuildings.remove(i);
				
				ID.remove(id);
				return;				
			}
			
		}
				
	}
	
	/**Controlla e aggiorna la distanza minima e massima dal fiume del lato Nord**/
	private void LimitNUpdate(Palazzo p) {
		if(p.getDistanza() < minNordLimit) minNordLimit=p.getDistanza();
		if(p.getLimit() > MaxNordLimit) MaxNordLimit = p.getLimit(); 
		}
	
	/**Controlla e aggiorna la distanza minima e massima dal fiume del lato Sud**/
	private void LimitSUpdate(Palazzo p) {
		if (p.getDistanza() < minSudLimit) minSudLimit = p.getDistanza();
		if(p.getLimit()> MaxSudLimit) MaxSudLimit = p.getLimit();
	}
	
	/**Funzione che controlla se l'identificativo di un palazzo è già in uso**/
	public Boolean CheckId(String Identificativo) {
		return (ID.contains(Identificativo));
	}
	
	private void LimitChange(String lato) {
		if(lato.equals("N")) {
			MaxNordLimit = 0;
			minNordLimit = Integer.MAX_VALUE;
			for(int i=0; i < NordBuildings.size(); i++) {
				LimitNUpdate(NordBuildings.get(i));
			}
		}else if(lato.equals("S")){
			MaxSudLimit =0;
			minSudLimit = Integer.MAX_VALUE;
			for(int i = 0; i < SudBuildings.size(); i++) {
				LimitSUpdate(SudBuildings.get(i));
			}
		}
	}
	
	public void UpdateHistory(int anno) {
		/*calcolare ampiezza altezza e salvarli nella lista della storia*/
		SklHistory temp = new SklHistory(anno, size(anno),height(anno));
		/*temp.setAnno(anno);
		temp.setAmpiezza(size(anno));
		temp.setAltezza(height(anno));*/
		DataManager.Data.add(temp);
		
	}
	
	public int size(int year) {
		return ((MaxNordLimit+MaxSudLimit));
	}
	
	public double height(int year) {
		boolean[] bSud = new boolean[MaxSudLimit];        
        boolean[] bNord = new boolean[MaxNordLimit];
        double AltMedia = 0;
        
        for(int i=0; i< NordBuildings.size(); i++) {
        	
        	for(int k = NordBuildings.get(i).getDistanza(); k < NordBuildings.get(i).getLimit(); k++) {
        		if(bNord[k] ==false){
					AltMedia += NordBuildings.get(i).getAltezza();
					bNord[k]=true;
					}
        	}        	
        }
        
        for (int i=0; i < SudBuildings.size(); i++) {
        	
        	for(int k =SudBuildings.get(i).getDistanza(); k< SudBuildings.get(i).getLimit();k++) {
        		if(bSud[k] ==false){
					AltMedia += SudBuildings.get(i).getAltezza();
					bSud[k]=true;
					}
        	}        	
        }
        return ((AltMedia/(MaxNordLimit+MaxSudLimit)));
        
	}

}
