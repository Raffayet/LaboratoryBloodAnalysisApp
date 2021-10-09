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
import javax.swing.JSeparator;

public class AzuriranjeCeneAnaliza extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2341354623019136469L;
	private JPanel contentPane;
	private JTextField textField;
	String selektovanaAnaliza;
	String prikazanaAnaliza;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public AzuriranjeCeneAnaliza(String korisnickoImeUlogovanogKorisnika) {
		setTitle("Azuriranje cene analiza");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 712, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 30, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(11, 7, 17));
		panel.setBounds(0, 282, 696, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Potvrda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String novaCena = textField.getText();
				proveraUnosaNoveCene(novaCena, selektovanaAnaliza);
				
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(109, 213, 170));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 22));
		btnNewButton.setBounds(245, 11, 197, 47);
		panel.add(btnNewButton);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(213, 214, 217));
		comboBox.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
		
		EnumeracijeController.punjenjeComboBoxa(comboBox, AnalizaController.dobavljanjeImenaAnaliza());
		
		AnalizaController.ucitavanje(AnalizaController.putanja);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selektovanaAnaliza = String.valueOf(comboBox.getSelectedItem());
				textField.setText(AnalizaController.vracanjeCeneNaOsnovuImenaAnalize(selektovanaAnaliza));
			}
		});
		comboBox.setBounds(23, 126, 332, 48);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("ANALIZA");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
		lblNewLabel.setBounds(134, 78, 113, 37);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setCaretColor(Color.WHITE);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(32, 30 ,45));
		textField.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
		textField.setBounds(434, 126, 232, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField.setText(String.valueOf(Math.round(AnalizaController.analize.get(0).getCena())));
		
		JLabel lblNovaCena = new JLabel("NOVA CENA (RSD)");
		lblNovaCena.setForeground(Color.WHITE);
		lblNovaCena.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 26));
		lblNovaCena.setBounds(434, 78, 232, 37);
		contentPane.add(lblNovaCena);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(109, 213, 170));
		separator.setBackground(new Color(109, 213, 170));
		separator.setBounds(434, 177, 232, 2);
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
	
	private static void proveraUnosaNoveCene(String novaCena, String selektovanaAnaliza) {
		
		if (!novaCena.matches("^\\d+$")) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Unesite ceo pozitivan broj za cenu!", "Greska", JOptionPane.ERROR_MESSAGE);
		}
		
		else {
			
			JOptionPane.showMessageDialog(new JFrame(), "Sacuvano!");
			AnalizaController.azuriranjeCeneAnaliza(selektovanaAnaliza, novaCena);
		}
	}
}
