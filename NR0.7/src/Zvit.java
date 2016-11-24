import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Zvit extends JFrame {

	JFrame zvit = new JFrame("Тайм-менеджмент 0.5 Звіт");

	JButton Menu;
	JLabel l_vsi;
	JLabel l_otocyyci;
	JLabel Pusto;

	int type1 = JOptionPane.ERROR_MESSAGE; // Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ
	int type2 = JOptionPane.WARNING_MESSAGE;

	String[][] Reading = new String[1][9];
	String[][] Reading_otocenna = new String[1][9];
	String Reading1 = "Кількість усіх подій: ";
	String Reading2 = "";
	
	String Reading_otocenna1 = "Кількість оточення: ";
	String Reading_otocenna2 = "";

	eHandler handler = new eHandler();

	Scanner vsi , otocyyci;
	String de_vsi = "dani/кількість всіх подій.txt";
	String de_otocyyci = "dani/кількість оточення.txt";

	public Zvit(String s) {
		super(s);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		Menu = new JButton("Меню");
		Menu.setBounds(365, 10, 120, 20);

		Pusto = new JLabel("");
		Pusto.setBounds(0, 0, 494, 372);

		try {
			vsi = new Scanner(new File(de_vsi));
		} catch (Exception ez) {
			JOptionPane.showMessageDialog(null, "Помилка файлу");
		}

		while (vsi.hasNext()) {
			for (int row = 0; row < Reading.length; row++) {

				Reading1 = Reading1 + vsi.next();
			}
		}
		vsi.close();
		
		//
		try {
			otocyyci = new Scanner(new File(de_otocyyci));
		} catch (Exception ez) {
			JOptionPane.showMessageDialog(null, "Помилка файлу");
		}

		while (otocyyci.hasNext()) {
			for (int row = 0; row < Reading_otocenna.length; row++) {

				Reading_otocenna1 = Reading_otocenna1 + otocyyci.next();
			}
		}
		vsi.close();
		///
		
		zvit.getContentPane().setLayout(null);

		l_vsi = new JLabel(Reading1);
		l_vsi.setBounds(120, 120, 170, 20);
		
		l_otocyyci = new JLabel(Reading_otocenna1);
		l_otocyyci.setBounds(120, 170, 170, 20);

		
		add(l_otocyyci);
		add(l_vsi);
		add(Menu);
		add(Pusto);

		 

		Menu.addActionListener(handler);

		setVisible(true);
		
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Menu) {
					new Menu("");
					setVisible(false);
				}

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Помилка", null, type1);
			}
		}
	}
}

