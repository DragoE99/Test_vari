package soluzione;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileManager {
	
	public static ArrayList<String> Load(String f1, String f2) {
		ArrayList<String> FilePath = new ArrayList<String>();
		String TempPath;
		
		if(PathChecker(f1)){
			FilePath.add(f1);

		}else {
		System.out.println(Message.InvalidArgument);
		System.out.println(Message.InsertEvent);		
		TempPath = getPath();
		if(!PathChecker(TempPath)) {
			System.out.println(Message.ProgramFail);
			System.exit(0);
		}
		FilePath.add(TempPath);
		}
		
		
		if(PathChecker(f2)) {
			FilePath.add(f2);
		}else {		
		System.out.println(Message.InvalidArgument);	
		System.out.println(Message.InsertCommand);		
		TempPath = getPath();
		if(!PathChecker(TempPath)) {
			System.out.println(Message.ProgramFail);
			System.exit(0);
		}
		FilePath.add(TempPath);
		}
		
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
