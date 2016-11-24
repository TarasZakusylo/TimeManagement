import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JOptionPane;


public class Audio_No implements Runnable {

	 int type1 = JOptionPane.ERROR_MESSAGE;  //  Р•РњР‘Р›Р•РњРђ Р’Р†РљРќРђ

	 public void run(){		 
				
	
	  try {
		   AudioInputStream stream  = AudioSystem.getAudioInputStream(new File("res/sound/No.wav"));      
		   DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());      
		   Clip clip = (Clip) AudioSystem.getLine(info);         
		    clip.open(stream);      
		    clip.start();
		   
	      }  catch (Exception e) {
	    	  
	    	  JOptionPane.showMessageDialog(null,"Система завантажена не повністю, зверніться до адміністратора.","Error",type1);
	      }
	       
	 }
}
