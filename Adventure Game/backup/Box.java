package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Box extends Rectangle{

	Color color;
	public static String LM;
	
	Box(int x, int y, int width, int height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.y += -10;
			LM = "UP";
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.y += 10;
			LM = "DOWN";
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.x += -10;
			LM = "LEFT";
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.x += 10;
			LM = "RIGHT";
		}
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
	}

}
