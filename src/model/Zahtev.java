package model;

import java.time.LocalDateTime;

public class Zahtev {
	
	private boolean kucnaPoseta, uradjen;
	private String LBO;
	private String [] imenaAnaliza;
	private LocalDateTime vremeUzorka;
	private String korisnickoImeMedicinskogTehnicara;
	private int idZahteva;
	
	public Zahtev() {
		
	}

	public Zahtev(boolean kucnaPoseta, boolean uradjen, String LBO, String [] imenaAnaliza,
			LocalDateTime vremeUzorka, String korisnickoImeMedicinskogTehnicara, int idZahteva) {
		super();
		this.kucnaPoseta = kucnaPoseta;
		this.uradjen = uradjen;
		this.LBO = LBO;
		this.imenaAnaliza = imenaAnaliza;
		this.vremeUzorka = vremeUzorka;
		this.korisnickoImeMedicinskogTehnicara = korisnickoImeMedicinskogTehnicara;
		this.idZahteva = idZahteva;
	}

	public boolean isKucnaPoseta() {
		return kucnaPoseta;
	}

	public void setKucnaPoseta(boolean kucnaPoseta) {
		this.kucnaPoseta = kucnaPoseta;
	}

	public boolean isUradjen() {
		return uradjen;
	}

	public void setUradjen(boolean uradjen) {
		this.uradjen = uradjen;
	}

	public String getLBO() {
		return LBO;
	}

	public void setLBO(String LBO) {
		this.LBO = LBO;
	}

	public LocalDateTime getVremeUzorka() {
		return vremeUzorka;
	}

	public void setVremeUzorka(LocalDateTime vremeUzorka) {
		this.vremeUzorka = vremeUzorka;
	}

	public int getIdZahteva() {
		return idZahteva;
	}

	public void setIdZahteva(int idZahteva) {
		this.idZahteva = idZahteva;
	}

	@Override
	public String toString() {
		return "Zahtev [kucnaPoseta=" + kucnaPoseta + ", uradjen=" + uradjen + ", LBO=" + LBO + ", analize=" + imenaAnaliza
				+ ", vremeUzorka=" + vremeUzorka + ", medicinskiTehnicar=" + korisnickoImeMedicinskogTehnicara + ", idZahteva="
				+ idZahteva + "]";
	}

	public String [] getImenaAnaliza() {
		return imenaAnaliza;
	}

	public void setImenaAnaliza(String[] imenaAnaliza) {
		this.imenaAnaliza = imenaAnaliza;
	}

	public String getKorisnickoImeMedicinskogTehnicara() {
		return korisnickoImeMedicinskogTehnicara;
	}

	public void setKorisnickoImeMedicinskogTehnicara(String korisnickoImeMedicinskogTehnicara) {
		this.korisnickoImeMedicinskogTehnicara = korisnickoImeMedicinskogTehnicara;
	}

}
