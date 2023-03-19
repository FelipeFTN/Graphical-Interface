package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;

	public Window() {
		add(new Board());
		setTitle("DarkLegend");
		ImageIcon logo = new ImageIcon(getClass().getResource("/Logo.png"));
		setIconImage(logo.getImage());
		setSize(335, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)	{		
		Window w = new Window();
		w.setVisible(true);
	}
}
