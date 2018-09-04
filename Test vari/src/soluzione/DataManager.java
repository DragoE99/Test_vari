package soluzione;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataManager {
	
	public static void Process(ArrayList<String> Path) {
		Import(Path.get(0));
		
	}
	
	private static void Import(String f){
		int tempyear = 0;
		String line;
		Megalopolis current = new Megalopolis();
		
	try {
		BufferedReader br = new BufferedReader(new FileReader(f));
        
       
			while((line = br.readLine()) != null){
			    
			    StringTokenizer st = new StringTokenizer(line);
			   
			    
			    while(st.hasMoreTokens()){
			        
			        String istruzione = st.nextToken();
			        int anno = Integer.parseInt(st.nextToken());
			        String id = st.nextToken();
			        
			        if(anno>tempyear && tempyear!=0) {
			        	
			        	current.UpdateHistory(tempyear);
			        }
			        
			        if(istruzione.equals("build") && !current.CheckId(id)) {
			            
			            String lato = st.nextToken();
			            int distanza = Integer.parseInt(st.nextToken());
			            int base = Integer.parseInt(st.nextToken());
			            int altezza = Integer.parseInt(st.nextToken());
			            Palazzo temp = new Palazzo(anno, id, lato, distanza, base, altezza);
			         if(temp.checkBuilding(temp)) {
			        	current.Build(temp);
			        	tempyear = anno;
			         }
			        }else if (istruzione.equals("demolish") && current.CheckId(id)) {
			        	current.Demolish(id);
			        	tempyear = anno;
			        }
			    	
			    }
			}
		} catch (Exception e) {
			System.out.println(Message.InputError);
		} 
	
	//aggiungere calcolo soze e higth pure qui per l'ultimo anno
		
	}
	

}
