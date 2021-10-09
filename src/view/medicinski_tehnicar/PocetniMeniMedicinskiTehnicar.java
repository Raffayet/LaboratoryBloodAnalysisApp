package view.medicinski_tehnicar;

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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import controller.ZahtevController;
import enumeracije.Entitet;
import enumeracije.Pol;
import view.univerzalno.KreiranjeZahteva;
import view.univerzalno.Prijava;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class PocetniMeniMedicinskiTehnicar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6422379935101281323L;
	private JPanel contentPane;

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PocetniMeniMedicinskiTehnicar frame = new PocetniMeniMedicinskiTehnicar();
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
	public PocetniMeniMedicinskiTehnicar(String korisnickoIme) {
		setTitle("Pocetni meni medicinskog tehnicara");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 980, 546);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 30, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				new JFrame("Izlaz");
				Object[] opcije = {"Da", "Ne"};
				
				if (JOptionPane.showOptionDialog(new JFrame(), "Da li ste sigurni da zelite da izadjete?", "Izlaz", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
						opcije, opcije[0]) == JOptionPane.YES_NO_OPTION) {
					
					System.exit(0);
				}	
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(11, 7, 17));
		panel_1.setBounds(0, 0, 240, 507);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Registracija pacijenata");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_1.setBackground(new Color(35, 19, 76));
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(11, 7, 17));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 240, 81);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				RegistracijaPacijenata registracijaPacijenata = new RegistracijaPacijenata(korisnickoIme);
				registracijaPacijenata.setVisible(true);
			}
		});
		
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Preuzeti zahtevi");
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_2.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_2.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_2.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(11, 7, 17));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(0, 92, 240, 73);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ZahtevController.preuzetiZahtevi(korisnickoIme);
				PreuzetiZahtevi preuzetiZahtevi = new PreuzetiZahtevi(korisnickoIme);
				preuzetiZahtevi.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_5 = new JButton("Registracija musterija");
		
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(new Color(11, 7, 17));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBounds(0, 176, 240, 73);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				RegistracijaMusterija registracijaMusterija = new RegistracijaMusterija(korisnickoIme);
				registracijaMusterija.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_3 = new JButton("Kreiranje zahteva");
		
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_3.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_3.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_3.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(new Color(11, 7, 17));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(0, 260, 240, 73);
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				KreiranjeZahteva.izabraneAnalize.clear();
				KreiranjeZahteva kreiranjeZahteva = new KreiranjeZahteva(Entitet.MEDICINSKI_TEHNICAR.name(), korisnickoIme);
				kreiranjeZahteva.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_4 = new JButton("Preuzimanje uzoraka");
		
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_4.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_4.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_4.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(11, 7, 17));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBounds(0, 344, 240, 73);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				PreuzimanjeUzorka preuzimanjeUzoraka = new PreuzimanjeUzorka(korisnickoIme);
				preuzimanjeUzoraka.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_4_1 = new JButton("Pregled nalaza");
		
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_4_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_4_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_4_1.setBackground(new Color(35, 19, 76));
			}
		});

		
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborPacijentaPregledNalaza izborPacijentaPregledNalaza = new IzborPacijentaPregledNalaza(korisnickoIme);
				izborPacijentaPregledNalaza.setVisible(true);
			}
		});
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_4_1.setBorderPainted(false);
		btnNewButton_4_1.setBackground(new Color(11, 7, 17));
		btnNewButton_4_1.setBounds(0, 428, 240, 79);
		panel_1.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/log_out-2das-512.png")));
		lblNewLabel_1.setBounds(857, 397, 75, 87);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/log_out-gfasd2-512.png")));
		lblNewLabel_2.setBounds(847, 384, 96, 112);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(korisnickoIme);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setBounds(763, 186, 156, 51);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Medicinski tehnicar");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 26));
		lblNewLabel_5.setBounds(371, 406, 358, 78);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 153, 153));
		separator.setBounds(274, 402, 455, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 153, 153));
		separator_1.setBounds(274, 482, 455, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/reczzdds1.png")));
		lblNewLabel_4.setBounds(250, -16, 503, 395);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		String polUlogovanoKorisnika = KorisniciController.vracanjePolaNaOsnovuKorisnickogImena(korisnickoIme);
		
		if (polUlogovanoKorisnika.equals(Pol.MUSKI.name())) {
			
			lblNewLabel.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/man5-51bfszxb2.png")));
		}
		
		else if (polUlogovanoKorisnika.equals(Pol.ZENSKI.name())){
			
			lblNewLabel.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/21996fgagadfssd9.png")));
		}
		
		lblNewLabel.setBounds(788, 25, 150, 150);
		contentPane.add(lblNewLabel);
		lblNewLabel_2.setVisible(false);
		
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblNewLabel_2.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblNewLabel_2.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				Prijava window = new Prijava();
				window.frmPrijavaNaSistem.setVisible(true);
			}
		});
	
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dispose();
				Prijava window = new Prijava();
				window.frmPrijavaNaSistem.setVisible(true);
			}
		});
	}
}
