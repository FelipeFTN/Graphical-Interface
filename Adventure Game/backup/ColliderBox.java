package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ColliderBox extends JPanel{
	private Image blockImg;
	private int x, y, w, h;
	
	public ColliderBox() {
		loadImage();
		x = 50;
		y = 50;
	}
		
	public void loadImage() {
		ImageIcon ii = new ImageIcon("res//Block.png");
		blockImg = ii.getImage();
		w = blockImg.getWidth(null);
		h = blockImg.getHeight(null);
		
	}
	public void paint(Graphics g) {
		
	}
	public Image getImage() {
		return blockImg;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, w, h);
	}
}
