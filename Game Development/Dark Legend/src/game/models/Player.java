package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// Player handler
public class Player extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image image;
	static int x;
	static int y;
	private int dx;
	private int dy;
	private int w;
	private int h;
	private int initX = 125;
	private int initY = 50;

	public static String lastMove;
	public Player() {
		playerImage();
		resetState();
	}

  // Creates player image
	public void playerImage() {
		ImageIcon ii = new ImageIcon(Player.class.getResource("/PlayerResized.png"));
		image = ii.getImage();
		w = 50;
		h = 72;
	}

  // Player movements
	public void boxMove() {
		x += dx;
		y += dy;
	}
	
	// Controlls
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == java.awt.event.KeyEvent.VK_UP) {
			lastMove = "UP";
			dy = -2;
		} else if(key == java.awt.event.KeyEvent.VK_DOWN) {
			lastMove = "DOWN";
			dy = 2;
		} else if(key == java.awt.event.KeyEvent.VK_LEFT) {
			lastMove = "LEFT";
			dx = -2;				
		} else if(key == java.awt.event.KeyEvent.VK_RIGHT) {
			lastMove = "RIGHT";
			dx = 2;			
		}
	}

  // Stops player if key is up
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == java.awt.event.KeyEvent.VK_UP) {
			dy = 0;
		} else if(key == java.awt.event.KeyEvent.VK_DOWN) {
			dy = 0;
		} else if(key == java.awt.event.KeyEvent.VK_LEFT) {
			dx = 0;
		} else if(key == java.awt.event.KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
  // Player starts at a initial position
	private void resetState() {
		x = initX;
		y = initY;
	}
	
	// Get Methods
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

  // Get collision box
	public Rectangle getBounds(int x, int y) {
		Player.x = x;
		Player.y = y;
		return new Rectangle(x, y, w, h);
	}
}
