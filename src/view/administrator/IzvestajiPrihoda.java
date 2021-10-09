package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import enumeracije.StatusObrade;
import model.Nalaz;
import javax.swing.ImageIcon;

public class IzvestajiPrihoda extends JFrame {

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

	public IzvestajiPrihoda(String korisnickoImeUlogovanogKorisnika, LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		getContentPane().setBackground(new Color(32, 30, 45));
		setTitle("Izvestaji prihoda");
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
				"Id nalaza", "Broj analiza u nalazu", "Ime pacijenta", "Prezime pacijenta", "Ukupna cena"
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
		
		lbl.setText("Ukupan prihod:");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 29));
		lbl.setBounds(95, 279, 202, 34);
		getContentPane().add(lbl);
		
		lblUkupanPrihod.setText("");
		lblUkupanPrihod.setForeground(new Color(109, 213, 170));
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
                IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestaji = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "prihodi");
                izborVremenskogOpsegaIzvestaji.setVisible(true);
            }
        });
		
		
	}
	
	private static void popunjavanjeTabele(LocalDateTime pocetniDatum, LocalDateTime krajnjiDatum) {
		
		NalazController.ucitavanje(NalazController.putanja);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		NalazController.konvertovanjeDanaNaEngleski();
		
		double ukupanPrihod = 0;
		
		for (Nalaz nalaz : NalazController.nalazi) {
			
			if (nalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
			
				if (NalazController.vracanjeOpsegaDatumaNalaza(pocetniDatum, krajnjiDatum).contains(nalaz.getDatumObradeNalaza()) && 
					NalazController.vracanjeIdNalazaOdredjenihDana().contains(nalaz.getIdZahteva())) {
				
				model.addRow(new Object [] {String.valueOf(nalaz.getIdZahteva()), 
				String.valueOf(ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getImenaAnaliza().length),  
						KorisniciController.vracanjeImenaNaOsnovuLBO(ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getLBO()), 
						KorisniciController.vracanjePrezimenaNaOsnovuLBO(ZahtevController.vracanjeZahtevaprekoIdZahteva(String.valueOf(nalaz.getIdZahteva())).getLBO()),
						Math.round(nalaz.getUkupnaCena()) + " RSD"});
				
				ukupanPrihod = ukupanPrihod + nalaz.getUkupnaCena();
			}
		}
			
		}
		
		lblUkupanPrihod.setText(String.valueOf(Math.round(ukupanPrihod)) + "  RSD");
	}
}
