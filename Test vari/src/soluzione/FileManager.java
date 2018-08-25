package soluzione;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
	
	public static void Load() {
		System.out.println("Inserire il percorso del file degli eventi di costruzione/demolizione:");
		FileChecker(getPath());
	}
	
	/**Prende in input il percorso di un file controlla che esista e ritorna la stringa associata **/
	public static String getPath() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String percorso;
		try {
			percorso = br.readLine();
		} catch (IOException e) {
			System.out.println("Precorsto del file errato");
		}		
		return percorso;		
	}
	
	/*Riceve in input una stringa con la locazione del file e controlla che quest'ultimo non sia vuoto*/
	public static void FileChecker(String path) {
		
		try {
			FileReader SKL = new FileReader(path);
		} catch (FileNotFoundException e) {
			System.out.println("File n");
		}				
		
	}
	//controllo che i file non siano vuoti
	//TODO Aggiungerre controlli del formato corretto

}
