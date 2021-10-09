package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AnalizaController;
import controller.EnumeracijeController;
import enumeracije.GrupaAnalize;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class DodavanjeAnalize extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -656834975247847858L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTextField textField;
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
	private JTextField textField_10;

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
	public DodavanjeAnalize(String korisnickoImeUlogovanogKorisnika) {
		
		setTitle("Dodavanje analiza");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 719);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(32, 30, 45));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IME ANALIZE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel.setBounds(602, 101, 163, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GRUPA ANALIZE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(602, 45, 152, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("JEDINICA MERE");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(602, 161, 195, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("REF. VREDNOST OD (MUSKI)");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(602, 279, 300, 24);
		contentPane.add(lblNewLabel_3);

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
		textField_2.setBounds(602, 126, 311, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setBorder(null);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		
		textField_3.setBackground(new Color(32, 30, 45));
		textField_3.setBounds(602, 185, 311, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CENA");
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
		lblNewLabel_5.setIcon(new ImageIcon(DodavanjeAnalize.class.getResource("/slike/dodavanjeAnaliza.png")));
		lblNewLabel_5.setBounds(0, 0, 501, 680);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3_1 = new JLabel("REF. VREDNOST DO (MUSKI)");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(602, 339, 311, 24);
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
		
		JLabel lblNewLabel_3_1_1 = new JLabel("POPUST");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(602, 516, 234, 24);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setCaretColor(Color.WHITE);
		textField_5.setForeground(Color.WHITE);
		textField_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(32, 30, 45));
		textField_5.setBounds(602, 304, 311, 24);
		contentPane.add(textField_5);
		
		JButton dugmeZaRegistraciju = new JButton("Dodavanje");
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
		
		JLabel lblNewLabel_3_1_2 = new JLabel("REF. VREDNOST OD (ZENSKI)");
		lblNewLabel_3_1_2.setForeground(Color.WHITE);
		lblNewLabel_3_1_2.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_2.setBounds(602, 398, 300, 24);
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
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("REF. VREDNOST DO (ZENSKI)");
		lblNewLabel_3_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_2_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_2_1.setBounds(602, 457, 300, 24);
		contentPane.add(lblNewLabel_3_1_2_1);
		
		txtDdmmgggg = new JTextField();
		txtDdmmgggg.setBorder(null);
		txtDdmmgggg.setCaretColor(Color.WHITE);
		txtDdmmgggg.setForeground(Color.WHITE);
		txtDdmmgggg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		txtDdmmgggg.setColumns(10);
		txtDdmmgggg.setBackground(new Color(32, 30, 45));
		txtDdmmgggg.setBounds(602, 481, 311, 24);
		contentPane.add(txtDdmmgggg);
		
		textField_10 = new JTextField();
		textField_10.setCaretColor(Color.WHITE);
		textField_10.setBorder(null);
		textField_10.setForeground(Color.WHITE);
		textField_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBackground(new Color(32, 30, 45));
		textField_10.setBounds(602, 542, 311, 24);
		contentPane.add(textField_10);
		
		JComboBox<GrupaAnalize> comboBox = new JComboBox<GrupaAnalize>();
		comboBox.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		comboBox.setBounds(602, 68, 311, 24);
		contentPane.add(comboBox);
		
		EnumeracijeController.punjenjeComboBoxaObjekat(comboBox, EnumeracijeController.dobavljanjeSpecijalizacija());
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(109, 213, 170));
		separator.setForeground(new Color(109, 213, 170));
		separator.setBounds(602, 152, 311, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setBounds(602, 211, 311, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setBounds(602, 270, 311, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(109, 213, 170));
		separator_3.setBackground(new Color(109, 213, 170));
		separator_3.setBounds(602, 330, 311, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(109, 213, 170));
		separator_4.setBackground(new Color(109, 213, 170));
		separator_4.setBounds(602, 389, 311, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(109, 213, 170));
		separator_5.setBackground(new Color(109, 213, 170));
		separator_5.setBounds(602, 448, 311, 2);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(new Color(109, 213, 170));
		separator_6.setBackground(new Color(109, 213, 170));
		separator_6.setBounds(602, 507, 311, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(new Color(109, 213, 170));
		separator_7.setBackground(new Color(109, 213, 170));
		separator_7.setBounds(602, 568, 311, 2);
		contentPane.add(separator_7);
		
		@SuppressWarnings("unused")
		JTextField textField_9 = new JTextField();
		
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
				
				String imeAnalize = textField_2.getText();
				String jedinicaMere = textField_3.getText();
				String cena = textField_4.getText();
				String referentnaVrednostOdMuski = textField_5.getText();
				String referentnaVrednostDoMuski = textField_6.getText();
				String referentnaVrednostOdZenski = textField_8.getText();
				String referentnaVrednostDoZenski = txtDdmmgggg.getText();
				String popust = textField_10.getText();
				
				proveraPraznogUnosa(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, referentnaVrednostDoZenski, popust);
				
			}

			private void proveraUnosaSpejsa(String imeAnalize, String jedinicaMere, String cena, String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				if (imeAnalize.contains(" ") || jedinicaMere.contains(" ") || cena.contains(" ") || referentnaVrednostOdMuski.contains(" ") ||
						referentnaVrednostDoMuski.contains(" ") || referentnaVrednostOdZenski.contains(" ") || referentnaVrednostDoZenski.contains(" ")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaCene(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
				
			}

			private void proveraUnosaCene(String imeAnalize, String jedinicaMere, String cena, String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!cena.matches("([0-9]*)\\.([0-9]*)") && !cena.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za cenu!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaReferentneVrednostiOdMuski(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
			}

			private void proveraUnosaReferentneVrednostiOdMuski(String imeAnalize, String jedinicaMere, String cena,
					String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!referentnaVrednostOdMuski.matches("([0-9]*)\\.([0-9]*)") && !referentnaVrednostOdMuski.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za referentnu vrednost od (muski)!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaReferentneVrednostiDoMuski(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
				
			}

			private void proveraUnosaReferentneVrednostiDoMuski(String imeAnalize, String jedinicaMere, String cena,
					String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!referentnaVrednostDoMuski.matches("([0-9]*)\\.([0-9]*)") && !referentnaVrednostDoMuski.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za referentnu vrednost do (muski)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaReferentneVrednostiOdZenski(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
				
			}

			private void proveraUnosaReferentneVrednostiOdZenski(String imeAnalize, String jedinicaMere, String cena,
					String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!referentnaVrednostOdZenski.matches("([0-9]*)\\.([0-9]*)") && !referentnaVrednostOdZenski.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za referentnu vrednost od (zenski)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaReferentneVrednostiDoZenski(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
				
			}

			private void proveraUnosaReferentneVrednostiDoZenski(String imeAnalize, String jedinicaMere, String cena,
					String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!referentnaVrednostDoMuski.matches("([0-9]*)\\.([0-9]*)") && !referentnaVrednostDoMuski.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za referentnu vrednost do (zenski)", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					proveraUnosaPopusta(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, 
							referentnaVrednostDoZenski, popust);
				}
				
			}

			private void proveraUnosaPopusta(String imeAnalize, String jedinicaMere, String cena,
					String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (!popust.matches("^\\d+$")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Unesite ceo pozitivan broj za popust!", "Greska", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					JOptionPane.showMessageDialog(new JFrame(), "Uspesno dodavanje analize!");
					setVisible(false);
					AnalizaController.dodavanjeNoveAnalize(comboBox.getSelectedItem(), imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, 
							referentnaVrednostOdZenski, referentnaVrednostDoZenski, popust);
					PocetniMeniAdministrator pocetniMeniAdministrator = new PocetniMeniAdministrator(korisnickoImeUlogovanogKorisnika);
					pocetniMeniAdministrator.setVisible(true);
				}
			}

			private void proveraPraznogUnosa(String imeAnalize, String jedinicaMere, String cena, String referentnaVrednostOdMuski, String referentnaVrednostDoMuski,
					String referentnaVrednostOdZenski, String referentnaVrednostDoZenski, String popust) {
				
				if (imeAnalize.equals("") || jedinicaMere.equals("") || cena.equals("") || referentnaVrednostOdMuski.equals("") || referentnaVrednostDoMuski.equals("") || 
						referentnaVrednostOdZenski.equals("") || referentnaVrednostDoZenski.equals("") || popust.equals("")) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else {
					
					proveraUnosaSpejsa(imeAnalize, jedinicaMere, cena, referentnaVrednostOdMuski, referentnaVrednostDoMuski, referentnaVrednostOdZenski, referentnaVrednostDoZenski, popust);
				}
			}
		});
	}
}
