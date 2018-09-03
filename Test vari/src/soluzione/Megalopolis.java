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
	

}
