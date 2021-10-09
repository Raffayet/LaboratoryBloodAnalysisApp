package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import enumeracije.GrupaAnalize;

public class IzborSpecijalizacija extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6475720988789737478L;
	private static JPanel contentPane;
	private static JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public IzborSpecijalizacija() {
		setTitle("Izbor specijalizacija");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 649, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				"Ime specijalizacije", "Izabrano"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -2677886778450141187L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.setRowHeight(25);

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
				
				String izabranaSpecijalizacija = "";
				
				for (int red = 0; red < table.getRowCount(); red ++){
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        izabranaSpecijalizacija = (model.getValueAt(red, 0)).toString();
			        boolean izabrana = Boolean.parseBoolean(model.getValueAt(red, 1).toString());
			        
			        if (izabrana == true) {
		        
			        	if (!RegistracijaLaboranta.izabraneSpecijalizacije.contains(izabranaSpecijalizacija)) {
			        		
			        		RegistracijaLaboranta.izabraneSpecijalizacije.add(izabranaSpecijalizacija);
			        	}
			        }
			        
			        else {
			        
			        	RegistracijaLaboranta.izabraneSpecijalizacije.remove(izabranaSpecijalizacija);
			        }
				}
			}
		});
		
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton.setBounds(187, 223, 273, 45);
		contentPane.add(btnNewButton);
	}

	
	private static void popunjavanjeTabele() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Boolean izabrana = false;
		
		for (GrupaAnalize specijalizacija : GrupaAnalize.values()) {
			
			if (RegistracijaLaboranta.izabraneSpecijalizacije.contains(specijalizacija.name())) {
				
				izabrana = true;
			}
			
			else {
				
				izabrana = false;
			}
			
			model.addRow(new Object []{specijalizacija.name(), izabrana});
		
		}
	}
}
