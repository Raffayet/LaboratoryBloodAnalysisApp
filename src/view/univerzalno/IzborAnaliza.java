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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AnalizaController;
import model.Analiza;

public class IzborAnaliza extends JFrame {

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
	public IzborAnaliza(String ukupnaCena) {
		setTitle("Izbor analiza");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
				"Ime analize", "Cena", "Izabrano"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7550189199634019336L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.setRowHeight(25);
		scrollPane_1.setViewportView(table);
		
		boolean odredjenoVreme = false;
		
		boolean kucnaPoseta = false;
		
		JLabel lblNewLabel = new JLabel("Cena analiza: " + 
		AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) + "  RSD");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 221, 384, 45);
		contentPane.add(lblNewLabel);
		
		popunjavanjeTabele();
		
		btnNewButton = new JButton("Potvrda");
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
			
			KreiranjeZahteva.lblNewLabel_6.setText("Ukupna cena: " +
					AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) + "  RSD");
            e.getWindow().dispose();
            
           }
        });
		
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
				
				String izabranaAnaliza = "";
				
				for (int red = 0; red < table.getRowCount(); red ++){
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        izabranaAnaliza = (model.getValueAt(red, 0)).toString();
			        
			        boolean izabrana = Boolean.parseBoolean(model.getValueAt(red, 2).toString());
			      
			        if (izabrana == true) {
		        
			        	if (!KreiranjeZahteva.izabraneAnalize.contains(izabranaAnaliza)) {
			        		
			        		KreiranjeZahteva.izabraneAnalize.add(izabranaAnaliza);
			        	}
			        }
			        
			        else {
			        
			        	KreiranjeZahteva.izabraneAnalize.remove(izabranaAnaliza);
			        }
				}
				lblNewLabel.setText("Cena analiza: " + 
				AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) + "  RSD");
			}
		});
		
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(500, 223, 123, 45);
		contentPane.add(btnNewButton);
	}

	
	private static void popunjavanjeTabele() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Boolean izabrana = false;
		
		for (Analiza analiza : AnalizaController.analize) {
			
			if (KreiranjeZahteva.izabraneAnalize.contains(analiza.getImeAnalize())) {
	
				izabrana = true;
			}
			
			else {
				
				izabrana = false;
			}
			
			model.addRow(new Object []{analiza.getImeAnalize(), String.valueOf(Math.round(analiza.getCena())) + "  RSD", izabrana});
		
		}
	}
}
