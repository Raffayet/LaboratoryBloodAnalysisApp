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

import controller.AnalizaController;
import controller.NalazController;
import controller.ZahtevController;
import enumeracije.StatusObrade;
import model.Zahtev;

public class IzvestajiZahteva extends JFrame {

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

	public IzvestajiZahteva(String korisnickoImeUlogovanogKorisnika, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		getContentPane().setBackground(new Color(32, 30, 45));
		setTitle("Izvestaji zahteva");
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
				"Id zahteva", "Grupe analiza u zahtevu", "Broj analiza", "Trenutno stanje", "Kucna poseta"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3658730800950274602L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Boolean.class
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
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
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
                IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestaji = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "zahtevi");
                izborVremenskogOpsegaIzvestaji.setVisible(true);
            }
        });
		
		
	}
	
	private static void popunjavanjeTabele(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		NalazController.ucitavanje(NalazController.putanja);
		ZahtevController.ucitavanje(ZahtevController.putanja);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NalazController.konvertovanjeDanaNaEngleski();
		
		for (Zahtev zahtev : ZahtevController.zahtevi) {
			
			if (NalazController.vracanjeNalazaPrekoIdNalaza(String.valueOf(zahtev.getIdZahteva())).getStatus().equals(StatusObrade.OBRADJENO)) {
			
				if (NalazController.vracanjeOpsegaDatumaNalaza(pocetniDatum, krajnjiDatum).contains(NalazController.vracanjeNalazaNaOsnovuZahteva(String.valueOf(zahtev.getIdZahteva())).
					getDatumObradeNalaza()) && NalazController.vracanjeIdNalazaOdredjenihDana().contains(NalazController.vracanjeNalazaPrekoIdNalaza(String.valueOf(zahtev.getIdZahteva())).
							getIdZahteva())) {
				
				model.addRow(new Object [] {String.valueOf(zahtev.getIdZahteva()), AnalizaController.vracanjeGrupaAnaliza(zahtev), String.valueOf(zahtev.getImenaAnaliza().length), 
						NalazController.vracanjeNalazaNaOsnovuZahteva(String.valueOf(zahtev.getIdZahteva())).getStatus().name(), zahtev.isKucnaPoseta()});
				
			}
		}
			
		}
	}
}
