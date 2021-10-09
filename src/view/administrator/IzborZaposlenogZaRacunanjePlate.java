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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.KorisniciController;
import controller.MusterijaController;
import javax.swing.JSeparator;

public class IzborZaposlenogZaRacunanjePlate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 68906011178523062L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzborZaposlenogZaRacunanjePlate(String korisnickoImeUlogovanogKorisnika) {
		setTitle("Izbor zaposlenog za racunanje plate");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 553, 279);
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
                PocetniMeniAdministrator pocetniMeniAdministrator = new PocetniMeniAdministrator(korisnickoImeUlogovanogKorisnika);
                pocetniMeniAdministrator.setVisible(true);
            }
        });
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 172, 537, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(32, 30, 45));
		textField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		textField.setBounds(101, 85, 349, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String unetoKorisnickoIme = textField.getText();
				proveraUnosaKorisnickogImena(unetoKorisnickoIme, korisnickoImeUlogovanogKorisnika);
			}
		});
		btnNewButton.setBounds(189, 11, 160, 46);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("KORISNICKO IME ZAPOSLENOG");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		lblNewLabel.setBounds(101, 31, 349, 43);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(109, 213, 170));
		separator.setBackground(new Color(109, 213, 170));
		separator.setBounds(101, 130, 349, 2);
		contentPane.add(separator);
	}
	
	private void proveraUnosaKorisnickogImena(String unetoKorisnickoIme, String korisnickoImeUlogovanogKorisnika) {
		
		KorisniciController.punjenjeListeKorisnickihImena();
		
		if (!KorisniciController.korisnickaImenaLaboranata.contains(unetoKorisnickoIme) && !KorisniciController.korisnickaImenaMedicinskihTehnicara.contains(unetoKorisnickoIme)){
					
			JOptionPane.showMessageDialog(new JFrame(), "Ovo korisnicko ime zaposlenog ne postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			setVisible(false);
			RacunanjeMesecnePlate racunanjeMesecnePlate = new RacunanjeMesecnePlate(korisnickoImeUlogovanogKorisnika, unetoKorisnickoIme);
			racunanjeMesecnePlate.setVisible(true);
		}
	}
}
