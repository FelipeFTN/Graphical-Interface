package game;

import javax.swing.JFrame;

public class Window extends JFrame{

	public Window() {
		
		add(new Board());
		setTitle("GameZone");
		//setSize(1280, 720);
		setSize(335, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
	}
	
	public static void main(String[] args)	{		
		Window w = new Window();
		w.setVisible(true);	
	}
}
