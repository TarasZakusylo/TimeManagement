import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Planu extends JFrame {

	private JLabel label;
	private JLabel label_1 = new JLabel("");

	String s_zavantagenistDna = "";
	String s_zavantagenistDna1 = "";

	private JLabel label_2 = new JLabel("");
	private JLabel label_3 = new JLabel("");

	Calendar calendar = Calendar.getInstance();
	int i_Misatc = calendar.get(calendar.MONTH) + 1;
	int i_Chislo = calendar.get(calendar.DAY_OF_MONTH);

	private Scanner scn;
	private Scanner scn_zavtra;

	String f = "res/JustDoIt.png";
	ImageIcon logo = new ImageIcon(f);
	JLabel l_logo = new JLabel(logo);
	private File F;
	private JTextField t_misac;
	private JTextField t_cuslo;

	private int i_misac;
	private int i_cuslo;

	int indikator_zavtra = 1;

	String s_podia = "";
	String s_podia1 = "";
	String s_podia2 = "";
	String s_podia3 = "";
	String s_podia4 = "";

	private JLabel l_nayblujciPodii = new JLabel(
			"\u041D\u0430\u0439\u0431\u043B\u0438\u0436\u0447\u0456 \u043F\u043E\u0434\u0456\u0457:");
	private JLabel l_podia0 = new JLabel("");
	private JLabel l_podia1 = new JLabel("");
	private JLabel l_podia2 = new JLabel("");
	private JLabel l_podia3 = new JLabel("");
	private JLabel l_podia4 = new JLabel("");
	 
	public Planu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		Podii(i_Misatc, i_Chislo, indikator_zavtra);

		JButton b_menu = new JButton("\u041C\u0435\u043D\u044E");
		b_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu("");
				setVisible(false);
			}
		});
		b_menu.setBounds(395, 7, 89, 23);
		getContentPane().add(b_menu);

		JLabel l_vuvestu = new JLabel(
				"\u0412\u0438\u0432\u0435\u0441\u0442\u0438 \u043F\u043E\u0434\u0456\u0457 \u0437\u0430 \u0432\u043A\u0430\u0437\u0430\u043D\u0438\u043C \u0434\u043D\u0435\u043C:");
		l_vuvestu.setBounds(138, 303, 201, 14);
		getContentPane().add(l_vuvestu);

		JLabel l_misac = new JLabel("\u041C\u0456\u0441\u044F\u0446\u044C:");
		l_misac.setBounds(22, 335, 55, 14);
		getContentPane().add(l_misac);

		t_misac = new JTextField();
		t_misac.setBounds(93, 332, 55, 20);
		getContentPane().add(t_misac);
		t_misac.setColumns(10);

		JLabel l_cuslo = new JLabel("\u0427\u0438\u0441\u043B\u043E:");
		l_cuslo.setBounds(196, 335, 46, 14);
		getContentPane().add(l_cuslo);

		t_cuslo = new JTextField();
		t_cuslo.setBounds(267, 332, 55, 20);
		getContentPane().add(t_cuslo);
		t_cuslo.setColumns(10);

		JButton b_vuvestu = new JButton("\u0412\u0438\u0432\u0435\u0441\u0442\u0438");
		b_vuvestu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					i_misac = Integer.parseInt(t_misac.getText());
					i_cuslo = Integer.parseInt(t_cuslo.getText());

					indikator_zavtra = 0;
					if (i_misac > 0 || i_cuslo > 0 || i_cuslo <= 31 ||i_misac <= 12 ) {
						label_3.setBounds(0,0,0,0);
						Podii(i_misac, i_cuslo, indikator_zavtra);
					}else{
						JOptionPane.showMessageDialog(null, "Помилкове введення");
					}						
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Введіть дату");
				}
			}
		});
		b_vuvestu.setBounds(371, 331, 89, 23);
		getContentPane().add(b_vuvestu);

		
		l_nayblujciPodii.setBounds(20, 103, 144, 14);
		getContentPane().add(l_nayblujciPodii);
		l_podia0.setBounds(47, 135, 413, 23);
		getContentPane().add(l_podia0);
		l_podia1.setBounds(47, 169, 413, 23);
		getContentPane().add(l_podia1);
		l_podia2.setBounds(47, 203, 413, 23);
		getContentPane().add(l_podia2);
		l_podia3.setBounds(47, 236, 413, 23);
		getContentPane().add(l_podia3);
		l_podia4.setBounds(47, 269, 413, 23);
		getContentPane().add(l_podia4);
		
		label_3.setBounds(263, 68, 221, 14);
		getContentPane().add(label_3);
		label_2.setBounds(10, 68, 243, 14);
		getContentPane().add(label_2);
		
		l_podia0.setForeground(Color.BLUE);
		l_podia0.setFont(new Font("Serif", Font.BOLD | Font.CENTER_BASELINE, 15));	
		l_podia1.setForeground(Color.BLUE);
		l_podia1.setFont(new Font("Serif", Font.BOLD | Font.CENTER_BASELINE, 15));	
		l_podia2.setForeground(Color.BLUE);
		l_podia2.setFont(new Font("Serif", Font.BOLD | Font.CENTER_BASELINE, 15));
		l_podia3.setForeground(Color.BLUE);
		l_podia3.setFont(new Font("Serif", Font.BOLD | Font.CENTER_BASELINE, 15));
		l_podia4.setForeground(Color.BLUE);
		l_podia4.setFont(new Font("Serif", Font.BOLD | Font.CENTER_BASELINE, 15));
 
		label_1.setBounds(175, 30, 243, 27);
		label_1.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 20));
		label_1.setForeground(Color.YELLOW);
		getContentPane().add(label_1);
		
		// logo
				l_logo.setBounds(0, 0, 494, 372);
				getContentPane().add(l_logo);

		
		setVisible(true);
	}

	void Podii(int i_Misatc2, int i_Chislo2, int indikator_zavtra) {

		String[][] Reading = new String[1][9];
		String[][] Reading_zavtra = new String[1][9];
		int rizn = 0;
		int i_zavantajenist_dna = 0;
		int rizn_zavtra = 0;
		int i_zavantajenist_dna_zavtra = 0;
		String prioriti = "";
		String s_nazva = "";
		String p_podii = "";
		String k_podii = "";
		String prioriti_zavtra = "";
		String s_nazva_zavtra = "";
		String p_podii_zavtra = "";
		String k_podii_zavtra = "";
		String Perhapodiya = "";

		l_podia0.setText("");
		l_podia1.setText("");
		l_podia2.setText("");
		l_podia3.setText("");
		l_podia4.setText("");

		int mas = 6;

		File[] s_perevipka;
		int kilkistPodii = 0;
		File[] fList;
		String put0;

		String[] ss_Nazva = new String[mas];
		int[] ii_Pruoritet = new int[mas];
		String[] ss_Pocatok = new String[mas];
		String[] ss_Kinec = new String[mas];

		put0 = "dani/" + i_Misatc2 + "/" + i_Chislo2;
 
		F = new File(put0);
		fList = F.listFiles();
		s_perevipka = F.listFiles();

		try {
			if (s_perevipka == null) {
				i_zavantajenist_dna = 0;
				Perhapodiya = "Cьогодні подій немає";
			} else {
				for (int i1 = 0; i1 < F.listFiles().length; i1++) { //// сьогоднішній
																	//// день
					String put = put0 + "/" + fList[i1].getName();
					try {
						scn = new Scanner(new File(put));
					} catch (Exception e) {
						System.out.print("Error");
					}

					while (scn.hasNext()) {
						for (int row = 0; row < Reading.length; row++) {
							for (int col = 0; col < Reading[row].length; col++) {

								Reading[row][col] = scn.next();

								if (col == 3) {
									prioriti = scn.next();
									ii_Pruoritet[kilkistPodii] = Integer.parseInt(prioriti);
								}

								if (col == 4) {
									s_nazva = Reading[row][col];
									ss_Nazva[kilkistPodii] = s_nazva;
									kilkistPodii++;
								}
								if (col == 2) {
									p_podii = Reading[row][col]; // початок
																	// події
									ss_Pocatok[kilkistPodii] = p_podii;
								}
								if (col == 7) {
									k_podii = Reading[row][col]; // кінець події
									ss_Kinec[kilkistPodii - 1] = k_podii;
								}

								if (kilkistPodii == 1) {
									Perhapodiya = s_nazva;
								}
							}
						}
					}

					scn.close();

					int r1 = Integer.parseInt(p_podii);
					int r2 = Integer.parseInt(k_podii);
					int r3 = Integer.parseInt(prioriti);

					rizn = (r2 + 2) - r1;

					i_zavantajenist_dna = i_zavantajenist_dna + (rizn * r3);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Занадто перевантажений день");
		}

		///////////////////// //// завтрішній день
		if (indikator_zavtra == 1) {
			String put_zavtra = "dani/" + (i_Misatc2) + "/" + (i_Chislo2 + 1);

			File[] fList_zavtra;
			File F_zavtra = new File(put_zavtra);
			fList_zavtra = F_zavtra.listFiles();
			if (fList_zavtra == null) {
				i_zavantajenist_dna_zavtra = 0;
			} else {
				for (int i1 = 0; i1 < F_zavtra.listFiles().length; i1++) {
					String s_put_zavtra = "dani/" + (i_Misatc2) + "/" + (i_Chislo2 + 1) + "/"
							+ fList_zavtra[i1].getName();
					try {
						scn_zavtra = new Scanner(new File(s_put_zavtra));
					} catch (Exception e) {
						System.out.print("Error");
					}

					while (scn_zavtra.hasNext()) {
						for (int row = 0; row < Reading_zavtra.length; row++) {
							for (int col = 0; col < Reading_zavtra[row].length; col++) {

								Reading_zavtra[row][col] = scn_zavtra.next();

								if (col == 3) {
									prioriti_zavtra = scn_zavtra.next();
								}

								if (col == 2) {
									p_podii_zavtra = Reading_zavtra[row][col]; // початок
																				// події

								}
								if (col == 7) {
									k_podii_zavtra = Reading_zavtra[row][col]; // кінець
																				// події
								}

							}
						}
					}

					scn_zavtra.close();

					int r1 = Integer.parseInt(p_podii_zavtra);
					int r2 = Integer.parseInt(k_podii_zavtra);
					int r3 = Integer.parseInt(prioriti_zavtra);

					rizn_zavtra = (r2 + 2) - r1;

					i_zavantajenist_dna_zavtra = i_zavantajenist_dna_zavtra + (rizn_zavtra * r3);

				}
			}
		}
		////////////////////

		label = new JLabel("\u041D\u0430\u0439\u0431\u043B\u0438\u0436\u0447\u0430 \u043F\u043E\u0434\u0456\u044F");
		label.setBounds(196, 11, 128, 14);
		getContentPane().add(label);

		label_1.setText(Perhapodiya);
		 
		s_zavantagenistDna = "\u0417\u0430\u0432\u0430\u043D\u0442\u0430\u0436\u0435\u043D\u0456\u0441\u0442\u044C \u0441\u044C\u043E\u0433\u043E\u0434\u043D\u0456\u0448\u043D\u044C\u043E\u0433\u043E \u0434\u043D\u044F "
				+ i_zavantajenist_dna;
		label_2.setText(s_zavantagenistDna);

		s_zavantagenistDna1 = "\u0417\u0430\u0432\u0430\u043D\u0442\u0430\u0436\u0435\u043D\u0456\u0441\u0442\u044C \u0437\u0430\u0432\u0442\u0440\u0456\u0448\u043D\u044C\u043E\u0433\u043E \u0434\u043D\u044F "
				+ i_zavantajenist_dna_zavtra;
		label_3.setText(s_zavantagenistDna1);
	

		if (s_perevipka != null) {
 
			switch (kilkistPodii) {
			case 1: {
				s_podia = "Назва: " + ss_Nazva[0] + "  Приорітет: " + ii_Pruoritet[0] + "   Початок o: " + ss_Pocatok[0]
						+ "   Кінець o: " + ss_Kinec[0];
				l_podia0.setText(s_podia);

			}
				break;
			case 2: {
				s_podia = "Назва: " + ss_Nazva[0] + "  Приорітет: " + ii_Pruoritet[0] + "   Початок o: " + ss_Pocatok[0]
						+ "   Кінець o: " + ss_Kinec[0];

				s_podia1 = "Назва: " + ss_Nazva[1] + "  Приорітет: " + ii_Pruoritet[1] + "   Початок o: "
						+ ss_Pocatok[1] + "   Кінець o: " + ss_Kinec[1];
				l_podia0.setText(s_podia);
				l_podia1.setText(s_podia1);

			}
				break;
			case 3: {
				s_podia = "Назва: " + ss_Nazva[0] + "  Приорітет: " + ii_Pruoritet[0] + "   Початок o: " + ss_Pocatok[0]
						+ "   Кінець o: " + ss_Kinec[0];

				s_podia1 = "Назва: " + ss_Nazva[1] + "  Приорітет: " + ii_Pruoritet[1] + "   Початок o: "
						+ ss_Pocatok[1] + "   Кінець o: " + ss_Kinec[1];

				s_podia2 = "Назва: " + ss_Nazva[2] + "  Приорітет: " + ii_Pruoritet[2] + "   Початок o: "
						+ ss_Pocatok[2] + "   Кінець o: " + ss_Kinec[2];
				l_podia0.setText(s_podia);
				l_podia1.setText(s_podia1);
				l_podia2.setText(s_podia2);

			}
				break;
			case 4: {
				s_podia = "Назва: " + ss_Nazva[0] + "  Приорітет: " + ii_Pruoritet[0] + "   Початок o: " + ss_Pocatok[0]
						+ "   Кінець o: " + ss_Kinec[0];

				s_podia1 = "Назва: " + ss_Nazva[1] + "  Приорітет: " + ii_Pruoritet[1] + "   Початок o: "
						+ ss_Pocatok[1] + "   Кінець o: " + ss_Kinec[1];

				s_podia2 = "Назва: " + ss_Nazva[2] + "  Приорітет: " + ii_Pruoritet[2] + "   Початок o: "
						+ ss_Pocatok[2] + "   Кінець o: " + ss_Kinec[2];

				s_podia3 = "Назва: " + ss_Nazva[3] + "  Приорітет: " + ii_Pruoritet[3] + "   Початок o: "
						+ ss_Pocatok[3] + "   Кінець o: " + ss_Kinec[3];
				l_podia0.setText(s_podia);
				l_podia1.setText(s_podia1);
				l_podia2.setText(s_podia2);
				l_podia3.setText(s_podia3);

			}
				break;
			default: {
				s_podia = "Назва: " + ss_Nazva[0] + "  Приорітет: " + ii_Pruoritet[0] + "   Початок o: " + ss_Pocatok[0]
						+ "   Кінець o: " + ss_Kinec[0];

				s_podia1 = "Назва: " + ss_Nazva[1] + "  Приорітет: " + ii_Pruoritet[1] + "   Початок o: "
						+ ss_Pocatok[1] + "   Кінець o: " + ss_Kinec[1];

				s_podia2 = "Назва: " + ss_Nazva[2] + "  Приорітет: " + ii_Pruoritet[2] + "   Початок o: "
						+ ss_Pocatok[2] + "   Кінець o: " + ss_Kinec[2];

				s_podia3 = "Назва: " + ss_Nazva[3] + "  Приорітет: " + ii_Pruoritet[3] + "   Початок o: "
						+ ss_Pocatok[3] + "   Кінець o: " + ss_Kinec[3];

				s_podia4 = "Назва: " + ss_Nazva[4] + "  Приорітет: " + ii_Pruoritet[4] + "   Початок o: "
						+ ss_Pocatok[4] + "   Кінець o: " + ss_Kinec[4];

				l_podia0.setText(s_podia);
				l_podia1.setText(s_podia1);
				l_podia2.setText(s_podia2);
				l_podia3.setText(s_podia3);
				l_podia4.setText(s_podia4);
			}
				break;

			}
 
		}

	}
}