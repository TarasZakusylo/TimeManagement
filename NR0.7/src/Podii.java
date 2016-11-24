import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class Podii extends JFrame {

	JFrame podii = new JFrame("Тайм-менеджмент 0.5 Попередні події");

	int type1 = JOptionPane.ERROR_MESSAGE; // Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ
	int type2 = JOptionPane.WARNING_MESSAGE;

	JButton Menu, Vuvestu, Redaguvatu;
	JLabel Pusto;

	JLabel l_Data, l_Znak1, l_Pruklad, l_Hapka;
	JTextField t_Misatc, t_Chislo;

	String s_Misatc, s_Chislo;
	int i_Misatc, i_Chislo;
 
	Scanner sc_k, sc_k1;
	String st = "";

	eHandler handler = new eHandler();


	JLabel l_vilnuy = new JLabel("");
	JLabel l_vilnuy1 = new JLabel("");
	JLabel l_vilnuy2 = new JLabel("");
	JLabel l_vilnuy3 = new JLabel("");
	JLabel l_vilnuy4 = new JLabel("");
	JLabel l_vilnuy5 = new JLabel("");
	JLabel l_vilnuy6 = new JLabel("");
	JLabel l_vilnuy7 = new JLabel("");
	JLabel l_vilnuy8 = new JLabel("");
	JLabel l_vilnuy9 = new JLabel("");
	JLabel l_vilnuy10 = new JLabel("");
	JLabel l_vilnuy11 = new JLabel("");
	JLabel l_vilnuy12 = new JLabel("");
	JLabel l_vilnuy13 = new JLabel("");
	JLabel l_vilnuy14 = new JLabel("");
	JLabel l_vilnuy15 = new JLabel("");
	JLabel l_vilnuy16 = new JLabel("");
	JLabel l_vilnuy17 = new JLabel("");
	JLabel l_vilnuy18 = new JLabel("");
	JLabel l_vilnuy19 = new JLabel("");	
	 
	String vuvid = "";
	String vuvid1 = "";
	String vuvid2 = "";
	String vuvid3 = "";
	String vuvid4 = "";
	String vuvid5 = "";
	String vuvid6 = "";
	String vuvid7 = "";
	String vuvid8 = "";
	String vuvid9 = "";
	String vuvid10 = "";
	String vuvid11 = "";
	String vuvid12 = "";
	String vuvid13 = "";
	String vuvid14 = "";
	String vuvid15 = "";
	String vuvid16 = "";
	String vuvid17 = "";
	String vuvid18 = "";
	String vuvid19 = "";

	JLabel l_cas = new JLabel("");
	JLabel l_cas1 = new JLabel("");
	JLabel l_cas2 = new JLabel("");
	JLabel l_cas3 = new JLabel("");
	JLabel l_cas4 = new JLabel("");
	JLabel l_cas5 = new JLabel("");
	JLabel l_cas6 = new JLabel("");
	JLabel l_cas7 = new JLabel("");
	JLabel l_cas8 = new JLabel("");
	JLabel l_cas9 = new JLabel("");
	JLabel l_cas10 = new JLabel("");
	JLabel l_cas11 = new JLabel("");
	JLabel l_cas12 = new JLabel("");
	JLabel l_cas13 = new JLabel("");
	JLabel l_cas14 = new JLabel("");
	JLabel l_cas15 = new JLabel("");
	JLabel l_cas16 = new JLabel("");
	JLabel l_cas17 = new JLabel("");
	JLabel l_cas18 = new JLabel("");
	JLabel l_cas19 = new JLabel("");
	
	String s_cas = "";
	String s_cas1 = "";
	String s_cas2 = "";
	String s_cas3 = "";
	String s_cas4 = "";
	String s_cas5 = "";
	String s_cas6 = "";
	String s_cas7 = "";
	String s_cas8 = "";
	String s_cas9 = "";
	String s_cas10 = "";
	String s_cas11 = "";
	String s_cas12 = "";
	String s_cas13 = "";
	String s_cas14 = "";
	String s_cas15 = "";
	String s_cas16 = "";
	String s_cas17 = "";
	String s_cas18 = "";
	String s_cas19 = "";
	
	String[][] data = {
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		     {"", "", "","","",""},
		}; 
	
	String[] columnNames = 
		{ "Назва", "Приорітет",  "Відбулась?","Назва", "Приорітет",  "Відбулась?"}; 
	
	String[][] Reading = new String[1][8];


	JTable table = new JTable(data, columnNames);
	 JScrollPane scrollPane = new JScrollPane(add(table));
	
	public Podii(String s) {
		super(s);

	 
		podii.setVisible(true);
		podii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		podii.setSize(500, 400);
		podii.setResizable(false);
		podii.setLocationRelativeTo(null);

		Menu = new JButton("Меню");
		Menu.setBounds(365, 10, 120, 20);
		Vuvestu = new JButton("Вивести");
		Vuvestu.setBounds(365, 40, 120, 20);
		Redaguvatu = new JButton("Редагувати");
		Redaguvatu.setBounds(365, 330, 120, 20);

		l_Hapka = new JLabel("Введіть дату для перегляду подій :");

		l_Data = new JLabel("Дата події:");
		l_Znak1 = new JLabel("/");

		l_Pruklad = new JLabel("Наприклад: 04/25");

		t_Misatc = new JTextField();
		t_Chislo = new JTextField();

		l_Hapka.setBounds(10, 10, 350, 20);
		l_Data.setBounds(10, 30, 130, 20);
		l_Znak1.setBounds(147, 30, 130, 20);
		l_Pruklad.setBounds(220, 30, 260, 20);

		t_Misatc.setBounds(95, 30, 50, 25);
		t_Chislo.setBounds(155, 30, 50, 25);

		l_cas.setBounds(120, 107, 150, 40);
		podii.add(l_cas);
		l_cas1.setBounds(120, 123, 150, 40);
		podii.add(l_cas1);
		l_cas2.setBounds(120, 139, 150, 40);
		podii.add(l_cas2);
		l_cas3.setBounds(120, 155, 150, 40);
		podii.add(l_cas3);
		l_cas4.setBounds(120, 171, 150, 40);
		podii.add(l_cas4);
		l_cas5.setBounds(120, 187, 150, 40);
		podii.add(l_cas5);
		l_cas6.setBounds(120, 203, 150, 40);
		podii.add(l_cas6);
		l_cas7.setBounds(120, 219, 150, 40);
		podii.add(l_cas7);
		l_cas8.setBounds(120, 235, 150, 40);
		podii.add(l_cas8);
		l_cas9.setBounds(120, 251, 150, 40);
		podii.add(l_cas9);
		l_cas10.setBounds(340, 107, 150, 40);
		podii.add(l_cas10);
		l_cas11.setBounds(340, 123, 150, 40);
		podii.add(l_cas11);
		l_cas12.setBounds(340, 139, 150, 40);
		podii.add(l_cas12);
		l_cas13.setBounds(340, 155, 150, 40);
		podii.add(l_cas13);
		l_cas14.setBounds(340, 171, 150, 40);
		podii.add(l_cas14);
		l_cas15.setBounds(340, 187, 150, 40);
		podii.add(l_cas15);
		l_cas16.setBounds(340, 203, 150, 40);
		podii.add(l_cas16);
		l_cas17.setBounds(340, 219, 150, 40);
		podii.add(l_cas17);
		l_cas18.setBounds(340, 235, 150, 40);
		podii.add(l_cas18);
		l_cas19.setBounds(340, 251, 150, 40);
		podii.add(l_cas19);
		//
		l_vilnuy.setBounds(30, 107, 150, 40);
		podii.add(l_vilnuy);
		l_vilnuy1.setBounds(30, 123, 150, 40);
		podii.add(l_vilnuy1);
		l_vilnuy2.setBounds(30, 139, 150, 40);
		podii.add(l_vilnuy2);
		l_vilnuy3.setBounds(30, 155, 150, 40);
		podii.add(l_vilnuy3);
		l_vilnuy4.setBounds(30, 171, 150, 40);
		podii.add(l_vilnuy4);
		l_vilnuy5.setBounds(30, 187, 150, 40);
		podii.add(l_vilnuy5);
		l_vilnuy6.setBounds(30, 203, 150, 40);
		podii.add(l_vilnuy6);
		l_vilnuy7.setBounds(30, 219, 150, 40);
		podii.add(l_vilnuy7);
		l_vilnuy8.setBounds(30, 235, 150, 40);
		podii.add(l_vilnuy8);
		l_vilnuy9.setBounds(30, 251, 150, 40);
		podii.add(l_vilnuy9);
		l_vilnuy10.setBounds(255, 107, 150, 40);
		podii.add(l_vilnuy10);
		l_vilnuy11.setBounds(255, 123, 150, 40);
		podii.add(l_vilnuy11);
		l_vilnuy12.setBounds(255, 139, 150, 40);
		podii.add(l_vilnuy12);
		l_vilnuy13.setBounds(255, 155, 150, 40);
		podii.add(l_vilnuy13);
		l_vilnuy14.setBounds(255, 171, 150, 40);
		podii.add(l_vilnuy14);
		l_vilnuy15.setBounds(255, 187, 150, 40);
		podii.add(l_vilnuy15);
		l_vilnuy16.setBounds(255, 203, 150, 40);
		podii.add(l_vilnuy16);
		l_vilnuy17.setBounds(255, 219, 150, 40);
		podii.add(l_vilnuy17);
		l_vilnuy18.setBounds(255, 235, 150, 40);
		podii.add(l_vilnuy18);
		l_vilnuy19.setBounds(255, 251, 150, 40);
		podii.add(l_vilnuy19);

		Pusto = new JLabel("");
		Pusto.setBounds(10, 10, 10, 10);

		Menu.addActionListener(handler);
		Vuvestu.addActionListener(handler);
		Redaguvatu.addActionListener(handler);

		podii.add(l_Data);
		podii.add(l_Znak1);
		podii.add(l_Pruklad);
		podii.add(l_Hapka);

		podii.add(t_Misatc);
		podii.add(t_Chislo);

		podii.add(Menu);
		podii.add(Vuvestu);
		podii.add(Redaguvatu);

		scrollPane.setBounds(20,100,450,182);
		 
		podii.add(scrollPane);
		
		podii.add(Pusto);

	}

	void ochustka() {
 
		vuvid = "";
		vuvid1 = "";
		vuvid2 = "";
		vuvid3 = "";
		vuvid4 = "";
		vuvid5 = "";
		vuvid6 = "";
		vuvid7 = "";
		vuvid8 = "";
		vuvid9 = "";
		vuvid10 = "";
		vuvid11 = "";
		vuvid12 = "";
		vuvid13 = "";
		vuvid14 = "";
		vuvid15 = "";
		vuvid16 = "";
		vuvid17 = "";
		vuvid18 = "";
		vuvid19 = "";
		
		 s_cas = "";
		 s_cas1 = "";
		 s_cas2 = "";
		 s_cas3 = "";
		 s_cas4 = "";
		 s_cas5 = "";
		 s_cas6 = "";
		 s_cas7 = "";
		 s_cas8 = "";
		 s_cas9 = "";
		 s_cas10 = "";
		 s_cas11 = "";
		 s_cas12 = "";
		 s_cas13 = "";
		 s_cas14 = "";
		 s_cas15 = "";
		 s_cas16 = "";
		 s_cas17 = "";
		 s_cas18 = "";
	     s_cas19 = "";

	}

	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Menu) {
					new Menu("");
					podii.setVisible(false);
				}
				if (e.getSource() == Vuvestu) {

					s_Misatc = t_Misatc.getText();
					s_Chislo = t_Chislo.getText();

					i_Misatc = Integer.parseInt(s_Misatc);
					i_Chislo = Integer.parseInt(s_Chislo);

					Calendar calendar = Calendar.getInstance();
					int month = calendar.get(calendar.MONTH) + 1;
					int day = calendar.get(calendar.DAY_OF_MONTH);

					ochustka();

					// if (i_Misatc >= 1 && i_Misatc <= month && i_Chislo >= 1 )
					// { РІРІРµРґРµРЅРµ С‡РёСЃР»Рѕ РЅРµ РїРµСЂРµРІРёС‰СѓС” СЃСЊРѕРіРѕРґРЅС–С€РЅСЋ РґР°С‚Сѓ

					String Reading1 = "";
					int kk = 0;

					for (int i = 0; i < 24; i++) {
						for (int j = 0; j < 60; j++) {
							String put = "dani/" + i_Misatc + "/" + i_Chislo
									+ "/" + i + "." + j + ".txt";
							File file = new File(put);
 
							
							if (file.exists()) {
								 
								try {
									sc_k = new Scanner(new File(put));
								} catch (Exception ez) {
									JOptionPane.showMessageDialog(null,
											" Помилка файлу°");
								}

								while (sc_k.hasNext()) {

									// st = st + "\n";
									//

									for (int row = 0; row < Reading.length; row++) {

										for (int col = 0; col < Reading[row].length; col++) {

											Reading[row][col] = sc_k.next();
											if (col == 4) {
												Reading1 = sc_k.next();
												
											}
										
										}
									
										
										switch (kk) {
										case 0:
											vuvid = Reading1;
											s_cas = i + " : " + j ;
											break;
										case 1:
											vuvid1 = Reading1;
											s_cas1 = i + " : " + j ;
											break;
										case 2:
											vuvid2 = Reading1;
											s_cas2 = i + " : " + j ;
											break;
										case 3:
											vuvid3 = Reading1;
											s_cas3 = i + " : " + j ;
											break;
										case 4:
											vuvid4 = Reading1;
											s_cas4 = i + " : " + j ;
											break;
										case 5:
											vuvid5 = Reading1;
											s_cas5 = i + " : " + j ;
											break;
										case 6:
											vuvid6 = Reading1;
											s_cas6 = i + " : " + j ;
											break;
										case 7:
											vuvid7 = Reading1;
											s_cas7 = i + " : " + j ;
											break;
										case 8:
											vuvid8 = Reading1;
											s_cas8 = i + " : " + j ;
											break;
										case 9:
											vuvid9 = Reading1;
											s_cas9 = i + " : " + j ;
											break;
										case 10:
											vuvid10 = Reading1;
											s_cas10 = i + " : " + j ;
											break;
										case 11:
											vuvid11 = Reading1;
											s_cas11 = i + " : " + j ;
											break;
										case 12:
											vuvid12 = Reading1;
											s_cas12 = i + " : " + j ;
											break;
										case 13:
											vuvid13 = Reading1;
											s_cas13 = i + " : " + j ;
											break;
										case 14:
											vuvid14 = Reading1;
											s_cas14 = i + " : " + j ;
											break;
										case 15:
											vuvid15 = Reading1;
											s_cas15 = i + " : " + j ;
											break;
										case 16:
											vuvid16 = Reading1;
											s_cas16 = i + " : " + j ;
											break;
										case 17:
											vuvid17 = Reading1;
											s_cas17 = i + " : " + j ;
											break;
										case 18:
											vuvid18 = Reading1;
											s_cas18 = i + " : " + j ;
											break;
										default:
											vuvid19 = Reading1;
											s_cas19 = i + " : " + j ;
											
											JOptionPane
													.showMessageDialog(
															null,
															"Sorry, Подій занадто багато.",
															null, type1);

											i = 70;
											j = 70;
											break;
										}
										kk++;

									}
									st = st + " " + sc_k.next();

								}

								l_vilnuy.setText(vuvid);
								l_vilnuy1.setText(vuvid1);
								l_vilnuy2.setText(vuvid2);
								l_vilnuy3.setText(vuvid3);
								l_vilnuy4.setText(vuvid4);
								l_vilnuy5.setText(vuvid5);
								l_vilnuy6.setText(vuvid6);
								l_vilnuy7.setText(vuvid7);
								l_vilnuy8.setText(vuvid8);
								l_vilnuy9.setText(vuvid9);
								l_vilnuy10.setText(vuvid10);
								l_vilnuy11.setText(vuvid11);
								l_vilnuy12.setText(vuvid12);
								l_vilnuy13.setText(vuvid13);
								l_vilnuy14.setText(vuvid14);
								l_vilnuy15.setText(vuvid15);
								l_vilnuy16.setText(vuvid16);
								l_vilnuy17.setText(vuvid17);
								l_vilnuy18.setText(vuvid18);
								l_vilnuy19.setText(vuvid19);
								
								
								l_cas.setText(s_cas);
								l_cas1.setText(s_cas1);
								l_cas2.setText(s_cas2);
								l_cas3.setText(s_cas3);
								l_cas4.setText(s_cas4);
								l_cas5.setText(s_cas5);
								l_cas6.setText(s_cas6);
								l_cas7.setText(s_cas7);
								l_cas8.setText(s_cas8);
								l_cas9.setText(s_cas9); 
								l_cas10.setText(s_cas10);
								l_cas11.setText(s_cas11);
								l_cas12.setText(s_cas12);
								l_cas13.setText(s_cas13);
								l_cas14.setText(s_cas14);
								l_cas15.setText(s_cas15);
								l_cas16.setText(s_cas16);
								l_cas17.setText(s_cas17);
								l_cas18.setText(s_cas18);
								l_cas19.setText(s_cas19);
								
							}
						}

					}

					if (kk == 0) {

						JOptionPane.showMessageDialog(null,
								"На дану дату подій не було.", null, type2);

						ochustka();

					}

					st = "";

//					 } РІРІРµРґРµРЅРµ С‡РёСЃР»Рѕ РЅРµ РїРµСЂРµРІРёС‰СѓС” СЃСЊРѕРіРѕРґРЅС–С€РЅСЋ РґР°С‚Сѓ
//					 else
//					 {
//					 JOptionPane.showMessageDialog(null, "Error", null,
//					 type1);
//					 }

				}
				if (e.getSource() == Redaguvatu) {

				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						"Помилка", null, type1);
			}
		}

	}

}
