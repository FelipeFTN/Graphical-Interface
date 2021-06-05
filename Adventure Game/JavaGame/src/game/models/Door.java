package game.models;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Door {
	private int x, y, x1, y1, w, h;
	private Image image;
	
	public Door() {
		loadImage();
		x = 685;
		y = 107;
		x1 = 774;
		y1 = 107;
	}
	private void loadImage() {
		// TODO Auto-generated method stub
		ImageIcon closedDoor = new ImageIcon("res//ClosedDoor.png");
		ImageIcon openedDoor = new ImageIcon("res//OpenedDoor.png");
		
		image = closedDoor.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
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
	public int getX1() {
		return x;
	}
	public int getY1() {
		return y;
	}
	public int getWidth() {
		return w;
	}
	public int getHeight() {
		return h;
	}
	

}
