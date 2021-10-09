package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import model.Korisnik;
import model.Pacijent;

public class IzvestajiPacijenata extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 407521719376756146L;
	private static JTable table;

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

	public IzvestajiPacijenata(String korisnickoImeUlogovanogKorisnika, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		getContentPane().setBackground(new Color(32, 30, 45));
		setTitle("Izvestaji pacijenata");
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
				"Korisnicko ime pacijenta", "Ime", "Prezime", "Broj nalaza", "Ukupan iznos"
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
		NalazController.vracanjeIdNalazaOdredjenihDana();
		popunjavanjeTabele(pocetniDatum, krajnjiDatum);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestaji = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "pacijenti");
                izborVremenskogOpsegaIzvestaji.setVisible(true);
            }
        });
		
		
	}
	
	private static void popunjavanjeTabele(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		NalazController.ucitavanje(NalazController.putanja);
		ZahtevController.ucitavanje(ZahtevController.putanja);
		KorisniciController.ucitavanje(KorisniciController.putanja);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NalazController.konvertovanjeDanaNaEngleski();
		
		for (Korisnik korisnik : KorisniciController.korisnici) {
			
			if (korisnik instanceof Pacijent) {
				
				model.addRow(new Object [] {korisnik.getKorisnickoIme(), korisnik.getIme(), korisnik.getPrezime(), ZahtevController.vracanjeBrojaZahteva(((Pacijent) korisnik).getLBO(), 
						pocetniDatum, krajnjiDatum), NalazController.vracanjeUkupneCeneNalaza(((Pacijent) korisnik).getLBO(), pocetniDatum, krajnjiDatum)});
		}
			
		}
	}
}
