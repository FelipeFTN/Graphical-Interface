package game.models;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Door {
	private int x, y, x1, y1, w, h;
	private Image image;
	private ImageIcon openedDoor, closedDoor;
	private Chests chest;
	public Door() {
		loadImage();
		x = 685;
		y = 107;
		x1 = 760;
		y1 = 107;
		chest = new Chests();
	}
	private void loadImage() {
		// TODO Auto-generated method stub
		closedDoor = new ImageIcon("res//ClosedDoor.png");
		openedDoor = new ImageIcon("res//OpenedDoor.png");
		
		image = closedDoor.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	public void useDoor(boolean openChest) {
		if(openChest) {
			x = x1;
			y = y1;
			image = openedDoor.getImage();
			chest.openChest = false;
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
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
	

}
