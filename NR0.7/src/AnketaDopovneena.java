import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class AnketaDopovneena extends JFrame{

	
		JFrame anketaDopovneena = new JFrame("Тайм-менеджмент 0.5 Доповнення до анкети");
	
//	AnketaDopovneena anketaDopovneena =	new AnketaDopovneena("РџР»Р°РЅСѓРІР°РЅРЅСЏ 0.1 РћРґРЅРѕС‡Р°СЃРЅС– РїРѕРґС–С—", Reading1 , Reading2, fps);

		JButton  Yes , No ;
	JLabel Comentar , Comentar1 ,Comentar2, Comentar3, Comentar4,Comentar5,  Pusto;
	
	
    int type2 = JOptionPane.WARNING_MESSAGE;
	
	 int	Prioriti , f ; 
	 public Formatter x ;
		String Fayl ;
		
		 public Formatter k ;
		 int st_int;
		 String st  ;
		 static Scanner sc_k ;
		
	  eHandler handler = new eHandler();


			int i_MisatcZ;
			int i_ChisloZ;
			int i_GodunuZ;
			int i_HvulunuZ;
			int i_Misatc1Z;
			int i_Chislo1Z;
			int i_Godunu1Z;
			int i_Hvulunu1Z;
			int fps1Z;
			String s_NazvaZ;

			String Re1, Re2  ;


	  public AnketaDopovneena(String s , String Reading1 , String Reading2 , int fps , String s_Nazva , int  i_Misatc,
			  int i_Chislo,int i_Godunu,int i_Hvulunu,int i_Misatc1,int i_Chislo1,int i_Godunu1,int i_Hvulunu1 , int fps1) {
		  
            super(s);
            
            i_MisatcZ =i_Misatc;
            i_ChisloZ= i_Chislo ;
            i_GodunuZ =i_Godunu ;
            i_HvulunuZ= i_Hvulunu ;
            i_Misatc1Z=i_Misatc1 ;
            i_Chislo1Z = i_Chislo1 ;
            i_Godunu1Z=i_Godunu1 ;
            i_Hvulunu1Z =i_Hvulunu1 ;
            fps1Z = fps1 ;
            s_NazvaZ = s_Nazva ;
            
   
         Re1 = Reading1;
         Re2 = Reading2 ; 
         
	       	  anketaDopovneena.setVisible(true);
	   //   	  anketaDopovneena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      anketaDopovneena.setSize(300, 200);
		      anketaDopovneena.setResizable(false);
		      anketaDopovneena.setLocationRelativeTo(null);
					
		          Yes = new JButton("Так");
		          No = new JButton("Ні");
       
		          Comentar = new JLabel("На даний момент уже заплановано подію");
		          Comentar1 = new JLabel("Її назва: \"" + Re2+ " \"");
		          Comentar2 = new JLabel("Її приорітет: "+Re1);
		          Comentar3 = new JLabel("Бажаєте замінати подію?");
		          
		          Comentar4 = new JLabel("Увага! Ви намагаєтесь замінати");
		          Comentar5 = new JLabel("подію із більшим приортетом.");
		               

		          StringBuilder z = new StringBuilder(Reading1);
		              z.deleteCharAt(0);
		          String ans = z.toString();
		      
 	            Prioriti = Integer.parseInt(ans);    		     
		
          
          Yes.setBounds(30,120,100,40);
          No.setBounds(180,120,100,40);   
          
          Comentar.setBounds(20,5,280,20);
          Comentar1.setBounds(20,20,250,20);   
          Comentar2.setBounds(20,35,250,20);   
          Comentar3.setBounds(20,50,250,20);   
          
          Comentar4.setBounds(0,0,0,0);          
          Comentar5.setBounds(0,0,0,0);   
          
         if(Prioriti > fps){
          Comentar4.setBounds(50,75,250,20);          
          Comentar5.setBounds(70,90,250,20);   
          }          
          
        
          Pusto = new JLabel("");
          
          Pusto.setBounds(10,10,10,10);
                    
          anketaDopovneena.add(Yes);
          anketaDopovneena.add(No);
          anketaDopovneena.add(Comentar);
          anketaDopovneena.add(Comentar1);
          anketaDopovneena.add(Comentar2);
          anketaDopovneena.add(Comentar3);
          anketaDopovneena.add(Comentar4);
          anketaDopovneena.add(Comentar5);
          
          anketaDopovneena.add(Pusto);
   
	            		  
          Yes.addActionListener(handler);
          No.addActionListener(handler);
      
	  }
	  
	  public class eHandler  implements ActionListener{
			public void actionPerformed(ActionEvent e) {
	            try { 
	            	  if (e.getSource() == Yes) {
	            		  
	            		  Fayl = "dani/"+i_MisatcZ+"/"+i_ChisloZ+"/"+i_GodunuZ+"."+i_HvulunuZ+".txt";
	            
	            		    
	            			x = new Formatter(Fayl);
							x.format(i_MisatcZ + " "+ i_ChisloZ + " " + i_GodunuZ + " "+ i_HvulunuZ + " " + fps1Z+ " " +  s_NazvaZ +" "+i_Misatc1Z + " "+ i_Chislo1Z + " " + i_Godunu1Z + " "+ i_Hvulunu1Z );
							x.close();
							JOptionPane.showMessageDialog(null,	"Дані збережено", null, type2);
	            		  
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
								
							k = new Formatter("dani/кількість всіх подій.txt");            
							k.format(st);
							k.close();
							
							  anketaDopovneena.setVisible(false);
	                  }
	            	
	            	  if (e.getSource() == No) {
	            		  anketaDopovneena.setVisible(false);
	            		
	                  }  
	            	  

	            	} catch (Exception ex) {
	            }
	            //    JOptionPane.showMessageDialog(null, "Р’Р’РµРґС–С‚СЊ  РґР°РЅС–");
	            }
	        }

}