package model;

import enumeracije.GrupaAnalize;

public class Analiza {
	
	private GrupaAnalize grupa;
	private String imeAnalize, jedinicaMere;
	private double cena, rezultat, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, referentnaVrednostDoZenski;
	private String korisnickoImeLaboranta;
	private int popust;
	
	public Analiza(GrupaAnalize grupa, String imeAnalize, String jedinicaMere, double cena, double referentnaVrednostOdMuski, double referentnaVrednostDoMuski, 
			double referentnaVrednostOdZenski, double referentnaVrednostDoZenski,  String korisnickoImeLaboranta, int popust) {
		super();
		this.grupa = grupa;
		this.imeAnalize = imeAnalize;
		this.jedinicaMere = jedinicaMere;
		this.cena = cena;
		this.referentnaVrednostOdMuski = referentnaVrednostOdMuski;
		this.referentnaVrednostDoMuski = referentnaVrednostDoMuski;
		this.referentnaVrednostOdZenski = referentnaVrednostOdZenski;
		this.referentnaVrednostDoZenski = referentnaVrednostDoZenski;
		this.korisnickoImeLaboranta = korisnickoImeLaboranta;
		this.popust = popust;
	}

	public Analiza() {
		
	}

	public GrupaAnalize getGrupa() {
		return grupa;
	}

	public void setGrupa(GrupaAnalize grupa) {
		this.grupa = grupa;
	}

	public String getImeAnalize() {
		return imeAnalize;
	}

	public void setImeAnalize(String imeAnalize) {
		this.imeAnalize = imeAnalize;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getRezultat() {
		return rezultat;
	}

	public void setRezultat(double rezultat) {
		this.rezultat = rezultat;
	}

	public double getReferentnaVrednostOdMuski() {
		return referentnaVrednostOdMuski;
	}

	public void setReferentnaVrednostOdMuski(double referentnaVrednostOdMuski) {
		this.referentnaVrednostOdMuski = referentnaVrednostOdMuski;
	}

	public double getReferentnaVrednostDoMuski() {
		return referentnaVrednostDoMuski;
	}

	public void setReferentnaVrednostDoMuski(double referentnaVrednostDoMuski) {
		this.referentnaVrednostDoMuski = referentnaVrednostDoMuski;
	}
	
	public double getReferentnaVrednostOdZenski() {
		return referentnaVrednostOdZenski;
	}

	public void setReferentnaVrednostOdZenski(double referentnaVrednostOdZenski) {
		this.referentnaVrednostOdZenski = referentnaVrednostOdZenski;
	}

	public double getReferentnaVrednostDoZenski() {
		return referentnaVrednostDoZenski;
	}

	public void setReferentnaVrednostDoZenski(double referentnaVrednostDoZenski) {
		this.referentnaVrednostDoZenski = referentnaVrednostDoZenski;
	}

	public String getKorisnickoImeLaboranta() {
		return korisnickoImeLaboranta;
	}

	public void setKorisnickoImeLaboranta(String korisnickoImeLaboranta) {
		this.korisnickoImeLaboranta = korisnickoImeLaboranta;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	@Override
	public String toString() {
		return "Analiza [grupa=" + grupa + ", imeAnalize=" + imeAnalize + ", jedinicaMere=" + jedinicaMere + ", cena="
				+ cena + ", rezultat=" + rezultat + ", referentnaVrednostOdMuski=" + referentnaVrednostOdMuski
				+ ", referentnaVrednostDoMuski=" + referentnaVrednostDoMuski + ", laborant=" + korisnickoImeLaboranta + ", popust=" + popust + "]";
	}

}
