package soluzione;

import java.io.File;

public class Skyline {

	public static void main(String[] args) {

		 try {
				File eventi = new File(args[0]);
			} catch (Exception e) {
				
				System.out.println("File 1 inesistente o errato");
			}
			 
			 
		     try {
				File richieste = new File(args[1]);
			} catch (Exception e) {
				
				System.out.println("File 2 inesistente o errato");
			}
		     
		     


	}

}
