package main;

import java.awt.EventQueue;

import controller.AnalizaController;
import controller.KorisniciController;
import controller.MusterijaController;
import controller.NalazController;
import controller.ZahtevController;
import view.univerzalno.Prijava;


public class Main {

	public static void main(String[] args) {
		
		KorisniciController.ucitavanje(KorisniciController.putanja);
		AnalizaController.ucitavanje(AnalizaController.putanja);
		MusterijaController.ucitavanje(MusterijaController.putanja);
		NalazController.ucitavanje(NalazController.putanja);
		ZahtevController.ucitavanje(ZahtevController.putanja);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava window = new Prijava();
					window.frmPrijavaNaSistem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	}
