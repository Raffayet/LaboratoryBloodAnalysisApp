package view.laborant;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AnalizaController;
import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import enumeracije.GrupaAnalize;
import model.Nalaz;
import model.Zahtev;

public class PreuzimanjeNalazaZaObradu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8594519666609013845L;
	private static JPanel contentPane;
	private static JTable table;
	public static ArrayList<String> izabraniNalazi = new ArrayList<String>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public PreuzimanjeNalazaZaObradu(String korisnickoIme) {
		setTitle("Preuzimanje nalaza za obradu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 897, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ZahtevController.ucitavanje(ZahtevController.putanja);
		NalazController.ucitavanje(NalazController.putanja);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 881, 256);
		contentPane.add(scrollPane);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                PocetniMeniLaborant pocetniMeniLaborant = new PocetniMeniLaborant(korisnickoIme);
                pocetniMeniLaborant.setVisible(true);
            }
        });
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id nalaza", "LBO", "Analize", "Vreme", "Preuzimanje"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(98);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		popunjavanjeTabele(korisnickoIme);
		
		JButton btnNewButton = new JButton("Preuzmite nalaz za obradu");
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		
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
				
				izabraniNalazi.clear();
				
				String izabranNalaz = "";
				
				for (int red = 0; red < table.getRowCount(); red ++){
					
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        izabranNalaz = model.getValueAt(red, 0).toString();
			        
			        boolean izabran = Boolean.parseBoolean(model.getValueAt(red, 4).toString());
			        
			        if (izabran == true) {
			        	
			        	if (!izabraniNalazi.contains(izabranNalaz)) {
			        
			        		izabraniNalazi.add(izabranNalaz);
			        		
			        		JOptionPane.showMessageDialog(new JFrame(), "Uspesno preuzimanje!");
				        	((DefaultTableModel)table.getModel()).removeRow(red);
				        	KorisniciController.preuzimanjeNalazaZaObradu(izabranNalaz, korisnickoIme);
			        	}
			        }
			        
			        else {
			        	
			        	izabraniNalazi.remove(izabranNalaz);
			        }
			        
				}	
				
				 if (izabraniNalazi.size() == 0) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali nijedan nalaz!", "Greska", 
								JOptionPane.ERROR_MESSAGE);
					}     	
	
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		btnNewButton.setBounds(333, 267, 236, 51);
		contentPane.add(btnNewButton);
	}
	
	private static void popunjavanjeTabele(String korisnickoIme) {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		ArrayList<Integer> idNalazaUzimanjeUzorka = NalazController.vracanjeIdNalazaUzimanjeUzorkaIliObradaNalaza();
		
		ArrayList<String> imenaAnalizaPoLaborantu = AnalizaController.vracanjeImenaAnalizaPoLaborantu(korisnickoIme);
		
		ArrayList<Integer> upisaniNalazi = new ArrayList<Integer>();
		
		ArrayList<GrupaAnalize> potrebneSpecijalizacije = new ArrayList<GrupaAnalize>();
		
		DateTimeFormatter formatZaDatum = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		
		ZahtevController.ucitavanje(ZahtevController.putanja);
		
		KorisniciController.punjenjeListeKorisnickihImena();
		
		NalazController.ucitavanje(NalazController.putanja);
		
		for (Zahtev zahtev : ZahtevController.zahtevi) {
				
			for (String imeAnalize : ZahtevController.konvertovanjeIzNizaUListu(zahtev.getImenaAnaliza())) {
			
			if (idNalazaUzimanjeUzorka.contains(zahtev.getIdZahteva()) && imenaAnalizaPoLaborantu.contains(imeAnalize)) {
					
				Nalaz nalaz = NalazController.vracanjeNalazaNaOsnovuZahteva(String.valueOf(zahtev.getIdZahteva()));
				
				potrebneSpecijalizacije = NalazController.odredjivanjePotrebnihSpecijalizacija(nalaz);
				
				for (GrupaAnalize specijalizacija : KorisniciController.vracanjeLaborantaNaOsnovuKorisnickogImena(korisnickoIme).getSpecijalizacije()) {
					
					if (potrebneSpecijalizacije.contains(specijalizacija) && !nalaz.getKorisnickaImenaLaboranata().contains(korisnickoIme)) {
						
						if (!upisaniNalazi.contains(zahtev.getIdZahteva())) {
							upisaniNalazi.add(zahtev.getIdZahteva());
						
							model.addRow(new Object []{String.valueOf(zahtev.getIdZahteva()), zahtev.getLBO(), ZahtevController.prikazPojedinacnihAnaliza(zahtev), 
									zahtev.getVremeUzorka().format(formatZaDatum), false});
					}
					}
				}
				}
			}
			}
	}
	}	

		
		
	

