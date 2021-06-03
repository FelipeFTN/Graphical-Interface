package game;

import java.awt.Color;

import javax.swing.JFrame;

public class Window extends JFrame{

	public Window() {
		
		add(new Board());
		setTitle("GameZone");
		setSize(350, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args)	{		
		Window w = new Window();
		w.setVisible(true);	
	}
}
