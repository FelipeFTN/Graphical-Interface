package game.models;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Lever {
	private Image image, doorImage;
	private ImageIcon leverOff, leverOn, bossDoorOpened, bossDoorClosed;
	private int x, y, w, h;
	private int dx, dox, doy, dy, dw, dh;
	public static boolean leverActive = false;
	private Boss boss;

	public Lever(){
		leverImage();
		useLever();
		bossDoorImage();
		boss = new Boss();
		x = 327;
		y = 92;
		dx = 540;
		dy = 383;
		dox = 465;
		doy = 376;
		
	}

	private void leverImage() {
		leverOff = new ImageIcon("res//lever0.png");
		leverOn = new ImageIcon("res//lever1.png");	
		
		image = leverOff.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	private void bossDoorImage() {
		bossDoorOpened = new ImageIcon("res//BossDoorOpened.png");
		bossDoorClosed = new ImageIcon("res//BossDoorClosed.png");
		
		doorImage = bossDoorClosed.getImage();
		dw = doorImage.getWidth(null);
		dh = doorImage.getHeight(null);
	}
	public void useLever() {
		if(leverActive) {
			image = leverOn.getImage();
			doorImage = bossDoorOpened.getImage();
			dx = dox;
			dy = doy;
			boss.bossActive = true;
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
	public int getDx() {
		return dx;
	}
	public int getDy() {
		return dy;
	}
	public Image getDoorImage() {
		return doorImage;
	}
	public Rectangle getBoundsDoor() {
		return new Rectangle(dx, dy, dw, dh);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, w, h);
	}
}
