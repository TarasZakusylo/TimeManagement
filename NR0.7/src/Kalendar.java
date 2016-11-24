import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


 class Kalendar extends JFrame {
	 
 
		JFrame kalendar = new JFrame("Тайм-менеджмент 0.5 Календар");
	 
	 JButton Vpered, Nazad,Sogodni , Menu;
	 JLabel Pusto;
   	 
   	   eHandler handler = new eHandler();
   	   
	   Calendar calendar = Calendar.getInstance();
   	    int month = calendar.get(calendar.MONTH)+1;
    
    
   	    
   	     ImageIcon i_sichen2015 = new ImageIcon("res/Kalendar2015/Sichen.JPG");
	   	 JLabel l_sichen2015 = new JLabel(i_sichen2015);
		 ImageIcon i_lytuy2015 = new ImageIcon("res/Kalendar2015/Lytuy.JPG");
	   	 JLabel l_lytuy2015 = new JLabel(i_lytuy2015);
	   	 ImageIcon i_berezen2015 = new ImageIcon("res/Kalendar2015/Berezen.JPG");
	   	 JLabel l_berezen2015 = new JLabel(i_berezen2015);
	   	 ImageIcon i_kviten2015 = new ImageIcon("res/Kalendar2015/Kviten.JPG");
	   	 JLabel l_kviten2015 = new JLabel(i_kviten2015);
	   	 ImageIcon i_traven2015= new ImageIcon("res/Kalendar2015/Traven.JPG");
	  	 JLabel l_traven2015 = new JLabel(i_traven2015);
		 ImageIcon i_cherven2015 = new ImageIcon("res/Kalendar2015/Cherven.JPG");
	   	 JLabel l_cherven2015 = new JLabel(i_cherven2015);
		 ImageIcon i_lupen2015 = new ImageIcon("res/Kalendar2015/Lupen.JPG");
	   	 JLabel l_lupen2015 = new JLabel(i_lupen2015);
	   	 ImageIcon i_serpen2015 = new ImageIcon("res/Kalendar2015/Serpen.JPG");
	  	 JLabel l_serpen2015 = new JLabel(i_serpen2015);
	  	 ImageIcon i_veresen2015 = new ImageIcon("res/Kalendar2015/Veresen.JPG");
	  	 JLabel l_veresen2015 = new JLabel(i_veresen2015);
		 ImageIcon i_jovten2015 = new ImageIcon("res/Kalendar2015/Jovten.JPG");
	  	 JLabel l_jovten2015 = new JLabel(i_jovten2015);
		 ImageIcon i_lustopad2015 = new ImageIcon("res/Kalendar2015/Lustopad.JPG");
	  	 JLabel l_lustopad2015 = new JLabel(i_lustopad2015);
		 ImageIcon i_gruden2015 = new ImageIcon("res/Kalendar2015/Gruden.JPG");
	  	 JLabel l_gruden2015 = new JLabel(i_gruden2015);
	  	 
	  	 ImageIcon i_sichen2016 = new ImageIcon("res/Kalendar2016/Sichen.JPG");
	   	 JLabel l_sichen2016 = new JLabel(i_sichen2016);
		 ImageIcon i_lytuy2016 = new ImageIcon("res/Kalendar2016/Lytuy.JPG");
	   	 JLabel l_lytuy2016 = new JLabel(i_lytuy2016);
	   	 ImageIcon i_berezen2016 = new ImageIcon("res/Kalendar2016/Berezen.JPG");
	   	 JLabel l_berezen2016 = new JLabel(i_berezen2016);
	   	 ImageIcon i_kviten2016 = new ImageIcon("res/Kalendar2016/Kviten.JPG");
	   	 JLabel l_kviten2016 = new JLabel(i_kviten2016);
	   	 ImageIcon i_traven2016= new ImageIcon("res/Kalendar2016/Traven.JPG");
	  	 JLabel l_traven2016 = new JLabel(i_traven2016);
		 ImageIcon i_cherven2016 = new ImageIcon("res/Kalendar2016/Cherven.JPG");
	   	 JLabel l_cherven2016 = new JLabel(i_cherven2016);
		 ImageIcon i_lupen2016 = new ImageIcon("res/Kalendar2016/Lupen.JPG");
	   	 JLabel l_lupen2016 = new JLabel(i_lupen2016);
	   	 ImageIcon i_serpen2016 = new ImageIcon("res/Kalendar2016/Serpen.JPG");
	  	 JLabel l_serpen2016 = new JLabel(i_serpen2016);
	  	 ImageIcon i_veresen2016 = new ImageIcon("res/Kalendar2016/Veresen.JPG");
	  	 JLabel l_veresen2016 = new JLabel(i_veresen2016);
		 ImageIcon i_jovten2016 = new ImageIcon("res/Kalendar2016/Jovten.JPG");
	  	 JLabel l_jovten2016 = new JLabel(i_jovten2016);
		 ImageIcon i_lustopad2016 = new ImageIcon("res/Kalendar2016/Lustopad.JPG");
	  	 JLabel l_lustopad2016 = new JLabel(i_lustopad2016);
		 ImageIcon i_gruden2016 = new ImageIcon("res/Kalendar2016/Gruden.JPG");
	  	 JLabel l_gruden2016 = new JLabel(i_gruden2016);

	     ImageIcon i_sichen2017 = new ImageIcon("res/Kalendar2017/Sichen.JPG");
	   	 JLabel l_sichen2017 = new JLabel(i_sichen2017);
		 ImageIcon i_lytuy2017 = new ImageIcon("res/Kalendar2017/Lytuy.JPG");
	   	 JLabel l_lytuy2017 = new JLabel(i_lytuy2017);
	   	 ImageIcon i_berezen2017 = new ImageIcon("res/Kalendar2017/Berezen.JPG");
	   	 JLabel l_berezen2017 = new JLabel(i_berezen2017);
	   	 ImageIcon i_kviten2017 = new ImageIcon("res/Kalendar2017/Kviten.JPG");
	   	 JLabel l_kviten2017 = new JLabel(i_kviten2017);
	   	 ImageIcon i_traven2017= new ImageIcon("res/Kalendar2017/Traven.JPG");
	  	 JLabel l_traven2017 = new JLabel(i_traven2017);
		 ImageIcon i_cherven2017 = new ImageIcon("res/Kalendar2017/Cherven.JPG");
	   	 JLabel l_cherven2017 = new JLabel(i_cherven2017);
		 ImageIcon i_lupen2017 = new ImageIcon("res/Kalendar2017/Lupen.JPG");
	   	 JLabel l_lupen2017 = new JLabel(i_lupen2017);
	   	 ImageIcon i_serpen2017 = new ImageIcon("res/Kalendar2017/Serpen.JPG");
	  	 JLabel l_serpen2017 = new JLabel(i_serpen2017);
	  	 ImageIcon i_veresen2017 = new ImageIcon("res/Kalendar2017/Veresen.JPG");
	  	 JLabel l_veresen2017 = new JLabel(i_veresen2017);
		 ImageIcon i_jovten2017 = new ImageIcon("res/Kalendar2017/Jovten.JPG");
	  	 JLabel l_jovten2017 = new JLabel(i_jovten2017);
		 ImageIcon i_lustopad2017 = new ImageIcon("res/Kalendar2017/Lustopad.JPG");
	  	 JLabel l_lustopad2017 = new JLabel(i_lustopad2017);
		 ImageIcon i_gruden2017 = new ImageIcon("res/Kalendar2017/Gruden.JPG");
	  	 JLabel l_gruden2017 = new JLabel(i_gruden2017);
	  	 
	  	int k = month;
	  	int k1 = 0;
   public Kalendar(String s){
	    super (s);
	    	
	    kalendar.setVisible(true);
		kalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		kalendar.setSize(500, 400);
		kalendar.setResizable(false);
		kalendar.setLocationRelativeTo(null);
	    
	    Vpered = new JButton("Вперед");
	    Nazad = new JButton("Назад");
	    Sogodni = new JButton("Сьогодні");
	    Menu = new JButton("Меню");
	    
	    Nazad.setBounds(20,280,130,60);
	    Sogodni.setBounds(175,280,130,60);
	    Vpered.setBounds(335,280,130,60);
	    
	    Menu.setBounds(365,30,100,20);
	    
	    Pusto = new JLabel("");
        Pusto.setBounds(10,10,10,10);
           	    	
        kalendar.add(l_sichen2015);
        kalendar.add(l_lytuy2015);
        kalendar.add(l_berezen2015);
        kalendar.add(l_kviten2015);
        kalendar.add(l_traven2015);
        kalendar.add(l_cherven2015);
        kalendar.add(l_lupen2015);
        kalendar.add(l_serpen2015);
        kalendar.add(l_veresen2015);
        kalendar.add(l_jovten2015);
        kalendar.add(l_lustopad2015);
        kalendar.add(l_gruden2015);		 	 
	 	
        kalendar.add(l_sichen2016);
        kalendar.add(l_lytuy2016);
        kalendar.add(l_berezen2016);
        kalendar.add(l_kviten2016);
        kalendar.add(l_traven2016);
        kalendar.add(l_cherven2016);
        kalendar.add(l_lupen2016);
        kalendar.add(l_serpen2016);
        kalendar.add(l_veresen2016);
        kalendar.add(l_jovten2016);
        kalendar.add(l_lustopad2016);
        kalendar.add(l_gruden2016);		 
        
        kalendar.add(l_sichen2017);
        kalendar.add(l_lytuy2017);
        kalendar.add(l_berezen2017);
        kalendar.add(l_kviten2017);
        kalendar.add(l_traven2017);
        kalendar.add(l_cherven2017);
        kalendar.add(l_lupen2017);
        kalendar.add(l_serpen2017);
        kalendar.add(l_veresen2017);
        kalendar.add(l_jovten2017);
        kalendar.add(l_lustopad2017);
        kalendar.add(l_gruden2017);		 
        
        kalendar.add(Menu);
        kalendar.add(Vpered);
        kalendar.add(Nazad);
        kalendar.add(Sogodni);
        kalendar.add(Pusto);
        
        vvedenny2016 (month);
        
        Menu.addActionListener(handler);
        Vpered.addActionListener(handler);
        Nazad.addActionListener(handler);
        Sogodni.addActionListener(handler);
}
   
   void ochistka (){
		l_sichen2015.setBounds(0,0,0,0);					
		l_lytuy2015.setBounds(0,0,0,0);					
		l_berezen2015.setBounds(0,0,0,0);					
		l_kviten2015.setBounds(0,0,0,0);					
		l_traven2015.setBounds(0,0,0,0);					
		l_cherven2015.setBounds(0,0,0,0);					
		l_lupen2015.setBounds(0,0,0,0);				
		l_serpen2015.setBounds(0,0,0,0);					
		l_veresen2015.setBounds(0,0,0,0);					
		l_jovten2015.setBounds(0,0,0,0);
		l_lustopad2015.setBounds(0,0,0,0);					
		l_gruden2015.setBounds(0,0,0,0);
		
		l_sichen2016.setBounds(0,0,0,0);					
		l_lytuy2016.setBounds(0,0,0,0);					
		l_berezen2016.setBounds(0,0,0,0);					
		l_kviten2016.setBounds(0,0,0,0);					
		l_traven2016.setBounds(0,0,0,0);					
		l_cherven2016.setBounds(0,0,0,0);					
		l_lupen2016.setBounds(0,0,0,0);				
		l_serpen2016.setBounds(0,0,0,0);					
		l_veresen2016.setBounds(0,0,0,0);					
		l_jovten2016.setBounds(0,0,0,0);
		l_lustopad2016.setBounds(0,0,0,0);					
		l_gruden2016.setBounds(0,0,0,0);
		
		l_sichen2017.setBounds(0,0,0,0);					
		l_lytuy2017.setBounds(0,0,0,0);					
		l_berezen2017.setBounds(0,0,0,0);					
		l_kviten2017.setBounds(0,0,0,0);					
		l_traven2017.setBounds(0,0,0,0);					
		l_cherven2017.setBounds(0,0,0,0);					
		l_lupen2017.setBounds(0,0,0,0);				
		l_serpen2017.setBounds(0,0,0,0);					
		l_veresen2017.setBounds(0,0,0,0);					
		l_jovten2017.setBounds(0,0,0,0);
		l_lustopad2017.setBounds(0,0,0,0);					
		l_gruden2017.setBounds(0,0,0,0);
   }
   void vvedenny2015 (int d){
		switch (d) {
		case 1:
			l_sichen2015.setBounds(120, 50, 250, 200);
			break;

		case 2:
			l_lytuy2015.setBounds(120, 50, 250, 200);
			break;

		case 3:
			l_berezen2015.setBounds(120, 30, 250, 230);
			break;

		case 4:
			l_kviten2015.setBounds(120, 50, 250, 200);
			break;

		case 5:
			l_traven2015.setBounds(120, 50, 250, 200);
			break;

		case 6:
			l_cherven2015.setBounds(120, 50, 250, 200);
			break;

		case 7:
			l_lupen2015.setBounds(120, 50, 250, 200);
			break;

		case 8:
			l_serpen2015.setBounds(120, 30, 250, 230);
			break;

		case 9:
			l_veresen2015.setBounds(120, 50, 250, 200);
			break;

		case 10:
			l_jovten2015.setBounds(120, 50, 250, 200);
			break;

		case 11:
			l_lustopad2015.setBounds(120, 30, 250, 230);
			break;

		case 12:
			l_gruden2015.setBounds(120, 50, 250, 200);
			break;
		}
   }
   
   void vvedenny2016 (int d){
		switch (d) {
		case 1:
			l_sichen2016.setBounds(120, 50, 250, 200);
			break;

		case 2:
			l_lytuy2016.setBounds(120, 50, 250, 200);
			break;

		case 3:
			l_berezen2016.setBounds(120, 30, 250, 230);
			break;

		case 4:
			l_kviten2016.setBounds(120, 50, 250, 200);
			break;

		case 5:
			l_traven2016.setBounds(120, 50, 250, 200);
			break;

		case 6:
			l_cherven2016.setBounds(120, 50, 250, 200);
			break;

		case 7:
			l_lupen2016.setBounds(120, 50, 250, 200);
			break;

		case 8:
			l_serpen2016.setBounds(120, 30, 250, 230);
			break;

		case 9:
			l_veresen2016.setBounds(120, 50, 250, 200);
			break;

		case 10:
			l_jovten2016.setBounds(120, 50, 250, 200);
			break;

		case 11:
			l_lustopad2016.setBounds(120, 30, 250, 230);
			break;

		case 12:
			l_gruden2016.setBounds(120, 50, 250, 200);
			break;
		}
  }
   
   void vvedenny2017 (int d){
		switch (d) {
		case 1:
			l_sichen2017.setBounds(120, 50, 260, 210);
			break;

		case 2:
			l_lytuy2017.setBounds(120, 50, 260, 210);
			break;

		case 3:
			l_berezen2017.setBounds(120, 30, 260, 230);
			break;

		case 4:
			l_kviten2017.setBounds(120, 50, 260, 210);
			break;

		case 5:
			l_traven2017.setBounds(120, 50, 260, 210);
			break;

		case 6:
			l_cherven2017.setBounds(120, 50, 260, 210);
			break;

		case 7:
			l_lupen2017.setBounds(120, 50, 260, 210);
			break;

		case 8:
			l_serpen2017.setBounds(120, 30, 260, 230);
			break;

		case 9:
			l_veresen2017.setBounds(120, 50, 260, 210);
			break;

		case 10:
			l_jovten2017.setBounds(120, 50, 260, 210);
			break;

		case 11:
			l_lustopad2017.setBounds(120, 30, 260, 230);
			break;

		case 12:
			l_gruden2017.setBounds(120, 50, 260, 210);
			break;
		}
 }
     
	public class eHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == Vpered) {
					ochistka();
				        k++;
				        
				        if(k>=13){
				        	k=k-12;
				        	     vvedenny2017 (k);	
				        	k=k+12;
				        	 }else{
				        		 vvedenny2016 (k);	
				        	 }
				        
				        if(k<=0){
			        		 k=k+12;
			        		 vvedenny2015 (k);	
			        		 k=k-12;
			        		 }
				        
				}

				if (e.getSource() == Nazad) {					
					ochistka();					
				        k--;
				     
				        	 if(k<=0){
				        	k=k+12;
				        	     vvedenny2015 (k);	
				        	k=k-12;
				        	 }else{
				        		 vvedenny2016 (k);	
				        	 }
				        	
				         
				        	 
				        	 
				        	 if(k>12){
				        		 k=k-12;
				        		 vvedenny2017 (k);	
				        		 k=k+12;
				        		 }
				         
				   				
				}

				if (e.getSource() == Sogodni) {	
				 
					k=month;
					  ochistka();
				   vvedenny2016 (month);					
				}

				if (e.getSource() == Menu) {
	            	new Menu("");
	            	kalendar.setVisible(false);
					}
			} catch (Exception ex) { }
		}
	}
}
