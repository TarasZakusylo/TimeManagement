import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Anketa extends JFrame{
	
	  JFrame anketa = new JFrame("Тайм-менеджмент 0.5 Анкета");
	
	JButton Pereglad , Zberegtu, Ochustutu1 , Menu;
	JLabel l_NazvaPodii , l_Chas  , l_Data , l_Znak1 , l_Znak2 ,l_Znak1_1 , l_Znak2_2 , l_Pruklad,l_Prioriti,l_Ramka1,l_Ramka2, Pusto ;
	JTextField t_Nazva , t_Misatc , t_Chislo , t_Godunu , t_Hvulunu, t_Prioriti;
	JTextField  t_Misatc1 , t_Chislo1 , t_Godunu1 , t_Hvulunu1;
	JLabel l_Komentar1 , l_Komentar2 , l_Komentar3,l_Zaverhenna; 
	
	JLabel l_vilnuy, l_vilnuy_nema , l_vilnuy_nema1, l_vilnuy1,l_vilnuy2,l_vilnuy3,l_vilnuy4,l_vilnuy5,l_vilnuy6 
	,l_vilnuy7 ,l_vilnuy8 ,l_vilnuy9 ,l_vilnuy10 ,l_vilnuy11 ,l_vilnuy12 ,l_vilnuy13 ,l_vilnuy14 ,l_vilnuy15 ,l_vilnuy16 
	,l_vilnuy17 ,l_vilnuy18 ,l_vilnuy19 , l_Komentar_vilnuy;
	
	String s_Nazva , s_Misatc , s_Chislo , s_Godunu , s_Hvulunu;
	String s_Misatc1 , s_Chislo1 , s_Godunu1 , s_Hvulunu1;
	int   i_Misatc , i_Chislo , i_Godunu , i_Hvulunu;  
	int   i_Misatc1 , i_Chislo1 , i_Godunu1 , i_Hvulunu1;  
	
	String Fayl ;
	 String [][] Reading = new String [1][9] ;
	 String Reading1 ;
	 String Reading2 ;
	
	 JSlider sl = new JSlider( 0, 1 ,5 , 1);
	 int fps =1 ;
	 
	 public Formatter x ;
	 public Formatter k ;
	 
	 String st  ;
	 int st_int;
	 String st1 ;
	 static Scanner scn ;
	 static Scanner sc_k ;
	 
	 	 
	    int type1 = JOptionPane.ERROR_MESSAGE;  //  Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ
	    int type2 = JOptionPane.WARNING_MESSAGE;
	 
	eHandler handler = new eHandler();
	
	SliderListener slider = new SliderListener();
	
	 public Anketa (String s) {
		super(s);
		
		     anketa.setVisible(true);
		     anketa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     anketa.setSize(500, 400);
		     anketa.setResizable(false);
		     anketa.setLocationRelativeTo(null);
	
	    Pusto = new JLabel("");
        Pusto.setBounds(10,10,10,10);
		
		Pereglad = new JButton("Зайнятий час");
		Zberegtu = new JButton("Зберегти");
        Ochustutu1 = new JButton("Очистити");
        Menu = new JButton("Меню");
		
     		  l_vilnuy = new JLabel("");
     		  l_vilnuy_nema1 = new JLabel("");
     		  l_vilnuy_nema = new JLabel("");
     		  l_vilnuy1 = new JLabel("");
     		  l_vilnuy2 = new JLabel("");
     		  l_vilnuy3 = new JLabel("");
     		  l_vilnuy4 = new JLabel("");
     		  l_vilnuy5 = new JLabel("");
     		  l_vilnuy6 = new JLabel("");
     		  l_vilnuy7 = new JLabel("");
    		  l_vilnuy8 = new JLabel("");
    		  l_vilnuy9 = new JLabel("");
    		  l_vilnuy10 = new JLabel("");
    		  l_vilnuy11 = new JLabel("");
    		  l_vilnuy12 = new JLabel("");
    		  l_vilnuy13 = new JLabel("");
     		  l_vilnuy14 = new JLabel("");
     		  l_vilnuy15 = new JLabel("");
     		  l_vilnuy16 = new JLabel("");
     		  l_vilnuy17 = new JLabel("");
     		  l_vilnuy18 = new JLabel("");
     		  l_vilnuy19 = new JLabel("");
     		
     		 l_Komentar_vilnuy = new JLabel("За датою та числом");
        
		l_NazvaPodii = new JLabel("Назва події:");
		l_Chas = new JLabel("Час початку події:");
		l_Data = new JLabel("Дата події:");
		l_Znak1 = new JLabel("/");
		l_Znak2 = new JLabel(":");
		l_Znak1_1 = new JLabel("/");
		l_Znak2_2 = new JLabel(":");
		l_Pruklad = new JLabel("Наприклад: 04/25  22:00");
		l_Zaverhenna = new JLabel("Вкажіть приблизний час завершення:");
		l_Prioriti = new JLabel("Оцініть приорітет події (від 1 до 5):");
		l_Komentar1 = new JLabel("Якщо не вказати,");
		l_Komentar2 = new JLabel("то буде зазначено");
		l_Komentar3 = new JLabel("мінімальне значення.");
		
	  
	
		l_Ramka1 = new JLabel("  ");
		l_Ramka1.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createEtchedBorder(),"Обов'язково",TitledBorder.RIGHT,TitledBorder.TOP,
				new Font("Times New Roman", Font.ITALIC,13),Color.green));
		
		l_Ramka2 = new JLabel("  ");
		l_Ramka2.setBorder(BorderFactory.createTitledBorder(BorderFactory.
				createEtchedBorder(),"Не обов'язково",TitledBorder.RIGHT,TitledBorder.TOP,
				new Font("Times New Roman", Font.ITALIC,13),Color.blue));
		
		
		//  Р±С–РіСѓРЅРѕРє
		sl.setMajorTickSpacing(5);
		sl.setMinorTickSpacing(1);
		sl.setPaintTicks(true);
		sl.setPaintLabels(true);
		sl.setLabelTable(sl.createStandardLabels(2,1));
		
		sl.setBounds(35,225,235,40);
		 anketa.add(sl);
		
		t_Nazva = new JTextField ("назва");
		t_Misatc = new JTextField ();
		t_Chislo = new JTextField ();
		t_Godunu = new JTextField ();
		t_Hvulunu = new JTextField ();
		t_Misatc1 = new JTextField ();
		t_Chislo1= new JTextField ();
		t_Godunu1 = new JTextField ();
		t_Hvulunu1 = new JTextField ();
		
		Pereglad.setBounds(320,80,150,40);
		Zberegtu.setBounds(23,323,133,30);
	    Menu.setBounds(320,30,150,40);
	    Ochustutu1.setBounds(156,323,131,30);  
		
		l_NazvaPodii.setBounds(95,5,130,20);
		l_Data.setBounds(45,50,130,20);
		l_Chas.setBounds(150,50,150,20);
		l_Znak1.setBounds(88,75,130,20);
		l_Znak2.setBounds(213,75,130,20);
		l_Znak1_1.setBounds(88,150,130,20);
		l_Znak2_2.setBounds(213,150,130,20);
		l_Pruklad.setBounds(65,100,260,20);
		l_Zaverhenna.setBounds(21,125,270,20);
		l_Prioriti.setBounds(25,195,260,20);
		l_Komentar1.setBounds(120,265,260,20);
		l_Komentar2.setBounds(120,280,260,20);
		l_Komentar3.setBounds(120,295,260,20);
		
		l_Ramka1.setBounds(20,0,270,180);
		l_Ramka2.setBounds(20,185,270,140);
		
		t_Nazva.setBounds(70,25,160,25);
		t_Misatc.setBounds(35,75,50,25);
		t_Chislo.setBounds(95,75,50,25);
		t_Godunu.setBounds(160,75,50,25);
		t_Hvulunu.setBounds(220,75,50,25);
		t_Misatc1.setBounds(35,150,50,25);
		t_Chislo1.setBounds(95,150,50,25);
		t_Godunu1.setBounds(160,150,50,25);
		t_Hvulunu1.setBounds(220,150,50,25);
		
				 
		 anketa.add(Pereglad);
		 anketa.add(Zberegtu);
		 anketa.add(Ochustutu1);
		 anketa.add(Menu);
		
		 anketa.add(l_NazvaPodii);
		 anketa.add(l_Chas);
		 anketa.add(l_Data);
		 anketa.add(l_Znak1);
		 anketa.add(l_Znak2);
		 anketa.add(l_Znak1_1);
		 anketa.add(l_Znak2_2);
		 anketa.add(l_Pruklad);
		 anketa.add(l_Zaverhenna);
		 anketa.add(l_Prioriti);
		 anketa.add(l_Komentar1);
		 anketa.add(l_Komentar2);
		 anketa.add(l_Komentar3);
		 	 
		 
		 l_Komentar_vilnuy.setBounds(320,110,150,30);
		  anketa.add(l_Komentar_vilnuy);
		 	  
		  l_vilnuy.setBounds(335,140,150,40);
		  anketa.add(l_vilnuy);
		  l_vilnuy1.setBounds(335,160,150,40);
		  anketa.add(l_vilnuy1);
				  l_vilnuy_nema.setBounds(330,140,150,40);
				  anketa.add(l_vilnuy_nema);
				  l_vilnuy_nema1.setBounds(345,160,150,40);
				  anketa.add(l_vilnuy_nema1);
		  l_vilnuy2.setBounds(335,180,150,40);
		  anketa.add(l_vilnuy2);
		  l_vilnuy3.setBounds(335,200,150,40);
		  anketa.add(l_vilnuy3);
		  l_vilnuy4.setBounds(335,220,150,40);
		  anketa.add(l_vilnuy4);
		  l_vilnuy5.setBounds(335,240,150,40);
		  anketa.add(l_vilnuy5);
		  l_vilnuy6.setBounds(335,260,150,40);
		  anketa.add(l_vilnuy6);
		  		  
		  l_vilnuy7.setBounds(335,280,150,40);
		  anketa.add(l_vilnuy7);
		  l_vilnuy8.setBounds(335,300,150,40);
		  anketa.add(l_vilnuy8);
		  l_vilnuy9.setBounds(335,320,150,40);
		  anketa.add(l_vilnuy9);
		  l_vilnuy10.setBounds(405,140,150,40);
		  anketa.add(l_vilnuy10);
		  l_vilnuy11.setBounds(405,160,150,40);
		  anketa.add(l_vilnuy11);
		  l_vilnuy12.setBounds(405,180,150,40);
		  anketa.add(l_vilnuy12);
		  l_vilnuy13.setBounds(405,200,150,40);
		  anketa.add(l_vilnuy13);
		  l_vilnuy14.setBounds(405,220,150,40);
		  anketa.add(l_vilnuy14);
		  l_vilnuy15.setBounds(405,240,150,40);
		  anketa.add(l_vilnuy15);
		  l_vilnuy16.setBounds(405,260,150,40);
		  anketa.add(l_vilnuy16);
		  l_vilnuy17.setBounds(405,280,150,40);
		  anketa.add(l_vilnuy17);
		  l_vilnuy18.setBounds(405,300,150,40);
		  anketa.add(l_vilnuy18);
		  l_vilnuy19.setBounds(405,320,150,40);
		  anketa.add(l_vilnuy19);
		   
		  
		  
		 anketa.add(t_Nazva);
		 anketa.add(t_Misatc);
		 anketa.add(t_Chislo);
		 anketa.add(t_Godunu);
		 anketa.add(t_Hvulunu);

		 anketa.add(t_Misatc1);
		 anketa.add(t_Chislo1);
		 anketa.add(t_Godunu1);
		 anketa.add(t_Hvulunu1);
		
		 anketa.add(l_Ramka1);
		 anketa.add(l_Ramka2);
		 
		  
		 anketa.add(Pusto);
	
		sl.addChangeListener(slider);
		
		Menu.addActionListener(handler);
		Zberegtu.addActionListener(handler);
		Ochustutu1.addActionListener(handler);
		Pereglad.addActionListener(handler);
			
	 }		
	 
	 
	 	void obnulutu () {
	 		    l_vilnuy_nema.setText(null);
	            l_vilnuy_nema1.setText(null);
	       		l_vilnuy.setText(null);
				l_vilnuy1.setText(null);
				l_vilnuy2.setText(null);
				l_vilnuy3.setText(null);
				l_vilnuy4.setText(null);
				l_vilnuy5.setText(null);
				l_vilnuy6.setText(null);
				l_vilnuy7.setText(null);
				l_vilnuy8.setText(null);
				l_vilnuy9.setText(null);
				l_vilnuy10.setText(null);
				l_vilnuy11.setText(null);
				l_vilnuy12.setText(null);
				l_vilnuy13.setText(null);
				l_vilnuy14.setText(null);
				l_vilnuy15.setText(null);
				l_vilnuy16.setText(null);
				l_vilnuy17.setText(null);
				l_vilnuy18.setText(null);
				l_vilnuy19.setText(null);
		}
	 	
	 	void chustka (){
	 		t_Nazva.setText("назва");
			t_Misatc.setText(null);
			t_Chislo.setText(null);
			t_Godunu.setText(null);
			t_Hvulunu.setText(null);
			t_Misatc1.setText(null);
			t_Chislo1.setText(null);
			t_Godunu1.setText(null);
			t_Hvulunu1.setText(null);

	 	}
	 	
		class SliderListener implements ChangeListener {
		    public void stateChanged(ChangeEvent e) {
		       sl = (JSlider)e.getSource();
		           fps = (int)sl.getValue();	     
		    } 
	 }	
		public class eHandler implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				try {
					if (e.getSource() == Zberegtu) {
						
						
						s_Nazva = t_Nazva.getText();
						s_Misatc = t_Misatc.getText();
						s_Chislo = t_Chislo.getText();
						s_Godunu = t_Godunu.getText();
						s_Hvulunu = t_Hvulunu.getText();
						s_Misatc1 = t_Misatc1.getText();
						s_Chislo1 = t_Chislo1.getText();
						s_Godunu1 = t_Godunu1.getText();
						s_Hvulunu1 = t_Hvulunu1.getText();
						
											
						i_Misatc  = Integer.parseInt(s_Misatc);
						i_Chislo  = Integer.parseInt(s_Chislo);
						i_Godunu  = Integer.parseInt(s_Godunu);
						i_Hvulunu = Integer.parseInt(s_Hvulunu);
						i_Misatc1  = Integer.parseInt(s_Misatc1);
						i_Chislo1  = Integer.parseInt(s_Chislo1);
						i_Godunu1  = Integer.parseInt(s_Godunu1);
						i_Hvulunu1 = Integer.parseInt(s_Hvulunu1);
						
					
						
							if ( i_Misatc >= 1 && i_Misatc <= 12 && i_Chislo >= 1 && i_Chislo <=31 &&
									i_Godunu >=0 && i_Godunu <= 23 && i_Hvulunu >= 0 && i_Hvulunu <= 59 && i_Misatc1 >= 1 && i_Misatc1 <= 12 && i_Chislo1 >= 1 && i_Chislo1 <=31 &&
									i_Godunu1 >=0 && i_Godunu1 <= 23 && i_Hvulunu1 >= 0 && i_Hvulunu1 <= 59) {		
								
								
						                  	String	sogodni ;  
						    	            sogodni = i_Misatc+"/"+ i_Chislo;
						    						    File myPath = new File ("dani/"+sogodni);            //  СЃС‚РІРѕСЂРµРЅРЅСЏ РїР°РїРєРё
													//  myPath.mkdir();
													    myPath.mkdirs(); 
													    
						Fayl = "dani/" + i_Misatc + "/" + i_Chislo + "/"
								+ i_Godunu + "." + i_Hvulunu + ".txt";
						File file = new File(Fayl);

						if (file.exists()) { // СЏРєС‰Рѕ С„Р°Р№Р»Сѓ РЅРµРјР° / С”, С‚Рѕ Р№РѕРіРѕ
												// СЃС‚РІРѕСЂРёС‚СЊ
							// file.createNewFile(); // СЃС‚РІРѕСЂРµРЅРЅСЏ С„Р°Р№Р»Сѓ
							try {
								scn = new Scanner(new File(Fayl));
							} catch (Exception ez) {
								JOptionPane.showMessageDialog(null, " Помилка файлу");
							}

							while (scn.hasNext()) {
								for (int row = 0; row < Reading.length; row++) {
									Reading1 = " ";
									Reading2 = " ";
									for (int col = 0; col < Reading[row].length; col++) {

										Reading[row][col] = scn.next();
										if (col == 3) {
											Reading1 = Reading1 + scn.next();
										}
										if (col == 4) {
											Reading2 = Reading2+ Reading[row][col];
										}
									}
								}
							}

							int fps1 = fps;
							scn.close();
							new AnketaDopovneena(
									"Тайм-менеджмент 0.5 Узгодження", Reading1,
									Reading2, fps, s_Nazva, i_Misatc, i_Chislo,
									i_Godunu, i_Hvulunu, i_Misatc1, i_Chislo1,
									i_Godunu1, i_Hvulunu1, fps1);

		            		  

						} else {
							x = new Formatter(Fayl);
							x.format(i_Misatc + " " + i_Chislo + " " + i_Godunu
									+ " " + i_Hvulunu + " " + fps + " "
									+ s_Nazva + " " + i_Misatc1 + " "
									+ i_Chislo1 + " " + i_Godunu1 + " "
									+ i_Hvulunu1);
							x.close();
							

							try {
								sc_k = new Scanner(new File("dani/кількість всіх подій.txt"));
							} catch (Exception ez) {
								JOptionPane.showMessageDialog(null, "Помилка відкриття файлу кількості всіх подій");
							}
							
							while (sc_k.hasNext()) {
										st = sc_k.next();				
							}
								sc_k.close();
								
								st_int = Integer.parseInt(st);
								st_int++;
								st = ""+ st_int;
								
							k = new Formatter("dani/кількість всіх подій.txt");           // СЃС‡СЊРѕС‚С‡РёРє
							k.format(st);
							k.close();
						
							
							JOptionPane.showMessageDialog(null,
									"Подія збережена", null, type2);

					         	chustka();
						}

					} else {
						JOptionPane.showMessageDialog(null, "Error", null,	type1);
								}
				
					}

					if (e.getSource() == Ochustutu1) {					
						   chustka();						
						   obnulutu();
							
	       			}

					if (e.getSource() == Pereglad) {					
											
						
						 obnulutu();
						
						
						s_Misatc = t_Misatc.getText();
						s_Chislo = t_Chislo.getText();
									
						i_Misatc  = Integer.parseInt(s_Misatc);
						i_Chislo  = Integer.parseInt(s_Chislo);		

						 String vuvid =  ""; 
						 String vuvid1 = ""; 
						 String vuvid2=  ""; 
						 String vuvid3 = ""; 
						 String vuvid4=  ""; 
						 String vuvid5 = ""; 
						 String vuvid6 = ""; 
						 String vuvid7 =  ""; 
						 String vuvid8 =  ""; 
						 String vuvid9 =  ""; 
						 String vuvid10 =  ""; 
						 String vuvid11 =  ""; 
						 String vuvid12 =  ""; 
						 String vuvid13 =  ""; 
						 String vuvid14 =  ""; 
						 String vuvid15 =  ""; 
						 String vuvid16 =  ""; 
						 String vuvid17 =  ""; 
						 String vuvid18 =  ""; 
						 String vuvid19 =  ""; 

						 
							int kk =0;
							
												
							if (i_Misatc >= 1 && i_Misatc <= 12 && i_Chislo >= 1 && i_Chislo <=31 ) {		
								
								
								for (int i = 0; i < 24; i++) {
									for (int j = 0; j < 60; j++) {
										String put = "dani/" + i_Misatc + "/"+ i_Chislo + "/" + i + "." + j + ".txt";
										File file = new File(put);
		
										if (file.exists()) {
											kk++;
													switch(kk){
													case 1:
														vuvid = vuvid  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 2:
														vuvid1 = vuvid1  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 3:
														vuvid2 = vuvid2  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 4:
														vuvid3 = vuvid3  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 5:
														vuvid4 = vuvid4  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 6:
														vuvid5 = vuvid5  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 7:
														vuvid6 = vuvid6  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 8:
														vuvid7 = vuvid7  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 9:
														vuvid8 = vuvid8  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 10:
														vuvid9 = vuvid9  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 11:
														vuvid10 = vuvid10  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 12:
														vuvid11 = vuvid11  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 13:
														vuvid12 = vuvid12  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 14:
														vuvid13 = vuvid13  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 15:
														vuvid14 = vuvid14  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 16:
														vuvid15= vuvid15  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 17:
														vuvid16 = vuvid16  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 18:
														vuvid17 = vuvid17  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 19:
														vuvid18 = vuvid18  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
													case 20:
														vuvid19 = vuvid19  + i_Misatc + "/" + i_Chislo + "  " + i + ":" + j;
														break;
												   	default: 
														JOptionPane.showMessageDialog(null, "Даний день є дуууже завантаженим.", null,	type1);
														i = 70;
														j=70;
														break;
												}
													
										
												
													
										}
									}
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

						
								
						         if (kk==0){
						        	 String nema =      "На даний день";
						        		String nema1 =	"подій немає";
						        	 l_vilnuy_nema.setText(nema);
						        	 l_vilnuy_nema1.setText(nema1);
						         }
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Error", null,	type1);
								}
								
				
						
					}

					if (e.getSource() == Menu) {
		            	new Menu("");
		            	 anketa.setVisible(false);
					}
					
				
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Введіть дані",null,type1);
					}
			}
		
		}	
	
	}
