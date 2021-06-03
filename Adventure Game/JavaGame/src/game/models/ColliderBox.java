package game.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ColliderBox extends JPanel{
	private int x, y, w, h;
	
	public ColliderBox() {
		x = 50;
		y = 50;
		w = 50;
		h = 50;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle getBounds(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		return new Rectangle(x, y, w, h);
	}
}
