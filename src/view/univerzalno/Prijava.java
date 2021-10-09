package view.univerzalno;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.ColorUIResource;

import controller.KorisniciController;
import model.Administrator;
import model.Korisnik;
import model.Laborant;
import model.MedicinskiTehnicar;
import model.Pacijent;
import view.administrator.PocetniMeniAdministrator;
import view.laborant.PocetniMeniLaborant;
import view.medicinski_tehnicar.PocetniMeniMedicinskiTehnicar;
import view.pacijent.PocetniMeniPacijent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Prijava {

	public JFrame frmPrijavaNaSistem;
	private JTextField txtGasg;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prijava window = new Prijava();
					window.frmPrijavaNaSistem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prijava() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("static-access")
	private void initialize() {
		frmPrijavaNaSistem = new JFrame();
		frmPrijavaNaSistem.getContentPane().setBackground(new Color(32, 30, 45));
		frmPrijavaNaSistem.setFont(new Font("Dialog", Font.BOLD, 14));
		frmPrijavaNaSistem.setTitle("Prijava na sistem");
		frmPrijavaNaSistem.getContentPane().setFont(new Font("Algerian", Font.BOLD, 14));
		frmPrijavaNaSistem.setBounds(100, 100, 812, 483);
		frmPrijavaNaSistem.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmPrijavaNaSistem.getContentPane().setLayout(null);

		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new ColorUIResource(11, 7, 17));
		UI.put("OptionPane.messageForeground", Color.white);
		UI.put("Panel.background", new ColorUIResource(11, 7, 17));
		UI.put("Panel.foreground", Color.WHITE);
		
		frmPrijavaNaSistem.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				frmPrijavaNaSistem = new JFrame("Izlaz");
				
				Object[] opcije = {"Da", "Ne"};
				
				if (JOptionPane.showOptionDialog(new JFrame(), "Da li ste sigurni da zelite da izadjete?", "Izlaz", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
						opcije, opcije[0]) == JOptionPane.YES_NO_OPTION) {
					
					System.exit(0);
				}	
			}
		});

		JLabel lblNewLabel = new JLabel("KORISNICKO IME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel.setBounds(501, 43, 185, 33);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("LOZINKA");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_1.setBounds(501, 190, 151, 33);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel_1);

		txtGasg = new JTextField();
		txtGasg.setCaretColor(Color.WHITE);
		txtGasg.setDisabledTextColor(Color.WHITE);
		txtGasg.setForeground(Color.WHITE);
		txtGasg.setBorder(null);
		txtGasg.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 19));
		txtGasg.setBackground(new Color(32, 30, 45));
		txtGasg.setBounds(448, 87, 306, 41);
		frmPrijavaNaSistem.getContentPane().add(txtGasg);
		txtGasg.setColumns(10);

		JButton btnNewButton = new JButton("Prijava");

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

		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.DARK_GRAY));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(179, 14, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String korisnickoIme = txtGasg.getText();
				@SuppressWarnings("deprecation")
				String lozinka = passwordField.getText();

				boolean prijava = false;

				for(Korisnik korisnik : KorisniciController.korisnici) {

					if(korisnickoIme.equals(korisnik.getKorisnickoIme()) && lozinka.equals(korisnik.getLozinka())) {

						frmPrijavaNaSistem.setVisible(false);
						prijava = true;

						if (korisnik instanceof Administrator) {

							PocetniMeniAdministrator pocetniMeniAdministrator = new PocetniMeniAdministrator(korisnickoIme);
							pocetniMeniAdministrator.setVisible(true);
						}

						if (korisnik instanceof MedicinskiTehnicar) {

							PocetniMeniMedicinskiTehnicar pocetniMeniMedicinskiTehnicar = new PocetniMeniMedicinskiTehnicar(korisnickoIme);
							pocetniMeniMedicinskiTehnicar.setVisible(true);	
						}

						if (korisnik instanceof Laborant) {

							PocetniMeniLaborant pocetniMeniLaborant = new PocetniMeniLaborant(korisnickoIme);
							pocetniMeniLaborant.setVisible(true);
						}

						if (korisnik instanceof Pacijent) {

							PocetniMeniPacijent pocetniMeniPacijent = new PocetniMeniPacijent(korisnickoIme);
							pocetniMeniPacijent.setVisible(true);
						}

					}				
				}	

				if (prijava == false) {

					JOptionPane.showMessageDialog(frmPrijavaNaSistem, "Pogresno korisnicko ime ili lozinka. Pokusajte ponovo.", "Greska", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton.setBounds(448, 321, 134, 50);
		frmPrijavaNaSistem.getContentPane().add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		separator.setBounds(448, 278, 306, 2);
		frmPrijavaNaSistem.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(448, 131, 306, 2);
		frmPrijavaNaSistem.getContentPane().add(separator_1);

		JButton btnNewButton_2 = new JButton("Reset");

		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnNewButton_2.setBackground(new Color(14, 122, 68));
			}
			@Override
			public void mouseExited(MouseEvent e) {

				btnNewButton_2.setBackground(new Color(25, 91, 70));
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				btnNewButton_2.setBackground(new Color(14, 122, 68));
			}
		});

		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(25, 91, 70));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGasg.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton_2.setBounds(620, 321, 134, 50);
		frmPrijavaNaSistem.getContentPane().add(btnNewButton_2);

		passwordField = new JPasswordField();
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setDisabledTextColor(Color.WHITE);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 19));
		passwordField.setBackground(new Color(32, 30, 45));
		
		passwordField.setBounds(448, 234, 306, 41);
		frmPrijavaNaSistem.getContentPane().add(passwordField);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 0, 401, 444);
		frmPrijavaNaSistem.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Prijava.class.getResource("/slike/unnamed.jpg")));
		lblNewLabel_2.setBounds(0, -1, 401, 281);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setIcon(new ImageIcon(Prijava.class.getResource("/slike/drawing126345.png")));
		lblNewLabel_3.setBounds(36, 300, 160, 201);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Prijava.class.getResource("/slike/twf-def-cl-06i6rdi.png")));
		lblNewLabel_4.setBounds(206, 302, 149, 86);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("Radno vreme: 05:00 - 23:00 (PON - NED)");
		lblNewLabel_9.setBounds(36, 419, 327, 14);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(153, 51, 51));
		lblNewLabel_9.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Prijava.class.getResource("/slike/a25f4f58938bbe61357ebca42d23866fgdf.png")));
		lblNewLabel_5.setBounds(759, 410, 27, 23);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Pratite nas na");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(666, 413, 88, 14);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(Prijava.class.getResource("/slike/avatar (1)dddddd.png")));
		lblNewLabel_7.setBounds(448, 32, 43, 59);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(Prijava.class.getResource("/slike/Authorisation_lock_pahgdsdlock_password_privacy_sddafe_security3124-512 (1).png")));
		lblNewLabel_8.setBounds(447, 183, 43, 50);
		frmPrijavaNaSistem.getContentPane().add(lblNewLabel_8);
	}
}
