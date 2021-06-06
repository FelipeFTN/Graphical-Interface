package game.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ColliderBox extends JPanel{ // Arquivo das Hitbox
	private int x, y, w, h;
	
	public ColliderBox(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
}
