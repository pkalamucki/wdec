package pl.edu.pw.wdec.data;

/**
 * Klasa przechowujaca wartosci parametrow, ktore nalezy wpisac do symulatora
 * aby osiagnac konkretny zysk
 * 
 * @author cor
 * 
 */
public class OutputData {
	private Double jakosc;
	private Double wolumen;
	private Double cena;
	private Double kredyt;
	private Double reklamaTv;
	private Double reklamaNet;
	private Double reklamaMagazyn;
	private Double rata;

	public Double getJakosc() {
		return jakosc;
	}

	public void setJakosc(Double jakosc) {
		this.jakosc = jakosc;
	}

	public Double getWolumen() {
		return wolumen;
	}

	public void setWolumen(Double wolumen) {
		this.wolumen = wolumen;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Double getKredyt() {
		return kredyt;
	}

	public void setKredyt(Double kredyt) {
		this.kredyt = kredyt;
	}

	public Double getReklamaTv() {
		return reklamaTv;
	}

	public void setReklamaTv(Double reklamaTv) {
		this.reklamaTv = reklamaTv;
	}

	public Double getReklamaNet() {
		return reklamaNet;
	}

	public void setReklamaNet(Double reklamaNet) {
		this.reklamaNet = reklamaNet;
	}

	public Double getReklamaMagazyn() {
		return reklamaMagazyn;
	}

	public void setReklamaMagazyn(Double reklamaMagazyn) {
		this.reklamaMagazyn = reklamaMagazyn;
	}

	public Double getRata() {
		return rata;
	}

	public void setRata(Double rata) {
		this.rata = rata;
	}
}
