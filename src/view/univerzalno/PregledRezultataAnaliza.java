package view.univerzalno;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AnalizaController;
import controller.KorisniciController;
import controller.MusterijaController;
import enumeracije.Pol;
import enumeracije.StatusObrade;
import model.Analiza;
import model.Nalaz;
import model.Zahtev;

public class PregledRezultataAnaliza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4240780020844088896L;
	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PregledRezultataAnaliza(String korisnickoIme, Zahtev selektovanZahtev, Nalaz selektovanNalaz, String LBOMusterije) {
		setTitle("Rezultati analiza");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 671, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 30, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 655, 203);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ime analize", "Jedinica mere", "Ref.vrednost (od)", "Ref.vrednost (do)", "Rezultat", "Cena"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1401865453683860420L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		popunjavanjeTabele(korisnickoIme, selektovanZahtev, selektovanNalaz, LBOMusterije);
	}
	
	private static void popunjavanjeTabele(String korisnickoIme, Zahtev selektovanZahtev, Nalaz selektovanNalaz, String LBOMusterije) {
		
		if (!korisnickoIme.equals("")) {
		
		KorisniciController.ucitavanje(KorisniciController.putanja);
		
		String pol = KorisniciController.vracanjePolaNaOsnovuKorisnickogImena(korisnickoIme);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		for (Analiza analiza : AnalizaController.analize) {
			
			for (String imeAnalize : selektovanZahtev.getImenaAnaliza()) {
				
				if (imeAnalize.equals(analiza.getImeAnalize())) {
					
					if (selektovanNalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
						
						if (pol.equals(Pol.MUSKI.name())) {
							
							model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdMuski(),
									analiza.getReferentnaVrednostDoMuski(), AnalizaController.dobavljanjeRezultataAnaliza(selektovanZahtev, analiza.getImeAnalize()), 
							Math.round(analiza.getCena()) + " RSD"});
						}
						
						else {
							
							model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdZenski(),
									analiza.getReferentnaVrednostDoZenski(), AnalizaController.dobavljanjeRezultataAnaliza(selektovanZahtev, analiza.getImeAnalize()), 
							Math.round(analiza.getCena()) + " RSD"});
						}
	
					}
					
					else {
						
						if (pol.equals(Pol.MUSKI.name())) {
							
							model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdMuski(),
									analiza.getReferentnaVrednostDoMuski(), "-", 
							Math.round(analiza.getCena()) + " RSD"});
						}
						
						else {
							
							model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdZenski(),
									analiza.getReferentnaVrednostDoZenski(), "-", 
							Math.round(analiza.getCena()) + " RSD"});
						}

					}
				}
			}
		}
	}
		
		else {
			
			MusterijaController.ucitavanje(MusterijaController.putanja);
			
			String pol = MusterijaController.vracanjePolaNaOsnovuLBO(LBOMusterije);
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			for (Analiza analiza : AnalizaController.analize) {
				
				for (String imeAnalize : selektovanZahtev.getImenaAnaliza()) {
					
					if (imeAnalize.equals(analiza.getImeAnalize())) {
						
						if (selektovanNalaz.getStatus().equals(StatusObrade.OBRADJENO)) {
							
							if (pol.equals(Pol.MUSKI.name())) {
								
								model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdMuski(),
										analiza.getReferentnaVrednostDoMuski(), analiza.getRezultat(), 
								Math.round(analiza.getCena()) + " RSD"});
							}
							
							else {
								
								model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdZenski(),
										analiza.getReferentnaVrednostDoZenski(), analiza.getRezultat(), 
								Math.round(analiza.getCena()) + " RSD"});
							}
		
						}
						
						else {
							
							if (pol.equals(Pol.MUSKI.name())) {
								
								model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdMuski(),
										analiza.getReferentnaVrednostDoMuski(), "-", 
								Math.round(analiza.getCena()) + " RSD"});
							}
							
							else {
								
								model.addRow(new Object [] {analiza.getImeAnalize(), analiza.getJedinicaMere(), analiza.getReferentnaVrednostOdZenski(),
										analiza.getReferentnaVrednostDoZenski(), "-", 
								Math.round(analiza.getCena()) + " RSD"});
							}

						}
					}
				}
			}
		}
	}
}
