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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import controller.MusterijaController;
import model.Zaposleni;

public class RacunanjeMesecnePlate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 68906011178523062L;
	private JPanel contentPane;
	static JTextField textField;
	static JTextField textField_1;
	static JTextField textField_2;
	static JTextField textField_3;
	static JButton btnNewButton;
	static JLabel lblMesecnaPlata;
	static String osnova;
	static String koeficijent;
	static String bonus;
	static String staz;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RacunanjeMesecnePlate(String korisnickoImeUlogovanogKorisnika, String korisnickoImeZaposlenog) {
		setTitle("Racunanje mesecne plate");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 862, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 30, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		KorisniciController.ucitavanje(KorisniciController.putanja);
		MusterijaController.ucitavanje(MusterijaController.putanja);

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				e.getWindow().dispose();
				IzborZaposlenogZaRacunanjePlate izborZaposlenogZaRacunanjePlate = new IzborZaposlenogZaRacunanjePlate(korisnickoImeUlogovanogKorisnika);
				izborZaposlenogZaRacunanjePlate.setVisible(true);
				
				if (osnova != null && koeficijent != null && bonus != null && staz != null) {
					
					osnova = osnova + "!";
					koeficijent = koeficijent + "!";
					bonus = bonus + "!";
					staz = staz + "!";
					KorisniciController.menjanjeAtributaZaposlenog(korisnickoImeZaposlenog, osnova,
							koeficijent, bonus, staz);
			}
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 344, 846, 95);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(32, 30, 45));
		textField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		textField.setBounds(31, 160, 147, 43);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Sacuvajte");

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
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 24));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				osnova = textField.getText();
				koeficijent = textField_1.getText();
				bonus = textField_2.getText();
				staz = textField_3.getText();

				proveraPraznogUnosa(osnova, koeficijent, bonus, staz);

			}
		});
		btnNewButton.setBounds(299, 23, 265, 49);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("OSNOVA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblNewLabel.setBounds(55, 106, 101, 43);
		contentPane.add(lblNewLabel);

		JLabel lblPodaciZa = new JLabel("RACUNANJE PLATE ZA ZAPOSLENOG:     " + korisnickoImeZaposlenog);
		lblPodaciZa.setForeground(Color.WHITE);
		lblPodaciZa.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 26));
		lblPodaciZa.setBounds(39, 11, 774, 43);
		contentPane.add(lblPodaciZa);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 65, 826, 2);
		contentPane.add(separator);

		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setCaretColor(Color.WHITE);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(32, 30, 45));
		textField_1.setBounds(247, 160, 147, 43);
		contentPane.add(textField_1);

		JLabel lblOsnova = new JLabel("KOEFICIJENT");
		lblOsnova.setForeground(Color.WHITE);
		lblOsnova.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblOsnova.setBounds(247, 106, 147, 43);
		contentPane.add(lblOsnova);

		textField_2 = new JTextField();
		textField_2.setCaretColor(Color.WHITE);
		textField_2.setBorder(null);
		textField_2.setForeground(Color.WHITE);
		textField_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBackground(new Color(32, 30, 45));
		textField_2.setBounds(458, 160, 147, 43);
		contentPane.add(textField_2);

		JLabel lblStaz = new JLabel("BONUS");
		lblStaz.setForeground(Color.WHITE);
		lblStaz.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblStaz.setBounds(489, 106, 86, 43);
		contentPane.add(lblStaz);

		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setCaretColor(Color.WHITE);
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBackground(new Color(32, 30, 45));
		textField_3.setBounds(666, 160, 147, 43);
		contentPane.add(textField_3);

		JLabel lblBonus = new JLabel("STAZ");
		lblBonus.setForeground(Color.WHITE);
		lblBonus.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblBonus.setBounds(710, 106, 61, 43);
		contentPane.add(lblBonus);

		lblMesecnaPlata = new JLabel("MESECNA PLATA:       ");
		lblMesecnaPlata.setForeground(Color.WHITE);
		lblMesecnaPlata.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 26));
		lblMesecnaPlata.setBounds(230, 269, 508, 43);
		contentPane.add(lblMesecnaPlata);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(109, 213, 170));
		separator_1.setForeground(new Color(109, 213, 170));
		separator_1.setBounds(31, 205, 147, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(109, 213, 170));
		separator_2.setBackground(new Color(109, 213, 170));
		separator_2.setBounds(247, 205, 147, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(new Color(109, 213, 170));
		separator_3.setBackground(new Color(109, 213, 170));
		separator_3.setBounds(458, 205, 147, 2);
		contentPane.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(new Color(109, 213, 170));
		separator_4.setBackground(new Color(109, 213, 170));
		separator_4.setBounds(666, 205, 147, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(109, 213, 170));
		separator_1_1.setBackground(new Color(109, 213, 170));
		separator_1_1.setBounds(503, 315, 235, 2);
		contentPane.add(separator_1_1);
		
		punjenjeTekstPolja(korisnickoImeZaposlenog);
	}

	private static void punjenjeTekstPolja(String korisnickoImeZaposlenog) {

		Zaposleni zaposleni = KorisniciController.vracanjeZaposlenogNaOsnovuKorisnickogImena(korisnickoImeZaposlenog);

		textField.setText(String.valueOf(zaposleni.getOsnova()));
		textField_1.setText(String.valueOf(zaposleni.getKoeficijent()));
		textField_2.setText(String.valueOf(zaposleni.getBonus()));
		textField_3.setText(String.valueOf(zaposleni.getStaz()));
	}

	private void proveraPraznogUnosa(String osnova, String koeficijent, String bonus, String staz) {

		if (osnova.equals("") || koeficijent.equals("") || bonus.equals("") || staz.equals("")) {

			JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);

		}

		else {

			proveraUnosaSpejsa(osnova, koeficijent, bonus, staz);
		}
	}
	
	private void proveraUnosaSpejsa(String osnova, String koeficijent, String bonus, String staz) {
		if (osnova.contains(" ") || koeficijent.contains(" ") || bonus.contains(" ") || staz.contains(" ")) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Ne smete koristiti spejs u poljima!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			proveraUnosaOsnove(osnova, koeficijent, bonus, staz);
		}
		
	}
	
	private void proveraUnosaOsnove(String osnova, String koeficijent, String bonus, String staz) {
		
		if (!osnova.matches("([0-9]*)\\.([0-9]*)") && !osnova.matches("^\\d+$") || (!osnova.contains("0") && !osnova.contains("1") && !osnova.contains("2") && !osnova.contains("3") &&
				!osnova.contains("4") && !osnova.contains("5") && !osnova.contains("6") && !osnova.contains("7") && !osnova.contains("8") && !osnova.contains("9"))) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za osnovu!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			proveraUnosaKoeficijenta(osnova, koeficijent, bonus, staz);
		}
	}
	
	private void proveraUnosaKoeficijenta(String osnova, String koeficijent, String bonus, String staz) {
		
		if (!koeficijent.matches("([0-9]*)\\.([0-9]*)") && !koeficijent.matches("^\\d+$") || (!koeficijent.contains("0") && !koeficijent.contains("1") && !koeficijent.contains("2") && 
				!koeficijent.contains("3") && !koeficijent.contains("4") && !koeficijent.contains("5") && !koeficijent.contains("6") && !koeficijent.contains("7") && !koeficijent.contains("8") 
				&& !koeficijent.contains("9"))) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za koeficijent!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
		
		proveraUnosaBonusa(osnova, koeficijent, bonus, staz);
	}
	}
	
	private void proveraUnosaStaza(String osnova, String koeficijent, String bonus, String staz) {
		
		if (!staz.matches("^\\d+$")) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Unesite ceo pozitivan broj za staz!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			lblMesecnaPlata.setText("MESECNA PLATA:         " + KorisniciController.vracanjePlate(osnova, koeficijent, bonus, staz));
		}
	}

	private void proveraUnosaBonusa(String osnova, String koeficijent, String bonus, String staz) {
		
		if (!bonus.matches("([0-9]*)\\.([0-9]*)") && !bonus.matches("^\\d+$") || (!bonus.contains("0") && !bonus.contains("1") &&  !bonus.contains("2") && !bonus.contains("3") && !bonus.contains("4") 
				&& !bonus.contains("5") && !bonus.contains("6") && !bonus.contains("7") && !bonus.contains("8") && !bonus.contains("9"))) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Unesite pozitivan broj za bonus!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			proveraUnosaStaza(osnova, koeficijent, bonus, staz);
		}
		
	}
}
