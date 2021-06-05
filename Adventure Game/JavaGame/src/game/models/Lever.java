package game.models;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Lever {
	private Image image;
	private ImageIcon leverOff, leverOn;
	private int x, y, w, h;
	public static boolean leverActive = false;

	public Lever(){
		leverImage();
		useLever();
		x = 327;
		y = 92;
	}

	private void leverImage() {
		leverOff = new ImageIcon("res//lever0.png");
		leverOn = new ImageIcon("res//lever1.png");	
		
		image = leverOff.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	public void useLever() {
		if(leverActive) {
			image = leverOn.getImage();
		}else {
			image = leverOff.getImage();
		}
	}
	
	public Image getImage() {
		return image;
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
