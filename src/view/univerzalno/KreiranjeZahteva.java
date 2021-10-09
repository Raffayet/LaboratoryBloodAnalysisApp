package view.univerzalno;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AnalizaController;
import controller.KorisniciController;
import controller.NalazController;
import controller.ZahtevController;
import enumeracije.Entitet;
import view.medicinski_tehnicar.PocetniMeniMedicinskiTehnicar;
import view.pacijent.PocetniMeniPacijent;
import javax.swing.JSeparator;

public class KreiranjeZahteva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -777347333623048319L;
	private JPanel contentPane;
	private JTextField txtGvyu;
	private JTextField txtDdmmgggg;
	public static ArrayList<String> izabraneAnalize = new ArrayList<String>();
	private JTextField txtSsmm;
	boolean kucnaPoseta = false;
	boolean odredjenoVreme = false;
	public static JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public KreiranjeZahteva(String entitet, String korisnickoIme) {
		setTitle("Kreiranje zahteva");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String ukupnaCena = "";
		
		JLabel lblNewLabel = new JLabel("LBO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(636, 146, 108, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ANALIZE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(636, 56, 83, 24);
		contentPane.add(lblNewLabel_1);
		
		JButton izborAnalizeDugme = new JButton("Izaberite analize");
		izborAnalizeDugme.setBorderPainted(false);
		izborAnalizeDugme.setBackground(new Color(12, 91, 123));
		izborAnalizeDugme.setForeground(Color.WHITE);
		
		izborAnalizeDugme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				izborAnalizeDugme.setBackground(new Color(53, 158, 200));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				izborAnalizeDugme.setBackground(new Color(12, 91, 123));
			}
		});
		
		izborAnalizeDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IzborAnaliza izborAnaliza = new IzborAnaliza(ukupnaCena);
				izborAnaliza.setVisible(true);
			}
		});
		
		izborAnalizeDugme.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		izborAnalizeDugme.setBounds(636, 91, 233, 31);
		contentPane.add(izborAnalizeDugme);
		
		JLabel lblNewLabel_2 = new JLabel("DATUM UZORKA");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(636, 243, 195, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("KUCNA POSETA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(636, 443, 165, 38);
		contentPane.add(lblNewLabel_3);
		
		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
			
			KorisniciController.punjenjeListeKorisnickihImena();
				
            e.getWindow().dispose();
            
            if (KorisniciController.korisnickaImenaMedicinskihTehnicara.contains(korisnickoIme)) {
                PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoIme);
                pocetniMeniMedicinskiTehnicar.setVisible(true);
            }
            
            else if (KorisniciController.korisnickaImenaPacijenata.contains(korisnickoIme)){
			
            	PocetniMeniPacijent pocetniMeniPacijent = new PocetniMeniPacijent(korisnickoIme);
            	pocetniMeniPacijent.setVisible(true);
		}
            }
        });
		
		JRadioButton da = new JRadioButton("Da");
		da.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				da.setBackground(new Color(48, 152, 106));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				da.setBackground(new Color(109, 213, 170));
			}
		});
		da.setBackground(new Color(109, 213, 170));
		da.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		da.setForeground(Color.WHITE);
		
		JRadioButton ne = new JRadioButton("Ne");
		
		ne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				ne.setBackground(new Color(48, 152, 106));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				ne.setBackground(new Color(109, 213, 170));
			}
		});
		
		ne.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		ne.setBackground(new Color(109, 213, 170));
		ne.setForeground(Color.WHITE);
		
		JButton btnNewButton = new JButton("Kreiranje");
		btnNewButton.setBorderPainted(false);
		
		btnNewButton.setBackground(new Color(179, 14, 14));
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(241, 76, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(179, 14, 14));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(241, 76, 76));
			}
		});
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String LBO = txtGvyu.getText();
				String datumUzorka = txtDdmmgggg.getText();
				String vremeUzorka = txtSsmm.getText();
				
				if (vremeUzorka.equals("ss:mm")) {
					
					vremeUzorka = "00:00";
				}
				
				proveraPraznogUnosa(LBO, datumUzorka, vremeUzorka);
				
			}

			private void proveraPraznogUnosa(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (LBO.equals("") ||datumUzorka.equals("") ||  (!da.isSelected() && !ne.isSelected())) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Nisu sva obavezna polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
						
					}
					
					else {
						
						proveraUnosaSpejsa(LBO, datumUzorka, vremeUzorka);
					}
			}

			private void proveraUnosaSpejsa(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (LBO.contains(" ") || vremeUzorka.contains(" ")) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						
						proveraOdabiraAnaliza(LBO, datumUzorka, vremeUzorka);
					}
				
			}

			private void proveraOdabiraAnaliza(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (izabraneAnalize.size() == 0) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali analize!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaLBO(LBO, datumUzorka, vremeUzorka);
				}
				
			}

			private void proveraUnosaLBO(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (entitet == Entitet.MEDICINSKI_TEHNICAR.name()) {
				
					if (!KorisniciController.licniBrojeviOsiguranika.contains(LBO)){
						
						JOptionPane.showMessageDialog(new JFrame(), "Ovaj LBO pacijenta ne postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				
				else if (LBO.length() != 11 || !LBO.matches(("-?\\d+(\\.\\d+)?"))) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Licni broj osiguranika (LBO) mora imati 11 cifara!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					proveraUnosaDatumaUzorka(LBO, datumUzorka, vremeUzorka);
				}
				}
				
				else {
					
					if (!LBO.equals(KorisniciController.vracanjeLBOPacijenta(korisnickoIme))) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Niste uneli vas LBO!", "Greska", 
						JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						
						proveraUnosaDatumaUzorka(LBO, datumUzorka, vremeUzorka);
					}
				}
			}

			private void proveraUnosaDatumaUzorka(String LBO, String datumUzorka, String vremeUzorka) {
				
				Date danasnjiDatum = java.util.Calendar.getInstance().getTime();
				
				if (!datumUzorka.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format datuma uzorka!", "Greska", JOptionPane.ERROR_MESSAGE);
				
				} else
					try {
						if (ZahtevController.proveraUnosaProslogDatuma(datumUzorka) != null &&
								ZahtevController.proveraUnosaProslogDatuma(datumUzorka).before(danasnjiDatum)) {
							
							JOptionPane.showMessageDialog(new JFrame(),
									"Mozete izabrati bilo koji datum pocevsi od sutra!", "Greska", JOptionPane.ERROR_MESSAGE);
						}
							
						else {
									
							proveraUnosaVremenaUzorka(LBO, datumUzorka, vremeUzorka);
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}

			private void proveraUnosaVremenaUzorka(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (!vremeUzorka.matches("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$") && !vremeUzorka.matches("00:00")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format vremena uzorka!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraOdabiraKucnePosete(LBO, datumUzorka, vremeUzorka);
				}
				
			}

			private void proveraOdabiraKucnePosete(String LBO, String datumUzorka, String vremeUzorka) {
				
				if (!da.isSelected() && !ne.isSelected()) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali da li hocete kucnu posetu!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					boolean kucnaPoseta = false;
					
					if (da.isSelected()) {
						
						kucnaPoseta = true;
					}
					
					else {
						
						kucnaPoseta = false;
					}
					
					JOptionPane.showMessageDialog(new JFrame(), "Uspesno kreiranje zahteva!");
					setVisible(false);
					ZahtevController.kreiranjeNovogZahteva(LBO, datumUzorka, vremeUzorka, String.valueOf(kucnaPoseta), entitet, korisnickoIme);
					NalazController.kreiranjeNovogNalaza(AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, 
							odredjenoVreme, kucnaPoseta));
					
					KorisniciController.punjenjeListeKorisnickihImena();
					
					 if (KorisniciController.korisnickaImenaMedicinskihTehnicara.contains(korisnickoIme)) {
						
			                PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoIme);
			                pocetniMeniMedicinskiTehnicar.setVisible(true);
			            }
			            
			            else if (KorisniciController.korisnickaImenaPacijenata.contains(korisnickoIme)){
						
			            	PocetniMeniPacijent pocetniMeniPacijent = new PocetniMeniPacijent(korisnickoIme);
			            	pocetniMeniPacijent.setVisible(true);
			            }
				
				}
				
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(861, 578, 136, 65);
		contentPane.add(btnNewButton);
		
		txtGvyu = new JTextField();
		txtGvyu.setCaretColor(Color.WHITE);
		txtGvyu.setForeground(Color.WHITE);
		txtGvyu.setBorder(null);
		txtGvyu.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		
		txtGvyu.setBackground(new Color(32, 30, 45));
		txtGvyu.setBounds(636, 182, 233, 31);
		contentPane.add(txtGvyu);
		txtGvyu.setColumns(10);
		
		txtDdmmgggg = new JTextField();
		txtDdmmgggg.setCaretColor(Color.WHITE);
		txtDdmmgggg.setBorder(null);
		txtDdmmgggg.setForeground(Color.GRAY);
		txtDdmmgggg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		txtDdmmgggg.setText("dd/mm/gggg");
		
		txtDdmmgggg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtDdmmgggg.getText().equals("dd/mm/gggg")) {
				
					txtDdmmgggg.setText("");
					txtDdmmgggg.setForeground(Color.WHITE);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (txtDdmmgggg.getText().equals("")) {
				
					txtDdmmgggg.setText("dd/mm/gggg");
				}
			}

			
		});
		
		txtDdmmgggg.setBackground(new Color(32, 30, 45));
		txtDdmmgggg.setBounds(636, 277, 233, 31);
		contentPane.add(txtDdmmgggg);
		txtDdmmgggg.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Ukupna cena: " +
		AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) + "  RSD");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		lblNewLabel_6.setBounds(511, 612, 279, 31);
		contentPane.add(lblNewLabel_6);
		
		ne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ne.isSelected()) {
					
					kucnaPoseta = false;
					
					da.setSelected(false);
				}
				
				lblNewLabel_6.setText("Ukupna cena: " +
				AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) + "  RSD");
			}
		});
		
		da.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (da.isSelected()) {
					
					kucnaPoseta = true;
					
					ne.setSelected(false);
				
				}
				
				else {
					
					kucnaPoseta = false;
				}
				
				lblNewLabel_6.setText("Ukupna cena: " + 
				AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) 
				+ "  RSD");
				
			}
		});
		da.setBounds(636, 488, 108, 31);
		contentPane.add(da);
		
		ne.setBounds(756, 488, 113, 31);
		contentPane.add(ne);
		
		JLabel lblNewLabel_4 = new JLabel("VREME UZORKA");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(636, 328, 184, 39);
		contentPane.add(lblNewLabel_4);
		
		txtSsmm = new JTextField();
		txtSsmm.setCaretColor(Color.WHITE);
		txtSsmm.setBorder(null);
		
		txtSsmm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtSsmm.getText().equals("ss:mm")) {
				
					txtSsmm.setText("");
					txtSsmm.setForeground(Color.WHITE);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (txtSsmm.getText().equals("")) {
				
					txtSsmm.setText("ss:mm");
				}
			}
			
		});
		
		txtSsmm.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		txtSsmm.setText("ss:mm");
		txtSsmm.setForeground(Color.GRAY);
		txtSsmm.setBackground(new Color(32, 30, 45));
		
		
		
		txtSsmm.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				
				String vreme = txtSsmm.getText();
				
				if (vreme.equals("") || vreme.equals("ss:mm")) {
					
					odredjenoVreme = false;
				}
				
				else {
					
					odredjenoVreme = true;
				}
				
				lblNewLabel_6.setText("Ukupna cena: " + 
						AnalizaController.vracanjeUkupneCeneZahteva(KreiranjeZahteva.izabraneAnalize, odredjenoVreme, kucnaPoseta) 
						+ "  RSD");
			}
		});
		txtSsmm.setBounds(636, 371, 233, 31);
		contentPane.add(txtSsmm);
		txtSsmm.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("(Opciono)");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(802, 336, 83, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("(Pritisnite ENTER posle unosa)");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(669, 408, 174, 24);
		contentPane.add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 0, 501, 654);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(KreiranjeZahteva.class.getResource("/slike/kreiranjeZahteva.png")));
		lblNewLabel_8.setBounds(0, 0, 501, 654);
		panel.add(lblNewLabel_8);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(109, 213, 170));
		separator.setBackground(new Color(109, 213, 170));
		separator.setBounds(636, 216, 233, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setBounds(636, 311, 233, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setBounds(636, 405, 233, 2);
		contentPane.add(separator_2);
	}
}
