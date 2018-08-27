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
		
		String line;
		
	try {
		BufferedReader br = new BufferedReader(new FileReader(f));
        
       
			while((line = br.readLine()) != null){
			    
			    StringTokenizer st = new StringTokenizer(line);
			   
			    
			    while(st.hasMoreTokens()){
			        
			        String istruzione = st.nextToken();
			        int anno = Integer.parseInt(st.nextToken());
			        String id = st.nextToken();
			        
			        if(istruzione.equals("build")) {
			            
			            String lato = st.nextToken();                          //forse ci conviene mettere "lato" come String, altrimenti c'è qualche conversione da fare
			            int distanza = Integer.parseInt(st.nextToken());
			            int base = Integer.parseInt(st.nextToken());
			            int altezza = Integer.parseInt(st.nextToken());
			            
			        }
			    	
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	

}
