package soluzione;

/*Questa classe definisce l'oggetto palazzo */

public class Palazzo {
	//parametri di un oalazzo
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
    
    
    
}
