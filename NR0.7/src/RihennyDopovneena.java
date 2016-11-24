import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RihennyDopovneena extends JFrame {

	JFrame rihennyDopovneena = new JFrame("Тайм-менеджмент 0.5 Доповнення до ТПР");

	JButton Menu, Nazad;

	JLabel l_Nazva1, l_Nazva2, Pusto, Nay;
	JLabel l_u1, l_u2, l_u3, l_u4, l_u5, l_u6, l_u7, l_u8, l_u9, l_u10, l_u11, l_u12, l_q1, l_q2, l_q3;

	String s_Nay = "";

	String Fayl;

	String f = "res/rihenna2.png";
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	String Re1, Re2;

	eHandler handler = new eHandler();

	public RihennyDopovneena(String s_Nazva1, String s_Nazva2, double u1, double u2, double u3, double u4, double u5,
			double u6, double u7, double u8, double u9, double u10, double u11, double u12, double q1, double q2,
			double q3) {
		super();

		rihennyDopovneena.setVisible(true);
		// anketaDopovneena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rihennyDopovneena.setSize(500, 300);
		rihennyDopovneena.setResizable(false);
		rihennyDopovneena.setLocationRelativeTo(null);

		Menu = new JButton("Меню");
		Nazad = new JButton("Назад");

		l_Nazva1 = new JLabel("" + s_Nazva1);
		l_Nazva2 = new JLabel("" + s_Nazva2);

		l_u1 = new JLabel("" + u1);
		l_u2 = new JLabel("" + u2);
		l_u3 = new JLabel("" + u3);
		l_u4 = new JLabel("" + u4);
		l_u5 = new JLabel("" + u5);
		l_u6 = new JLabel("" + u6);
		l_u7 = new JLabel("" + u7);
		l_u8 = new JLabel("" + u8);
		l_u9 = new JLabel("" + u9);
		l_u10 = new JLabel("" + u10);
		l_u11 = new JLabel("" + u11);
		l_u12 = new JLabel("" + u12);

		l_q1 = new JLabel("" + q1);
		l_q2 = new JLabel("" + q2);
		l_q3 = new JLabel("" + q3);

		Menu.setBounds(375, 10, 100, 20);
		Nazad.setBounds(275, 10, 100, 20);

		l_Nazva1.setBounds(35, 113, 60, 20);
		l_Nazva2.setBounds(35, 160, 60, 20);

		l_u1.setBounds(145, 110, 40, 20);
		l_u2.setBounds(215, 110, 40, 20);
		l_u3.setBounds(295, 110, 40, 20);
		l_u4.setBounds(365, 110, 40, 20);
		l_u5.setBounds(145, 155, 40, 20);
		l_u6.setBounds(215, 155, 40, 20);
		l_u7.setBounds(295, 155, 40, 20);
		l_u8.setBounds(365, 155, 40, 20);
		l_u9.setBounds(145, 200, 40, 20);
		l_u10.setBounds(215, 200, 40, 20);
		l_u11.setBounds(295, 200, 40, 20);
		l_u12.setBounds(365, 200, 40, 20);

		l_q1.setBounds(440, 105, 50, 20);
		l_q2.setBounds(440, 155, 50, 20);
		l_q3.setBounds(440, 205, 50, 20);

		rihennyDopovneena.add(l_Nazva1);
		rihennyDopovneena.add(l_Nazva2);

		rihennyDopovneena.add(l_u1);
		rihennyDopovneena.add(l_u2);
		rihennyDopovneena.add(l_u3);
		rihennyDopovneena.add(l_u4);
		rihennyDopovneena.add(l_u5);
		rihennyDopovneena.add(l_u6);
		rihennyDopovneena.add(l_u7);
		rihennyDopovneena.add(l_u8);
		rihennyDopovneena.add(l_u9);
		rihennyDopovneena.add(l_u10);
		rihennyDopovneena.add(l_u11);
		rihennyDopovneena.add(l_u12);

		rihennyDopovneena.add(l_q1);
		rihennyDopovneena.add(l_q2);
		rihennyDopovneena.add(l_q3);

		rihennyDopovneena.add(Menu);
		rihennyDopovneena.add(Nazad);

		
		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);
		
		
		l_logo.setBounds(0, 35, 500, 200);

		int y = 0;

		if (q1 < q2) {
			if (q2 < q3) {
				s_Nay = "Найкращою альтернативою є виконання обох подій одночасно,\n або поетапно";
				y = 10;

			} else {
				s_Nay = ("Найкращою альтернативою є відміна (перенесення) події - " + s_Nazva2);
				y = 50;
			}
		} else {
			s_Nay = ("Найкращою альтернативою є відміна (перенесення) події - " + s_Nazva1);
			y = 50;
		}

		Nay = new JLabel(s_Nay);

		Nay.setBounds(y, 235, 450, 20);

		rihennyDopovneena.add(Nay);

		rihennyDopovneena.add(l_logo);

		rihennyDopovneena.add(Pusto);
 
		Menu.addActionListener(handler);
		Nazad.addActionListener(handler);

	}

	public class eHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				if (e.getSource() == Menu) {
					 
					new Menu("");
					rihennyDopovneena.setVisible(false);
					
				}
				if (e.getSource() ==  Nazad) {
				 
					rihennyDopovneena.setVisible(false);
				}
	 
			} catch (Exception ex) {System.err.println("  WTF  " );
			}
		}
	}

}
