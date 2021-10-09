package view.univerzalno;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import model.Nalaz;
import model.Zahtev;
import view.medicinski_tehnicar.IzborPacijentaPregledNalaza;
import view.pacijent.PocetniMeniPacijent;

public class PregledNalaza extends JFrame {

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

	public PregledNalaza(String korisnickoImeUlogovanogKorisnika, String korisnickoImeZaPregledNalaza, String LBOMusterije) {
		getContentPane().setBackground(new Color(32, 30, 45));
		setTitle("Pregled nalaza");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 895, 367);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 879, 257);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id nalaza", "Status nalaza", "Datum obrade nalaza", "Ukupna cena"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 3658730800950274602L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(175);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Detalji nalaza");
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(14, 122, 68));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(109, 213, 170));
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectionModel().isSelectionEmpty()) {

					JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali nijedan nalaz!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else {
				
				int selektovanRed = table.getSelectedRow();
				Nalaz selektovanNalaz = NalazController.vracanjeNalazaPrekoIdNalaza(table.getModel().getValueAt(selektovanRed, 0).toString());
				Zahtev selektovanZahtev = ZahtevController.vracanjeZahtevaprekoIdZahteva((table.getModel().getValueAt(selektovanRed, 0).toString()));
				PregledRezultataAnaliza pregledRezultataAnaliza = new PregledRezultataAnaliza(korisnickoImeZaPregledNalaza, selektovanZahtev, selektovanNalaz, LBOMusterije);
				pregledRezultataAnaliza.setVisible(true);
			}
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(356, 268, 170, 49);
		getContentPane().add(btnNewButton);
		
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		popunjavanjeTabele(korisnickoImeZaPregledNalaza, LBOMusterije);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
			
			KorisniciController.punjenjeListeKorisnickihImena();
				
            e.getWindow().dispose();
            
            if (KorisniciController.korisnickaImenaMedicinskihTehnicara.contains(korisnickoImeUlogovanogKorisnika)) {
                IzborPacijentaPregledNalaza izborPacijentaPregledNalaza = new IzborPacijentaPregledNalaza(korisnickoImeUlogovanogKorisnika);
                izborPacijentaPregledNalaza.setVisible(true);
            }
            
            else if (KorisniciController.korisnickaImenaPacijenata.contains(korisnickoImeUlogovanogKorisnika)){
			
            	PocetniMeniPacijent pocetniMeniPacijent = new PocetniMeniPacijent(korisnickoImeUlogovanogKorisnika);
            	pocetniMeniPacijent.setVisible(true);
		}
            }
        });
	}
	
	private static void popunjavanjeTabele(String korisnickoIme, String LBOMusterije) {
		
		if (LBOMusterije.equals("")) {
		
		NalazController.ucitavanje(NalazController.putanja);
		
		ZahtevController.ucitavanje(ZahtevController.putanja);
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		String trazenLBO = KorisniciController.vracanjeLBOPacijenta(korisnickoIme);
		
		for (Zahtev zahtev : ZahtevController.zahtevi) {
			
			for (Nalaz nalaz : NalazController.nalazi) {
			
			if (zahtev.getLBO().equals(trazenLBO) && String.valueOf(zahtev.getIdZahteva()).equals(String.valueOf(nalaz.getIdZahteva()))) {
				
				model.addRow(new Object [] {nalaz.getIdZahteva(), NalazController.ulepsavanjeStatusaObradeNalaza(String.valueOf(nalaz.getStatus())),
				NalazController.vracanjeDatumaObradeNalaza(String.valueOf(nalaz.getDatumObradeNalaza())), Math.round(nalaz.getUkupnaCena()) + " RSD"});
			}
		}
	}
}
		
		else {
			
			NalazController.ucitavanje(NalazController.putanja);
			
			ZahtevController.ucitavanje(ZahtevController.putanja);
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String trazenLBO = LBOMusterije;
			
			for (Zahtev zahtev : ZahtevController.zahtevi) {
				
				for (Nalaz nalaz : NalazController.nalazi) {
				
				if (zahtev.getLBO().equals(trazenLBO) && String.valueOf(zahtev.getIdZahteva()).equals(String.valueOf(nalaz.getIdZahteva()))) {
					
					model.addRow(new Object [] {nalaz.getIdZahteva(), NalazController.ulepsavanjeStatusaObradeNalaza(String.valueOf(nalaz.getStatus())),
					NalazController.vracanjeDatumaObradeNalaza(String.valueOf(nalaz.getDatumObradeNalaza())), Math.round(nalaz.getUkupnaCena()) + " RSD"});
				}
			}
		}
		}
}
}
