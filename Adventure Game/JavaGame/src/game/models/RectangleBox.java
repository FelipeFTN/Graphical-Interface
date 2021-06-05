package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import game.Board;

public class RectangleBox extends JPanel{
	private Image image;
	private int x, y, dx, dy, w, h;
	private int initX = 125;
	private int initY = 50;
	public static String lastMove;
	
	public RectangleBox() {
		playerImage();
		resetState();
	}
	public void playerImage() {
		ImageIcon ii = new ImageIcon("res//PlayerResized.png");
		image = ii.getImage();
		w = 50;
		h = 72;
	}
	public void boxMove() {
		x += dx;
		y += dy;
	}
	
	//Controles
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP) {
			dy = -2;
			lastMove = "UP";
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 2;
			lastMove = "DOWN";
		}
		if(key == KeyEvent.VK_LEFT) {
			dx = -2;
			lastMove = "LEFT";
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 2;
			lastMove = "RIGHT";
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
	private void resetState() {
		x = initX;
		y = initY;
	}
	
	//Metodos get
	
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
	public Rectangle getBounds(int x, int y) {
		this.x = x;
		this.y = y;
		return new Rectangle(x, y, w, h);
	}
}
