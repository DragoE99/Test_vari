package soluzione;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
	
	public static ArrayList<String> Load() {
		System.out.println(Message.InsertEvent);
		ArrayList<String> FilePath = new ArrayList<String>();
		
		String TempPath = getPath();
		if(!PathChecker(TempPath)) {
			//TODO Creare metodo che stampa avviso: Impossibile proseguire con il programma
			System.exit(0);
		}
		FilePath.add(TempPath);
		
		System.out.println(Message.InsertCommand);
		TempPath = getPath();
		if(!PathChecker(TempPath)) {
			System.out.println(Message.ProgramFail);
			System.exit(0);
		}
		FilePath.add(TempPath);
		
		return FilePath;
		
		}
		

	
	
	
/**Prende in input il percorso di un file controlla che esista e ritorna la stringa associata **/
	public static String getPath() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String percorso = null;
		try {
			percorso = br.readLine();
		} catch (IOException e) {
			System.out.println(Message.InputError);
		}		
		return percorso;		
	}
	;
	
	
/**Riceve in input una stringa con locazione e nome del file e controlla che questo esista**/
	public static Boolean PathChecker(String path) {	
				
		try {
		@SuppressWarnings("resource")
		FileReader SKL = new FileReader(path);
		if(SKL.read()== -1) {
			System.out.println(Message.FileEmpty);	
			return false;
		}		
		
		} catch (FileNotFoundException e) {
			System.out.println(Message.PathError);
			return false;
			
		} catch (IOException e) {
			System.out.println(Message.InputError);
			return false;
		}
		
		return true;		
		
	}
	

}
