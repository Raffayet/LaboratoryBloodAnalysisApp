package view.medicinski_tehnicar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import model.Nalaz;
import model.Zahtev;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PreuzetiZahtevi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6528407384545027124L;
	private JPanel contentPane;
	private static JTable table;
	public static ArrayList<String> idIzabranihZahteva = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PreuzetiZahtevi frame = new PreuzetiZahtevi();
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
	@SuppressWarnings("serial")
	public PreuzetiZahtevi(String korisnickoIme) {
		setTitle("Preuzeti zahtevi");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 668, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 652, 374);
		scrollPane.setBackground(new Color(32, 30, 45));
		contentPane.add(scrollPane);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoIme);
                pocetniMeniMedicinskiTehnicar.setVisible(true);
            }
        });
		
		ZahtevController.ucitavanjeIzabranihZahteva();
		
		table = new JTable();
		table.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		table.setForeground(Color.WHITE);
		table.setBackground(new Color(44, 62, 80));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "LBO", "Analize", "Vreme uzorka", "Uzet uzorak", "Kucna poseta"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Boolean.class, Boolean.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				
				Object o = getValueAt(row, column);
				
				boolean b = (Boolean) o;
				
				if (b == true) {
					
					return false;
				}
				
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(69);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(76);
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Potvrda");
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
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int red = 0; red < table.getRowCount(); red ++){
			        DefaultTableModel model = (DefaultTableModel)table.getModel();
			        
			        String idIzabranogZahteva = (model.getValueAt(red, 0)).toString();
			        boolean izabranZahtev = Boolean.parseBoolean(model.getValueAt(red, 4).toString());
			        Nalaz nalaz = NalazController.vracanjeNalazaNaOsnovuZahteva(idIzabranogZahteva);
			        
			        if (izabranZahtev == true) {
			        	
			        	if (!idIzabranihZahteva.contains(idIzabranogZahteva)) {
			        		
			        		NalazController.menjanjeStatusaUzimanjeUzorka(nalaz);
			        		
			        		idIzabranihZahteva.add(idIzabranogZahteva);
			        	}
			        	
			        	KorisniciController.azuriranjeBonusaZaMedicinskogTehnicara(korisnickoIme);
			        }
			        
			        else {
			        	
			        	idIzabranihZahteva.remove(idIzabranogZahteva);
			        }
			}
				
				JOptionPane.showMessageDialog(new JFrame(), "Sacuvano!");
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(239, 385, 196, 44);
		contentPane.add(btnNewButton);
		popunjavanjeTabele();
	}
	
	private static void popunjavanjeTabele() {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		DateTimeFormatter formatZaDatum = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
		
		boolean izabranZahtev = false;
		
		for (Zahtev zahtev : ZahtevController.zahteviPoMedicinskomTehnicaru) {
			
			if (idIzabranihZahteva.contains(String.valueOf(zahtev.getIdZahteva()))){
				
				izabranZahtev = true;
			}
			
			else {
				
				izabranZahtev = false;
			}
			
			model.addRow(new Object []{zahtev.getIdZahteva(), zahtev.getLBO(), ZahtevController.prikazPojedinacnihAnaliza(zahtev), zahtev.getVremeUzorka().format(formatZaDatum),
					izabranZahtev, zahtev.isKucnaPoseta()});
		}
	}
}
