package view.administrator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controller.KorisniciController;

import javax.swing.JSeparator;

public class IzborVremenskogOpsegaIzvestaji extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6611511367706426799L;
	private JPanel contentPane;
	public static ArrayList<String> izabraniDaniUNedelji = new ArrayList<String>();
	public static ArrayList<DayOfWeek> izabraniDaniUNedeljiEngleski = new ArrayList<DayOfWeek>();
	static JTextPane textPane = new JTextPane();
	static JDateChooser dateChooser = new JDateChooser();
	static JDateChooser dateChooser_1 = new JDateChooser();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public IzborVremenskogOpsegaIzvestaji(String korisnickoImeUlogovanogKorisnika, String svrha) {
		setTitle("Izbor vremenskog opsega");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 734, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 30, 45));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 267, 718, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		dateChooser.getJCalendar().setForeground(Color.BLACK);
		dateChooser.getJCalendar().setBackground(Color.WHITE);
		JTextFieldDateEditor editor = new JTextFieldDateEditor();
		editor.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		dateChooser.setForeground(Color.BLACK);
		dateChooser.getCalendarButton().setForeground(Color.BLACK);
		dateChooser.setBackground(Color.WHITE);
		dateChooser.getCalendarButton().setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 11));
		dateChooser.getCalendarButton().setBorderPainted(false);
		dateChooser.getCalendarButton().setBackground(new Color(11, 7, 17));
		dateChooser.setBounds(34, 116, 178, 20);
		contentPane.add(dateChooser);
		
		dateChooser_1.getJCalendar().setForeground(Color.BLACK);
		dateChooser_1.getJCalendar().setBackground(Color.WHITE);
		dateChooser_1.getCalendarButton().setBorderPainted(false);
		dateChooser_1.getCalendarButton().setBackground(new Color(11, 7, 17));
		dateChooser_1.setBounds(278, 116, 178, 20);
		contentPane.add(dateChooser_1);
		
		
		JButton btnNewButton = new JButton("Potvrda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date prviDatum = dateChooser.getDate();
				Date drugiDatum = dateChooser_1.getDate();
				
				proveraPraznogUnosa(korisnickoImeUlogovanogKorisnika, prviDatum, drugiDatum, svrha);
				
				
			}
		});
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		btnNewButton.setBounds(243, 11, 237, 62);
		panel.add(btnNewButton);
		
		JLabel lblD = new JLabel("POCETNI DATUM");
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblD.setBounds(34, 42, 197, 43);
		contentPane.add(lblD);
		
		JLabel lblOpsegDatumado = new JLabel("KRAJNJI DATUM");
		lblOpsegDatumado.setForeground(Color.WHITE);
		lblOpsegDatumado.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblOpsegDatumado.setBounds(278, 42, 178, 43);
		contentPane.add(lblOpsegDatumado);
		
		JLabel lblDaniUNedelji = new JLabel("DANI U NEDELJI");
		lblDaniUNedelji.setForeground(Color.WHITE);
		lblDaniUNedelji.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblDaniUNedelji.setBounds(515, 42, 172, 43);
		contentPane.add(lblDaniUNedelji);
		
		JButton btnIzaberiteDane = new JButton("Izaberite dane");
		btnIzaberiteDane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IzborDanaUNedelji izborDanaUNedelji = new IzborDanaUNedelji();
				izborDanaUNedelji.setVisible(true);
			}
		});
		btnIzaberiteDane.setForeground(Color.WHITE);
		btnIzaberiteDane.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		btnIzaberiteDane.setBorder(null);
		btnIzaberiteDane.setBackground(new Color(61, 190, 225));
		btnIzaberiteDane.setBounds(515, 109, 172, 43);
		contentPane.add(btnIzaberiteDane);
		
		textPane = new JTextPane();
		textPane.setForeground(Color.WHITE);
		textPane.setEditable(false);
		textPane.setBackground(new Color(32, 30, 45));
		textPane.setFont(new Font("MS Ref20ence Sans Serif", Font.PLAIN, 16));
		textPane.setBounds(232, 197, 455, 43);
		contentPane.add(textPane);
		
		JLabel lblIzabraniDani = new JLabel("IZABRANI DANI :");
		lblIzabraniDani.setForeground(Color.WHITE);
		lblIzabraniDani.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 22));
		lblIzabraniDani.setBounds(34, 197, 178, 43);
		contentPane.add(lblIzabraniDani);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(109, 213, 170));
		separator.setBackground(new Color(109, 213, 170));
		separator.setBounds(232, 243, 455, 2);
		contentPane.add(separator);
		
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
		
		btnIzaberiteDane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnIzaberiteDane.setBackground(new Color(9, 107, 133));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnIzaberiteDane.setBackground(new Color(61, 190, 225));
			}
		});
		
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
	}
	
	private void proveraPraznogUnosa(String korisnickoImeUlogovanogKorisnika, Date prviDatum, Date drugiDatum, String svrha) {
		
		if (prviDatum == null || drugiDatum == null || izabraniDaniUNedelji.size() == 0) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Nisu sva polja popunjena! Ucinite to!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			LocalDateTime pocetniDatum = KorisniciController.konvertovanjeULocalDateTime(dateChooser.getDate());
			LocalDateTime krajnjiDatum = KorisniciController.konvertovanjeULocalDateTime(dateChooser_1.getDate());
			
			if (svrha.equals("prihodi")) {
			
			setVisible(false);
			IzvestajiPrihoda izvestajiPrihoda = new IzvestajiPrihoda(korisnickoImeUlogovanogKorisnika, pocetniDatum, krajnjiDatum);
			izvestajiPrihoda.setVisible(true);
			
			}
			
			else  if (svrha.equals("rashodi")){
				
				setVisible(false);
				IzvestajiRashoda izvestajiRashoda = new IzvestajiRashoda(korisnickoImeUlogovanogKorisnika, pocetniDatum, krajnjiDatum);
				izvestajiRashoda.setVisible(true);
			}
			
			else if (svrha.equals("zahtevi")) {
				
				setVisible(false);
				IzvestajiZahteva izvestajiZahteva = new IzvestajiZahteva(korisnickoImeUlogovanogKorisnika, pocetniDatum, krajnjiDatum);
				izvestajiZahteva.setVisible(true);
				
			}
			
			else if (svrha.equals("pacijenti")) {
				
				setVisible(false);
				IzvestajiPacijenata izvestajiPacijenata = new IzvestajiPacijenata(korisnickoImeUlogovanogKorisnika, pocetniDatum, krajnjiDatum);
				izvestajiPacijenata.setVisible(true);
			}
		}
	}
	
	static void ispisIzabranihDana() {
		
		String ispis = "";
		
		for (String izabranDan : izabraniDaniUNedelji) {
			
			ispis = ispis + izabranDan + "  ";
		}
		
		textPane.setText(ispis);
	}
}
