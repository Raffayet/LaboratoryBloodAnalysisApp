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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class IzborDanaUNedelji extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6475720988789737478L;
	private static JPanel contentPane;
	private static JTable table;
	private JButton btnNewButton;
	private static ArrayList<String> daniUNedelji = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public IzborDanaUNedelji() {
		setTitle("Izbor dana u nedelji");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 649, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		daniUNedelji.clear();
		
		daniUNedelji.add("Ponedeljak");
		daniUNedelji.add("Utorak");
		daniUNedelji.add("Sreda");
		daniUNedelji.add("Cetvrtak");
		daniUNedelji.add("Petak");
		daniUNedelji.add("Subota");
		daniUNedelji.add("Nedelja");
		
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
				"Dani u nedelji", "Izabrano"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7550189199634019336L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.setRowHeight(25);
		scrollPane_1.setViewportView(table);
		
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
            e.getWindow().dispose();
            IzborVremenskogOpsegaIzvestaji.ispisIzabranihDana();
            
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
				
				String izabranDan = "";
				
				for (int red = 0; red < table.getRowCount(); red ++){
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        izabranDan = (model.getValueAt(red, 0)).toString();
			        
			        boolean izabran = Boolean.parseBoolean(model.getValueAt(red, 1).toString());
			      
			        if (izabran == true) {
		        
			        	if (!IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.contains(izabranDan)) {
			        		
			        		IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.add(izabranDan);
			        	}
			        }
			        
			        else {
			        
			        	IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.remove(izabranDan);
			        }
				}
			}
		});
		
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		btnNewButton.setBounds(203, 221, 230, 45);
		contentPane.add(btnNewButton);
	}

	
	private static void popunjavanjeTabele() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Boolean izabran = false;
		
		for (String dan : daniUNedelji) {
			
			if (IzborVremenskogOpsegaIzvestaji.izabraniDaniUNedelji.contains(dan)) {
	
				izabran = true;
			}
			
			else {
				
				izabran = false;
			}
			
			model.addRow(new Object []{dan, izabran});
		
		}
	}
}
