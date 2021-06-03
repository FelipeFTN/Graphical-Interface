package game.models;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Boss extends JPanel{
	private Image image;
	private int x, y, w, h;
	public static int chooseDirection;
	private int followDirection;
	Random random = new Random();
	
	public Boss() {
		bossImage();
		bossMove();
		x = 200;
		y = 200;
	}
	private void bossImage() {
		// TODO Auto-generated method stub
		ImageIcon ii = new ImageIcon("res//BossResized.png");
		image = ii.getImage();
		w = image.getWidth(null);
		h = image.getHeight(null);
	}
	public void bossMove() {
		chooseDirection = random.nextInt(3);
		System.out.println(chooseDirection);
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
	public Rectangle getBounds(int x, int y) {
		this.x = x;
		this.y = y;
		return new Rectangle(x, y, w, h);
	}

}
