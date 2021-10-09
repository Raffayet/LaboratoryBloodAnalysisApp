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
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IzborZaposlenogZaRegistraciju extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3068850790588777455L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzborZaposlenogZaRegistraciju(String korisnickoImeUlogovanogKorisnika) {
		setTitle("Izbor zaposlenog");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 531, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnNewButton = new JButton("Medicinski tehnicar");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(32, 30, 45));
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				RegistracijaMedicinskogTehnicara registracijaMedicinskogTehnicara = new RegistracijaMedicinskogTehnicara(korisnickoImeUlogovanogKorisnika);
				registracijaMedicinskogTehnicara.setVisible(true);
			}
		});
		btnNewButton.setBounds(0, 0, 259, 141);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Laborant");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				RegistracijaLaboranta registracijaLaboranta = new RegistracijaLaboranta(korisnickoImeUlogovanogKorisnika);
				registracijaLaboranta.setVisible(true);
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(32, 30, 45));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		btnNewButton_1.setBounds(256, 0, 259, 141);
		contentPane.add(btnNewButton_1);
		
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
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(35, 19, 76));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(11, 7, 17));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnNewButton.setBackground(new Color(35, 19, 76));
			}
		});
	}
}
