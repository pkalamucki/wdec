package pl.edu.pw.wdec.data;

/**
 * Klasa przechowujaca informacje o stanie symulacji
 * 
 * @author cor
 * 
 */

public class EntryData {
	/** Majatek trwaly firmy */
	private Double majatekTrwaly;
	/** Maksymalny kredyt */
	private Double maxKredyt;
	/** Ilosc gotowki */
	private Double gotowka;
	/** Zadluzenie firmy */
	private Double zadluzenie;
	/** Amortyzacja */
	private Double amortyzacja;
	/** Koszty stale produktu zwyklego */
	private Double kosztStaly;
	/** Oprocentowanie konta bankowego */
	private Double procentKonta;
	/** Oprocentowanie kredytu */
	private Double procentKredytu;
	/** Stawka podatku */
	private Double podatek;
	/** Niesprzedane produkty skupowane za: (kosztu pordukcji) */
	private Double skup;
	/** Maksymalna zdolnosc produkcyjna */
	private Double maxProdukcja;
	
	private Integer iloscEtapowDoKonca;

	public EntryData(Double majatekTrwaly, Double maxKredyt, Double gotowka,
			Double zadluzenie, Double amortyzacja, Double kosztStaly,
			Double procentKonta, Double procentKredytu, Double podatek,
			Double maxProdukcja) {

		this.amortyzacja = amortyzacja;
		this.gotowka = gotowka;
		this.kosztStaly = kosztStaly;
		this.majatekTrwaly = majatekTrwaly;
		this.maxKredyt = maxKredyt;
		this.maxProdukcja = maxProdukcja;
		this.podatek = podatek;
		this.procentKonta = procentKonta;
		this.procentKredytu = procentKredytu;
		this.zadluzenie = zadluzenie;
		this.iloscEtapowDoKonca = 5;
	}

	public Double getMajatekTrwaly() {
		return majatekTrwaly;
	}

	public void setMajatekTrwaly(Double majatekTrwaly) {
		this.majatekTrwaly = majatekTrwaly;
	}

	public Double getMaxKredyt() {
		return maxKredyt;
	}

	public void setMaxKredyt(Double maxKredyt) {
		this.maxKredyt = maxKredyt;
	}

	public Double getGotowka() {
		return gotowka;
	}

	public void setGotowka(Double gotowka) {
		this.gotowka = gotowka;
	}

	public Double getZadluzenie() {
		return zadluzenie;
	}

	public void setZadluzenie(Double zadluzenie) {
		this.zadluzenie = zadluzenie;
	}

	public Double getAmortyzacja() {
		return amortyzacja;
	}

	public void setAmortyzacja(Double amortyzacja) {
		this.amortyzacja = amortyzacja;
	}

	public Double getKosztStaly() {
		return kosztStaly;
	}

	public void setKosztStaly(Double kosztStaly) {
		this.kosztStaly = kosztStaly;
	}

	public Double getProcentKonta() {
		return procentKonta;
	}

	public void setProcentKonta(Double procentKonta) {
		this.procentKonta = procentKonta;
	}

	public Double getProcentKredytu() {
		return procentKredytu;
	}

	public void setProcentKredytu(Double procentKredytu) {
		this.procentKredytu = procentKredytu;
	}

	public Double getPodatek() {
		return podatek;
	}

	public void setPodatek(Double podatek) {
		this.podatek = podatek;
	}

	public Double getSkup() {
		return skup;
	}

	public void setSkup(Double skup) {
		this.skup = skup;
	}

	public Double getMaxProdukcja() {
		return maxProdukcja;
	}

	public void setMaxProdukcja(Double maxProdukcja) {
		this.maxProdukcja = maxProdukcja;
	}

	public Integer getIloscEtapowDoKonca() {
		return iloscEtapowDoKonca;
	}

	public void setIloscEtapowDoKonca(Integer iloscEtapowDoKonca) {
		this.iloscEtapowDoKonca = iloscEtapowDoKonca;
	}

}
