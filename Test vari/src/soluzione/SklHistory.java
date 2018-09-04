package soluzione;



public class SklHistory {
	
	private int Anno;
	private int Ampiezza;
	private double Altezza;
	
	public SklHistory(int anno, int ampiezza, double altezza) {
		this.Anno = anno;
		this.Ampiezza = ampiezza;
		this.Altezza = altezza;
	}
	

	public int getAnno() {
		return Anno;
	}
	public void setAnno(int anno) {
		Anno = anno;
	}
	public int getAmpiezza() {
		return Ampiezza;
	}
	public void setAmpiezza(int ampiezza) {
		Ampiezza = ampiezza;
	}
	public double getAltezza() {
		return Altezza;
	}
	public void setAltezza(double altezza) {
		Altezza = altezza;
	}

}
