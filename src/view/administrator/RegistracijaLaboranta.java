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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.EnumeracijeController;
import controller.KorisniciController;
import enumeracije.Pol;
import model.Korisnik;
import javax.swing.JSeparator;

public class RegistracijaLaboranta extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6842644124199130793L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTextField textField;
	private JTextField textField_1;
	@SuppressWarnings("unused")
	private JTextField textField_2;
	@SuppressWarnings("unused")
	private JTextField textField_3;
	@SuppressWarnings("unused")
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtDdmmgggg_1;
	private JTextField textField_8;
	@SuppressWarnings("unused")
	private JTextField txtDdmmgggg;
	private JTextField textField_9;
	private JTextField textField_10;
	ArrayList<String> strucneSpreme = EnumeracijeController.dobavljanjeStrucnihSprema();
	public static ArrayList<String> izabraneSpecijalizacije = new ArrayList<String>();
	String selektovanaStrucnaSprema;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistracijaMedicinskogTehnicara frame = new RegistracijaMedicinskogTehnicara();
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
	public RegistracijaLaboranta(String korisnickoImeUlogovanogKorisnika) {
		
		setTitle("Registracija laboranata");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOZINKA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel.setBounds(602, 91, 108, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KORISNICKO IME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(602, 39, 152, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IME");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(602, 141, 195, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ADRESA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(602, 235, 234, 15);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton muski = new JRadioButton("Muski");
		JRadioButton zenski = new JRadioButton("Zenski");
		
		muski.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				muski.setBackground(new Color(9, 107, 133));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				muski.setBackground(new Color(61, 190, 225));
			}
		});
		muski.setBackground(new Color(61, 190, 225));
		muski.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		muski.setForeground(Color.WHITE);
		
		zenski.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				zenski.setBackground(new Color(165, 21, 141));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				zenski.setBackground(new Color(242, 81, 215));
			}
		});
		
		zenski.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		zenski.setBackground(new Color(242, 81, 215));
		zenski.setForeground(Color.WHITE);

		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                PocetniMeniAdministrator pocetniMeniAdministrator = new PocetniMeniAdministrator(korisnickoImeUlogovanogKorisnika);
                pocetniMeniAdministrator.setVisible(true);
            }
        });
		
		JTextField textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(null);
		textField_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		textField_2.setBackground(new Color(32, 30, 45));
		textField_2.setBounds(602, 109, 311, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setBorder(null);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		textField_3.setBackground(new Color(32, 30, 45));
		textField_3.setBounds(602, 156, 311, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		zenski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (zenski.isSelected()) {
					
					muski.setSelected(false);
				}
			}
		});
		
		muski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (muski.isSelected()) {
					
					zenski.setSelected(false);
				
				}		
			}
		});
		muski.setBounds(602, 651, 81, 24);
		contentPane.add(muski);
		
		zenski.setBounds(731, 651, 81, 24);
		contentPane.add(zenski);
		
		JLabel lblNewLabel_4 = new JLabel("PREZIME");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(602, 188, 184, 15);
		contentPane.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setCaretColor(Color.WHITE);
		
		textField_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_4.setForeground(Color.WHITE);
		textField_4.setBackground(new Color(32, 30, 45));
	
		textField_4.setBounds(602, 203, 311, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 0, 501, 717);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(RegistracijaLaboranta.class.getResource("/slike/registracijaLaboranata.png")));
		lblNewLabel_5.setBounds(0, 0, 501, 717);
		panel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(32, 30, 45));
		textField_1.setBounds(602, 59, 311, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("TELEFON");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(602, 282, 234, 15);
		contentPane.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setBorder(null);
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(32, 30, 45));
		textField_6.setBounds(602, 297, 311, 21);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("POL");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBounds(602, 634, 234, 15);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setBorder(null);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(32, 30, 45));
		textField_5.setBounds(602, 250, 311, 21);
		contentPane.add(textField_5);
		
		JButton dugmeZaRegistraciju = new JButton("Registracija");
		dugmeZaRegistraciju.setBorderPainted(false);
		dugmeZaRegistraciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dugmeZaRegistraciju.setForeground(Color.WHITE);
		dugmeZaRegistraciju.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		dugmeZaRegistraciju.setBounds(882, 663, 115, 43);
		contentPane.add(dugmeZaRegistraciju);
		dugmeZaRegistraciju.setBackground(new Color(179, 14, 14));
		
		JLabel lblNewLabel_3_1_2 = new JLabel("DATUM RODJENJA");
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2.setBounds(602, 329, 234, 15);
		contentPane.add(lblNewLabel_3_1_2);
		
		txtDdmmgggg_1 = new JTextField();
		txtDdmmgggg_1.setCaretColor(Color.WHITE);
		txtDdmmgggg_1.setBorder(null);
		txtDdmmgggg_1.setText("dd/mm/gggg");
		txtDdmmgggg_1.setForeground(Color.GRAY);
		txtDdmmgggg_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txtDdmmgggg_1.setColumns(10);
		txtDdmmgggg_1.setBackground(new Color(32, 30, 45));
		txtDdmmgggg_1.setBounds(602, 345, 311, 21);
		contentPane.add(txtDdmmgggg_1);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("OSNOVA");
		lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1.setBounds(602, 377, 234, 15);
		contentPane.add(lblNewLabel_3_1_2_1);
		
		textField_8 = new JTextField();
		textField_8.setBorder(null);
		textField_8.setCaretColor(Color.WHITE);
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(32, 30, 45));
		textField_8.setBounds(602, 393, 311, 21);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_3_1_2_1_1 = new JLabel("KOEFICIJENT");
		lblNewLabel_3_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1_1.setBounds(602, 425, 234, 15);
		contentPane.add(lblNewLabel_3_1_2_1_1);
		
		textField_9 = new JTextField();
		textField_9.setCaretColor(Color.WHITE);
		textField_9.setBorder(null);
		textField_9.setForeground(Color.WHITE);
		textField_9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBackground(new Color(32, 30, 45));
		textField_9.setBounds(602, 441, 311, 21);
		contentPane.add(textField_9);
		
		JLabel lblNewLabel_3_1_2_1_1_1 = new JLabel("STAZ");
		lblNewLabel_3_1_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1_1_1.setBounds(602, 473, 234, 15);
		contentPane.add(lblNewLabel_3_1_2_1_1_1);
		
		textField_10 = new JTextField();
		textField_10.setBorder(null);
		textField_10.setCaretColor(Color.WHITE);
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(32, 30, 45));
		textField_10.setBounds(602, 488, 311, 21);
		contentPane.add(textField_10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selektovanaStrucnaSprema = String.valueOf(comboBox.getSelectedItem());
			}
		});
		EnumeracijeController.punjenjeComboBoxa(comboBox, strucneSpreme);
		
		comboBox.setBounds(602, 536, 311, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3_1_2_1_1_1_1 = new JLabel("NIVO STRUCNE SPREME");
		lblNewLabel_3_1_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1_1_1_1.setBounds(602, 520, 234, 15);
		contentPane.add(lblNewLabel_3_1_2_1_1_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(RegistracijaMedicinskogTehnicara.class.getResource("/slike/Malege54235ag.png")));
		lblNewLabel_6.setBounds(689, 647, 25, 34);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(RegistracijaMedicinskogTehnicara.class.getResource("/slike/1719b1fec10c32f9fhgfasec4683dec9c35bb.png")));
		lblNewLabel_7.setBounds(818, 647, 25, 34);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3_1_2_1_1_1_1_1 = new JLabel("SPECIJALIZACIJE");
		lblNewLabel_3_1_2_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1_1_1_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNewLabel_3_1_2_1_1_1_1_1.setBounds(602, 569, 234, 15);
		contentPane.add(lblNewLabel_3_1_2_1_1_1_1_1);
		
		JButton izborSpecijalizacijeDugme = new JButton("Izaberite specijalizacije");
		izborSpecijalizacijeDugme.setBorderPainted(false);
		izborSpecijalizacijeDugme.setBackground(new Color(109, 213, 170));
		izborSpecijalizacijeDugme.setForeground(Color.WHITE);
		izborSpecijalizacijeDugme.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		izborSpecijalizacijeDugme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				izborSpecijalizacijeDugme.setBackground(new Color(76, 190, 106));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				izborSpecijalizacijeDugme.setBackground(new Color(109, 213, 170));
			}
		});
		
		izborSpecijalizacijeDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IzborSpecijalizacija izborSpecijalizacija = new IzborSpecijalizacija();
				izborSpecijalizacija.setVisible(true);
			}
		});
		izborSpecijalizacijeDugme.setBounds(602, 586, 311, 37);
		contentPane.add(izborSpecijalizacijeDugme);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(109, 213, 170));
		separator.setForeground(new Color(109, 213, 170));
		separator.setBounds(602, 81, 311, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setBounds(602, 131, 311, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setBounds(602, 178, 311, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(109, 213, 170));
		separator_3.setBackground(new Color(109, 213, 170));
		separator_3.setBounds(602, 225, 311, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(109, 213, 170));
		separator_4.setBackground(new Color(109, 213, 170));
		separator_4.setBounds(602, 272, 311, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(109, 213, 170));
		separator_5.setBackground(new Color(109, 213, 170));
		separator_5.setBounds(602, 319, 311, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(new Color(109, 213, 170));
		separator_6.setBackground(new Color(109, 213, 170));
		separator_6.setBounds(602, 367, 311, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(109, 213, 170));
		separator_7.setBackground(new Color(109, 213, 170));
		separator_7.setBounds(602, 415, 311, 2);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(new Color(109, 213, 170));
		separator_8.setBackground(new Color(109, 213, 170));
		separator_8.setBounds(602, 463, 311, 2);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setForeground(new Color(109, 213, 170));
		separator_9.setBackground(new Color(109, 213, 170));
		separator_9.setBounds(602, 510, 311, 2);
		contentPane.add(separator_9);
		
		txtDdmmgggg_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (txtDdmmgggg_1.getText().equals("dd/mm/gggg")) {
				
					txtDdmmgggg_1.setText("");
					txtDdmmgggg_1.setForeground(Color.WHITE);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (txtDdmmgggg_1.getText().equals("")) {
				
					txtDdmmgggg_1.setText("dd/mm/gggg");
				}
			}
			
		});
		
		dugmeZaRegistraciju.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				dugmeZaRegistraciju.setBackground(new Color(241, 76, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				dugmeZaRegistraciju.setBackground(new Color(179, 14, 14));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				dugmeZaRegistraciju.setBackground(new Color(241, 76, 76));
			}
		});
		
		dugmeZaRegistraciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String korisnickoIme = textField_1.getText();
				String lozinka = textField_2.getText();
				String ime = textField_3.getText();
				String prezime = textField_4.getText();
				String adresa = textField_5.getText();
				String telefon = textField_6.getText();
				String datumRodjenja = txtDdmmgggg_1.getText();
				String osnova = textField_8.getText();
				String koeficijent = textField_9.getText();
				String staz = textField_10.getText();
				
				proveraPraznogUnosa(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				
			}

			private void proveraUnosaDatumaRodjenja(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja, 
					String osnova, String koeficijent, String staz) {
				
				if (!datumRodjenja.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")){
				
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format datuma! Unesite datum u formatu: (dd/mm/gggg)", 
							"Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaOsnove(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
				
			}

			private void proveraUnosaTelefona(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, 
					String datumRodjenja, String osnova, String koeficijent, String staz) {
				
				if ((telefon.length() != 9 && telefon.length() != 10) || (telefon.charAt(0) != ('0') || telefon.charAt(1) != '6') || !telefon.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format broja mobilnog telefona!", "Greska", JOptionPane.ERROR_MESSAGE);
				}

				
				else {
					
					proveraUnosaDatumaRodjenja(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
			}

			private void proveraOdabiraPola(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja, String osnova,
					String koeficijent, String staz) {
				
				if (!muski.isSelected() && !zenski.isSelected()) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali pol!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					String pol = null;
					
					if (muski.isSelected()) {
						
						pol = Pol.MUSKI.name();
					}
					
					else {
						
						pol = Pol.ZENSKI.name();
					}
					
					proveraOdabiraSpecijalizacija(korisnickoIme, lozinka, ime, prezime, adresa, telefon, pol, datumRodjenja, osnova, koeficijent, staz);
					
				}
			}

			private void proveraOdabiraSpecijalizacija(String korisnickoIme, String lozinka, String ime, String prezime,
					String adresa, String telefon, String pol, String datumRodjenja, String osnova, String koeficijent,
					String staz) {
				
				if (izabraneSpecijalizacije.size() == 0) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Niste izabrali specijalizacije!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					JOptionPane.showMessageDialog(new JFrame(), "Uspesna registracija!");
					setVisible(false);
					KorisniciController.registracijaLaboranta(korisnickoIme, lozinka, ime, prezime, adresa, telefon, pol, datumRodjenja, osnova, koeficijent,
							staz, selektovanaStrucnaSprema);
					PocetniMeniAdministrator pocetniMeniAdministrator = new PocetniMeniAdministrator(korisnickoImeUlogovanogKorisnika);
	                pocetniMeniAdministrator.setVisible(true);
				}
			}

			private void proveraUnosaSpejsa(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja, 
					String osnova, String koeficijent, String staz) {
				if (korisnickoIme.contains(" ") || lozinka.contains(" ") || ime.contains(" ") || prezime.contains(" ") || adresa.contains(" ") || telefon.contains(" ") || 
						datumRodjenja.contains(" ") || osnova.contains(" ") || koeficijent.contains(" ") || staz.contains(" ")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaPostojecegKorisnickogImena(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
				
			}

			private void proveraUnosaPostojecegKorisnickogImena(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon,
					String datumRodjenja, String osnova, String koeficijent, String staz) {
				
				boolean pronadjenoKorisnickoIme = false;
				
				for (Korisnik korisnik : KorisniciController.korisnici) {
					
					if (korisnickoIme.equals(korisnik.getKorisnickoIme())){
						
						pronadjenoKorisnickoIme = true;
						JOptionPane.showMessageDialog(new JFrame(), "Ovo korisnicko ime vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (pronadjenoKorisnickoIme == false) {
					
					proveraUnosaTelefona(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
				
			}
			
			private void proveraUnosaOsnove(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja,
					String osnova, String koeficijent, String staz) {
				
				if (!osnova.matches("([0-9]*)\\.([0-9]*)") && !osnova.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za osnovu!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaKoeficijenta(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
			}

			private void proveraUnosaKoeficijenta(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja, String osnova, 
					String koeficijent, String staz) {
				
				if (!koeficijent.matches("([0-9]*)\\.([0-9]*)") && !koeficijent.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za koeficijent!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
				
				proveraUnosaStaza(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
			}
			}
			
			private void proveraUnosaStaza(String korisnickoIme, String lozinka, String ime, String prezime, String adresa, String telefon, String datumRodjenja, String osnova, 
					String koeficijent, String staz) {
				
				if (!staz.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite ceo pozitivan broj za staz!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraOdabiraPola(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
			}
			
			private void proveraPraznogUnosa(String korisnickoIme, String lozinka, String ime, 
											 String prezime, String adresa, String telefon, String datumRodjenja, String osnova, String koeficijent, String staz) {
				
				if (korisnickoIme.equals("") || lozinka.equals("") || ime.equals("") || prezime.equals("") || adresa.equals("") ||
					telefon.equals("") || datumRodjenja.equals("") || osnova.equals("") || koeficijent.equals("") || staz.equals("") || (!muski.isSelected() && !zenski.isSelected())) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else {
					
					proveraUnosaSpejsa(korisnickoIme, lozinka, ime, prezime, adresa, telefon, datumRodjenja, osnova, koeficijent, staz);
				}
			}
		});
		
		muski.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (muski.isSelected()) {
					
					zenski.setSelected(false);
				}
			}
		});
	}
	}
