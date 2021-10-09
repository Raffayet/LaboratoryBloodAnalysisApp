package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.EnumeracijeController;
import controller.KorisniciController;
import enumeracije.GrupaAnalize;

public class DodavanjeSpecijalizacija extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6475720988789737478L;
	private static JPanel contentPane;
	private static JTable table;
	private JButton btnNewButton;
	public static ArrayList<GrupaAnalize> izabraneSpecijalizacije = new ArrayList<GrupaAnalize>();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DodavanjeSpecijalizacija(String korisnickoImeUlogovanogKorisnika, String korisnickoImeLaboranta) {
		
		setTitle("Izbor specijalizacija");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 649, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                IzborLaborantaDodavanjeSpecijalizacija izborLaborantaDodavanjeSpecijalizacija = new IzborLaborantaDodavanjeSpecijalizacija(korisnickoImeUlogovanogKorisnika);
                izborLaborantaDodavanjeSpecijalizacija.setVisible(true);
            }
        });
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(0, 0, 633, 212);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Specijalizacija", "Izabrano"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2677886778450141187L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				GrupaAnalize.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		scrollPane_1.setViewportView(table);
		
		popunjavanjeTabele();
		
		btnNewButton = new JButton("Potvrda");
		
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
				
				izabraneSpecijalizacije.clear();
				
				GrupaAnalize izabranaSpecijalizacija;
				
				int poklopljeneSpecijalizacije = 0;
				
				for (int red = 0; red < table.getRowCount(); red ++){
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        izabranaSpecijalizacija = (GrupaAnalize) (model.getValueAt(red, 0));
			        boolean izabrana = Boolean.parseBoolean(model.getValueAt(red, 1).toString());
			        
			        if (izabrana == true) {
			        	
			        	if (!izabraneSpecijalizacije.contains(izabranaSpecijalizacija)) {
		        
			        	if (!KorisniciController.vracanjeSpecijalizacijaNaOsnovuKorisnickogImena(korisnickoImeLaboranta).contains(izabranaSpecijalizacija)) {
			        		
			        		izabraneSpecijalizacije.add(izabranaSpecijalizacija);
			        		
			        	}
			        	
			        	else {
			        		
			        		poklopljeneSpecijalizacije += 1;
			        		izabraneSpecijalizacije.remove(izabranaSpecijalizacija);
			        	}
			        	
			        }
			        }
			        
			        else {
			        	
			        	izabraneSpecijalizacije.remove(izabranaSpecijalizacija);
			        }
				}
				
				if (poklopljeneSpecijalizacije > 0) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Laborant je vec specijalizovan za izabrane specijalizacije", "Greska", JOptionPane.ERROR_MESSAGE);
			}
				
				else if (izabraneSpecijalizacije.size() == 0) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali nijednu specijalizaciju!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					JOptionPane.showMessageDialog(new JFrame(), "Uspesno dodavanje specijalizacija!");
					KorisniciController.dodavanjeSpecijalizacija(korisnickoImeLaboranta, izabraneSpecijalizacije);
					KorisniciController.ucitavanje(KorisniciController.putanja);
				}
			}
		});
		
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(220, 223, 193, 45);
		contentPane.add(btnNewButton);
	}

	
	private static void popunjavanjeTabele() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Boolean izabrana = false;
		
		for (GrupaAnalize specijalizacija : EnumeracijeController.dobavljanjeSpecijalizacija()) {
			
			model.addRow(new Object []{specijalizacija, izabrana});
		
		}
	}
}
