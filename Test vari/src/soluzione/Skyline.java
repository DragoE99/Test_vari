package soluzione;


public class Skyline {

	public static void main(String[] args) {
		String f1;
		String f2;
		
		try {
			f1 = new String(args[0]);
			f2 = new String(args[1]);
			DataManager.Process(FileManager.Load(f1, f2));
			
		}catch (Exception e) {
			f1="";
			f2="";
			DataManager.Process(FileManager.Load(f1, f2));		
		} 

		 

	}

}
