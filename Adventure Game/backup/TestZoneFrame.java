package game;

import java.awt.Color;

import javax.swing.JFrame;

public class TestZoneFrame extends JFrame{

	public TestZoneFrame() {
		
		add(new Board());
		setSize(350, 350);
		setTitle("Test Zone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBackground(Color.BLACK);
	}
	
	public static void main(String[] args) {
		TestZoneFrame frame = new TestZoneFrame();
		frame.setVisible(true);
	}
}
