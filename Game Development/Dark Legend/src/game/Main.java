package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main extends JFrame {
	public Main() {
		add(new Board());
		setTitle("Adventure Game");
		ImageIcon logo = new ImageIcon(Main.class.getResource("/Logo.png"));
		setIconImage(logo.getImage());
		setSize(335, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)	{		
		Main m = new Main();
		m.setVisible(true);
	}
}
