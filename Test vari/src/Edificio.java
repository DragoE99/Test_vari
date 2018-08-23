public class Edificio{
    //campi
    private int anno;
    private String id;
    private char lato;
    private int distanza;
    private int base;
    private int altezza;
    //costruttore
    public Edificio(int anno, String id, char lato, int distanza, int base, int altezza){
        this.anno = anno;
        this.id = id;
        this.lato = lato;
        this.distanza = distanza;
        this.base = base;
        this.altezza = altezza;
    }
    //metodi
    
    //getter
    public int getAnno(){
        return anno;
    }
    public String getId(){
        return id;
    }
    public char getLato(){
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
    //toString
}