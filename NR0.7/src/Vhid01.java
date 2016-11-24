import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Vhid01 extends JFrame {

	private static JTextField t_login;
	private static JPasswordField t_parol;
	private static JTextField t_capcha;

	JButton b_avtoruzacia = new JButton("Авторизація");
	JButton b_reestracia = new JButton("Реєстрація");
	JButton b_peredumav = new JButton("Передумав?");
	JButton b_vhid = new JButton();
	JLabel l_login = new JLabel("Логін:");
	JLabel l_parol = new JLabel("Пароль:");
	JLabel l_mail = new JLabel("Mail:");
	JButton b_ocustu = new JButton("Очистити");
	JLabel l_perevirka = new JLabel("Перевірка:");
	JLabel l_capcha1 = new JLabel("+");
	JLabel l_capcha2 = new JLabel("=");
	JButton b_zberegtu = new JButton("");
	JLabel l_capcha = new JLabel(
			"\u0412\u0432\u0435\u0434\u0456\u0442\u044C \u0441\u0443\u043C\u0443 \u0446\u0438\u0444\u0440:");

	int Random1 = (int) (100 * Math.random());
	int Random2 = (int) (100 * Math.random());
	int sumaRandom;
	String s_Random1 = "" + Random1;
	String s_Random2 = "" + Random2;
	private JLabel lblRandom;
	private JLabel lblRandom_1;

	int type1 = JOptionPane.ERROR_MESSAGE;
	int type2 = JOptionPane.WARNING_MESSAGE;

	String a, b, c;
	int z1, z2, z3;
	int a1 = (-1);

	String f = "res/f_vhid.png";
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	public Vhid01() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		lblRandom = new JLabel(s_Random1);
		lblRandom_1 = new JLabel(s_Random2);
		getContentPane().setLayout(null);

		b_avtoruzacia.addActionListener(e -> {
			b_reestracia.setBounds(0, 0, 0, 0);
			l_login.setBounds(68, 120, 154, 35);
			b_peredumav.setBounds(154, 75, 191, 23);
			b_vhid.setBounds(284, 149, 173, 154);
			t_login.setBounds(51, 166, 154, 28);
			l_parol.setBounds(61, 209, 154, 26);
			t_parol.setBounds(51, 244, 154, 28);
			b_ocustu.setBounds(116, 303, 89, 23);

		});
		b_avtoruzacia.setBounds(10, 11, 233, 53);
		getContentPane().add(b_avtoruzacia);

		b_reestracia.setBounds(253, 11, 233, 53);

		b_reestracia.addActionListener(e -> {
			b_avtoruzacia.setBounds(0, 0, 0, 0);
			l_login.setBounds(68, 120, 154, 35);
			b_peredumav.setBounds(154, 75, 191, 23);

			t_login.setBounds(51, 166, 154, 28);
			l_parol.setBounds(0, 0, 0, 0);
			l_mail.setBounds(61, 209, 154, 26);
			t_parol.setBounds(51, 244, 154, 28);
			l_perevirka.setBounds(61, 283, 154, 26);
			b_ocustu.setBounds(355, 330, 89, 23);

			t_capcha.setBounds(249, 327, 64, 28);
			l_capcha.setBounds(14, 334, 121, 14);
			l_capcha1.setBounds(172, 334, 17, 14);
			l_capcha2.setBounds(226, 334, 17, 14);
			b_zberegtu.setBounds(284, 149, 173, 154);
			lblRandom.setBounds(145, 334, 17, 14);
			lblRandom_1.setBounds(198, 334, 17, 14);

		});
		getContentPane().add(b_reestracia);

		getContentPane().add(b_peredumav);

		b_peredumav.addActionListener(e -> {
			b_avtoruzacia.setBounds(10, 11, 233, 53);
			b_reestracia.setBounds(253, 11, 233, 53);
			l_login.setBounds(0, 0, 0, 0);
			b_peredumav.setBounds(0, 0, 0, 0);

			t_login.setBounds(0, 0, 0, 0);
			l_parol.setBounds(0, 0, 0, 0);
			l_mail.setBounds(0, 0, 0, 0);
			t_parol.setBounds(0, 0, 0, 0);
			l_perevirka.setBounds(0, 0, 0, 0);
			b_ocustu.setBounds(0, 0, 0, 0);

			t_capcha.setBounds(0, 0, 0, 0);
			l_capcha.setBounds(0, 0, 0, 0);
			l_capcha1.setBounds(0, 0, 0, 0);
			l_capcha2.setBounds(0, 0, 0, 0);
			b_zberegtu.setBounds(0, 0, 0, 0);
			lblRandom.setBounds(0, 0, 0, 0);
			lblRandom_1.setBounds(0, 0, 0, 0);
			b_vhid.setBounds(0, 0, 0, 0);

			t_parol.setText("");
			t_login.setText("");
			t_capcha.setText("");

		});

		b_vhid.setIcon(new ImageIcon("C:\\Users\\Zakk\\workspace\\NR0.7\\res\\vh\u0456d.png"));
		b_vhid.addActionListener(e -> {
			a = t_login.getText();
			b = t_parol.getText();

			switch (a) {
			case "1":
				z1 = 1;
			}
			switch (b) {
			case "1":
				z2 = 1;
			}

			if (z1 == 1 && z2 == 1) {
				Thread audio_Nravitsa = new Thread(new Audio_Nravitsa());
				// audio_Nravitsa.start();

				JOptionPane.showMessageDialog(null, "Авторизація пройшла успішно, доступ отримано", null, type2);
				new Menu("");
				setVisible(false);

			} else {
				Thread audio1 = new Thread(new Audio_No());
				// audio1.start();
				JOptionPane.showMessageDialog(null, "Дані не введено, або введено помилково", null, type1);
			}

			z1 = 0;
			z2 = 0;
		});

		getContentPane().add(b_vhid);

		t_login = new JTextField();
		t_login.setText("1");
		getContentPane().add(t_login);
		t_login.setColumns(10);
		l_login.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		l_login.setForeground(Color.CYAN);
		getContentPane().add(l_login);

		l_parol.setForeground(Color.CYAN);
		l_parol.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));

		l_mail.setForeground(Color.CYAN);
		l_mail.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));

		getContentPane().add(l_parol);
		getContentPane().add(l_mail);

		t_parol = new JPasswordField();

		t_parol.setText("1");
		t_parol.setColumns(10);

		getContentPane().add(t_parol);

		b_ocustu.addActionListener(e -> {
			t_parol.setText("");
			t_login.setText("");
			t_capcha.setText("");
		});
		getContentPane().add(b_ocustu);

		l_perevirka.setForeground(Color.CYAN);
		l_perevirka.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));

		getContentPane().add(l_perevirka);

		t_capcha = new JTextField();
		t_capcha.setText("");

		t_capcha.setColumns(10);

		getContentPane().add(t_capcha);
		l_capcha.setForeground(Color.red);
		getContentPane().add(l_capcha);
		l_capcha1.setForeground(Color.red);
		getContentPane().add(l_capcha1);

		getContentPane().add(l_capcha2);
		b_zberegtu.setIcon(new ImageIcon("C:\\Users\\Zakk\\workspace\\NR0.7\\res\\zberegtu.png"));

		b_zberegtu.addActionListener(e -> {
			a = t_login.getText();
			b = t_parol.getText();
			c = t_capcha.getText();

			sumaRandom = Random1 + Random2;
			String s_sumaRandom = "" + sumaRandom;
			int k = 0;

			switch (a) {
			case "Name":
				JOptionPane.showMessageDialog(null, "Змініть ім’я");
				break;
			case "Login":
				JOptionPane.showMessageDialog(null, "Змініть ім’я");
				break;
			case "login":
				JOptionPane.showMessageDialog(null, "Змініть ім’я");
				break;
			case "":
				JOptionPane.showMessageDialog(null, "Введіть ім’я");
				break;
			case " ":
				JOptionPane.showMessageDialog(null, "Змініть ім’я");
				break;
			case "  ":
				JOptionPane.showMessageDialog(null, "Змініть ім’я");
				break;
			default:
				k++;
				break;
			}

			switch (b) {
			case "Password":
				JOptionPane.showMessageDialog(null, "Змініть пароль");
				break;
			case "password":
				JOptionPane.showMessageDialog(null, "Змініть пароль");
				break;
			case "":
				JOptionPane.showMessageDialog(null, "Введіть пароль");
				break;
			case " ":
				JOptionPane.showMessageDialog(null, "Змініть пароль");
				break;
			case "  ":
				JOptionPane.showMessageDialog(null, "Змініть пароль");
				break;
			default:
				k++;
				break;
			}

			try {
				a1 = Integer.parseInt(c);
			} catch (Exception ex) {
			}

			if (a1 == sumaRandom) {
				k++;
			} else {
				JOptionPane.showMessageDialog(null, "Помилка вводу коду, або код не введено");
			}

			if (k >= 3) {
				k++;
				JOptionPane.showMessageDialog(null, "Заявку подано. Чекайте повідомлення на пошту.");

				b_avtoruzacia.setBounds(10, 11, 233, 53);
				b_reestracia.setBounds(253, 11, 233, 53);
				l_login.setBounds(0, 0, 0, 0);
				b_peredumav.setBounds(0, 0, 0, 0);

				t_login.setBounds(0, 0, 0, 0);
				l_parol.setBounds(0, 0, 0, 0);
				l_mail.setBounds(0, 0, 0, 0);
				t_parol.setBounds(0, 0, 0, 0);
				l_perevirka.setBounds(0, 0, 0, 0);
				b_ocustu.setBounds(0, 0, 0, 0);

				t_capcha.setBounds(0, 0, 0, 0);
				l_capcha.setBounds(0, 0, 0, 0);
				l_capcha1.setBounds(0, 0, 0, 0);
				l_capcha2.setBounds(0, 0, 0, 0);
				b_zberegtu.setBounds(0, 0, 0, 0);
				lblRandom.setBounds(0, 0, 0, 0);
				lblRandom_1.setBounds(0, 0, 0, 0);
				b_vhid.setBounds(0, 0, 0, 0);

				t_login.setText("");
				t_parol.setText("");
				t_capcha.setText("");

				Random1 = (int) (100 * Math.random());
				Random2 = (int) (100 * Math.random());
				s_Random1 = "" + Random1;
				s_Random2 = "" + Random2;
				lblRandom = new JLabel(s_Random1);
				lblRandom_1 = new JLabel(s_Random2);

				lblRandom.setForeground(Color.red);
				getContentPane().add(lblRandom);
				lblRandom_1.setForeground(Color.red);
				getContentPane().add(lblRandom_1);
				l_logo.setBounds(0, 0, 500, 400);
				add(l_logo);			}
		});

		getContentPane().add(b_zberegtu);
		lblRandom.setForeground(Color.red);
		getContentPane().add(lblRandom);
		lblRandom_1.setForeground(Color.red);
		getContentPane().add(lblRandom_1);

		l_logo.setBounds(0, 0, 500, 400);
		add(l_logo);

		setVisible(true);
	}
}
