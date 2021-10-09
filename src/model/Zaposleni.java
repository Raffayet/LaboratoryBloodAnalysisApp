package model;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import enumeracije.Pol;
import enumeracije.StrucnaSprema;

public abstract class Zaposleni extends Korisnik{
	
	private double osnova, koeficijent, bonus;
	private int staz;
	private StrucnaSprema strucnaSprema;
	
	private ArrayList<HashMap<String, String>> plate;
	
	public Zaposleni(){
		
	}

	public Zaposleni(String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String adresa,
			Pol pol, Date datumRodjenja2, double osnova, double koeficijent, double bonus, int staz, StrucnaSprema strucnaSprema) {
		super();
		this.osnova = osnova;
		this.koeficijent = koeficijent;
		this.bonus = bonus;
		this.staz = staz;
		this.strucnaSprema = strucnaSprema;
	}

	public Zaposleni(double osnova, double koeficijent, double bonus, int staz, StrucnaSprema strucnaSprema,
			ArrayList<HashMap<String, String>> plate) {
		super();
		this.osnova = osnova;
		this.koeficijent = koeficijent;
		this.bonus = bonus;
		this.staz = staz;
		this.strucnaSprema = strucnaSprema;
		this.plate = plate;
	}

	public double getOsnova() {
		return osnova;
	}

	public void setOsnova(double osnova) {
		this.osnova = osnova;
	}

	public double getKoeficijent() {
		return koeficijent;
	}

	public void setKoeficijent(double koeficijent) {
		this.koeficijent = koeficijent;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public int getStaz() {
		return staz;
	}

	public void setStaz(int staz) {
		this.staz = staz;
	}

	public StrucnaSprema getStrucnaSprema() {
		return strucnaSprema;
	}

	public void setStrucnaSprema(StrucnaSprema strucnaSprema) {
		this.strucnaSprema = strucnaSprema;
	}
	
	public ArrayList<HashMap<String, String>> getPlate() {
		return plate;
	}

	public void setPlate(ArrayList<HashMap<String, String>> plate) {
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "Zaposleni [osnova=" + osnova + ", koeficijent=" + koeficijent + ", bonus=" + bonus + ", staz=" + staz
				+ ", strucnaSprema=" + strucnaSprema + ", plate=" + plate + "]";
	}
	
	public void racunanjePlate() {
		
	}
	
}
