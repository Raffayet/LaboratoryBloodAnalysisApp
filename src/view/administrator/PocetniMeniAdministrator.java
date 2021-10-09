package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import enumeracije.Pol;
import view.medicinski_tehnicar.PocetniMeniMedicinskiTehnicar;
import view.univerzalno.Prijava;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PocetniMeniAdministrator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 915422144033807039L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PocetniMeniAdministrator frame = new PocetniMeniAdministrator();
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
	public PocetniMeniAdministrator(String korisnickoImeUlogovanogKorisnika) {
		
		setTitle("Pocetni meni administratora");
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
		
		JButton btnNewButton_1 = new JButton("Racunanje mesecne plate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborZaposlenogZaRacunanjePlate racunanjeMesecnePlate = new IzborZaposlenogZaRacunanjePlate(korisnickoImeUlogovanogKorisnika);
				racunanjeMesecnePlate.setVisible(true);
			}
		});
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
		btnNewButton_1.setBounds(0, 0, 240, 43);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("Izvestaji prihoda");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestajiPrihodi = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "prihodi");
				izborVremenskogOpsegaIzvestajiPrihodi.setVisible(true);
			}
		});
		
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
		btnNewButton_2.setBounds(0, 54, 240, 43);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("Microsoft Sans Se5if", Font.PLAIN, 16));
		
		JButton btnNewButton_5 = new JButton("Izvestaji rashoda");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestajiRashodi = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "rashodi");
				izborVremenskogOpsegaIzvestajiRashodi.setVisible(true);
			}
		});
		
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
		btnNewButton_5.setBounds(0, 108, 240, 43);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setFont(new Font("Microsoft5Sans Serif", Font.PLAIN, 16));
		
		JButton dugmeRegistracijaZaposlenih = new JButton("Registracija zaposlenih");
		
		dugmeRegistracijaZaposlenih.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				dugmeRegistracijaZaposlenih.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				dugmeRegistracijaZaposlenih.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dugmeRegistracijaZaposlenih.setBackground(new Color(35, 19, 76));
			}
		});
		dugmeRegistracijaZaposlenih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborZaposlenogZaRegistraciju izborZaposlenogZaRegistraciju = new IzborZaposlenogZaRegistraciju(korisnickoImeUlogovanogKorisnika);
				izborZaposlenogZaRegistraciju.setVisible(true);
			}
		});
		dugmeRegistracijaZaposlenih.setForeground(Color.WHITE);
		dugmeRegistracijaZaposlenih.setFont(new Font("Microsoft5Sans Serif", Font.PLAIN, 16));
		dugmeRegistracijaZaposlenih.setBorderPainted(false);
		dugmeRegistracijaZaposlenih.setBackground(new Color(11, 7, 17));
		dugmeRegistracijaZaposlenih.setBounds(0, 162, 240, 43);
		panel_1.add(dugmeRegistracijaZaposlenih);
		
		JButton btnNewButton_5_2 = new JButton("Azuriranje cene analiza");
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				AzuriranjeCeneAnaliza azuriranjeCeneAnaliza = new AzuriranjeCeneAnaliza(korisnickoImeUlogovanogKorisnika);
				azuriranjeCeneAnaliza.setVisible(true);
			}
		});
		
		btnNewButton_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5_2.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5_2.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5_2.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_5_2.setForeground(Color.WHITE);
		btnNewButton_5_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_5_2.setBorderPainted(false);
		btnNewButton_5_2.setBackground(new Color(11, 7, 17));
		btnNewButton_5_2.setBounds(0, 216, 240, 49);
		panel_1.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_2_1 = new JButton("Izvestaji pacijenata");
		btnNewButton_5_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestajiZahteva = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "pacijenti");
				izborVremenskogOpsegaIzvestajiZahteva.setVisible(true);
			}
		});
		btnNewButton_5_2_1.setForeground(Color.WHITE);
		btnNewButton_5_2_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_5_2_1.setBorderPainted(false);
		btnNewButton_5_2_1.setBackground(new Color(11, 7, 17));
		btnNewButton_5_2_1.setBounds(0, 278, 240, 49);
		panel_1.add(btnNewButton_5_2_1);
		
		btnNewButton_5_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5_2_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5_2_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5_2_1.setBackground(new Color(35, 19, 76));
			}
		});
		
		JButton btnNewButton_5_2_1_1 = new JButton("Dodavanje specijalizacija");
		btnNewButton_5_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborLaborantaDodavanjeSpecijalizacija izborLaborantaDodavanjeSpecijalizacija = new IzborLaborantaDodavanjeSpecijalizacija(korisnickoImeUlogovanogKorisnika);
				izborLaborantaDodavanjeSpecijalizacija.setVisible(true);
			}
		});
		btnNewButton_5_2_1_1.setForeground(Color.WHITE);
		btnNewButton_5_2_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_5_2_1_1.setBorderPainted(false);
		btnNewButton_5_2_1_1.setBackground(new Color(11, 7, 17));
		btnNewButton_5_2_1_1.setBounds(0, 338, 240, 49);
		panel_1.add(btnNewButton_5_2_1_1);
		
		JButton btnNewButton_5_2_1_1_1 = new JButton("Dodavanje analiza");
		btnNewButton_5_2_1_1_1.setForeground(Color.WHITE);
		btnNewButton_5_2_1_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_5_2_1_1_1.setBorderPainted(false);
		btnNewButton_5_2_1_1_1.setBackground(new Color(11, 7, 17));
		btnNewButton_5_2_1_1_1.setBounds(0, 398, 240, 49);
		panel_1.add(btnNewButton_5_2_1_1_1);
		
		btnNewButton_5_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				DodavanjeAnalize dodavanjeAnalize = new DodavanjeAnalize(korisnickoImeUlogovanogKorisnika);
				dodavanjeAnalize.setVisible(true);
			}
		});
		btnNewButton_5_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1.setBackground(new Color(35, 19, 76));
			}
		});
		
		JButton btnNewButton_5_2_1_1_1_1 = new JButton("Izvestaji zahteva");
		btnNewButton_5_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				IzborVremenskogOpsegaIzvestaji izborVremenskogOpsegaIzvestajiZahteva = new IzborVremenskogOpsegaIzvestaji(korisnickoImeUlogovanogKorisnika, "zahtevi");
				izborVremenskogOpsegaIzvestajiZahteva.setVisible(true);
			}
		});
		btnNewButton_5_2_1_1_1_1.setForeground(Color.WHITE);
		btnNewButton_5_2_1_1_1_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		btnNewButton_5_2_1_1_1_1.setBorderPainted(false);
		btnNewButton_5_2_1_1_1_1.setBackground(new Color(11, 7, 17));
		btnNewButton_5_2_1_1_1_1.setBounds(0, 458, 240, 49);
		panel_1.add(btnNewButton_5_2_1_1_1_1);
		
		btnNewButton_5_2_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5_2_1_1_1_1.setBackground(new Color(35, 19, 76));
			}
		});
		
		btnNewButton_5_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton_5_2_1_1.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton_5_2_1_1.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton_5_2_1_1.setBackground(new Color(35, 19, 76));
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/log_out-2das-512.png")));
		lblNewLabel_1.setBounds(857, 397, 75, 87);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/log_out-gfasd2-512.png")));
		lblNewLabel_2.setBounds(847, 384, 96, 112);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(korisnickoImeUlogovanogKorisnika);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setBounds(763, 186, 156, 51);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Administrator");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 26));
		lblNewLabel_5.setBounds(408, 406, 172, 78);
		contentPane.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 153, 153));
		separator.setBounds(274, 402, 435, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 153, 153));
		separator_1.setBounds(274, 482, 435, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		String polUlogovanoKorisnika = KorisniciController.vracanjePolaNaOsnovuKorisnickogImena(korisnickoImeUlogovanogKorisnika);
		
		if (polUlogovanoKorisnika.equals(Pol.MUSKI.name())) {
			
			lblNewLabel.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/man5-51bfszxb2.png")));
		}
		
		else if (polUlogovanoKorisnika.equals(Pol.ZENSKI.name())){
			
			lblNewLabel.setIcon(new ImageIcon(PocetniMeniMedicinskiTehnicar.class.getResource("/slike/21996fgagadfssd9.png")));
		}
		
		
		lblNewLabel.setBounds(788, 25, 150, 150);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(PocetniMeniAdministrator.class.getResource("/slike/path15gsfdg53.png")));
		lblNewLabel_4.setBounds(274, 25, 435, 326);
		contentPane.add(lblNewLabel_4);
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
