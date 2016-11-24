import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class OtochennaWindow extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTextArea txtrEnter;
	private JButton b_izMereji;
	private JButton b_izPamyati;
	private JPanel panel_vidkkrutu;
	private Label label;
	private JButton b_vuvestu;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JLabel imageLabel;
	private JTextArea t__harakteristici;
	private JScrollPane scrollPane_1;
	private JButton b_ochustutu;

	String s_zberegtu = "";
	String s_inkognito = "res/inkognito.png";
	String s_nazva = "otochenna/";
	String s__harakteristici = "";
	String s_nayavnistPodii = "";
	
	Formatter formatter_harakteristici;
	 
	int k_nayavnistPodii = 0;
	private JTextField t_Nazva;

     Formatter formatter_k_otocenna ;
	 int k_otocenna;
	 String s_k_otocenna  ;
	 static Scanner scanner_k_otocenna ;
	 private JPanel panel_foto;
	 private JPanel panel_harakteristiki;
	 private JScrollPane scrollPane_2;
	 private JScrollPane scrollPane_3;
	 private JLabel l_harakteristiki;
	 
	 private OtocennaVidkrutu  model;
	 private JList<String> list;
	
		File folder = new File(s_nazva);
		File[] listOfFiles = folder.listFiles();
		StringBuffer sb = new StringBuffer();
		private JButton b_vuvestuProfil;
	 		
	 String s_k_vuvestuProfil = "";
 
	 private static BufferedImage image_vuvestuProfil;
	 
	
	 private JLabel l_vuvestuProfilPhoto;
	 
	public OtochennaWindow() {
		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setResizable(false);
		setLocationRelativeTo(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 22, 494, 350);
		getContentPane().add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Створити профіль", null, panel, null);
		panel.setLayout(null);

		txtrEnter = new JTextArea();
		txtrEnter.setBounds(20, 42, 327, 23);
		txtrEnter.setText("\u0412\u0432\u0435\u0434\u0456\u0442\u044C URL...");
		panel.add(txtrEnter);

		b_izMereji = new JButton(
				"\u0417\u0430\u0432\u0430\u043D\u0442\u0430\u0436\u0438\u0442\u0438 \u0444\u043E\u0442\u043E \u0456\u0437 \u043C\u0435\u0440\u0435\u0436\u0456");
		b_izMereji.setBounds(10, 11, 221, 23);
		b_izMereji.addActionListener(e -> {
			try {
				Otochenna.setImage(new URL(txtrEnter.getText()));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Некоректне введення, або відсутнє з'єднання із Інтеренетом");
			}
		});
		panel.add(b_izMereji);

		b_izPamyati = new JButton(
				"\u0417\u0430\u0432\u0430\u043D\u0442\u0430\u0436\u0438\u0442\u0438 \u0444\u043E\u0442\u043E \u0456\u0437 \u043F\u0430\u043C'\u044F\u0442\u0456");
		b_izPamyati.setBounds(258, 11, 221, 23);
		b_izPamyati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int reply = chooser.showOpenDialog(null);
				if (reply == JFileChooser.APPROVE_OPTION) {
					Otochenna.setImage(chooser.getSelectedFile());
				}
			}
		});
		panel.add(b_izPamyati);

		label = new Label("Вкажіть назву, або ім'я");
		label.setBounds(266, 293, 132, 22);
		panel.add(label);

		b_vuvestu = new JButton("\u0412\u0438\u0432\u0435\u0441\u0442\u0438 \u0444\u043E\u0442\u043E");
		b_vuvestu.setBounds(359, 42, 120, 23);
		panel.add(b_vuvestu);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 76, 245, 235);
		panel.add(scrollPane);

		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		imageLabel = new JLabel("");
		panel_2.add(imageLabel);

		JButton b_zberegtu = new JButton("\u0417\u0431\u0435\u0440\u0435\u0433\u0442\u0438");
		b_zberegtu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		 

				if (Otochenna.getImage() == null) {
					File file = new File(s_inkognito);
					Otochenna.setImage(file);
					imageLabel.setIcon(new ImageIcon(Otochenna.getImage()));
					imageLabel.updateUI();
					switch (t_Nazva.getText()) {
					case "":
					case " ":
					case "  ":
						JOptionPane.showMessageDialog(null, "Не введено назву, або ім'я");
						break;
					default:
						zberegtu();
						break;
					}

				} else {
					switch (t_Nazva.getText()) {
					case "":
					case " ":
					case "  ":
						JOptionPane.showMessageDialog(null, "Не введено назву, або ім'я");
						break;
					default:
						zberegtu();
						break;
					}
				}
			}
		});
		b_zberegtu.setBounds(284, 265, 183, 23);
		panel.add(b_zberegtu);

		JLabel label_1 = new JLabel(
				"\u041A\u043E\u0440\u043E\u0442\u043A\u0456 \u0445\u0430\u0440\u0430\u043A\u0442\u0435\u0440\u0438\u0441\u0442\u0438\u043A\u0438");
		label_1.setBounds(308, 102, 152, 14);
		panel.add(label_1);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(284, 121, 183, 137);
		panel.add(scrollPane_1);

		t__harakteristici = new JTextArea();
		scrollPane_1.setViewportView(t__harakteristici);

		b_ochustutu = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u0438");
		b_ochustutu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ochstutu();
			}
		});
		b_ochustutu.setBounds(308, 76, 138, 23);
		panel.add(b_ochustutu);

		t_Nazva = new JTextField();
		t_Nazva.setBounds(400, 293, 87, 20);
		panel.add(t_Nazva);
		t_Nazva.setColumns(10);
		b_vuvestu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Otochenna.getImage() == null) {
					return;
				}
				imageLabel.setIcon(new ImageIcon(Otochenna.getImage()));
				imageLabel.updateUI();
			}
		});

		panel_vidkkrutu = new JPanel();
		tabbedPane.addTab("Відкрити профіль", null, panel_vidkkrutu, null);
		panel_vidkkrutu.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(236, 11, 243, 164);
		panel_vidkkrutu.add(scrollPane_2);
		
		panel_foto = new JPanel();
		scrollPane_2.setViewportView(panel_foto);
		panel_foto.setLayout(new BorderLayout(0, 0));
		
		l_vuvestuProfilPhoto = new JLabel("");
		panel_foto.add(l_vuvestuProfilPhoto, BorderLayout.NORTH);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(236, 211, 243, 100);
		panel_vidkkrutu.add(scrollPane_3);
		
		panel_harakteristiki = new JPanel();
		scrollPane_3.setViewportView(panel_harakteristiki);
		panel_harakteristiki.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_vuvestuProfil = new JTextArea();
		panel_harakteristiki.add(textArea_vuvestuProfil, BorderLayout.CENTER);
		
		l_harakteristiki = new JLabel("\u041A\u043E\u0440\u043E\u0442\u043A\u0456 \u0445\u0430\u0440\u0430\u043A\u0442\u0435\u0440\u0438\u0441\u0442\u0438\u043A\u0438 :");
		l_harakteristiki.setBounds(253, 186, 157, 14);
		panel_vidkkrutu.add(l_harakteristiki);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 211, 210);
		panel_vidkkrutu.add(scrollPane_4);
		
		
		model = new  OtocennaVidkrutu ();
		list = new JList<String>(model);
		scrollPane_4.setViewportView(list);	
		
		JButton b__udalutu = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u0438 \u043F\u0440\u043E\u0444\u0456\u043B\u044C");
		b__udalutu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				File folder1 = new File(s_nazva+list.getSelectedValue());
				removeElement(list.getSelectedValue());
				delete(folder1);
				list.updateUI();
			}
		});
		b__udalutu.setBounds(10, 262, 211, 23);
		panel_vidkkrutu.add(b__udalutu);
		
		b_vuvestuProfil = new JButton("\u0412\u0438\u0432\u0435\u0441\u0442\u0438 \u043F\u0440\u043E\u0444\u0456\u043B\u044C");
		b_vuvestuProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BufferedReader reader;
				try {
					reader = new BufferedReader(
							new FileReader(s_nazva + list.getSelectedValue() + "/" + "harakteristici.txt"));

					String line;
					List<String> lines = new ArrayList<String>();

					while ((line = reader.readLine()) != null) {
						lines.add(line);
					}
					String[] linesAsArray = lines.toArray(new String[lines.size()]);

					for (int i = 0; i < linesAsArray.length; i++) {
						s_k_vuvestuProfil = s_k_vuvestuProfil + linesAsArray[i] + "\n";
					}

				} catch (Exception e1) {}

				
				 File file_vuvestuProfil = new File(s_nazva + list.getSelectedValue() + "/" + "photo.png") ;
				
				try {
					image_vuvestuProfil = ImageIO.read(file_vuvestuProfil);
				} catch (Exception e1) {}
				
				
				try {
				l_vuvestuProfilPhoto.setIcon(new ImageIcon(image_vuvestuProfil));
				l_vuvestuProfilPhoto.updateUI();
				} catch (Exception e1) {JOptionPane.showMessageDialog(null, "Виберіть профіль");}
				
				textArea_vuvestuProfil.setText(s_k_vuvestuProfil);
				s_k_vuvestuProfil = "";
				image_vuvestuProfil = null ;
			}
		});
		b_vuvestuProfil.setBounds(10, 232, 211, 23);
		panel_vidkkrutu.add(b_vuvestuProfil);
	
	
		for (int i = 0; i < listOfFiles.length; i++) {
			addElement(listOfFiles[i].getName());
		}	
		
		JButton b_menu = new JButton("\u041C\u0435\u043D\u044E");
		b_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Menu("");
				setVisible(false);
			}
		});
		b_menu.setBounds(405, 0, 89, 23);
		getContentPane().add(b_menu);

		setVisible(true);
		
	}

	void ochstutu() {
		imageLabel.setIcon(new ImageIcon(""));
		txtrEnter.setText(null);
		t__harakteristici.setText(null);
		t_Nazva.setText(null);

		panel_2.add(imageLabel);
		panel.add(scrollPane_1);
		panel.add(txtrEnter);
		panel.add(t_Nazva);
	}
	
	void zberegtu(){
		
		for (int i = 0; i < listOfFiles.length; i++) {
			 	if (listOfFiles[i].getName().equals(t_Nazva.getText())) {
				k_nayavnistPodii= k_nayavnistPodii+1;
				}
			sb.append(listOfFiles[i].getName() + " ");
		}				 
		if (k_nayavnistPodii == 0) {
			File Path = new File(s_nazva + t_Nazva.getText());
			Path.mkdirs();
			Otochenna.saveImage(s_nazva + t_Nazva.getText() + "/photo.png");
			s__harakteristici = t__harakteristici.getText();
			try {
				formatter_harakteristici = new Formatter(
						s_nazva + t_Nazva.getText() + "/harakteristici.txt");
				formatter_harakteristici.format(s__harakteristici);
				formatter_harakteristici.close();
			} catch (Exception e) {
			}
			JOptionPane.showMessageDialog(null, "Збережено");
			
			try {
				scanner_k_otocenna = new Scanner(new File("dani/кількість оточення.txt"));
			} catch (Exception ez) {
				JOptionPane.showMessageDialog(null, "Помилка відкриття файлу кількість оточення");
			}
			
			while (scanner_k_otocenna.hasNext()) {
				s_k_otocenna = scanner_k_otocenna.next();				
			}
			scanner_k_otocenna.close();
				
				k_otocenna = Integer.parseInt(s_k_otocenna);
				k_otocenna++;
				s_k_otocenna = ""+ k_otocenna;
				
				try {
					formatter_k_otocenna = new Formatter("dani/кількість оточення.txt");
				} catch (Exception e) {JOptionPane.showMessageDialog(null, "System Error");}            
				formatter_k_otocenna.format(s_k_otocenna);
				formatter_k_otocenna.close();
			
//			ochstutu();
				
				setVisible(false);
			    new Otochenna();
			    
		}else{
			JOptionPane.showMessageDialog(null, "Уже існує така назва, ім'я");
		}
		k_nayavnistPodii = 0;
	}

	void addElement(String s){
		model.addElements(s);
	}
	
	void removeElement(int index){
		model.remuveElements(index);
	}
	
	void removeElement(String obj){
		model.remuveElements(obj);
	}

    void delete(File file)
	  {
		
	    if(!file.exists())
	      return;
	    if(file.isDirectory())
	    {
	      for(File f : file.listFiles())
	    	  delete(f);
	      file.delete();
	    }
	    else
	    {
	      file.delete();
	    }
	  }
}


