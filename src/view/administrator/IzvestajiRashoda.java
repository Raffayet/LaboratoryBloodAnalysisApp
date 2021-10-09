package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import model.Korisnik;
import model.Laborant;
import model.MedicinskiTehnicar;
import model.Zaposleni;

public class IzvestajiRashoda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 407521719376756146L;
	private static JTable table;
	static JLabel lbl = new JLabel();
	static JLabel lblUkupanPrihod = new JLabel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PregledNalaza frame = new PregledNalaza();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */

	public IzvestajiRashoda(String korisnickoImeUlogovanogKorisnika, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		getContentPane().setBackground(new Color(32, 30, 45));
		setTitle("Izvestaji rashoda");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 895, 367);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 879, 255);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Korisnicko ime zaposlenog", "Ime", "Prezime", "Broj obradjenih zahteva/nalaza", "Plata"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3658730800950274602L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(95);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(95);
		
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		lbl.setText("Ukupan rashod:");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 29));
		lbl.setBounds(95, 279, 210, 34);
		getContentPane().add(lbl);
		
		lblUkupanPrihod.setText("");
		lblUkupanPrihod.setForeground(new Color(179, 14, 14));
		lblUkupanPrihod.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 29));
		lblUkupanPrihod.setBounds(430, 279, 210, 34);
		getContentPane().add(lblUkupanPrihod);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(353, 315, 311, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(IzvestajiPrihoda.class.getResource("/slike/Coi21ns-Transparent-Background.png")));
		lblNewLabel.setBounds(706, 266, 67, 52);
		getContentPane().add(lblNewLabel);
		NalazController.vracanjeIdNalazaOdredjenihDana();
		popunjavanjeTabele(pocetniDatum, krajnjiDatum);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestaji = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "rashodi");
                izborVremenskogOpsegaIzvestaji.setVisible(true);
            }
        });
		
		
	}
	
	private static void popunjavanjeTabele(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		NalazController.ucitavanje(NalazController.putanja);
		KorisniciController.ucitavanje(KorisniciController.putanja);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NalazController.konvertovanjeDanaNaEngleski();
		
		double ukupanRashod = 0;
		
		for (Korisnik korisnik : KorisniciController.korisnici) {	
			
			if (korisnik instanceof Zaposleni) {
				
				if (korisnik instanceof Laborant) {
					
					model.addRow(new Object [] {korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(), NalazController.vracanjeBrojaObradjenihNalaza((Laborant) korisnik,
					pocetniDatum, krajnjiDatum), String.valueOf(Math.round(KorisniciController.vracanjePlateLaboranataZaIzvestaje(pocetniDatum, krajnjiDatum, (Laborant) korisnik))) + "  RSD"});
					
					ukupanRashod = ukupanRashod + KorisniciController.vracanjePlateLaboranataZaIzvestaje(pocetniDatum, krajnjiDatum, (Laborant) korisnik);
				}
				
				
				else if (korisnik instanceof MedicinskiTehnicar) { 
						
					model.addRow(new Object [] {korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(),
					ZahtevController.vracanjeBrojaObradjenihZahteva((MedicinskiTehnicar) korisnik, pocetniDatum, krajnjiDatum), 
					String.valueOf(Math.round(ZahtevController.vracanjePlateMedicinskihTehnicaraZaIzvestaje(pocetniDatum, krajnjiDatum, (MedicinskiTehnicar) korisnik))) + "  RSD"});
					
					ukupanRashod = ukupanRashod + ZahtevController.vracanjePlateMedicinskihTehnicaraZaIzvestaje(pocetniDatum, krajnjiDatum, (MedicinskiTehnicar) korisnik);	
			}
				
			}
		
		}
		
		lblUkupanPrihod.setText(String.valueOf(Math.round(ukupanRashod)) + "  RSD");
	}
}


