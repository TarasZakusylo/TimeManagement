import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.xeiam.xchart.BitmapEncoder;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.StyleManager.LegendPosition;
import com.xeiam.xchart.SwingWrapper;

  
public class Rihenny {

	JFrame rihenny = new JFrame("Тайм-менеджмент 0.5  ТРП");

	JButton Menu, Pogoda, Karta, Gotovo,Nazad;
	JButton b_tabluca, b_grafik, b_hvudko, b_anketa;
	JLabel l_Nazva1, l_Nazva2, l_Kohtovnist, l_Pruemnist, l_Dopomoga, l_Vagkist;
	JLabel l_Predstavlenna;
	JTextField t_Nazva1, t_Nazva2;
	JLabel Pusto;

	String s_Nazva1, s_Nazva2;

	String f = "res/f_rihenna.png";
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	JSlider sl_Kohtovnistl = new JSlider(0, 1, 5, 1);
	int i_Kohtovnistl = 1;
	JSlider sl_Kohtovnist2 = new JSlider(0, 1, 5, 1);
	int i_Kohtovnist2 = 1;
	JSlider sl_Pruemnist1 = new JSlider(0, 1, 5, 1);
	int i_Pruemnist1 = 1;
	JSlider sl_Pruemnist2 = new JSlider(0, 1, 5, 1);
	int i_Pruemnist2 = 1;
	JSlider sl_Vagkist1 = new JSlider(0, 1, 5, 1);
	int i_Vagkist1 = 1;
	JSlider sl_Vagkist2 = new JSlider(0, 1, 5, 1);
	int i_Vagkist2 = 1;

	double u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12;
	double q1, q2, q3;

	JLabel l_Ramka;

	eHandler handler = new eHandler();

	SliderListener1 slider1 = new SliderListener1();
	SliderListener2 slider2 = new SliderListener2();
	SliderListener3 slider3 = new SliderListener3();
	SliderListener4 slider4 = new SliderListener4();
	SliderListener5 slider5 = new SliderListener5();
	SliderListener6 slider6 = new SliderListener6();

	Desktop d = Desktop.getDesktop();

	public Rihenny(String s) {
		super();

		rihenny.setVisible(true);
		rihenny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rihenny.setSize(500, 400);
		rihenny.setResizable(false);
		rihenny.setLocationRelativeTo(null);

		Menu = new JButton("Меню");
		Pogoda = new JButton("Погода");
		Karta = new JButton("Карта");
		Gotovo = new JButton("Готово");

		b_hvudko = new JButton("Швидко");
		b_tabluca = new JButton("Таблично");
		b_grafik = new JButton("Графічно");
		Nazad = new JButton("Назад");
		b_anketa = new JButton("Бажаєте перейти до фіксування події ?");
	 

		b_hvudko.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		b_hvudko.setForeground(Color.GREEN);
		b_tabluca.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		b_tabluca.setForeground(Color.GREEN);
		b_grafik.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		b_grafik.setForeground(Color.GREEN);

		Menu.setBounds(375, 10, 100, 20);
		Pogoda.setBounds(65, 250, 130, 20);
		Karta.setBounds(300, 250, 130, 20);
		Gotovo.setBounds(375, 350, 100, 20);
		Nazad.setBounds(0,0,0,0);
		b_anketa.setBounds(0,0,0,0);

		l_Nazva1 = new JLabel("Назва 1 події:");
		l_Nazva2 = new JLabel("Назва 2 події:");
		l_Kohtovnist = new JLabel("Інтуїтивно приблизно оцініть коштовність події");
		l_Pruemnist = new JLabel("Інтуїтивно приблизно оцініть приємність події");
		l_Dopomoga = new JLabel("Для допомги визначеності ви можете використати");
		l_Vagkist = new JLabel("Інтуїтивно приблизно оцініть важкість виконання події(підготовки)");

		l_Predstavlenna = new JLabel("Оберіть вид представлення результатів");
		l_Predstavlenna.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 24));
		l_Predstavlenna.setForeground(Color.BLUE);

		l_Nazva1.setBounds(100, 30, 100, 15);
		l_Nazva2.setBounds(300, 30, 100, 15);
		l_Kohtovnist.setBounds(100, 70, 300, 15);
		l_Pruemnist.setBounds(100, 150, 300, 15);
		l_Dopomoga.setBounds(100, 230, 300, 15);
		l_Vagkist.setBounds(50, 280, 400, 15);

		t_Nazva1 = new JTextField("Назва1");
		t_Nazva2 = new JTextField("Назва2");

		t_Nazva1.setBounds(80, 50, 120, 20);
		t_Nazva2.setBounds(280, 50, 120, 20);

		sl_Kohtovnistl.setMajorTickSpacing(5);
		sl_Kohtovnistl.setMinorTickSpacing(1);
		sl_Kohtovnistl.setPaintTicks(true);
		sl_Kohtovnistl.setPaintLabels(true);
		sl_Kohtovnistl.setLabelTable(sl_Kohtovnistl.createStandardLabels(2, 1));
		sl_Kohtovnist2.setMajorTickSpacing(5);
		sl_Kohtovnist2.setMinorTickSpacing(1);
		sl_Kohtovnist2.setPaintTicks(true);
		sl_Kohtovnist2.setPaintLabels(true);
		sl_Kohtovnist2.setLabelTable(sl_Kohtovnist2.createStandardLabels(2, 1));
		sl_Pruemnist1.setMajorTickSpacing(5);
		sl_Pruemnist1.setMinorTickSpacing(1);
		sl_Pruemnist1.setPaintTicks(true);
		sl_Pruemnist1.setPaintLabels(true);
		sl_Pruemnist1.setLabelTable(sl_Pruemnist1.createStandardLabels(2, 1));
		sl_Pruemnist2.setMajorTickSpacing(5);
		sl_Pruemnist2.setMinorTickSpacing(1);
		sl_Pruemnist2.setPaintTicks(true);
		sl_Pruemnist2.setPaintLabels(true);
		sl_Pruemnist2.setLabelTable(sl_Pruemnist2.createStandardLabels(2, 1));
		sl_Vagkist1.setMajorTickSpacing(5);
		sl_Vagkist1.setMinorTickSpacing(1);
		sl_Vagkist1.setPaintTicks(true);
		sl_Vagkist1.setPaintLabels(true);
		sl_Vagkist1.setLabelTable(sl_Vagkist1.createStandardLabels(2, 1));
		sl_Vagkist2.setMajorTickSpacing(5);
		sl_Vagkist2.setMinorTickSpacing(1);
		sl_Vagkist2.setPaintTicks(true);
		sl_Vagkist2.setPaintLabels(true);
		sl_Vagkist2.setLabelTable(sl_Vagkist2.createStandardLabels(2, 1));

		sl_Kohtovnistl.setBounds(35, 100, 200, 40);
		rihenny.add(sl_Kohtovnistl);
		sl_Kohtovnist2.setBounds(270, 100, 200, 40);
		rihenny.add(sl_Kohtovnist2);
		sl_Pruemnist1.setBounds(35, 185, 200, 40);
		rihenny.add(sl_Pruemnist1);
		sl_Pruemnist2.setBounds(270, 185, 200, 40);
		rihenny.add(sl_Pruemnist2);
		sl_Vagkist1.setBounds(35, 300, 200, 40);
		rihenny.add(sl_Vagkist1);
		sl_Vagkist2.setBounds(270, 300, 200, 40);
		rihenny.add(sl_Vagkist2);

		l_Ramka = new JLabel();
		l_Ramka.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.RIGHT,
				TitledBorder.TOP, new Font("Times New Roman", Font.ITALIC, 13), Color.blue));

		l_Ramka.setBounds(20, 175, 460, 105);
		rihenny.add(l_Ramka);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		rihenny.add(Menu);
		rihenny.add(Pogoda);
		rihenny.add(Karta);
		rihenny.add(Gotovo);
		rihenny.add(Nazad);
		rihenny.add(b_anketa);
		
		rihenny.add(b_tabluca);
		rihenny.add(b_grafik);
		rihenny.add(b_hvudko);		

		rihenny.add(l_Nazva1);
		rihenny.add(l_Nazva2);
		rihenny.add(l_Kohtovnist);
		rihenny.add(l_Pruemnist);
		rihenny.add(l_Dopomoga);
		rihenny.add(l_Vagkist);
		rihenny.add(l_Predstavlenna);

		rihenny.add(t_Nazva1);
		rihenny.add(t_Nazva2);

		rihenny.add(l_logo);

		rihenny.add(Pusto);

		sl_Kohtovnistl.addChangeListener(slider1);
		sl_Kohtovnist2.addChangeListener(slider2);
		sl_Pruemnist1.addChangeListener(slider3);
		sl_Pruemnist2.addChangeListener(slider4);
		sl_Vagkist1.addChangeListener(slider5);
		sl_Vagkist2.addChangeListener(slider6);
		Menu.addActionListener(handler);
		Pogoda.addActionListener(handler);
		Karta.addActionListener(handler);
		Gotovo.addActionListener(handler);
		b_tabluca.addActionListener(handler);
		b_grafik.addActionListener(handler);
		b_hvudko.addActionListener(handler);
		Nazad.addActionListener(handler);
		b_anketa.addActionListener(handler);
		

	}

	class SliderListener1 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Kohtovnistl = (JSlider) e.getSource();
			i_Kohtovnistl = (int) sl_Kohtovnistl.getValue();
		}
	}

	class SliderListener2 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Kohtovnist2 = (JSlider) e.getSource();
			i_Kohtovnist2 = (int) sl_Kohtovnist2.getValue();
		}
	}

	class SliderListener3 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Pruemnist1 = (JSlider) e.getSource();
			i_Pruemnist1 = (int) sl_Pruemnist1.getValue();
		}
	}

	class SliderListener4 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Pruemnist2 = (JSlider) e.getSource();
			i_Pruemnist2 = (int) sl_Pruemnist2.getValue();
		}
	}

	/////
	class SliderListener5 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Vagkist1 = (JSlider) e.getSource();
			i_Vagkist1 = (int) sl_Vagkist1.getValue();
		}
	}

	class SliderListener6 implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			sl_Vagkist2 = (JSlider) e.getSource();
			i_Vagkist2 = (int) sl_Vagkist2.getValue();
		}
	}

	public class eHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			s_Nazva1 = t_Nazva1.getText();
			s_Nazva2 = t_Nazva2.getText();
			
			try {
				if (e.getSource() ==  Nazad) {
					
					Menu.setBounds(375, 10, 100, 20);
					Pogoda.setBounds(65, 250, 130, 20);
					Karta.setBounds(300, 250, 130, 20);
					Gotovo.setBounds(375, 350, 100, 20);
					
					l_Nazva1.setBounds(100, 30, 100, 15);
					l_Nazva2.setBounds(300, 30, 100, 15);
					l_Kohtovnist.setBounds(100, 70, 300, 15);
					l_Pruemnist.setBounds(100, 150, 300, 15);
					l_Dopomoga.setBounds(100, 230, 300, 15);
					l_Vagkist.setBounds(50, 280, 400, 15);
 

					t_Nazva1.setBounds(80, 50, 120, 20);
					t_Nazva2.setBounds(280, 50, 120, 20);
					
					sl_Kohtovnistl.setBounds(35, 100, 200, 40);
					rihenny.add(sl_Kohtovnistl);
					sl_Kohtovnist2.setBounds(270, 100, 200, 40);
					rihenny.add(sl_Kohtovnist2);
					sl_Pruemnist1.setBounds(35, 185, 200, 40);
					rihenny.add(sl_Pruemnist1);
					sl_Pruemnist2.setBounds(270, 185, 200, 40);
					rihenny.add(sl_Pruemnist2);
					sl_Vagkist1.setBounds(35, 300, 200, 40);
					rihenny.add(sl_Vagkist1);
					sl_Vagkist2.setBounds(270, 300, 200, 40);
					rihenny.add(sl_Vagkist2);
 
					l_Ramka.setBounds(20, 175, 460, 105);
					
					Nazad.setBounds(0, 0, 0, 0);
					b_tabluca.setBounds(0, 0, 0, 0);
					b_grafik.setBounds(0, 0, 0, 0);
					b_hvudko.setBounds(0, 0, 0, 0);
					l_logo.setBounds(0, 0, 0, 0);
					l_Predstavlenna.setBounds(0, 0, 0, 0);
					b_anketa.setBounds(0, 0, 0, 0);
			 
					 
				}
				if (e.getSource() == Pogoda) {

					try {
						d.browse(new URI(
								"https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%B2%D0%B8%D0%BD%D0%BD%D0%B8%D1%86%D0%B0"));
					} catch (Exception e1) {
					}
				}
				if (e.getSource() == Karta) {
					try {
						d.browse(new URI(
								"https://www.google.com.ua/maps/place/%D0%92%D0%B8%D0%BD%D0%BD%D0%B8%D1%86%D0%B0,+%D0%92%D0%B8%D0%BD%D0%BD%D0%B8%D1%86%D0%BA%D0%B0%D1%8F+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/@49.2276433,28.4378695,13z/data=!4m2!3m1!1s0x472d5b65195a6489:0xcbd4e159eedd74fe"));
					} catch (Exception e1) {
					}
				}
				if (e.getSource() == Gotovo) {

					if ((i_Pruemnist1 == i_Pruemnist2) && (i_Kohtovnistl == i_Kohtovnist2)
							&& (i_Vagkist1 == i_Vagkist2)) {
						JOptionPane.showMessageDialog(null,
								"       Помилка всі дані однакові,\nабо не змінені із початкового значення");
					} else {

						i_Kohtovnistl = 6 - i_Kohtovnistl;
						i_Kohtovnist2 = 6 - i_Kohtovnist2;
						i_Vagkist1 = 6 - i_Vagkist1;
						i_Vagkist2 = 6 - i_Vagkist2;

						u5 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;
						u6 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;
						u7 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;
						u8 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;

						u1 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;
						u2 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;
						u3 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;
						u4 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;

						u9 = (0.5 * (i_Kohtovnistl)) + (i_Pruemnist1) + (0.5 * (i_Vagkist1));
						u10 = (0.5 * (i_Kohtovnist2)) + (i_Pruemnist2) + (0.5 * (i_Vagkist2));
						u11 = (0.5 * ((i_Kohtovnistl + i_Kohtovnist2) / 2)) + (2 * ((i_Pruemnist1 + i_Pruemnist2) / 2))
								+ (0.5 * ((i_Vagkist1 + i_Vagkist2) / 2));
						u12 = (0.5 * ((i_Kohtovnistl + i_Kohtovnist2) / 2))
								+ (0.5 * ((i_Pruemnist1 + i_Pruemnist2) / 2)) + (0.5 * ((i_Vagkist1 + i_Vagkist2) / 2));
 
						u1 = u1 * 0.01;
						u2 = u2 * 0.889;
						u3 = u3 * 0.001;
						u4 = u4 * 0.1;
						u5 = u5 * 0.889;
						u6 = u6 * 0.01;
						u7 = u7 * 0.001;
						u8 = u8 * 0.1;
						 
						 

						q1 = u1 * 0.01 + u2 * 0.889 + u3 * 0.001 + u4 * 0.1;
						q2 = u5 * 0.889 + u6 * 0.01 + u7 * 0.001 + u8 * 0.1;
						q3 = u9 * 0.25 + u10 * 0.25 + u11 * 0.25 + u12 * 0.25;
						
						String s = u1 + "  " + u2 + "  " + u3 + "  " + u4 + "\n" + u5 + "  " + u6 + "  " + u7 + "  "
								+ u8 + "\n" + u9 + "  " + u10 + "  " + u11 + "  " + u12;
				 
						String s1 = q1 + "  " + q2 + "  " + q3;
					 

						if (q1 == q2) {
							if (q1 <= q3) {
								JOptionPane.showMessageDialog(null,
										"Найкращою альтернативою є виконання\nобох подій одночасно чи поетапно.");
							} else {
								u5 = i_Kohtovnistl + (2 * i_Pruemnist1) + i_Vagkist1;
								u6 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;
								u7 = i_Kohtovnistl + (2 * i_Pruemnist1) + i_Vagkist1;
								u8 = i_Kohtovnistl + i_Pruemnist1 + i_Vagkist1;

								u1 = i_Kohtovnist2 + (2 * i_Pruemnist2) + i_Vagkist2;
								u2 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;
								u3 = i_Kohtovnist2 + (2 * i_Pruemnist2) + i_Vagkist2;
								u4 = i_Kohtovnist2 + i_Pruemnist2 + i_Vagkist2;
								
								u1 = u1 * 0.01;
								u2 = u2 * 0.889;
								u3 = u3 * 0.001;
								u4 = u4 * 0.1;
								u5 = u5 * 0.889;
								u6 = u6 * 0.01;
								u7 = u7 * 0.001;
								u8 = u8 * 0.1;
								u9 = u9 * 0.25;
							 

								String s0_1 = u1 + "  " + u2 + "  " + u3 + "  " + u4 + "\n" + u5 + "  " + u6 + "  " + u7
										+ "  " + u8 + "\n" + u9 + "  " + u10 + "  " + u11 + "  " + u12;
							 

								q1 = u1 * 0.01 + u2 * 0.889 + u3 * 0.001 + u4 * 0.1;
								q2 = u5 * 0.889 + u6 * 0.01 + u7 * 0.001 + u8 * 0.1;

								String s2 = q1 + "  " + q2 + "  " + q3;
								 

							}
						}

						sl_Kohtovnistl.setBounds(0, 0, 0, 0);
						sl_Kohtovnist2.setBounds(0, 0, 0, 0);
						sl_Pruemnist1.setBounds(0, 0, 0, 0);
						sl_Pruemnist2.setBounds(0, 0, 0, 0);
						sl_Vagkist1.setBounds(0, 0, 0, 0);
						sl_Vagkist2.setBounds(0, 0, 0, 0);

						Pogoda.setBounds(0, 0, 0, 0);
						Karta.setBounds(0, 0, 0, 0);
						Gotovo.setBounds(0, 0, 0, 0);

						l_Nazva1.setBounds(0, 0, 0, 0);
						l_Nazva2.setBounds(0, 0, 0, 0);
						l_Kohtovnist.setBounds(0, 0, 0, 0);
						l_Pruemnist.setBounds(0, 0, 0, 0);
						l_Dopomoga.setBounds(0, 0, 0, 0);
						l_Vagkist.setBounds(0, 0, 0, 0);

						t_Nazva1.setBounds(0, 0, 0, 0);
						t_Nazva2.setBounds(0, 0, 0, 0);

						l_Ramka.setBounds(0, 0, 0, 0);
						
						Nazad.setBounds(375, 30, 100, 20);

						l_Predstavlenna.setBounds(20, 75, 500, 30);

						b_tabluca.setBounds(175, 300, 150, 50);
						b_grafik.setBounds(325, 300, 150, 50);
						b_hvudko.setBounds(25, 300, 150, 50);

						l_logo.setBounds(0, 0, 500, 400);

					}
				}
				
				if (e.getSource() == b_anketa) {
					new Anketa("");
					rihenny.setVisible(false);
				}
				if (e.getSource() == Menu) {
					new Menu("");
					rihenny.setVisible(false);
				}
				if (e.getSource() == b_tabluca) {
					  
					
					new RihennyDopovneena(s_Nazva1 , s_Nazva2, u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12,
							q1, q2, q3);
					
					b_anketa.setBounds(100, 350,300, 20);
					
				}
				if (e.getSource() == b_grafik) {
 
					
					double[] Result = new double[3];
					double[] Result1 = new double[3];
					double[] Result2 = new double[3];
				
					
					Result[0] = q1;
					Result1[1] = q2;
					Result2[2] = q3;
					
					Chart chart = new ChartBuilder().chartType(ChartType.Area).width(800)
							.height(600).title("Діаграма прийняття рішень").xAxisTitle(
									"1 -Відмінити (перенести) 1 подію,     2 -Відмінити (перенести) 2 подію,     3 - виконувати обидві події одночасно(поетапно)")
							.yAxisTitle("Значення за критеріями").build();
					
				 
					 
					 chart.addSeries("Відмінити (перенести) 1 подію", new double[] { 1, 2, 3},	
							 Result);
					 chart.addSeries("Відмінити (перенести) 2 подію", new double[] { 1, 2, 3},	
							 Result1);
					 chart.addSeries("Виконувати обидві події одночасно(поетапно)", new double[] { 1, 2, 3},	
							 Result2);
					
					
					chart.getStyleManager().setLegendPosition(LegendPosition.InsideNW);
					new SwingWrapper(chart).displayChart();
					try {
						BitmapEncoder.savePNGWithDPI(chart, "prognoz/Rihenna.png", 400);
					} catch (IOException eq) {}
					
					
					b_anketa.setBounds(100, 350,300, 20);

				}
				if (e.getSource() == b_hvudko) {

				 

					if (q1 < q2) {
						if (q2 < q3) {
							JOptionPane.showMessageDialog(null,
									"Найкращою альтернативою є виконання обох подій одночасно,\n або поетапно, зменшивши час виконання");
						} else {
							JOptionPane.showMessageDialog(null,
									"Найкращою альтернативою є відміна(перенесення)події - " + s_Nazva2);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Найкращою альтернативою є відміна(перенесення)події - " + s_Nazva1);
					}

					b_anketa.setBounds(100, 350,300, 20);
					
				}
			} catch (Exception ex) {
			}
		}
	}
}
