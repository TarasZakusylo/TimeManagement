import java.io.FileInputStream;
import java.util.Random;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;


public class Audio  implements Runnable {

	 Player p = null;
	 Random rand = new Random () ;
	 int type1 = JOptionPane.ERROR_MESSAGE;  //  Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ

	 public void run(){		 
		 
		 for(int i=0; i<5;i++){
		 
		try {			
			int ra ;
		//	ra =3;
			ra=rand.nextInt(4);
				switch(ra){
					 case 0:
						   p = new  Player( new FileInputStream("res/z1.mp3"));
						 break;
					 case 1:
						   p = new  Player( new FileInputStream("res/z2.mp3"));
						 break;
					 case 2:
						   p = new  Player( new FileInputStream("res/z3.mp3"));
						 break;	
					 case 3:
						   p = new  Player( new FileInputStream("res/z.mp3"));
						 
						 break;	
						// default;
			 }
			try{
			 Thread.sleep(10);
		 }catch(Exception e){ }
		 
			p.play();
		}	  catch(Exception e)
  	  {JOptionPane.showMessageDialog(null,"Система завантажена не повністю, зверніться до адміністратора.","Error",type1);}
	 }
		 
		 
	 }
}
