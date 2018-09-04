package soluzione;

/**Classe che definisce l'oggetto palazzo**/
public class Palazzo {
	//parametri di un palazzo
	private int anno;
    private String id;
    private String lato;
    private int distanza;
    private int base;
    private int altezza;

    public Palazzo(int anno, String id, String lato, int distanza, int base, int altezza){
        this.anno = anno;
        this.id = id;
        this.lato = lato;
        this.distanza = distanza;
        this.base = base;
        this.altezza = altezza;
    }
    
    //getter
    public int getAnno(){
        return anno;
    }
    public String getId(){
        return id;
    }
    public String getLato(){
        return lato;
    }
    public int getDistanza(){
        return distanza;
    }
    public int getBase(){
        return base;
    }
    public int getAltezza(){
        return altezza;
    }
    public int getLimit() {
    	return ((distanza+base));
    }
    /**Funzione che controlla la correttezza dei parametri del palazzo da costruire**/
    public Boolean checkBuilding(Palazzo p) {
    	
    	return (checkAnno(p.getAnno()) && checkDistanza(p.getDistanza()) &&
    			checkLato(p.getLato()) && checkBase(p.getBase()) &&
    			checkAltezza(p.getAltezza()));
    }
    
    /**Funzione per controllare che il formato dell'anno sia corretto**/
    private Boolean checkAnno(int anno) {
    	return (anno >= 2050);
    }
 
    /**Funzione per controllare che il formato della distanza dal fiume sia corretto**/
    private Boolean checkDistanza(int lato) {
    	return (lato>=0);
    }
    
    /**Funzione per controllare che il formato del lato sia correttto**/
    private Boolean checkLato(String lato) {
    	return (lato.equals("N") || lato.equals("S"));
    }
    
    /**Funzione per controllare che il formato della base sia corretto**/
    private Boolean checkBase(int base) {
    	return (base > 0);
    }
    
    /**Funzione per controllare che il formato dell'altezza sia corretto**/
    private Boolean checkAltezza(int altezza) {
    	return (altezza > 0);
    }
    
}
