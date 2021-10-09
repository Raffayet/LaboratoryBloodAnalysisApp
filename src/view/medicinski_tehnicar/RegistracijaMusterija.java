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
import controller.MusterijaController;
import enumeracije.Pol;
import javax.swing.JSeparator;

public class RegistracijaMusterija extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5363340079404465059L;
	private JPanel contentPane;
	boolean kucnaPoseta = false;
	boolean odredjenoVreme = false;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegistracijaMusterija frame = new RegistracijaMusterija();
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
	public RegistracijaMusterija(String korisnickoIme) {
		
		setTitle("Registracija musterija");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PREZIME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel.setBounds(602, 112, 108, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IME");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(602, 42, 83, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADRESA");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(602, 182, 195, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("BROJ TELEFONA");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(602, 328, 234, 24);
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
		
		JButton btnNewButton = new JButton("Registracija");
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
		

		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		btnNewButton.setBounds(636, 596, 234, 36);
		contentPane.add(btnNewButton);
		
		JTextField textField_2 = new JTextField();
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setForeground(Color.WHITE);
		textField_2.setBorder(null);
		textField_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		
		textField_2.setBackground(new Color(32, 30, 45));
		textField_2.setBounds(602, 140, 311, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setBorder(null);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		
		textField_3.setBackground(new Color(32, 30, 45));
		textField_3.setBounds(602, 211, 311, 36);
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
		muski.setBounds(602, 523, 108, 31);
		contentPane.add(muski);
		
		zenski.setBounds(776, 523, 108, 31);
		contentPane.add(zenski);
		
		JLabel lblNewLabel_4 = new JLabel("LBO");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(602, 258, 184, 24);
		contentPane.add(lblNewLabel_4);
		
		JTextField textField_4 = new JTextField();
		textField_4.setCaretColor(Color.WHITE);
		textField_4.setBorder(null);
		
		textField_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		textField_4.setForeground(Color.WHITE);
		textField_4.setBackground(new Color(32, 30, 45));
	
		textField_4.setBounds(602, 286, 311, 31);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 0, 501, 675);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(RegistracijaMusterija.class.getResource("/slike/registracijaMusterija.png")));
		lblNewLabel_5.setBounds(0, 0, 501, 675);
		panel.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setBorder(null);
		textField_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(32, 30, 45));
		textField_1.setBounds(602, 70, 311, 31);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("DATUM RODJENJA");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(602, 403, 234, 24);
		contentPane.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setCaretColor(Color.WHITE);
		textField_6.setBorder(null);
		textField_6.setForeground(Color.GRAY);
		textField_6.setText("dd/mm/gggg");
		textField_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(32, 30, 45));
		textField_6.setBounds(602, 434, 311, 31);
		contentPane.add(textField_6);
		
		textField_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textField_6.getText().equals("dd/mm/gggg")) {
				
					textField_6.setText("");
					textField_6.setForeground(Color.WHITE);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				if (textField_6.getText().equals("")) {
				
					textField_6.setText("dd/mm/gggg");
				}
			}
			
		});
		
		JLabel lblNewLabel_3_1_1 = new JLabel("POL");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(602, 492, 234, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setBorder(null);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(32, 30, 45));
		textField_5.setBounds(602, 361, 311, 31);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(RegistracijaMusterija.class.getResource("/slike/Malegeagsagag.png")));
		lblNewLabel_6.setBounds(716, 522, 33, 36);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(RegistracijaMusterija.class.getResource("/slike/1719b1fec10c343212f9fec4683dec9c35bb.png")));
		lblNewLabel_7.setBounds(890, 525, 33, 31);
		contentPane.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(109, 213, 170));
		separator.setForeground(new Color(109, 213, 170));
		separator.setBounds(602, 173, 311, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setBounds(602, 103, 311, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(109, 213, 170));
		separator_1_1.setBackground(new Color(109, 213, 170));
		separator_1_1.setBounds(602, 249, 311, 2);
		contentPane.add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBounds(602, 319, 311, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(109, 213, 170));
		separator_3.setBackground(new Color(109, 213, 170));
		separator_3.setBounds(602, 394, 311, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBackground(new Color(109, 213, 170));
		separator_3_1.setForeground(new Color(109, 213, 170));
		separator_3_1.setBounds(602, 467, 311, 2);
		contentPane.add(separator_3_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ime = textField_1.getText();
				String prezime = textField_2.getText();
				String adresa = textField_3.getText();
				String LBO = textField_4.getText();
				String telefon = textField_5.getText();
				String datumRodjenja = textField_6.getText();
				
				proveraPraznogUnosa(ime, prezime, adresa, LBO, telefon, datumRodjenja);
			}

			private void proveraPraznogUnosa(String ime, String prezime, String adresa, String LBO, String telefon,
					String datumRodjenja) {
				
				if (LBO.equals("") || ime.equals("") || prezime.equals("") || adresa.equals("") ||
						telefon.equals("") || datumRodjenja.equals("") || (!muski.isSelected() && !zenski.isSelected())) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
						
				}
					
					else {
						
						proveraUnosaSpejsa(ime, prezime, adresa, LBO, telefon, datumRodjenja);
					}
				
			}

			private void proveraUnosaSpejsa(String ime, String prezime, String adresa, String LBO, String telefon,
					String datumRodjenja) {
				
				if (LBO.contains(" ") || ime.contains(" ") ||
						prezime.contains(" ") || adresa.contains(" ") || telefon.contains(" ") || datumRodjenja.contains(" ")) {
						
						JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
					}
					
					else {
						
						proveraUnosaLBO(ime, prezime, adresa, LBO, telefon, datumRodjenja);
					}
				
			}

			private void proveraUnosaLBO(String ime, String prezime, String adresa, String LBO, String telefon,
					String datumRodjenja) {
				
				if (KorisniciController.licniBrojeviOsiguranika.contains(LBO)){
					
					JOptionPane.showMessageDialog(new JFrame(), "Ovaj LBO vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else if (LBO.length() != 11 || !LBO.matches(("^\\d+$"))) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Licni broj osiguranika (LBO) mora imati 11 cifara!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraOdabiraPola(ime, prezime, adresa, LBO, telefon, datumRodjenja);
				}
				
			}

			private void proveraOdabiraPola(String ime, String prezime, String adresa, String LBO, String telefon,
					String datumRodjenja) {
				
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
					
					proveraUnosaTelefona(ime, prezime, adresa, LBO, telefon, pol, datumRodjenja);
				}
				
			}

			private void proveraUnosaTelefona(String ime, String prezime, String adresa, String LBO, String telefon,
					String pol, String datumRodjenja) {
				
				if ((telefon.length() != 9 && telefon.length() != 10) || (telefon.charAt(0) != ('0') || telefon.charAt(1) != '6') || !telefon.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format broja mobilnog telefona!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaDatumaRodjenja(ime, prezime, adresa, LBO, telefon, pol, datumRodjenja);
				}
			}

			private void proveraUnosaDatumaRodjenja(String ime, String prezime, String adresa, String LBO,
					String telefon, String pol, String datumRodjenja) {
				
				if (!datumRodjenja.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")){
					
					JOptionPane.showMessageDialog(new JFrame(), "Pogresan format datuma! Unesite datum u formatu: (dd/mm/gggg)", 
							"Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					MusterijaController.registracijaMusterija(ime, prezime, adresa, LBO, telefon, pol, datumRodjenja);
					JOptionPane.showMessageDialog(new JFrame(), "Uspesna registracija!");
					setVisible(false);
			        PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoIme);
			        pocetniMeniMedicinskiTehnicar.setVisible(true);
			         
				}
				
			}

			
		});
	}
}
