import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {

	JButton Anketa, Kalendar, Zvit, Podii, Planu, Rihenny, Otochenna, Prognoz, Nalahtuvanna;
	JLabel Pusto;

	JFrame menu = new JFrame("Тайм-менеджмент 0.5 Меню");

	String f = "res/f_menu.png";
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	eHandler handler = new eHandler();

	public Menu(String s) {
		super(s);

		menu.setVisible(true);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setSize(500, 400);
		menu.setResizable(false);
		menu.setLocationRelativeTo(null);

		Anketa = new JButton("Анкета");
		Kalendar = new JButton("Календар");
		Zvit = new JButton("Звіт");
		Podii = new JButton("Попередні події");
		Planu = new JButton("Майбутні події");
		Rihenny = new JButton("Прийняття рішень");
		Otochenna = new JButton("Моє оточення");
		Prognoz = new JButton("Прогнозування");
		Nalahtuvanna = new JButton("Налаштування");

		Anketa.setBounds(20, 50, 450, 40);
		Kalendar.setBounds(50, 100, 200, 40);
		Zvit.setBounds(250, 100, 200, 40);
		Podii.setBounds(50, 140, 200, 40);
		Planu.setBounds(250, 140, 200, 40);
		Rihenny.setBounds(50, 180, 200, 40);
		Otochenna.setBounds(250, 180, 200, 40);
		Prognoz.setBounds(50, 220, 200, 40);
		Nalahtuvanna.setBounds(250, 220, 200, 40);

		Pusto = new JLabel("");

		Pusto.setBounds(10, 10, 10, 10);

		l_logo.setBounds(0, 0, 500, 400);

		menu.add(Anketa);
		menu.add(Kalendar);
		menu.add(Zvit);
		menu.add(Podii);
		menu.add(Planu);
		menu.add(Rihenny);
		menu.add(Otochenna);
		menu.add(Prognoz);
		menu.add(Nalahtuvanna);

		menu.add(l_logo);

		menu.add(Pusto);

		Anketa.addActionListener(handler);
		Kalendar.addActionListener(handler);
		Zvit.addActionListener(handler);
		Podii.addActionListener(handler);
		Planu.addActionListener(handler);
		Rihenny.addActionListener(handler);
		Otochenna.addActionListener(handler);
		Prognoz.addActionListener(handler);
		Nalahtuvanna.addActionListener(handler);
	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Kalendar) {
					new Kalendar("");
					menu.setVisible(false);
				}

				if (e.getSource() == Anketa) {
					new Anketa("");
					menu.setVisible(false);
				}

				if (e.getSource() == Podii) {
					new Podii("");
					menu.setVisible(false);
				}
				if (e.getSource() == Zvit) {
					new Zvit("");
					menu.setVisible(false);
				}
				if (e.getSource() == Prognoz) {
					new Prognoz("");
					menu.setVisible(false);
				}
				if (e.getSource() == Rihenny) {
					new Rihenny("");
					menu.setVisible(false);
				}
				if (e.getSource() == Otochenna) {
					new Otochenna();
					menu.setVisible(false);
				}
				if (e.getSource() == Planu) {
					new Planu();
					menu.setVisible(false);
				}
			} catch (Exception ex) {
			}
			// JOptionPane.showMessageDialog(null, "Р’Р’РµРґС–С‚СЊ РґР°РЅС–");
		}
	}

}