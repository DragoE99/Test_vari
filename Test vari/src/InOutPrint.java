import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class InOutPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Quanto fa 2+2?");
		Scanner risp = new Scanner(System.in);
		int i = risp.nextInt();
		if(i == 4)System.out.println("giusto");
		else {System.out.println("pirla");}*/
		
		/*List<Integer> numeri = new ArrayList<Integer>();
		
		for(int j=0; j<10; j++) {
			numeri.add(j);
		}
		for(int j=0; j<10; j++) {
			System.out.println(numeri.get(j));
		}
		
		List<String> parole = new ArrayList<String>();
		
		parole.add("ciao");
		parole.add("banana");
		parole.add("gialla");
		parole.add("Dio");
		
		for(int i=0;i<4;i++) {
			System.out.println(parole.get(i));
		}
		
		parole.remove(1);
		
		for(int i=0;i<3;i++) {
			System.out.println(parole.get(i));
		}
		
		parole.remove("ciao");
		parole.add("santo");
		
		for(int i=0;i<3;i++) {
			System.out.println(parole.get(i));
		}*/
		
		List<Edificio> bld =new ArrayList<Edificio>();
		
		Edificio primo = new Edificio(2050, "ciao123", 'N', 5, 20, 10);
		Edificio secondo = new Edificio(2050, "banan", 'N', 5, 20, 10);
		
		bld.add(primo);
		bld.add(secondo);
		
		int k = bld.size();
		System.out.println("la lista contiene "+k+" elementi");
		
		bld.remove(primo);
		
		k = bld.size();
		System.out.println("la lista contiene "+k+" elementi");
			
	

	}
}


