import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.xeiam.xchart.BitmapEncoder;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.StyleManager.LegendPosition;
import com.xeiam.xchart.SwingWrapper;

public class Prognoz extends JFrame {

	JFrame Prognoz = new JFrame("Тайм-менеджмент 0.5 Прогнозування");

	JButton Menu, b_Prognoz1, b_Prognoz2;
	JLabel Vkazivka, Vkazivka1, Vkazivka2;
	JTextField t_den;

	JLabel Pusto;
	
	String s_day1 = "";
	String s_day2 = "";
	String s_day3 = "";
	String s_day4 = "";
	String s_day5 = "";
	String s_day6 = "";
	String s_day7 = "";
	String s_day8 = "";
	
	
	String f = "res/f_prognoz.png";
	  
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);

	
	int type1 = JOptionPane.ERROR_MESSAGE; // Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ
	int type2 = JOptionPane.WARNING_MESSAGE;

	Calendar calendar = Calendar.getInstance();
	int day = calendar.get(calendar.DAY_OF_MONTH);
	int month = calendar.get(calendar.MONTH) + 1;
 
	Scanner scn;
	String[][] Reading = new String[1][9];
	String[][] Reading0 = new String[1][9];
	int[] Reading_P = new int [9];
	int[] Reading_P1 = new int [9];
	
	static double[] Result = new double[9];
	static double[] Result1 = new double[9];
	double[] grafic = new double [9];

	Formatter x;

	eHandler handler = new eHandler();

	public Prognoz(String s) {
		super(s);
	
		Prognoz.setVisible(true);
		Prognoz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Prognoz.setSize(500, 400);
		Prognoz.setResizable(false);
		Prognoz.setLocationRelativeTo(null);

		Menu = new JButton("Меню");
		Menu.setBounds(365, 10, 120, 20);
		b_Prognoz1 = new JButton("Прогноз усередненим методом");
		b_Prognoz1.setBounds(120, 200, 260, 30);
		b_Prognoz2 = new JButton("Прогноз на основі нейронної мережі");
		b_Prognoz2.setBounds(120, 230, 260, 30);

		Vkazivka = new JLabel(
				"Вкажіть день для якого буде розраховано завантаженість:");
		Vkazivka.setBounds(30, 60, 450, 20);
		Vkazivka1 = new JLabel("(для забезпечення почності вказувати");
		Vkazivka1.setBounds(60, 90, 450, 20);
		Vkazivka2 = new JLabel("можна лише на найближчий тиждень)");
		Vkazivka2.setBounds(70, 110, 450, 20);

		String s_day = "" + day;
		
		l_logo.setBounds(0, 0, 500, 400);

		t_den = new JTextField(s_day);
		t_den.setBounds(380, 90, 70, 30);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		Prognoz.add(Menu);
		Prognoz.add(b_Prognoz1);
		Prognoz.add(b_Prognoz2);
		Prognoz.add(Vkazivka);
		Prognoz.add(Vkazivka1);
		Prognoz.add(Vkazivka2);
		Prognoz.add(t_den);
		Prognoz.add(l_logo);
		Prognoz.add(Pusto);

		Menu.addActionListener(handler);
		b_Prognoz1.addActionListener(handler);
		b_Prognoz2.addActionListener(handler);
		
	

	}

	public class eHandler implements ActionListener {
		 
		public void actionPerformed(ActionEvent e) {
			
			
			try {
				if (e.getSource() == Menu) {
					new Menu("");
					Prognoz.setVisible(false);
				}
				if (e.getSource() == b_Prognoz2) {
					String s_den = t_den.getText();
					int i_den = Integer.parseInt(s_den);
					
					 int day_max1 = 0;
					 int day_max2 = 0;
					 int day_max3 = 0;
					 int day_max4 = 0;
					 int day_max5 = 0;
					 int day_max6 = 0;
					 int day_max7 = 0;
					 
						s_day1 = "";
						s_day2 = "";
						s_day3 = "";
						s_day4 = "";
						s_day5 = "";
						s_day6 = "";
						s_day7 = "";
						s_day8 = "";

					if (i_den <= 0 || i_den > 31) {
						JOptionPane.showMessageDialog(null,
								"Помилкове введенння");
					} else {

						int perevirka = day + 7;
						
						
						////////////////
						
						switch (day) {
						case 25: {
							  day_max1 = 25;
							  day_max2 = 26;
							  day_max3 = 27;
							  day_max4 = 28;
							  day_max5 = 29;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 26: {
							  day_max1 = 1;
							  day_max2 = 26;
							  day_max3 = 27;
							  day_max4 = 28;
							  day_max5 = 29;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 27: {
							  day_max1 = 1;
							  day_max2 = 2;
							  day_max3 = 27;
							  day_max4 = 28;
							  day_max5 = 29;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 28: {
							  day_max1 = 1;
							  day_max2 = 2;
							  day_max3 = 3;
							  day_max4 = 28;
							  day_max5 = 29;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 29: {
							  day_max1 = 1;
							  day_max2 = 2;
							  day_max3 = 3;
							  day_max4 = 4;
							  day_max5 = 29;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 30: {
							  day_max1 = 1;
							  day_max2 = 2;
							  day_max3 = 3;
							  day_max4 = 4;
							  day_max5 = 5;
							  day_max6 = 30;
							  day_max7 = 31;
						}
						break;
						case 31: {
							  day_max1 = 1;
							  day_max2 = 2;
							  day_max3 = 3;
							  day_max4 = 4;
							  day_max5 = 5;
							  day_max6 = 6;
							  day_max7 = 31;
						}
						break;
						default:{
							  day_max1 = day + 1;
							  day_max2 = day + 2;
							  day_max3 = day + 3;
							  day_max4 = day + 4;
							  day_max5 = day + 5;
							  day_max6 = day + 6;
							  day_max7 = day + 7;
						}
					}
						
						
						if(i_den == day_max1 || i_den==day_max2 || i_den==day_max3 || i_den==day_max4 || i_den==day_max5 || i_den==day_max6 || i_den==day_max7 ){
					
						
						////////////////
				
						//	String s_day = "" + (day - 1);
							String s_month = "" +  month; 
						//	zavantajenist_dna1(s_month, s_day);
													
						
						switch (i_den) {
						case 1: {
							
						 
							
							s_day1 = s_day1 + 31;
							s_day2 = s_day2 + 30;
							s_day3 = s_day3 + 29;
							s_day4 = s_day4 + 28;
							s_day5 = s_day5 + 25;
							s_day6 = s_day6 + 24;
							s_day7 = s_day7 + 18;
							s_day8 = s_day8 + 17;						 
							
 				   
							zavantajenist_dna1(s_month, s_day1);							
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);						
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);						 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);			
							


						}
						break;
						case 2: {
							s_day1 = s_day1 + 1;
							s_day2 = s_day2 + 31;
							s_day3 = s_day3 + 30;
							s_day4 = s_day4 + 29;
							s_day5 = s_day5 + 26;
							s_day6 = s_day6 + 25;
							s_day7 = s_day7 + 19;
							s_day8 = s_day8 + 18;
							
// 							    s_month = "" + month+1; 
								zavantajenist_dna1(s_month, s_day1);
// 			     				s_month = "" + (month); 
								zavantajenist_dna1(s_month, s_day2);						 
								zavantajenist_dna1(s_month, s_day3);						
								zavantajenist_dna1(s_month, s_day4);						
								zavantajenist_dna1(s_month, s_day5);
								zavantajenist_dna1(s_month, s_day6);						 
								zavantajenist_dna1(s_month, s_day7);						
								zavantajenist_dna1(s_month, s_day8);	
								
						}
						break;
						case 3: {
							s_day1 = s_day1 + 2;
							s_day2 = s_day2 + 1;
							s_day3 = s_day3 + 31;
							s_day4 = s_day4 + 30;
							s_day5 = s_day5 + 27;
							s_day6 = s_day6 + 26;
							s_day7 = s_day7 + 20;
							s_day8 = s_day8 + 19;
							
//							    s_month = "" + month; 
								zavantajenist_dna1(s_month, s_day1);								 
								zavantajenist_dna1(s_month, s_day2);
//								s_month = "" + (month-1);					 
								zavantajenist_dna1(s_month, s_day3);						
								zavantajenist_dna1(s_month, s_day4);						
								zavantajenist_dna1(s_month, s_day5);
								zavantajenist_dna1(s_month, s_day6);						 
								zavantajenist_dna1(s_month, s_day7);						
								zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 4: {
							s_day1 = s_day1 + 3;
							s_day2 = s_day2 + 2;
							s_day3 = s_day3 + 1;
							s_day4 = s_day4 + 31;
							s_day5 = s_day5 + 28;
							s_day6 = s_day6 + 27;
							s_day7 = s_day7 + 21;
							s_day8 = s_day8 + 20;
							
//							    s_month = "" + month; 
							 	zavantajenist_dna1(s_month, s_day1);								
								zavantajenist_dna1(s_month, s_day2);						 
								zavantajenist_dna1(s_month, s_day3);
//								s_month = "" + (month-1); 					
								zavantajenist_dna1(s_month, s_day4);						
								zavantajenist_dna1(s_month, s_day5);
								zavantajenist_dna1(s_month, s_day6);						 
								zavantajenist_dna1(s_month, s_day7);						
								zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 5: {
							s_day1 = s_day1 + 4;
							s_day2 = s_day2 + 3;
							s_day3 = s_day3 + 2;
							s_day4 = s_day4 + 1;
							s_day5 = s_day5 + 29;
							s_day6 = s_day6 + 28;
							s_day7 = s_day7 + 22;
							s_day8 = s_day8 + 21;
							
//							    s_month = "" + month; 
								zavantajenist_dna1(s_month, s_day1);								
								zavantajenist_dna1(s_month, s_day2);						 
								zavantajenist_dna1(s_month, s_day3);						
								zavantajenist_dna1(s_month, s_day4);
//								s_month = "" + (month-1); 						
								zavantajenist_dna1(s_month, s_day5);
								zavantajenist_dna1(s_month, s_day6);						 
								zavantajenist_dna1(s_month, s_day7);						
								zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 6: {
							s_day1 = s_day1 + 5;
							s_day2 = s_day2 + 4;
							s_day3 = s_day3 + 3;
							s_day4 = s_day4 + 2;
							s_day5 = s_day5 + 30;
							s_day6 = s_day6 + 29;
							s_day7 = s_day7 + 23;
							s_day8 = s_day8 + 22;

							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);
//							s_month = "" + (month-1); 						
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);						 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 7: {
							s_day1 = s_day1 + 6;
							s_day2 = s_day2 + 5;
							s_day3 = s_day3 + 4;
							s_day4 = s_day4 + 3;
							s_day5 = s_day5 + 31;
							s_day6 = s_day6 + 30;
							s_day7 = s_day7 + 24;
							s_day8 = s_day8 + 23;

							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);
//							s_month = "" + (month-1); 						
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);						 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 8: {
							s_day1 = s_day1 + 7;
							s_day2 = s_day2 + 6;
							s_day3 = s_day3 + 5;
							s_day4 = s_day4 + 4;
							s_day5 = s_day5 + 1;
							s_day6 = s_day6 + 31;
							s_day7 = s_day7 + 25;
							s_day8 = s_day8 + 24;

							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
//							s_month = "" + (month-1); 	
							zavantajenist_dna1(s_month, s_day6);						 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 9: {
							s_day1 = s_day1 + 8;
							s_day2 = s_day2 + 7;
							s_day3 = s_day3 + 6;
							s_day4 = s_day4 + 5;
							s_day5 = s_day5 + 2;
							s_day6 = s_day6 + 1;
							s_day7 = s_day7 + 26;
							s_day8 = s_day8 + 25;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);	
						}
						break;
						case 10: {
							s_day1 = s_day1 + 9;
							s_day2 = s_day2 + 8;
							s_day3 = s_day3 + 7;
							s_day4 = s_day4 + 6;
							s_day5 = s_day5 + 3;
							s_day6 = s_day6 + 2;
							s_day7 = s_day7 + 27;
							s_day8 = s_day8 + 26;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						case 11: {
							s_day1 = s_day1 + 10;
							s_day2 = s_day2 + 9;
							s_day3 = s_day3 + 8;
							s_day4 = s_day4 + 7;
							s_day5 = s_day5 + 4;
							s_day6 = s_day6 + 3;
							s_day7 = s_day7 + 28;
							s_day8 = s_day8 + 27;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						case 12: {
							s_day1 = s_day1 + 11;
							s_day2 = s_day2 + 10;
							s_day3 = s_day3 + 9;
							s_day4 = s_day4 + 8;
							s_day5 = s_day5 + 5;
							s_day6 = s_day6 + 4;
							s_day7 = s_day7 + 29;
							s_day8 = s_day8 + 28;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						case 13: {
							s_day1 = s_day1 + 12;
							s_day2 = s_day2 + 11;
							s_day3 = s_day3 + 10;
							s_day4 = s_day4 + 9;
							s_day5 = s_day5 + 6;
							s_day6 = s_day6 + 5;
							s_day7 = s_day7 + 30;
							s_day8 = s_day8 + 29;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						case 14: {
							s_day1 = s_day1 + 13;
							s_day2 = s_day2 + 12;
							s_day3 = s_day3 + 11;
							s_day4 = s_day4 + 10;
							s_day5 = s_day5 + 7;
							s_day6 = s_day6 + 6;
							s_day7 = s_day7 + 31;
							s_day8 = s_day8 + 30;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);
//							s_month = "" + (month-1); 							 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						case 15: {
							s_day1 = s_day1 + 14;
							s_day2 = s_day2 + 13;
							s_day3 = s_day3 + 12;
							s_day4 = s_day4 + 11;
							s_day5 = s_day5 + 8;
							s_day6 = s_day6 + 7;
							s_day7 = s_day7 + 1;
							s_day8 = s_day8 + 31;
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);												 
							zavantajenist_dna1(s_month, s_day7);
//							s_month = "" + (month-1); 							
							zavantajenist_dna1(s_month, s_day8);
						}
						break;
						default:{
							s_day1 = s_day1 +  (day - 1) ;
							s_day2 = s_day2 +  (day - 2);
							s_day3 = s_day3 +  (day - 3);
							s_day4 = s_day4 +  (day - 4);
							s_day5 = s_day5 +  (day - 7);
							s_day6 = s_day6 +  (day - 8);
							s_day7 = s_day7 +  (day - 14);
							s_day8 = s_day8 +  (day - 15);
							
							
//						    s_month = "" + month; 
							zavantajenist_dna1(s_month, s_day1);								
							zavantajenist_dna1(s_month, s_day2);						 
							zavantajenist_dna1(s_month, s_day3);						
							zavantajenist_dna1(s_month, s_day4);												
							zavantajenist_dna1(s_month, s_day5);
							zavantajenist_dna1(s_month, s_day6);					 				 
							zavantajenist_dna1(s_month, s_day7);						
							zavantajenist_dna1(s_month, s_day8);
						}
					}
		 
				
//						for (File myFile : new File("prognoz/").listFiles())// РѕС‡РёС‰Р°С”РјРѕ РїР°РїР°РєСѓ prognoz
//			                if (myFile.isFile()) myFile.delete();
						
//						String s_day = "" + (day - 1);
//						String s_month = "" + month; 
//						zavantajenist_dna1(s_month, s_day);
//						
//						String s_day1 = "" + (day - 2); 
//						zavantajenist_dna1(s_month, s_day1);
//						
//						String s_day2 = "" + (day - 3); 
//						zavantajenist_dna1(s_month, s_day2);
//						
//						String s_day3 = "" + (day - 4); 
//						zavantajenist_dna1(s_month, s_day3);
						
					 int i_den1 = i_den ;
					 int i_den2 = i_den ;
					 int i_den3 = i_den ;
					 int i_den4 = i_den ;
					 
					 String s_month1 = s_month ;
					 String s_month2 = s_month ;
					 String s_month3 = s_month ;
					 String s_month4 = s_month ;
					
						if(i_den < 8){							 
							i_den1 =  i_den + 30;
							i_den2 =  i_den + 30;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = s_month;
							s_month2 = s_month;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						
						if(i_den == 8){
							i_den1 =  i_den;	
							i_den2 =  i_den + 30;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						if(i_den >= 9){
							i_den1 =  i_den;	
							i_den2 =  i_den;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month1;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						if(i_den >= 10){
							i_den1 =  i_den;	
							i_den2 =  i_den;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month1;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						
//						String s_day4 = "" + (i_den1 - 7); 
//						zavantajenist_dna(s_month1, s_day4);
//						
//						String s_day5 = "" + (i_den2 - 8); 
//						zavantajenist_dna(s_month2, s_day5);
//						
//						String s_day6 = "" + (i_den3 - 14); 
//						zavantajenist_dna(s_month3, s_day6);
//						
//						String s_day7 = "" + (i_den4 - 15); 
//						zavantajenist_dna(s_month4, s_day7);

					
					perseptron1 ();
						
						
						
						}else{
							JOptionPane.showMessageDialog(null, "Прогнозувати можли тільки на 7 днів у перед");
							}
					}
				}
				if (e.getSource() == b_Prognoz1) {
					
					String s_den = t_den.getText();

					int i_den = Integer.parseInt(s_den);

					if (i_den <= 0 || i_den > 31) {
						JOptionPane.showMessageDialog(null,
								"Помилкове введенння");
					} else {

						int perevirka = day + 7;

						switch(i_den){
							
						}
						
						
//						if (i_den > perevirka) {
//							JOptionPane.showMessageDialog(null,
//									"РќРµРєРѕСЂРµРєС‚РЅРµ РІРІРµРґРµРЅРЅСЏ");
//						} else {
//
//							int i_max = 0;
//
//							if (i_den > 23 ) {
//								switch (day) {
//								case 24:
//									i_max = 1;
//									break;
//								case 25:
//									i_max = 2;
//									break;
//								case 26:
//									i_max = 3;
//									break;
//								case 27:
//									i_max = 4;
//									break;
//								case 28:
//									i_max = 5;
//									break;
//								case 29:
//									i_max = 6;
//									break;
//								case 30:
//									i_max = 7;
//									break;
//								}
//
//								if (i_max < i_den) {
//									JOptionPane.showMessageDialog(null,
//											"РќРµРєРѕСЂРµРєС‚РЅРµ РІРІРµРґРµРЅРЅСЏ");
//									System.out.println("cd");
//
//								}
//							}
//
//						}

						for (File myFile : new File("prognoz/").listFiles())// РѕС‡РёС‰Р°С”РјРѕ РїР°РїР°РєСѓ prognoz
			                if (myFile.isFile()) myFile.delete();
						
						String s_day = "" + (day - 1);
						String s_month = "" + month; 
						zavantajenist_dna(s_month, s_day);
						
						String s_day1 = "" + (day - 2); 
						zavantajenist_dna(s_month, s_day1);
						
						String s_day2 = "" + (day - 3); 
						zavantajenist_dna(s_month, s_day2);
						
						String s_day3 = "" + (day - 4); 
						zavantajenist_dna(s_month, s_day3);
						
					 int i_den1 = i_den ;
					 int i_den2 = i_den ;
					 int i_den3 = i_den ;
					 int i_den4 = i_den ;
					 
					 String s_month1 = s_month ;
					 String s_month2 = s_month ;
					 String s_month3 = s_month ;
					 String s_month4 = s_month ;
					
						if(i_den < 8){							 
							i_den1 =  i_den + 30;
							i_den2 =  i_den + 30;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = s_month;
							s_month2 = s_month;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						
						if(i_den == 8){
							i_den1 =  i_den;	
							i_den2 =  i_den + 30;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						if(i_den >= 9){
							i_den1 =  i_den;	
							i_den2 =  i_den;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month1;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						if(i_den >= 10){
							i_den1 =  i_den;	
							i_den2 =  i_den;
							i_den3 =  i_den + 30;
							i_den4 =  i_den + 30;
							s_month = ""+ (month-1) ;
							s_month1 = ""+ month;
							s_month2 = s_month1;
							s_month3 = s_month;
							s_month4 = s_month;
							}
						
//						String s_day4 = "" + (i_den1 - 7); 
//						zavantajenist_dna(s_month1, s_day4);
//						
//						String s_day5 = "" + (i_den2 - 8); 
//						zavantajenist_dna(s_month2, s_day5);
//						
//						String s_day6 = "" + (i_den3 - 14); 
//						zavantajenist_dna(s_month3, s_day6);
//						
//						String s_day7 = "" + (i_den4 - 15); 
//						zavantajenist_dna(s_month4, s_day7);

					
						perseptron ();
						
						
					}

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Некоректне введення", null, type1);
			}
		}

		

		private void zavantajenist_dna(String i_Misatc, String i_Chislo) {
			 
			int rizn = 0;
			int i_zavantajenist_dna = 0;
			String prioriti = "";
			String p_podii = "";
			String k_podii = "";

			String put0 = "dani/" + i_Misatc + "/" + i_Chislo;

			File[] fList;
			File F = new File(put0);
		
			fList = F.listFiles();
			
			int i1 = 0;
			for (; i1 <  F.listFiles().length; i1++) {
				// РќСѓР¶РЅС‹ С‚РѕР»СЊРєРѕ РїР°РїРєРё РІ РјРµСЃС‚Рѕ isFile() РїРёС€РёРј isDirectory()
				if (fList[i1].isFile()) {
				}
				// System.out.println(String.valueOf(i1) + " - " +
				// fList[i1].getName());

				String put = "dani/" + i_Misatc + "/" + i_Chislo + "/"
						+ fList[i1].getName();

				try {
					scn = new Scanner(new File(put));
				} catch (Exception qe) {
					System.out.print("Error");
				}

				while (scn.hasNext()) {
					for (int row = 0; row < Reading.length; row++) {

						for (int col = 0; col < Reading[row].length; col++) {

							Reading[row][col] = scn.next();
							// System.out.print(Reading[row][col]);

							if (col == 3) {
								prioriti = scn.next();

							}
							if (col == 2) {
								p_podii = Reading[row][col];  // початок  події

							}
							if (col == 7) {
								k_podii = Reading[row][col];  // кінець  події
								
							}

						}
					}
				}
				
				scn.close();

				int r1 = Integer.parseInt(p_podii);
				int r2 = Integer.parseInt(k_podii);
				int r3 = Integer.parseInt(prioriti);

				rizn = (r2 + 1) - r1;
			 

				i_zavantajenist_dna = i_zavantajenist_dna + (rizn * r3);
				
			}
			
			String Fayl = "prognoz/" + i_Misatc + "." + i_Chislo + ".txt";

			String s_zavantajenist_dna = "" + i_zavantajenist_dna;

			try {
				x = new Formatter(Fayl);

			} catch (Exception e) {
			}

			x.format(s_zavantajenist_dna);
			x.close();
		

		}
		
		private void perseptron()  {
			 
			double d1 = 0;
		
			String put0 = "prognoz/" ;
			String Reading1 = "";
			
			File[] fList;
			File F = new File(put0);

			fList = F.listFiles();
			int i1 = 0;
			double k=0;
			 
			
			Chart chart = new ChartBuilder().chartType(ChartType.Bar).width(800)
					.height(600).title("Діаграма прогнозування").xAxisTitle(
							"1-8 Завантаженість недавніх днів,       9 - прогноз")
					.yAxisTitle("Значення завантаженості дня").build();
 
			
			for ( ; i1 < 4; i1++) {
				// РќСѓР¶РЅС‹ С‚РѕР»СЊРєРѕ РїР°РїРєРё РІ РјРµСЃС‚Рѕ isFile() РїРёС€РёРј isDirectory()
				if (fList[i1].isFile()) {
				}
		//		System.out.println(String.valueOf(i1) + " - " + fList[i1].getName());
			
				
				String put = "prognoz/" + fList[i1].getName();

				try {
					scn = new Scanner(new File(put));
				} catch (Exception qe) {
					System.out.print("Error");
				}
				 
				while (scn.hasNext()) {
					for (int row = 0; row < 1; row++) {
					 
		//				Reading1 = Reading1 +" "+ scn.next();
						Reading1 =  scn.next();
						
						
						int r =  Integer.parseInt(Reading1);
						k = k + r ;
					 
	 
			       d1 =  Double.parseDouble(Reading1);	        
			   
				      			       
				} 
				}
				 Result[i1] = d1;
				//  	System.out.println(Result[i1]);
				scn.close();
				
			}
			
			
	// 	 k=k/8;
	 	 k=k/4;
		 
		 
		 
		 Result1[8] = k;
		 
			 chart.addSeries("Вибірка", new double[] { 1, 2, 3, 4, 5, 6 , 7, 8, 9},	
					 Result);
			 chart.addSeries("Прогноз", new double[] { 1, 2, 3, 4, 5, 6 , 7, 8, 9},	
					 Result1);
			
			
			chart.getStyleManager().setLegendPosition(LegendPosition.InsideNW);
			new SwingWrapper(chart).displayChart();
			try {
				BitmapEncoder.savePNGWithDPI(chart, "prognoz/Chart.png", 400);
			} catch (IOException e) {}
			
			
		 
		
			
			
		}
		
		//////
		
		
		private void zavantajenist_dna1(String i_Misatc, String i_Chislo) {
			 
			int rizn = 0;
			int i_zavantajenist_dna = 0;
			String prioriti = "";
			String p_podii = "";
			String k_podii = "";

			String put0 = "dani/" + i_Misatc + "/" + i_Chislo;

			File[] fList;
			File F = new File(put0);
		
			  fList = F.listFiles();
			int i1 = 0;
			for (; i1 <  F.listFiles().length; i1++) {
			  
				
				// System.out.println(String.valueOf(i1) + " - " +
				// fList[i1].getName());

				String put = "dani/" + i_Misatc + "/" + i_Chislo + "/"
						+ fList[i1].getName();

				try {
					scn = new Scanner(new File(put));
				} catch (Exception qe) {
					System.out.print("Error");
				}

				while (scn.hasNext()) {
					for (int row = 0; row < Reading.length; row++) {
						for (int col = 0; col < Reading[row].length; col++) {

							Reading[row][col] = scn.next();
							// System.out.print(Reading[row][col]);

							if (col == 3) {
								prioriti = scn.next();

							}
							if (col == 2) {
								p_podii = Reading[row][col];  // початок  події

							}
							if (col == 7) {
								k_podii = Reading[row][col];  // кінець  події
								
							}

						}
					}
				}
				
				scn.close();

				int r1 = Integer.parseInt(p_podii);
				int r2 = Integer.parseInt(k_podii);
				int r3 = Integer.parseInt(prioriti);

				rizn = (r2 + 1) - r1;
			 

				i_zavantajenist_dna = i_zavantajenist_dna + (rizn * r3);
				
			}
			
			String Fayl = "prognoz/" + i_Misatc + "." + i_Chislo + ".txt";

			String s_zavantajenist_dna = "" + i_zavantajenist_dna;

			try {
				
				x = new Formatter(Fayl);

			} catch (Exception e) {;
			}

			x.format(s_zavantajenist_dna);
			x.close();
		
		}
		
		private void perseptron1()  {
			 
		
			
			double d1 = 0;
		
			String put0 = "prognoz/" ;
			String Reading1 = "";
			
			File[] fList;
			File F = new File(put0);
			
			fList = F.listFiles();
			int i1 = 0;
			double k9=0;
			double k1_1=0;
			double k1_2=0;
			double k1_3=0;
			double k1_4=0;
			
			int kk = 0;
			 
			Chart chart = new ChartBuilder().chartType(ChartType.Bar).width(800)
					.height(600).title("Діаграма прогнозування").xAxisTitle(
							"1-8 Завантаженість недавніх днів,       9 - прогноз")
					.yAxisTitle("Значення завантаженості дня").build();
 
		
		 	for ( ; i1 < 8; i1++) {
		
		  	
				String put = "prognoz/" + fList[i1].getName();
				
		 	
			
				try {
					scn = new Scanner(new File(put));
				} catch (Exception qe) {
					System.out.print("Errorrr");
				}
				
			 	
				while (scn.hasNext()) {
					for (int row = 0; row < 1; row++) {
		 
						Reading1 =  scn.next();
						
						
						int r =  Integer.parseInt(Reading1);
					 
						
						if(kk == 0 ||kk ==1){
							 k1_1=k1_1+r;
						}
						if(kk == 3 || kk ==2){
							 k1_2=k1_2+r;
						}
						if(kk == 5 || kk ==4){
							 k1_3=k1_3+r;
						}
						if(kk == 6 ||kk ==7){
							 k1_4=k1_4+r;
						}
					   
					 
						 
			       d1 =  Double.parseDouble(Reading1);	        
			   
				      			       
				} kk++;
				}
				 Result[i1] = d1;
			 
				scn.close();
				
		 	}
			
			 
				 k1_1=k1_1/2;			 
				 k1_2=k1_2/2;			 
				 k1_3=k1_3/2;			 
				 k1_4=k1_4/2;
				 
			 
				 k1_1 = (k1_1 + k1_2)/2;
				 k1_3 = (k1_3 + k1_4)/2;
				   
				 k9=(k1_3 + k1_1)/2;
 
		 
		 Result1[8] = k9;
		 
			 chart.addSeries("Вибірка", new double[] { 1, 2, 3, 4, 5, 6 , 7, 8, 9},	
					 Result);
			 chart.addSeries("Прогноз", new double[] { 1, 2, 3, 4, 5, 6 , 7, 8, 9},	
					 Result1);
			
			
				
			chart.getStyleManager().setLegendPosition(LegendPosition.InsideNW);
			new SwingWrapper(chart).displayChart();
			try {
				BitmapEncoder.savePNGWithDPI(chart, "prognoz/Chart.png", 400);
			} catch (IOException e) {}
 
			
			
		}
	}
	
 
}
