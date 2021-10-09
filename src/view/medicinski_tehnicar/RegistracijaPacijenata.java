package view.medicinski_tehnicar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import enumeracije.Pol;
import model.Korisnik;
import javax.swing.JSeparator;

public class RegistracijaPacijenata extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -656834975247847858L;
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
	@SuppressWarnings("unused")
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtDdmmgggg;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistracijaPacijenata frame = new RegistracijaPacijenata();
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
	public RegistracijaPacijenata(String korisnickoImeUlogovanogKorisnika) {
		
		setTitle("Registracija pacijenata");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOZINKA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds(602, 101, 108, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KORISNICKO IME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(602, 45, 152, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IME");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(602, 161, 195, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ADRESA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(602, 279, 234, 24);
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
		muski.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
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
		
		zenski.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		zenski.setBackground(new Color(242, 81, 215));
		zenski.setForeground(Color.WHITE);

		addWindowListener(new WindowAdapter()
        {
			@Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoImeUlogovanogKorisnika);
                pocetniMeniMedicinskiTehnicar.setVisible(true);
            }
        });
		
		JTextField textField_2 = new JTextField();
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(null);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		textField_2.setBackground(new Color(32, 30, 45));
		textField_2.setBounds(602, 126, 311, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		textField_3.setBackground(new Color(32, 30, 45));
		textField_3.setBounds(602, 185, 311, 24);
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
		muski.setBounds(602, 547, 116, 24);
		contentPane.add(muski);
		
		zenski.setBounds(769, 547, 116, 24);
		contentPane.add(zenski);
		
		JLabel lblNewLabel_4 = new JLabel("PREZIME");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(602, 220, 184, 24);
		contentPane.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setCaretColor(Color.WHITE);
		
		textField_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_4.setForeground(Color.WHITE);
		textField_4.setBackground(new Color(32, 30, 45));
	
		textField_4.setBounds(602, 244, 311, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 0, 501, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(RegistracijaPacijenata.class.getResource("/slike/registracijaPacijenata.png")));
		lblNewLabel_5.setBounds(0, 0, 501, 680);
		panel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(null);
		textField_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(32, 30, 45));
		textField_1.setBounds(602, 66, 311, 24);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("LBO");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(602, 339, 234, 24);
		contentPane.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setBorder(null);
		textField_6.setForeground(Color.WHITE);
		textField_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(32, 30, 45));
		textField_6.setBounds(602, 363, 311, 24);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("POL");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(602, 516, 234, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setBorder(null);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(32, 30, 45));
		textField_5.setBounds(602, 304, 311, 24);
		contentPane.add(textField_5);
		
		JButton dugmeZaRegistraciju = new JButton("Registracija");
		dugmeZaRegistraciju.setBorderPainted(false);
		dugmeZaRegistraciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dugmeZaRegistraciju.setForeground(Color.WHITE);
		dugmeZaRegistraciju.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		dugmeZaRegistraciju.setBounds(664, 600, 184, 43);
		contentPane.add(dugmeZaRegistraciju);
		dugmeZaRegistraciju.setBackground(new Color(179, 14, 14));
		
		JLabel lblNewLabel_3_1_2 = new JLabel("TELEFON");
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_2.setBounds(602, 398, 234, 24);
		contentPane.add(lblNewLabel_3_1_2);
		
		textField_8 = new JTextField();
		textField_8.setCaretColor(Color.WHITE);
		textField_8.setBorder(null);
		textField_8.setForeground(Color.WHITE);
		textField_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBackground(new Color(32, 30, 45));
		textField_8.setBounds(602, 422, 311, 24);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("DATUM RODJENJA");
		lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_2_1.setBounds(602, 457, 234, 24);
		contentPane.add(lblNewLabel_3_1_2_1);
		
		txtDdmmgggg = new JTextField();
		txtDdmmgggg.setBorder(null);
		txtDdmmgggg.setCaretColor(Color.WHITE);
		txtDdmmgggg.setText("dd/mm/gggg");
		txtDdmmgggg.setForeground(Color.GRAY);
		txtDdmmgggg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txtDdmmgggg.setColumns(10);
		txtDdmmgggg.setBackground(new Color(32, 30, 45));
		txtDdmmgggg.setBounds(602, 481, 311, 24);
		contentPane.add(txtDdmmgggg);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(RegistracijaPacijenata.class.getResource("/slike/Malege54235ag.png")));
		lblNewLabel_6.setBounds(724, 549, 22, 25);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(RegistracijaPacijenata.class.getResource("/slike/1719b1fec10c32f9fhgfasec4683dec9c35bb.png")));
		lblNewLabel_7.setBounds(891, 544, 22, 34);
		contentPane.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(109, 213, 170));
		separator.setBackground(new Color(109, 213, 170));
		separator.setBounds(602, 92, 311, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setBounds(602, 152, 311, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setBounds(602, 211, 311, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(109, 213, 170));
		separator_3.setBackground(new Color(109, 213, 170));
		separator_3.setBounds(602, 270, 311, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(109, 213, 170));
		separator_4.setBackground(new Color(109, 213, 170));
		separator_4.setBounds(602, 330, 311, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(109, 213, 170));
		separator_5.setBackground(new Color(109, 213, 170));
		separator_5.setBounds(602, 389, 311, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(new Color(109, 213, 170));
		separator_6.setForeground(new Color(109, 213, 170));
		separator_6.setBounds(602, 448, 311, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(109, 213, 170));
		separator_7.setBackground(new Color(109, 213, 170));
		separator_7.setBounds(602, 507, 311, 2);
		contentPane.add(separator_7);
		
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
				String LBO = textField_6.getText();
				String telefon = textField_8.getText();
				String datumRodjenja = txtDdmmgggg.getText();
				
				proveraPraznogUnosa(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, datumRodjenja);
				
			}

			private void proveraUnosaDatumaRodjenja(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon, String pol, String datumRodjenja) {
				
				if (!datumRodjenja.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")){
				
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format datuma! Unesite datum u formatu: (dd/mm/gggg)", 
							"Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					JOptionPane.showMessageDialog(new JFrame(), "Uspesna registracija!");
					setVisible(false);
					KorisniciController.registracijaPacijenata(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, pol, datumRodjenja);
					PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoImeUlogovanogKorisnika);
	                pocetniMeniMedicinskiTehnicar.setVisible(true);
				}
				
			}

			private void proveraUnosaTelefona(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon, String pol, String datumRodjenja) {
				
				if ((telefon.length() != 9 && telefon.length() != 10) || (telefon.charAt(0) != ('0') || telefon.charAt(1) != '6') || !telefon.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format broja mobilnog telefona!", "Greska", JOptionPane.ERROR_MESSAGE);
				}

				
				else {
					
					proveraUnosaDatumaRodjenja(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, pol, datumRodjenja);
				}
			}

			private void proveraOdabiraPola(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon, String datumRodjenja) {
				
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
					
					proveraUnosaTelefona(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, pol, datumRodjenja);
				}
			}

			private void proveraUnosaLBO(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon, String datumRodjenja) {
						
				if (KorisniciController.licniBrojeviOsiguranika.contains(LBO)){
							
					JOptionPane.showMessageDialog(new JFrame(), "Ovaj LBO vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (LBO.length() != 11 || !LBO.matches(("^\\d+$"))) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Licni broj osiguranika (LBO) mora imati 11 cifara!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraOdabiraPola(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, datumRodjenja);
				}
			
			}

			private void proveraUnosaSpejsa(String korisnickoIme, String lozinka, String LBO,
											String ime, String prezime, String adresa, String telefon, String datumRodjenja) {
				if (korisnickoIme.contains(" ") || lozinka.contains(" ") || LBO.contains(" ") || ime.contains(" ") ||
					prezime.contains(" ") || adresa.contains(" ") || telefon.contains(" ") || datumRodjenja.contains(" ")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaPostojecegKorisnickogImena(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, datumRodjenja);
				}
				
			}

			private void proveraUnosaPostojecegKorisnickogImena(String korisnickoIme, String lozinka, String LBO, String ime, String prezime, String adresa, String telefon, String datumRodjenja) {
				
				boolean pronadjenoKorisnickoIme = false;
				
				for (Korisnik korisnik : KorisniciController.korisnici) {
					
					if (korisnickoIme.equals(korisnik.getKorisnickoIme())){
						
						pronadjenoKorisnickoIme = true;
						JOptionPane.showMessageDialog(new JFrame(), "Ovo korisnicko ime vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				if (pronadjenoKorisnickoIme == false) {
					
					proveraUnosaLBO(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, datumRodjenja);
				}
				
			}

			private void proveraPraznogUnosa(String korisnickoIme, String lozinka, String LBO, String ime, 
											 String prezime, String adresa, String telefon, String datumRodjenja) {
				
				if (korisnickoIme.equals("") || lozinka.equals("") || LBO.equals("") ||ime.equals("") || prezime.equals("") || adresa.equals("") ||
					telefon.equals("") || datumRodjenja.equals("") || (!muski.isSelected() && !zenski.isSelected())) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else {
					
					proveraUnosaSpejsa(korisnickoIme, lozinka, LBO, ime, prezime, adresa, telefon, datumRodjenja);
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
