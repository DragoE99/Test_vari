package soluzione;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataManager {
	
	public static ArrayList<SklHistory> Data = new ArrayList<SklHistory>(); 
	
	public static void Process(ArrayList<String> Path) {
		Import(Path.get(0));
		Command(Path.get(1));
		
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
			        
			        if(anno>tempyear&& tempyear!=0) {			        	
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
			br.close();
		} catch (Exception e) {
			System.out.println(Message.InputError);
		
		} 

	current.UpdateHistory(tempyear);
		
	}
	
// TODO aggiungere controllo per anni iniziali (se ti chiede l'altezza di un anno che non c'è
	private static void Command(String f) {
		String line;  
		
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(f));
		
	       
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line);
				
			         
			         while(st.hasMoreTokens()){
			             
			             String istruzione = st.nextToken();
			         
			             if(istruzione.equals("s")){
			                 int year = Integer.parseInt(st.nextToken());
			                 System.out.println(istruzione +  " " + year + " : " + Ampiezza(year));
			             }
			             else if(istruzione.equals("h")){
			                 int year = Integer.parseInt(st.nextToken());
			                 System.out.println(istruzione +  " " + year + " : " + (float)AvarangeH(year));
			             }
			             else
			                 System.out.println("comando non valido");
			         }
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}     
		
	}
	
	
	private static int Ampiezza(int anno) {
		if(Data.get(0).getAnno() <= anno) {
		for(int i=0;i<Data.size() ; i++) {
			if(anno==Data.get(i).getAnno()) {
				return (Data.get(i).getAmpiezza());
			}else if(anno< Data.get(i).getAnno()) {
				return (Data.get(i-1).getAmpiezza());
			}
			
		}
		}
		return 0;		
	}
	
	private static double AvarangeH(int anno) {
		if(Data.get(0).getAnno() <= anno) {
		for(int i=0; i<Data.size(); i++) {
			if(anno == Data.get(i).getAnno()) {
				return (Data.get(i).getAltezza());
			}else if (anno < Data.get(i).getAnno()) {
				return (Data.get(i-1).getAltezza());
			}
			
		}
		}
		return 0;
		
	}
}
