package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import enumeracije.StatusObrade;

public class Nalaz {
	
	private StatusObrade status;
	private double ukupnaCena;
	private int idZahteva;
	private LocalDateTime datumObradeNalaza;
	private ArrayList<String> korisnickaImenaLaboranata, rezultatiAnaliza;

	public Nalaz(StatusObrade status, double ukupnaCena, int idZahteva, LocalDateTime datumObradeNalaza,
			ArrayList<String> korisnickaImenaLaboranata) {
		super();
		this.status = status;
		this.ukupnaCena = ukupnaCena;
		this.idZahteva = idZahteva;
		this.datumObradeNalaza = datumObradeNalaza;
		this.korisnickaImenaLaboranata = korisnickaImenaLaboranata;
	}

	public Nalaz(StatusObrade status, double ukupnaCena, int idZahteva, LocalDateTime datumObradeNalaza,
			ArrayList<String> korisnickaImenaLaboranata, ArrayList<String> rezultatiAnaliza) {
		super();
		this.status = status;
		this.ukupnaCena = ukupnaCena;
		this.idZahteva = idZahteva;
		this.datumObradeNalaza = datumObradeNalaza;
		this.korisnickaImenaLaboranata = korisnickaImenaLaboranata;
		this.rezultatiAnaliza = rezultatiAnaliza;
	}

	public Nalaz() {
		
	}

	public Nalaz(StatusObrade status, double ukupnaCena, int idZahteva, LocalDateTime datumObradeNalaza) {
		super();
		this.status = status;
		this.ukupnaCena = ukupnaCena;
		this.idZahteva = idZahteva;
		this.datumObradeNalaza = datumObradeNalaza;
	}

	public LocalDateTime getDatumObradeNalaza() {
		return datumObradeNalaza;
	}

	public void setDatumObradeNalaza(LocalDateTime datumObradeNalaza) {
		this.datumObradeNalaza = datumObradeNalaza;
	}

	public StatusObrade getStatus() {
		return status;
	}

	public void setStatus(StatusObrade status) {
		this.status = status;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public int getIdZahteva() {
		return idZahteva;
	}

	public void setIdZahteva(int idZahteva) {
		this.idZahteva = idZahteva;
	}

	public ArrayList<String> getKorisnickaImenaLaboranata() {
		return korisnickaImenaLaboranata;
	}

	public void setKorisnickaImenaLaboranata(ArrayList<String> korisnickaImenaLaboranata) {
		this.korisnickaImenaLaboranata = korisnickaImenaLaboranata;
	}

	public ArrayList<String> getRezultatiAnaliza() {
		return rezultatiAnaliza;
	}

	public void setRezultatiAnaliza(ArrayList<String> rezultatiAnaliza) {
		this.rezultatiAnaliza = rezultatiAnaliza;
	}

	@Override
	public String toString() {
		return "Nalaz [status=" + status + ", ukupnaCena=" + ukupnaCena + ", idZahteva=" + idZahteva
				+ ", datumObradeNalaza=" + datumObradeNalaza + ", korisnickaImenaLaboranata="
				+ korisnickaImenaLaboranata + ", rezultatiAnaliza=" + rezultatiAnaliza + "]";
	}

}
