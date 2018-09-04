package soluzione;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Megalopolis {
	
	Set<String> ID = new HashSet<String>();		//set di identificativi dei palazzi presenti
	int minSudLimit = 0;		//distanza minima dal fiume degli edifici del lato Sud
	int MaxSudLimit = 0;		//distanza massima dal fiume degli edifici del lato Sud
	int minNordLimit = 0;		//distanza minima dal fiume degli edifici del lato Nord
	int MaxNordLimit = 0;		//distanza massima dal fiume degli edifici del lato Nord
	ArrayList<Palazzo> NordBuildings;	//lista di edifici del lato Nord
	ArrayList<Palazzo> SudBuildings;	//lista di edifici del lato Sud
	
	/**Funzione che inserisce, in base all'altezza,il palazzo nella lista appropriateo**/
	public void Build(Palazzo p) {
		if(p.getLato()=="N") {
			//funzione per inserire l'edificio a nord
			for(int i=0; i<NordBuildings.size(); i++) {
				if(p.getAltezza()>NordBuildings.get(i).getAltezza()) {
					NordBuildings.add(i, p);
				}
			}
			
			LimitNUpdate(p);
			
		}else {
			//funzione per inserire l'edificio a sud
			for(int i=0; i<SudBuildings.size(); i++) {
				if(p.getAltezza()>SudBuildings.get(i).getAltezza()) {
					SudBuildings.add(i, p);
				}
			}
			LimitSUpdate(p);
		}
		
		ID.add(p.getId());
		
	}
	
	public void Demolish(String id) {
		
		for(int i=0; i<NordBuildings.size(); i++) {
			if(id == NordBuildings.get(i).getId()) {
				if(NordBuildings.get(i).getLimit() == MaxNordLimit ||
						NordBuildings.get(i).getDistanza() == minNordLimit) {
					NordBuildings.remove(i);
					LimitChange('N');
					}else NordBuildings.remove(i);
				ID.remove(id);
				return;
			}
		}
		
		
		for(int i=0; i< SudBuildings.size(); i++) {
			if(id == SudBuildings.get(i).getId()) {
				if(SudBuildings.get(i).getLimit() == MaxSudLimit ||
						SudBuildings.get(i).getDistanza() == minSudLimit) {
					
					SudBuildings.remove(i);
					LimitChange('S');
					
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
	
	private void LimitChange(char lato) {
		if(lato == 'N') {
			for(int i=0; i < NordBuildings.size(); i++) {
				LimitNUpdate(NordBuildings.get(i));
			}
		}else if(lato =='S'){
			for(int i = 0; i < SudBuildings.size(); i++) {
				LimitSUpdate(SudBuildings.get(i));
			}
		}
	}
	
	public void UpdateHistory(int anno) {
		/*calcolare ampiezza altezza e salvarli nella lista della storia*/
		SklHistory temp = new SklHistory();
		temp.setAnno(anno);
		temp.setAmpiezza((MaxNordLimit+MaxSudLimit));
		temp.setAltezza(AverageH());
		SklHistory.Data.add(temp);
		
	}
	
	public double AverageH() {
		boolean[] bSud = new boolean[MaxSudLimit-minSudLimit];        
        boolean[] bNord = new boolean[MaxNordLimit-minNordLimit];
        double AltMedia = 0;
        
        for(int i=0; i< NordBuildings.size(); i++) {
        	
        	for(int k=0; k<NordBuildings.get(i).getLimit();k++) {
        		if(bNord[k] ==false){
					AltMedia += NordBuildings.get(i).getAltezza();
					bNord[k]=true;
					}
        	}        	
        }
        
        for (int i=0; i< SudBuildings.size(); i++) {
        	
        	for(int k=0; k<SudBuildings.get(i).getLimit();k++) {
        		if(bSud[k] ==false){
					AltMedia += SudBuildings.get(i).getAltezza();
					bSud[k]=true;
					}
        	}        	
        }
        return (AltMedia/(MaxNordLimit+MaxSudLimit));
        
	}

}
